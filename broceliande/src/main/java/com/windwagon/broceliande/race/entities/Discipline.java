package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumDisciplineValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Discipline {

    @PMUEnumValue( "ATTELE" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.TROT_ATTELE )
    TROT_ATTELE( true ),

    @PMUEnumValue( "MONTE" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.TROT_MONTE )
    TROT_MONTE( true ),

    @PMUEnumValue( "AMBLE" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.TROT_AMBLE )
    TROT_AMBLE( true ),

    @PMUEnumValue( "PLAT" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.PLAT )
    PLAT( false ),

    @PMUEnumValue( "HAIE" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.HAIES )
    HAIES( false ),

    @PMUEnumValue( "STEEPLECHASE" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.STEEPLE_CHASE )
    STEEPLE_CHASE( false ),

    @PMUEnumValue( "CROSS" )
    @KaamelottEnumDisciplineValue( com.windwagon.kaamelott.race.Discipline.CROSS_COUNTRY )
    CROSS_COUNTRY( false );

    private boolean trot;

    Discipline(boolean trot) {
        this.trot = trot;
    }

    public boolean isTrot() {
        return trot;
    }

}
