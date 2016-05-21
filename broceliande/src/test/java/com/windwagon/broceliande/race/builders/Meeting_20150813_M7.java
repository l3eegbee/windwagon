package com.windwagon.broceliande.race.builders;

import java.util.EnumSet;
import java.util.SortedSet;
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

public class Meeting_20150813_M7 extends MeetingBuilder {

    public static Meeting build() {

        Meeting meeting = new Meeting();

        meeting.setDate( parse( "13/08/2015 00:00:00 +0200" ) );
        meeting.setRacecourse( racecourse( "GRAIGNES", "FRANCE" ) );
        meeting.setNumber( 7 );
        meeting.setWindSpeed( 3.0 );
        meeting.setWindDirection( WindDirection.E );
        meeting.setTemperature( 19.0 );
        meeting.setClimat( "ONDEES ORAGEUSES" );
        meeting.setField( Field.BON );

        // -- races --
        SortedSet<Race> races = new TreeSet<>();
        races.add( builderRace_R1( meeting ) );
        races.add( builderRace_R2( meeting ) );
        races.add( builderRace_R3( meeting ) );
        races.add( builderRace_R4( meeting ) );
        races.add( builderRace_R5( meeting ) );
        races.add( builderRace_R6( meeting ) );
        races.add( builderRace_R7( meeting ) );
        meeting.setRaces( races );

        return meeting;

    }

    /*
     * Race 1 - PRIX D'HEROUVILLE SAINT CLAIR
     */

    public static Race builderRace_R1( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 1 );
        race.setName( "PRIX D'HEROUVILLE SAINT CLAIR" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 19:25:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 13000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.noneOf( Type.class ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
        horses.add( builderHorse_R1_H1( race ) );
        horses.add( builderHorse_R1_H2( race ) );
        horses.add( builderHorse_R1_H3( race ) );
        horses.add( builderHorse_R1_H4( race ) );
        horses.add( builderHorse_R1_H5( race ) );
        horses.add( builderHorse_R1_H6( race ) );
        horses.add( builderHorse_R1_H7( race ) );
        horses.add( builderHorse_R1_H8( race ) );
        horses.add( builderHorse_R1_H9( race ) );
        horses.add( builderHorse_R1_H10( race ) );
        horses.add( builderHorse_R1_H11( race ) );
        horses.add( builderHorse_R1_H12( race ) );
        horses.add( builderHorse_R1_H13( race ) );
        horses.add( builderHorse_R1_H14( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R1_O1( race ) );
        oddsSet.add( builderOdds_R1_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 11, 211980 ) );
        places.add( place( race,  2,  4, 212920 ) );
        places.add( place( race,  3, 10, 212990 ) );
        places.add( place( race,  4, 14, 213510 ) );
        places.add( place( race,  5,  6, 213730 ) );
        places.add( place( race,  6,  7, 213960 ) );
        places.add( place( race,  7,  3, 214050 ) );
        places.add( place( race,  8,  1, 214070 ) );
        places.add( place( race,  9, 12, 214150 ) );
        places.add( place( race, 10,  8, 214730 ) );
        places.add( place( race, 11,  9, 222610 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "2 5 13" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.7, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "10" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "4" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 22.0, "11 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.7, "11 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.3, "11 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.5, "4 10" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 21.0, "11 4 10" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 1
     * Horse 1 - CESAR DE TILLARD
     * HorseID - CESAR DE TILLARD
     */
    public static HorseID builderHorse_R1_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CESAR DE TILLARD" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "SEVERINO" );
        horseID.setMother( "GRACE DE TILLARD" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 1 - CESAR DE TILLARD
     */

    public static Horse builderHorse_R1_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 388000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 388000.0 );
        horse.setYearProfit( 388000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ET. LEFRANC" ) );
        horse.setOwner( owner( "ECURIE ETIENNE LEFRANC" ) );
        // no rancher
        horse.setJockey( jockey( "ET. LEFRANC" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 2 - CHARLY DU HEURT
     * HorseID - CHARLY DU HEURT
     */
    public static HorseID builderHorse_R1_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHARLY DU HEURT" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "RICAN WAY" );
        horseID.setMother( "LORETTE DU HEURT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 2 - CHARLY DU HEURT
     */

    public static Horse builderHorse_R1_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 450000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 450000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "CH. LANCELIN" ) );
        horse.setOwner( owner( "CH. LANCELIN" ) );
        // no rancher
        horse.setJockey( jockey( "CH. LANCELIN" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 3 - CAPAC
     * HorseID - CAPAC
     */
    public static HorseID builderHorse_R1_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAPAC" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "QUITUS DU MEXIQUE" );
        horseID.setMother( "SERENA DU TIJAS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 3 - CAPAC
     */

    public static Horse builderHorse_R1_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 455000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 455000.0 );
        horse.setYearProfit( 455000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "V. JARRY" ) );
        horse.setOwner( owner( "D. DUPONT" ) );
        // no rancher
        horse.setJockey( jockey( "V. JARRY" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 4 - CESAR VOLO
     * HorseID - CESAR VOLO
     */
    public static HorseID builderHorse_R1_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CESAR VOLO" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "PRINCE DE MONTFORT" );
        horseID.setMother( "QUALITE VOLO" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 4 - CESAR VOLO
     */

    public static Horse builderHorse_R1_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 457000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 457000.0 );
        horse.setYearProfit( 457000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. VIEL" ) );
        horse.setOwner( owner( "P. VIEL" ) );
        // no rancher
        horse.setJockey( jockey( "S. LEVOY" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 5 - CAPRICE DE STAR
     * HorseID - CAPRICE DE STAR
     */
    public static HorseID builderHorse_R1_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAPRICE DE STAR" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "MELCHIOR JET" );
        horseID.setMother( "JALINGA DU LYS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_BRULE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 5 - CAPRICE DE STAR
     */

    public static Horse builderHorse_R1_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 520000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 520000.0 );
        horse.setYearProfit( 520000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. BERNIER" ) );
        horse.setOwner( owner( "S. BERNIER" ) );
        // no rancher
        horse.setJockey( jockey( "R. DELAUNE" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 6 - COCA DE GUEZ
     * HorseID - COCA DE GUEZ
     */
    public static HorseID builderHorse_R1_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "COCA DE GUEZ" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KOREAN" );
        horseID.setMother( "ORCHIDEE DE GUEZ" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 6 - COCA DE GUEZ
     */

    public static Horse builderHorse_R1_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 525000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 525000.0 );
        horse.setYearProfit( 525000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. ROBIN" ) );
        horse.setOwner( owner( "B. ROBIN" ) );
        // no rancher
        horse.setJockey( jockey( "B. ROBIN" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 7 - CHARLY DES CHAMPS
     * HorseID - CHARLY DES CHAMPS
     */
    public static HorseID builderHorse_R1_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHARLY DES CHAMPS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "SAPHIR D'HAUFOR" );
        horseID.setMother( "JAVANA DES CHAMPS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 7 - CHARLY DES CHAMPS
     */

    public static Horse builderHorse_R1_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 537000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 537000.0 );
        horse.setYearProfit( 537000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. GODARD" ) );
        horse.setOwner( owner( "J.M. GODARD" ) );
        // no rancher
        horse.setJockey( jockey( "J.M. GODARD" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 8 - COLYSTAR DU MOUTY
     * HorseID - COLYSTAR DU MOUTY
     */
    public static HorseID builderHorse_R1_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "COLYSTAR DU MOUTY" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "QUARO" );
        horseID.setMother( "OLYSTAR DU MOUTY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 8 - COLYSTAR DU MOUTY
     */

    public static Horse builderHorse_R1_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 560000.0 );
        horse.setPreviousYearProfit( 560000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 560000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. LETOUZE" ) );
        horse.setOwner( owner( "J. LECARDONNEL" ) );
        // no rancher
        horse.setJockey( jockey( "E. LETOUZE" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 9 - COLT DES FONTAINES
     * HorseID - COLT DES FONTAINES
     */
    public static HorseID builderHorse_R1_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "COLT DES FONTAINES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JASON DE VANDEL" );
        horseID.setMother( "DAME DE BEAUREGARD" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_FONCE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 9 - COLT DES FONTAINES
     */

    public static Horse builderHorse_R1_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 576000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 36000.0 );
        horse.setYearProfit( 576000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L.M. DAVID" ) );
        horse.setOwner( owner( "L.M. DAVID" ) );
        // no rancher
        horse.setJockey( jockey( "L.M. DAVID" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 10 - CRACK DU BOIS
     * HorseID - CRACK DU BOIS
     */
    public static HorseID builderHorse_R1_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CRACK DU BOIS" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "ROMBALDI" );
        horseID.setMother( "JUSQUIAME D'OR" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 10 - CRACK DU BOIS
     */

    public static Horse builderHorse_R1_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 581000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 581000.0 );
        horse.setYearProfit( 581000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.L. DERSOIR" ) );
        horse.setOwner( owner( "ECURIE LUCK" ) );
        // no rancher
        horse.setJockey( jockey( "G. GELORMINI" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 11 - CHARME KERYVON
     * HorseID - CHARME KERYVON
     */
    public static HorseID builderHorse_R1_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHARME KERYVON" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "OFFSHORE DREAM" );
        horseID.setMother( "JELICA KERYVON" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 11 - CHARME KERYVON
     */

    public static Horse builderHorse_R1_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 585000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 585000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "D. CHERBONNEL" ) );
        horse.setOwner( owner( "D. CHERBONNEL" ) );
        // no rancher
        horse.setJockey( jockey( "S. ERNAULT" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 12 - CYRUS DESTIN
     * HorseID - CYRUS DESTIN
     */
    public static HorseID builderHorse_R1_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CYRUS DESTIN" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "SAXO DE VANDEL" );
        horseID.setMother( "POPINEE DE TIMBIA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 12 - CYRUS DESTIN
     */

    public static Horse builderHorse_R1_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 594000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 594000.0 );
        horse.setYearProfit( 594000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. GUILLOTTE" ) );
        horse.setOwner( owner( "MME S. SCHWAR" ) );
        // no rancher
        horse.setJockey( jockey( "D. LOCQUENEUX" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 13 - COUP CHANCEUX
     * HorseID - COUP CHANCEUX
     */
    public static HorseID builderHorse_R1_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "COUP CHANCEUX" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ROCKLYN" );
        horseID.setMother( "ISEUT DE CHENU" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_CRIN_LAVE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 13 - COUP CHANCEUX
     */

    public static Horse builderHorse_R1_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 607000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 22000.0 );
        horse.setYearProfit( 607000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. HUBERT" ) );
        horse.setOwner( owner( "MME A.M. SPELLE" ) );
        // no rancher
        horse.setJockey( jockey( "A. HUBERT" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 14 - CONNOR CASH
     * HorseID - CONNOR CASH
     */
    public static HorseID builderHorse_R1_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CONNOR CASH" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MEAULNES DU CORTA" );
        horseID.setMother( "JOLIE MOME CASH" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 14 - CONNOR CASH
     */

    public static Horse builderHorse_R1_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 639000.0 );
        horse.setPreviousYearProfit( 74000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 639000.0 );
        horse.setYearProfit( 565000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L.M. DAVID" ) );
        horse.setOwner( owner( "L.M. DAVID" ) );
        // no rancher
        horse.setJockey( jockey( "S. BAUDE" ) );

        return horse;

    }

    /*
     * Race 1
     * Odds 1 - 13/08/2015 17:23:38 +0200
     */

    public static Odds builderOdds_R1_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:38 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 12.4 ) );
        simples.add( simple( odds, "2", 7.9 ) );
        simples.add( simple( odds, "3", 17.3 ) );
        simples.add( simple( odds, "4", 9.6 ) );
        simples.add( simple( odds, "5", 13.0 ) );
        simples.add( simple( odds, "6", 32.2 ) );
        simples.add( simple( odds, "7", 121.1 ) );
        simples.add( simple( odds, "8", 53.8 ) );
        simples.add( simple( odds, "9", 26.9 ) );
        simples.add( simple( odds, "10", 3.0 ) );
        simples.add( simple( odds, "11", 7.3 ) );
        simples.add( simple( odds, "12", 14.6 ) );
        simples.add( simple( odds, "13", 23.0 ) );
        simples.add( simple( odds, "14", 14.6 ) );
        simples.add( simple( odds, "A", 9.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 1
     * Odds 2 - 13/08/2015 19:25:28 +0200
     */

    public static Odds builderOdds_R1_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 19:25:28 +0200" ) );
        odds.setTotal( 2676.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 13.2 ) );
        simples.add( simple( odds, "2", 28.9 ) );
        simples.add( simple( odds, "3", 32.9 ) );
        simples.add( simple( odds, "4", 6.3 ) );
        simples.add( simple( odds, "5", 21.5 ) );
        simples.add( simple( odds, "6", 24.8 ) );
        simples.add( simple( odds, "7", 22.2 ) );
        simples.add( simple( odds, "8", 21.2 ) );
        simples.add( simple( odds, "9", 20.5 ) );
        simples.add( simple( odds, "10", 2.8 ) );
        simples.add( simple( odds, "11", 6.7 ) );
        simples.add( simple( odds, "12", 20.4 ) );
        simples.add( simple( odds, "13", 17.9 ) );
        simples.add( simple( odds, "14", 16.3 ) );
        simples.add( simple( odds, "A", 9.1 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2 - PRIX AMAND RIGAULT
     */

    public static Race builderRace_R2( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 2 );
        race.setName( "PRIX AMAND RIGAULT" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 19:50:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 13000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.noneOf( Type.class ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
        horses.add( builderHorse_R2_H13( race ) );
        horses.add( builderHorse_R2_H14( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R2_O1( race ) );
        oddsSet.add( builderOdds_R2_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  3, 213310 ) );
        places.add( place( race,  2,  8, 214490 ) );
        places.add( place( race,  3,  7, 215530 ) );
        places.add( place( race,  4, 12, 215640 ) );
        places.add( place( race,  5,  1, 216000 ) );
        places.add( place( race,  6,  9, 216140 ) );
        places.add( place( race,  7,  4, 216370 ) );
        places.add( place( race,  8, 14, 216670 ) );
        places.add( place( race,  9, 13, 217130 ) );
        places.add( place( race, 10,  5, 217290 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "2 6 10 11" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.5, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.9, "7" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "8" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 6.4, "3 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.7, "3 7" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.1, "3 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 14.6, "8 7" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 55.3, "3 8 7" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 2
     * Horse 1 - CHEYENNE DJAMES
     * HorseID - CHEYENNE DJAMES
     */
    public static HorseID builderHorse_R2_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHEYENNE DJAMES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "RIEUSSEC" );
        horseID.setMother( "PERLE D'AMOUR BLUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_BRULE );

        return horseID;

    }


    /*
     * Race 2
     * Horse 1 - CHEYENNE DJAMES
     */

    public static Horse builderHorse_R2_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 20000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 20000.0 );
        horse.setYearProfit( 20000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. LESOUEF" ) );
        horse.setOwner( owner( "J.M. BREVAULT" ) );
        // no rancher
        horse.setJockey( jockey( "R. LESOUEF" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 2 - CITY DELO
     * HorseID - CITY DELO
     */
    public static HorseID builderHorse_R2_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CITY DELO" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ISLERO DE BELLOUET" );
        horseID.setMother( "QUOSTIA D'HABERN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 2 - CITY DELO
     */

    public static Horse builderHorse_R2_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 75000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 75000.0 );
        horse.setYearProfit( 75000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. RENAULT" ) );
        horse.setOwner( owner( "MME E. MANGEARD" ) );
        // no rancher
        horse.setJockey( jockey( "J. JAMAULT" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 3 - CRANEUSE SARJO
     * HorseID - CRANEUSE SARJO
     */
    public static HorseID builderHorse_R2_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CRANEUSE SARJO" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OH JAMES" );
        horseID.setMother( "LOGA JOSSELYN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 3 - CRANEUSE SARJO
     */

    public static Horse builderHorse_R2_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 325000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 325000.0 );
        horse.setYearProfit( 325000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "TH. LEVESQUE" ) );
        horse.setOwner( owner( "ECURIE THOMAS LEVESQUE" ) );
        // no rancher
        horse.setJockey( jockey( "TH. LEVESQUE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 4 - CALECHE
     * HorseID - CALECHE
     */
    public static HorseID builderHorse_R2_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CALECHE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "QUAKER JET" );
        horseID.setMother( "NOUVELLE PERLE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 4 - CALECHE
     */

    public static Horse builderHorse_R2_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 418000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 418000.0 );
        horse.setYearProfit( 418000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. RUAULT" ) );
        horse.setOwner( owner( "ECURIE COMTE P. DE MONTESSON" ) );
        // no rancher
        horse.setJockey( jockey( "E. CANU" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 5 - CHIPIE D'YVI
     * HorseID - CHIPIE D'YVI
     */
    public static HorseID builderHorse_R2_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHIPIE D'YVI" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OVERTRICK" );
        horseID.setMother( "PRETTY D'YVI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 5 - CHIPIE D'YVI
     */

    public static Horse builderHorse_R2_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 442000.0 );
        horse.setPreviousYearProfit( 55000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 442000.0 );
        horse.setYearProfit( 387000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ST. MEUNIER" ) );
        horse.setOwner( owner( "ECURIE AURMATH" ) );
        // no rancher
        horse.setJockey( jockey( "J.L. LEREBOURG" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 6 - CIRCLE DRIVE
     * HorseID - CIRCLE DRIVE
     */
    public static HorseID builderHorse_R2_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CIRCLE DRIVE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GOETMALS WOOD" );
        horseID.setMother( "SELDOVIA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 6 - CIRCLE DRIVE
     */

    public static Horse builderHorse_R2_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 450000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 450000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "PH. ALLAIRE" ) );
        horse.setOwner( owner( "FABRICE SIMON" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE E. ALLAIRE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 7 - CALIE SIN
     * HorseID - CALIE SIN
     */
    public static HorseID builderHorse_R2_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CALIE SIN" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "SINGALO" );
        horseID.setMother( "QUEEN DU MONCEL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 7 - CALIE SIN
     */

    public static Horse builderHorse_R2_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 454000.0 );
        horse.setPreviousYearProfit( 143000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 454000.0 );
        horse.setYearProfit( 311000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "PH. DAUGEARD" ) );
        horse.setOwner( owner( "ECURIE PHILIPPE DAUGEARD" ) );
        // no rancher
        horse.setJockey( jockey( "PH. DAUGEARD" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 8 - CAPELLA DU PONT
     * HorseID - CAPELLA DU PONT
     */
    public static HorseID builderHorse_R2_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAPELLA DU PONT" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "QWERTY" );
        horseID.setMother( "LEVA DU PONT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 8 - CAPELLA DU PONT
     */

    public static Horse builderHorse_R2_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 542000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 542000.0 );
        horse.setYearProfit( 542000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.Y. RAYON" ) );
        horse.setOwner( owner( "ECURIE ALBERT RAYON" ) );
        // no rancher
        horse.setJockey( jockey( "TH. VIET" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 9 - COSTA MESLOISE
     * HorseID - COSTA MESLOISE
     */
    public static HorseID builderHorse_R2_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "COSTA MESLOISE" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LET'S GO ALONG" );
        horseID.setMother( "THELGA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 9 - COSTA MESLOISE
     */

    public static Horse builderHorse_R2_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 544000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 544000.0 );
        horse.setYearProfit( 544000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. BELLOCHE" ) );
        horse.setOwner( owner( "ECURIE BOIS DOUFRAY" ) );
        // no rancher
        horse.setJockey( jockey( "J.M. MARIE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 10 - CARMINE DU GOLLIER
     * HorseID - CARMINE DU GOLLIER
     */
    public static HorseID builderHorse_R2_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CARMINE DU GOLLIER" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "POWER JET" );
        horseID.setMother( "LOLITA DU GOLLIER" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 2
     * Horse 10 - CARMINE DU GOLLIER
     */

    public static Horse builderHorse_R2_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 565000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 565000.0 );
        horse.setYearProfit( 565000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. LEPIGEON" ) );
        horse.setOwner( owner( "R. LEPIGEON" ) );
        // no rancher
        horse.setJockey( jockey( "S. BAUDE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 11 - CAGNOISE D'AGON
     * HorseID - CAGNOISE D'AGON
     */
    public static HorseID builderHorse_R2_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAGNOISE D'AGON" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "NOBLESSE DE LARRE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 11 - CAGNOISE D'AGON
     */

    public static Horse builderHorse_R2_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 614000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 164000.0 );
        horse.setYearProfit( 614000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. HERNOT" ) );
        horse.setOwner( owner( "G. HERNOT" ) );
        // no rancher
        horse.setJockey( jockey( "G. HERNOT" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 12 - CHARLINA
     * HorseID - CHARLINA
     */
    public static HorseID builderHorse_R2_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CHARLINA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KENOR DE COSSE" );
        horseID.setMother( "KETTY LOVE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 12 - CHARLINA
     */

    public static Horse builderHorse_R2_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 629000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 89000.0 );
        horse.setYearProfit( 629000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. BERTHAULT" ) );
        horse.setOwner( owner( "M. DUTERTRE" ) );
        // no rancher
        horse.setJockey( jockey( "G. BERTHAULT" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 13 - CARLOVA
     * HorseID - CARLOVA
     */
    public static HorseID builderHorse_R2_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CARLOVA" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ECHO" );
        horseID.setMother( "NELLY CADENCE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 13 - CARLOVA
     */

    public static Horse builderHorse_R2_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 639000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 639000.0 );
        horse.setYearProfit( 639000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.ET. LE BEC" ) );
        horse.setOwner( owner( "J.ET. LE BEC" ) );
        // no rancher
        horse.setJockey( jockey( "B. MICHARDIERE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 14 - CAPRI DES BORDES
     * HorseID - CAPRI DES BORDES
     */
    public static HorseID builderHorse_R2_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "CAPRI DES BORDES" );
        horseID.setBirth( parse( "01/01/2012 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JASON DE VANDEL" );
        horseID.setMother( "ILLUSION DE BANNES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 14 - CAPRI DES BORDES
     */

    public static Horse builderHorse_R2_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R2_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 649000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 154000.0 );
        horse.setYearProfit( 649000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L.M. DAVID" ) );
        horse.setOwner( owner( "L. VINCENT" ) );
        // no rancher
        horse.setJockey( jockey( "L.M. DAVID" ) );

        return horse;

    }

    /*
     * Race 2
     * Odds 1 - 13/08/2015 17:23:17 +0200
     */

    public static Odds builderOdds_R2_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:17 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 118.7 ) );
        simples.add( simple( odds, "2", 118.7 ) );
        simples.add( simple( odds, "3", 5.3 ) );
        simples.add( simple( odds, "4", 18.2 ) );
        simples.add( simple( odds, "5", 6.5 ) );
        simples.add( simple( odds, "6", 39.5 ) );
        simples.add( simple( odds, "7", 12.8 ) );
        simples.add( simple( odds, "8", 11.3 ) );
        simples.add( simple( odds, "9", 16.3 ) );
        simples.add( simple( odds, "10", 19.0 ) );
        simples.add( simple( odds, "11", 8.9 ) );
        simples.add( simple( odds, "12", 23.7 ) );
        simples.add( simple( odds, "13", 3.5 ) );
        simples.add( simple( odds, "14", 31.6 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2
     * Odds 2 - 13/08/2015 19:51:02 +0200
     */

    public static Odds builderOdds_R2_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 19:51:02 +0200" ) );
        odds.setTotal( 2813.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 89.6 ) );
        simples.add( simple( odds, "2", 46.5 ) );
        simples.add( simple( odds, "3", 2.5 ) );
        simples.add( simple( odds, "4", 17.2 ) );
        simples.add( simple( odds, "5", 20.1 ) );
        simples.add( simple( odds, "6", 12.3 ) );
        simples.add( simple( odds, "7", 16.1 ) );
        simples.add( simple( odds, "8", 7.7 ) );
        simples.add( simple( odds, "9", 29.6 ) );
        simples.add( simple( odds, "10", 9.4 ) );
        simples.add( simple( odds, "11", 12.3 ) );
        simples.add( simple( odds, "12", 28.7 ) );
        simples.add( simple( odds, "13", 14.9 ) );
        simples.add( simple( odds, "14", 16.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3 - PRIX FELIX LEGUERNEY
     */

    public static Race builderRace_R3( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 3 );
        race.setName( "PRIX FELIX LEGUERNEY" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 20:15:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 15000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.noneOf( Type.class ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R3_O1( race ) );
        oddsSet.add( builderOdds_R3_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  4, 210160 ) );
        places.add( place( race,  2,  6, 210220 ) );
        places.add( place( race,  3,  2, 211700 ) );
        places.add( place( race,  4, 12, 213240 ) );
        places.add( place( race,  5,  9, 213290 ) );
        places.add( place( race,  6, 11, 213290 ) );
        places.add( place( race,  7, 13, 213700 ) );
        places.add( place( race,  8, 10, 213730 ) );
        places.add( place( race,  9,  8, 214130 ) );
        places.add( place( race, 10,  3, 214380 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "5" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.6, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.2, "2" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.5, "6" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 29.4, "4 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.0, "4 2" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.4, "4 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 17.8, "6 2" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 48.3, "4 6 2" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 3
     * Horse 1 - BOCAGE DU FOURNET
     * HorseID - BOCAGE DU FOURNET
     */
    public static HorseID builderHorse_R3_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOCAGE DU FOURNET" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "OURAGAN DE CELLAND" );
        horseID.setMother( "ROXANE DU FOURNET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_CLAIR );

        return horseID;

    }


    /*
     * Race 3
     * Horse 1 - BOCAGE DU FOURNET
     */

    public static Horse builderHorse_R3_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 629000.0 );
        horse.setPreviousYearProfit( 182000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 629000.0 );
        horse.setYearProfit( 447000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "W. GREEN" ) );
        horse.setOwner( owner( "W. GREEN" ) );
        // no rancher
        horse.setJockey( jockey( "W. GREEN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 2 - BRICHET BLEU
     * HorseID - BRICHET BLEU
     */
    public static HorseID builderHorse_R3_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRICHET BLEU" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ROMBALDI" );
        horseID.setMother( "SONATE VIERVIL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 2 - BRICHET BLEU
     */

    public static Horse builderHorse_R3_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 768000.0 );
        horse.setPreviousYearProfit( 768000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 228000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. ERNAULT" ) );
        horse.setOwner( owner( "M. GALLIER" ) );
        // no rancher
        horse.setJockey( jockey( "S. ERNAULT" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 3 - BOB LA CHANCE
     * HorseID - BOB LA CHANCE
     */
    public static HorseID builderHorse_R3_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOB LA CHANCE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "GOETMALS WOOD" );
        horseID.setMother( "KANGONE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 3 - BOB LA CHANCE
     */

    public static Horse builderHorse_R3_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 824800.0 );
        horse.setPreviousYearProfit( 284400.0 );
        horse.setVictoryProfit( 683400.0 );
        horse.setPlaceProfit( 139600.0 );
        horse.setYearProfit( 538600.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "T. FORKERUD" ) );
        horse.setOwner( owner( "L. HALLBERG AB" ) );
        // no rancher
        horse.setJockey( jockey( "J.M. MARIE" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 4 - BECOME MONEY
     * HorseID - BECOME MONEY
     */
    public static HorseID builderHorse_R3_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BECOME MONEY" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "SAM BOURBON" );
        horseID.setMother( "MAKING MONEY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 4 - BECOME MONEY
     */

    public static Horse builderHorse_R3_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 847800.0 );
        horse.setPreviousYearProfit( 307000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 307000.0 );
        horse.setYearProfit( 540000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "T. MALMQVIST" ) );
        horse.setOwner( owner( "STALL PANAMERA RACING" ) );
        // no rancher
        horse.setJockey( jockey( "D. LOCQUENEUX" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 5 - BANGURO
     * HorseID - BANGURO
     */
    public static HorseID builderHorse_R3_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BANGURO" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "READY CASH" );
        horseID.setMother( "LA SUEDOISE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 5 - BANGURO
     */

    public static Horse builderHorse_R3_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 857000.0 );
        horse.setPreviousYearProfit( 507000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 857000.0 );
        horse.setYearProfit( 350000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. NISKANEN" ) );
        horse.setOwner( owner( "ECURIE SKYTTEN" ) );
        // no rancher
        horse.setJockey( jockey( "J. NISKANEN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 6 - BRALON
     * HorseID - BRALON
     */
    public static HorseID builderHorse_R3_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRALON" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FIRST DE RETZ" );
        horseID.setMother( "OPHELIA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 6 - BRALON
     */

    public static Horse builderHorse_R3_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 905000.0 );
        horse.setPreviousYearProfit( 730000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 905000.0 );
        horse.setYearProfit( 175000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "PH. DAUGEARD" ) );
        horse.setOwner( owner( "A. BESNAINOU" ) );
        // no rancher
        horse.setJockey( jockey( "PH. DAUGEARD" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 7 - BYBLOS DE SOMOZA
     * HorseID - BYBLOS DE SOMOZA
     */
    public static HorseID builderHorse_R3_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BYBLOS DE SOMOZA" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ECHO" );
        horseID.setMother( "PANADA DE JOUY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 7 - BYBLOS DE SOMOZA
     */

    public static Horse builderHorse_R3_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1055000.0 );
        horse.setPreviousYearProfit( 990000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1055000.0 );
        horse.setYearProfit( 65000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. CAVEY" ) );
        horse.setOwner( owner( "E. CAVEY" ) );
        // no rancher
        horse.setJockey( jockey( "E. CAVEY" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 8 - BUSIS
     * HorseID - BUSIS
     */
    public static HorseID builderHorse_R3_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BUSIS" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PODOSIS" );
        horseID.setMother( "SAMUSETTE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 8 - BUSIS
     */

    public static Horse builderHorse_R3_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1756000.0 );
        horse.setPreviousYearProfit( 1271000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1756000.0 );
        horse.setYearProfit( 485000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "YVES LEDOYEN" ) );
        horse.setOwner( owner( "YVES LEDOYEN" ) );
        // no rancher
        horse.setJockey( jockey( "A. LEDOYEN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 9 - BLUE EYES VIKLAND
     * HorseID - BLUE EYES VIKLAND
     */
    public static HorseID builderHorse_R3_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BLUE EYES VIKLAND" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "GAZOUILLIS" );
        horseID.setMother( "KELOWNA PESCHARD" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 9 - BLUE EYES VIKLAND
     */

    public static Horse builderHorse_R3_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1945000.0 );
        horse.setPreviousYearProfit( 40000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1945000.0 );
        horse.setYearProfit( 1905000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F. HAREL" ) );
        horse.setOwner( owner( "ECURIE FRANCK HAREL" ) );
        // no rancher
        horse.setJockey( jockey( "F. HAREL" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 10 - BAS NORMAND
     * HorseID - BAS NORMAND
     */
    public static HorseID builderHorse_R3_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAS NORMAND" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "DIAMANT GEDE" );
        horseID.setMother( "GLOIRE NORMANDE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 10 - BAS NORMAND
     */

    public static Horse builderHorse_R3_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1965000.0 );
        horse.setPreviousYearProfit( 447000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1965000.0 );
        horse.setYearProfit( 1518000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "X. GUIBOUT" ) );
        horse.setOwner( owner( "MME M.CL. GUIBOUT" ) );
        // no rancher
        horse.setJockey( jockey( "J. POUTREL" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 11 - BELICIO WILD
     * HorseID - BELICIO WILD
     */
    public static HorseID builderHorse_R3_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BELICIO WILD" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KUADRO WILD" );
        horseID.setMother( "QUARINA BELLA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 11 - BELICIO WILD
     */

    public static Horse builderHorse_R3_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2196000.0 );
        horse.setPreviousYearProfit( 1806000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 2196000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.J. LE BEZVOET" ) );
        horse.setOwner( owner( "H. LAMY" ) );
        // no rancher
        horse.setJockey( jockey( "Y.J. LE BEZVOET" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 12 - BELLINO DE BOLERO
     * HorseID - BELLINO DE BOLERO
     */
    public static HorseID builderHorse_R3_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BELLINO DE BOLERO" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KOREAN" );
        horseID.setMother( "JALIE DE FEUGERES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 12 - BELLINO DE BOLERO
     */

    public static Horse builderHorse_R3_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2341000.0 );
        horse.setPreviousYearProfit( 840000.0 );
        horse.setVictoryProfit( 1800000.0 );
        horse.setPlaceProfit( 541000.0 );
        horse.setYearProfit( 1501000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HARDY" ) );
        horse.setOwner( owner( "ECURIE SEBASTIEN HARDY" ) );
        // no rancher
        horse.setJockey( jockey( "S. HARDY" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 13 - BALBOA ROCK
     * HorseID - BALBOA ROCK
     */
    public static HorseID builderHorse_R3_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BALBOA ROCK" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "RIEUSSEC" );
        horseID.setMother( "LA FEE D'HOUSSAYE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 13 - BALBOA ROCK
     */

    public static Horse builderHorse_R3_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R3_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2354000.0 );
        horse.setPreviousYearProfit( 1450000.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 1859000.0 );
        horse.setYearProfit( 384000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.P. LAMACHE" ) );
        horse.setOwner( owner( "J.P. LAMACHE" ) );
        // no rancher
        horse.setJockey( jockey( "S. BAUDE" ) );

        return horse;

    }

    /*
     * Race 3
     * Odds 1 - 13/08/2015 17:23:28 +0200
     */

    public static Odds builderOdds_R3_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:28 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 88.4 ) );
        simples.add( simple( odds, "2", 14.1 ) );
        simples.add( simple( odds, "3", 27.2 ) );
        simples.add( simple( odds, "4", 3.4 ) );
        simples.add( simple( odds, "5", 4.0 ) );
        simples.add( simple( odds, "6", 7.2 ) );
        simples.add( simple( odds, "7", 58.9 ) );
        simples.add( simple( odds, "8", 10.7 ) );
        simples.add( simple( odds, "9", 29.4 ) );
        simples.add( simple( odds, "10", 16.8 ) );
        simples.add( simple( odds, "11", 88.4 ) );
        simples.add( simple( odds, "12", 10.1 ) );
        simples.add( simple( odds, "13", 13.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3
     * Odds 2 - 13/08/2015 20:16:35 +0200
     */

    public static Odds builderOdds_R3_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 20:16:35 +0200" ) );
        odds.setTotal( 3311.0 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 55.8 ) );
        simples.add( simple( odds, "2", 12.8 ) );
        simples.add( simple( odds, "3", 33.4 ) );
        simples.add( simple( odds, "4", 2.6 ) );
        simples.add( simple( odds, "5", 6.0 ) );
        simples.add( simple( odds, "6", 16.2 ) );
        simples.add( simple( odds, "7", 50.8 ) );
        simples.add( simple( odds, "8", 29.1 ) );
        simples.add( simple( odds, "9", 33.2 ) );
        simples.add( simple( odds, "10", 21.1 ) );
        simples.add( simple( odds, "11", 60.0 ) );
        simples.add( simple( odds, "12", 6.8 ) );
        simples.add( simple( odds, "13", 6.2 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4 - PRIX QUERIDO II
     */

    public static Race builderRace_R4( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 4 );
        race.setName( "PRIX QUERIDO II" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 20:40:00 +0200" ) );
        // no real start
        race.setDistance( 2725.0 );
        race.setBenefit( 26000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.noneOf( Type.class ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
        horses.add( builderHorse_R4_H14( race ) );
        horses.add( builderHorse_R4_H15( race ) );
        horses.add( builderHorse_R4_H16( race ) );
        horses.add( builderHorse_R4_H17( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R4_O1( race ) );
        oddsSet.add( builderOdds_R4_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  8, 205520 ) );
        places.add( place( race,  2,  5, 205630 ) );
        places.add( place( race,  3, 10, 206070 ) );
        places.add( place( race,  4, 17, 206420 ) );
        places.add( place( race,  5, 16, 206570 ) );
        places.add( place( race,  6,  2, 206670 ) );
        places.add( place( race,  7,  3, 206770 ) );
        places.add( place( race,  8, 15, 206790 ) );
        places.add( place( race,  9,  6, 206850 ) );
        places.add( place( race, 10, 11, 207400 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "4" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 8.7, "8" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.1, "10" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "5" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.6, "8" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 8.7, "8" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 8.7, "8 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.1, "10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.6, "5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.5, "5 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.6, "8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 13.8, "8 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.1, "8 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "8" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "8 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 18.7, "8 5 10" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 4
     * Horse 1 - URANIE DE REALS
     * HorseID - URANIE DE REALS
     */
    public static HorseID builderHorse_R4_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URANIE DE REALS" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JEST" );
        horseID.setMother( "FORTUNE DE REALS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 1 - URANIE DE REALS
     */

    public static Horse builderHorse_R4_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5648000.0 );
        horse.setPreviousYearProfit( 254000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 5648000.0 );
        horse.setYearProfit( 65000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. CASTEL" ) );
        horse.setOwner( owner( "D. DE MORNAC" ) );
        // no rancher
        horse.setJockey( jockey( "G. CASTEL" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 2 - TEKENN LESMELCHEN
     * HorseID - TEKENN LESMELCHEN
     */
    public static HorseID builderHorse_R4_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TEKENN LESMELCHEN" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KIWI" );
        horseID.setMother( "BRUDED LESMELCHEN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 2 - TEKENN LESMELCHEN
     */

    public static Horse builderHorse_R4_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.48205E7 );
        horse.setPreviousYearProfit( 6624500.0 );
        horse.setVictoryProfit( 7555000.0 );
        horse.setPlaceProfit( 7265500.0 );
        horse.setYearProfit( 599000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. BEAUVAIS" ) );
        horse.setOwner( owner( "MME N. LEOST" ) );
        // no rancher
        horse.setJockey( jockey( "E. BEAUVAIS" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 3 - TIFOSI DU RIB
     * HorseID - TIFOSI DU RIB
     */
    public static HorseID builderHorse_R4_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TIFOSI DU RIB" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LOVE YOU" );
        horseID.setMother( "OCLARA DU RIB" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 3 - TIFOSI DU RIB
     */

    public static Horse builderHorse_R4_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.48605E7 );
        horse.setPreviousYearProfit( 1770000.0 );
        horse.setVictoryProfit( 7090000.0 );
        horse.setPlaceProfit( 7770500.0 );
        horse.setYearProfit( 695000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JOEL HALLAIS" ) );
        horse.setOwner( owner( "ECURIE RIB" ) );
        // no rancher
        horse.setJockey( jockey( "A. COLLETTE" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 4 - UBRINA NORMANDE
     * HorseID - UBRINA NORMANDE
     */
    public static HorseID builderHorse_R4_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UBRINA NORMANDE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KID WOOD" );
        horseID.setMother( "IBRINA DU PONCHET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 4 - UBRINA NORMANDE
     */

    public static Horse builderHorse_R4_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.4873E7 );
        horse.setPreviousYearProfit( 40000.0 );
        horse.setVictoryProfit( 1.159E7 );
        horse.setPlaceProfit( 3283000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. FOSSARD" ) );
        horse.setOwner( owner( "P. FOSSARD" ) );
        // no rancher
        horse.setJockey( jockey( "P. FOSSARD" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 5 - TEOMALTO CHEF
     * HorseID - TEOMALTO CHEF
     */
    public static HorseID builderHorse_R4_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TEOMALTO CHEF" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LOBELL DE MAREUIL" );
        horseID.setMother( "INCERTAINE MABON" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 4
     * Horse 5 - TEOMALTO CHEF
     */

    public static Horse builderHorse_R4_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.5121E7 );
        horse.setPreviousYearProfit( 1310000.0 );
        horse.setVictoryProfit( 7810000.0 );
        horse.setPlaceProfit( 7311000.0 );
        horse.setYearProfit( 350000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "C. CHENU" ) );
        horse.setOwner( owner( "CH. DREUX" ) );
        // no rancher
        horse.setJockey( jockey( "D. THOMAIN" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 6 - UPSON WEST
     * HorseID - UPSON WEST
     */
    public static HorseID builderHorse_R4_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UPSON WEST" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JASMIN DE FLORE" );
        horseID.setMother( "NOBLESSE DE BUSSET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 6 - UPSON WEST
     */

    public static Horse builderHorse_R4_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.55605E7 );
        horse.setPreviousYearProfit( 5903000.0 );
        horse.setVictoryProfit( 7885000.0 );
        horse.setPlaceProfit( 7675500.0 );
        horse.setYearProfit( 433000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ST. MEUNIER" ) );
        horse.setOwner( owner( "ECURIE HARAS DES QUATRE VENTS" ) );
        // no rancher
        horse.setJockey( jockey( "J.L. LEREBOURG" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 7 - TEMPO BOY
     * HorseID - TEMPO BOY
     */
    public static HorseID builderHorse_R4_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TEMPO BOY" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "FLAMBEAU DES PINS" );
        horseID.setMother( "JUNKIE GIRL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 7 - TEMPO BOY
     */

    public static Horse builderHorse_R4_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.5762E7 );
        horse.setPreviousYearProfit( 2760000.0 );
        horse.setVictoryProfit( 1.2625E7 );
        horse.setPlaceProfit( 3137000.0 );
        horse.setYearProfit( 52000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. COUEFFIN" ) );
        horse.setOwner( owner( "R. COUEFFIN" ) );
        // no rancher
        horse.setJockey( jockey( "F. LAGADEUC" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 8 - UN BEAU LUXOR
     * HorseID - UN BEAU LUXOR
     */
    public static HorseID builderHorse_R4_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UN BEAU LUXOR" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MEAULNES DU CORTA" );
        horseID.setMother( "NYMPHE LUXOR" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 8 - UN BEAU LUXOR
     */

    public static Horse builderHorse_R4_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1.5968E7 );
        horse.setPreviousYearProfit( 3912000.0 );
        horse.setVictoryProfit( 5745000.0 );
        horse.setPlaceProfit( 1.0223E7 );
        horse.setYearProfit( 203000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HARDY" ) );
        horse.setOwner( owner( "A. COHEN" ) );
        // no rancher
        horse.setJockey( jockey( "S. HARDY" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 9 - URGAH DU RIB
     * HorseID - URGAH DU RIB
     */
    public static HorseID builderHorse_R4_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URGAH DU RIB" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "GARDA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 9 - URGAH DU RIB
     */

    public static Horse builderHorse_R4_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.0444E7 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 4450000.0 );
        horse.setPlaceProfit( 5994000.0 );
        horse.setYearProfit( 1496000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "JOEL HALLAIS" ) );
        horse.setOwner( owner( "ECURIE RIB" ) );
        // no rancher
        horse.setJockey( jockey( "TH. LEVESQUE" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 10 - VOLTORB D'OLIVERIE
     * HorseID - VOLTORB D'OLIVERIE
     */
    public static HorseID builderHorse_R4_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VOLTORB D'OLIVERIE" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MOUROTAIS" );
        horseID.setMother( "BETTY D'OLIVERIE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 10 - VOLTORB D'OLIVERIE
     */

    public static Horse builderHorse_R4_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.2297E7 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 8350000.0 );
        horse.setPlaceProfit( 3947000.0 );
        horse.setYearProfit( 2092000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HOUYVET" ) );
        horse.setOwner( owner( "S. GABRIEL" ) );
        // no rancher
        horse.setJockey( jockey( "S. HOUYVET" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 11 - TANIA DU DERBY
     * HorseID - TANIA DU DERBY
     */
    public static HorseID builderHorse_R4_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TANIA DU DERBY" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "KELINOTTE DU DERBY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 11 - TANIA DU DERBY
     */

    public static Horse builderHorse_R4_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.2726E7 );
        horse.setPreviousYearProfit( 196000.0 );
        horse.setVictoryProfit( 5685000.0 );
        horse.setPlaceProfit( 7041000.0 );
        horse.setYearProfit( 2563000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "X. BARROIS" ) );
        horse.setOwner( owner( "D. BARROIS" ) );
        // no rancher
        horse.setJockey( jockey( "S. BAUDE" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 12 - UTELO DE CARENTONE
     * HorseID - UTELO DE CARENTONE
     */
    public static HorseID builderHorse_R4_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UTELO DE CARENTONE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KIWI" );
        horseID.setMother( "MAEVA D'HARCOUEL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 12 - UTELO DE CARENTONE
     */

    public static Horse builderHorse_R4_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.4213E7 );
        horse.setPreviousYearProfit( 3187000.0 );
        horse.setVictoryProfit( 5625000.0 );
        horse.setPlaceProfit( 8588000.0 );
        horse.setYearProfit( 1119000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. MAILLARD" ) );
        horse.setOwner( owner( "MME M. MAILLARD" ) );
        // no rancher
        horse.setJockey( jockey( "G. MAILLARD" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 13 - TENOR COURTAMBLAY
     * HorseID - TENOR COURTAMBLAY
     */
    public static HorseID builderHorse_R4_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TENOR COURTAMBLAY" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KEPLER" );
        horseID.setMother( "HORALIE BARBES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 13 - TENOR COURTAMBLAY
     */

    public static Horse builderHorse_R4_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.4503E7 );
        horse.setPreviousYearProfit( 2994000.0 );
        horse.setVictoryProfit( 7015000.0 );
        horse.setPlaceProfit( 7488000.0 );
        horse.setYearProfit( 2454000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. GUYARD" ) );
        horse.setOwner( owner( "A. GUYARD" ) );
        // no rancher
        horse.setJockey( jockey( "S. ERNAULT" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 14 - URANIUM
     * HorseID - URANIUM
     */
    public static HorseID builderHorse_R4_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URANIUM" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "L'AVENTURIERE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 14 - URANIUM
     */

    public static Horse builderHorse_R4_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.4613E7 );
        horse.setPreviousYearProfit( 7696000.0 );
        horse.setVictoryProfit( 8505000.0 );
        horse.setPlaceProfit( 6108000.0 );
        horse.setYearProfit( 2041000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "CH. GALLIER" ) );
        horse.setOwner( owner( "ECURIE CHRISTOPHE GALLIER" ) );
        // no rancher
        horse.setJockey( jockey( "CH. GALLIER" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 15 - TOUCH GREEN
     * HorseID - TOUCH GREEN
     */
    public static HorseID builderHorse_R4_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TOUCH GREEN" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ESPEYRAC SUN" );
        horseID.setMother( "NEMENINE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 15 - TOUCH GREEN
     */

    public static Horse builderHorse_R4_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.5605E7 );
        horse.setPreviousYearProfit( 1792000.0 );
        horse.setVictoryProfit( 1.158E7 );
        horse.setPlaceProfit( 4025000.0 );
        horse.setYearProfit( 2130000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. DELACOUR" ) );
        horse.setOwner( owner( "J.L. COLOMBIER" ) );
        // no rancher
        horse.setJockey( jockey( "G. DELACOUR" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 16 - UDINE DU DEZERT
     * HorseID - UDINE DU DEZERT
     */
    public static HorseID builderHorse_R4_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UDINE DU DEZERT" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LE RETOUR" );
        horseID.setMother( "LICENCE TO WIN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 16 - UDINE DU DEZERT
     */

    public static Horse builderHorse_R4_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.571E7 );
        horse.setPreviousYearProfit( 5567000.0 );
        horse.setVictoryProfit( 3585000.0 );
        horse.setPlaceProfit( 1.2125E7 );
        horse.setYearProfit( 3827000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. MARTIN" ) );
        horse.setOwner( owner( "CL. HAGEGE" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE C. CHERADAME" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 17 - TESSY DU MOULIN
     * HorseID - TESSY DU MOULIN
     */
    public static HorseID builderHorse_R4_H17_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TESSY DU MOULIN" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DAHIR DE PRELONG" );
        horseID.setMother( "LUNE DES GENETS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 17 - TESSY DU MOULIN
     */

    public static Horse builderHorse_R4_H17( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H17_ID() );
        horse.setNumber( 17 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.5926E7 );
        horse.setPreviousYearProfit( 6487000.0 );
        horse.setVictoryProfit( 1.121E7 );
        horse.setPlaceProfit( 4716000.0 );
        horse.setYearProfit( 2624000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. LORIN" ) );
        horse.setOwner( owner( "J.M. LORIN" ) );
        // no rancher
        horse.setJockey( jockey( "Y. LORIN" ) );

        return horse;

    }

    /*
     * Race 4
     * Odds 1 - 13/08/2015 17:23:16 +0200
     */

    public static Odds builderOdds_R4_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:16 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 236.9 ) );
        simples.add( simple( odds, "2", 25.6 ) );
        simples.add( simple( odds, "3", 45.1 ) );
        simples.add( simple( odds, "4", 157.9 ) );
        simples.add( simple( odds, "5", 4.1 ) );
        simples.add( simple( odds, "6", 32.6 ) );
        simples.add( simple( odds, "7", 78.9 ) );
        simples.add( simple( odds, "8", 9.2 ) );
        simples.add( simple( odds, "9", 9.0 ) );
        simples.add( simple( odds, "10", 5.2 ) );
        simples.add( simple( odds, "11", 27.0 ) );
        simples.add( simple( odds, "12", 28.7 ) );
        simples.add( simple( odds, "13", 16.9 ) );
        simples.add( simple( odds, "14", 105.3 ) );
        simples.add( simple( odds, "15", 12.6 ) );
        simples.add( simple( odds, "16", 31.5 ) );
        simples.add( simple( odds, "17", 5.8 ) );
        simples.add( simple( odds, "A", 7.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4
     * Odds 2 - 13/08/2015 19:04:39 +0200
     */

    public static Odds builderOdds_R4_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 19:04:39 +0200" ) );
        odds.setTotal( 4489.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 76.3 ) );
        simples.add( simple( odds, "2", 66.4 ) );
        simples.add( simple( odds, "3", 18.8 ) );
        simples.add( simple( odds, "4", 102.3 ) );
        simples.add( simple( odds, "5", 2.3 ) );
        simples.add( simple( odds, "6", 33.3 ) );
        simples.add( simple( odds, "7", 42.7 ) );
        simples.add( simple( odds, "8", 8.7 ) );
        simples.add( simple( odds, "9", 12.3 ) );
        simples.add( simple( odds, "10", 12.7 ) );
        simples.add( simple( odds, "11", 18.3 ) );
        simples.add( simple( odds, "12", 22.8 ) );
        simples.add( simple( odds, "13", 12.8 ) );
        simples.add( simple( odds, "14", 50.3 ) );
        simples.add( simple( odds, "15", 14.7 ) );
        simples.add( simple( odds, "16", 40.0 ) );
        simples.add( simple( odds, "17", 11.3 ) );
        simples.add( simple( odds, "A", 7.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5 - PRIX DES CIGOGNES
     */

    public static Race builderRace_R5( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 5 );
        race.setName( "PRIX DES CIGOGNES" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 21:05:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 15000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of(
                Type.APPRENTIS,
                Type.LADS_JOCKEYS ) );
        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
        horses.add( builderHorse_R5_H13( race ) );
        horses.add( builderHorse_R5_H14( race ) );
        horses.add( builderHorse_R5_H15( race ) );
        horses.add( builderHorse_R5_H16( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R5_O1( race ) );
        oddsSet.add( builderOdds_R5_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1, 16, 213680 ) );
        places.add( place( race,  2,  6, 214380 ) );
        places.add( place( race,  3, 11, 215210 ) );
        places.add( place( race,  4, 12, 215400 ) );
        places.add( place( race,  5, 14, 215610 ) );
        places.add( place( race,  6,  8, 215660 ) );
        places.add( place( race,  7,  9, 216280 ) );
        places.add( place( race,  8, 10, 216710 ) );
        places.add( place( race,  9,  1, 217300 ) );
        places.add( place( race, 10, 13, 218600 ) );
        race.setPlaces( places );

        race.setStopped( "3" );
        race.setDisqualified( "2 5 7 15" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.7, "16" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.5, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.5, "16" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 9.7, "6" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 218.1, "16 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 27.1, "16 11" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 64.5, "16 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 46.3, "6 11" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 244.0, "16 11 12" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "16 6 11" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 5
     * Horse 1 - BAZOUGERE DE FHAM
     * HorseID - BAZOUGERE DE FHAM
     */
    public static HorseID builderHorse_R5_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAZOUGERE DE FHAM" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "QUICK WOOD" );
        horseID.setMother( "NAIDELISSE DE FHAM" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 1 - BAZOUGERE DE FHAM
     */

    public static Horse builderHorse_R5_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 71000.0 );
        horse.setPreviousYearProfit( 11000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 71000.0 );
        horse.setYearProfit( 60000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. BARASSIN" ) );
        horse.setOwner( owner( "R. FRILOUX" ) );
        // no rancher
        horse.setJockey( jockey( "TH. BARASSIN" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 2 - BAHIA DE LA FYE
     * HorseID - BAHIA DE LA FYE
     */
    public static HorseID builderHorse_R5_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAHIA DE LA FYE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NIKY" );
        horseID.setMother( "OURA YONI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 2 - BAHIA DE LA FYE
     */

    public static Horse builderHorse_R5_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 678000.0 );
        horse.setPreviousYearProfit( 622000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 678000.0 );
        horse.setYearProfit( 56000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HARDY" ) );
        horse.setOwner( owner( "ECURIE SEBASTIEN HARDY" ) );
        // no rancher
        horse.setJockey( jockey( "C. GODARD" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 3 - BRUME DU BOSQ
     * HorseID - BRUME DU BOSQ
     */
    public static HorseID builderHorse_R5_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRUME DU BOSQ" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "PLAYER" );
        horseID.setMother( "PLEIADE DU BOSQ" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 3 - BRUME DU BOSQ
     */

    public static Horse builderHorse_R5_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 936000.0 );
        horse.setPreviousYearProfit( 50000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 936000.0 );
        horse.setYearProfit( 886000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.L. GIOT" ) );
        horse.setOwner( owner( "J.L. GIOT" ) );
        // no rancher
        horse.setJockey( jockey( "N. DELAMARRE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 4 - BLUME DU GOLLIER
     * HorseID - BLUME DU GOLLIER
     */
    public static HorseID builderHorse_R5_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BLUME DU GOLLIER" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "POWER JET" );
        horseID.setMother( "DALOMA CASTELETS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 4 - BLUME DU GOLLIER
     */

    public static Horse builderHorse_R5_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 943000.0 );
        horse.setPreviousYearProfit( 598000.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 493000.0 );
        horse.setYearProfit( 345000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. LEPIGEON" ) );
        horse.setOwner( owner( "R. LEPIGEON" ) );
        // no rancher
        horse.setJockey( jockey( "R. SEVESTRE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 5 - BEAUCHANAISE
     * HorseID - BEAUCHANAISE
     */
    public static HorseID builderHorse_R5_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BEAUCHANAISE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "GRACE DU COGLAIS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 5 - BEAUCHANAISE
     */

    public static Horse builderHorse_R5_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 994000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 675000.0 );
        horse.setPlaceProfit( 319000.0 );
        horse.setYearProfit( 994000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.F. POPOT" ) );
        horse.setOwner( owner( "ECURIE JEAN FRANCOIS POPOT" ) );
        // no rancher
        horse.setJockey( jockey( "A. POPOT" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 6 - BISE DELO
     * HorseID - BISE DELO
     */
    public static HorseID builderHorse_R5_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BISE DELO" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LAETENTER DIEM" );
        horseID.setMother( "ELUE DES ARTS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 6 - BISE DELO
     */

    public static Horse builderHorse_R5_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1037000.0 );
        horse.setPreviousYearProfit( 575000.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 542000.0 );
        horse.setYearProfit( 462000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. RENAULT" ) );
        horse.setOwner( owner( "MME E. MANGEARD" ) );
        // no rancher
        horse.setJockey( jockey( "J. JAMAULT" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 7 - BEA ROYALE
     * HorseID - BEA ROYALE
     */
    public static HorseID builderHorse_R5_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BEA ROYALE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OLITRO" );
        horseID.setMother( "OLLY DE CAHOT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 7 - BEA ROYALE
     */

    public static Horse builderHorse_R5_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1058000.0 );
        horse.setPreviousYearProfit( 746000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1058000.0 );
        horse.setYearProfit( 232000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.PH. RAFFEGEAU" ) );
        horse.setOwner( owner( "ECURIE J.Y. ET J.P. RAFFEGEAU" ) );
        // no rancher
        horse.setJockey( jockey( "F. PRIOUL" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 8 - BELLE DE CADIX
     * HorseID - BELLE DE CADIX
     */
    public static HorseID builderHorse_R5_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BELLE DE CADIX" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "CARPE DIEM" );
        horseID.setMother( "JONQUILLE DE MAI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 8 - BELLE DE CADIX
     */

    public static Horse builderHorse_R5_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 1099000.0 );
        horse.setPreviousYearProfit( 578000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1099000.0 );
        horse.setYearProfit( 521000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L.A. MARTIN" ) );
        horse.setOwner( owner( "L.A. MARTIN" ) );
        // no rancher
        horse.setJockey( jockey( "EMILIEN RAULLINE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 9 - BRUME D'OURVILLE
     * HorseID - BRUME D'OURVILLE
     */
    public static HorseID builderHorse_R5_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRUME D'OURVILLE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "PRODIGIOUS" );
        horseID.setMother( "MONA D'ODYSSEE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 9 - BRUME D'OURVILLE
     */

    public static Horse builderHorse_R5_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1840000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1305000.0 );
        horse.setPlaceProfit( 535000.0 );
        horse.setYearProfit( 1070000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. GUARATO" ) );
        horse.setOwner( owner( "ECURIE J.P. RAFFRE" ) );
        // no rancher
        horse.setJockey( jockey( "G. JOUVE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 10 - BELLE AU VENT
     * HorseID - BELLE AU VENT
     */
    public static HorseID builderHorse_R5_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BELLE AU VENT" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "LA FUSEE DES BOIS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 10 - BELLE AU VENT
     */

    public static Horse builderHorse_R5_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1861000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1861000.0 );
        horse.setYearProfit( 1861000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. MARTIN" ) );
        horse.setOwner( owner( "J. SEUX" ) );
        // no rancher
        horse.setJockey( jockey( "J. ALMIN" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 11 - BRIGHT GIRL
     * HorseID - BRIGHT GIRL
     */
    public static HorseID builderHorse_R5_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRIGHT GIRL" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NORGINIO" );
        horseID.setMother( "NUTTY GIRL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 5
     * Horse 11 - BRIGHT GIRL
     */

    public static Horse builderHorse_R5_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1923000.0 );
        horse.setPreviousYearProfit( 838000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1923000.0 );
        horse.setYearProfit( 1085000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. CARPENTIER" ) );
        horse.setOwner( owner( "J.F. GOUBET" ) );
        // no rancher
        horse.setJockey( jockey( "Q. MACHET" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 12 - BANGKOK
     * HorseID - BANGKOK
     */
    public static HorseID builderHorse_R5_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BANGKOK" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GOETMALS WOOD" );
        horseID.setMother( "OSHIMA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 12 - BANGKOK
     */

    public static Horse builderHorse_R5_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1965000.0 );
        horse.setPreviousYearProfit( 857000.0 );
        horse.setVictoryProfit( 1260000.0 );
        horse.setPlaceProfit( 705000.0 );
        horse.setYearProfit( 1108000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.W. HALLAIS" ) );
        horse.setOwner( owner( "ECURIE J.CL. HALLAIS" ) );
        // no rancher
        horse.setJockey( jockey( "J.B. DHONDT" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 13 - BAHIA D'IQUAINE
     * HorseID - BAHIA D'IQUAINE
     */
    public static HorseID builderHorse_R5_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAHIA D'IQUAINE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OURAGAN DE CELLAND" );
        horseID.setMother( "OREALE D'IQUAINE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 13 - BAHIA D'IQUAINE
     */

    public static Horse builderHorse_R5_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2003000.0 );
        horse.setPreviousYearProfit( 1097000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 2003000.0 );
        horse.setYearProfit( 906000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. LEMETAYER" ) );
        horse.setOwner( owner( "S. LEMETAYER" ) );
        // no rancher
        horse.setJockey( jockey( "L. SZCZESNY" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 14 - BAILA DELADOU
     * HorseID - BAILA DELADOU
     */
    public static HorseID builderHorse_R5_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAILA DELADOU" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ORLANDO VICI" );
        horseID.setMother( "ROMY DE FROMENTEL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 14 - BAILA DELADOU
     */

    public static Horse builderHorse_R5_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2009000.0 );
        horse.setPreviousYearProfit( 1181000.0 );
        horse.setVictoryProfit( 1170000.0 );
        horse.setPlaceProfit( 839000.0 );
        horse.setYearProfit( 828000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME V. LECROQ" ) );
        horse.setOwner( owner( "E. DUFOUR" ) );
        // no rancher
        horse.setJockey( jockey( "D. LECROQ" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 15 - BARTAVELLE SEGAH
     * HorseID - BARTAVELLE SEGAH
     */
    public static HorseID builderHorse_R5_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BARTAVELLE SEGAH" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GAZOUILLIS" );
        horseID.setMother( "MESANGE DU RIB" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 15 - BARTAVELLE SEGAH
     */

    public static Horse builderHorse_R5_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2156000.0 );
        horse.setPreviousYearProfit( 1174000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 2156000.0 );
        horse.setYearProfit( 982000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HOUYVET" ) );
        horse.setOwner( owner( "G. DUFIT" ) );
        // no rancher
        horse.setJockey( jockey( "Y. SALAUN" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 16 - BELLE DE VARVILLE
     * HorseID - BELLE DE VARVILLE
     */
    public static HorseID builderHorse_R5_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BELLE DE VARVILLE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LOULOU JET" );
        horseID.setMother( "CAROLA DE LA MOTTE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 16 - BELLE DE VARVILLE
     */

    public static Horse builderHorse_R5_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2357000.0 );
        horse.setPreviousYearProfit( 1187000.0 );
        horse.setVictoryProfit( 1530000.0 );
        horse.setPlaceProfit( 827000.0 );
        horse.setYearProfit( 1170000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G.H. VIBERT" ) );
        horse.setOwner( owner( "G.H. VIBERT" ) );
        // no rancher
        horse.setJockey( jockey( "M. HOUAL" ) );

        return horse;

    }

    /*
     * Race 5
     * Odds 1 - 13/08/2015 17:23:38 +0200
     */

    public static Odds builderOdds_R5_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:38 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 12.8 ) );
        simples.add( simple( odds, "2", 27.1 ) );
        simples.add( simple( odds, "3", 81.5 ) );
        simples.add( simple( odds, "5", 9.7 ) );
        simples.add( simple( odds, "7", 27.1 ) );
        simples.add( simple( odds, "8", 24.4 ) );
        simples.add( simple( odds, "9", 3.9 ) );
        simples.add( simple( odds, "10", 20.3 ) );
        simples.add( simple( odds, "11", 17.4 ) );
        simples.add( simple( odds, "12", 18.8 ) );
        simples.add( simple( odds, "13", 27.1 ) );
        simples.add( simple( odds, "14", 61.1 ) );
        simples.add( simple( odds, "15", 4.0 ) );
        simples.add( simple( odds, "16", 5.9 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5
     * Odds 2 - 13/08/2015 21:09:27 +0200
     */

    public static Odds builderOdds_R5_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 21:09:27 +0200" ) );
        odds.setTotal( 4437.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 32.0 ) );
        simples.add( simple( odds, "2", 27.1 ) );
        simples.add( simple( odds, "3", 28.4 ) );
        simples.add( simple( odds, "4", 31.6 ) );
        simples.add( simple( odds, "5", 4.0 ) );
        simples.add( simple( odds, "6", 36.7 ) );
        simples.add( simple( odds, "7", 58.9 ) );
        simples.add( simple( odds, "8", 21.4 ) );
        simples.add( simple( odds, "9", 18.6 ) );
        simples.add( simple( odds, "10", 8.3 ) );
        simples.add( simple( odds, "11", 22.6 ) );
        simples.add( simple( odds, "12", 8.4 ) );
        simples.add( simple( odds, "13", 24.3 ) );
        simples.add( simple( odds, "14", 7.9 ) );
        simples.add( simple( odds, "15", 16.6 ) );
        simples.add( simple( odds, "16", 6.7 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6 - PRIX LANDOAS
     */

    public static Race builderRace_R6( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 6 );
        race.setName( "PRIX LANDOAS" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 21:35:00 +0200" ) );
        // no real start
        race.setDistance( 2725.0 );
        race.setBenefit( 15000.0 );
        race.setDiscipline( Discipline.TROT_MONTE );
        race.setTypes( EnumSet.of( Type.APPRENTIS ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R6_O1( race ) );
        oddsSet.add( builderOdds_R6_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  6, 209520 ) );
        places.add( place( race,  2, 10, 209850 ) );
        places.add( place( race,  3,  9, 209940 ) );
        places.add( place( race,  4,  2, 210920 ) );
        places.add( place( race,  5,  7, 211100 ) );
        places.add( place( race,  6,  4, 211460 ) );
        places.add( place( race,  7,  3, 211930 ) );
        places.add( place( race,  8,  5, 212100 ) );
        places.add( place( race,  9,  8, 212140 ) );
        places.add( place( race, 10,  1, 213180 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "11" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.3, "6" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.3, "10" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.4, "6" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.0, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 24.9, "6 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 14.2, "10 9" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.2, "6 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.2, "6 9" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 65.9, "6 10 9" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 6
     * Horse 1 - A TOUS LES VENTS
     * HorseID - A TOUS LES VENTS
     */
    public static HorseID builderHorse_R6_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "A TOUS LES VENTS" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ILLICO PRESTO" );
        horseID.setMother( "LA FUSEE DES BOIS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 6
     * Horse 1 - A TOUS LES VENTS
     */

    public static Horse builderHorse_R6_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 3981000.0 );
        horse.setPreviousYearProfit( 646000.0 );
        horse.setVictoryProfit( 675000.0 );
        horse.setPlaceProfit( 3306000.0 );
        horse.setYearProfit( 1996000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. VARIN" ) );
        horse.setOwner( owner( "D. GUEROULT" ) );
        // no rancher
        horse.setJockey( jockey( "W. SOUCHET" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 2 - ALEZAN D'ORTIGE
     * HorseID - ALEZAN D'ORTIGE
     */
    public static HorseID builderHorse_R6_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALEZAN D'ORTIGE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "GOBERNADOR" );
        horseID.setMother( "ETOILE DE GINAI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 2 - ALEZAN D'ORTIGE
     */

    public static Horse builderHorse_R6_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4000000.0 );
        horse.setPreviousYearProfit( 2875000.0 );
        horse.setVictoryProfit( 1800000.0 );
        horse.setPlaceProfit( 2200000.0 );
        horse.setYearProfit( 1125000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "W. BIGEON" ) );
        horse.setOwner( owner( "J. SECHE" ) );
        // no rancher
        horse.setJockey( jockey( "J. BALU" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 3 - AFRICAN GIRL
     * HorseID - AFRICAN GIRL
     */
    public static HorseID builderHorse_R6_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AFRICAN GIRL" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OARDO" );
        horseID.setMother( "PEPETTE JOLIE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 6
     * Horse 3 - AFRICAN GIRL
     */

    public static Horse builderHorse_R6_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4031000.0 );
        horse.setPreviousYearProfit( 1694000.0 );
        horse.setVictoryProfit( 1485000.0 );
        horse.setPlaceProfit( 2546000.0 );
        horse.setYearProfit( 943000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.PH. RAFFEGEAU" ) );
        horse.setOwner( owner( "ECURIE J.Y. ET J.P. RAFFEGEAU" ) );
        // no rancher
        horse.setJockey( jockey( "F. PRIOUL" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 4 - AMI DE SAINTHO
     * HorseID - AMI DE SAINTHO
     */
    public static HorseID builderHorse_R6_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMI DE SAINTHO" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "IF" );
        horseID.setMother( "JOUTE DE SAINTHO" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 4 - AMI DE SAINTHO
     */

    public static Horse builderHorse_R6_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4559000.0 );
        horse.setPreviousYearProfit( 2187000.0 );
        horse.setVictoryProfit( 1215000.0 );
        horse.setPlaceProfit( 3344000.0 );
        horse.setYearProfit( 2138000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. ONFROY" ) );
        horse.setOwner( owner( "H. ONFROY" ) );
        // no rancher
        horse.setJockey( jockey( "M. KROUCHI" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 5 - ASSIM DES GLENAN
     * HorseID - ASSIM DES GLENAN
     */
    public static HorseID builderHorse_R6_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ASSIM DES GLENAN" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KENOR DE COSSE" );
        horseID.setMother( "JOYCE JAMES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 5 - ASSIM DES GLENAN
     */

    public static Horse builderHorse_R6_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4852000.0 );
        horse.setPreviousYearProfit( 672000.0 );
        horse.setVictoryProfit( 1440000.0 );
        horse.setPlaceProfit( 3412000.0 );
        horse.setYearProfit( 365000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. HUBERT" ) );
        horse.setOwner( owner( "A. HUBERT" ) );
        // no rancher
        horse.setJockey( jockey( "A.PH. GRIMAULT" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 6 - AVRIL DU BOTTEY
     * HorseID - AVRIL DU BOTTEY
     */
    public static HorseID builderHorse_R6_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AVRIL DU BOTTEY" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LILIUM MADRIK" );
        horseID.setMother( "JILIANE DU BOTTEY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 6 - AVRIL DU BOTTEY
     */

    public static Horse builderHorse_R6_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4916000.0 );
        horse.setPreviousYearProfit( 3307000.0 );
        horse.setVictoryProfit( 3015000.0 );
        horse.setPlaceProfit( 1901000.0 );
        horse.setYearProfit( 1065000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.P. RUCKEBUSCH" ) );
        horse.setOwner( owner( "J.P. RUCKEBUSCH" ) );
        // no rancher
        horse.setJockey( jockey( "F. DESMIGNEUX" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 7 - AZAN D'AZIF
     * HorseID - AZAN D'AZIF
     */
    public static HorseID builderHorse_R6_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AZAN D'AZIF" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KEPLER" );
        horseID.setMother( "NECYLA DE LESPI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 7 - AZAN D'AZIF
     */

    public static Horse builderHorse_R6_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5053000.0 );
        horse.setPreviousYearProfit( 2092000.0 );
        horse.setVictoryProfit( 2745000.0 );
        horse.setPlaceProfit( 2308000.0 );
        horse.setYearProfit( 1872000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. BIHEL" ) );
        horse.setOwner( owner( "R. RUGGERI" ) );
        // no rancher
        horse.setJockey( jockey( "A. COLLETTE" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 8 - AS DE L'AUMOY
     * HorseID - AS DE L'AUMOY
     */
    public static HorseID builderHorse_R6_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AS DE L'AUMOY" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PALEO DU FRUITIER" );
        horseID.setMother( "QUALLA DE VIVE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 8 - AS DE L'AUMOY
     */

    public static Horse builderHorse_R6_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5149000.0 );
        horse.setPreviousYearProfit( 2765000.0 );
        horse.setVictoryProfit( 1170000.0 );
        horse.setPlaceProfit( 3979000.0 );
        horse.setYearProfit( 1333000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ST. MEUNIER" ) );
        horse.setOwner( owner( "R. MAZZETTI" ) );
        // no rancher
        horse.setJockey( jockey( "B. LEREBOURG" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 9 - A CAPPELLA VET
     * HorseID - A CAPPELLA VET
     */
    public static HorseID builderHorse_R6_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "A CAPPELLA VET" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MAGNIFICENT RODNEY" );
        horseID.setMother( "HARMONIE CHERY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 9 - A CAPPELLA VET
     */

    public static Horse builderHorse_R6_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5191000.0 );
        horse.setPreviousYearProfit( 3371000.0 );
        horse.setVictoryProfit( 2880000.0 );
        horse.setPlaceProfit( 2311000.0 );
        horse.setYearProfit( 532000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. LE BELLER" ) );
        horse.setOwner( owner( "A. TRIOMPHE" ) );
        // no rancher
        horse.setJockey( jockey( "MME E. LE BELLER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 10 - ARTEMIS DU FAUCON
     * HorseID - ARTEMIS DU FAUCON
     */
    public static HorseID builderHorse_R6_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARTEMIS DU FAUCON" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NEW DES LANDES" );
        horseID.setMother( "PREMIERE D'ISMAEL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 10 - ARTEMIS DU FAUCON
     */

    public static Horse builderHorse_R6_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5274000.0 );
        horse.setPreviousYearProfit( 3084000.0 );
        horse.setVictoryProfit( 2655000.0 );
        horse.setPlaceProfit( 2619000.0 );
        horse.setYearProfit( 2190000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.Y. RAYON" ) );
        horse.setOwner( owner( "ECURIE ALBERT RAYON" ) );
        // no rancher
        horse.setJockey( jockey( "TH. DROMIGNY" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 11 - ALEXANOR
     * HorseID - ALEXANOR
     */
    public static HorseID builderHorse_R6_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALEXANOR" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "ORLANDO SPORT" );
        horseID.setMother( "GOLD FLOWER" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 11 - ALEXANOR
     */

    public static Horse builderHorse_R6_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 840000.0 );
        horse.setPreviousYearProfit( 840000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 300000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. GILLES" ) );
        horse.setOwner( owner( "J.P. PES" ) );
        // no rancher
        horse.setJockey( jockey( "S.E. PASQUIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 12 - AMOUR DE FOOT
     * HorseID - AMOUR DE FOOT
     */
    public static HorseID builderHorse_R6_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMOUR DE FOOT" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "DIAMANT GEDE" );
        horseID.setMother( "PRINCESS FOOT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 12 - AMOUR DE FOOT
     */

    public static Horse builderHorse_R6_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 4617000.0 );
        horse.setPreviousYearProfit( 1636000.0 );
        horse.setVictoryProfit( 3375000.0 );
        horse.setPlaceProfit( 1242000.0 );
        horse.setYearProfit( 2565000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. MARIE" ) );
        horse.setOwner( owner( "L. TORREGROSSA" ) );
        // no rancher
        horse.setJockey( jockey( "M. DAOUGABEL" ) );

        return horse;

    }

    /*
     * Race 6
     * Odds 1 - 13/08/2015 17:23:17 +0200
     */

    public static Odds builderOdds_R6_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:17 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 39.7 ) );
        simples.add( simple( odds, "2", 53.0 ) );
        simples.add( simple( odds, "3", 12.7 ) );
        simples.add( simple( odds, "4", 8.5 ) );
        simples.add( simple( odds, "5", 16.7 ) );
        simples.add( simple( odds, "6", 4.0 ) );
        simples.add( simple( odds, "7", 5.2 ) );
        simples.add( simple( odds, "8", 9.6 ) );
        simples.add( simple( odds, "9", 9.9 ) );
        simples.add( simple( odds, "10", 7.0 ) );
        simples.add( simple( odds, "11", 21.2 ) );
        simples.add( simple( odds, "12", 18.7 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6
     * Odds 2 - 13/08/2015 21:35:34 +0200
     */

    public static Odds builderOdds_R6_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 21:35:34 +0200" ) );
        odds.setTotal( 4832.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 37.4 ) );
        simples.add( simple( odds, "2", 16.9 ) );
        simples.add( simple( odds, "3", 19.9 ) );
        simples.add( simple( odds, "4", 6.5 ) );
        simples.add( simple( odds, "5", 38.4 ) );
        simples.add( simple( odds, "6", 6.3 ) );
        simples.add( simple( odds, "7", 3.4 ) );
        simples.add( simple( odds, "8", 16.6 ) );
        simples.add( simple( odds, "9", 7.9 ) );
        simples.add( simple( odds, "10", 5.9 ) );
        simples.add( simple( odds, "11", 32.6 ) );
        simples.add( simple( odds, "12", 28.7 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7 - PRIX BRUCHEVILLE
     */

    public static Race builderRace_R7( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 7 );
        race.setName( "PRIX BRUCHEVILLE" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 22:00:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 6000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of( Type.AMATEURS ) );

        // -- horses --
        SortedSet<Horse> horses = new TreeSet<>();
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
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R7_O1( race ) );
        oddsSet.add( builderOdds_R7_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  9, 209150 ) );
        places.add( place( race,  2,  6, 210080 ) );
        places.add( place( race,  3,  3, 210520 ) );
        places.add( place( race,  4, 12, 210920 ) );
        places.add( place( race,  5, 11, 211100 ) );
        places.add( place( race,  6,  4, 220560 ) );
        places.add( place( race,  7,  5 ) );
        race.setPlaces( places );

        race.setStopped( "7" );
        race.setDisqualified( "1 2 8 10" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.2, "9" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.7, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.5, "6" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 2.2, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 28.7, "9 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.7, "3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 29.9, "6 3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.4, "9" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.9, "9 3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.7, "9 6" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 28.7, "9 6" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 78.1, "9 6 3" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 7
     * Horse 1 - VINO VERDE
     * HorseID - VINO VERDE
     */
    public static HorseID builderHorse_R7_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VINO VERDE" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "MILORD DRILL" );
        horseID.setMother( "NATALIA DE CHARMS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 1 - VINO VERDE
     */

    public static Horse builderHorse_R7_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 2361000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1350000.0 );
        horse.setPlaceProfit( 1011000.0 );
        horse.setYearProfit( 80000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N. LECERF" ) );
        horse.setOwner( owner( "N. LECERF" ) );
        // no rancher
        horse.setJockey( jockey( "N. LECERF" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 2 - ULTRA DAG
     * HorseID - ULTRA DAG
     */
    public static HorseID builderHorse_R7_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ULTRA DAG" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LAETENTER DIEM" );
        horseID.setMother( "MARINA DE RABUT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 2 - ULTRA DAG
     */

    public static Horse builderHorse_R7_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 3985500.0 );
        horse.setPreviousYearProfit( 126000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 3985500.0 );
        horse.setYearProfit( 301500.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ST. MEUNIER" ) );
        horse.setOwner( owner( "CH. BOUVIER" ) );
        // no rancher
        horse.setJockey( jockey( "CHARLES BOUVIER" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 3 - ULTRALITO
     * HorseID - ULTRALITO
     */
    public static HorseID builderHorse_R7_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ULTRALITO" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FULL ACCOUNT" );
        horseID.setMother( "LADY DE VARENNE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 3 - ULTRALITO
     */

    public static Horse builderHorse_R7_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4042900.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1665000.0 );
        horse.setPlaceProfit( 2377900.0 );
        horse.setYearProfit( 12000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ST. PROVOOST" ) );
        horse.setOwner( owner( "ECURIE DANOVER" ) );
        // no rancher
        horse.setJockey( jockey( "A. LESCALIER" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 4 - TOP GUN DE NACRE
     * HorseID - TOP GUN DE NACRE
     */
    public static HorseID builderHorse_R7_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TOP GUN DE NACRE" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NICE LOVE" );
        horseID.setMother( "LIGNEE VIKING" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 4 - TOP GUN DE NACRE
     */

    public static Horse builderHorse_R7_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4379000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1750000.0 );
        horse.setPlaceProfit( 2629000.0 );
        horse.setYearProfit( 4000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "ANTHONY GUERIN" ) );
        horse.setOwner( owner( "ANTHONY GUERIN" ) );
        // no rancher
        horse.setJockey( jockey( "ANTHONY GUERIN" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 5 - UPPERCUT BLEU
     * HorseID - UPPERCUT BLEU
     */
    public static HorseID builderHorse_R7_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UPPERCUT BLEU" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "GOBERNADOR" );
        horseID.setMother( "HELOISE BLEUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 5 - UPPERCUT BLEU
     */

    public static Horse builderHorse_R7_H5( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H5_ID() );
        horse.setNumber( 5 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4498000.0 );
        horse.setPreviousYearProfit( 295000.0 );
        horse.setVictoryProfit( 2190000.0 );
        horse.setPlaceProfit( 2308000.0 );
        horse.setYearProfit( 4000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. THIEULENT" ) );
        horse.setOwner( owner( "ECURIE ALTA BLEU" ) );
        // no rancher
        horse.setJockey( jockey( "A. THIEULENT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 6 - VAHINE D'OCCAGNES
     * HorseID - VAHINE D'OCCAGNES
     */
    public static HorseID builderHorse_R7_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VAHINE D'OCCAGNES" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "INFANT DU BOSSIS" );
        horseID.setMother( "HELLA PIERRE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 6 - VAHINE D'OCCAGNES
     */

    public static Horse builderHorse_R7_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4579000.0 );
        horse.setPreviousYearProfit( 1147000.0 );
        horse.setVictoryProfit( 1440000.0 );
        horse.setPlaceProfit( 3139000.0 );
        horse.setYearProfit( 304000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. CARDINE" ) );
        horse.setOwner( owner( "PH. JOYEUX" ) );
        // no rancher
        horse.setJockey( jockey( "MME E. LAPEYRE" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 7 - VISTULE
     * HorseID - VISTULE
     */
    public static HorseID builderHorse_R7_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VISTULE" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OFFSHORE DREAM" );
        horseID.setMother( "METEORITE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 7 - VISTULE
     */

    public static Horse builderHorse_R7_H7( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H7_ID() );
        horse.setNumber( 7 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4680000.0 );
        horse.setPreviousYearProfit( 2211000.0 );
        horse.setVictoryProfit( 1665000.0 );
        horse.setPlaceProfit( 3035000.0 );
        horse.setYearProfit( 350000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. LE COURTOIS" ) );
        horse.setOwner( owner( "CH. LAPORTE" ) );
        // no rancher
        horse.setJockey( jockey( "CH. LAPORTE" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 8 - TENOR ROYAL
     * HorseID - TENOR ROYAL
     */
    public static HorseID builderHorse_R7_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TENOR ROYAL" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FIRST DE RETZ" );
        horseID.setMother( "GOA BEACH" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 8 - TENOR ROYAL
     */

    public static Horse builderHorse_R7_H8( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H8_ID() );
        horse.setNumber( 8 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4841000.0 );
        horse.setPreviousYearProfit( 632000.0 );
        horse.setVictoryProfit( 1540000.0 );
        horse.setPlaceProfit( 3301000.0 );
        horse.setYearProfit( 34000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. COPPENS" ) );
        horse.setOwner( owner( "E. LEFRANC" ) );
        // no rancher
        horse.setJockey( jockey( "JULIEN RENAULT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 9 - TUPELO DES BOIS
     * HorseID - TUPELO DES BOIS
     */
    public static HorseID builderHorse_R7_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TUPELO DES BOIS" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MICKAEL DE VONNAS" );
        horseID.setMother( "MYRTILLE DES BOIS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 9 - TUPELO DES BOIS
     */

    public static Horse builderHorse_R7_H9( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H9_ID() );
        horse.setNumber( 9 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4881000.0 );
        horse.setPreviousYearProfit( 746000.0 );
        horse.setVictoryProfit( 2050000.0 );
        horse.setPlaceProfit( 2831000.0 );
        horse.setYearProfit( 580000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BOUGAULT" ) );
        horse.setOwner( owner( "M. BOUGAULT" ) );
        // no rancher
        horse.setJockey( jockey( "M. BOUGAULT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 10 - VIC ROYAL
     * HorseID - VIC ROYAL
     */
    public static HorseID builderHorse_R7_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VIC ROYAL" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "CHEF DU CHATELET" );
        horseID.setMother( "PENSEE DE CERISY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 10 - VIC ROYAL
     */

    public static Horse builderHorse_R7_H10( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H10_ID() );
        horse.setNumber( 10 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4924000.0 );
        horse.setPreviousYearProfit( 1539000.0 );
        horse.setVictoryProfit( 1500000.0 );
        horse.setPlaceProfit( 3424000.0 );
        horse.setYearProfit( 103000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "TH. DESOUBEAUX" ) );
        horse.setOwner( owner( "TH. DESOUBEAUX" ) );
        // no rancher
        horse.setJockey( jockey( "TH. DESOUBEAUX" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 11 - UDYSSEE ROYALE
     * HorseID - UDYSSEE ROYALE
     */
    public static HorseID builderHorse_R7_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UDYSSEE ROYALE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MOUROTAIS" );
        horseID.setMother( "ODYSSEE ROYALE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 11 - UDYSSEE ROYALE
     */

    public static Horse builderHorse_R7_H11( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H11_ID() );
        horse.setNumber( 11 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 8414000.0 );
        horse.setPreviousYearProfit( 1184000.0 );
        horse.setVictoryProfit( 1815000.0 );
        horse.setPlaceProfit( 6879000.0 );
        horse.setYearProfit( 390000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. HOUYVET" ) );
        horse.setOwner( owner( "ECURIE SEBASTIEN HOUYVET" ) );
        // no rancher
        horse.setJockey( jockey( "S. CAMPAIN" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 12 - TOLITE
     * HorseID - TOLITE
     */
    public static HorseID builderHorse_R7_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TOLITE" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KALAHARI" );
        horseID.setMother( "OPALINE DU SCION" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 12 - TOLITE
     */

    public static Horse builderHorse_R7_H12( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H12_ID() );
        horse.setNumber( 12 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9162500.0 );
        horse.setPreviousYearProfit( 2583000.0 );
        horse.setVictoryProfit( 3530000.0 );
        horse.setPlaceProfit( 5632500.0 );
        horse.setYearProfit( 460000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.F. POPOT" ) );
        horse.setOwner( owner( "ECURIE JEAN FRANCOIS POPOT" ) );
        // no rancher
        horse.setJockey( jockey( "A. LAIR" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 13 - VERSION STAR'S
     * HorseID - VERSION STAR'S
     */
    public static HorseID builderHorse_R7_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VERSION STAR'S" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "PRINCE D'ESPACE" );
        horseID.setMother( "PLANETE RAPIDE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 13 - VERSION STAR'S
     */

    public static Horse builderHorse_R7_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9619000.0 );
        horse.setPreviousYearProfit( 938000.0 );
        horse.setVictoryProfit( 1800000.0 );
        horse.setPlaceProfit( 7819000.0 );
        horse.setYearProfit( 389000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. VARIN" ) );
        horse.setOwner( owner( "F. MORANT" ) );
        // no rancher
        horse.setJockey( jockey( "J. VARIN" ) );

        return horse;

    }

    /*
     * Race 7
     * Odds 1 - 13/08/2015 17:23:36 +0200
     */

    public static Odds builderOdds_R7_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:23:36 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 34.6 ) );
        simples.add( simple( odds, "2", 3.2 ) );
        simples.add( simple( odds, "3", 18.4 ) );
        simples.add( simple( odds, "5", 92.2 ) );
        simples.add( simple( odds, "6", 12.5 ) );
        simples.add( simple( odds, "7", 12.5 ) );
        simples.add( simple( odds, "8", 9.5 ) );
        simples.add( simple( odds, "9", 7.9 ) );
        simples.add( simple( odds, "10", 46.1 ) );
        simples.add( simple( odds, "11", 9.5 ) );
        simples.add( simple( odds, "12", 21.2 ) );
        simples.add( simple( odds, "13", 4.6 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7
     * Odds 2 - 13/08/2015 22:05:06 +0200
     */

    public static Odds builderOdds_R7_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 22:05:06 +0200" ) );
        odds.setTotal( 5415.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 24.1 ) );
        simples.add( simple( odds, "2", 5.4 ) );
        simples.add( simple( odds, "3", 7.9 ) );
        simples.add( simple( odds, "4", 64.6 ) );
        simples.add( simple( odds, "5", 54.9 ) );
        simples.add( simple( odds, "6", 21.4 ) );
        simples.add( simple( odds, "7", 16.4 ) );
        simples.add( simple( odds, "8", 19.5 ) );
        simples.add( simple( odds, "9", 2.2 ) );
        simples.add( simple( odds, "10", 30.2 ) );
        simples.add( simple( odds, "11", 7.3 ) );
        simples.add( simple( odds, "12", 27.4 ) );
        simples.add( simple( odds, "13", 7.4 ) );
        odds.setSimples( simples );

        return odds;

    }

}
