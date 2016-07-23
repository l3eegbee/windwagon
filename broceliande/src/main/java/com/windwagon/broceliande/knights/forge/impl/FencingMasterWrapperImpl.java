package com.windwagon.broceliande.knights.forge.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredFencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.Knight;

public class FencingMasterWrapperImpl
        extends TaskWrapperImpl<FencingMaster, ArmoredFencingMasterWrapper, FencingMasterData, FencingMasterRun>
        implements FencingMasterWrapper {

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    private KnightWrapper knightWrapper;

    private BrotherhoodWrapper brotherhoodWrapper;

    public FencingMasterWrapperImpl( Herald herald, FencingMasterRun runData ) {
        super( herald, runData.getFencingMaster(), runData );
    }

    @PostConstruct
    public void init() {

        knightWrapper = herald.getKnight( runData );

        brotherhoodWrapper = herald.getBrotherhood( runData.getBrotherhood() );

    }

    @Override
    public KnightWrapper getKnight() {
        return knightWrapper;
    }

    @Override
    public BrotherhoodWrapper getBrotherhood() {
        return brotherhoodWrapper;
    }

    @Override
    protected ArmoredFencingMasterWrapper createArmor( Camp camp ) {
        return camp.getFencingMaster( this );
    }

    @Override
    protected void saveRun() {
        fencingMasterRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?, ?>> getActorDependances() {
        return new HashSet<>( Arrays.asList( knightWrapper, brotherhoodWrapper ) );
    }

    @Override
    public Set<? extends TaskWrapper<?, ?, ?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<? extends TaskWrapper<?, ?, ?>> getDependantTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        tasks.add( brotherhoodWrapper );

        addDependantTasksFromConstants( tasks, ComponentPatterns.getTrainedKnightName( this ) );
        addDependantTasksFromConstants( tasks, ComponentPatterns.getFencingMasterName( this ) );

        return tasks;

    }

    @Override
    public void actorInitialize( ArmoredFencingMasterWrapper armored ) throws ForgeException {

        FencingMaster fencingMaster = armored.getActor();

        fencingMaster.setKnight( armored.getKnight() );
        fencingMaster.setBrotherhood( armored.getBrotherhood() );

        fencingMaster.initialize();

    }

    @Override
    public void skip() {
        runData.setKnightSerialization( null );
        super.skip();
    }

    @Override
    public RunStatus fail( Throwable ex ) {

        runData.setKnightSerialization( null );
        return super.fail( ex );

    }

    @Override
    public void execute( ArmoredFencingMasterWrapper armored ) {

        FencingMaster fencingMaster = armored.getActor();
        Knight knight = armored.getKnight().getActor();

        // train
        fencingMaster.train();

        // save
        runData.setKnightSerialization( base64encode( knight.marshal() ) );
        runData.setSerialization( base64encode( fencingMaster.marshal() ) );

    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitFencingMaster( this );
    }

}
