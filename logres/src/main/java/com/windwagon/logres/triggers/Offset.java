package com.windwagon.logres.triggers;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

public class Offset implements Comparable<Offset> {

    @Autowired
    private Clock clock;

    private Duration duration;

    private boolean repeatly = false;

    public Offset( Duration duration, boolean repeatly ) {
        this.duration = duration;
        this.repeatly = repeatly;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isRepeatly() {
        return repeatly;
    }

    public Date nextDate( Date ref ) {

        Date now = Date.from( Instant.now( clock ) );

        if( repeatly ) {

            if( now.before( ref ) )
                return ref;

            double nowMillis = (double) now.getTime();
            double refMillis = (double) ref.getTime();
            double durMillis = (double) duration.toMillis();

            return new Date( (long) ( Math.ceil( ( nowMillis - refMillis ) / durMillis ) * durMillis + refMillis ) );

        } else {

            Date next = new Date( ref.getTime() + duration.toMillis() );
            return next.before( now ) ? null : next;

        }

    }

    @Override
    public int compareTo( Offset offset ) {
        return duration.compareTo( offset.duration );
    }

    @Override
    public boolean equals( Object obj ) {

        if( this == obj )
            return true;
        if( obj == null || getClass() != obj.getClass() )
            return false;

        Offset other = (Offset) obj;

        if( !Objects.equals( duration, other.duration ) )
            return false;
        if( !Objects.equals( repeatly, other.repeatly ) )
            return false;

        return true;

    }

    @Override
    public String toString() {
        return duration.toString() + ( repeatly ? "*" : "" );
    }

}
