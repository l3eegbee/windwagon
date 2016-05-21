package com.windwagon.logres.triggers;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;

import com.windwagon.logres.date.DateConverter;

public class DailyTrigger extends FixRateTrigger {

    @Autowired
    private Clock clock;

    private LocalTime hour;

    public DailyTrigger( LocalTime hour ) {
        this.hour = hour;
    }

    public LocalTime getHour() {
        return hour;
    }

    @Override
    public Date nextExecutionTime( TriggerContext triggerContext ) {

        LocalDateTime nextTrigger = LocalDate.now( clock ).atTime( hour );
        if( nextTrigger.isBefore( LocalDateTime.now( clock ) ) )
            nextTrigger = nextTrigger.plusDays( 1 );

        return DateConverter.toDate( nextTrigger );

    }

    @Override
    public boolean equals( Object obj ) {

        if( this == obj )
            return true;
        if( obj == null || getClass() != obj.getClass() )
            return false;

        DailyTrigger other = (DailyTrigger) obj;

        if( !Objects.equals( hour, other.hour ) )
            return false;

        return true;

    }

    @Override
    public String toString() {
        return "daily:" + hour;
    }

}
