package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;

public class ArmoredKnightWrapperImpl extends ArmoredWrappedKnightImpl<KnightWrapper> implements ArmoredKnightWrapper {

    public ArmoredKnightWrapperImpl( Camp camp, KnightWrapper wrapper ) {
        super( camp, wrapper );
    }

    @Override
    public String getName() {
        return wrapper.getName();
    }

}
