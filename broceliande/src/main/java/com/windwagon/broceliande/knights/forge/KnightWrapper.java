package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;

public interface KnightWrapper extends WrappedKnight<ArmoredKnightWrapper, KnightData> {

    public String getName();

    public FencingMasterRun getFencingMasterRun();

}
