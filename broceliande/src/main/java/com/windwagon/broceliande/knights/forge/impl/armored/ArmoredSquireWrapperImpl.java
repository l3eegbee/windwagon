package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.SquireWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredSquireWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Squire;

public class ArmoredSquireWrapperImpl extends ArmoredActorWrapperImpl<Squire, SquireWrapper> implements ArmoredSquireWrapper {

    public ArmoredSquireWrapperImpl( Camp camp, SquireWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    @Override
    protected void actorInitialize() throws ForgeException {
        instance.initialize();
    }

}
