package com.windwagon.broceliande.knights.forge.impl.armored;

import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredPageWrapper;
import com.windwagon.kaamelott.Page;

public class ArmoredPageWrapperImpl extends ArmoredActorWrapperImpl<Page> implements ArmoredPageWrapper {

    public ArmoredPageWrapperImpl( PageWrapper wrapper, Page page ) {
        super( wrapper, page );
    }

}
