package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.kaamelott.Page;

public class PageWrapperImpl extends ActorWrapperImpl<Page, PageData> implements PageWrapper {

    private Cycle cycle;

    public PageWrapperImpl( Cycle cycle, PageData actorData ) {

        super( actorData );

        this.cycle = cycle;

    }

    @Override
    public Cycle getCycle() {
        return cycle;
    }

}
