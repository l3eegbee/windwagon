package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class OfficialKnightWrapperImpl extends WrappedKnightImpl<OfficialKnightData> implements OfficialKnightWrapper {

    public OfficialKnightWrapperImpl( Herald herald, OfficialKnightData officialKnightData ) {
        super( herald, officialKnightData );
    }

    @Override
    public void actorPostInitialize() throws ForgeException {

        String serialization = actorData.getSerialization();
        if( serialization != null ) {

            byte[] bytes = base64decode( serialization );

            try {
                actorInstance.unmarshal( bytes );
            } catch( Throwable ex ) {
                throw new ActorExecutionException( ex );
            }

        }

    }

}
