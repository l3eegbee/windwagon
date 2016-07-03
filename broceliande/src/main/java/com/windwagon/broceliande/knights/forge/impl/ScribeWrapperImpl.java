package com.windwagon.broceliande.knights.forge.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.ComponentPatterns;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.TaskWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;
import com.windwagon.kaamelott.Scribe;

public class ScribeWrapperImpl extends TaskWrapperImpl<Scribe, ScribeData, ScribeRun> implements
        ScribeWrapper {

    private static final Logger logger = LoggerFactory.getLogger( ScribeWrapper.class );

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    public ScribeWrapperImpl( ScribeRun runData ) {
        super( runData.getScribe(), runData );
    }

    @Override
    protected void saveRun() {
        scribeRunRepository.save( runData );
    }

    @Override
    public Set<TaskWrapper> getRequiredTasks() throws ForgeException {

        ActorWrapperSet<TaskWrapper> tasks = new ActorWrapperSet<>();

        addRequiredTasksFromConstants( tasks );

        return tasks.get();

    }

    @Override
    public Set<TaskWrapper> getDependantTasks() {

        ActorWrapperSet<TaskWrapper> tasks = new ActorWrapperSet<>();

        addDependantTasksFromConstants( tasks, ComponentPatterns.getScribeName( this ) );

        return tasks.get();

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
