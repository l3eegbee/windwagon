package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredPageWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Page;

public class ArmoredPageWrapperImpl extends ArmoredActorWrapperImpl<Page, PageWrapper> implements ArmoredPageWrapper {

    public ArmoredPageWrapperImpl( Camp camp, PageWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    @Override
    protected void actorInitialize() throws ForgeException {
        instance.initialize();
    }

}
