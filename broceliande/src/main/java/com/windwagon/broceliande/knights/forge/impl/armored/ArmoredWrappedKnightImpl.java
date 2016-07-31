package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.WrappedKnight;
import com.windwagon.broceliande.knights.forge.armored.ArmoredWrappedKnight;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public abstract class ArmoredWrappedKnightImpl<W extends WrappedKnight<?, ?>> extends ArmoredActorWrapperImpl<Knight, W>
        implements ArmoredWrappedKnight {

    public ArmoredWrappedKnightImpl( Camp camp, W wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    public Words getWords( Race race ) {
        return instance.getWords( race );
    }

}
