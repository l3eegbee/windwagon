package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.kaamelott.Scribe;

public class ArmoredScribeWrapperImpl extends ArmoredTaskWrapperImpl<Scribe, ScribeRun, ScribeWrapper>
        implements ArmoredScribeWrapper {

    public ArmoredScribeWrapperImpl( Camp camp, ScribeWrapper wrapper ) {
        super( camp, wrapper );
    }

}
