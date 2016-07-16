package com.windwagon.broceliande.knights.forge.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.errors.ActorExecutionException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public class FencingMasterWrapperImpl extends TaskWrapperImpl<FencingMaster, FencingMasterData, FencingMasterRun>
        implements FencingMasterWrapper {

    private static final Logger logger = LoggerFactory.getLogger( FencingMasterWrapper.class );

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    private KnightWrapper knight;

    private BrotherhoodWrapper brotherhood;

    public FencingMasterWrapperImpl( Herald herald, FencingMasterRun runData ) {
        super( herald, runData.getFencingMaster(), runData );
    }

    @PostConstruct
    public void init() {
        knight = herald.getKnight( runData );
    }

    private BrotherhoodWrapper brotherhood() {

        if( brotherhood == null && runData.getBrotherhood() != null )
            brotherhood = herald.getBrotherhood( runData.getBrotherhood() );

        return brotherhood;

    }

    @Override
    protected void saveRun() {
        fencingMasterRunRepository.save( runData );
    }

    @Override
    public Set<? extends ActorWrapper<?,?>> getActorDependances() {
        return new HashSet<>( Arrays.asList( knight, brotherhood() ) );
    }

    @Override
    public Set<? extends TaskWrapper<?,?,?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<? extends TaskWrapper<?,?,?>> getDependantTasks() throws ForgeException {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        tasks.add( brotherhood() );

        addDependantTasksFromConstants( tasks, ComponentPatterns.getTrainedKnightName( this ) );
        addDependantTasksFromConstants( tasks, ComponentPatterns.getFencingMasterName( this ) );

        return tasks;

    }

    @Override
    public void actorPreInitialize() throws ForgeException {

        knight.setClassLoader( classLoader );
        knight.inClasspathInstanciate();

        try {
            actorInstance.setKnight( knight );
        } catch( Throwable ex ) {
            throw new ActorExecutionException( ex );
        }

    }

    @Override
    public void close() {

        if( knight != null )
            knight.close();

        super.close();

    }

    @Override
    public KnightWrapper getKnight() {
        return knight;
    }

    @Override
    public Words getWords( Race race ) {
        return knight.getWords( race );
    }

    @Override
    public void skip() {
        runData.setKnightSerialization( null );
        super.skip();
    }

    @Override
    @Transactional
    public RunStatus run() {

        logger.info( "Run task {}", this );

        try {

            instanciate();

            call( new Script() {

                @Override
                public void call() {

                    // train
                    actorInstance.train();

                    // save
                    knight.marshal();
                    marshal();

                }

            } );

            return done();

        } catch( Throwable ex ) {

            runData.setKnightSerialization( null );

            return fail( ex );

        } finally {

            this.close();

            logger.info( "Task {} finished", this );

        }

    }

}
