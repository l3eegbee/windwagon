package com.windwagon.broceliande.knights.forge.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.kaamelott.Brotherhood;
import com.windwagon.logres.collection.LazyInitializer;

public class BrotherhoodWrapperImpl
        extends TaskWrapperImpl<Brotherhood, ArmoredBrotherhoodWrapper, BrotherhoodData, BrotherhoodRun>
        implements BrotherhoodWrapper {

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    private LazyInitializer<Set<FencingMasterWrapper>> fencingMasters = new LazyInitializer<>( () -> {
        Set<FencingMasterWrapper> set = new HashSet<>();
        for( FencingMasterRun fmrun : runData.getFencingMasters() )
            set.add( herald.getFencingMaster( fmrun ) );
        return set;
    } );

    private LazyInitializer<FencingMasterWrapper> theone = new LazyInitializer<>( () -> {
        return runData.getSelected() != null ? herald.getFencingMaster( runData.getSelected() ) : null;
    } );

    public BrotherhoodWrapperImpl( Herald herald, BrotherhoodRun runData ) {
        super( herald, runData.getBrotherhood(), runData );
    }

    @Override
    public Set<FencingMasterWrapper> getFencingMasterWrappers() {
        return fencingMasters.get();
    }

    @Override
    public FencingMasterWrapper getSelectedWrapper() {
        return theone.get();
    }

    @Override
    protected void saveRun() {
        brotherhoodRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?, ?>> getActorDependances() {
        return fencingMasters.get();
    }

    @Override
    public Set<? extends TaskWrapper<?, ?, ?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        for( FencingMasterWrapper fencingMaster : fencingMasters.get() )
            tasks.add( fencingMaster );

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<TaskWrapper<?, ?, ?>> getDependantTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        addDependantTasksFromConstants( tasks, ComponentPatterns.getSelectedKnightName( this ) );
        addDependantTasksFromConstants( tasks, ComponentPatterns.getBrotherhoodName( this ) );

        return tasks;

    }

    @Override
    public ArmoredBrotherhoodWrapper instanciate( Camp camp ) throws ForgeException {
        return camp.getBrotherhood( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitBrotherhood( this );
    }

}
