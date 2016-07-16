package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.KnightData;

public interface KnightWrapper extends WrappedKnight<KnightData> {

    public void marshal();

    public void unmarshal();

}
