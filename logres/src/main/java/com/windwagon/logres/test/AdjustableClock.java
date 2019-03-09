package com.windwagon.logres.test;

import android.annotation.*;

import com.windwagon.logres.date.*;

import java.time.*;
import java.time.format.*;

@SuppressLint("NewApi")
public class AdjustableClock extends Clock {

    private final static DateTimeFormatter DEFAULT_FORMAT = LazyDate.FORMAT_S;

    private Clock offsetClock;

    public AdjustableClock() {
        this( ZoneId.systemDefault() );
    }

    public AdjustableClock( ZoneId zoneId ) {
        Clock baseClock = Clock.system( zoneId );
        offsetClock = Clock.offset( baseClock, Duration.ZERO );
    }

    public void setNow( String now ) {
        setNow( now, DEFAULT_FORMAT );
    }

    public void setNow( String now, DateTimeFormatter format ) {
        setNow( LocalDateTime.parse( now, format ).atZone( getZone() ).toInstant() );
    }

    public void setNow( Instant instant ) {
        Clock clock = Clock.system( offsetClock.getZone() );
        Duration diff = Duration.between( clock.instant(), instant );
        offsetClock = Clock.offset( clock, diff );
    }

    private AdjustableClock( Clock offsetClock ) {
        this.offsetClock = offsetClock;
    }

    @Override
    public ZoneId getZone() {
        return offsetClock.getZone();
    }

    @Override
    public Clock withZone( ZoneId zoneId ) {
        return new AdjustableClock( offsetClock.withZone( zoneId ) );
    }

    @Override
    public Instant instant() {
        return offsetClock.instant();
    }

}
