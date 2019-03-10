package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumBetTypeValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumNoValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

// length = 6
// 10032019 TODO SUPER QUATRE, E_SUPER_QUATRE
@PMUEnumNoValue( { "REPORT", "TIC_TROIS", "E_REPORT", "E_REPORT_PLUS", "E_TIC_TROIS"} )
public enum BetType {

    @PMUEnumValue( { "SIMPLE_GAGNANT", "E_SIMPLE_GAGNANT" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.SIMPLE_GAGNANT )
    SIMPLE_GAGNANT( 1.5d ),

    @PMUEnumValue( { "SIMPLE_PLACE", "E_SIMPLE_PLACE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.SIMPLE_PLACE )
    SIMPLE_PLACE( 1.5d ),

    @PMUEnumValue( { "COUPLE_ORDRE", "COUPLE_ORDRE_INTERNATIONAL", "E_COUPLE_ORDRE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.COUPLE_ORDRE )
    COUPLE_ORDRE( 1.5d ),

    @PMUEnumValue( { "COUPLE_GAGNANT", "E_COUPLE_GAGNANT" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.COUPLE_GAGNANT )
    COUPLE_GAGNANT( 1.5d ),

    @PMUEnumValue( { "COUPLE_PLACE", "E_COUPLE_PLACE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.COUPLE_PLACE )
    COUPLE_PLACE( 1.5d ),

    @PMUEnumValue( { "TRIO_ORDRE", "TRIO_ORDRE_INTERNATIONAL", "E_TRIO_ORDRE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.TRIO_ORDRE )
    TRIO_ORDRE( 1.5d ),

    @PMUEnumValue( { "TRIO", "E_TRIO" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.TRIO )
    TRIO( 1.5d ),

    @PMUEnumValue( { "DEUX_SUR_QUATRE", "E_DEUX_SUR_QUATRE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.DEUX_SUR_QUATRE )
    DEUX_SUR_QUATRE( 3d ),

    @PMUEnumValue( { "MINI_MULTI", "MULTI", "E_MINI_MULTI", "E_MULTI" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.MULTI_EN_QUATRE )
    MULTI_EN_QUATRE( 3d ),

    @PMUEnumValue( { "MINI_MULTI", "MULTI", "E_MINI_MULTI", "E_MULTI" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.MULTI_EN_CINQ )
    MULTI_EN_CINQ( 3d ),

    @PMUEnumValue( { "MINI_MULTI", "MULTI", "E_MINI_MULTI", "E_MULTI" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.MULTI_EN_SIX )
    MULTI_EN_SIX( 3d ),

    @PMUEnumValue( { "MULTI", "E_MULTI" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.MULTI_EN_SEPT )
    MULTI_EN_SEPT( 3d ),

    @PMUEnumValue( { "PICK5", "E_PICK5" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.PICK5 )
    PICK5( 1d ),

    @PMUEnumValue( { "TIERCE", "CLASSIC_TIERCE", "E_TIERCE", "E_CLASSIC_TIERCE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.TIERCE )
    TIERCE( 1d ),

    @PMUEnumValue( { "QUARTE_PLUS", "E_QUARTE_PLUS" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.QUARTE )
    QUARTE( 1.3d ),
    
    @PMUEnumValue( { "SUPER_QUATRE", "E_SUPER_QUATRE" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.SUPER_QUATRE )
    SUPER_QUATRE( 1.0d ),

    @PMUEnumValue( { "QUINTE_PLUS", "E_QUINTE_PLUS" } )
    @KaamelottEnumBetTypeValue( com.windwagon.kaamelott.race.BetType.QUINTE )
    QUINTE( 2d );

    private double base;

    BetType(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

}
