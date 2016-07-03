package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;

public interface OfficialKnightWrapper extends WrappedKnight {

    @Override
    public OfficialKnightData getActorData();

}
