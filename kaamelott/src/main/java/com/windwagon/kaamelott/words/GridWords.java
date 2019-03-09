package com.windwagon.kaamelott.words;

import com.windwagon.kaamelott.race.*;

import java.util.*;

public class GridWords implements Words {

    private final static long serialVersionUID = 1L;

    protected double[][] values;

    public GridWords( Race race ) {
        this( race, 0d );
    }

    public GridWords( Race race, double defValue ) {
        int size = race.getHorses().size();
        values = new double[ size ][ size ];
        for( double[] row: values )
            Arrays.fill( row, defValue );
    }

    public void set( Horse h1, Horse h2, double value ) {
        values[ h1.getNumber() - 1 ][ h2.getNumber() - 1 ] = value;
    }

    public double get( Horse h1, Horse h2 ) {
        return values[ h1.getNumber() - 1 ][ h2.getNumber() - 1 ];
    }

}
