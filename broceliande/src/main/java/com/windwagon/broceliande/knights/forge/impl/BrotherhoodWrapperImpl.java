package com.windwagon.broceliande.knights.forge.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.h2.tools.Script;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.kaamelott.Brotherhood;

public class BrotherhoodWrapperImpl extends TaskWrapperImpl<Brotherhood, BrotherhoodData, BrotherhoodRun>
        implements BrotherhoodWrapper {

    private static final Logger logger = LoggerFactory.getLogger( BrotherhoodWrapper.class );

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    private Set<FencingMasterWrapper> fencingMasters = new HashSet<>();

    public BrotherhoodWrapperImpl( Herald herald, BrotherhoodRun runData ) {
        super( herald, runData.getBrotherhood(), runData );
    }

    @PostConstruct
    public void init() {
        for( FencingMasterRun fmrun : runData.getFencingMasters() )
            fencingMasters.add( herald.getFencingMaster( fmrun ) );
    }

    @Override
    protected void saveRun() {
        brotherhoodRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?,?>> getActorDependances() {
        return fencingMasters;
    }

    @Override
    public Set<? extends TaskWrapper<?,?,?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        for( FencingMasterWrapper fencingMaster : fencingMasters )
            tasks.add( fencingMaster );

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<TaskWrapper<?,?,?>> getDependantTasks() throws ForgeException {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        addDependantTasksFromConstants( tasks, ComponentPatterns.getSelectedKnightName( this ) );
        addDependantTasksFromConstants( tasks, ComponentPatterns.getBrotherhoodName( this ) );

        return tasks;

    }

    @Override
    public void actorPreInitialize() throws ForgeException {

        try {

            for( FencingMasterWrapper fencingMaster : fencingMasters ) {

                fencingMaster.setClassLoader( classLoader );
                fencingMaster.inClasspathInstanciate();

                if( fencingMaster.getStatus() == RunStatus.DONE ) {
                    fencingMaster.getKnight().unmarshal();
                    fencingMaster.unmarshal();
                }

            }

            actorInstance.setFencingMasters( Collections.unmodifiableSet( fencingMasters ) );

        } catch( ForgeException ex ) {
            throw ex;
        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

    }

    @Override
    public void close() {

        if( fencingMasters != null )
            for( FencingMasterWrapper fencingMaster : fencingMasters )
                fencingMaster.close();

        super.close();

    }

    @Override
    @Transactional
    public RunStatus run() {

        logger.info( "Run task {}", this );

        try {

            // instanciates actors
            instanciate();

            call( new Script() {

                @Override
                public void call() throws ActorExecutionException {

                    // get best knight
                    FencingMasterWrapper theone = (FencingMasterWrapper) actorInstance.getBest();

                    // save
                    runData.setSelected( theone.getRunData() );
                    marshal();

                }

            } );

            return done();

        } catch( Throwable ex ) {

            return fail( ex );

        } finally {

            this.close();

            logger.info( "Task {} finished", this );

        }

    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitBrotherhood( this );
    }

}
