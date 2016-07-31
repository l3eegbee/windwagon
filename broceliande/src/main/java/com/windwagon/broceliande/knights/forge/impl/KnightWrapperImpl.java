package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredKnightWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class KnightWrapperImpl extends WrappedKnightImpl<ArmoredKnightWrapper, KnightData> implements KnightWrapper {

    private FencingMasterRun fencingMasterRun;

    private String knightName;

    public KnightWrapperImpl( Herald herald, FencingMasterRun fencingMasterRun ) {

        super( herald, fencingMasterRun.getFencingMaster().getKnight() );

        this.fencingMasterRun = fencingMasterRun;

        this.knightName = fencingMasterRun.getFencingMaster().getBrotherhood().getName();

    }

    @Override
    public String getName() {
        return knightName;
    }

    @Override
    public Cycle getCycle() {
        return fencingMasterRun.getCycle();
    }

    @Override
    public FencingMasterRun getFencingMasterRun() {
        return this.fencingMasterRun;
    }

    @Override
    public ArmoredKnightWrapper instanciate( Camp camp ) throws ForgeException {
        return camp.getKnight( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitKnight( this );
    }

}
