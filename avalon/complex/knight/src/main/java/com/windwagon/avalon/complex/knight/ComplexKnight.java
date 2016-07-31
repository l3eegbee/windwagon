package com.windwagon.avalon.complex.knight;

import java.util.Objects;

import com.windwagon.avalon.complex.component.ComplexComponent;
import com.windwagon.avalon.simple.SimpleKnight;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.BetWords;

public class ComplexKnight implements Knight {

    private ComplexComponent component;

    private SimpleKnight knight;

    private SimpleKnight hiddenKnight = new SimpleKnight();

    @Override
    public BetWords getWords( Race race ) {
        Horse horse = race.getHorses().first();
        return new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );
    }

    public ComplexComponent getComponent() {
        return this.component;
    }

    public void setComponent( ComplexComponent component ) {
        this.component = component;
    }

    public SimpleKnight getKnight() {
        return this.knight;
    }

    public void setKnight( SimpleKnight knight ) {
        this.knight = knight;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append( "{component:" )
                .append( Objects.toString( component ) )
                .append( ",knight:" )
                .append( Objects.toString( knight ) )
                .append( ",hidden:" )
                .append( Objects.toString( hiddenKnight ) )
                .append( "}" )
                .toString();
    }

}
