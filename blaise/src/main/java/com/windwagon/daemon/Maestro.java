package com.windwagon.daemon;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.broceliande.race.repositories.MeetingRepository;
import com.windwagon.broceliande.race.repositories.RaceRepository;
import com.windwagon.daemon.tasks.ProgrammeLoader;
import com.windwagon.logres.date.DateConverter;
import com.windwagon.logres.date.LazyDate;
import com.windwagon.logres.mail.TemplateMailSenderFactory;
import com.windwagon.logres.triggers.FixRateTrigger;
import com.windwagon.logres.triggers.OffsetTrigger;
import com.windwagon.logres.triggers.TriggerParser;

@Component
public class Maestro {

    public final static String ENV_LOAD_PROGRAMME_FROM = "reload.from";

    public final static String ENV_LOAD_PROGRAMME_TO = "reload.to";

    public final static String ENV_MAESTRO_START_MAIL = "maestro.start.mail";

    public final static String ENV_TASKS_PREFIX = "tasks.";

    public final static String ENV_TRIGGERS_SUFFIX = ".triggers";

    public final static String ENV_MAIL_SUCCESS_SUFFIX = ".mail.success";

    public final static String ENV_MAIL_ERROR_SUFFIX = ".mail.error";

    public final static String CXT_RACE = "race";

    public final static String CXT_STACKTRACE = "error";

    private final static Logger logger = LoggerFactory.getLogger( Maestro.class );

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    @Autowired
    private Clock clock;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private TriggerParser triggerParser;

    @Autowired
    private ProgrammeLoader programmeLoader;

    @Autowired
    private TaskRunnerFactory taskRunnerFactory;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private TemplateMailSenderFactory templateMailSenderFactory;

    private static class RaceTaskTrigger {

        public RaceTask raceTask;

        public OffsetTrigger offsetTrigger;

        public RaceTaskTrigger( RaceTask raceTask, OffsetTrigger offsetTrigger ) {
            this.raceTask = raceTask;
            this.offsetTrigger = offsetTrigger;
        }

        /**
         * @return the raceTask
         */
        public RaceTask getRaceTask() {
            return raceTask;
        }

        /**
         * @return the offsetTrigger
         */
        public OffsetTrigger getOffsetTrigger() {
            return offsetTrigger;
        }

    }

    private EnumMap<RaceStatus, List<RaceTaskTrigger>> raceTasksByStatus =
            new EnumMap<RaceStatus, List<RaceTaskTrigger>>( RaceStatus.class );

    @PostConstruct
    public void start() {

        String maestroStart = environment.getProperty( "maestro.start" );
        if( maestroStart == null || !maestroStart.equals( "true" ) ) {
            logger.info( "Skip Maestro" );
            return;
        }

        logger.info( "Start Maestro" );

        // reload programmes

        LocalDate startDay = null;

        // fix by property?
        String startStr = environment.getProperty( ENV_LOAD_PROGRAMME_FROM );
        if( startStr != null )
            startDay = LocalDate.parse( startStr, LazyDate.FORMAT_D );

        // last scan? (repeat the last day)
        if( startDay == null ) {
            Date lastDate = meetingRepository.getLastMeetingDate();
            if( lastDate != null )
                startDay = DateConverter.toLocalDate( lastDate );
        }

        // default: yesterday
        if( startDay == null )
            startDay = LocalDate.now( clock ).plusDays( -1 );

        LocalDate endDay = null;

        // fix by property?
        String endStr = environment.getProperty( ENV_LOAD_PROGRAMME_TO );
        if( endStr != null )
            endDay = LocalDate.parse( endStr, LazyDate.FORMAT_D );

        // default: tomorrow
        if( endStr == null )
            endDay = LocalDate.now( clock ).plusDays( 1 );

        // scan programmes
        for( LocalDate date = startDay; !date.isAfter( endDay ); date = date.plusDays( 1 ) )
            programmeLoader.scan( date );

        // load and schedule fix rate tasks

        Map<String, Task> tasks = applicationContext.getBeansOfType( Task.class );
        for( Task task : tasks.values() ) {

            String envTaskKey = task.getEnvKey();

            String triggerKey = envTaskKey + ENV_TRIGGERS_SUFFIX;
            String triggerRaw = environment.getProperty( triggerKey );
            if( triggerRaw == null )
                throw new NoSuchElementException( "Property " + triggerKey + " not found." );

            FixRateTrigger trigger = triggerParser.parse( triggerRaw );

            TaskRunner runner = taskRunnerFactory.getTaskRunner( task );

            taskScheduler.schedule( runner, trigger );

        }

        // load RaceTasks

        Map<String, RaceTask> raceTasks = applicationContext.getBeansOfType( RaceTask.class );
        for( RaceTask raceTask : raceTasks.values() ) {

            String envTaskKey = raceTask.getEnvKey();

            String triggerKey = envTaskKey + ENV_TRIGGERS_SUFFIX;
            String triggerRaw = environment.getProperty( triggerKey );
            if( triggerRaw == null )
                throw new NoSuchElementException( "Property " + triggerKey + " not found." );

            OffsetTrigger trigger = triggerParser.createOffsetTrigger( triggerRaw );

            RaceStatus raceStatus = raceTask.getRaceStatus();

            if( !raceTasksByStatus.containsKey( raceStatus ) )
                raceTasksByStatus.put( raceStatus, new Vector<RaceTaskTrigger>() );

            raceTasksByStatus.get( raceStatus ).add( new RaceTaskTrigger( raceTask, trigger ) );

        }

        // schedule RaceTasks

        for( RaceStatus raceStatus : raceTasksByStatus.keySet() )
            for( Race race : raceRepository.findByStatus( raceStatus ) )
                scheduleRaceTask( race );

        logger.info( "Maestro scheduler started" );

        templateMailSenderFactory.getTemplateMailSender( ENV_MAESTRO_START_MAIL ).send();

    }

    public void scheduleRaceTask( Race race ) {

        RaceStatus raceStatus = race.getStatus();
        if( !raceTasksByStatus.containsKey( raceStatus ) )
            return;

        for( RaceTaskTrigger raceTaskTrigger : raceTasksByStatus.get( raceStatus ) ) {

            RaceTaskRunner runner = taskRunnerFactory.getRaceTaskRunner(
                    race.getId(),
                    raceTaskTrigger.getRaceTask(),
                    raceTaskTrigger.getOffsetTrigger() );

            taskScheduler.schedule( runner, runner );

        }

    }

}
