package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.FencingMaster;

public interface FencingMasterWrapper
        extends TaskWrapper<FencingMaster, FencingMasterData, FencingMasterRun>, ArmoredFencingMaster {

    @Override
    public KnightWrapper getKnight();

}
