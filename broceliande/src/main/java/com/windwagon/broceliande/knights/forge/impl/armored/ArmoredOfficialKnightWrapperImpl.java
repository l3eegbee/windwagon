package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredOfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;

public class ArmoredOfficialKnightWrapperImpl extends ArmoredWrappedKnightImpl<OfficialKnightWrapper>
        implements ArmoredOfficialKnightWrapper {

    public ArmoredOfficialKnightWrapperImpl( Camp camp, OfficialKnightWrapper wrapper ) {
        super( camp, wrapper );
    }

}
