package com.windwagon.kaamelott.race;

import java.util.SortedSet;

public interface Price {

    /**
     * @return the bet
     */
    public BetType getBetType();

    /**
     * @return the priceName
     */
    public PriceName getPriceName();

    /**
     * @return the price
     */
    public Double getPrice();

    /**
     * @return the ticketComposition
     */
    public SortedSet<Horse> getTicket();

}
