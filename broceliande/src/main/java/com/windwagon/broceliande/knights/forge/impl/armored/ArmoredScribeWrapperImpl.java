package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Base64;

import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.Scribe;

public class ArmoredScribeWrapperImpl extends ArmoredTaskWrapperImpl<Scribe, ScribeRun, ScribeWrapper>
        implements ArmoredScribeWrapper {

    public ArmoredScribeWrapperImpl( Camp camp, ScribeWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    @Override
    protected void actorInitialize() throws ForgeException {
        instance.initialize();
    }

    @Override
    public void execute() {

        // evaluate
        instance.evaluate();

        // save the scribe

        ScribeRun runData = wrapper.getRunData();

        byte[] scribeMarshalling = instance.marshal();
        if( scribeMarshalling != null )
            runData.setSerialization( Base64.getEncoder().encodeToString( scribeMarshalling ) );

    }

}
