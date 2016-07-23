package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;
import com.windwagon.logres.collection.LazyInitializer;

public class ArmoredFencingMasterWrapperImpl
        extends ArmoredTaskWrapperImpl<FencingMaster, FencingMasterRun, FencingMasterWrapper>
        implements ArmoredFencingMasterWrapper {

    public ArmoredFencingMasterWrapperImpl( Camp camp, FencingMasterWrapper wrapper ) {
        super( camp, wrapper );
    }

    private LazyInitializer<ArmoredKnightWrapper> armoredKnightWrapper =
            new LazyInitializer<>( () -> camp.getKnight( wrapper.getKnight() ) );

    @Override
    public ArmoredBrotherhoodWrapper getBrotherhood() {
        return armoredBrotherhoodWrapper.get();
    }

    private LazyInitializer<ArmoredBrotherhoodWrapper> armoredBrotherhoodWrapper =
            new LazyInitializer<>( () -> camp.getBrotherhood( wrapper.getBrotherhood() ) );

    @Override
    public ArmoredKnightWrapper getKnight() {
        return armoredKnightWrapper.get();
    }

    @Override
    public Words getWords( Race race ) {
        return getKnight().getWords( race );
    }

}
