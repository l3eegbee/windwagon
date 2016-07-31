package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Base64;

import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeError;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;
import com.windwagon.logres.collection.LazyInitializer;

public class ArmoredFencingMasterWrapperImpl
        extends ArmoredTaskWrapperImpl<FencingMaster, FencingMasterRun, FencingMasterWrapper>
        implements ArmoredFencingMasterWrapper {

    public ArmoredFencingMasterWrapperImpl( Camp camp, FencingMasterWrapper wrapper ) throws ForgeException {
        super( camp, wrapper );
    }

    private LazyInitializer<ArmoredKnightWrapper> armoredKnightWrapper = new LazyInitializer<>( () -> {
        try {
            return camp.getKnight( wrapper.getKnight() );
        } catch( ForgeException ex ) {
            throw new ForgeError( ex );
        }
    } );

    @Override
    public ArmoredBrotherhoodWrapper getBrotherhood() {
        return armoredBrotherhoodWrapper.get();
    }

    private LazyInitializer<ArmoredBrotherhoodWrapper> armoredBrotherhoodWrapper = new LazyInitializer<>( () -> {
        try {
            return camp.getBrotherhood( wrapper.getBrotherhood() );
        } catch( ForgeException ex ) {
            ex.printStackTrace();
            throw new ForgeError( ex );
        }
    } );

    @Override
    public ArmoredKnightWrapper getKnight() {
        return armoredKnightWrapper.get();
    }

    @Override
    public Words getWords( Race race ) {
        return getKnight().getWords( race );
    }

    @Override
    protected void actorInitialize() throws ForgeException {

        instance.setKnight( armoredKnightWrapper.get() );
        instance.setBrotherhood( armoredBrotherhoodWrapper.get() );

        instance.initialize();

    }

    @Override
    public void execute() {

        // train
        instance.train();

        // save

        FencingMasterRun runData = wrapper.getRunData();

        byte[] knightMarshalling = armoredKnightWrapper.get().getActor().marshal();
        if( knightMarshalling != null )
            runData.setKnightSerialization( Base64.getEncoder().encodeToString( knightMarshalling ) );

        byte[] fencingMasterMarshalling = instance.marshal();
        if( fencingMasterMarshalling != null )
            runData.setSerialization( Base64.getEncoder().encodeToString( fencingMasterMarshalling ) );

    }

}
