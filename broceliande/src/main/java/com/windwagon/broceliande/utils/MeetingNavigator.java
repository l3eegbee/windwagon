package com.windwagon.broceliande.utils;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Race;

public class MeetingNavigator {

    public static < R, S > R find( Set<R> set, Function<R, S> getter, S target ) {

        if( set == null )
            throw new IllegalArgumentException( "Set is null" );
        if( set.isEmpty() )
            throw new IllegalArgumentException( "Set is empty" );

        for( R elt : set )
            if( Objects.equals( getter.apply( elt ), target ) )
                return elt;

        throw new IllegalArgumentException( "Element not found" );

    }

    public static Race getRace( Meeting meeting, int numRace ) {
        return meeting == null ? null : find( meeting.getRaces(), Race::getNumber, numRace );
    }

    public static Odds getOdds( Race race, Date date ) {
        return race == null ? null : find( race.getOdds(), Odds::getDate, date );
    }

    public static Horse getHorse( Race race, int numHorse ) {
        return race == null ? null : find( race.getHorses(), Horse::getNumber, numHorse );
    }

    public static Horse getHorse( Meeting meeting, int numRace, int numHorse ) {
        return meeting == null ? null : getHorse( getRace( meeting, numRace ), numHorse );
    }

}
