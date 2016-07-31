package com.windwagon.broceliande.knights.forge.armored;

import java.util.SortedSet;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Actor;
import com.windwagon.kaamelott.ArmoredActor;

public interface ArmoredActorWrapper<A extends Actor> extends ArmoredActor<A> {

    public void initialize() throws ForgeException;

    public Herald getHerald();

    public Cycle getCycle();

    public Camp getCamp();

    public ActorWrapper<?, ?> getWrapper();

    @Override
    public SortedSet<? extends ConstantWrapper> getConstantProps();

}
