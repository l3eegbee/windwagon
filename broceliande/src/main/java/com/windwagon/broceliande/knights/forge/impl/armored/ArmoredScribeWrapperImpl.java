package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredScribeWrapper;
import com.windwagon.kaamelott.Scribe;

public class ArmoredScribeWrapperImpl extends ArmoredActorWrapperImpl<Scribe> implements ArmoredScribeWrapper {

    public ArmoredScribeWrapperImpl( ScribeWrapper wrapper, Scribe scribe ) {
        super( wrapper, scribe );
    }

}
