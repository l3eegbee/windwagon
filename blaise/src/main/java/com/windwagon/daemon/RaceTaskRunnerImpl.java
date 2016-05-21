package com.windwagon.daemon;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;

import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.broceliande.race.repositories.RaceRepository;
import com.windwagon.logres.mail.TemplateMailSender;
import com.windwagon.logres.mail.TemplateMailSenderFactory;
import com.windwagon.logres.triggers.OffsetTrigger;

public class RaceTaskRunnerImpl implements RaceTaskRunner {

    private final static Logger logger = LoggerFactory.getLogger( RaceTaskRunnerImpl.class );

    @Autowired
    private Maestro maestro;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private TemplateMailSenderFactory templateMailSenderFactory;

    private Long raceId;

    private Date raceStart;

    private RaceTask raceTask;

    private OffsetTrigger offsetTrigger;

    private TemplateMailSender successMailSender;

    private TemplateMailSender errorMailSender;

    private boolean enabled = true;

    public RaceTaskRunnerImpl( Long raceId, RaceTask raceTask, OffsetTrigger offsetTrigger ) {
        this.raceId = raceId;
        this.raceTask = raceTask;
        this.offsetTrigger = offsetTrigger;
    }

    @PostConstruct
    @Transactional
    public void init() {

        successMailSender = templateMailSenderFactory
                .getTemplateMailSender( raceTask.getEnvKey() + Maestro.ENV_MAIL_SUCCESS_SUFFIX );
        errorMailSender = templateMailSenderFactory
                .getTemplateMailSender( raceTask.getEnvKey() + Maestro.ENV_MAIL_ERROR_SUFFIX );

        raceStart = raceRepository.findOne( raceId ).getStart();

    }

    @Override
    @Transactional
    public void run() {

        Race race = raceRepository.findOne( raceId );

        RaceStatus expectedStatus = raceTask.getRaceStatus();

        RaceStatus raceStatus = race.getStatus();

        // run the task if enabled and the status is OK
        if( enabled && raceStatus == expectedStatus ) {

            Map<String, Object> context = new HashMap<>();
            context.put( Maestro.CXT_RACE, race );

            try {

                raceTask.run( context, race );

                successMailSender.send( context );

            } catch( Throwable ex ) {

                logger.error(
                        "Error during executing task {} on {}",
                        raceTask.getName(),
                        race,
                        ex );

                context.put( Maestro.CXT_STACKTRACE, ExceptionUtils.getStackTrace( ex ) );
                errorMailSender.send( context );

            }

            raceStatus = race.getStatus();

        }

        Date nextExecution = offsetTrigger.nextExecutionTime( race.getStart() );

        // disabled the trigger if the status is not OK anymore or if no more
        // execution are scheduled
        enabled = raceStatus == expectedStatus && nextExecution != null;

        // re-schedule tasks if the status has changed
        if( raceStatus != expectedStatus )
            maestro.scheduleRaceTask( race );

    }

    @Override
    public Date nextExecutionTime( TriggerContext triggerContext ) {
        return enabled ? offsetTrigger.nextExecutionTime( raceStart ) : null;
    }

}
