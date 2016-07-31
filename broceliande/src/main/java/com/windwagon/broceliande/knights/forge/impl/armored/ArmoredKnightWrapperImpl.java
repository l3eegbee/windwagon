package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Base64;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class ArmoredKnightWrapperImpl extends ArmoredWrappedKnightImpl<KnightWrapper> implements ArmoredKnightWrapper {

    public ArmoredKnightWrapperImpl( Camp camp, KnightWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    @Override
    public String getName() {
        return wrapper.getName();
    }

    @Override
    protected void actorInitialize() throws ForgeException {

        try {

            instance.initialize();

            FencingMasterRun run = wrapper.getFencingMasterRun();

            if( run.getStatus() == RunStatus.DONE ) {
                String serialization = run.getKnightSerialization();
                if( serialization != null ) {
                    byte[] bytes = Base64.getDecoder().decode( serialization );
                    instance.unmarshal( bytes );
                }
            }

        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

    }

}
