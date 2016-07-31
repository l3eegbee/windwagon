package com.windwagon.broceliande.knights.forge.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import com.windwagon.logres.collection.LazyInitializer;

public class FencingMasterWrapperImpl
        extends TaskWrapperImpl<FencingMaster, ArmoredFencingMasterWrapper, FencingMasterData, FencingMasterRun>
        implements FencingMasterWrapper {

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    private LazyInitializer<KnightWrapper> knightWrapper = new LazyInitializer<>( () -> herald.getKnight( runData ) );

    private LazyInitializer<BrotherhoodWrapper> brotherhoodWrapper =
            new LazyInitializer<>( () -> herald.getBrotherhood( runData.getBrotherhood() ) );

    public FencingMasterWrapperImpl( Herald herald, FencingMasterRun runData ) {
        super( herald, runData.getFencingMaster(), runData );
    }

    @Override
    public KnightWrapper getKnight() {
        return knightWrapper.get();
    }

    @Override
    public BrotherhoodWrapper getBrotherhood() {
        return brotherhoodWrapper.get();
    }

    @Override
    public ArmoredFencingMasterWrapper instanciate( Camp camp ) throws ForgeException {
        return camp.getFencingMaster( this );
    }

    @Override
    protected void saveRun() {
        fencingMasterRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?, ?>> getActorDependances() {
        return new HashSet<>( Arrays.asList( knightWrapper.get(), brotherhoodWrapper.get() ) );
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

        tasks.add( brotherhoodWrapper.get() );

        addDependantTasksFromConstants( tasks, ComponentPatterns.getTrainedKnightName( this ) );
        addDependantTasksFromConstants( tasks, ComponentPatterns.getFencingMasterName( this ) );

        return tasks;

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
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitFencingMaster( this );
    }

}
