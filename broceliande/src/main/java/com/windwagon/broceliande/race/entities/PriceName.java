package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumPriceNameValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumNoValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

@PMUEnumNoValue( "ORDRE + TIRELIRE" )
public enum PriceName {

    @PMUEnumDefaultValue
    @PMUEnumValue( "DESORDRE" )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.DIRECT )
    DIRECT,

    @PMUEnumValue( "ORDRE" )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.ORDRE )
    ORDRE,

    @PMUEnumValue( { "BONUS", "BONUS 3" } )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.BONUS_TROIS )
    BONUS_3,

    @PMUEnumValue( "BONUS 4" )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.BONUS_QUATRE )
    BONUS_4,

    @PMUEnumValue( "BONUS 4SUR5" )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.BONUS_QUATRE_SUR_CINQ )
    BONUS_4_SUR_5,

    @PMUEnumValue( "TIERCE DEGRADE PLUS DE 3 CL" )
    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.DEGRADE )
    DEGRADE,

    @KaamelottEnumPriceNameValue( com.windwagon.kaamelott.race.PriceName.REMBOURSEMENT )
    REMBOURSEMENT;

}
