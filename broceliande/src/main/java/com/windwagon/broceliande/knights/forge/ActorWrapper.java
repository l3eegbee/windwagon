package com.windwagon.broceliande.knights.forge;

import java.util.Set;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.forge.errors.LoadJARException;
import com.windwagon.kaamelott.Actor;

public interface ActorWrapper extends AutoCloseable, ComponentWrapper {

    /*
     * PROTECT CALLING
     */

    public interface Function<V> {

        public V call() throws Exception;

    }

    public <V> V call( Function<V> func ) throws ActorExecutionException;

    public interface Script {

        public void call() throws Exception;

    }

    public void call( Script script ) throws ActorExecutionException;

    /*
     * CONSTANTS
     */

    public Set<ConstantWrapper> getConstantProps();

    public ConstantWrapper getConstantProp( String name );

    /*
     * CLASS LOADER
     */

    public Set<? extends ActorWrapper> getActorDependances();

    public Set<ComponentWrapper> getComponentDependances() throws ConstantException;

    public Set<JARFile> getAllJarDependances() throws ConstantException;

    public void constructClassLoader() throws ConstantException, LoadJARException;

    /*
     * INSTANCIATE
     */

    public void instanciate() throws ForgeException;

    @InActorClassPathOperation
    public void inClasspathInstanciate() throws ForgeException;

    @InActorClassPathOperation
    public void actorPreInitialize() throws Exception;

    @InActorClassPathOperation
    public void actorPostInitialize() throws Exception;

    /*
     * OTHERS
     */

    public void close();

    public ActorData getActorData();

    public Actor getActor();

    public Cycle getCycle();

}
