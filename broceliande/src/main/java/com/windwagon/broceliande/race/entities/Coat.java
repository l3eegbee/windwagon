package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumCoatValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Coat {

    @PMUEnumValue( "ALEZAN" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN )
    ALEZAN,

    @PMUEnumValue( "AL BRU" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_BRULE )
    ALEZAN_BRULE,

    @PMUEnumValue( "AL CRL" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_CRIN_LAVE )
    ALEZAN_CRIN_LAVE,

    @PMUEnumValue( "AL CUI" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_CUIVRE )
    ALEZAN_CUIVRE,

    @PMUEnumValue( "AL FON" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_FONCE )
    ALEZAN_FONCE,

    @PMUEnumValue( "ALZMEL" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_MELANGE )
    ALEZAN_MELANGE,

    @PMUEnumValue( "ALZPIE" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ALEZAN_PIE )
    ALEZAN_PIE,

    @PMUEnumValue( "AUBERE" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.AUBERE )
    AUBERE,

    @PMUEnumValue( "BAI" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI )
    BAI,

    @PMUEnumValue( "BB/ALB" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_BRUN_ALEZAN_BRULE )
    BAI_BRUN_ALEZAN_BRULE,

    @PMUEnumValue( "BAI BR" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_BRUN )
    BAI_BRUN,

    @PMUEnumValue( "BAI BF" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_BRUN_RUBICAN )
    BAI_BRUN_RUBICAN,

    @PMUEnumValue( "BCE" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_CERISE )
    BAI_CERISE,

    @PMUEnumValue( "BAI CL" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_CLAIR )
    BAI_CLAIR,

    @PMUEnumValue( "BAI F." )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_FONCE )
    BAI_FONCE,

    @PMUEnumValue( "BAIMEL" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_MELANGE )
    BAI_MELANGE,

    @PMUEnumValue( "BAIPIE" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_PIE )
    BAI_PIE,

    @PMUEnumValue( "BAI R." )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.BAI_RUBICAN )
    BAI_RUBICAN,

    @PMUEnumValue( "GRIS" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.GRIS )
    GRIS,

    @PMUEnumValue( "GCL" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.GRIS_CLAIR )
    GRIS_CLAIR,

    @PMUEnumValue( "GR FER" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.GRIS_FER )
    GRIS_FER,

    @PMUEnumValue( "GR FON" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.GRIS_FONCE )
    GRIS_FONCE,

    @PMUEnumValue( "GR TRU" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.GRIS_TRUITE )
    GRIS_TRUITE,

    @PMUEnumValue( "NOIR" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.NOIR )
    NOIR,

    @PMUEnumValue( "ROUAN" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.ROUAN )
    ROUAN,

    @PMUEnumDefaultValue
    @PMUEnumValue( "INDET" )
    @KaamelottEnumCoatValue( com.windwagon.kaamelott.race.Coat.INCONNU )
    INCONNU;

}
