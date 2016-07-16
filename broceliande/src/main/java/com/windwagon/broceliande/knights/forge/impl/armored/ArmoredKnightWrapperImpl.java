package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.WrappedKnight;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public class ArmoredKnightWrapperImpl extends ArmoredActorWrapperImpl<Knight> implements ArmoredKnightWrapper {

    public ArmoredKnightWrapperImpl( WrappedKnight<?> wrapper, Knight instance ) {
        super( wrapper, instance );
    }

    @Override
    public Words getWords( Race race ) {
        return instance.getWords( race );
    }

}
