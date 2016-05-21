package com.windwagon.kaamelott.words;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.windwagon.kaamelott.race.BetType;

public class BetTest {

    private void roundStakeTest( double stake, double expected ) {
        assertThat( new Bet( BetType.SIMPLE_GAGNANT, stake ).roundStake(), is( expected ) );
    }

    @Test
    public void roundStake() {

        roundStakeTest( 1.50, 1.50 );
        roundStakeTest( 2.00, 2.00 );

        roundStakeTest( 1.00, 1.50 );
        roundStakeTest( 1.80, 2.00 );
        roundStakeTest( 2.00, 2.00 );
        roundStakeTest( 2.20, 2.00 );
        roundStakeTest( 4.00, 4.00 );
        roundStakeTest( 4.20, 4.00 );
        roundStakeTest( 4.30, 4.50 );
        roundStakeTest( 4.40, 4.50 );
        roundStakeTest( 4.50, 4.50 );
        roundStakeTest( 4.70, 4.50 );

    }

}
