package com.windwagon.kaamelott.race;

import java.util.SortedSet;

public interface Price {

	/**
	 * @return the bet
	 */
	BetType getBetType();

	/**
	 * @return the priceName
	 */
	PriceName getPriceName();

	/**
	 * @return the price
	 */
	Double getPrice();

	/**
	 * @return the ticketComposition
	 */
	SortedSet<Horse> getTicket();

}
