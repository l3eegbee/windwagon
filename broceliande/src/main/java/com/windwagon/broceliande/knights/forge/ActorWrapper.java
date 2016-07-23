package com.windwagon.broceliande.knights.forge;

import java.util.Set;
import java.util.function.Function;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public interface ActorWrapper<Armored extends ArmoredActorWrapper<?>, D extends ActorData> extends ComponentWrapper {

    /*
     * PROTECT CALLING
     */

    public <V> V call( Function<? super Armored, V> func ) throws ForgeException;

    /*
     * CLASS LOADER
     */

    public Set<? extends ActorWrapper<?, ?>> getActorDependances();

    /*
     * INSTANCIATE
     */

    @InActorClassPathOperation
    public Armored instanciate( Camp camp ) throws ForgeException;

    /*
     * OTHER
     */

    public Set<ConstantWrapper> getConstants();

    public D getActorData();

}
