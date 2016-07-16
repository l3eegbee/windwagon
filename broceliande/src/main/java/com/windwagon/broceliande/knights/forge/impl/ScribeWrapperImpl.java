package com.windwagon.broceliande.knights.forge.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;
import com.windwagon.kaamelott.Scribe;

public class ScribeWrapperImpl extends TaskWrapperImpl<Scribe, ScribeData, ScribeRun> implements ScribeWrapper {

    private static final Logger logger = LoggerFactory.getLogger( ScribeWrapper.class );

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    public ScribeWrapperImpl( Herald herald, ScribeRun runData ) {
        super( herald, runData.getScribe(), runData );
    }

    @Override
    protected void saveRun() {
        scribeRunRepository.save( runData );
    }

    @Override
    public Set<TaskWrapper<?,?,?>> getRequiredTasks() throws ForgeException {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        addRequiredTasksFromConstants( tasks );

        return tasks;

    }

    @Override
    public Set<TaskWrapper<?,?,?>> getDependantTasks() {

        Set<TaskWrapper<?,?,?>> tasks = new HashSet<>();

        addDependantTasksFromConstants( tasks, ComponentPatterns.getScribeName( this ) );

        return tasks;

    }

    @Override
    public RunStatus run() {

        logger.info( "Run task {}", this );

        try {

            // instanciates actors
            instanciate();

            call( new Script() {

                @Override
                public void call() {

                    // evaluate
                    actorInstance.evaluate();

                    // save the scribe
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

}
