package com.windwagon.logres.triggers;



import com.windwagon.logres.date.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.*;

import java.time.*;
import java.util.*;


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

        return Objects.equals(hour, other.hour);

    }

    @Override
    public String toString() {
        return "daily:" + hour;
    }

}
