package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.InvalidBet;

public interface Race extends Comparable<Race> {

    /**
     * @return the meeting
     */
    public Meeting getMeeting();

    /**
     * @return the number
     */
    public int getNumber();

    /**
     * @return the name
     */
    public String getName();

    /**
     * @return the canceling
     */
    public boolean isCanceled();

    /**
     * @return the start
     */
    public Date getStart();

    /**
     * @return the realStart
     */
    @MainRaceInaccessibleField
    public Date getRealStart();

    /**
     * @return the distance
     */
    public double getDistance();

    /**
     * @return the benefit
     */
    public Double getBenefit();

    /**
     * @return the discipline
     */
    public Discipline getDiscipline();

    /**
     * @return le type de la course
     */
    public Set<RaceType> getTypes();

    /**
     * @return si départ à l'autostart
     */
    public boolean isAutostart();

    /**
     * @return si course à handicap
     */
    public boolean isHandicap();

    /**
     * @return si course à reclamer
     */
    public boolean isReclamer();

    /**
     * @return si course amateurs
     */
    public boolean isAmateurs();

    /**
     * @return the horses
     */
    public SortedSet<Horse> getHorses();

    /**
     * return the horse
     */
    public Horse getHorse( int num );

    /**
     * @return the bets
     */
    public Set<BetType> getBets();

    /**
     * @return the odds dates
     */
    public NavigableSet<Date> getOddsDates();

    /**
     * @return le total des paris simples
     */
    public Double getOddsTotal();

    /**
     * @return le total des paris simples
     */
    @MainRaceInaccessibleField
    public Double getFinishOddsTotal();

    /**
     * @return le total des paris simples
     */
    @MainRaceInaccessibleField
    public Double getOddsTotal( Date date );

    /**
     * @return the duration
     */
    @MainRaceInaccessibleField
    public Integer getDuration();

    /**
     * @return the places
     */
    @MainRaceInaccessibleField
    public SortedSet<Finish> getFinish();

    /**
     * @return the stopped
     */
    @MainRaceInaccessibleField
    public Set<Horse> getStopped();

    /**
     * @return the disqualified
     */
    @MainRaceInaccessibleField
    public Set<Horse> getDisqualified();

    /**
     * @return the fallen
     */
    @MainRaceInaccessibleField
    public Set<Horse> getFallen();

    /**
     * @return the prices
     */
    @MainRaceInaccessibleField
    public Set<Price> getPrices();

    /**
     * @return true if the bet is valid
     */
    public boolean isValidBet( Bet bet );

    /**
     * @return the prices obtained by the bet
     */
    @MainRaceInaccessibleField
    public List<Price> getPrice( Bet bet ) throws InvalidBet;

    /**
     * @return the price value obtained by the bet
     */
    @MainRaceInaccessibleField
    public double getBalance( Bet bet ) throws InvalidBet;

}
