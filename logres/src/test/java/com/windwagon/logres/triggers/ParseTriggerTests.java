package com.windwagon.logres.triggers;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.*;
import org.springframework.test.context.junit4.*;

import java.time.*;
import java.time.temporal.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = TriggerTestsConfig.class)
//@SpringApplicationConfiguration( classes = TriggerTestsConfig.class )
@EnableAutoConfiguration
public class ParseTriggerTests {

    @Autowired
    private ApplicationContext appCxt;

    @Autowired
    private TriggerParser triggerParser;

    @Test
    public void parseDaily() {

        DailyTrigger trigger;

        trigger = appCxt.getBean( DailyTrigger.class, LocalTime.of( 13, 37 ) );
        assertThat( triggerParser.parse( "daily:13h37" ), is( trigger ) );

        trigger = appCxt.getBean( DailyTrigger.class, LocalTime.of( 13, 00 ) );
        assertThat( triggerParser.parse( "daily:13h00" ), is( trigger ) );

        trigger = appCxt.getBean( DailyTrigger.class, LocalTime.of( 9, 00 ) );
        assertThat( triggerParser.parse( "daily:09h00" ), is( trigger ) );
        assertThat( triggerParser.parse( "daily:9h00" ), is( trigger ) );

    }

    @Test
    public void parseWeekly() {

        WeeklyTrigger trigger;

        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.MONDAY, LocalTime.of( 01, 37 ) );
        assertThat( triggerParser.parse( "weekly:mon:01h37" ), is( trigger ) );

        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.THURSDAY, LocalTime.of( 13, 00 ) );
        assertThat( triggerParser.parse( "weekly:thu:13h00" ), is( trigger ) );

        trigger = appCxt.getBean( WeeklyTrigger.class, DayOfWeek.SUNDAY, LocalTime.of( 9, 37 ) );
        assertThat( triggerParser.parse( "weekly:sun:09h37" ), is( trigger ) );

    }

    @Test
    public void parseMonthly() {

        MonthlyTrigger trigger;

        trigger = appCxt.getBean( MonthlyTrigger.class, 5, LocalTime.of( 01, 37 ) );
        assertThat( triggerParser.parse( "monthly:5:01h37" ), is( trigger ) );

    }

    @Test
    public void parseOffsets() {

        OffsetTrigger trigger = appCxt.getBean( OffsetTrigger.class );

        trigger.setOffsets(
                appCxt.getBean( Offset.class, Duration.of( 1, ChronoUnit.HOURS ), false ) );
        assertThat( triggerParser.createOffsetTrigger( "+1h" ), is( trigger ) );

        ChronoUnit H = ChronoUnit.HOURS;
        ChronoUnit M = ChronoUnit.MINUTES;

        trigger.setOffsets(
                appCxt.getBean( Offset.class, Duration.of( -2, H ), false ),
                appCxt.getBean( Offset.class, Duration.of( -5, M ), false ),
                appCxt.getBean( Offset.class, Duration.of( 0, M ), false ),
                appCxt.getBean( Offset.class, Duration.of( 2, M ), true ) );
        assertThat( triggerParser.createOffsetTrigger( "-2h,-5m,0m,2m*" ), is( trigger ) );

    }

}
