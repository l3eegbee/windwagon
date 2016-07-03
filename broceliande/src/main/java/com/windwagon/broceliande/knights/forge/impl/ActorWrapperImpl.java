package com.windwagon.broceliande.knights.forge.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.Casern;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Tavern;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperFactory;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.forge.errors.LoadJARException;
import com.windwagon.kaamelott.Actor;

public class ActorWrapperImpl<A extends Actor, D extends ActorData> extends ComponentWrapperImpl
        implements ActorWrapper {

    private static final Logger logger = LoggerFactory.getLogger( ActorWrapperImpl.class );

    @Value( "${jarfiles.root.path}" )
    protected String jarRootPathName;

    @Autowired
    private FileSystem fileSystem;

    @Autowired
    private ConstantWrapperFactory constantWrapperFactory;

    @Autowired
    protected Casern casern;

    @Autowired
    protected Tavern tavern;

    protected D actorData;

    protected Class<? extends A> actorClass;

    protected A actorInstance;

    protected List<ConstantWrapper> allConstants;

    protected List<ComponentConstantWrapper> componentConstants;

    protected Set<ConstantWrapper> visibleConstants;

    protected Map<String, ConstantWrapper> visibleConstantsMap;

    protected ActorWrapperImpl( D actorData ) {

        super( actorData.getComponent() );

        this.actorData = actorData;

    }

    @PostConstruct
    public void initialize() {

        allConstants = new Vector<>();
        for( Constant constant : component.getConstants() )
            allConstants.add( constantWrapperFactory.getConstantWrapper( this, constant ) );
        Collections.sort( allConstants, Comparator.comparing( ConstantWrapper::getAttribute ) );

        componentConstants = new Vector<>();
        for( ConstantWrapper constant : allConstants )
            constant.accept( new ConstantWrapperVisitor<Runnable>() {

                @Override
                public Runnable visitConstant( ConstantWrapper constant ) {
                    return () -> {};
                }

                @Override
                public Runnable visitComponent( ComponentConstantWrapper constant ) {
                    return () -> componentConstants.add( constant );
                }

            } ).run();

        SortedSet<ConstantWrapper> visible = new TreeSet<>( Comparator.comparingInt( ConstantWrapper::getOrder ) );
        allConstants.stream().filter( c -> !c.isHidden() ).map( visible::add );
        visibleConstants = Collections.unmodifiableSet( visible );

        visibleConstantsMap = visibleConstants.stream().collect( Collectors.toMap( c -> c.getName(), c -> c ) );

    }

    /*
     * PROTECT CALLING
     */

    private class ValuableRunnable<V> implements Runnable {

        private Function<V> fun;

        private V value;

        private Throwable ex;

        public ValuableRunnable( Function<V> fun ) {
            this.fun = fun;
        }

        @Override
        public void run() {
            try {
                this.value = fun.call();
            } catch( Throwable ex ) {
                this.ex = ex;
            }
        }

        public Throwable getException() {
            return ex;
        }

        public V getValue() {
            return value;
        }

    }

    @Override
    public <V> V call( Function<V> func ) throws ActorExecutionException {

        ValuableRunnable<V> runnable = new ValuableRunnable<>( func );
        Thread thread = new Thread( runnable );
        thread.setContextClassLoader( classLoader );

        thread.start();
        try {
            thread.join();
        } catch( InterruptedException ex ) {
            throw new ActorExecutionException( ex );
        }

        if( runnable.getException() != null )
            throw new ActorExecutionException( runnable.getException() );

        return runnable.getValue();

    }

    @Override
    public void call( Script script ) throws ActorExecutionException {
        call( () -> {
            script.call();
            return null;
        } );
    }

    /*
     * CONSTANTS
     */

    public Set<ConstantWrapper> getConstantProps() {
        return visibleConstants;
    }

    public ConstantWrapper getConstantProp( String name ) {
        return visibleConstantsMap.get( name );
    }

    /*
     * CLASS LOADER
     */

    @Override
    public Set<ComponentWrapper> getComponentDependances() throws ConstantException {

        Set<ComponentWrapper> components = new HashSet<>();
        components.add( this );

        for( ComponentConstantWrapper constant : componentConstants )
            components.add( constant.getComponent() );

        return components;

    }

    @Override
    public Set<? extends ActorWrapper> getActorDependances() {
        return Collections.emptySet();
    }

    protected static class ActorWrapperSet<A extends ActorWrapper> {

        private Map<ActorData, A> map = new HashMap<>();

        public boolean add( A actorWrapper ) {
            if( !map.containsKey( actorWrapper.getActorData() ) ) {
                map.put( actorWrapper.getActorData(), actorWrapper );
                return true;
            }
            return false;
        }

        public Set<A> get() {
            return new HashSet<>( map.values() );
        }

    }

    private void addAllActorDependances( ActorWrapperSet<ActorWrapper> actors, ActorWrapper actor ) {

        if( actors.add( actor ) )
            for( ActorWrapper dep : actor.getActorDependances() )
                addAllActorDependances( actors, dep );

    }

    @Override
    public Set<JARFile> getAllJarDependances() throws ConstantException {

        ActorWrapperSet<ActorWrapper> actors = new ActorWrapperSet<>();
        addAllActorDependances( actors, this );
        Set<ActorWrapper> allActors = actors.get();

        Set<JARFile> jarFiles = new HashSet<>();

        for( ActorWrapper actor : allActors )
            for( ComponentWrapper component : actor.getComponentDependances() )
                jarFiles.addAll( component.getComponent().getComponentClass().getJarFiles() );

        return jarFiles;

    }

    @Override
    public void constructClassLoader() throws ConstantException, LoadJARException {

        Set<JARFile> allJarFiles = getAllJarDependances();

        Path jarRootPath = fileSystem.getPath( jarRootPathName );

        try {

            // convert paths to URLs
            Set<URL> urls = new HashSet<>();
            for( JARFile jarFile : allJarFiles )
                urls.add( jarRootPath.resolve( jarFile.getPath() ).toUri().toURL() );

            logger.trace( "Class loader urls: {}", urls );

            // create the new class loader
            classLoader = new URLClassLoader( urls.toArray( new URL[] {} ) );

        } catch( MalformedURLException ex ) {
            throw new LoadJARException( "Can't create class loader", ex );
        }

    }

    @Override
    public void close() {

        actorInstance = null;

        if( classLoader != null )
            try {
                classLoader.close();
            } catch( IOException ex ) {
                logger.error( "Can't close actor {}", getName(), ex );
            } finally {
                classLoader = null;
            }

    }

    /*
     * INSTANCIATION
     */

    @Override
    @SuppressWarnings( "unchecked" )
    public void instanciate() throws ForgeException {

        if( classLoader == null )
            this.constructClassLoader();

        call( () -> {

            inClasspathInstanciate();

            actorInstance = (A) componentInstance;

            for( ConstantWrapper constant : allConstants )
                constant.affectValue();

            actorPreInitialize();

            actorInstance.initialize();

            actorPostInitialize();

        } );

    }

    @Override
    public void actorPreInitialize() throws Exception {}

    @Override
    public void actorPostInitialize() throws Exception {}

    /*
     * OTHERS
     */

    @Override
    public String getName() {
        return actorData.getName();
    }

    @Override
    public String getDescription() {
        return actorData.getDescription();
    }

    @Override
    public D getActorData() {
        return actorData;
    }

    @Override
    public A getActor() {
        return actorInstance;
    }

    @Override
    public Cycle getCycle() {
        return null;
    }

    /*
     * UTILITIES
     */

    protected String base64encode( byte[] bytes ) {
        return bytes == null ? null : Base64.getEncoder().encodeToString( bytes );
    }

    protected byte[] base64decode( String string ) {
        return string == null ? null : Base64.getDecoder().decode( string );
    }

}
