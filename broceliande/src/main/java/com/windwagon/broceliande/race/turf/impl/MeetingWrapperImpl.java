package com.windwagon.broceliande.race.turf.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;

import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.turf.MeetingWrapper;
import com.windwagon.broceliande.race.turf.RaceWrapper;
import com.windwagon.broceliande.race.turf.Reference;
import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumConverter;
import com.windwagon.logres.collection.LazyInitializer;
import com.windwagon.logres.collection.LazyLoadNavigableSet;

public class MeetingWrapperImpl extends ObjectWrapperImpl<Meeting> implements MeetingWrapper {

    public final static Comparator<com.windwagon.kaamelott.race.Meeting> COMPARATOR =
            Comparator.comparing( com.windwagon.kaamelott.race.Meeting::getDate ).thenComparingInt(
                    com.windwagon.kaamelott.race.Meeting::getNumber );

    public MeetingWrapperImpl( Reference ref, Meeting meeting ) {
        super( ref, meeting );
    }

    public MeetingWrapperImpl( Reference ref, Meeting meeting, RaceWrapper race ) {
        super( ref, meeting );
        races.initAdd( race );
    }

    @Override
    public int compareTo( com.windwagon.kaamelott.race.Meeting meeting ) {
        return COMPARATOR.compare( this, meeting );
    }

    @Override
    public Date getDate() {
        return daoObject.getDate();
    }

    private LazyInitializer<String> racecourse =
            new LazyInitializer<String>( () -> daoObject.getRacecourse().getName() );

    @Override
    public String getRacecourse() {
        return racecourse.get();
    }

    private LazyInitializer<String> country =
            new LazyInitializer<String>( () -> daoObject.getRacecourse().getCountry() );

    @Override
    public String getCountry() {
        return country.get();
    }

    @Override
    public int getNumber() {
        return daoObject.getNumber();
    }

    @Override
    public Double getWindSpeed() {
        return daoObject.getWindSpeed();
    }

    @Override
    public com.windwagon.kaamelott.race.WindDirection getWindDirection() {
        return KaamelottEnumConverter.windDirection.castToKaamelott( daoObject.getWindDirection() );
    }

    @Override
    public Double getTemperature() {
        return daoObject.getTemperature();
    }

    @Override
    public String getClimat() {
        return daoObject.getClimat();
    }

    @Override
    public com.windwagon.kaamelott.race.Field getField() {
        return KaamelottEnumConverter.field.castToKaamelott( daoObject.getField() );
    }

    private LazyLoadNavigableSet<com.windwagon.kaamelott.race.Race> races =
            new LazyLoadNavigableSet<>( set -> {

                for( Race daoRace : daoObject.getRaces() ) {
                    RaceWrapper race = stud.getRace( ref, daoRace, MeetingWrapperImpl.this );
                    if( !set.contains( race ) )
                        set.add( race );
                }

            } );

    @Override
    public SortedSet<com.windwagon.kaamelott.race.Race> getRaces() {
        return races.getNavigableSet();
    }

}
