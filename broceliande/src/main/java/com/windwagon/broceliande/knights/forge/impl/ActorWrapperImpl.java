package com.windwagon.broceliande.knights.forge.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.Tavern;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.armored.Armory;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperFactory;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeError;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.forge.errors.LoadJARException;
import com.windwagon.kaamelott.Actor;

public abstract class ActorWrapperImpl<A extends Actor, Armored extends ArmoredActorWrapper<A>, D extends ActorData>
        extends ComponentWrapperImpl implements ActorWrapper<Armored, D> {

    private static final Logger logger = LoggerFactory.getLogger( ActorWrapperImpl.class );

    @Value( "${jarfiles.root.path}" )
    protected String jarRootPathName;

    @Autowired
    protected FileSystem fileSystem;

    @Autowired
    protected PlatformTransactionManager transactionManager;

    @Autowired
    protected Tavern tavern;

    @Autowired
    protected Armory armory;

    @Autowired
    private ConstantWrapperFactory constantWrapperFactory;

    protected D actorData;

    protected Set<ConstantWrapper> constants = new HashSet<>();

    protected ActorWrapperImpl( Herald herald, D actorData ) {

        super( herald, actorData.getComponent().getComponentClass() );

        this.actorData = actorData;

    }

    @PostConstruct
    public void postConstruct() {

        for( Constant constant : actorData.getComponent().getConstants() )
            constants.add( constantWrapperFactory.getConstantWrapper( constant ) );

    }

    /*
     * PROTECT CALLING
     */

    private class ValuableRunnable<V> implements Runnable {

        private Function<? super Armored, V> fun;

        private V value;

        private Throwable ex;

        public ValuableRunnable( Function<? super Armored, V> fun ) {
            this.fun = fun;
        }

        @Override
        public void run() {
            try {

                this.value = new TransactionTemplate( transactionManager ).execute( ( status ) -> {
                    try {

                        Cycle cycle = getCycle();

                        Camp camp = armory.getCamp( cycle );
                        Armored armored = instanciate( camp );

                        return fun.apply( armored );

                    } catch( Throwable ex ) {
                        this.ex = ex;
                        return null;
                    }
                } );

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
    public <V> V call( Function<? super Armored, V> func ) throws ForgeException {

        ValuableRunnable<V> runnable = new ValuableRunnable<V>( func );

        URLClassLoader classLoader = constructClassLoader();

        Thread thread = new Thread( runnable );
        thread.setContextClassLoader( classLoader );

        thread.start();
        try {
            thread.join();
        } catch( InterruptedException ex ) {
            throw new ActorExecutionException( ex );
        } finally {
            try {
                classLoader.close();
            } catch( IOException ex ) {
                logger.error( "Error during closing class loader.", ex );
            }
        }

        try {
            if( runnable.getException() != null )
                throw runnable.getException();
        } catch( ForgeException ex ) {
            throw ex;
        } catch( ForgeError ex ) {
            throw ex.getCause();
        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

        return runnable.getValue();

    }

    protected Cycle getCycle() {
        return null;
    }

    /*
     * CLASS LOADER
     */

    public Set<? extends ActorWrapper<?, ?>> getActorDependances() {
        return Collections.emptySet();
    }

    private void searchComponents(
            Set<ComponentClass> componentClasses,
            Set<ActorWrapper<?, ?>> actors,
            Herald herald,
            ActorWrapper<?, ?> actor ) throws ForgeException {

        if( actors.add( actor ) ) {

            ComponentData actorComponent = actor.getActorData().getComponent();
            componentClasses.add( actorComponent.getComponentClass() );

            for( Constant constant : actorComponent.getConstants() ) {
                if( constant.getType() == ConstantType.COMPONENT ) {

                    String value = constant.getValue();
                    ComponentWrapper constantWrapper = tavern.findComponent( herald, getCycle(), value );

                    if( constantWrapper instanceof ActorWrapper )
                        searchComponents( componentClasses, actors, herald, (ActorWrapper<?, ?>) constantWrapper );
                    else
                        componentClasses.add( constantWrapper.getComponentClass() );

                }
            }

            for( ActorWrapper<?, ?> actorDep : actor.getActorDependances() )
                searchComponents( componentClasses, actors, herald, actorDep );

        }

    }

    public URLClassLoader constructClassLoader() throws ForgeException {

        // get all component classes
        Set<ComponentClass> componentClasses = new HashSet<>();
        searchComponents( componentClasses, new HashSet<>(), herald, this );

        Set<JARFile> jarFiles = new HashSet<>();
        for( ComponentClass componentClass : componentClasses )
            jarFiles.addAll( componentClass.getJarFiles() );

        Path jarRootPath = fileSystem.getPath( jarRootPathName );

        try {

            // convert paths to URLs
            Set<URL> urls = new HashSet<>();
            for( JARFile jarFile : jarFiles )
                urls.add( jarRootPath.resolve( jarFile.getPath() ).toUri().toURL() );

            logger.trace( "Class loader urls: {}", urls );

            // create the new class loader
            return new URLClassLoader( urls.toArray( new URL[] {} ) );

        } catch( MalformedURLException ex ) {
            throw new LoadJARException( "Can't create class loader", ex );
        }

    }

    /*
     * INSTANCIATION
     */

    @Override
    public Armored instanciate( Camp camp ) throws ForgeException {
        Armored armored = createArmor( camp );
        initialize( armored );
        return armored;
    }

    protected abstract Armored createArmor( Camp camp );

    @SuppressWarnings( "unchecked" )
    public void initialize( Armored armored ) throws ForgeException {

        try {

            A instance = (A) instanciateComponent();
            armored.setActor( instance );

            List<ConstantWrapper> sorted = new ArrayList<>( constants );
            Collections.sort( sorted, Comparator.comparing( ConstantWrapper::getAttribute ) );
            for( ConstantWrapper constant : sorted )
                constant.affectValue( armored );

            actorInitialize( armored );

        } catch( ForgeException ex ) {
            throw ex;
        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

    }

    protected abstract void actorInitialize( Armored armored ) throws ForgeException;

    /*
     * OTHER
     */

    @Override
    public Set<ConstantWrapper> getConstants() {
        return constants;
    }

    @Override
    public D getActorData() {
        return actorData;
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitActor( this );
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
