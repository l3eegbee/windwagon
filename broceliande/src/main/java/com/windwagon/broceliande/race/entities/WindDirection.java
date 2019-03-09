package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumWindDirectionValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum WindDirection {

    @PMUEnumValue( "N" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.N )
    N,

    @PMUEnumValue( "NE" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.NE )
    NE,

    @PMUEnumValue( "E" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.E )
    E,

    @PMUEnumValue( "SE" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.SE )
    SE,

    @PMUEnumValue( "S" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.S )
    S,

    @PMUEnumValue( "SO" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.SW )
    SW,

    @PMUEnumValue( "O" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.W )
    W,

    @PMUEnumValue( "NO" )
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.NW )
    NW,

    @PMUEnumDefaultValue
    @KaamelottEnumWindDirectionValue( com.windwagon.kaamelott.race.WindDirection.UNKNOWN )
    UNKNOWN

}
