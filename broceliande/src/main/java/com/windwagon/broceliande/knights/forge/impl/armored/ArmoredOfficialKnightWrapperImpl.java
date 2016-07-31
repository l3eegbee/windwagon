package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Base64;

import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredOfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class ArmoredOfficialKnightWrapperImpl extends ArmoredWrappedKnightImpl<OfficialKnightWrapper>
        implements ArmoredOfficialKnightWrapper {

    public ArmoredOfficialKnightWrapperImpl( Camp camp, OfficialKnightWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    @Override
    protected void actorInitialize() throws ForgeException {

        try {

            instance.initialize();

            String serialization = wrapper.getActorData().getSerialization();
            if( serialization != null ) {
                byte[] bytes = Base64.getDecoder().decode( serialization );
                instance.unmarshal( bytes );
            }

        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

    }

}
