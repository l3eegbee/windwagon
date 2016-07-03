package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.forge.WrappedKnight;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.words.Words;

public abstract class WrappedKnightImpl<D extends ActorData> extends ActorWrapperImpl<Knight, D>
        implements WrappedKnight {

    public WrappedKnightImpl( D actorData ) {
        super( actorData );
    }

    @Override
    public Words getWords( com.windwagon.kaamelott.race.Race race ) {
        return actorInstance.getWords( race );
    }

}
