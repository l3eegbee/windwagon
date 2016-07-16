package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.WrappedKnight;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.words.Words;

public abstract class WrappedKnightImpl<D extends ActorData> extends ActorWrapperImpl<Knight, D>
        implements WrappedKnight<D> {

    public WrappedKnightImpl( Herald herald, D actorData ) {
        super( herald, actorData );
    }

    @Override
    public Words getWords( com.windwagon.kaamelott.race.Race race ) {
        return actorInstance.getWords( race );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitWrappedKnight( this );
    }

}
