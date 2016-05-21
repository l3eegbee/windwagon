package com.windwagon.broceliande.race.builders;

import java.util.EnumSet;
import java.util.TreeSet;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Blinder;
import com.windwagon.broceliande.race.entities.Breed;
import com.windwagon.broceliande.race.entities.Coat;
import com.windwagon.broceliande.race.entities.Discipline;
import com.windwagon.broceliande.race.entities.Field;
import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.entities.Horseshoe;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Place;
import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.entities.PriceName;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.broceliande.race.entities.Sex;
import com.windwagon.broceliande.race.entities.Simple;
import com.windwagon.broceliande.race.entities.Type;
import com.windwagon.broceliande.race.entities.WindDirection;

public class Meeting_20150813_M1 extends MeetingBuilder {

    public static Meeting build() {

        Meeting meeting = new Meeting();

        meeting.setDate( parse( "13/08/2015 00:00:00 +0200" ) );
        meeting.setRacecourse( racecourse( "CLAIREFONTAINE", "FRANCE" ) );
        meeting.setNumber( 1 );
        meeting.setWindSpeed( 14.0 );
        meeting.setWindDirection( WindDirection.E );
        meeting.setTemperature( 23.0 );
        meeting.setClimat( "ONDEES ORAGEUSES" );
        meeting.setField( Field.BON_SOUPLE );

        // -- races --
        TreeSet<Race> races = new TreeSet<>();
        races.add( builderRace_R1( meeting ) );
        races.add( builderRace_R2( meeting ) );
        races.add( builderRace_R3( meeting ) );
        races.add( builderRace_R4( meeting ) );
        races.add( builderRace_R5( meeting ) );
        races.add( builderRace_R6( meeting ) );
        races.add( builderRace_R7( meeting ) );
        races.add( builderRace_R8( meeting ) );
        meeting.setRaces( races );

        return meeting;

    }

    /*
     * Race 1 - PRIX JOURNAL LE PAYS D'AUGE (PRIX HIGHEST HONOR)
     */

    public static Race builderRace_R1( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 1 );
        race.setName( "PRIX JOURNAL LE PAYS D'AUGE (PRIX HIGHEST HONOR)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 12:47:00 +0200" ) );
        // no real start
        race.setDistance( 1800.0 );
        race.setBenefit( 29000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.CONDITIONS ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R1_H1( race ) );
        horses.add( builderHorse_R1_H2( race ) );
        horses.add( builderHorse_R1_H3( race ) );
        horses.add( builderHorse_R1_H4( race ) );
        horses.add( builderHorse_R1_H5( race ) );
        horses.add( builderHorse_R1_H6( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.TRIO_ORDRE ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R1_O1( race ) );
        oddsSet.add( builderOdds_R1_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  5 ) );
        places.add( place( race,  2,  4, "DEUX_LONGUEURS" ) );
        places.add( place( race,  3,  2, "UNE_TETE" ) );
        places.add( place( race,  4,  1, "TROIS_LONGUEURS" ) );
        places.add( place( race,  5,  3, "DEUX_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race,  6,  6, "VINGT_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.0, "5" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.3, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.1, "5" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 3.1, "5 4" ) );
        prices.add( price( race, BetType.TRIO_ORDRE, PriceName.DIRECT, 7.0, "5 4 2" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 1
     * Horse 1 - PROGRESSION
     * HorseID - PROGRESSION
     */
    public static HorseID builderHorse_R1_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PROGRESSION" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "DANSILI" );
        horseID.setMother( "PRETTY FACE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 1 - PROGRESSION
     */

    public static Horse builderHorse_R1_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1250000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 1250000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "D.SMAGA" ) );
        horse.setOwner( owner( "K.ABDULLAH" ) );
        horse.setRancher( rancher( "JUDDMONTE FARMS" ) );
        horse.setJockey( jockey( "V.CHEMINAUD" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 2 - LISTAN
     * HorseID - LISTAN
     */
    public static HorseID builderHorse_R1_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LISTAN" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "LOPE DE VEGA" );
        horseID.setMother( "MACOTTE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 2 - LISTAN
     */

    public static Horse builderHorse_R1_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 2670000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1650000.0 );
        horse.setPlaceProfit( 1020000.0 );
        horse.setYearProfit( 2670000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "C.FERLAND (S)" ) );
        horse.setOwner( owner( "HARAS SAUBOUAS/MME DUBUC-GRASSA" ) );
        horse.setRancher( rancher( "HARAS DES SABLONNETS" ) );
        horse.setJockey( jockey( "J.AUGE" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 3 - BRONZINO
     * HorseID - BRONZINO
     */
    public static HorseID builderHorse_R1_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRONZINO" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "CREACHADOIR" );
        horseID.setMother( "BERENICE PANCRISIA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 3 - BRONZINO
     */

    public static Horse builderHorse_R1_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 2125000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 875000.0 );
        horse.setYearProfit( 2125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R.CHOTARD" ) );
        horse.setOwner( owner( "GR.PETIT" ) );
        horse.setRancher( rancher( "SCUDERIA MIRABELLA" ) );
        horse.setJockey( jockey( "O.PESLIER" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 4 - OBLONSKY
     * HorseID - OBLONSKY
     */
    public static HorseID builderHorse_R1_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "OBLONSKY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "LOPE DE VEGA" );
        horseID.setMother( "DANSEUSE INDIENNE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 4 - OBLONSKY
     */

    public static Horse builderHorse_R1_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 2250000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 1000000.0 );
        horse.setYearProfit( 2250000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.FABRE (S)" ) );
        horse.setOwner( owner( "BARON ED.DE ROTHSCHILD" ) );
        horse.setRancher( rancher( "S.C. DE L'ECURIE DE MEAUTRY" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 5 - INTO THE MYSTIC
     * HorseID - INTO THE MYSTIC
     */
    public static HorseID builderHorse_R1_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "INTO THE MYSTIC" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GALILEO" );
        horseID.setMother( "TAMAZIRTE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 5 - INTO THE MYSTIC
     */

    public static Horse builderHorse_R1_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 55.5 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1880000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1300000.0 );
        horse.setPlaceProfit( 580000.0 );
        horse.setYearProfit( 1880000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JC.ROUGET (S)" ) );
        horse.setOwner( owner( "RC.PORTER II" ) );
        horse.setRancher( rancher( "ECURIE LA VALLEE MARTIGNY EARL" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 6 - FELINGARIE
     * HorseID - FELINGARIE
     */
    public static HorseID builderHorse_R1_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "FELINGARIE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LINNGARI" );
        horseID.setMother( "FELINDRA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 6 - FELINGARIE
     */

    public static Horse builderHorse_R1_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 125000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 125000.0 );
        horse.setYearProfit( 125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JP.GALLORINI (S)" ) );
        horse.setOwner( owner( "D.DAHAN" ) );
        horse.setRancher( rancher( "MR ANDRE ABADIE" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 1
     * Odds 1 - 13/08/2015 12:31:14 +0200
     */

    public static Odds builderOdds_R1_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:14 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 7.8 ) );
        simples.add( simple( odds, "2", 8.7 ) );
        simples.add( simple( odds, "3", 21.4 ) );
        simples.add( simple( odds, "4", 3.1 ) );
        simples.add( simple( odds, "5", 1.8 ) );
        simples.add( simple( odds, "6", 29.1 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 1
     * Odds 2 - 13/08/2015 12:47:33 +0200
     */

    public static Odds builderOdds_R1_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:47:33 +0200" ) );
        odds.setTotal( 83511.89 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 8.9 ) );
        simples.add( simple( odds, "2", 5.1 ) );
        simples.add( simple( odds, "3", 15.7 ) );
        simples.add( simple( odds, "4", 3.4 ) );
        simples.add( simple( odds, "5", 2.0 ) );
        simples.add( simple( odds, "6", 29.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2 - PRIX DODSON ET HORELL (PRIX BERING)
     */

    public static Race builderRace_R2( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 2 );
        race.setName( "PRIX DODSON ET HORELL (PRIX BERING)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 13:15:00 +0200" ) );
        // no real start
        race.setDistance( 2200.0 );
        race.setBenefit( 29000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.CONDITIONS ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R2_H1( race ) );
        horses.add( builderHorse_R2_H2( race ) );
        horses.add( builderHorse_R2_H3( race ) );
        horses.add( builderHorse_R2_H4( race ) );
        horses.add( builderHorse_R2_H5( race ) );
        horses.add( builderHorse_R2_H6( race ) );
        horses.add( builderHorse_R2_H7( race ) );
        horses.add( builderHorse_R2_H8( race ) );
        horses.add( builderHorse_R2_H9( race ) );
        horses.add( builderHorse_R2_H10( race ) );
        horses.add( builderHorse_R2_H11( race ) );
        horses.add( builderHorse_R2_H12( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R2_O1( race ) );
        oddsSet.add( builderOdds_R2_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 12 ) );
        places.add( place( race,  2,  4, "DEMI_LONGUEUR" ) );
        places.add( place( race,  3,  3, "COURTE_ENCOLURE" ) );
        places.add( place( race,  4,  7, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race,  5,  9, "ENCOLURE" ) );
        places.add( place( race,  6,  1, "UN_NEZ" ) );
        places.add( place( race,  7,  5, "UNE_LONGUEUR" ) );
        places.add( place( race,  8, 11, "SEPT_LONGUEURS" ) );
        places.add( place( race,  9,  8, "TROIS_LONGUEURS" ) );
        places.add( place( race, 10, 10, "DIX_LONGUEURS" ) );
        places.add( place( race, 11,  2, "DOUZE_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 4.5, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.0, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "4" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 4.5, "12" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 22.1, "12 4" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 4.5, "12" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 9.2, "12 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.6, "12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 21.8, "12 3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.2, "12 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.0, "3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.5, "4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 12.7, "4 3" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 9.2, "12 4" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 164.4, "12 4 3" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "12" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "12 3" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "12 4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "12 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "3" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "3 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "4 3" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.1, "4 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "7" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 193.5, "12 4 3 7" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 38.7, "12 4 3 7" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 12.9, "12 4 3 7" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 2
     * Horse 1 - BURROWS PARK
     * HorseID - BURROWS PARK
     */
    public static HorseID builderHorse_R2_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BURROWS PARK" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "ASTARABAD" );
        horseID.setMother( "LA VIE DE BOITRON" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 1 - BURROWS PARK
     */

    public static Horse builderHorse_R2_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 3620000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1500000.0 );
        horse.setPlaceProfit( 2120000.0 );
        horse.setYearProfit( 3620000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.COUETIL (S)" ) );
        horse.setOwner( owner( "ECURIE CERDEVAL/P. LEJOP" ) );
        horse.setRancher( rancher( "MME JULIE MORGAN" ) );
        horse.setJockey( jockey( "A.FOUASSIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 2 - FANTASTIC LOVE
     * HorseID - FANTASTIC LOVE
     */
    public static HorseID builderHorse_R2_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "FANTASTIC LOVE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "TOUT SEUL" );
        horseID.setMother( "EMPIRE IN LOVE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 2 - FANTASTIC LOVE
     */

    public static Horse builderHorse_R2_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1910800.0 );
        horse.setPreviousYearProfit( 907800.0 );
        horse.setVictoryProfit( 1190000.0 );
        horse.setPlaceProfit( 720800.0 );
        horse.setYearProfit( 1003000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MLLE C.O'HALLORAN" ) );
        horse.setOwner( owner( "M.GUARNIERI" ) );
        horse.setRancher( rancher( "MR ROBERTO BERNARDONI" ) );
        horse.setJockey( jockey( "F.LEFEBVRE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 3 - KLOUD GATE
     * HorseID - KLOUD GATE
     */
    public static HorseID builderHorse_R2_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "KLOUD GATE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ASTRONOMER ROYAL" );
        horseID.setMother( "TALKATA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 3 - KLOUD GATE
     */

    public static Horse builderHorse_R2_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 5084900.0 );
        horse.setPreviousYearProfit( 3190000.0 );
        horse.setVictoryProfit( 2910000.0 );
        horse.setPlaceProfit( 2174900.0 );
        horse.setYearProfit( 1894900.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G.BIETOLINI" ) );
        horse.setOwner( owner( "RAZZA DELLA SILA SRL" ) );
        horse.setRancher( rancher( "MR THIERRY DE LA HERONNIERE" ) );
        horse.setJockey( jockey( "U.RISPOLI" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 4 - QAWAAREB
     * HorseID - QAWAAREB
     */
    public static HorseID builderHorse_R2_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "QAWAAREB" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "TEOFILO" );
        horseID.setMother( "MASAAFAT" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 4 - QAWAAREB
     */

    public static Horse builderHorse_R2_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1125000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 750000.0 );
        horse.setPlaceProfit( 375000.0 );
        horse.setYearProfit( 1125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JC.ROUGET (S)" ) );
        horse.setOwner( owner( "H.AL MAKTOUM" ) );
        horse.setRancher( rancher( "SHADWELL ESTATE CO. LTD" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 5 - CAVTAT
     * HorseID - CAVTAT
     */
    public static HorseID builderHorse_R2_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAVTAT" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "DOCTOR DINO" );
        horseID.setMother( "STEADFAST" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 2
     * Horse 5 - CAVTAT
     */

    public static Horse builderHorse_R2_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1745000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1050000.0 );
        horse.setPlaceProfit( 695000.0 );
        horse.setYearProfit( 1745000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E.LEENDERS" ) );
        horse.setOwner( owner( "D.MCMILLAN" ) );
        horse.setRancher( rancher( "MR JAMES DONNARY" ) );
        horse.setJockey( jockey( "M.GUYON" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 6 - MAGNETICJIM
     * HorseID - MAGNETICJIM
     */
    public static HorseID builderHorse_R2_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MAGNETICJIM" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "GALILEO" );
        horseID.setMother( "DIBENOISE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 2
     * Horse 6 - MAGNETICJIM
     */

    public static Horse builderHorse_R2_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 920000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 920000.0 );
        horse.setYearProfit( 920000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P.BARY (S)" ) );
        horse.setOwner( owner( "HSPIRIT" ) );
        horse.setRancher( rancher( "MME GILLES FORIEN" ) );
        horse.setJockey( jockey( "S.PASQUIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 7 - DARAMAKFI
     * HorseID - DARAMAKFI
     */
    public static HorseID builderHorse_R2_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "DARAMAKFI" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MAKFI" );
        horseID.setMother( "DARAKIYLA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 7 - DARAMAKFI
     */

    public static Horse builderHorse_R2_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 55.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1930000.0 );
        horse.setPreviousYearProfit( 1930000.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 680000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.HEAD (S)" ) );
        horse.setOwner( owner( "CHEIK ABK .AL THANI" ) );
        horse.setRancher( rancher( "RAZZA PALLORSI SNC" ) );
        horse.setJockey( jockey( "O.PESLIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 8 - DOGMA
     * HorseID - DOGMA
     */
    public static HorseID builderHorse_R2_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "DOGMA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MOUNT NELSON" );
        horseID.setMother( "PENNE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 8 - DOGMA
     */

    public static Horse builderHorse_R2_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 55.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 905000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 500000.0 );
        horse.setPlaceProfit( 405000.0 );
        horse.setYearProfit( 905000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S.WATTEL" ) );
        horse.setOwner( owner( "FAMILLE ROTHSCHILD" ) );
        horse.setRancher( rancher( "FAMILLE ROTHSCHILD" ) );
        horse.setJockey( jockey( "T.BACHELOT" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 9 - PINK ROSE
     * HorseID - PINK ROSE
     */
    public static HorseID builderHorse_R2_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PINK ROSE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SHIROCCO" );
        horseID.setMother( "LA NUIT ROSE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 9 - PINK ROSE
     */

    public static Horse builderHorse_R2_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 55.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 2170000.0 );
        horse.setPreviousYearProfit( 1930000.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 920000.0 );
        horse.setYearProfit( 240000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.FABRE (S)" ) );
        horse.setOwner( owner( "GODOLPHIN SNC" ) );
        horse.setRancher( rancher( "DARLEY STUD MANAGEMENT CO. LTD" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 10 - AMAMI
     * HorseID - AMAMI
     */
    public static HorseID builderHorse_R2_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMAMI" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "PEINTRE CELEBRE" );
        horseID.setMother( "AIRLINE HOSTESS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 10 - AMAMI
     */

    public static Horse builderHorse_R2_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        horse.setStable( "A" );
        horse.setWeight( 55.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1250000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 1250000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "FH.GRAFFARD (S)" ) );
        horse.setOwner( owner( "WILDENSTEIN STABLES LIMIT" ) );
        horse.setRancher( rancher( "DAYTON INVESTMENTS LTD" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 11 - PERLE RARE
     * HorseID - PERLE RARE
     */
    public static HorseID builderHorse_R2_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PERLE RARE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DISTORTED HUMOR" );
        horseID.setMother( "PEINTURE RARE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 11 - PERLE RARE
     */

    public static Horse builderHorse_R2_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        horse.setStable( "A" );
        horse.setWeight( 55.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1250000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 1250000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.ROYER DUPRE DE" ) );
        horse.setOwner( owner( "WILDENSTEIN STABLES LIMIT" ) );
        horse.setRancher( rancher( "DAYTON INVESTMENTS LTD" ) );
        horse.setJockey( jockey( "M.BERTO" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 12 - PACIFIC ANGEL
     * HorseID - PACIFIC ANGEL
     */
    public static HorseID builderHorse_R2_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PACIFIC ANGEL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DALAKHANI" );
        horseID.setMother( "PERSTROVKA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 12 - PACIFIC ANGEL
     */

    public static Horse builderHorse_R2_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1000000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1000000.0 );
        horse.setYearProfit( 1000000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.DELZANGLES" ) );
        horse.setOwner( owner( "BALLYMORE THOROUGHBRED LT" ) );
        horse.setRancher( rancher( "DAYTON INVESTMENTS LTD" ) );
        horse.setJockey( jockey( "A.BADEL" ) );

        return horse;

    }

    /*
     * Race 2
     * Odds 1 - 13/08/2015 12:31:16 +0200
     */

    public static Odds builderOdds_R2_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:16 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 10.2 ) );
        simples.add( simple( odds, "2", 14.2 ) );
        simples.add( simple( odds, "3", 25.7 ) );
        simples.add( simple( odds, "4", 4.6 ) );
        simples.add( simple( odds, "5", 15.1 ) );
        simples.add( simple( odds, "6", 14.7 ) );
        simples.add( simple( odds, "7", 9.0 ) );
        simples.add( simple( odds, "8", 15.6 ) );
        simples.add( simple( odds, "9", 9.3 ) );
        simples.add( simple( odds, "10", 5.9 ) );
        simples.add( simple( odds, "11", 11.3 ) );
        simples.add( simple( odds, "12", 6.1 ) );
        simples.add( simple( odds, "A", 3.9 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2
     * Odds 2 - 13/08/2015 13:18:02 +0200
     */

    public static Odds builderOdds_R2_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 13:18:02 +0200" ) );
        odds.setTotal( 145078.49 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 10.5 ) );
        simples.add( simple( odds, "2", 28.9 ) );
        simples.add( simple( odds, "3", 27.9 ) );
        simples.add( simple( odds, "4", 3.9 ) );
        simples.add( simple( odds, "5", 22.6 ) );
        simples.add( simple( odds, "6", 15.5 ) );
        simples.add( simple( odds, "7", 11.2 ) );
        simples.add( simple( odds, "8", 21.2 ) );
        simples.add( simple( odds, "9", 12.4 ) );
        simples.add( simple( odds, "10", 4.6 ) );
        simples.add( simple( odds, "11", 14.8 ) );
        simples.add( simple( odds, "12", 4.5 ) );
        simples.add( simple( odds, "A", 3.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3 - PRIX ECOLE BLONDEAU (PRIX DE LA COTE FLEURIE)
     */

    public static Race builderRace_R3( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 3 );
        race.setName( "PRIX ECOLE BLONDEAU (PRIX DE LA COTE FLEURIE)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 13:50:00 +0200" ) );
        // no real start
        race.setDistance( 2400.0 );
        race.setBenefit( 60000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.HANDICAP ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R3_H1( race ) );
        horses.add( builderHorse_R3_H2( race ) );
        horses.add( builderHorse_R3_H3( race ) );
        horses.add( builderHorse_R3_H4( race ) );
        horses.add( builderHorse_R3_H5( race ) );
        horses.add( builderHorse_R3_H6( race ) );
        horses.add( builderHorse_R3_H7( race ) );
        horses.add( builderHorse_R3_H8( race ) );
        horses.add( builderHorse_R3_H9( race ) );
        horses.add( builderHorse_R3_H10( race ) );
        horses.add( builderHorse_R3_H11( race ) );
        horses.add( builderHorse_R3_H12( race ) );
        horses.add( builderHorse_R3_H13( race ) );
        horses.add( builderHorse_R3_H14( race ) );
        horses.add( builderHorse_R3_H15( race ) );
        horses.add( builderHorse_R3_H16( race ) );
        horses.add( builderHorse_R3_H17( race ) );
        horses.add( builderHorse_R3_H18( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX,
                BetType.MULTI_EN_SEPT,
                BetType.TIERCE,
                BetType.QUARTE,
                BetType.QUINTE ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R3_O1( race ) );
        oddsSet.add( builderOdds_R3_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  1 ) );
        places.add( place( race,  2,  5, "COURTE_ENCOLURE" ) );
        places.add( place( race,  3,  8, "UNE_LONGUEUR" ) );
        places.add( place( race,  4,  4, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  5, 13, "COURTE_ENCOLURE" ) );
        places.add( place( race,  6, 10, "COURTE_ENCOLURE" ) );
        places.add( place( race,  7, 16, "UNE_LONGUEUR" ) );
        places.add( place( race,  8, 18, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  9, 14, "UNE_LONGUEUR" ) );
        places.add( place( race, 10,  2, "ENCOLURE" ) );
        places.add( place( race, 11, 15, "UNE_LONGUEUR_TROIS_QUARTS" ) );
        places.add( place( race, 12,  3, "UNE_LONGUEUR_TROIS_QUARTS" ) );
        places.add( place( race, 13,  9, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race, 14, 12, "QUATRE_LONGUEURS" ) );
        places.add( place( race, 15,  6, "DEUX_LONGUEURS" ) );
        places.add( place( race, 16,  7, "DEUX_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race, 17, 11, "ENCOLURE" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 10.3, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.2, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.2, "5" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 13.2, "8" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 0.0, "1" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 52.4, "1 5" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 0.0, "1" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 31.4, "1 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 14.6, "1 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 81.6, "1 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 59.8, "5 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "8" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "1 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 599.1, "1 5 8" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "1 4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "1 5" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "1 8" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "5 4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "5 8" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.9, "8 4" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 861.0, "1 5 8 4" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 172.2, "1 5 8 4" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 57.4, "1 5 8 4" ) );
        prices.add( price( race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 24.6, "1 5 8 4" ) );
        prices.add( price( race, BetType.TIERCE, PriceName.DIRECT, 0.0, "1 5" ) );
        prices.add( price( race, BetType.TIERCE, PriceName.DIRECT, 191.1, "1 5 8" ) );
        prices.add( price( race, BetType.TIERCE, PriceName.ORDRE, 955.5, "1 5 8" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.DIRECT, 232.8, "1 5 8 4" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.ORDRE, 3160.6, "1 5 8 4" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.BONUS_3, 58.2, "1 5 8" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.DIRECT, 671.5, "1 5 8 4 13" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.ORDRE, 45848.7, "1 5 8 4 13" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_3, 14.4, "1 5 8" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_4, 43.2, "1 5 8 4" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_4_SUR_5, 21.6, "1 5 4 13" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_4_SUR_5, 21.6, "1 5 8 13" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_4_SUR_5, 21.6, "1 8 4 13" ) );
        prices.add( price( race, BetType.QUINTE, PriceName.BONUS_4_SUR_5, 21.6, "5 8 4 13" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 3
     * Horse 1 - GAIUS CAESAR
     * HorseID - GAIUS CAESAR
     */
    public static HorseID builderHorse_R3_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "GAIUS CAESAR" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "SOLDIER OF FORTUNE" );
        horseID.setMother( "CAROUSEL GIRL" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 1 - GAIUS CAESAR
     */

    public static Horse builderHorse_R3_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 15 );
        // no stable
        horse.setWeight( 61.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 7012000.0 );
        horse.setPreviousYearProfit( 400000.0 );
        horse.setVictoryProfit( 6292000.0 );
        horse.setPlaceProfit( 720000.0 );
        horse.setYearProfit( 6612000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "W.HICKST" ) );
        horse.setOwner( owner( "STALL KONIGSFORST" ) );
        horse.setRancher( rancher( "HARAS DU LOGIS SAINT GERMAIN" ) );
        horse.setJockey( jockey( "V.CHEMINAUD" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 2 - ARCENFETE
     * HorseID - ARCENFETE
     */
    public static HorseID builderHorse_R3_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARCENFETE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ARCH" );
        horseID.setMother( "SOFT PLEASURE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 2 - ARCENFETE
     */

    public static Horse builderHorse_R3_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1820000.0 );
        horse.setPreviousYearProfit( 680000.0 );
        horse.setVictoryProfit( 800000.0 );
        horse.setPlaceProfit( 1020000.0 );
        horse.setYearProfit( 1140000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "C.LAFFON-PARIAS" ) );
        horse.setOwner( owner( "WERTHEIMER & FRERE" ) );
        horse.setRancher( rancher( "WERTHEIMER & FRERE" ) );
        horse.setJockey( jockey( "M.GUYON" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 3 - MAKFLAWLESS
     * HorseID - MAKFLAWLESS
     */
    public static HorseID builderHorse_R3_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MAKFLAWLESS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "MAKFI" );
        horseID.setMother( "DEE FLAWLESS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 3
     * Horse 3 - MAKFLAWLESS
     */

    public static Horse builderHorse_R3_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 58.5 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1240000.0 );
        horse.setPreviousYearProfit( 375000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1240000.0 );
        horse.setYearProfit( 865000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.GOURRAUD (S)" ) );
        horse.setOwner( owner( "ECURIE VICTORIA DREAMS" ) );
        horse.setRancher( rancher( "MR JEAN-PHILIPPE DUBOIS" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 4 - MINOTAUR
     * HorseID - MINOTAUR
     */
    public static HorseID builderHorse_R3_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MINOTAUR" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "AZAMOUR" );
        horseID.setMother( "MYCENAE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 4 - MINOTAUR
     */

    public static Horse builderHorse_R3_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 57.5 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 4000000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 3520000.0 );
        horse.setPlaceProfit( 480000.0 );
        horse.setYearProfit( 4000000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N.CLEMENT (S)" ) );
        horse.setOwner( owner( "MLLE C.WILLS" ) );
        horse.setRancher( rancher( "ST CLARE HALL STUD" ) );
        horse.setJockey( jockey( "T.THULLIEZ" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 5 - PARZIVAL
     * HorseID - PARZIVAL
     */
    public static HorseID builderHorse_R3_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PARZIVAL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MYBOYCHARLIE" );
        horseID.setMother( "SLYTA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 5 - PARZIVAL
     */

    public static Horse builderHorse_R3_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 17 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 4926100.0 );
        horse.setPreviousYearProfit( 1385000.0 );
        horse.setVictoryProfit( 1650000.0 );
        horse.setPlaceProfit( 3276100.0 );
        horse.setYearProfit( 3541100.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A&G.BOTTI (S)" ) );
        horse.setOwner( owner( "SCUDERIA MAGENTA/DIOSCURI SRL" ) );
        horse.setRancher( rancher( "S.F. BLOODSTOCK LLC" ) );
        horse.setJockey( jockey( "C.DEMURO" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 6 - KOUROS JELOIS
     * HorseID - KOUROS JELOIS
     */
    public static HorseID builderHorse_R3_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "KOUROS JELOIS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "HANNOUMA" );
        horseID.setMother( "ANOWA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 6 - KOUROS JELOIS
     */

    public static Horse builderHorse_R3_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 3365000.0 );
        horse.setPreviousYearProfit( 750000.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 2115000.0 );
        horse.setYearProfit( 2615000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.GOURRAUD (S)" ) );
        horse.setOwner( owner( "P.LARROUDE" ) );
        horse.setRancher( rancher( "MR ROGER JEAN" ) );
        horse.setJockey( jockey( "S.PASQUIER" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 7 - ABRAHAM
     * HorseID - ABRAHAM
     */
    public static HorseID builderHorse_R3_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ABRAHAM" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "HERNANDO" );
        horseID.setMother( "GUANA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 7 - ABRAHAM
     */

    public static Horse builderHorse_R3_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( true );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1880000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 630000.0 );
        horse.setYearProfit( 1880000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "S.CERULIS" ) );
        horse.setOwner( owner( "BALLYGALLON STUD LTD" ) );
        horse.setRancher( rancher( "BALLYGALLON STUD LTD" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 8 - SANS PEUR
     * HorseID - SANS PEUR
     */
    public static HorseID builderHorse_R3_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SANS PEUR" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "HALLING" );
        horseID.setMother( "BLUE LULLABY" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 8 - SANS PEUR
     */

    public static Horse builderHorse_R3_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 13 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1250000.0 );
        horse.setPreviousYearProfit( 1250000.0 );
        horse.setVictoryProfit( 1250000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S.WATTEL" ) );
        horse.setOwner( owner( "D. SUTHERLAND/C. WILSON" ) );
        horse.setRancher( rancher( "D & C BLOODSTOCK LLP" ) );
        horse.setJockey( jockey( "T.BACHELOT" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 9 - CHEGA DE SAUDADE
     * HorseID - CHEGA DE SAUDADE
     */
    public static HorseID builderHorse_R3_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHEGA DE SAUDADE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "FASTNET ROCK" );
        horseID.setMother( "SHAKE THE MOON" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 9 - CHEGA DE SAUDADE
     */

    public static Horse builderHorse_R3_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 18 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1850000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1150000.0 );
        horse.setPlaceProfit( 700000.0 );
        horse.setYearProfit( 1850000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.COUETIL (S)" ) );
        horse.setOwner( owner( "FAMILLE MOUSSAC/A.MENDES" ) );
        horse.setRancher( rancher( "HARAS DU MEZERAY S.A." ) );
        horse.setJockey( jockey( "A.FOUASSIER" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 10 - MORIGNY
     * HorseID - MORIGNY
     */
    public static HorseID builderHorse_R3_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MORIGNY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ROYAL APPLAUSE" );
        horseID.setMother( "MAD EXISTENCE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 10 - MORIGNY
     */

    public static Horse builderHorse_R3_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 55.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 4620000.0 );
        horse.setPreviousYearProfit( 1780000.0 );
        horse.setVictoryProfit( 3100000.0 );
        horse.setPlaceProfit( 1520000.0 );
        horse.setYearProfit( 2840000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "C.FERLAND (S)" ) );
        horse.setOwner( owner( "G.AUGUSTIN-NORMAND" ) );
        horse.setRancher( rancher( "KILDARAGH STUD" ) );
        horse.setJockey( jockey( "G.BENOIST" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 11 - ELDACAR
     * HorseID - ELDACAR
     */
    public static HorseID builderHorse_R3_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ELDACAR" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "VERGLAS" );
        horseID.setMother( "SERACINA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 3
     * Horse 11 - ELDACAR
     */

    public static Horse builderHorse_R3_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 55.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 615000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 615000.0 );
        horse.setYearProfit( 615000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.DELZANGLES" ) );
        horse.setOwner( owner( "STUD RDI" ) );
        horse.setRancher( rancher( "PETRA BLOODSTOCK AGENCY LTD" ) );
        horse.setJockey( jockey( "U.RISPOLI" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 12 - ALARCOS
     * HorseID - ALARCOS
     */
    public static HorseID builderHorse_R3_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALARCOS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MR SIDNEY" );
        horseID.setMother( "ALFAGUARA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 12 - ALARCOS
     */

    public static Horse builderHorse_R3_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 54.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1890000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 950000.0 );
        horse.setPlaceProfit( 940000.0 );
        horse.setYearProfit( 1890000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME G.RARICK" ) );
        horse.setOwner( owner( "MLLE K.HOSTE" ) );
        horse.setRancher( rancher( "SARL DARPAT FRANCE" ) );
        horse.setJockey( jockey( "M.FOREST" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 13 - PRECIOUS KING
     * HorseID - PRECIOUS KING
     */
    public static HorseID builderHorse_R3_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PRECIOUS KING" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "KING'S BEST" );
        horseID.setMother( "PROMESSE DE L'AUBE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 13 - PRECIOUS KING
     */

    public static Horse builderHorse_R3_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 54.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 920000.0 );
        horse.setPreviousYearProfit( 800000.0 );
        horse.setVictoryProfit( 800000.0 );
        horse.setPlaceProfit( 120000.0 );
        horse.setYearProfit( 120000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.HAMMOND (S)" ) );
        horse.setOwner( owner( "GESTUT AMMERLAND" ) );
        horse.setRancher( rancher( "GESTUT AMMERLAND" ) );
        horse.setJockey( jockey( "I.MENDIZABAL" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 14 - WHIPEARL
     * HorseID - WHIPEARL
     */
    public static HorseID builderHorse_R3_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "WHIPEARL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "WHIPPER" );
        horseID.setMother( "MISS CLEM'S" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 14 - WHIPEARL
     */

    public static Horse builderHorse_R3_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 53.5 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 940000.0 );
        horse.setPreviousYearProfit( 400000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 940000.0 );
        horse.setYearProfit( 540000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "P.SOGORB" ) );
        horse.setOwner( owner( "J.N..TEMAM" ) );
        horse.setRancher( rancher( "S.C.E.A DES BISSONS" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 15 - WINTER MAGIC
     * HorseID - WINTER MAGIC
     */
    public static HorseID builderHorse_R3_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "WINTER MAGIC" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SOLDIER OF FORTUNE" );
        horseID.setMother( "MASSANA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_BRUN_ALEZAN_BRULE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 15 - WINTER MAGIC
     */

    public static Horse builderHorse_R3_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 53.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 2240000.0 );
        horse.setPreviousYearProfit( 145000.0 );
        horse.setVictoryProfit( 1150000.0 );
        horse.setPlaceProfit( 1090000.0 );
        horse.setYearProfit( 2095000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "T.CASTANHEIRA (S)" ) );
        horse.setOwner( owner( "V.VEERAMOOTOO" ) );
        horse.setRancher( rancher( "HARAS DU LOGIS SAINT GERMAIN" ) );
        horse.setJockey( jockey( "A.HAMELIN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 16 - ALBUFERA
     * HorseID - ALBUFERA
     */
    public static HorseID builderHorse_R3_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALBUFERA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ALEXANDROS" );
        horseID.setMother( "JACIRA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_CLAIR );

        return horseID;

    }


    /*
     * Race 3
     * Horse 16 - ALBUFERA
     */

    public static Horse builderHorse_R3_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 16 );
        // no stable
        horse.setWeight( 52.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 2955000.0 );
        horse.setPreviousYearProfit( 780000.0 );
        horse.setVictoryProfit( 1150000.0 );
        horse.setPlaceProfit( 1805000.0 );
        horse.setYearProfit( 2175000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P.VAN DE POELE (S)" ) );
        horse.setOwner( owner( "MME MB.RASCHLE GRAND" ) );
        horse.setRancher( rancher( "MR FELIX SANZ BLANCO" ) );
        horse.setJockey( jockey( "A.BADEL" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 17 - SWINGKING
     * HorseID - SWINGKING
     */
    public static HorseID builderHorse_R3_H17_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SWINGKING" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "MYBOYCHARLIE" );
        horseID.setMother( "SALUTE THE SUN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 17 - SWINGKING
     */

    public static Horse builderHorse_R3_H17( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H17_ID() );
        horse.setNumber( 17 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 52.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 1355000.0 );
        horse.setPreviousYearProfit( 855000.0 );
        horse.setVictoryProfit( 500000.0 );
        horse.setPlaceProfit( 855000.0 );
        horse.setYearProfit( 500000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.FIGGE" ) );
        horse.setOwner( owner( "M.HAENNI" ) );
        horse.setRancher( rancher( "LORD HUNTINGDON" ) );
        horse.setJockey( jockey( "E.HARDOUIN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 18 - BRASS BELL
     * HorseID - BRASS BELL
     */
    public static HorseID builderHorse_R3_H18_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRASS BELL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FOOTSTEPSINTHESAND" );
        horseID.setMother( "CHEYRAC" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 3
     * Horse 18 - BRASS BELL
     */

    public static Horse builderHorse_R3_H18( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H18_ID() );
        horse.setNumber( 18 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 14 );
        // no stable
        horse.setWeight( 51.0 );
        horse.setDistance( 2400.0 );
        horse.setCareerProfit( 650000.0 );
        horse.setPreviousYearProfit( 250000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 650000.0 );
        horse.setYearProfit( 400000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.DOUMEN (S)" ) );
        horse.setOwner( owner( "PH.VOGT" ) );
        horse.setRancher( rancher( "HARAS DU MONT DIT MONT" ) );
        horse.setJockey( jockey( "A.CRASTUS" ) );

        return horse;

    }

    /*
     * Race 3
     * Odds 1 - 13/08/2015 12:31:18 +0200
     */

    public static Odds builderOdds_R3_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:18 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 10.5 ) );
        simples.add( simple( odds, "2", 12.2 ) );
        simples.add( simple( odds, "3", 19.5 ) );
        simples.add( simple( odds, "4", 7.3 ) );
        simples.add( simple( odds, "5", 10.6 ) );
        simples.add( simple( odds, "6", 7.8 ) );
        simples.add( simple( odds, "7", 14.1 ) );
        simples.add( simple( odds, "8", 36.4 ) );
        simples.add( simple( odds, "9", 14.2 ) );
        simples.add( simple( odds, "10", 9.7 ) );
        simples.add( simple( odds, "11", 15.5 ) );
        simples.add( simple( odds, "12", 42.7 ) );
        simples.add( simple( odds, "13", 22.5 ) );
        simples.add( simple( odds, "14", 24.4 ) );
        simples.add( simple( odds, "15", 18.3 ) );
        simples.add( simple( odds, "16", 17.3 ) );
        simples.add( simple( odds, "18", 22.8 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3
     * Odds 2 - 13/08/2015 13:57:18 +0200
     */

    public static Odds builderOdds_R3_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 13:57:18 +0200" ) );
        odds.setTotal( 503928.63 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 10.3 ) );
        simples.add( simple( odds, "2", 11.4 ) );
        simples.add( simple( odds, "3", 19.7 ) );
        simples.add( simple( odds, "4", 6.9 ) );
        simples.add( simple( odds, "5", 7.4 ) );
        simples.add( simple( odds, "6", 10.3 ) );
        simples.add( simple( odds, "7", 17.6 ) );
        simples.add( simple( odds, "8", 54.0 ) );
        simples.add( simple( odds, "9", 12.2 ) );
        simples.add( simple( odds, "10", 9.0 ) );
        simples.add( simple( odds, "11", 14.0 ) );
        simples.add( simple( odds, "12", 42.9 ) );
        simples.add( simple( odds, "13", 34.2 ) );
        simples.add( simple( odds, "14", 19.9 ) );
        simples.add( simple( odds, "15", 23.8 ) );
        simples.add( simple( odds, "16", 17.4 ) );
        simples.add( simple( odds, "18", 27.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4 - PRIX CARREFOUR MARKET DE TOURGEVILLE (PRIX DES FUSCHIAS)
     */

    public static Race builderRace_R4( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 4 );
        race.setName( "PRIX CARREFOUR MARKET DE TOURGEVILLE (PRIX DES FUSCHIAS)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 14:23:00 +0200" ) );
        // no real start
        race.setDistance( 2200.0 );
        race.setBenefit( 19000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.RECLAMER ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R4_H1( race ) );
        horses.add( builderHorse_R4_H2( race ) );
        horses.add( builderHorse_R4_H3( race ) );
        horses.add( builderHorse_R4_H4( race ) );
        horses.add( builderHorse_R4_H5( race ) );
        horses.add( builderHorse_R4_H6( race ) );
        horses.add( builderHorse_R4_H7( race ) );
        horses.add( builderHorse_R4_H8( race ) );
        horses.add( builderHorse_R4_H9( race ) );
        horses.add( builderHorse_R4_H10( race ) );
        horses.add( builderHorse_R4_H11( race ) );
        horses.add( builderHorse_R4_H12( race ) );
        horses.add( builderHorse_R4_H13( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R4_O1( race ) );
        oddsSet.add( builderOdds_R4_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 12 ) );
        places.add( place( race,  2, 10, "ENCOLURE" ) );
        places.add( place( race,  3,  7, "COURTE_TETE" ) );
        places.add( place( race,  4,  5, "TROIS_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race,  5,  8, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  6,  6, "ENCOLURE" ) );
        places.add( place( race,  7,  3, "TROIS_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race,  8, 11, "UNE_LONGUEUR" ) );
        places.add( place( race,  9,  4, "COURTE_TETE" ) );
        places.add( place( race, 10,  1, "TROIS_QUARTS_DE_LONGUEUR" ) );
        places.add( place( race, 11,  2, "TROIS_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race, 12,  9, "TROIS_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 19.0, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "10" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.4, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.4, "7" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 0.0, "12" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 82.4, "12 10" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 0.0, "12" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 31.9, "12 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.9, "10 7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.2, "12 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 17.7, "12 7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "7" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "12 10" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 74.8, "12 10 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "10 5" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "10 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "12 10" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "12 5" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "12 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.6, "7 5" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 306.0, "12 10 7 5" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 61.2, "12 10 7 5" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 20.4, "12 10 7 5" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 4
     * Horse 1 - CRAZY DES AIGLES
     * HorseID - CRAZY DES AIGLES
     */
    public static HorseID builderHorse_R4_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CRAZY DES AIGLES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "DEPORTIVO" );
        horseID.setMother( "SHALL WE DANCE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 1 - CRAZY DES AIGLES
     */

    public static Horse builderHorse_R4_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 61.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 4260000.0 );
        horse.setPreviousYearProfit( 1380000.0 );
        horse.setVictoryProfit( 2100000.0 );
        horse.setPlaceProfit( 2160000.0 );
        horse.setYearProfit( 2880000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "F.CHAPPET" ) );
        horse.setOwner( owner( "F.CHAPPET" ) );
        horse.setRancher( rancher( "MME SANDRINE GAVILAN" ) );
        horse.setJockey( jockey( "M.ROMARY" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 2 - SUPER VERDAZ
     * HorseID - SUPER VERDAZ
     */
    public static HorseID builderHorse_R4_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SUPER VERDAZ" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "VERGLAS" );
        horseID.setMother( "DAZZLING DANCER" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 4
     * Horse 2 - SUPER VERDAZ
     */

    public static Horse builderHorse_R4_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 13 );
        // no stable
        horse.setWeight( 59.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 336600.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 255000.0 );
        horse.setPlaceProfit( 81600.0 );
        horse.setYearProfit( 336600.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "G.BIETOLINI" ) );
        horse.setOwner( owner( "F.FRATINI" ) );
        horse.setRancher( rancher( "CASTLEMARTIN STUD" ) );
        horse.setJockey( jockey( "J.MARCIALIS" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 3 - AYACUCHO
     * HorseID - AYACUCHO
     */
    public static HorseID builderHorse_R4_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AYACUCHO" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ALFRED NOBEL" );
        horseID.setMother( "AKAZIE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 3 - AYACUCHO
     */

    public static Horse builderHorse_R4_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 390000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 390000.0 );
        horse.setYearProfit( 390000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.DUREPAIRE (S)" ) );
        horse.setOwner( owner( "ECURIE NORMANDIE PUR SANG" ) );
        horse.setRancher( rancher( "HARAS DE BEAUVOIR" ) );
        horse.setJockey( jockey( "MA.BERNADET" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 4 - STORM SAIL
     * HorseID - STORM SAIL
     */
    public static HorseID builderHorse_R4_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "STORM SAIL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "DYLAN THOMAS" );
        horseID.setMother( "SORRENTA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 4 - STORM SAIL
     */

    public static Horse builderHorse_R4_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 250000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 250000.0 );
        horse.setYearProfit( 250000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "J.HAMMOND (S)" ) );
        horse.setOwner( owner( "GESTUT AMMERLAND" ) );
        horse.setRancher( rancher( "GESTUT AMMERLAND" ) );
        horse.setJockey( jockey( "D.SANTIAGO" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 5 - I SEE YOU
     * HorseID - I SEE YOU
     */
    public static HorseID builderHorse_R4_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "I SEE YOU" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "AIR CHIEF MARSHAL" );
        horseID.setMother( "DALMARA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 5 - I SEE YOU
     */

    public static Horse builderHorse_R4_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 57.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1935000.0 );
        horse.setPreviousYearProfit( 310000.0 );
        horse.setVictoryProfit( 500000.0 );
        horse.setPlaceProfit( 1435000.0 );
        horse.setYearProfit( 1625000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "MLLE J.LEGATTE" ) );
        horse.setOwner( owner( "I.ENDALTSEV" ) );
        horse.setRancher( rancher( "MR ROGER-YVES SIMON" ) );
        horse.setJockey( jockey( "K.BEAUMARD" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 6 - QATAR SKY
     * HorseID - QATAR SKY
     */
    public static HorseID builderHorse_R4_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "QATAR SKY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "AUSSIE RULES" );
        horseID.setMother( "LORIENTAISE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 6 - QATAR SKY
     */

    public static Horse builderHorse_R4_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "GE.MIKHALIDES" ) );
        horse.setOwner( owner( "M.AL NAEMI" ) );
        horse.setRancher( rancher( "STONE RIDGE FARM" ) );
        horse.setJockey( jockey( "L.LE PEMP" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 7 - VALOGNES
     * HorseID - VALOGNES
     */
    public static HorseID builderHorse_R4_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VALOGNES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ROYAL APPLAUSE" );
        horseID.setMother( "VIKING FAIR" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 7 - VALOGNES
     */

    public static Horse builderHorse_R4_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 115000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 115000.0 );
        horse.setYearProfit( 115000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E.LELLOUCHE" ) );
        horse.setOwner( owner( "G.AUGUSTIN-NORMAND" ) );
        horse.setRancher( rancher( "MR JOHN F. TUTHILL" ) );
        horse.setJockey( jockey( "P.DOMINOIS" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 8 - GREAT ALANA
     * HorseID - GREAT ALANA
     */
    public static HorseID builderHorse_R4_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "GREAT ALANA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GREAT PRETENDER" );
        horseID.setMother( "AMIE DES CHAMPS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 8 - GREAT ALANA
     */

    public static Horse builderHorse_R4_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME P.BUTEL" ) );
        horse.setOwner( owner( "MME P.BUTEL" ) );
        horse.setRancher( rancher( "MME VALERIE LUTZ" ) );
        horse.setJockey( jockey( "A.BOUVIER" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 9 - NESSAYA
     * HorseID - NESSAYA
     */
    public static HorseID builderHorse_R4_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "NESSAYA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SOLDIER OF FORTUNE" );
        horseID.setMother( "NOUVELLE PRINCESSE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 9 - NESSAYA
     */

    public static Horse builderHorse_R4_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( true );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "W.FIGGE" ) );
        horse.setOwner( owner( "STALL SALZBURG" ) );
        horse.setRancher( rancher( "GESTUT AM SCHLOSSGARTEN" ) );
        horse.setJockey( jockey( "A.VILMAR" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 10 - SERENDY
     * HorseID - SERENDY
     */
    public static HorseID builderHorse_R4_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SERENDY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "PLEASANTLY PERFECT" );
        horseID.setMother( "YDILLIQUE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 10 - SERENDY
     */

    public static Horse builderHorse_R4_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 1320000.0 );
        horse.setPreviousYearProfit( 170000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1320000.0 );
        horse.setYearProfit( 1150000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "C.LAFFON-PARIAS" ) );
        horse.setOwner( owner( "WERTHEIMER & FRERE" ) );
        horse.setRancher( rancher( "WERTHEIMER & FRERE" ) );
        horse.setJockey( jockey( "Z.PFEIL" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 11 - MORERA
     * HorseID - MORERA
     */
    public static HorseID builderHorse_R4_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MORERA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "FOL PARADE" );
        horseID.setMother( "BALDORIA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 11 - MORERA
     */

    public static Horse builderHorse_R4_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 70000.0 );
        horse.setPreviousYearProfit( 70000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 70000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.DELCHER SANCHEZ" ) );
        horse.setOwner( owner( "CUADRA MEDITERRANEO" ) );
        horse.setRancher( rancher( "CUADRA MADRONOS" ) );
        horse.setJockey( jockey( "L.GROSSO" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 12 - SISTER DAM'S
     * HorseID - SISTER DAM'S
     */
    public static HorseID builderHorse_R4_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SISTER DAM'S" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MASTERCRAFTSMAN" );
        horseID.setMother( "FOUR GREEN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 4
     * Horse 12 - SISTER DAM'S
     */

    public static Horse builderHorse_R4_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 915000.0 );
        horse.setPreviousYearProfit( 915000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 915000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "C&Y.LERNER (S)" ) );
        horse.setOwner( owner( "ECURIE DAM'S/MME P. ADES-HAZAN" ) );
        horse.setRancher( rancher( "VISION BLOODSTOCK LTD" ) );
        horse.setJockey( jockey( "O.LESLY" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 13 - SOLANGE
     * HorseID - SOLANGE
     */
    public static HorseID builderHorse_R4_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SOLANGE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KAMSIN" );
        horseID.setMother( "STARAYA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 13 - SOLANGE
     */

    public static Horse builderHorse_R4_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 2200.0 );
        horse.setCareerProfit( 145000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 145000.0 );
        horse.setYearProfit( 145000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "M.FIGGE" ) );
        horse.setOwner( owner( "RENNSTALL GESTUT HACHTSEE" ) );
        horse.setRancher( rancher( "GESTUT HACHTSEE" ) );
        horse.setJockey( jockey( "G.MUHLBICHLER" ) );

        return horse;

    }

    /*
     * Race 4
     * Odds 1 - 13/08/2015 12:31:38 +0200
     */

    public static Odds builderOdds_R4_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:38 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 13.1 ) );
        simples.add( simple( odds, "2", 27.3 ) );
        simples.add( simple( odds, "3", 10.8 ) );
        simples.add( simple( odds, "4", 3.5 ) );
        simples.add( simple( odds, "5", 9.7 ) );
        simples.add( simple( odds, "6", 29.0 ) );
        simples.add( simple( odds, "7", 5.3 ) );
        simples.add( simple( odds, "8", 30.8 ) );
        simples.add( simple( odds, "9", 17.3 ) );
        simples.add( simple( odds, "10", 5.0 ) );
        simples.add( simple( odds, "11", 23.5 ) );
        simples.add( simple( odds, "12", 24.3 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4
     * Odds 2 - 13/08/2015 14:27:46 +0200
     */

    public static Odds builderOdds_R4_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 14:27:46 +0200" ) );
        odds.setTotal( 145807.04 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 10.6 ) );
        simples.add( simple( odds, "2", 22.9 ) );
        simples.add( simple( odds, "3", 6.0 ) );
        simples.add( simple( odds, "4", 4.1 ) );
        simples.add( simple( odds, "5", 13.8 ) );
        simples.add( simple( odds, "6", 56.1 ) );
        simples.add( simple( odds, "7", 7.6 ) );
        simples.add( simple( odds, "8", 36.0 ) );
        simples.add( simple( odds, "9", 23.3 ) );
        simples.add( simple( odds, "10", 4.0 ) );
        simples.add( simple( odds, "11", 20.2 ) );
        simples.add( simple( odds, "12", 19.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5 - PRIX LUTH ENCHANTEE - FONDS EUROPEEN DE L'ELEVAGE - DHEVATARA
     */

    public static Race builderRace_R5( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 5 );
        race.setName( "PRIX LUTH ENCHANTEE - FONDS EUROPEEN DE L'ELEVAGE - DHEVATARA" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 14:53:00 +0200" ) );
        // no real start
        race.setDistance( 1800.0 );
        race.setBenefit( 48000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.CONDITIONS ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R5_H1( race ) );
        horses.add( builderHorse_R5_H2( race ) );
        horses.add( builderHorse_R5_H3( race ) );
        horses.add( builderHorse_R5_H4( race ) );
        horses.add( builderHorse_R5_H5( race ) );
        horses.add( builderHorse_R5_H6( race ) );
        horses.add( builderHorse_R5_H7( race ) );
        horses.add( builderHorse_R5_H8( race ) );
        horses.add( builderHorse_R5_H9( race ) );
        horses.add( builderHorse_R5_H10( race ) );
        horses.add( builderHorse_R5_H11( race ) );
        horses.add( builderHorse_R5_H12( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX,
                BetType.PICK5,
                BetType.TIERCE ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R5_O1( race ) );
        oddsSet.add( builderOdds_R5_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 12 ) );
        places.add( place( race,  2,  1, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race,  3,  6, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race,  4,  7, "COURTE_ENCOLURE" ) );
        places.add( place( race,  5,  4, "COURTE_ENCOLURE" ) );
        places.add( place( race,  6, 11, "COURTE_ENCOLURE" ) );
        places.add( place( race,  7,  2, "UNE_TETE" ) );
        places.add( place( race,  8,  9, "TROIS_QUARTS_DE_LONGUEUR" ) );
        places.add( place( race,  9,  3, "DEUX_LONGUEURS" ) );
        places.add( place( race, 10, 10, "UNE_TETE" ) );
        places.add( place( race, 11,  8, "TROIS_LONGUEURS" ) );
        places.add( place( race, 12,  5, "DEUX_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 3.4, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.2, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.7, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.5, "6" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 59.0, "12 1" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 29.9, "12 1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 44.9, "1 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 11.0, "12 1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 12.4, "12 6" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 163.5, "12 1 6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "1 6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "1 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "12 1" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "12 6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "12 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 13.3, "6 7" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 426.0, "12 1 6 7" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 85.2, "12 1 6 7" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 28.4, "12 1 6 7" ) );
        prices.add( price( race, BetType.PICK5, PriceName.DIRECT, 301.1, "12 1 6 7 4" ) );
        prices.add( price( race, BetType.TIERCE, PriceName.DIRECT, 104.7, "12 1 6" ) );
        prices.add( price( race, BetType.TIERCE, PriceName.ORDRE, 523.5, "12 1 6" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 5
     * Horse 1 - MAKRUMA
     * HorseID - MAKRUMA
     */
    public static HorseID builderHorse_R5_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MAKRUMA" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DUBAWI" );
        horseID.setMother( "QELAAN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 1 - MAKRUMA
     */

    public static Horse builderHorse_R5_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1.91693E7 );
        horse.setPreviousYearProfit( 4249300.0 );
        horse.setVictoryProfit( 1.63535E7 );
        horse.setPlaceProfit( 2815800.0 );
        horse.setYearProfit( 1.4696E7 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "GE.MIKHALIDES" ) );
        horse.setOwner( owner( "M.AL NAEMI" ) );
        horse.setRancher( rancher( "SHADWELL ESTATE CO. LTD" ) );
        horse.setJockey( jockey( "T.JARNET" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 2 - RUE POMEREU
     * HorseID - RUE POMEREU
     */
    public static HorseID builderHorse_R5_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "RUE POMEREU" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DUBAWI" );
        horseID.setMother( "STAR OF AKKAR" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 2 - RUE POMEREU
     */

    public static Horse builderHorse_R5_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( true );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 6314000.0 );
        horse.setPreviousYearProfit( 2720000.0 );
        horse.setVictoryProfit( 2050000.0 );
        horse.setPlaceProfit( 4264000.0 );
        horse.setYearProfit( 3594000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "CH.GOURDAIN (S)" ) );
        horse.setOwner( owner( "J.BERES" ) );
        horse.setRancher( rancher( "MARQUISE DE MORATALLA" ) );
        horse.setJockey( jockey( "O.PESLIER" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 3 - GABELLA
     * HorseID - GABELLA
     */
    public static HorseID builderHorse_R5_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "GABELLA" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ARCHANGE D'OR" );
        horseID.setMother( "PREMIERE CHANCE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 5
     * Horse 3 - GABELLA
     */

    public static Horse builderHorse_R5_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1.267E7 );
        horse.setPreviousYearProfit( 5156000.0 );
        horse.setVictoryProfit( 5594000.0 );
        horse.setPlaceProfit( 7076000.0 );
        horse.setYearProfit( 3164000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N.CLEMENT (S)" ) );
        horse.setOwner( owner( "RJ.CRABTREE" ) );
        horse.setRancher( rancher( "S.C. DE L'ECURIE DE MEAUTRY" ) );
        horse.setJockey( jockey( "T.THULLIEZ" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 4 - DEBUTANTE
     * HorseID - DEBUTANTE
     */
    public static HorseID builderHorse_R5_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "DEBUTANTE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GOLD AWAY" );
        horseID.setMother( "DANEDROP" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 4 - DEBUTANTE
     */

    public static Horse builderHorse_R5_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 3350000.0 );
        horse.setPreviousYearProfit( 2070000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 3350000.0 );
        horse.setYearProfit( 1280000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.ROYER DUPRE DE" ) );
        horse.setOwner( owner( "ECURIE DES MONCEAUX" ) );
        horse.setRancher( rancher( "LEMZAR SARL" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 5 - CASCABEL
     * HorseID - CASCABEL
     */
    public static HorseID builderHorse_R5_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CASCABEL" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DYHIM DIAMOND" );
        horseID.setMother( "CHANNEL" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 5 - CASCABEL
     */

    public static Horse builderHorse_R5_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 3805000.0 );
        horse.setPreviousYearProfit( 2960000.0 );
        horse.setVictoryProfit( 2450000.0 );
        horse.setPlaceProfit( 1355000.0 );
        horse.setYearProfit( 140000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.RODRIGUEZ FERNANDEZ" ) );
        horse.setOwner( owner( "FABRICA D'EMBOTITS JP S.L" ) );
        horse.setRancher( rancher( "MR ENRIQUE CALAMITA-GONZALVEZ" ) );
        horse.setJockey( jockey( "J.CROCQUEVIEILLE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 6 - KAMELLATA
     * HorseID - KAMELLATA
     */
    public static HorseID builderHorse_R5_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "KAMELLATA" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "POMELLATO" );
        horseID.setMother( "KAMAKURA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 6 - KAMELLATA
     */

    public static Horse builderHorse_R5_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 9010000.0 );
        horse.setPreviousYearProfit( 6280000.0 );
        horse.setVictoryProfit( 4550000.0 );
        horse.setPlaceProfit( 4460000.0 );
        horse.setYearProfit( 150000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "HA.PANTALL" ) );
        horse.setOwner( owner( "SV.GIANELLA" ) );
        horse.setRancher( rancher( "APPAPAYS RACING CLUB" ) );
        horse.setJockey( jockey( "F.VERON" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 7 - LOVELY STORY
     * HorseID - LOVELY STORY
     */
    public static HorseID builderHorse_R5_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LOVELY STORY" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "CAPE CROSS" );
        horseID.setMother( "HUSH MONEY" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 7 - LOVELY STORY
     */

    public static Horse builderHorse_R5_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1420000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1420000.0 );
        horse.setYearProfit( 1420000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "HA.PANTALL" ) );
        horse.setOwner( owner( "GODOLPHIN SNC" ) );
        horse.setRancher( rancher( "DARLEY STUD MANAGEMENT CO. LTD" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 8 - HIGH STRUNG
     * HorseID - HIGH STRUNG
     */
    public static HorseID builderHorse_R5_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "HIGH STRUNG" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MASTERCRAFTSMAN" );
        horseID.setMother( "HIGH FIDELITY" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 8 - HIGH STRUNG
     */

    public static Horse builderHorse_R5_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1459000.0 );
        horse.setPreviousYearProfit( 225000.0 );
        horse.setVictoryProfit( 1000000.0 );
        horse.setPlaceProfit( 459000.0 );
        horse.setYearProfit( 234000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JD.HILLIS" ) );
        horse.setOwner( owner( "GRIFFO RACING" ) );
        horse.setRancher( rancher( "GESTUT AMMERLAND" ) );
        horse.setJockey( jockey( "A.HAMELIN" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 9 - HEAVENS EYES
     * HorseID - HEAVENS EYES
     */
    public static HorseID builderHorse_R5_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "HEAVENS EYES" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OASIS DREAM" );
        horseID.setMother( "SNOWTIME" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 9 - HEAVENS EYES
     */

    public static Horse builderHorse_R5_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 954500.0 );
        horse.setPreviousYearProfit( 115400.0 );
        horse.setVictoryProfit( 623000.0 );
        horse.setPlaceProfit( 331500.0 );
        horse.setYearProfit( 839100.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME J.F..HUGHES" ) );
        horse.setOwner( owner( "MME C.REGALADO-GONZALEZ" ) );
        horse.setRancher( rancher( "MME CHANTAL REGALADO-GONZALEZ" ) );
        horse.setJockey( jockey( "D.COSTELLO" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 10 - BOHEMIAN RHAPSODY
     * HorseID - BOHEMIAN RHAPSODY
     */
    public static HorseID builderHorse_R5_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOHEMIAN RHAPSODY" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DYHIM DIAMOND" );
        horseID.setMother( "SOLINA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 10 - BOHEMIAN RHAPSODY
     */

    public static Horse builderHorse_R5_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 5170000.0 );
        horse.setPreviousYearProfit( 2150000.0 );
        horse.setVictoryProfit( 4090000.0 );
        horse.setPlaceProfit( 1080000.0 );
        horse.setYearProfit( 600000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E.LEON PENATE" ) );
        horse.setOwner( owner( "ROISAJU LOPEZ S.L." ) );
        horse.setRancher( rancher( "CUADRA CIELO DE MADRID" ) );
        horse.setJockey( jockey( "C.DEMURO" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 11 - DEAUVILLE SHOWER
     * HorseID - DEAUVILLE SHOWER
     */
    public static HorseID builderHorse_R5_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "DEAUVILLE SHOWER" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "HIGH CHAPARRAL" );
        horseID.setMother( "ENDLESS NIGHT" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 11 - DEAUVILLE SHOWER
     */

    public static Horse builderHorse_R5_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 3835000.0 );
        horse.setPreviousYearProfit( 1685000.0 );
        horse.setVictoryProfit( 2550000.0 );
        horse.setPlaceProfit( 1285000.0 );
        horse.setYearProfit( 2150000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E.LIBAUD (S)" ) );
        horse.setOwner( owner( "T. STORME/T. LOHEST" ) );
        horse.setRancher( rancher( "MR JOSEPH HERNON" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 12 - ROYALMANIA
     * HorseID - ROYALMANIA
     */
    public static HorseID builderHorse_R5_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ROYALMANIA" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ELUSIVE QUALITY" );
        horseID.setMother( "SAFARI QUEEN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 12 - ROYALMANIA
     */

    public static Horse builderHorse_R5_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1800.0 );
        horse.setCareerProfit( 1.0803E7 );
        horse.setPreviousYearProfit( 3950000.0 );
        horse.setVictoryProfit( 5650000.0 );
        horse.setPlaceProfit( 5153000.0 );
        horse.setYearProfit( 2240000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.HEAD (S)" ) );
        horse.setOwner( owner( "WERTHEIMER & FRERE" ) );
        horse.setRancher( rancher( "WERTHEIMER & FRERE" ) );
        horse.setJockey( jockey( "M.GUYON" ) );

        return horse;

    }

    /*
     * Race 5
     * Odds 1 - 13/08/2015 12:31:24 +0200
     */

    public static Odds builderOdds_R5_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:24 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 15.1 ) );
        simples.add( simple( odds, "2", 7.7 ) );
        simples.add( simple( odds, "3", 5.5 ) );
        simples.add( simple( odds, "4", 6.1 ) );
        simples.add( simple( odds, "5", 27.5 ) );
        simples.add( simple( odds, "6", 23.4 ) );
        simples.add( simple( odds, "7", 13.7 ) );
        simples.add( simple( odds, "8", 23.1 ) );
        simples.add( simple( odds, "9", 17.7 ) );
        simples.add( simple( odds, "10", 17.8 ) );
        simples.add( simple( odds, "11", 11.7 ) );
        simples.add( simple( odds, "12", 3.9 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5
     * Odds 2 - 13/08/2015 14:54:04 +0200
     */

    public static Odds builderOdds_R5_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 14:54:04 +0200" ) );
        odds.setTotal( 153299.48 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 21.6 ) );
        simples.add( simple( odds, "2", 7.3 ) );
        simples.add( simple( odds, "3", 6.5 ) );
        simples.add( simple( odds, "4", 3.9 ) );
        simples.add( simple( odds, "5", 73.5 ) );
        simples.add( simple( odds, "6", 25.1 ) );
        simples.add( simple( odds, "7", 17.9 ) );
        simples.add( simple( odds, "8", 36.3 ) );
        simples.add( simple( odds, "9", 14.8 ) );
        simples.add( simple( odds, "10", 22.4 ) );
        simples.add( simple( odds, "11", 16.3 ) );
        simples.add( simple( odds, "12", 3.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6 - PRIX WWW.ADONIS-HOTELS-RESIDENCES.COM (PRIX DJAKAO)
     */

    public static Race builderRace_R6( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 6 );
        race.setName( "PRIX WWW.ADONIS-HOTELS-RESIDENCES.COM (PRIX DJAKAO)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 15:25:00 +0200" ) );
        // no real start
        race.setDistance( 2900.0 );
        race.setBenefit( 25000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.CONDITIONS ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R6_H1( race ) );
        horses.add( builderHorse_R6_H2( race ) );
        horses.add( builderHorse_R6_H3( race ) );
        horses.add( builderHorse_R6_H4( race ) );
        horses.add( builderHorse_R6_H5( race ) );
        horses.add( builderHorse_R6_H6( race ) );
        horses.add( builderHorse_R6_H7( race ) );
        horses.add( builderHorse_R6_H8( race ) );
        horses.add( builderHorse_R6_H9( race ) );
        horses.add( builderHorse_R6_H10( race ) );
        horses.add( builderHorse_R6_H11( race ) );
        horses.add( builderHorse_R6_H12( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R6_O1( race ) );
        oddsSet.add( builderOdds_R6_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  1 ) );
        places.add( place( race,  2,  9, "COURTE_TETE" ) );
        places.add( place( race,  3,  2, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  4,  8, "DEUX_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race,  5,  4, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  6, 10, "UNE_LONGUEUR_TROIS_QUARTS" ) );
        places.add( place( race,  7, 12, "QUATRE_LONGUEURS" ) );
        places.add( place( race,  8, 11, "DIX_LONGUEURS" ) );
        places.add( place( race,  9,  7, "NEUF_LONGUEURS" ) );
        places.add( place( race, 10,  5, "DEUX_LONGUEURS" ) );
        places.add( place( race, 11,  6, "UNE_LONGUEUR" ) );
        places.add( place( race, 12,  3, "SEPT_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 3.7, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "2" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.3, "9" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 9.5, "1 9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 4.1, "1 9" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.8, "1 2" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.3, "1 9" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.9, "9 2" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 10.0, "1 9 2" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "1 2" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "1 8" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "1 9" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "2 8" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "9 2" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.2, "9 8" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 10.0, "1 9 2 8" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 2.0, "1 9 2 8" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 1.05, "1 9 2 8" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 6
     * Horse 1 - PEACE NEWS
     * HorseID - PEACE NEWS
     */
    public static HorseID builderHorse_R6_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PEACE NEWS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "SHOLOKHOV" );
        horseID.setMother( "PEACEFUL LOVE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 1 - PEACE NEWS
     */

    public static Horse builderHorse_R6_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 58.0 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 720000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 720000.0 );
        horse.setYearProfit( 720000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.ROHAUT (S)" ) );
        horse.setOwner( owner( "ECURIE PANDORA RACING" ) );
        horse.setRancher( rancher( "PLERSCH BREEDING SARL" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 2 - TRACT
     * HorseID - TRACT
     */
    public static HorseID builderHorse_R6_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TRACT" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "FASTNET ROCK" );
        horseID.setMother( "STEROPE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 2 - TRACT
     */

    public static Horse builderHorse_R6_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 58.0 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 375000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 375000.0 );
        horse.setYearProfit( 375000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "P.BARY (S)" ) );
        horse.setOwner( owner( "FAM .NIARCHOS" ) );
        horse.setRancher( rancher( "SUCC MR S. NIARCHOS" ) );
        horse.setJockey( jockey( "S.PASQUIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 3 - MODERN PALACE
     * HorseID - MODERN PALACE
     */
    public static HorseID builderHorse_R6_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MODERN PALACE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PALACE EPISODE" );
        horseID.setMother( "PRINCESSE STESA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 3 - MODERN PALACE
     */

    public static Horse builderHorse_R6_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 58.0 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M&S.NIGGE (S)" ) );
        horse.setOwner( owner( "M&S.M&S .NIGGE (S)" ) );
        horse.setRancher( rancher( "MR MARKUS NIGGE" ) );
        horse.setJockey( jockey( "J.CABRE" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 4 - MARCEL DEBRUXELLES
     * HorseID - MARCEL DEBRUXELLES
     */
    public static HorseID builderHorse_R6_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MARCEL DEBRUXELLES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LIBRETTIST" );
        horseID.setMother( "FORCASTER" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 4 - MARCEL DEBRUXELLES
     */

    public static Horse builderHorse_R6_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 58.0 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 480000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 480000.0 );
        horse.setYearProfit( 480000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P.VAN DE POELE (S)" ) );
        horse.setOwner( owner( "P.VAN BELLE" ) );
        horse.setRancher( rancher( "MR PIERRE VAN BELLE" ) );
        horse.setJockey( jockey( "G.BENOIST" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 5 - SACREE ROSE
     * HorseID - SACREE ROSE
     */
    public static HorseID builderHorse_R6_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SACREE ROSE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GRIS DE GRIS" );
        horseID.setMother( "SACRED MUSIC" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 6
     * Horse 5 - SACREE ROSE
     */

    public static Horse builderHorse_R6_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JP.GALLORINI (S)" ) );
        horse.setOwner( owner( "MLLE A.BERGER" ) );
        horse.setRancher( rancher( "MLLE ALEXANDRINE BERGER" ) );
        horse.setJockey( jockey( "I.MENDIZABAL" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 6 - SILAFEE
     * HorseID - SILAFEE
     */
    public static HorseID builderHorse_R6_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SILAFEE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SILVER FROST" );
        horseID.setMother( "FEE DU NORD" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 6
     * Horse 6 - SILAFEE
     */

    public static Horse builderHorse_R6_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JP.GALLORINI (S)" ) );
        horse.setOwner( owner( "MME RG.EHRNROOTH" ) );
        horse.setRancher( rancher( "MR CHARLES BAREL" ) );
        horse.setJockey( jockey( "T.PICCONE" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 7 - PARC MONTSOURIS
     * HorseID - PARC MONTSOURIS
     */
    public static HorseID builderHorse_R6_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PARC MONTSOURIS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "HALLING" );
        horseID.setMother( "POWER GIRL" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 7 - PARC MONTSOURIS
     */

    public static Horse builderHorse_R6_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.DOUMEN (S)" ) );
        horse.setOwner( owner( "GOLD AND BLUE LTD" ) );
        horse.setRancher( rancher( "MR JACQUES BERES" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 8 - YOSILLE
     * HorseID - YOSILLE
     */
    public static HorseID builderHorse_R6_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "YOSILLE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "BLUE BRESIL" );
        horseID.setMother( "YOLAINE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 8 - YOSILLE
     */

    public static Horse builderHorse_R6_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 1820000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1820000.0 );
        horse.setYearProfit( 1820000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.BERTRAN DE BALANDA (S)" ) );
        horse.setOwner( owner( "D.GONCALVES" ) );
        horse.setRancher( rancher( "MR ALBERT HOSSELET" ) );
        horse.setJockey( jockey( "M.GUYON" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 9 - ALLEZ Y
     * HorseID - ALLEZ Y
     */
    public static HorseID builderHorse_R6_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALLEZ Y" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "RIP VAN WINKLE" );
        horseID.setMother( "L'ANCRESSE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 9 - ALLEZ Y
     */

    public static Horse builderHorse_R6_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 1940000.0 );
        horse.setPreviousYearProfit( 500000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1940000.0 );
        horse.setYearProfit( 1440000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.FABRE (S)" ) );
        horse.setOwner( owner( "M. TABOR/MME S. MAGNIER/D. SMITH" ) );
        horse.setRancher( rancher( "MARCH THOROUGHBREDS" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 10 - ROCK EYES
     * HorseID - ROCK EYES
     */
    public static HorseID builderHorse_R6_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ROCK EYES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ROCK OF GIBRALTAR" );
        horseID.setMother( "ART EYES" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 10 - ROCK EYES
     */

    public static Horse builderHorse_R6_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 440000.0 );
        horse.setPreviousYearProfit( 280000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 440000.0 );
        horse.setYearProfit( 160000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M.DELCHER SANCHEZ" ) );
        horse.setOwner( owner( "JM.MALDONADO" ) );
        horse.setRancher( rancher( "MR D. CURRAN" ) );
        horse.setJockey( jockey( "O.PESLIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 11 - THREE CARDS
     * HorseID - THREE CARDS
     */
    public static HorseID builderHorse_R6_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "THREE CARDS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MASTERCRAFTSMAN" );
        horseID.setMother( "BE MY LADY" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 6
     * Horse 11 - THREE CARDS
     */

    public static Horse builderHorse_R6_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "F.DOUMEN (S)" ) );
        horse.setOwner( owner( "MISE DE MORATALLA" ) );
        horse.setRancher( rancher( "EARL HARAS DE CISAI" ) );
        horse.setJockey( jockey( "C.DEMURO" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 12 - SLOWMOTION
     * HorseID - SLOWMOTION
     */
    public static HorseID builderHorse_R6_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SLOWMOTION" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SOLDIER OF FORTUNE" );
        horseID.setMother( "SECOND EMOTION" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 6
     * Horse 12 - SLOWMOTION
     */

    public static Horse builderHorse_R6_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 2900.0 );
        horse.setCareerProfit( 80000.0 );
        horse.setPreviousYearProfit( 80000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 80000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.LAMOTTE D'ARGY" ) );
        horse.setOwner( owner( "A.VON GUNTEN" ) );
        horse.setRancher( rancher( "MR ADRIAN VON GUNTEN" ) );
        horse.setJockey( jockey( "V.CHEMINAUD" ) );

        return horse;

    }

    /*
     * Race 6
     * Odds 1 - 13/08/2015 12:31:36 +0200
     */

    public static Odds builderOdds_R6_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:36 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 4.7 ) );
        simples.add( simple( odds, "2", 8.0 ) );
        simples.add( simple( odds, "3", 45.0 ) );
        simples.add( simple( odds, "4", 7.7 ) );
        simples.add( simple( odds, "5", 23.5 ) );
        simples.add( simple( odds, "6", 33.5 ) );
        simples.add( simple( odds, "7", 24.1 ) );
        simples.add( simple( odds, "8", 11.5 ) );
        simples.add( simple( odds, "9", 3.2 ) );
        simples.add( simple( odds, "10", 22.1 ) );
        simples.add( simple( odds, "11", 15.4 ) );
        simples.add( simple( odds, "12", 12.9 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6
     * Odds 2 - 13/08/2015 15:26:22 +0200
     */

    public static Odds builderOdds_R6_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 15:26:22 +0200" ) );
        odds.setTotal( 155671.51 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 3.7 ) );
        simples.add( simple( odds, "2", 8.5 ) );
        simples.add( simple( odds, "3", 111.8 ) );
        simples.add( simple( odds, "4", 7.7 ) );
        simples.add( simple( odds, "5", 47.8 ) );
        simples.add( simple( odds, "6", 72.9 ) );
        simples.add( simple( odds, "7", 43.2 ) );
        simples.add( simple( odds, "8", 7.5 ) );
        simples.add( simple( odds, "9", 3.0 ) );
        simples.add( simple( odds, "10", 12.0 ) );
        simples.add( simple( odds, "11", 38.3 ) );
        simples.add( simple( odds, "12", 34.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7 - PRIX DON DU SANG (PRIX DES AUBEPINES)
     */

    public static Race builderRace_R7( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 7 );
        race.setName( "PRIX DON DU SANG (PRIX DES AUBEPINES)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 15:55:00 +0200" ) );
        // no real start
        race.setDistance( 1600.0 );
        race.setBenefit( 19000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.RECLAMER ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R7_H1( race ) );
        horses.add( builderHorse_R7_H2( race ) );
        horses.add( builderHorse_R7_H3( race ) );
        horses.add( builderHorse_R7_H4( race ) );
        horses.add( builderHorse_R7_H5( race ) );
        horses.add( builderHorse_R7_H6( race ) );
        horses.add( builderHorse_R7_H7( race ) );
        horses.add( builderHorse_R7_H8( race ) );
        horses.add( builderHorse_R7_H9( race ) );
        horses.add( builderHorse_R7_H10( race ) );
        horses.add( builderHorse_R7_H11( race ) );
        horses.add( builderHorse_R7_H12( race ) );
        horses.add( builderHorse_R7_H13( race ) );
        horses.add( builderHorse_R7_H14( race ) );
        horses.add( builderHorse_R7_H15( race ) );
        horses.add( builderHorse_R7_H16( race ) );
        horses.add( builderHorse_R7_H17( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX,
                BetType.MULTI_EN_SEPT ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R7_O1( race ) );
        oddsSet.add( builderOdds_R7_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  2 ) );
        places.add( place( race,  2,  7, "DEMI_LONGUEUR" ) );
        places.add( place( race,  3, 17, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race,  4,  6, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  5, 10, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  6,  8, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race,  7,  5, "COURTE_TETE" ) );
        places.add( place( race,  8, 12, "DEMI_LONGUEUR" ) );
        places.add( place( race,  9,  4, "TROIS_LONGUEURS" ) );
        places.add( place( race, 10,  1, "TROIS_LONGUEURS" ) );
        places.add( place( race, 11, 16, "ENCOLURE" ) );
        places.add( place( race, 12, 13, "UN_NEZ" ) );
        places.add( place( race, 13, 11, "UNE_LONGUEUR" ) );
        places.add( place( race, 14, 14, "COURTE_ENCOLURE" ) );
        places.add( place( race, 15,  3, "NEUF_LONGUEURS" ) );
        places.add( place( race, 16,  9, "DIX_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.2, "2" ) );
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.2, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.7, "17" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.5, "2" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "7" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 0.0, "2" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 29.6, "2 7" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 6.2, "2" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 12.0, "2 7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.7, "17" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.5, "2" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 26.1, "2 17" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.3, "2 7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.8, "7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 12.0, "7 17" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "2 7" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 104.8, "2 7 17" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "17" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "17 6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "2" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "2 17" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "2 6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "2 7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "6" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "7" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "7 17" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.4, "7 6" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 199.5, "2 7 17 6" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 39.9, "2 7 17 6" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 13.3, "2 7 17 6" ) );
        prices.add( price( race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 5.7, "2 7 17 6" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 7
     * Horse 1 - JIMMY'S HALL
     * HorseID - JIMMY'S HALL
     */
    public static HorseID builderHorse_R7_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "JIMMY'S HALL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KYLLACHY" );
        horseID.setMother( "UP AT DAWN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 1 - JIMMY'S HALL
     */

    public static Horse builderHorse_R7_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 61.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 2013200.0 );
        horse.setPreviousYearProfit( 1035400.0 );
        horse.setVictoryProfit( 1019400.0 );
        horse.setPlaceProfit( 993800.0 );
        horse.setYearProfit( 977800.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "JS.MOORE" ) );
        horse.setOwner( owner( "J.S. MOORE & PARTNER" ) );
        horse.setRancher( rancher( "NEWSELLS PARK STUD LTD" ) );
        horse.setJockey( jockey( "M.BERTO" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 2 - ARTISTE TIME
     * HorseID - ARTISTE TIME
     */
    public static HorseID builderHorse_R7_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARTISTE TIME" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ARTISTE ROYAL" );
        horseID.setMother( "WHIPS AND SCORNS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 2 - ARTISTE TIME
     */

    public static Horse builderHorse_R7_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        horse.setStable( "A" );
        horse.setWeight( 61.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 4245000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 2100000.0 );
        horse.setPlaceProfit( 2145000.0 );
        horse.setYearProfit( 4245000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "S.SMRCZEK" ) );
        horse.setOwner( owner( "STALL AUSTRALIA" ) );
        horse.setRancher( rancher( "MR JOHN ARNOU" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 3 - FLY GRAZER
     * HorseID - FLY GRAZER
     */
    public static HorseID builderHorse_R7_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "FLY GRAZER" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MOSS VALE" );
        horseID.setMother( "GRAZE ON TOO" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 3 - FLY GRAZER
     */

    public static Horse builderHorse_R7_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        horse.setStable( "A" );
        horse.setWeight( 60.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 3244300.0 );
        horse.setPreviousYearProfit( 259300.0 );
        horse.setVictoryProfit( 2100000.0 );
        horse.setPlaceProfit( 1144300.0 );
        horse.setYearProfit( 2985000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S.SMRCZEK" ) );
        horse.setOwner( owner( "STALL AUSTRALIA" ) );
        horse.setRancher( rancher( "CORRIN STUD" ) );
        horse.setJockey( jockey( "T.BACHELOT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 4 - CHUCK A LUCK
     * HorseID - CHUCK A LUCK
     */
    public static HorseID builderHorse_R7_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHUCK A LUCK" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "TREMPOLINO" );
        horseID.setMother( "ROUVRAIE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 4 - CHUCK A LUCK
     */

    public static Horse builderHorse_R7_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 365000.0 );
        horse.setPreviousYearProfit( 125000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 365000.0 );
        horse.setYearProfit( 240000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.CHAPPET" ) );
        horse.setOwner( owner( "ECURIE CENTRALE" ) );
        horse.setRancher( rancher( "MR FRANCOIS-MARIE COTTIN" ) );
        horse.setJockey( jockey( "F.MALBRAN" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 5 - SED ETIAM
     * HorseID - SED ETIAM
     */
    public static HorseID builderHorse_R7_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SED ETIAM" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "WHIPPER" );
        horseID.setMother( "THREE WISHES" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 5 - SED ETIAM
     */

    public static Horse builderHorse_R7_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 16 );
        // no stable
        horse.setWeight( 57.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 670000.0 );
        horse.setPreviousYearProfit( 160000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 670000.0 );
        horse.setYearProfit( 510000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "E.LEENDERS" ) );
        horse.setOwner( owner( "ECURIE MUSEROLLE" ) );
        horse.setRancher( rancher( "MR THIERRY DE LA HERONNIERE" ) );
        horse.setJockey( jockey( "A.FOUASSIER" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 6 - LIGHT'S ON
     * HorseID - LIGHT'S ON
     */
    public static HorseID builderHorse_R7_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LIGHT'S ON" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LE HAVRE" );
        horseID.setMother( "AIRLIGHT" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 6 - LIGHT'S ON
     */

    public static Horse builderHorse_R7_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 57.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 790000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 340000.0 );
        horse.setYearProfit( 790000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E.LIBAUD (S)" ) );
        horse.setOwner( owner( "MME A.KURTH" ) );
        horse.setRancher( rancher( "MME ANGELA KURTH" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 7 - RED CITY
     * HorseID - RED CITY
     */
    public static HorseID builderHorse_R7_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "RED CITY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "TIGER HILL" );
        horseID.setMother( "RED DIVA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 7 - RED CITY
     */

    public static Horse builderHorse_R7_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 1170000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1050000.0 );
        horse.setPlaceProfit( 120000.0 );
        horse.setYearProfit( 1170000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MAR .HOFER" ) );
        horse.setOwner( owner( "GESTUT ITTLINGEN" ) );
        horse.setRancher( rancher( "GESTUT ITTLINGEN" ) );
        horse.setJockey( jockey( "U.RISPOLI" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 8 - KOONARI
     * HorseID - KOONARI
     */
    public static HorseID builderHorse_R7_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "KOONARI" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LINNGARI" );
        horseID.setMother( "KOONUNGA HILL" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 8 - KOONARI
     */

    public static Horse builderHorse_R7_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 17 );
        // no stable
        horse.setWeight( 56.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 325000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 250000.0 );
        horse.setPlaceProfit( 75000.0 );
        horse.setYearProfit( 325000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MAR .HOFER" ) );
        horse.setOwner( owner( "G.SINDERMANN" ) );
        horse.setRancher( rancher( "MR GERHARD SINDERMANN" ) );
        horse.setJockey( jockey( "I.MENDIZABAL" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 9 - QATAR BREEZE
     * HorseID - QATAR BREEZE
     */
    public static HorseID builderHorse_R7_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "QATAR BREEZE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "HELLVELYN" );
        horseID.setMother( "TROPICAL BREEZE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 9 - QATAR BREEZE
     */

    public static Horse builderHorse_R7_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 435000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 435000.0 );
        horse.setYearProfit( 435000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "GE.MIKHALIDES" ) );
        horse.setOwner( owner( "M.AL NAEMI" ) );
        horse.setRancher( rancher( "REDLAND BLOODSTOCK LTD" ) );
        horse.setJockey( jockey( "L.LE PEMP" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 10 - GODRIC
     * HorseID - GODRIC
     */
    public static HorseID builderHorse_R7_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "GODRIC" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "WINKER WATSON" );
        horseID.setMother( "BEA MENACE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 10 - GODRIC
     */

    public static Horse builderHorse_R7_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 2790000.0 );
        horse.setPreviousYearProfit( 1025000.0 );
        horse.setVictoryProfit( 600000.0 );
        horse.setPlaceProfit( 2190000.0 );
        horse.setYearProfit( 1765000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "MME P.BRANDT" ) );
        horse.setOwner( owner( "MME P.BRANDT" ) );
        horse.setRancher( rancher( "CHASEMORE FARM" ) );
        horse.setJockey( jockey( "M.GUYON" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 11 - BANADA
     * HorseID - BANADA
     */
    public static HorseID builderHorse_R7_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BANADA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "ELUSIVE CITY" );
        horseID.setMother( "SASANUMA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 11 - BANADA
     */

    public static Horse builderHorse_R7_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 15 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 125000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 125000.0 );
        horse.setYearProfit( 125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.WITH );
        horse.setTrainer( trainer( "D.SMAGA" ) );
        horse.setOwner( owner( "R.NAHAS" ) );
        horse.setRancher( rancher( "MR ROBERT NAHAS" ) );
        horse.setJockey( jockey( "T.SPEICHER" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 12 - MANZANA DORADA
     * HorseID - MANZANA DORADA
     */
    public static HorseID builderHorse_R7_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MANZANA DORADA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MULTAZEM" );
        horseID.setMother( "QUIET SPLENDOR" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 12 - MANZANA DORADA
     */

    public static Horse builderHorse_R7_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 3345000.0 );
        horse.setPreviousYearProfit( 3000000.0 );
        horse.setVictoryProfit( 2200000.0 );
        horse.setPlaceProfit( 1145000.0 );
        horse.setYearProfit( 345000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "T.CASTANHEIRA (S)" ) );
        horse.setOwner( owner( "MME IB.STEFANUSSEN" ) );
        horse.setRancher( rancher( "CUADRAS PELAEZ MALVAR S.L." ) );
        horse.setJockey( jockey( "F.SPANU" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 13 - FREAKY GIRL
     * HorseID - FREAKY GIRL
     */
    public static HorseID builderHorse_R7_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "FREAKY GIRL" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SANDWAKI" );
        horseID.setMother( "YIPPEE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 13 - FREAKY GIRL
     */

    public static Horse builderHorse_R7_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 125000.0 );
        horse.setPreviousYearProfit( 125000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 125000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "ROB.COLLET (S)" ) );
        horse.setOwner( owner( "BALLANTINES RACING STUD L" ) );
        horse.setRancher( rancher( "MLLE LOUISE COLLET" ) );
        horse.setJockey( jockey( "LP.BEUZELIN" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 14 - LILU MARMALADE
     * HorseID - LILU MARMALADE
     */
    public static HorseID builderHorse_R7_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LILU MARMALADE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DUKE OF MARMALADE" );
        horseID.setMother( "CLAUSTRA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 14 - LILU MARMALADE
     */

    public static Horse builderHorse_R7_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 85000.0 );
        horse.setPreviousYearProfit( 60000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 85000.0 );
        horse.setYearProfit( 25000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "MME E.MADER" ) );
        horse.setOwner( owner( "Z.BIFOV" ) );
        horse.setRancher( rancher( "MR P.A. BYRNE" ) );
        horse.setJockey( jockey( "M.FOREST" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 15 - LILIANE
     * HorseID - LILIANE
     */
    public static HorseID builderHorse_R7_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LILIANE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "TERTULLIAN" );
        horseID.setMother( "LINDANE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 15 - LILIANE
     */

    public static Horse builderHorse_R7_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( false );
        horse.setSupplemented( true );
        horse.setPregnant( false );
        horse.setStall( 13 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 360000.0 );
        horse.setPreviousYearProfit( 200000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 360000.0 );
        horse.setYearProfit( 160000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H.BLUME" ) );
        horse.setOwner( owner( "GESTUT HAUS HAHN" ) );
        horse.setRancher( rancher( "GESTUT HAUS HAHN" ) );
        horse.setJockey( jockey( "T.PICCONE" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 16 - PAO LINA
     * HorseID - PAO LINA
     */
    public static HorseID builderHorse_R7_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PAO LINA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MUHTATHIR" );
        horseID.setMother( "LERINA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 16 - PAO LINA
     */

    public static Horse builderHorse_R7_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 790000.0 );
        horse.setPreviousYearProfit( 560000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 790000.0 );
        horse.setYearProfit( 230000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JUL .PHELIPPON" ) );
        horse.setOwner( owner( "JUL .PHELIPPON" ) );
        horse.setRancher( rancher( "MR ERWAN ROBIN" ) );
        horse.setJockey( jockey( "R.THOMAS" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 17 - MARELLE
     * HorseID - MARELLE
     */
    public static HorseID builderHorse_R7_H17_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MARELLE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "RAVEN'S PASS" );
        horseID.setMother( "MANDURA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 17 - MARELLE
     */

    public static Horse builderHorse_R7_H17( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H17_ID() );
        horse.setNumber( 17 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 14 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 350000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 350000.0 );
        horse.setYearProfit( 350000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MAR .HOFER" ) );
        horse.setOwner( owner( "STALL HELENA" ) );
        horse.setRancher( rancher( "MR ROLF BRUNNER" ) );
        horse.setJockey( jockey( "E.HARDOUIN" ) );

        return horse;

    }

    /*
     * Race 7
     * Odds 1 - 13/08/2015 12:31:32 +0200
     */

    public static Odds builderOdds_R7_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:32 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 15.3 ) );
        simples.add( simple( odds, "2", 8.8 ) );
        simples.add( simple( odds, "3", 16.7 ) );
        simples.add( simple( odds, "4", 22.4 ) );
        simples.add( simple( odds, "5", 15.0 ) );
        simples.add( simple( odds, "6", 10.5 ) );
        simples.add( simple( odds, "7", 5.1 ) );
        simples.add( simple( odds, "8", 29.9 ) );
        simples.add( simple( odds, "9", 36.0 ) );
        simples.add( simple( odds, "10", 5.8 ) );
        simples.add( simple( odds, "11", 26.0 ) );
        simples.add( simple( odds, "12", 17.6 ) );
        simples.add( simple( odds, "13", 22.6 ) );
        simples.add( simple( odds, "14", 31.5 ) );
        simples.add( simple( odds, "16", 20.1 ) );
        simples.add( simple( odds, "17", 10.6 ) );
        simples.add( simple( odds, "A", 5.7 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7
     * Odds 2 - 13/08/2015 15:57:37 +0200
     */

    public static Odds builderOdds_R7_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 15:57:37 +0200" ) );
        odds.setTotal( 165858.19 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 9.0 ) );
        simples.add( simple( odds, "2", 7.4 ) );
        simples.add( simple( odds, "3", 36.7 ) );
        simples.add( simple( odds, "4", 10.4 ) );
        simples.add( simple( odds, "5", 22.3 ) );
        simples.add( simple( odds, "6", 8.7 ) );
        simples.add( simple( odds, "7", 3.7 ) );
        simples.add( simple( odds, "8", 36.4 ) );
        simples.add( simple( odds, "9", 61.9 ) );
        simples.add( simple( odds, "10", 6.1 ) );
        simples.add( simple( odds, "11", 38.0 ) );
        simples.add( simple( odds, "12", 23.4 ) );
        simples.add( simple( odds, "13", 72.1 ) );
        simples.add( simple( odds, "14", 46.8 ) );
        simples.add( simple( odds, "15", 18.7 ) );
        simples.add( simple( odds, "16", 34.6 ) );
        simples.add( simple( odds, "17", 18.8 ) );
        simples.add( simple( odds, "A", 6.2 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 8 - PRIX MANOIR DE BENERVILLE - SPA ADRIANA KAREMBEU (PRIX D'ELLON)
     */

    public static Race builderRace_R8( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 8 );
        race.setName( "PRIX MANOIR DE BENERVILLE - SPA ADRIANA KAREMBEU (PRIX D'ELLON)" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 16:25:00 +0200" ) );
        // no real start
        race.setDistance( 1600.0 );
        race.setBenefit( 23000.0 );
        race.setDiscipline( Discipline.PLAT );
        race.setTypes( EnumSet.of( Type.HANDICAP ) );

        // -- horses --
        TreeSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R8_H1( race ) );
        horses.add( builderHorse_R8_H2( race ) );
        horses.add( builderHorse_R8_H3( race ) );
        horses.add( builderHorse_R8_H4( race ) );
        horses.add( builderHorse_R8_H5( race ) );
        horses.add( builderHorse_R8_H6( race ) );
        horses.add( builderHorse_R8_H7( race ) );
        horses.add( builderHorse_R8_H8( race ) );
        horses.add( builderHorse_R8_H9( race ) );
        horses.add( builderHorse_R8_H10( race ) );
        horses.add( builderHorse_R8_H11( race ) );
        horses.add( builderHorse_R8_H12( race ) );
        horses.add( builderHorse_R8_H13( race ) );
        horses.add( builderHorse_R8_H14( race ) );
        horses.add( builderHorse_R8_H15( race ) );
        horses.add( builderHorse_R8_H16( race ) );
        horses.add( builderHorse_R8_H17( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_ORDRE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.DEUX_SUR_QUATRE,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX,
                BetType.MULTI_EN_SEPT ) );

        // -- odds --
        TreeSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R8_O1( race ) );
        oddsSet.add( builderOdds_R8_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        TreeSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 13 ) );
        places.add( place( race,  2,  4, "UNE_LONGUEUR" ) );
        places.add( place( race,  3,  1, "UNE_LONGUEUR_ET_DEMIE" ) );
        places.add( place( race,  4,  9, "COURTE_ENCOLURE" ) );
        places.add( place( race,  5,  8, "COURTE_ENCOLURE" ) );
        places.add( place( race,  6,  6, "COURTE_ENCOLURE" ) );
        places.add( place( race,  7, 10, "UNE_LONGUEUR" ) );
        places.add( place( race,  8, 14, "DEMI_LONGUEUR" ) );
        places.add( place( race,  9, 15, "DEUX_LONGUEURS" ) );
        places.add( place( race, 10, 16, "TROIS_QUARTS_DE_LONGUEUR" ) );
        places.add( place( race, 11,  5, "UNE_LONGUEUR_ET_QUART" ) );
        places.add( place( race, 12,  3, "UNE_LONGUEUR" ) );
        places.add( place( race, 13, 11, "UNE_LONGUEUR_TROIS_QUARTS" ) );
        places.add( place( race, 14,  2, "DEUX_LONGUEURS_ET_DEMIE" ) );
        places.add( place( race, 15, 17, "TROIS_LONGUEURS" ) );
        race.setPlaces( places );

        // no stopped
        // no disqualified
        // no fallen

        // -- prices --
        TreeSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.8, "13" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "13" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "4" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 6.8, "13" ) );
        prices.add( price( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 28.2, "13 4" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 6.8, "13" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 12.5, "13 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.1, "1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.1, "13" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.8, "13 1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.5, "13 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.0, "4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.9, "4 1" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 6.8, "13" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 12.5, "13 4" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 17.9, "13 4 1" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "1" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "1 9" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "13" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "13 1" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "13 4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "13 9" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "4" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "4 1" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "4 9" ) );
        prices.add( price( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "9" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 105.0, "13 4 1 9" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 21.0, "13 4 1 9" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 7.0, "13 4 1 9" ) );
        prices.add( price( race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 3.0, "13 4 1 9" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 8
     * Horse 1 - ARCADIA
     * HorseID - ARCADIA
     */
    public static HorseID builderHorse_R8_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARCADIA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LOPE DE VEGA" );
        horseID.setMother( "RAMZIA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 8
     * Horse 1 - ARCADIA
     */

    public static Horse builderHorse_R8_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 14 );
        // no stable
        horse.setWeight( 61.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 1170000.0 );
        horse.setPreviousYearProfit( 250000.0 );
        horse.setVictoryProfit( 800000.0 );
        horse.setPlaceProfit( 370000.0 );
        horse.setYearProfit( 920000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "FH.GRAFFARD (S)" ) );
        horse.setOwner( owner( "THURLOE FRANCE LIMITED" ) );
        horse.setRancher( rancher( "AZIENDA AGRICOLA LUCIANI LORETO" ) );
        horse.setJockey( jockey( "PC.BOUDOT" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 2 - ANADUN
     * HorseID - ANADUN
     */
    public static HorseID builderHorse_R8_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ANADUN" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DUNKERQUE" );
        horseID.setMother( "GORITIE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 2 - ANADUN
     */

    public static Horse builderHorse_R8_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 9 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 2275000.0 );
        horse.setPreviousYearProfit( 1135000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 2275000.0 );
        horse.setYearProfit( 1140000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P.NICOT (S)" ) );
        horse.setOwner( owner( "J-J. MONTAGNE/P. NICOT (S)" ) );
        horse.setRancher( rancher( "HARAS DU QUESNAY" ) );
        horse.setJockey( jockey( "J.AUGE" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 3 - OJALA
     * HorseID - OJALA
     */
    public static HorseID builderHorse_R8_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "OJALA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DUNKERQUE" );
        horseID.setMother( "GIOCONDA UMBRA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 8
     * Horse 3 - OJALA
     */

    public static Horse builderHorse_R8_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 1 );
        // no stable
        horse.setWeight( 59.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 360000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 360000.0 );
        horse.setYearProfit( 360000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "D.SMAGA" ) );
        horse.setOwner( owner( "AM.HADDAD" ) );
        horse.setRancher( rancher( "MME MARIE-BENEDICTE FOUGY" ) );
        horse.setJockey( jockey( "G.BENOIST" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 4 - BLACK BIRD RUNS
     * HorseID - BLACK BIRD RUNS
     */
    public static HorseID builderHorse_R8_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BLACK BIRD RUNS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "EVASIVE" );
        horseID.setMother( "MOON TREE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 8
     * Horse 4 - BLACK BIRD RUNS
     */

    public static Horse builderHorse_R8_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 11 );
        // no stable
        horse.setWeight( 58.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 1835000.0 );
        horse.setPreviousYearProfit( 950000.0 );
        horse.setVictoryProfit( 950000.0 );
        horse.setPlaceProfit( 885000.0 );
        horse.setYearProfit( 885000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JUL .PHELIPPON" ) );
        horse.setOwner( owner( "MR J.DAUBLAIN/ MR J.PHELIPPON" ) );
        horse.setRancher( rancher( "MR GERARD BELLOIR" ) );
        horse.setJockey( jockey( "M.BARZALONA" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 5 - CITY PRINCESS
     * HorseID - CITY PRINCESS
     */
    public static HorseID builderHorse_R8_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CITY PRINCESS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ELUSIVE CITY" );
        horseID.setMother( "HASENE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 5 - CITY PRINCESS
     */

    public static Horse builderHorse_R8_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 2 );
        // no stable
        horse.setWeight( 57.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 195000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 195000.0 );
        horse.setYearProfit( 195000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.AUSTRALIAN );
        horse.setTrainer( trainer( "C&Y.LERNER (S)" ) );
        horse.setOwner( owner( "MME P. ADES-HAZAN/ ECURIE KURA" ) );
        horse.setRancher( rancher( "PONTCHARTRAIN STUD" ) );
        horse.setJockey( jockey( "C.SOUMILLON" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 6 - MANUCHA
     * HorseID - MANUCHA
     */
    public static HorseID builderHorse_R8_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MANUCHA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NAAQOOS" );
        horseID.setMother( "SISTER TROUBLE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 8
     * Horse 6 - MANUCHA
     */

    public static Horse builderHorse_R8_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 13 );
        // no stable
        horse.setWeight( 57.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 365000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 365000.0 );
        horse.setYearProfit( 365000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.HEAD (S)" ) );
        horse.setOwner( owner( "MME F.HEAD" ) );
        horse.setRancher( rancher( "MR IAN DENNIS FAIR" ) );
        horse.setJockey( jockey( "A.LEMAITRE" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 7 - LOVE FREEDOM
     * HorseID - LOVE FREEDOM
     */
    public static HorseID builderHorse_R8_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "LOVE FREEDOM" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SIR PERCY" );
        horseID.setMother( "FREEDOM PASS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 7 - LOVE FREEDOM
     */

    public static Horse builderHorse_R8_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 3 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 1195000.0 );
        horse.setPreviousYearProfit( 280000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1195000.0 );
        horse.setYearProfit( 915000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A&G.BOTTI (S)" ) );
        horse.setOwner( owner( "R.NG" ) );
        horse.setRancher( rancher( "MR GUY HEALD" ) );
        horse.setJockey( jockey( "C.DEMURO" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 8 - MYRLA
     * HorseID - MYRLA
     */
    public static HorseID builderHorse_R8_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "MYRLA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ELUSIVE CITY" );
        horseID.setMother( "AGIEL" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 8 - MYRLA
     */

    public static Horse builderHorse_R8_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 4 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 710000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 710000.0 );
        horse.setYearProfit( 710000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A.LYON (S)" ) );
        horse.setOwner( owner( "G.LINSOLAS" ) );
        horse.setRancher( rancher( "STILVI COMPANIA FINANCIERA S.A." ) );
        horse.setJockey( jockey( "J.CLAUDIC" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 9 - GREEN SEA TURTLE
     * HorseID - GREEN SEA TURTLE
     */
    public static HorseID builderHorse_R8_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "GREEN SEA TURTLE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "TURTLE BOWL" );
        horseID.setMother( "LUNACAT" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 9 - GREEN SEA TURTLE
     */

    public static Horse builderHorse_R8_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 16 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 355000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 355000.0 );
        horse.setYearProfit( 355000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.CHAPPET" ) );
        horse.setOwner( owner( "B.VAN DALFSEN" ) );
        horse.setRancher( rancher( "MR BEREND VAN DALFSEN" ) );
        horse.setJockey( jockey( "T.PICCONE" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 10 - ENTREE PARFAITE
     * HorseID - ENTREE PARFAITE
     */
    public static HorseID builderHorse_R8_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ENTREE PARFAITE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ENRIQUE" );
        horseID.setMother( "ENTRE DEUX MERS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 10 - ENTREE PARFAITE
     */

    public static Horse builderHorse_R8_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 12 );
        // no stable
        horse.setWeight( 56.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 330000.0 );
        horse.setPreviousYearProfit( 100000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 330000.0 );
        horse.setYearProfit( 230000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.FOUIN (S)" ) );
        horse.setOwner( owner( "Y.Y.FOUIN (S)" ) );
        horse.setRancher( rancher( "MLLE DELPHINE DELACROIX" ) );
        horse.setJockey( jockey( "S.PASQUIER" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 11 - SILVER OCEANE
     * HorseID - SILVER OCEANE
     */
    public static HorseID builderHorse_R8_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SILVER OCEANE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LAYMAN" );
        horseID.setMother( "FABULOUS ZOUIZA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 8
     * Horse 11 - SILVER OCEANE
     */

    public static Horse builderHorse_R8_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 5 );
        // no stable
        horse.setWeight( 55.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 125000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 125000.0 );
        horse.setYearProfit( 125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N.CAULLERY" ) );
        horse.setOwner( owner( "MME P.DESCARGUES" ) );
        horse.setRancher( rancher( "MR ARNAUD COURSIN" ) );
        horse.setJockey( jockey( "A.HAMELIN" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 12 - PETITE SONATE
     * HorseID - PETITE SONATE
     */
    public static HorseID builderHorse_R8_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "PETITE SONATE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SIYOUNI" );
        horseID.setMother( "JANE ERIA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 12 - PETITE SONATE
     */

    public static Horse builderHorse_R8_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 8 );
        // no stable
        horse.setWeight( 54.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 180000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 180000.0 );
        horse.setYearProfit( 180000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N.LEENDERS" ) );
        horse.setOwner( owner( "MME O.FAU" ) );
        horse.setRancher( rancher( "SNIG ELEVAGE" ) );
        horse.setJockey( jockey( "F.VERON" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 13 - ARGUROS
     * HorseID - ARGUROS
     */
    public static HorseID builderHorse_R8_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARGUROS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "VERGLAS" );
        horseID.setMother( "STATIA" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.GRIS );

        return horseID;

    }


    /*
     * Race 8
     * Horse 13 - ARGUROS
     */

    public static Horse builderHorse_R8_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 17 );
        // no stable
        horse.setWeight( 54.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 1245000.0 );
        horse.setPreviousYearProfit( 160000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1245000.0 );
        horse.setYearProfit( 1085000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "W.WALTON" ) );
        horse.setOwner( owner( "COFINVEST" ) );
        horse.setRancher( rancher( "HARAS DE LA HUDERIE" ) );
        horse.setJockey( jockey( "D.BREUX" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 14 - EIRIA
     * HorseID - EIRIA
     */
    public static HorseID builderHorse_R8_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "EIRIA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KING'S BEST" );
        horseID.setMother( "EIRE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 14 - EIRIA
     */

    public static Horse builderHorse_R8_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 6 );
        // no stable
        horse.setWeight( 54.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 950000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 950000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 950000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M&S.NIGGE (S)" ) );
        horse.setOwner( owner( "L.BONGEN" ) );
        horse.setRancher( rancher( "MR LUTZ BONGEN" ) );
        horse.setJockey( jockey( "M.DELALANDE" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 15 - DINGARI
     * HorseID - DINGARI
     */
    public static HorseID builderHorse_R8_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "DINGARI" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LINNGARI" );
        horseID.setMother( "DIAMANTWELLE" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 15 - DINGARI
     */

    public static Horse builderHorse_R8_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 10 );
        // no stable
        horse.setWeight( 53.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 855000.0 );
        horse.setPreviousYearProfit( 125000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 855000.0 );
        horse.setYearProfit( 730000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MAR .HOFER" ) );
        horse.setOwner( owner( "G.SINDERMANN" ) );
        horse.setRancher( rancher( "MR GERHARD SINDERMANN" ) );
        horse.setJockey( jockey( "U.RISPOLI" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 16 - C'EST ENTRE NOUS
     * HorseID - C'EST ENTRE NOUS
     */
    public static HorseID builderHorse_R8_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "C'EST ENTRE NOUS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "HIGH ROCK" );
        horseID.setMother( "KATUN" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 8
     * Horse 16 - C'EST ENTRE NOUS
     */

    public static Horse builderHorse_R8_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 7 );
        // no stable
        horse.setWeight( 53.5 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 60000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 60000.0 );
        horse.setYearProfit( 60000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME P.BUTEL" ) );
        horse.setOwner( owner( "MME P.BUTEL" ) );
        horse.setRancher( rancher( "MR PASCAL NOUE" ) );
        horse.setJockey( jockey( "R.MARCHELLI" ) );

        return horse;

    }

    /*
     * Race 8
     * Horse 17 - WOLGA
     * HorseID - WOLGA
     */
    public static HorseID builderHorse_R8_H17_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "WOLGA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "WHIPPER" );
        horseID.setMother( "LADY GLITTERS" );
        horseID.setBreed( Breed.PUR_SANG );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 8
     * Horse 17 - WOLGA
     */

    public static Horse builderHorse_R8_H17( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R8_H17_ID() );
        horse.setNumber( 17 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        horse.setStall( 15 );
        // no stable
        horse.setWeight( 52.0 );
        horse.setDistance( 1600.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P.VAN DE POELE (S)" ) );
        horse.setOwner( owner( "MME C.TRANCHANT-DASSAULT" ) );
        horse.setRancher( rancher( "S.C.A. ELEVAGE DE TOURGEVILLE" ) );
        horse.setJockey( jockey( "A.BADEL" ) );

        return horse;

    }

    /*
     * Race 8
     * Odds 1 - 13/08/2015 12:31:22 +0200
     */

    public static Odds builderOdds_R8_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:22 +0200" ) );
        // no total

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 9.5 ) );
        simples.add( simple( odds, "2", 20.3 ) );
        simples.add( simple( odds, "3", 12.5 ) );
        simples.add( simple( odds, "4", 9.6 ) );
        simples.add( simple( odds, "5", 9.7 ) );
        simples.add( simple( odds, "6", 9.5 ) );
        simples.add( simple( odds, "7", 4.8 ) );
        simples.add( simple( odds, "8", 19.7 ) );
        simples.add( simple( odds, "9", 14.4 ) );
        simples.add( simple( odds, "10", 10.3 ) );
        simples.add( simple( odds, "11", 13.6 ) );
        simples.add( simple( odds, "12", 11.1 ) );
        simples.add( simple( odds, "13", 7.5 ) );
        simples.add( simple( odds, "14", 21.7 ) );
        simples.add( simple( odds, "15", 14.7 ) );
        simples.add( simple( odds, "16", 15.8 ) );
        simples.add( simple( odds, "17", 13.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 8
     * Odds 2 - 13/08/2015 16:29:09 +0200
     */

    public static Odds builderOdds_R8_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 16:29:09 +0200" ) );
        odds.setTotal( 219676.33 );

        TreeSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 6.5 ) );
        simples.add( simple( odds, "2", 21.1 ) );
        simples.add( simple( odds, "3", 15.7 ) );
        simples.add( simple( odds, "4", 5.0 ) );
        simples.add( simple( odds, "5", 8.5 ) );
        simples.add( simple( odds, "6", 8.7 ) );
        simples.add( simple( odds, "7", 5.2 ) );
        simples.add( simple( odds, "8", 27.1 ) );
        simples.add( simple( odds, "9", 17.1 ) );
        simples.add( simple( odds, "10", 12.5 ) );
        simples.add( simple( odds, "11", 22.7 ) );
        simples.add( simple( odds, "12", 12.3 ) );
        simples.add( simple( odds, "13", 6.8 ) );
        simples.add( simple( odds, "14", 40.8 ) );
        simples.add( simple( odds, "15", 17.4 ) );
        simples.add( simple( odds, "16", 40.7 ) );
        simples.add( simple( odds, "17", 41.9 ) );
        odds.setSimples( simples );

        return odds;

    }

}
