package com.windwagon.broceliande.race.turf.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Place;
import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.broceliande.race.entities.Type;
import com.windwagon.broceliande.race.turf.BetChecker;
import com.windwagon.broceliande.race.turf.FinishWrapper;
import com.windwagon.broceliande.race.turf.HorseWrapper;
import com.windwagon.broceliande.race.turf.MeetingWrapper;
import com.windwagon.broceliande.race.turf.PriceWrapper;
import com.windwagon.broceliande.race.turf.RaceWrapper;
import com.windwagon.broceliande.race.turf.Reference;
import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumConverter;
import com.windwagon.logres.collection.LazyInitializer;
import com.windwagon.logres.collection.LazyLoadNavigableMap;
import com.windwagon.logres.collection.LazyLoadNavigableSet;

public class RaceWrapperImpl extends ObjectWrapperImpl<Race> implements RaceWrapper {

    public final static Comparator<com.windwagon.kaamelott.race.Race> COMPARATOR =
            Comparator.comparing( com.windwagon.kaamelott.race.Race::getMeeting ).thenComparingInt(
                    com.windwagon.kaamelott.race.Race::getNumber );

    @Autowired
    private BetChecker betChecker;

    public RaceWrapperImpl( Reference ref, Race race ) {
        super( ref, race );
    }

    public RaceWrapperImpl( Reference ref, Race race, MeetingWrapper meeting ) {
        super( ref, race );
        this.meeting.set( meeting );
    }

    public RaceWrapperImpl( Reference ref, Race race, HorseWrapper horse ) {
        super( ref, race );
        numHorseMap.initAdd( horse.getNumber(), horse );
    }

    @Override
    public int compareTo( com.windwagon.kaamelott.race.Race race ) {
        return COMPARATOR.compare( this, race );
    }

    private LazyInitializer<MeetingWrapper> meeting = new LazyInitializer<MeetingWrapper>(
            () -> stud.getMeeting( ref, daoObject.getMeeting(), this ) );

    @Override
    public com.windwagon.kaamelott.race.Meeting getMeeting() {
        return meeting.get();
    }

    private LazyLoadNavigableMap<Integer, HorseWrapper> numHorseMap =
            new LazyLoadNavigableMap<>( map -> {

                for( Horse daoHorse : daoObject.getHorses() )
                    map.put( daoHorse.getNumber(), stud.getHorse( ref, daoHorse ) );

            } );

    @Override
    public HorseWrapper getHorseByNum( int num ) {
        NavigableMap<Integer, HorseWrapper> map = numHorseMap.getNavigableMap();
        return map.containsKey( num ) ? map.get( num ) : null;
    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile( "\\d+" );

    @Override
    public HorseWrapper getHorseByNum( String horseNum ) {

        if( horseNum == null )
            return null;

        HorseWrapper horse = null;

        Matcher numMatcher = NUMBER_PATTERN.matcher( horseNum );
        if( numMatcher.find() )
            horse = getHorseByNum( Integer.parseInt( numMatcher.group() ) );

        return horse;

    }

    @Override
    public List<HorseWrapper> getHorsesByNum( String horseList ) {

        if( horseList == null )
            return null;

        List<HorseWrapper> list = new LinkedList<>();

        Matcher numMatcher = NUMBER_PATTERN.matcher( horseList );
        while( numMatcher.find() )
            list.add( getHorseByNum( Integer.parseInt( numMatcher.group() ) ) );

        return list;

    }

    @Override
    public int getNumber() {
        return daoObject.getNumber();
    }

    @Override
    public String getName() {
        return daoObject.getName();
    }

    @Override
    public boolean isCanceled() {
        return daoObject.getStatus() == RaceStatus.CANCELED;
    }

    @Override
    public Date getStart() {
        return daoObject.getStart();
    }

    private LazyInitializer<Date> realStart = new LazyInitializer<>( () -> {

        Set<Date> dates = new HashSet<Date>();
        dates.add( daoObject.getStart() );
        dates.addAll( getOddsDates() );

        return Collections.max( dates );

    } );

    @Override
    public Date getRealStart() {
        return realStart.get();
    }

    @Override
    public double getDistance() {
        return daoObject.getDistance();
    }

    @Override
    public Double getBenefit() {
        return daoObject.getBenefit();
    }

    @Override
    public com.windwagon.kaamelott.race.Discipline getDiscipline() {
        return KaamelottEnumConverter.discipline.castToKaamelott( daoObject.getDiscipline() );
    }

    private LazyInitializer<Set<com.windwagon.kaamelott.race.RaceType>> raceTypes =
            new LazyInitializer<>( () -> {

                Set<com.windwagon.kaamelott.race.RaceType> raceTypes =
                        new HashSet<com.windwagon.kaamelott.race.RaceType>();

                for( Type type : daoObject.getTypes() )
                    raceTypes.add( KaamelottEnumConverter.raceType.castToKaamelott( type ) );

                return Collections.unmodifiableSet( raceTypes );

            } );

    @Override
    public Set<com.windwagon.kaamelott.race.RaceType> getTypes() {
        return raceTypes.get();
    }

    @Override
    public boolean isAutostart() {
        return daoObject.getTypes().contains( Type.AUTOSTART );
    }

    @Override
    public boolean isHandicap() {
        return daoObject.getTypes().contains( Type.HANDICAP );
    }

    @Override
    public boolean isReclamer() {
        return daoObject.getTypes().contains( Type.RECLAMER );
    }

    @Override
    public boolean isAmateurs() {
        return daoObject.getTypes().contains( Type.AMATEURS );
    }

    private LazyInitializer<SortedSet<com.windwagon.kaamelott.race.Horse>> horses =
            new LazyInitializer<>( () -> {

                NavigableMap<Integer, HorseWrapper> map = numHorseMap.getNavigableMap();
                SortedSet<com.windwagon.kaamelott.race.Horse> horses =
                        new TreeSet<com.windwagon.kaamelott.race.Horse>();
                horses.addAll( map.values() );
                return Collections.unmodifiableSortedSet( horses );

            } );

    @Override
    public SortedSet<com.windwagon.kaamelott.race.Horse> getHorses() {
        return horses.get();
    }

    @Override
    public com.windwagon.kaamelott.race.Horse getHorse( int number ) {
        return getHorseByNum( number );
    }

    private LazyInitializer<Set<com.windwagon.kaamelott.race.BetType>> bets =
            new LazyInitializer<>( () -> {

                Set<com.windwagon.kaamelott.race.BetType> bets =
                        EnumSet.noneOf( com.windwagon.kaamelott.race.BetType.class );

                for( BetType bet : daoObject.getBets() )
                    bets.add( KaamelottEnumConverter.betType.castToKaamelott( bet ) );

                return Collections.unmodifiableSet( bets );

            } );

    @Override
    public Set<com.windwagon.kaamelott.race.BetType> getBets() {
        return bets.get();
    }

    private LazyLoadNavigableMap<Date, Odds> dateOddsMap = new LazyLoadNavigableMap<>( map -> {

        for( Odds odds : daoObject.getOdds() )
            map.put( odds.getDate(), odds );

    } );

    @Override
    public Odds getOddsNextDate( Date date ) {

        NavigableMap<Date, Odds> map = dateOddsMap.getNavigableMap();

        Map.Entry<Date, Odds> entry = map.floorEntry( date );
        if( entry == null )
            entry = map.ceilingEntry( date );

        return entry == null ? null : entry.getValue();

    }

    @Override
    public NavigableSet<Date> getOddsDates() {
        return dateOddsMap.getNavigableMap().navigableKeySet();
    }

    @Override
    public Double getOddsTotal() {
        Odds odds = getOddsNextDate( getNow() );
        return odds == null ? null : odds.getTotal();
    }

    @Override
    public Double getFinishOddsTotal() {
        Odds odds = getOddsNextDate( getRealStart() );
        return odds == null ? null : odds.getTotal();
    }

    @Override
    public Double getOddsTotal( Date date ) {
        Odds odds = getOddsNextDate( date );
        return odds == null ? null : odds.getTotal();
    }

    @Override
    public Integer getDuration() {
        return daoObject.getDuration();
    }

    private LazyLoadNavigableMap<HorseWrapper, FinishWrapper> horseFinishMap =
            new LazyLoadNavigableMap<>( map -> {

                Set<Place> setPlace = daoObject.getPlaces();
                if( setPlace != null )
                    for( Place place : setPlace ) {
                        HorseWrapper horse = getHorseByNum( place.getHorse() );
                        FinishWrapper finish = stud.getFinish( ref, place, horse );
                        map.put( horse, finish );
                    }

            } );

    private LazyInitializer<SortedSet<com.windwagon.kaamelott.race.Finish>> finish =
            new LazyInitializer<>( () -> {

                SortedSet<com.windwagon.kaamelott.race.Finish> finish =
                        new TreeSet<com.windwagon.kaamelott.race.Finish>();
                finish.addAll( horseFinishMap.getNavigableMap().values() );
                return Collections.unmodifiableSortedSet( finish );

            } );

    @Override
    public SortedSet<com.windwagon.kaamelott.race.Finish> getFinish() {
        return finish.get();
    }

    private LazyLoadNavigableSet<HorseWrapper> stopped = new LazyLoadNavigableSet<>( set -> {

        List<HorseWrapper> list = getHorsesByNum( daoObject.getStopped() );
        if( list != null )
            set.addAll( list );

    } );

    @Override
    public Set<com.windwagon.kaamelott.race.Horse> getStopped() {
        return Collections.unmodifiableSet( stopped.getNavigableSet() );
    }

    private LazyLoadNavigableSet<HorseWrapper> disqualified = new LazyLoadNavigableSet<>( set -> {

        List<HorseWrapper> list = getHorsesByNum( daoObject.getDisqualified() );
        if( list != null )
            set.addAll( list );

    } );

    @Override
    public Set<com.windwagon.kaamelott.race.Horse> getFallen() {
        return Collections.unmodifiableSet( fallen.getNavigableSet() );
    }

    private LazyLoadNavigableSet<HorseWrapper> fallen = new LazyLoadNavigableSet<>( set -> {

        List<HorseWrapper> list = getHorsesByNum( daoObject.getFallen() );
        if( list != null )
            set.addAll( list );

    } );

    @Override
    public Set<com.windwagon.kaamelott.race.Horse> getDisqualified() {
        return Collections.unmodifiableSet( disqualified.getNavigableSet() );
    }

    private LazyInitializer<Set<PriceWrapper>> prices = new LazyInitializer<>( () -> {

        Set<PriceWrapper> set = new HashSet<>();

        Set<Price> racePrices = daoObject.getPrices();
        if( racePrices != null )
            for( Price price : racePrices )
                set.add( stud.getPrice( ref, price, RaceWrapperImpl.this ) );

        return set;

    } );

    @Override
    public Set<com.windwagon.kaamelott.race.Price> getPrices() {
        return Collections.unmodifiableSet( prices.get() );
    }

    @Override
    public boolean isValidBet( com.windwagon.kaamelott.words.Bet bet ) {
        return betChecker.isValid( bet, this );
    }

    @Override
    public List<com.windwagon.kaamelott.race.Price> getPrice(
            com.windwagon.kaamelott.words.Bet bet )
            throws com.windwagon.kaamelott.words.InvalidBet {
        return betChecker.getPrice( bet, this );
    }

    @Override
    public double getBalance( com.windwagon.kaamelott.words.Bet bet )
            throws com.windwagon.kaamelott.words.InvalidBet {
        return betChecker.getBalance( bet, this );
    }

}
