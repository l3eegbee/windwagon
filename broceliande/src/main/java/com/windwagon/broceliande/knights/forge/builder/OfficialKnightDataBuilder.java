package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;

public class OfficialKnightDataBuilder extends ActorDataBuilder<OfficialKnightData, OfficialKnightDataBuilder> {

    public OfficialKnightDataBuilder() {
        super( new OfficialKnightData() );
    }

    /*
     * Serialization
     */

    public OfficialKnightDataBuilder serialization( String serialization ) {
        actorData.setSerialization( serialization );
        return this;
    }

}
