package com.windwagon.avalon.dummy;

import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.BetWords;

public class DummyKnight implements Knight {

    @Override
    public BetWords getWords( Race race ) {
        Horse horse = race.getHorses().first();
        return new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );
    }

}
