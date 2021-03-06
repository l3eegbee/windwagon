package com.windwagon.kaamelott.race;

public enum BetType {

    /**
     * Simple gagnant.
     */
    SIMPLE_GAGNANT( 1, 1.5d ),

    /**
     * Simple plac�.
     */
    SIMPLE_PLACE( 1, 1.5d ),

    /**
     * Coupl� ordre.
     */
    COUPLE_ORDRE( 2, 1.5d ),

    /**
     * Coupl� gagnant.
     */
    COUPLE_GAGNANT( 2, 1.5d ),

    /**
     * Coupl� place.
     */
    COUPLE_PLACE( 2, 1.5d ),

    /**
     * Trio ordre.
     */
    TRIO_ORDRE( 3, 1.5d ),

    /**
     * Trio.
     */
    TRIO( 3, 1.5 ),

    /**
     * Deux sur quatre.
     */
    DEUX_SUR_QUATRE( 2, 3d ),

    /**
     * Multi en quatre.
     */
    MULTI_EN_QUATRE( 4, 3d ),

    /**
     * Multi en cinq.
     */
    MULTI_EN_CINQ( 5, 3d ),

    /**
     * Multi en six.
     */
    MULTI_EN_SIX( 6, 3d ),

    /**
     * Multi en sept.
     */
    MULTI_EN_SEPT( 7, 3d ),

    /**
     * Pick5.
     */
    PICK5( 5, 1d ),

    /**
     * Tierc�.
     */
    TIERCE( 3, 1d ),

    /**
     * Quart�.
     */
    QUARTE( 4, 1.3d ),

    /**
     * Quint�.
     */
    QUINTE( 5, 2d );

    private int ticketLength;

    private double base;

    private BetType( int ticketLength, double base ) {
        this.ticketLength = ticketLength;
        this.base = base;
    }

    public int getTicketLength() {
        return ticketLength;
    }

    public double getBase() {
        return base;
    }

}
