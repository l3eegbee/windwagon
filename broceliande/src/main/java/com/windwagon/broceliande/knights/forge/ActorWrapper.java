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

public interface ActorWrapper<A extends Actor, D extends ActorData> extends AutoCloseable, ComponentWrapper {

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
     * CLASS LOADER
     */

    public Set<? extends ActorWrapper<?, ?>> getActorDependances();

    public Set<ComponentWrapper> getComponentDependances() throws ConstantException;

    public Set<JARFile> getAllJarDependances() throws ConstantException;

    public void constructClassLoader() throws ConstantException, LoadJARException;

    /*
     * INSTANCIATE
     */

    public void instanciate() throws ForgeException;

    @InActorClassPathOperation
    public void inClasspathInstanciate() throws ForgeException;

    public void close();

    /*
     * ARMORED INTERFACE
     */

    public String getName();

    public String getDescription();

    public Set<ConstantWrapper> getConstantProps();

    public ConstantWrapper getConstantProp( String name );

    public A getActor();

    /*
     * OTHER
     */

    public D getActorData();

    public Cycle getCycle();

}
