package com.windwagon.logres.triggers;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;

import com.windwagon.logres.date.DateConverter;

public class MonthlyTrigger extends FixRateTrigger {

    @Autowired
    private Clock clock;

    private int day = 0;

    private LocalTime hour;

    public MonthlyTrigger( int day, LocalTime hour ) {
        this.day = day;
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public LocalTime getHour() {
        return hour;
    }

    @Override
    public Date nextExecutionTime( TriggerContext triggerContext ) {

        LocalDateTime nextTrigger =
                LocalDate.now( clock ).with( TemporalAdjusters.firstDayOfMonth() ).plusDays( day - 1 ).atTime( hour );
        if( nextTrigger.isBefore( LocalDateTime.now( clock ) ) )
            nextTrigger = nextTrigger.with( TemporalAdjusters.lastDayOfMonth() ).plusDays( day );

        return DateConverter.toDate( nextTrigger );

    }

    @Override
    public boolean equals( Object obj ) {

        if( this == obj )
            return true;
        if( obj == null || getClass() != obj.getClass() )
            return false;

        MonthlyTrigger other = (MonthlyTrigger) obj;

        if( !Objects.equals( day, other.day ) )
            return false;
        if( !Objects.equals( hour, other.hour ) )
            return false;

        return true;

    }

    @Override
    public String toString() {
        return "monthly:" + day + ":" + hour;
    }

}
