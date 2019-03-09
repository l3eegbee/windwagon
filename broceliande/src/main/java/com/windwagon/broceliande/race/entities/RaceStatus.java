package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum RaceStatus {

    @PMUEnumValue( "A_PARTIR" )
    SCHEDULED,

    @PMUEnumValue( "EN_COURS" )
    STARTED,

    @PMUEnumValue( "SUSPENDU" )
    SUSPENDED,

    @PMUEnumValue( "ANNULEE" )
    CANCELED,

    @PMUEnumValue( "ARRIVEE" )
    FINISHED,

    @PMUEnumValue( "INCONNUE" )
    UNKNOWN

}
