package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Collections;
import java.util.Set;

import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;

public class ArmoredBrotherhoodWrapperImpl extends ArmoredActorWrapperImpl<Brotherhood>
        implements ArmoredBrotherhoodWrapper {

    private Set<? extends ArmoredFencingMasterWrapper> fencingMasters;

    private ArmoredFencingMasterWrapper theone;

    public ArmoredBrotherhoodWrapperImpl(
            BrotherhoodWrapper wrapper,
            Brotherhood instance,
            Set<? extends ArmoredFencingMasterWrapper> fencingMasters,
            ArmoredFencingMasterWrapper theone ) {
        super( wrapper, instance );
        this.fencingMasters = Collections.unmodifiableSet( fencingMasters );
        this.theone = theone;
    }

    @Override
    public Set<? extends ArmoredFencingMaster> getFencingMasters() {
        return fencingMasters;
    }

    @Override
    public ArmoredFencingMasterWrapper getBest() {
        return theone;
    }

}
