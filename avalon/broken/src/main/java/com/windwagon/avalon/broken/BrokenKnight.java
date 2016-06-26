package com.windwagon.avalon.broken;

import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.BetWords;

public class BrokenKnight implements Knight {

    @Override
    public BetWords getWords( Race race ) {
        throw new RuntimeException( "I'm broken" );
    }

}
