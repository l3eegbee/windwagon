package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredPageWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Page;

public class PageWrapperImpl extends ActorWrapperImpl<Page, ArmoredPageWrapper, PageData> implements PageWrapper {

    private Cycle cycle;

    public PageWrapperImpl( Herald herald, Cycle cycle, PageData actorData ) {

        super( herald, actorData );

        this.cycle = cycle;

    }

    @Override
    public Cycle getCycle() {
        return cycle;
    }

    @Override
    public ArmoredPageWrapper instanciate( Camp camp ) throws ForgeException {
        return camp.getPage( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitPage( this );
    }

}
