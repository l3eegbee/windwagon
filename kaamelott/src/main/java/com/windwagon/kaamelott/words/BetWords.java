package com.windwagon.kaamelott.words;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BetWords implements Words {

    private final static long serialVersionUID = 1l;

    protected List<Bet> bets;

    public BetWords( Bet ... bets ) {
        this( Arrays.asList( bets ) );
    }

    public BetWords( Collection<Bet> bets ) {
        this.bets = new Vector<>( bets );
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList( bets );
    }

}
