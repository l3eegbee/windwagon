package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.KnightData;

public interface KnightWrapper extends WrappedKnight {

    public void marshal();

    public void unmarshal();

    @Override
    public KnightData getActorData();

}
