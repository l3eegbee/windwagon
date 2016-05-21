package com.windwagon.kaamelott.words;

import java.util.Arrays;

import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Race;

public class SimpleWords implements Words {

    private final static long serialVersionUID = 1l;

    protected double[] values;

    public SimpleWords( Race race ) {
        this( race, 0d );
    }

    public SimpleWords( Race race, double defValue ) {
        values = new double[ race.getHorses().size() ];
        Arrays.fill( values, defValue );
    }

    public void set( Horse horse, double value ) {
        values[ horse.getNumber() - 1 ] = value;
    }

    public double get( Horse horse ) {
        return values[ horse.getNumber() - 1 ];
    }

}
