package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;

public interface FencingMasterWrapper
        extends TaskWrapper<ArmoredFencingMasterWrapper, FencingMasterData, FencingMasterRun> {

    public KnightWrapper getKnight();

    public BrotherhoodWrapper getBrotherhood();

}
