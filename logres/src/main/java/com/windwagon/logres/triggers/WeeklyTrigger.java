package com.windwagon.logres.triggers;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;

import com.windwagon.logres.date.DateConverter;

public class WeeklyTrigger extends FixRateTrigger {

    @Autowired
    private Clock clock;

    private DayOfWeek day;

    private LocalTime hour;

    public WeeklyTrigger( DayOfWeek day, LocalTime hour ) {
        this.day = day;
        this.hour = hour;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getHour() {
        return hour;
    }

    @Override
    public Date nextExecutionTime( TriggerContext triggerContext ) {

        LocalDateTime nextTrigger = LocalDate.now( clock ).with( TemporalAdjusters.nextOrSame( day ) ).atTime( hour );
        if( nextTrigger.isBefore( LocalDateTime.now( clock ) ) )
            nextTrigger = nextTrigger.with( TemporalAdjusters.next( day ) );

        return DateConverter.toDate( nextTrigger );

    }

    @Override
    public boolean equals( Object obj ) {

        if( this == obj )
            return true;
        if( obj == null || getClass() != obj.getClass() )
            return false;

        WeeklyTrigger other = (WeeklyTrigger) obj;

        if( !Objects.equals( day, other.day ) )
            return false;
        if( !Objects.equals( hour, other.hour ) )
            return false;

        return true;

    }

    @Override
    public String toString() {
        return "weekly:" + day + ":" + hour;
    }

}
