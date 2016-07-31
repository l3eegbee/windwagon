package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.SquireData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.SquireWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredSquireWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Squire;

public class SquireWrapperImpl extends ActorWrapperImpl<Squire, ArmoredSquireWrapper, SquireData> implements SquireWrapper {

    private Cycle cycle;

    public SquireWrapperImpl( Herald herald, Cycle cycle, SquireData actorData ) {

        super( herald, actorData );

        this.cycle = cycle;

    }

    @Override
    public Cycle getCycle() {
        return cycle;
    }

    @Override
    public ArmoredSquireWrapper instanciate( Camp camp ) throws ForgeException {
        return camp.getSquire( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitSquire( this );
    }

}
