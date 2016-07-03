package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.forge.KnightWrapper;

public class KnightWrapperImpl extends WrappedKnightImpl<KnightData> implements KnightWrapper {

    private FencingMasterRun fencingMasterRun;

    private String knightName;

    public KnightWrapperImpl( FencingMasterRun fencingMasterRun ) {

        super( fencingMasterRun.getFencingMaster().getKnight() );

        this.fencingMasterRun = fencingMasterRun;

        this.knightName = fencingMasterRun.getFencingMaster().getBrotherhood().getName();

    }

    @Override
    public String getName() {
        return knightName;
    }

    @Override
    public void marshal() {
        fencingMasterRun.setKnightSerialization( base64encode( actorInstance.marshal() ) );
    }

    @Override
    public void unmarshal() {
        String serialization = fencingMasterRun.getKnightSerialization();
        if( serialization != null )
            actorInstance.unmarshal( base64decode( serialization ) );
    }

}
