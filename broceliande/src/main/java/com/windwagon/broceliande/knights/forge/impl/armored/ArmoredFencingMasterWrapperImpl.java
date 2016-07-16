package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.kaamelott.ArmoredKnight;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public class ArmoredFencingMasterWrapperImpl extends ArmoredActorWrapperImpl<FencingMaster>
        implements ArmoredFencingMasterWrapper {

    protected ArmoredKnightWrapper armoredKnight;

    public ArmoredFencingMasterWrapperImpl(
            FencingMasterWrapper wrapper,
            FencingMaster instance,
            ArmoredKnightWrapper armoredKnight ) {
        super( wrapper, instance );
        this.armoredKnight = armoredKnight;
    }

    public ArmoredKnight getKnight() {
        return armoredKnight;
    }

    public Words getWords( Race race ) {
        return armoredKnight.getWords( race );
    }

}
