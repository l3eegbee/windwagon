package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumBreedValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Breed {

    @PMUEnumValue( "TROTTEUR ETRANGER" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.TROTTEUR_ETRANGER )
    TROTTEUR_ETRANGER,

    @PMUEnumValue( "TROTTEUR FRANCAIS" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.TROTTEUR_FRANCAIS )
    TROTTEUR_FRANCAIS,

    @PMUEnumValue( "PUR-SANG" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.PUR_SANG )
    PUR_SANG,

    @PMUEnumValue( "AQPS" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.AQPS )
    AQPS,

    @PMUEnumValue( "ARABE" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.ARABE )
    ARABE,

    @PMUEnumValue( "ANGLO ARABE" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.ANGLO_ARABE )
    ANGLO_ARABE,

    @PMUEnumValue( "ANGLO ARABE DE COMPLEMENT" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.ANGLO_ARABE_DE_COMPLEMENT )
    ANGLO_ARABE_DE_COMPLEMENT,

    @PMUEnumValue( "CHEVAL DE SELLE" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.CHEVAL_DE_SELLE )
    CHEVAL_DE_SELLE,

    @PMUEnumValue( "CHEVAL DE SELLE FRANCAIS" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.CHEVAL_DE_SELLE_FRANCAIS )
    CHEVAL_DE_SELLE_FRANCAIS,

    @PMUEnumValue( "ORIGINE ETRANGERE" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.ORIGINE_ETRANGERE )
    ORIGINE_ETRANGERE,

    @PMUEnumDefaultValue
    @PMUEnumValue( "INCONNU" )
    @KaamelottEnumBreedValue( com.windwagon.kaamelott.race.Breed.INCONNU )
    INCONNU;

}
