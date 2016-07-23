package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.WrappedKnight;
import com.windwagon.broceliande.knights.forge.armored.ArmoredWrappedKnight;
import com.windwagon.kaamelott.Knight;

public abstract class WrappedKnightImpl<Armored extends ArmoredWrappedKnight, D extends ActorData>
        extends ActorWrapperImpl<Knight, Armored, D> implements WrappedKnight<Armored, D> {

    public WrappedKnightImpl( Herald herald, D actorData ) {
        super( herald, actorData );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitWrappedKnight( this );
    }

}
