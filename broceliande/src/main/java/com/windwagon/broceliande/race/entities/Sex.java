package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumSexValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Sex {

    @PMUEnumValue( "FEMELLES" )
    @KaamelottEnumSexValue( com.windwagon.kaamelott.race.Sex.FEMALE )
    FEMALE,

    @PMUEnumValue( "MALES" )
    @KaamelottEnumSexValue( com.windwagon.kaamelott.race.Sex.MALE )
    MALE,

    @PMUEnumValue( "HONGRES" )
    @KaamelottEnumSexValue( com.windwagon.kaamelott.race.Sex.GELDING )
    GELDING

}
