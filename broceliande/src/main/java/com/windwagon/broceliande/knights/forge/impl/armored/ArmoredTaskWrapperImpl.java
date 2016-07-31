package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.entities.Run;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredTaskWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Actor;

public abstract class ArmoredTaskWrapperImpl<A extends Actor, R extends Run, W extends TaskWrapper<?, ?, R>>
        extends ArmoredActorWrapperImpl<A, W> implements ArmoredTaskWrapper<A, R> {

    public ArmoredTaskWrapperImpl( Camp camp, W wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

}
