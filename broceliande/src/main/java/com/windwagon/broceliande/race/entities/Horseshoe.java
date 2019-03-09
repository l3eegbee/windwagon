package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumHorseshoeValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Horseshoe {

    @PMUEnumDefaultValue
    @KaamelottEnumHorseshoeValue( com.windwagon.kaamelott.race.Horseshoe.ALL )
    ALL,

    @PMUEnumValue( "DEFERRE_ANTERIEURS" )
    @KaamelottEnumHorseshoeValue( com.windwagon.kaamelott.race.Horseshoe.NO_FORELEG )
    NO_FORELEG,

    @PMUEnumValue( "DEFERRE_POSTERIEURS" )
    @KaamelottEnumHorseshoeValue( com.windwagon.kaamelott.race.Horseshoe.NO_POSTERIOR )
    NO_POSTERIOR,

    @PMUEnumValue( "DEFERRE_ANTERIEURS_POSTERIEURS" )
    @KaamelottEnumHorseshoeValue( com.windwagon.kaamelott.race.Horseshoe.NONE )
    NONE

}
