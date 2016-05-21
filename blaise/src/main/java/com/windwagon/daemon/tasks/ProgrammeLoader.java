package com.windwagon.daemon.tasks;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.daemon.Maestro;
import com.windwagon.daemon.Task;
import com.windwagon.daemon.TaskRunnerFactory;
import com.windwagon.logres.triggers.TriggerParser;
import com.windwagon.pmuportal.RaceLoader;
import com.windwagon.pmuportal.exceptions.PMUError;

@Component
public class ProgrammeLoader implements Task {

    public final static String NAME = "scan";

    public final static String CTX_SCANNED_DATE = "scanned";

    private final static Logger logger = LoggerFactory.getLogger( ProgrammeLoader.class );

    @Value( "${tasks.scan.dayoffsets}" )
    private String dayoffsetsParam;

    @Value( "${tasks.scan.delay_on_error}" )
    private String delayOnErrorParam;

    @Value( "${tasks.scan.max_retry}" )
    private String maxRetryParam;

    @Autowired
    private Clock clock;

    @Autowired
    private Maestro maestro;

    @Autowired
    private TriggerParser triggerParser;

    @Autowired
    private TaskRunnerFactory taskRunnerFactory;

    @Autowired
    private RaceLoader raceLoader;

    private List<Integer> dayoffsets;

    private Duration onErrorOffsetDuration;

    private int maxRetry;

    @Override
    public String getName() {
        return NAME;
    }

    @PostConstruct
    public void start() {

        // load day offsets
        dayoffsets = new Vector<Integer>();
        for( String offset : dayoffsetsParam.split( "," ) )
            dayoffsets.add( Integer.parseInt( offset ) );

        // load on error offset
        onErrorOffsetDuration = triggerParser
                .createOffsetTrigger( delayOnErrorParam )
                .getOffsets()
                .get( 0 )
                .getDuration();

        // load max retry
        maxRetry = Integer.parseInt( maxRetryParam );

    }

    @Override
    public void run( Map<String, Object> reportContext ) {

        LocalDate now = LocalDate.now( clock );

        for( Integer offset : dayoffsets )
            scan( now.plusDays( offset ) );

    }

    public void scan( LocalDate targetDate ) {
        taskRunnerFactory.getTaskRunner( new ProgrammeScanner( targetDate ) ).run();
    }

    private class ProgrammeScanner implements Task {

        public final static String NAME = ProgrammeLoader.NAME + ".daily";

        private LocalDate dateTarget;

        public ProgrammeScanner( LocalDate dateTarget ) {
            this.dateTarget = dateTarget;
        }

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public void run( Map<String, Object> reportContext ) throws PMUError {

            reportContext.put( CTX_SCANNED_DATE, dateTarget );

            boolean done = false;
            int retry = 0;
            PMUError lastError = null;

            List<Meeting> meetings = Collections.emptyList();

            while( !done && retry < maxRetry ) {

                try {

                    // scan programme
                    meetings = raceLoader.loadAllRaces( dateTarget );

                    done = true;

                } catch( PMUError ex ) {

                    retry++;
                    lastError = ex;

                    logger.warn( "Can't load program of {}, retry #{}", dateTarget, retry, ex );

                    try {
                        Thread.sleep( onErrorOffsetDuration.getSeconds() * 1000 );
                    } catch( InterruptedException interruptedException ) {
                        return;
                    }

                }

            }

            if( !done )
                throw lastError;

            // schedule
            for( Meeting meeting : meetings )
                for( Race race : meeting.getRaces() )
                    maestro.scheduleRaceTask( race );

        }

    }

}
