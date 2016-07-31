package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeError;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;
import com.windwagon.logres.collection.LazyInitializer;

public class ArmoredBrotherhoodWrapperImpl extends
        ArmoredTaskWrapperImpl<Brotherhood, BrotherhoodRun, BrotherhoodWrapper> implements ArmoredBrotherhoodWrapper {

    public ArmoredBrotherhoodWrapperImpl( Camp camp, BrotherhoodWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    private LazyInitializer<Set<ArmoredFencingMasterWrapper>> armoredFencingMasters = new LazyInitializer<>( () -> {
        try {
            Set<ArmoredFencingMasterWrapper> set = new HashSet<>();
            for( FencingMasterWrapper fencingMasterWrapper : wrapper.getFencingMasterWrappers() )
                set.add( camp.getFencingMaster( fencingMasterWrapper ) );
            return Collections.unmodifiableSet( set );
        } catch( ForgeException ex ) {
            throw new ForgeError( ex );
        }
    } );

    @Override
    public Set<? extends ArmoredFencingMaster> getFencingMasters() {
        return armoredFencingMasters.get();
    }

    private LazyInitializer<ArmoredFencingMasterWrapper> armoredTheOne = new LazyInitializer<>( () -> {
        try {
            return camp.getFencingMaster( wrapper.getSelectedWrapper() );
        } catch( ForgeException ex ) {
            throw new ForgeError( ex );
        }
    } );

    @Override
    public ArmoredFencingMasterWrapper getBest() {
        return armoredTheOne.get();
    }

    @Override
    protected void actorInitialize() throws ForgeException {

        instance.setFencingMasters( armoredFencingMasters.get() );

        instance.initialize();

    }

    @Override
    public void execute() {

        // get best knight
        ArmoredFencingMasterWrapper theone = (ArmoredFencingMasterWrapper) instance.getBest();

        // save

        BrotherhoodRun runData = wrapper.getRunData();

        runData.setSelected( ( (FencingMasterWrapper) theone.getWrapper() ).getRunData() );

        byte[] brotherhoodMarsahlling = instance.marshal();
        if( brotherhoodMarsahlling != null )
            runData.setSerialization( Base64.getEncoder().encodeToString( brotherhoodMarsahlling ) );

    }

}
