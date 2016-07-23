package com.windwagon.broceliande.knights.forge.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

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

public class BrotherhoodWrapperImpl
        extends TaskWrapperImpl<Brotherhood, ArmoredBrotherhoodWrapper, BrotherhoodData, BrotherhoodRun>
        implements BrotherhoodWrapper {

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    private Set<FencingMasterWrapper> fencingMasters = new HashSet<>();

    private FencingMasterWrapper theone;

    public BrotherhoodWrapperImpl( Herald herald, BrotherhoodRun runData ) {
        super( herald, runData.getBrotherhood(), runData );
    }

    @PostConstruct
    public void init() {

        for( FencingMasterRun fmrun : runData.getFencingMasters() )
            fencingMasters.add( herald.getFencingMaster( fmrun ) );

        if( runData.getSelected() != null )
            theone = herald.getFencingMaster( runData.getSelected() );

    }

    @Override
    public Set<FencingMasterWrapper> getFencingMasterWrappers() {
        return fencingMasters;
    }

    @Override
    public FencingMasterWrapper getSelectedWrapper() {
        return theone;
    }

    @Override
    protected void saveRun() {
        brotherhoodRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?, ?>> getActorDependances() {
        return fencingMasters;
    }

    @Override
    public Set<? extends TaskWrapper<?, ?, ?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?, ?, ?>> tasks = new HashSet<>();

        for( FencingMasterWrapper fencingMaster : fencingMasters )
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
    public void actorInitialize( ArmoredBrotherhoodWrapper armored ) throws ForgeException {

        Brotherhood brotherhood = armored.getActor();

        brotherhood.setFencingMasters( armored.getFencingMasters() );

        brotherhood.initialize();

    }

    @Override
    public void execute( ArmoredBrotherhoodWrapper armored ) {

        Brotherhood brotherhood = armored.getActor();

        // get best knight
        FencingMasterWrapper theone = (FencingMasterWrapper) brotherhood.getBest();

        // save
        runData.setSelected( theone.getRunData() );
        runData.setSerialization( base64encode( brotherhood.marshal() ) );

    }

    @Override
    protected ArmoredBrotherhoodWrapper createArmor( Camp camp ) {
        return camp.getBrotherhood( this );
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitBrotherhood( this );
    }

}
