package com.windwagon.kaamelott.race;

import com.windwagon.kaamelott.words.*;

import java.util.*;

public interface Race extends Comparable<Race> {

	/**
	 * @return the meeting
	 */
	Meeting getMeeting();

	/**
	 * @return the number
	 */
	int getNumber();

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @return the canceling
	 */
	boolean isCanceled();

	/**
	 * @return the start
	 */
	Date getStart();

	/**
	 * @return the realStart
	 */
	@MainRaceInaccessibleField
	Date getRealStart();

	/**
	 * @return the distance
	 */
	double getDistance();

	/**
	 * @return the benefit
	 */
	Double getBenefit();

	/**
	 * @return the discipline
	 */
	Discipline getDiscipline();

	/**
	 * @return le type de la course
	 */
	Set<RaceType> getTypes();

	/**
	 * @return si départ à l'autostart
	 */
	boolean isAutostart();

	/**
	 * @return si course à handicap
	 */
	boolean isHandicap();

	/**
	 * @return si course à reclamer
	 */
	boolean isReclamer();

	/**
	 * @return si course amateurs
	 */
	boolean isAmateurs();

	/**
	 * @return the horses
	 */
	SortedSet<Horse> getHorses();

	/**
	 * return the horse
	 */
	Horse getHorse(int num);

	/**
	 * @return the bets
	 */
	Set<BetType> getBets();

	/**
	 * @return the odds dates
	 */
	NavigableSet<Date> getOddsDates();

	/**
	 * @return le total des paris simples
	 */
	Double getOddsTotal();

	/**
	 * @return le total des paris simples
	 */
	@MainRaceInaccessibleField
	Double getFinishOddsTotal();

	/**
	 * @return le total des paris simples
	 */
	@MainRaceInaccessibleField
	Double getOddsTotal(Date date);

	/**
	 * @return the duration
	 */
	@MainRaceInaccessibleField
	Integer getDuration();

	/**
	 * @return the places
	 */
	@MainRaceInaccessibleField
	SortedSet<Finish> getFinish();

	/**
	 * @return the stopped
	 */
	@MainRaceInaccessibleField
	Set<Horse> getStopped();

	/**
	 * @return the disqualified
	 */
	@MainRaceInaccessibleField
	Set<Horse> getDisqualified();

	/**
	 * @return the fallen
	 */
	@MainRaceInaccessibleField
	Set<Horse> getFallen();

	/**
	 * @return the prices
	 */
	@MainRaceInaccessibleField
	Set<Price> getPrices();

	/**
	 * @return true if the bet is valid
	 */
	boolean isValidBet(Bet bet);

	/**
	 * @return the prices obtained by the bet
	 */
	@MainRaceInaccessibleField
	List<Price> getPrice(Bet bet) throws InvalidBet;

	/**
	 * @return the price value obtained by the bet
	 */
	@MainRaceInaccessibleField
	double getBalance(Bet bet) throws InvalidBet;

}
