package com.windwagon.kaamelott.words;

import com.windwagon.kaamelott.race.*;

import java.io.*;
import java.util.*;

public class Bet implements Serializable {

	private final static long serialVersionUID = 1L;

	private BetType betType;

	private double stake;

	private int[] ticket;

	public Bet(BetType betType, double stake, Collection<Horse> ticket) {

		this.betType = betType;
		this.stake = stake;

		this.ticket = new int[ticket.size()];
		int i = 0;
		for (Horse horse : ticket)
			this.ticket[i++] = horse.getNumber();

	}

	public Bet(BetType betType, Collection<Horse> ticket) {
		this(betType, betType.getBase(), ticket);
	}

	public Bet(BetType betType, double stake, Horse... horses) {
		this(betType, stake, Arrays.asList(horses));
	}

	public Bet(BetType betType, Horse... horses) {
		this(betType, betType.getBase(), Arrays.asList(horses));
	}

	/**
	 * @return the betType
	 */
	public BetType getBetType() {
		return betType;
	}

	/**
	 * @return the stake
	 */
	public double getStake() {
		return stake;
	}

	/**
	 * Rounds the stake to be valid (superior than the bet base, multiple of 1
	 * or of the base).
	 *
	 * @return the new stake
	 */
	public double roundStake() {

		double base = betType.getBase();
		double stake = getStake();

		if (stake < base) return base;

		double fromUnit = Math.abs(Math.IEEEremainder(stake, 1d));
		double fromBase = Math.abs(Math.IEEEremainder(stake, base));
		if (fromUnit < fromBase) {
			return Math.round(stake);
		} else {
			return Math.round(stake / base) * base;
		}

	}

	/**
	 * @return the ticket
	 */
	public int[] getTicket() {
		return ticket;
	}

	/**
	 * @return the ticket
	 */
	public List<Horse> getTicket(Race race) {
		List<Horse> horses = new Vector<>(ticket.length);
		for (int num : ticket)
			horses.add(race.getHorse(num));
		return horses;
	}

}
