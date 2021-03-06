package com.windwagon.logres.triggers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TriggerContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.windwagon.logres.date.DateConverter;
import com.windwagon.logres.date.LazyDate;
import com.windwagon.logres.test.AdjustableClock;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = TriggerTestsConfig.class )
@EnableAutoConfiguration
public class NextExecTriggerTests {

    @Autowired
    private ApplicationContext appCxt;

    @Autowired
    private AdjustableClock clock;

    public static final Date parseDate( String date ) {
        return DateConverter.toDate( LocalDateTime.parse( date, LazyDate.FORMAT_S ) );
    }

    public static class NullTriggerContext implements TriggerContext {

        @Override
        public Date lastActualExecutionTime() {
            return null;
        }

        @Override
        public Date lastCompletionTime() {
            return null;
        }

        @Override
        public Date lastScheduledExecutionTime() {
            return null;
        }

    }

    private final static TriggerContext TC = new NullTriggerContext();

    @Test
    public void nextExecDaily() {

        clock.setNow( "27-02-2015 12:00:00" );

        DailyTrigger trigger;

        // in a half hour
        trigger = appCxt.getBean( DailyTrigger.class, LocalTime.of( 12, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "27-02-2015 12:30:00" ) ) );

        // a half hour ago
        trigger = appCxt.getBean( DailyTrigger.class, LocalTime.of( 11, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "28-02-2015 11:30:00" ) ) );

    }

    @Test
    public void nextExecWeekly() {

        clock.setNow( "27-02-2015 12:00:00" );

        WeeklyTrigger trigger;

        // in a half hour
        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.FRIDAY, LocalTime.of( 12, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "27-02-2015 12:30:00" ) ) );

        // a half hour ago
        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.FRIDAY, LocalTime.of( 11, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "06-03-2015 11:30:00" ) ) );

        // next Monday
        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.MONDAY, LocalTime.of( 12, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "02-03-2015 12:30:00" ) ) );

    }

    @Test
    public void nextExecMonthly() {

        clock.setNow( "27-02-2015 12:00:00" );

        MonthlyTrigger trigger;

        // in a half hour
        trigger = appCxt.getBean( MonthlyTrigger.class, 27, LocalTime.of( 12, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "27-02-2015 12:30:00" ) ) );

        // a half hour ago
        trigger = appCxt.getBean( MonthlyTrigger.class, 27, LocalTime.of( 11, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "27-03-2015 11:30:00" ) ) );

        // next month
        trigger = appCxt.getBean( MonthlyTrigger.class, 5, LocalTime.of( 12, 30 ) );
        assertThat( trigger.nextExecutionTime( TC ), is( parseDate( "05-03-2015 12:30:00" ) ) );

    }

    @Test
    public void nextExecOffset() {

        // -2h, -5m, 0m, 2m*
        OffsetTrigger trigger = appCxt.getBean( OffsetTrigger.class );
        trigger.setOffsets(
                appCxt.getBean( Offset.class, Duration.of( -2, ChronoUnit.HOURS ), false ),
                appCxt.getBean( Offset.class, Duration.of( -5, ChronoUnit.MINUTES ), false ),
                appCxt.getBean( Offset.class, Duration.of( 0, ChronoUnit.MINUTES ), false ),
                appCxt.getBean( Offset.class, Duration.of( 2, ChronoUnit.MINUTES ), true ) );

        Date start = parseDate( "27-02-2015 14:00:00" );

        // in 4h
        clock.setNow( "27-02-2015 10:00:00" );
        assertThat( trigger.nextExecutionTime( start ), is( parseDate( "27-02-2015 12:00:00" ) ) );

        // in 1h
        clock.setNow( "27-02-2015 13:00:00" );
        assertThat( trigger.nextExecutionTime( start ), is( parseDate( "27-02-2015 13:55:00" ) ) );

        // in 3'
        clock.setNow( "27-02-2015 13:57:00" );
        assertThat( trigger.nextExecutionTime( start ), is( parseDate( "27-02-2015 14:00:00" ) ) );

        // 1" ago
        clock.setNow( "27-02-2015 14:00:01" );
        assertThat( trigger.nextExecutionTime( start ), is( parseDate( "27-02-2015 14:02:00" ) ) );

        // 5' ago
        clock.setNow( "27-02-2015 14:05:00" );
        assertThat( trigger.nextExecutionTime( start ), is( parseDate( "27-02-2015 14:06:00" ) ) );

    }

}
