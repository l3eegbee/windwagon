package com.windwagon.avalon.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.BetWords;

public class SimpleKnight implements Knight {

    private Parameters constants = new Parameters();

    private List<SimpleParameter> listConstant = new ArrayList<>();

    private Map<String, SimpleParameter> mapConstant = new HashMap<>();

    private SimpleParameter parameter = new SimpleParameter();

    @Override
    public BetWords getWords( Race race ) {

        Horse horse = race.getHorses().first();
        return new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );

    }

    @Override
    public byte[] marshal() {

        if( parameter == null )
            return null;

        String value = parameter.getValue();
        if( value == null )
            return null;

        return value.getBytes();

    }

    @Override
    public void unmarshal( byte[] data ) {
        parameter = new SimpleParameter();
        parameter.setValue( new String( data ) );
    }

    public Parameters getConstants() {
        return constants;
    }

    public void setConstants( Parameters constants ) {
        this.constants = constants;
    }

    public List<SimpleParameter> getListConstant() {
        return this.listConstant;
    }

    public void setListConstant( List<SimpleParameter> listConstant ) {
        this.listConstant = listConstant;
    }

    public Map<String, SimpleParameter> getMapConstant() {
        return this.mapConstant;
    }

    public void setMapConstant( Map<String, SimpleParameter> mapConstant ) {
        this.mapConstant = mapConstant;
    }

    public SimpleParameter getParameter() {
        return this.parameter;
    }

    public void setParameter( SimpleParameter parameter ) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {

        String listValue = listConstant == null ? "null" : new StringBuilder()
                .append( "[" )
                .append(
                        String.join(
                                ",",
                                listConstant
                                        .stream()
                                        .map( SimpleParameter::toString )
                                        .collect( Collectors.toList() ) ) )
                .append( "]" )
                .toString();

        String mapValue = mapConstant == null ? "null" : new StringBuilder()
                .append( "{" )
                .append(
                        String.join( ",", mapConstant
                                .keySet()
                                .stream()
                                .sorted()
                                .map(
                                        k -> new StringBuilder()
                                                .append( k )
                                                .append( ":" )
                                                .append( Objects.toString( mapConstant.get( k ) ) )
                                                .toString() )
                                .collect( Collectors.toList() ) ) )
                .append( "}" )
                .toString();

        return new StringBuilder()
                .append( "{constants:" )
                .append( Objects.toString( constants ) )
                .append( ",list:" )
                .append( listValue )
                .append( ",map:" )
                .append( mapValue )
                .append( ",parameter:" )
                .append( Objects.toString( parameter ) )
                .append( "}" )
                .toString();

    }

}
