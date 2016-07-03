package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;

public class OfficialKnightWrapperImpl extends WrappedKnightImpl<OfficialKnightData>
        implements OfficialKnightWrapper {

    public OfficialKnightWrapperImpl( OfficialKnightData officialKnightData ) {
        super( officialKnightData );
    }

    @Override
    public void actorPostInitialize() throws Exception {

        super.actorPostInitialize();

        String serialization = actorData.getSerialization();
        if( serialization != null )
            actorInstance.unmarshal( base64decode( serialization ) );

    }

}
