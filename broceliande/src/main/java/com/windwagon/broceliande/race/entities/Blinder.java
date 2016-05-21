package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumBlinderValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Blinder {

    @PMUEnumDefaultValue
    @PMUEnumValue( "SANS_OEILLERES" )
    @KaamelottEnumBlinderValue( com.windwagon.kaamelott.race.Blinder.NONE )
    NONE,

    @PMUEnumValue( "OEILLERES_CLASSIQUE" )
    @KaamelottEnumBlinderValue( com.windwagon.kaamelott.race.Blinder.WITH )
    WITH,

    @PMUEnumValue( "OEILLERES_AUSTRALIENNES" )
    @KaamelottEnumBlinderValue( com.windwagon.kaamelott.race.Blinder.AUSTRALIAN )
    AUSTRALIAN;

}
