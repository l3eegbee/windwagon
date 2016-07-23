package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;
import com.windwagon.logres.collection.LazyInitializer;

public class ArmoredBrotherhoodWrapperImpl extends
        ArmoredTaskWrapperImpl<Brotherhood, BrotherhoodRun, BrotherhoodWrapper> implements ArmoredBrotherhoodWrapper {

    public ArmoredBrotherhoodWrapperImpl( Camp camp, BrotherhoodWrapper wrapper ) {
        super( camp, wrapper );
    }

    private LazyInitializer<Set<ArmoredFencingMasterWrapper>> armoredFencingMasters = new LazyInitializer<>( () -> {
        HashSet<ArmoredFencingMasterWrapper> set = new HashSet<>();
        for( FencingMasterWrapper fencingMasterWrapper : wrapper.getFencingMasterWrappers() )
            set.add( camp.getFencingMaster( fencingMasterWrapper ) );
        return Collections.unmodifiableSet( set );
    } );

    @Override
    public Set<? extends ArmoredFencingMaster> getFencingMasters() {
        return armoredFencingMasters.get();
    }

    private LazyInitializer<ArmoredFencingMasterWrapper> armoredTheOne =
            new LazyInitializer<>( () -> camp.getFencingMaster( wrapper.getSelectedWrapper() ) );

    @Override
    public ArmoredFencingMasterWrapper getBest() {
        return armoredTheOne.get();
    }

}
