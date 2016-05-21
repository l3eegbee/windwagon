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

public class Meeting_20150813_M6 extends MeetingBuilder {

    public static Meeting build() {

        Meeting meeting = new Meeting();

        meeting.setDate( parse( "13/08/2015 00:00:00 +0200" ) );
        meeting.setRacecourse( racecourse( "AIX LES BAINS", "FRANCE" ) );
        meeting.setNumber( 6 );
        meeting.setWindSpeed( 14.0 );
        meeting.setWindDirection( WindDirection.SW );
        meeting.setTemperature( 31.0 );
        meeting.setClimat( "ORAGES ISOLES" );
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
     * Race 1 - PRIX EQUIRACING - PRIX DU CHABLAIS
     */

    public static Race builderRace_R1( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 1 );
        race.setName( "PRIX EQUIRACING - PRIX DU CHABLAIS" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 14:30:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 20000.0 );
        race.setDiscipline( Discipline.TROT_MONTE );
        race.setTypes( EnumSet.of(
                Type.APPRENTIS,
                Type.LADS_JOCKEYS ) );
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
        horses.add( builderHorse_R1_H15( race ) );
        horses.add( builderHorse_R1_H16( race ) );
        horses.add( builderHorse_R1_H17( race ) );
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
        places.add( place( race,  1,  4 ) );
        places.add( place( race,  2, 11 ) );
        places.add( place( race,  3, 12 ) );
        places.add( place( race,  4, 17 ) );
        places.add( place( race,  5, 10 ) );
        places.add( place( race,  6,  2 ) );
        places.add( place( race,  7,  5 ) );
        places.add( place( race,  8,  1 ) );
        places.add( place( race,  9,  7 ) );
        places.add( place( race, 10,  9 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "8 14 15" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 41.7, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.6, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.7, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 12.2, "4" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 0.0, "4" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 214.0, "4 11" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.6, "11" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.1, "11 12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.7, "12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 12.2, "4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 106.1, "4 11" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 36.8, "4 12" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "4" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "4 11" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 257.6, "4 11 12" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 1
     * Horse 1 - VANITE D'OCCAGNES
     * HorseID - VANITE D'OCCAGNES
     */
    public static HorseID builderHorse_R1_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VANITE D'OCCAGNES" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DIAMANT GEDE" );
        horseID.setMother( "QUOUNA D'OCCAGNES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 1 - VANITE D'OCCAGNES
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
        horse.setCareerProfit( 4766000.0 );
        horse.setPreviousYearProfit( 1837000.0 );
        horse.setVictoryProfit( 2120000.0 );
        horse.setPlaceProfit( 2646000.0 );
        horse.setYearProfit( 550000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R.J. GOUJON" ) );
        horse.setOwner( owner( "R. REOCREUX" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE I. KISS" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 2 - UN PREMIER D'ABY
     * HorseID - UN PREMIER D'ABY
     */
    public static HorseID builderHorse_R1_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UN PREMIER D'ABY" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KENOR DE COSSE" );
        horseID.setMother( "OLD BERLINE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 2 - UN PREMIER D'ABY
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
        horse.setCareerProfit( 5025000.0 );
        horse.setPreviousYearProfit( 2211000.0 );
        horse.setVictoryProfit( 765000.0 );
        horse.setPlaceProfit( 4260000.0 );
        horse.setYearProfit( 728000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. TOURON" ) );
        horse.setOwner( owner( "MLLE P. HERRY" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE P. HERRY" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 3 - VERDICT OAKS
     * HorseID - VERDICT OAKS
     */
    public static HorseID builderHorse_R1_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VERDICT OAKS" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LE BIG BOSS" );
        horseID.setMother( "FORTUNA BOURBON" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 3 - VERDICT OAKS
     */

    public static Horse builderHorse_R1_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 5332000.0 );
        horse.setPreviousYearProfit( 1609000.0 );
        horse.setVictoryProfit( 950000.0 );
        horse.setPlaceProfit( 4382000.0 );
        horse.setYearProfit( 575000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MLLE CH. CHAMANT" ) );
        horse.setOwner( owner( "MLLE CH. CHAMANT" ) );
        // no rancher
        horse.setJockey( jockey( "A. BORREGO" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 4 - URI DE LA VALLEE
     * HorseID - URI DE LA VALLEE
     */
    public static HorseID builderHorse_R1_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URI DE LA VALLEE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "OFFSHORE DREAM" );
        horseID.setMother( "NORA DU CADRAN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 4 - URI DE LA VALLEE
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
        horse.setCareerProfit( 5541000.0 );
        horse.setPreviousYearProfit( 1075000.0 );
        horse.setVictoryProfit( 4665000.0 );
        horse.setPlaceProfit( 876000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. ROUBAUD" ) );
        horse.setOwner( owner( "ECURIE SYLVAIN ROUBAUD" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE M. HEYMANS" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 5 - ALEX D'ACANTHE
     * HorseID - ALEX D'ACANTHE
     */
    public static HorseID builderHorse_R1_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALEX D'ACANTHE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "BIESOLO" );
        horseID.setMother( "NATH DE VIRETAUTE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 5 - ALEX D'ACANTHE
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
        horse.setCareerProfit( 5873000.0 );
        horse.setPreviousYearProfit( 3291000.0 );
        horse.setVictoryProfit( 3015000.0 );
        horse.setPlaceProfit( 2858000.0 );
        horse.setYearProfit( 1837000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. PELTIER" ) );
        horse.setOwner( owner( "MME B. PELTIER" ) );
        // no rancher
        horse.setJockey( jockey( "F. BOULOT" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 6 - UTOPIE DU SABLIER
     * HorseID - UTOPIE DU SABLIER
     */
    public static HorseID builderHorse_R1_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UTOPIE DU SABLIER" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "HYPERION" );
        horseID.setMother( "HYACINTHE MAB" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 6 - UTOPIE DU SABLIER
     */

    public static Horse builderHorse_R1_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 6066000.0 );
        horse.setPreviousYearProfit( 1953000.0 );
        horse.setVictoryProfit( 2145000.0 );
        horse.setPlaceProfit( 3921000.0 );
        horse.setYearProfit( 656000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. THOMAS" ) );
        horse.setOwner( owner( "ECURIE DU SABLIER" ) );
        // no rancher
        horse.setJockey( jockey( "F. BROUST" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 7 - SCABREUSE
     * HorseID - SCABREUSE
     */
    public static HorseID builderHorse_R1_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SCABREUSE" );
        horseID.setBirth( parse( "01/01/2006 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KENOR DE COSSE" );
        horseID.setMother( "KALTIERE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 7 - SCABREUSE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 8339000.0 );
        horse.setPreviousYearProfit( 1303000.0 );
        horse.setVictoryProfit( 5500000.0 );
        horse.setPlaceProfit( 2839000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. BISCH" ) );
        horse.setOwner( owner( "S. BISCH" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE N. ROLLY" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 8 - SAXO DES GIRES
     * HorseID - SAXO DES GIRES
     */
    public static HorseID builderHorse_R1_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SAXO DES GIRES" );
        horseID.setBirth( parse( "01/01/2006 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MAGOT DU RAVARY" );
        horseID.setMother( "ISIS DU BLEQUIN" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 8 - SAXO DES GIRES
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 8642000.0 );
        horse.setPreviousYearProfit( 1637000.0 );
        horse.setVictoryProfit( 5180000.0 );
        horse.setPlaceProfit( 3462000.0 );
        horse.setYearProfit( 504000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BONNEFOY" ) );
        horse.setOwner( owner( "P. GIROUD" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE L. BALAYN" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 9 - SCARABIAN
     * HorseID - SCARABIAN
     */
    public static HorseID builderHorse_R1_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SCARABIAN" );
        horseID.setBirth( parse( "01/01/2006 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LILIUM MADRIK" );
        horseID.setMother( "IMAGE VRO" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 9 - SCARABIAN
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
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 8779000.0 );
        horse.setPreviousYearProfit( 1399000.0 );
        horse.setVictoryProfit( 3950000.0 );
        horse.setPlaceProfit( 4829000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. BOUVARD" ) );
        horse.setOwner( owner( "J.M. BOUVARD" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE D. PETERS" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 10 - UN CIEL BLEU
     * HorseID - UN CIEL BLEU
     */
    public static HorseID builderHorse_R1_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UN CIEL BLEU" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NOT DISTURB" );
        horseID.setMother( "FIESQUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 10 - UN CIEL BLEU
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 8817000.0 );
        horse.setPreviousYearProfit( 3863000.0 );
        horse.setVictoryProfit( 2025000.0 );
        horse.setPlaceProfit( 6792000.0 );
        horse.setYearProfit( 1452000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BONNEFOY" ) );
        horse.setOwner( owner( "M. COLIN" ) );
        // no rancher
        horse.setJockey( jockey( "R. THONNERIEUX" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 11 - URAGANO
     * HorseID - URAGANO
     */
    public static HorseID builderHorse_R1_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URAGANO" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "HIMO JOSSELYN" );
        horseID.setMother( "OCEAN ISLAND" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 11 - URAGANO
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9039000.0 );
        horse.setPreviousYearProfit( 131000.0 );
        horse.setVictoryProfit( 3800000.0 );
        horse.setPlaceProfit( 5239000.0 );
        horse.setYearProfit( 2755000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R.J. GOUJON" ) );
        horse.setOwner( owner( "R.J. GOUJON" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE L. GROSBOT" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 12 - VELINA
     * HorseID - VELINA
     */
    public static HorseID builderHorse_R1_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VELINA" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LAND DU COGLAIS" );
        horseID.setMother( "NADIA DES JACQUOTS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 12 - VELINA
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9839000.0 );
        horse.setPreviousYearProfit( 2839000.0 );
        horse.setVictoryProfit( 3450000.0 );
        horse.setPlaceProfit( 6389000.0 );
        horse.setYearProfit( 3470000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. DESPRES" ) );
        horse.setOwner( owner( "ECURIE JOEL DESPRES" ) );
        // no rancher
        horse.setJockey( jockey( "CH. DESRUES" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 13 - VENI VICI
     * HorseID - VENI VICI
     */
    public static HorseID builderHorse_R1_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VENI VICI" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NOT DISTURB" );
        horseID.setMother( "LA VALLEE VICI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 1
     * Horse 13 - VENI VICI
     */

    public static Horse builderHorse_R1_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9894000.0 );
        horse.setPreviousYearProfit( 2619000.0 );
        horse.setVictoryProfit( 3565000.0 );
        horse.setPlaceProfit( 6329000.0 );
        horse.setYearProfit( 2281000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. LAMAZIERE" ) );
        horse.setOwner( owner( "L. LAMAZIERE" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE S. CORTIAL" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 14 - URIAKO DE VILLIERE
     * HorseID - URIAKO DE VILLIERE
     */
    public static HorseID builderHorse_R1_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URIAKO DE VILLIERE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "FAST DU GILET" );
        horseID.setMother( "LOELY DE VILLIERE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 14 - URIAKO DE VILLIERE
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
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 9951000.0 );
        horse.setPreviousYearProfit( 1480000.0 );
        horse.setVictoryProfit( 3060000.0 );
        horse.setPlaceProfit( 6891000.0 );
        horse.setYearProfit( 3730000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "T. AGUIAR" ) );
        horse.setOwner( owner( "MME N. MARTIN DEVILLIERE" ) );
        // no rancher
        horse.setJockey( jockey( "A. GIRAUD" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 15 - SULLIAN DU MOUTY
     * HorseID - SULLIAN DU MOUTY
     */
    public static HorseID builderHorse_R1_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SULLIAN DU MOUTY" );
        horseID.setBirth( parse( "01/01/2006 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LOOK DE STAR" );
        horseID.setMother( "GALYTIANE DU MOUTY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 15 - SULLIAN DU MOUTY
     */

    public static Horse builderHorse_R1_H15( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H15_ID() );
        horse.setNumber( 15 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.0285E7 );
        horse.setPreviousYearProfit( 84000.0 );
        horse.setVictoryProfit( 3150000.0 );
        horse.setPlaceProfit( 7135000.0 );
        horse.setYearProfit( 1264000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. GAZENGEL" ) );
        horse.setOwner( owner( "E. AMBARD" ) );
        // no rancher
        horse.setJockey( jockey( "J.T. UTTEWILLER" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 16 - TOSCALINE
     * HorseID - TOSCALINE
     */
    public static HorseID builderHorse_R1_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TOSCALINE" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "KAISER SOZE" );
        horseID.setMother( "LIMONADE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 1
     * Horse 16 - TOSCALINE
     */

    public static Horse builderHorse_R1_H16( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H16_ID() );
        horse.setNumber( 16 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.0821E7 );
        horse.setPreviousYearProfit( 1600000.0 );
        horse.setVictoryProfit( 4185000.0 );
        horse.setPlaceProfit( 6636000.0 );
        horse.setYearProfit( 647000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. BOUYER" ) );
        horse.setOwner( owner( "ECURIE G.E. BOUYER" ) );
        // no rancher
        horse.setJockey( jockey( "MME S. BUSSET" ) );

        return horse;

    }

    /*
     * Race 1
     * Horse 17 - ULTORIUS
     * HorseID - ULTORIUS
     */
    public static HorseID builderHorse_R1_H17_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ULTORIUS" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "BIESOLO" );
        horseID.setMother( "NOVELTY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 1
     * Horse 17 - ULTORIUS
     */

    public static Horse builderHorse_R1_H17( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R1_H17_ID() );
        horse.setNumber( 17 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1.1716E7 );
        horse.setPreviousYearProfit( 825000.0 );
        horse.setVictoryProfit( 4635000.0 );
        horse.setPlaceProfit( 7081000.0 );
        horse.setYearProfit( 5940000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "ECURIE AIME GAUVIN" ) );
        // no rancher
        horse.setJockey( jockey( "F. GAUVIN" ) );

        return horse;

    }

    /*
     * Race 1
     * Odds 1 - 13/08/2015 12:30:46 +0200
     */

    public static Odds builderOdds_R1_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:46 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 11.1 ) );
        simples.add( simple( odds, "4", 104.5 ) );
        simples.add( simple( odds, "5", 10.4 ) );
        simples.add( simple( odds, "6", 44.7 ) );
        simples.add( simple( odds, "8", 20.9 ) );
        simples.add( simple( odds, "10", 9.2 ) );
        simples.add( simple( odds, "11", 9.5 ) );
        simples.add( simple( odds, "12", 9.7 ) );
        simples.add( simple( odds, "13", 3.9 ) );
        simples.add( simple( odds, "14", 2.5 ) );
        simples.add( simple( odds, "15", 44.7 ) );
        simples.add( simple( odds, "16", 17.1 ) );
        simples.add( simple( odds, "17", 5.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 1
     * Odds 2 - 13/08/2015 14:32:40 +0200
     */

    public static Odds builderOdds_R1_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 14:32:40 +0200" ) );
        odds.setTotal( 1610.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 57.7 ) );
        simples.add( simple( odds, "2", 44.4 ) );
        simples.add( simple( odds, "4", 41.7 ) );
        simples.add( simple( odds, "5", 6.7 ) );
        simples.add( simple( odds, "6", 48.7 ) );
        simples.add( simple( odds, "7", 30.8 ) );
        simples.add( simple( odds, "8", 12.9 ) );
        simples.add( simple( odds, "9", 169.6 ) );
        simples.add( simple( odds, "10", 7.0 ) );
        simples.add( simple( odds, "11", 8.7 ) );
        simples.add( simple( odds, "12", 14.2 ) );
        simples.add( simple( odds, "13", 11.2 ) );
        simples.add( simple( odds, "14", 5.7 ) );
        simples.add( simple( odds, "15", 41.7 ) );
        simples.add( simple( odds, "16", 18.2 ) );
        simples.add( simple( odds, "17", 2.9 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2 - PRIX D'ALBENS
     */

    public static Race builderRace_R2( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 2 );
        race.setName( "PRIX D'ALBENS" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 15:00:00 +0200" ) );
        // no real start
        race.setDistance( 2725.0 );
        race.setBenefit( 11000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of( Type.RECLAMER ) );

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
        places.add( place( race,  1,  3 ) );
        places.add( place( race,  2,  4 ) );
        places.add( place( race,  3,  6 ) );
        places.add( place( race,  4, 11 ) );
        places.add( place( race,  5,  1 ) );
        places.add( place( race,  6,  5 ) );
        places.add( place( race,  7,  8 ) );
        places.add( place( race,  8,  2 ) );
        places.add( place( race,  9,  7 ) );
        places.add( place( race, 10, 13 ) );
        places.add( place( race, 11, 12 ) );
        places.add( place( race, 12,  9 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "10" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 74.4, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 14.5, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.7, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.2, "6" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 160.0, "3 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 74.6, "3 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 50.1, "3 6" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 18.8, "4 6" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 286.1, "3 4 6" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 2
     * Horse 1 - ARENE DE MALBERAUX
     * HorseID - ARENE DE MALBERAUX
     */
    public static HorseID builderHorse_R2_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARENE DE MALBERAUX" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "REPLAY OAKS" );
        horseID.setMother( "FEE DE LA LYRE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 1 - ARENE DE MALBERAUX
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
        horse.setCareerProfit( 1907000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 850000.0 );
        horse.setPlaceProfit( 1057000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y. LAVIGNE" ) );
        horse.setOwner( owner( "G. ALAINE" ) );
        // no rancher
        horse.setJockey( jockey( "F. JAMARD" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 2 - ABBAGHJU MAG
     * HorseID - ABBAGHJU MAG
     */
    public static HorseID builderHorse_R2_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ABBAGHJU MAG" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "OLITRO" );
        horseID.setMother( "PERSANE JET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.NOIR );

        return horseID;

    }


    /*
     * Race 2
     * Horse 2 - ABBAGHJU MAG
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
        horse.setCareerProfit( 2078000.0 );
        horse.setPreviousYearProfit( 1955000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 1538000.0 );
        horse.setYearProfit( 123000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "M. AGOSTINI" ) );
        // no rancher
        horse.setJockey( jockey( "P. CALLIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 3 - ADONIS DE CARO
     * HorseID - ADONIS DE CARO
     */
    public static HorseID builderHorse_R2_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ADONIS DE CARO" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NAIF PHI" );
        horseID.setMother( "FIESTA DU VAL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 3 - ADONIS DE CARO
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
        horse.setCareerProfit( 2340000.0 );
        horse.setPreviousYearProfit( 1401000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 2340000.0 );
        horse.setYearProfit( 457000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "ECURIE LAURENT VIRICEL" ) );
        // no rancher
        horse.setJockey( jockey( "B. THOMAS" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 4 - ALADIN DU NOYER
     * HorseID - ALADIN DU NOYER
     */
    public static HorseID builderHorse_R2_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALADIN DU NOYER" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PASSWORD" );
        horseID.setMother( "NINA DU NOYER" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 4 - ALADIN DU NOYER
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
        horse.setCareerProfit( 2473000.0 );
        horse.setPreviousYearProfit( 928000.0 );
        horse.setVictoryProfit( 1035000.0 );
        horse.setPlaceProfit( 1438000.0 );
        horse.setYearProfit( 720000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. BONNEFOY" ) );
        horse.setOwner( owner( "J.H. MESGUEN" ) );
        // no rancher
        horse.setJockey( jockey( "A. BONNEFOY" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 5 - AFRICAINE THE BEST
     * HorseID - AFRICAINE THE BEST
     */
    public static HorseID builderHorse_R2_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AFRICAINE THE BEST" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JOW DU VRO" );
        horseID.setMother( "OPALINE THE BEST" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 5 - AFRICAINE THE BEST
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
        horse.setCareerProfit( 2529000.0 );
        horse.setPreviousYearProfit( 660000.0 );
        horse.setVictoryProfit( 945000.0 );
        horse.setPlaceProfit( 1584000.0 );
        horse.setYearProfit( 575000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.CH. GANDRE" ) );
        horse.setOwner( owner( "J. GANDRE" ) );
        // no rancher
        horse.setJockey( jockey( "L. GAZENGEL" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 6 - ARNAQUEUR DU PIC
     * HorseID - ARNAQUEUR DU PIC
     */
    public static HorseID builderHorse_R2_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ARNAQUEUR DU PIC" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MICKAEL DE VONNAS" );
        horseID.setMother( "HILLARY DU PIC" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 6 - ARNAQUEUR DU PIC
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
        horse.setCareerProfit( 2624000.0 );
        horse.setPreviousYearProfit( 665000.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 2129000.0 );
        horse.setYearProfit( 627000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y. BERGER" ) );
        horse.setOwner( owner( "Y. BERGER" ) );
        // no rancher
        horse.setJockey( jockey( "R. GOUTTEFARDE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 7 - AMERICAN SLOGAN
     * HorseID - AMERICAN SLOGAN
     */
    public static HorseID builderHorse_R2_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMERICAN SLOGAN" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KOREAN" );
        horseID.setMother( "NEW MUSIC" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 7 - AMERICAN SLOGAN
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
        horse.setCareerProfit( 2798000.0 );
        horse.setPreviousYearProfit( 1693000.0 );
        horse.setVictoryProfit( 1575000.0 );
        horse.setPlaceProfit( 1223000.0 );
        horse.setYearProfit( 423000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. RAFFESTIN" ) );
        horse.setOwner( owner( "J. RAFFESTIN" ) );
        // no rancher
        horse.setJockey( jockey( "S. PELTIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 8 - AMOUR DU CHATELET
     * HorseID - AMOUR DU CHATELET
     */
    public static HorseID builderHorse_R2_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMOUR DU CHATELET" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JAG DE BELLOUET" );
        horseID.setMother( "LADY DU CHATELET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 8 - AMOUR DU CHATELET
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
        horse.setCareerProfit( 2825000.0 );
        horse.setPreviousYearProfit( 1910000.0 );
        horse.setVictoryProfit( 630000.0 );
        horse.setPlaceProfit( 2195000.0 );
        horse.setYearProfit( 130000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "A. ORSINI" ) );
        // no rancher
        horse.setJockey( jockey( "Y.A. BRIAND" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 9 - AMIR
     * HorseID - AMIR
     */
    public static HorseID builderHorse_R2_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AMIR" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ONE DU RIB" );
        horseID.setMother( "MANZIR" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 9 - AMIR
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
        horse.setCareerProfit( 4149000.0 );
        horse.setPreviousYearProfit( 2487000.0 );
        horse.setVictoryProfit( 2070000.0 );
        horse.setPlaceProfit( 2079000.0 );
        horse.setYearProfit( 332000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME G. MASSCHAELE" ) );
        horse.setOwner( owner( "J. LECAUCHOIS" ) );
        // no rancher
        horse.setJockey( jockey( "PH. MASSCHAELE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 10 - ABRICOT ONE
     * HorseID - ABRICOT ONE
     */
    public static HorseID builderHorse_R2_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ABRICOT ONE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MY HAPPY JET" );
        horseID.setMother( "OANA DES JACQUOTS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 10 - ABRICOT ONE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2204000.0 );
        horse.setPreviousYearProfit( 939000.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 1709000.0 );
        horse.setYearProfit( 191000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. CHOURRE" ) );
        horse.setOwner( owner( "B. CHOURRE" ) );
        // no rancher
        horse.setJockey( jockey( "B. CHOURRE" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 11 - AVANTAGE CENSERIE
     * HorseID - AVANTAGE CENSERIE
     */
    public static HorseID builderHorse_R2_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AVANTAGE CENSERIE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KESACO PHEDO" );
        horseID.setMother( "ONE STAR MELODY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 2
     * Horse 11 - AVANTAGE CENSERIE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2479000.0 );
        horse.setPreviousYearProfit( 1164000.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 1894000.0 );
        horse.setYearProfit( 786000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "TH. ISSAUTIER" ) );
        horse.setOwner( owner( "TH. ISSAUTIER" ) );
        // no rancher
        horse.setJockey( jockey( "TH. ISSAUTIER" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 12 - AME CITRONNEE
     * HorseID - AME CITRONNEE
     */
    public static HorseID builderHorse_R2_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "AME CITRONNEE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MEAULNES DU CORTA" );
        horseID.setMother( "QUALITY JIEL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 12 - AME CITRONNEE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2701000.0 );
        horse.setPreviousYearProfit( 1070000.0 );
        horse.setVictoryProfit( 1485000.0 );
        horse.setPlaceProfit( 1216000.0 );
        horse.setYearProfit( 655000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. BOILLEREAU" ) );
        horse.setOwner( owner( "J. BOILLEREAU" ) );
        // no rancher
        horse.setJockey( jockey( "J. BOILLEREAU" ) );

        return horse;

    }

    /*
     * Race 2
     * Horse 13 - ALYA DARCHE
     * HorseID - ALYA DARCHE
     */
    public static HorseID builderHorse_R2_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ALYA DARCHE" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LOOK DE STAR" );
        horseID.setMother( "LEADARCHE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 2
     * Horse 13 - ALYA DARCHE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 3429000.0 );
        horse.setPreviousYearProfit( 1274000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 3429000.0 );
        horse.setYearProfit( 296000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. MESSAGER" ) );
        horse.setOwner( owner( "ECURIE DARCHE" ) );
        // no rancher
        horse.setJockey( jockey( "M. MESSAGER" ) );

        return horse;

    }

    /*
     * Race 2
     * Odds 1 - 13/08/2015 12:30:47 +0200
     */

    public static Odds builderOdds_R2_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:47 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 16.8 ) );
        simples.add( simple( odds, "3", 42.1 ) );
        simples.add( simple( odds, "4", 2.4 ) );
        simples.add( simple( odds, "5", 56.2 ) );
        simples.add( simple( odds, "7", 28.1 ) );
        simples.add( simple( odds, "8", 5.1 ) );
        simples.add( simple( odds, "9", 8.4 ) );
        simples.add( simple( odds, "10", 11.2 ) );
        simples.add( simple( odds, "11", 5.1 ) );
        simples.add( simple( odds, "12", 28.1 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 2
     * Odds 2 - 13/08/2015 15:02:07 +0200
     */

    public static Odds builderOdds_R2_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 15:02:07 +0200" ) );
        odds.setTotal( 1500.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 9.1 ) );
        simples.add( simple( odds, "2", 33.7 ) );
        simples.add( simple( odds, "3", 74.4 ) );
        simples.add( simple( odds, "4", 10.9 ) );
        simples.add( simple( odds, "5", 18.9 ) );
        simples.add( simple( odds, "6", 8.0 ) );
        simples.add( simple( odds, "7", 10.2 ) );
        simples.add( simple( odds, "8", 3.7 ) );
        simples.add( simple( odds, "9", 9.1 ) );
        simples.add( simple( odds, "10", 43.6 ) );
        simples.add( simple( odds, "11", 15.6 ) );
        simples.add( simple( odds, "12", 6.9 ) );
        simples.add( simple( odds, "13", 17.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3 - PRIX DE DIVONNE
     */

    public static Race builderRace_R3( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 3 );
        race.setName( "PRIX DE DIVONNE" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 15:30:00 +0200" ) );
        // no real start
        race.setDistance( 2700.0 );
        race.setBenefit( 14000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of( Type.NATIONALE ) );

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
        places.add( place( race,  1, 11 ) );
        places.add( place( race,  2, 10 ) );
        places.add( place( race,  3,  5 ) );
        places.add( place( race,  4,  8 ) );
        places.add( place( race,  5,  4 ) );
        places.add( place( race,  6,  2 ) );
        places.add( place( race,  7,  7 ) );
        places.add( place( race,  8,  6 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "1 3 9" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 8.2, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "10" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.4, "11" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.4, "5" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 29.4, "11 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 21.8, "10 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.5, "11 10" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 23.2, "11 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 113.3, "11 10 5" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 3
     * Horse 1 - BLACK JACK D'ABO
     * HorseID - BLACK JACK D'ABO
     */
    public static HorseID builderHorse_R3_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BLACK JACK D'ABO" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ITON DU GITE" );
        horseID.setMother( "QUATARINA BLEUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 3
     * Horse 1 - BLACK JACK D'ABO
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
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. RUET" ) );
        horse.setOwner( owner( "B. RUET" ) );
        // no rancher
        horse.setJockey( jockey( "B. RUET" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 2 - BOLIDE EXTREME
     * HorseID - BOLIDE EXTREME
     */
    public static HorseID builderHorse_R3_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOLIDE EXTREME" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "OBJECTIF ROYAL" );
        horseID.setMother( "SYLVIA D'HAVAROCHE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 2 - BOLIDE EXTREME
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
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 727000.0 );
        horse.setPreviousYearProfit( 414000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 727000.0 );
        horse.setYearProfit( 313000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. SALAMANI" ) );
        horse.setOwner( owner( "V. FILOGRASSO" ) );
        // no rancher
        horse.setJockey( jockey( "F. BONNEFOY" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 3 - BARON DAIRPET
     * HorseID - BARON DAIRPET
     */
    public static HorseID builderHorse_R3_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BARON DAIRPET" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PAOLO BERRY" );
        horseID.setMother( "LA CAROLINA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 3 - BARON DAIRPET
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
        horse.setCareerProfit( 793000.0 );
        horse.setPreviousYearProfit( 203000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 793000.0 );
        horse.setYearProfit( 590000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. GAUVIN" ) );
        horse.setOwner( owner( "G. GAUVIN" ) );
        // no rancher
        horse.setJockey( jockey( "F. GAUVIN" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 4 - BICHE DU COLOMBIER
     * HorseID - BICHE DU COLOMBIER
     */
    public static HorseID builderHorse_R3_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BICHE DU COLOMBIER" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LILIUM MADRIK" );
        horseID.setMother( "NOTRE BOHEME" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 4 - BICHE DU COLOMBIER
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
        horse.setStable( "A" );
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 993000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 993000.0 );
        horse.setYearProfit( 993000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. SALAMANI" ) );
        horse.setOwner( owner( "V. FILOGRASSO" ) );
        // no rancher
        horse.setJockey( jockey( "J. FILOGRASSO" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 5 - BIMO DU CYFLO
     * HorseID - BIMO DU CYFLO
     */
    public static HorseID builderHorse_R3_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BIMO DU CYFLO" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "HIMO JOSSELYN" );
        horseID.setMother( "OIE DU GERS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 5 - BIMO DU CYFLO
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1585000.0 );
        horse.setPreviousYearProfit( 894000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 1045000.0 );
        horse.setYearProfit( 691000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. CHOURRE" ) );
        horse.setOwner( owner( "B. CHOURRE" ) );
        // no rancher
        horse.setJockey( jockey( "B. CHOURRE" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 6 - BALANCINE DARCHE
     * HorseID - BALANCINE DARCHE
     */
    public static HorseID builderHorse_R3_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BALANCINE DARCHE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "MAMBO KING" );
        horseID.setMother( "PRUNEDARCHE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 6 - BALANCINE DARCHE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1663500.0 );
        horse.setPreviousYearProfit( 1089000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1663500.0 );
        horse.setYearProfit( 574500.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. THOMAS" ) );
        horse.setOwner( owner( "B. THOMAS" ) );
        // no rancher
        horse.setJockey( jockey( "B. THOMAS" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 7 - BEST OF DU VAL
     * HorseID - BEST OF DU VAL
     */
    public static HorseID builderHorse_R3_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BEST OF DU VAL" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "READY CASH" );
        horseID.setMother( "KARLOTTA DU VAL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 7 - BEST OF DU VAL
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 1739000.0 );
        horse.setPreviousYearProfit( 926000.0 );
        horse.setVictoryProfit( 1170000.0 );
        horse.setPlaceProfit( 569000.0 );
        horse.setYearProfit( 813000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. DESPRES" ) );
        horse.setOwner( owner( "G. RUSSO" ) );
        // no rancher
        horse.setJockey( jockey( "F. JAMARD" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 8 - BIJOUX DE SAUZETTE
     * HorseID - BIJOUX DE SAUZETTE
     */
    public static HorseID builderHorse_R3_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BIJOUX DE SAUZETTE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JASMIN DE FLORE" );
        horseID.setMother( "PRISCA DE SAUZETTE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 3
     * Horse 8 - BIJOUX DE SAUZETTE
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
        horse.setCareerProfit( 1779000.0 );
        horse.setPreviousYearProfit( 1176000.0 );
        horse.setVictoryProfit( 630000.0 );
        horse.setPlaceProfit( 1149000.0 );
        horse.setYearProfit( 603000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "J. VIALE" ) );
        // no rancher
        horse.setJockey( jockey( "P. CALLIER" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 9 - BEAUFORT DU MELEUC
     * HorseID - BEAUFORT DU MELEUC
     */
    public static HorseID builderHorse_R3_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BEAUFORT DU MELEUC" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NIJINSKI BLUE" );
        horseID.setMother( "PERLE DE LA MERITE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 9 - BEAUFORT DU MELEUC
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
        horse.setCareerProfit( 1822000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 1800000.0 );
        horse.setPlaceProfit( 22000.0 );
        horse.setYearProfit( 1822000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "ECURIE SYLVAIN ROUBAUD" ) );
        // no rancher
        horse.setJockey( jockey( "Y.A. BRIAND" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 10 - BAHAMA JET
     * HorseID - BAHAMA JET
     */
    public static HorseID builderHorse_R3_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAHAMA JET" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "COKTAIL JET" );
        horseID.setMother( "PASSION DU LOISIR" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 10 - BAHAMA JET
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
        horse.setCareerProfit( 1846000.0 );
        horse.setPreviousYearProfit( 1185000.0 );
        horse.setVictoryProfit( 450000.0 );
        horse.setPlaceProfit( 1396000.0 );
        horse.setYearProfit( 661000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "J. HOUDUSSE" ) );
        // no rancher
        horse.setJockey( jockey( "J. BOILLEREAU" ) );

        return horse;

    }

    /*
     * Race 3
     * Horse 11 - BAMBA DU PONTHIEU
     * HorseID - BAMBA DU PONTHIEU
     */
    public static HorseID builderHorse_R3_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAMBA DU PONTHIEU" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OYONNAX" );
        horseID.setMother( "OREE DU PONTHIEU" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 3
     * Horse 11 - BAMBA DU PONTHIEU
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
        horse.setCareerProfit( 1967000.0 );
        horse.setPreviousYearProfit( 1047000.0 );
        horse.setVictoryProfit( 1035000.0 );
        horse.setPlaceProfit( 932000.0 );
        horse.setYearProfit( 920000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. ROZZONI" ) );
        horse.setOwner( owner( "JEREMY JEUFFE" ) );
        // no rancher
        horse.setJockey( jockey( "A. ROZZONI" ) );

        return horse;

    }

    /*
     * Race 3
     * Odds 1 - 13/08/2015 12:30:49 +0200
     */

    public static Odds builderOdds_R3_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:49 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 9.5 ) );
        simples.add( simple( odds, "2", 20.2 ) );
        simples.add( simple( odds, "3", 6.0 ) );
        simples.add( simple( odds, "4", 30.3 ) );
        simples.add( simple( odds, "5", 8.6 ) );
        simples.add( simple( odds, "7", 5.6 ) );
        simples.add( simple( odds, "8", 20.2 ) );
        simples.add( simple( odds, "9", 7.5 ) );
        simples.add( simple( odds, "10", 5.0 ) );
        simples.add( simple( odds, "11", 6.0 ) );
        simples.add( simple( odds, "A", 12.1 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 3
     * Odds 2 - 13/08/2015 15:30:28 +0200
     */

    public static Odds builderOdds_R3_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 15:30:28 +0200" ) );
        odds.setTotal( 1442.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 12.4 ) );
        simples.add( simple( odds, "2", 19.7 ) );
        simples.add( simple( odds, "3", 18.7 ) );
        simples.add( simple( odds, "4", 27.6 ) );
        simples.add( simple( odds, "5", 21.1 ) );
        simples.add( simple( odds, "6", 20.6 ) );
        simples.add( simple( odds, "7", 6.6 ) );
        simples.add( simple( odds, "8", 9.2 ) );
        simples.add( simple( odds, "9", 3.1 ) );
        simples.add( simple( odds, "10", 5.8 ) );
        simples.add( simple( odds, "11", 8.2 ) );
        simples.add( simple( odds, "A", 11.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4 - PRIX DU SEMNOZ
     */

    public static Race builderRace_R4( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 4 );
        race.setName( "PRIX DU SEMNOZ" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 16:00:00 +0200" ) );
        // no real start
        race.setDistance( 2725.0 );
        race.setBenefit( 11000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of(
                Type.RECLAMER,
                Type.APPRENTIS,
                Type.LADS_JOCKEYS ) );
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
        places.add( place( race,  1,  9 ) );
        places.add( place( race,  2,  4 ) );
        places.add( place( race,  3,  5 ) );
        places.add( place( race,  4,  2 ) );
        places.add( place( race,  5,  7 ) );
        places.add( place( race,  6,  3 ) );
        places.add( place( race,  7,  1 ) );
        places.add( place( race,  8,  8 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "6" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 4.6, "9" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.3, "4" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "5" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 6.1, "9 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.0, "4 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.9, "9 4" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.1, "9 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 6.2, "9 4 5" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 4
     * Horse 1 - VERDICT DE VINDECY
     * HorseID - VERDICT DE VINDECY
     */
    public static HorseID builderHorse_R4_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VERDICT DE VINDECY" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JASMIN DE FLORE" );
        horseID.setMother( "NORA THE BEST" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 1 - VERDICT DE VINDECY
     */

    public static Horse builderHorse_R4_H1( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R4_H1_ID() );
        horse.setNumber( 1 );
        horse.setRunner( true );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 3006000.0 );
        horse.setPreviousYearProfit( 1417000.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 2421000.0 );
        horse.setYearProfit( 16000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. DUJMIC" ) );
        horse.setOwner( owner( "M. DUJMIC" ) );
        // no rancher
        horse.setJockey( jockey( "R. GROSBOT" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 2 - VENUSREV
     * HorseID - VENUSREV
     */
    public static HorseID builderHorse_R4_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VENUSREV" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "INGEN" );
        horseID.setMother( "NATIREV" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 2 - VENUSREV
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
        horse.setCareerProfit( 3069000.0 );
        horse.setPreviousYearProfit( 832000.0 );
        horse.setVictoryProfit( 550000.0 );
        horse.setPlaceProfit( 2519000.0 );
        horse.setYearProfit( 479000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. CIRENO" ) );
        horse.setOwner( owner( "R. CIRENO" ) );
        // no rancher
        horse.setJockey( jockey( "CH.A. BUFFAVAND" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 3 - VELVET OAKS
     * HorseID - VELVET OAKS
     */
    public static HorseID builderHorse_R4_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VELVET OAKS" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "IMPACT DU RIB" );
        horseID.setMother( "JOY OAKS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 3 - VELVET OAKS
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
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 3180000.0 );
        horse.setPreviousYearProfit( 1164000.0 );
        horse.setVictoryProfit( 1235000.0 );
        horse.setPlaceProfit( 1945000.0 );
        horse.setYearProfit( 96000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BONNEFOY" ) );
        horse.setOwner( owner( "M. BONNEFOY" ) );
        // no rancher
        horse.setJockey( jockey( "I. BENAKMOUME" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 4 - VIRUS LATIN
     * HorseID - VIRUS LATIN
     */
    public static HorseID builderHorse_R4_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VIRUS LATIN" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NIL DU RIB" );
        horseID.setMother( "LUTECE LATINE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 4 - VIRUS LATIN
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
        horse.setCareerProfit( 4722000.0 );
        horse.setPreviousYearProfit( 1742000.0 );
        horse.setVictoryProfit( 1305000.0 );
        horse.setPlaceProfit( 3417000.0 );
        horse.setYearProfit( 807000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. GOUT" ) );
        horse.setOwner( owner( "P. BOUBEE" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE M. HEYMANS" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 5 - VIF OCEAN
     * HorseID - VIF OCEAN
     */
    public static HorseID builderHorse_R4_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VIF OCEAN" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "CYGNUS D'ODYSSEE" );
        horseID.setMother( "OCEANIDE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 5 - VIF OCEAN
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
        horse.setCareerProfit( 4852000.0 );
        horse.setPreviousYearProfit( 2053000.0 );
        horse.setVictoryProfit( 2265000.0 );
        horse.setPlaceProfit( 2587000.0 );
        horse.setYearProfit( 458000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "MLLE S. BLANCHETIERE" ) );
        // no rancher
        horse.setJockey( jockey( "A. CURY" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 6 - VOLCAN DE BRANCA
     * HorseID - VOLCAN DE BRANCA
     */
    public static HorseID builderHorse_R4_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VOLCAN DE BRANCA" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MICKAEL DE VONNAS" );
        horseID.setMother( "KELLIA DE LA MOTTE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 4
     * Horse 6 - VOLCAN DE BRANCA
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
        horse.setCareerProfit( 5283000.0 );
        horse.setPreviousYearProfit( 2089000.0 );
        horse.setVictoryProfit( 2420000.0 );
        horse.setPlaceProfit( 2863000.0 );
        horse.setYearProfit( 133000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. ROUBAUD" ) );
        horse.setOwner( owner( "ECURIE SYLVAIN ROUBAUD" ) );
        // no rancher
        horse.setJockey( jockey( "K. DEVIENNE" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 7 - VETMIE DU PONT
     * HorseID - VETMIE DU PONT
     */
    public static HorseID builderHorse_R4_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VETMIE DU PONT" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "ISMAEL DU PONT" );
        horseID.setMother( "PELINIA VETMI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 7 - VETMIE DU PONT
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 2281900.0 );
        horse.setPreviousYearProfit( 405000.0 );
        horse.setVictoryProfit( 1523400.0 );
        horse.setPlaceProfit( 758500.0 );
        horse.setYearProfit( 110900.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME G. MASSCHAELE" ) );
        horse.setOwner( owner( "ECURIE ALBERT RAYON" ) );
        // no rancher
        horse.setJockey( jockey( "F. GAUVIN" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 8 - VEZZANI SOMOLLI
     * HorseID - VEZZANI SOMOLLI
     */
    public static HorseID builderHorse_R4_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VEZZANI SOMOLLI" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "QUICK DE LA LOGE" );
        horseID.setMother( "NETTY SOMOLLI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_BRULE );

        return horseID;

    }


    /*
     * Race 4
     * Horse 8 - VEZZANI SOMOLLI
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 4287000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 3450000.0 );
        horse.setPlaceProfit( 837000.0 );
        horse.setYearProfit( 84000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y. LAVIGNE" ) );
        horse.setOwner( owner( "MLLE E. MAISONNETTE" ) );
        // no rancher
        horse.setJockey( jockey( "F. BOULOT" ) );

        return horse;

    }

    /*
     * Race 4
     * Horse 9 - VASE CLOS
     * HorseID - VASE CLOS
     */
    public static HorseID builderHorse_R4_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VASE CLOS" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "DAHIR DE PRELONG" );
        horseID.setMother( "KARELLISE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 4
     * Horse 9 - VASE CLOS
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
        // no stable
        // no weight
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 4695000.0 );
        horse.setPreviousYearProfit( 1927000.0 );
        horse.setVictoryProfit( 2655000.0 );
        horse.setPlaceProfit( 2040000.0 );
        horse.setYearProfit( 971000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N. MOUROT" ) );
        horse.setOwner( owner( "G. LAUMESFELT" ) );
        // no rancher
        horse.setJockey( jockey( "A. DUGARD" ) );

        return horse;

    }

    /*
     * Race 4
     * Odds 1 - 13/08/2015 12:30:48 +0200
     */

    public static Odds builderOdds_R4_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:48 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 18.3 ) );
        simples.add( simple( odds, "3", 7.3 ) );
        simples.add( simple( odds, "5", 3.8 ) );
        simples.add( simple( odds, "6", 3.8 ) );
        simples.add( simple( odds, "7", 12.2 ) );
        simples.add( simple( odds, "8", 12.2 ) );
        simples.add( simple( odds, "9", 3.1 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 4
     * Odds 2 - 13/08/2015 16:01:34 +0200
     */

    public static Odds builderOdds_R4_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 16:01:34 +0200" ) );
        odds.setTotal( 1382.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 18.2 ) );
        simples.add( simple( odds, "2", 16.0 ) );
        simples.add( simple( odds, "3", 15.2 ) );
        simples.add( simple( odds, "4", 2.8 ) );
        simples.add( simple( odds, "5", 5.6 ) );
        simples.add( simple( odds, "6", 9.5 ) );
        simples.add( simple( odds, "7", 12.3 ) );
        simples.add( simple( odds, "8", 13.5 ) );
        simples.add( simple( odds, "9", 4.6 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5 - PRIX DE LA FECLAZ
     */

    public static Race builderRace_R5( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 5 );
        race.setName( "PRIX DE LA FECLAZ" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 16:30:00 +0200" ) );
        // no real start
        race.setDistance( 2025.0 );
        race.setBenefit( 11000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of( Type.RECLAMER ) );

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
        places.add( place( race,  1,  9 ) );
        places.add( place( race,  2, 12 ) );
        places.add( place( race,  3, 15 ) );
        places.add( place( race,  4,  5 ) );
        places.add( place( race,  5, 11 ) );
        places.add( place( race,  6, 16 ) );
        places.add( place( race,  7,  3 ) );
        places.add( place( race,  8,  8 ) );
        places.add( place( race,  9,  4 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "1 6 7 10 13" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 10.8, "9" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.6, "15" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.3, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 10.8, "9" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 48.3, "9 12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 28.8, "12 15" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.6, "15" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.3, "9" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 23.0, "9 12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 27.2, "9 15" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "9" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 48.3, "9 12" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 125.0, "9 12 15" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 5
     * Horse 1 - BAUCALIS
     * HorseID - BAUCALIS
     */
    public static HorseID builderHorse_R5_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAUCALIS" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MIRAGE DU GOUTIER" );
        horseID.setMother( "MELODIE D'ATOUT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 1 - BAUCALIS
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.M. GAUVIN" ) );
        horse.setOwner( owner( "ECURIE AIME GAUVIN" ) );
        // no rancher
        horse.setJockey( jockey( "M. MESSAGER" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 2 - BRISE DU CHATAULT
     * HorseID - BRISE DU CHATAULT
     */
    public static HorseID builderHorse_R5_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BRISE DU CHATAULT" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "LILIUM MADRIK" );
        horseID.setMother( "ROLLS DU CHATAULT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN_BRULE );

        return horseID;

    }


    /*
     * Race 5
     * Horse 2 - BRISE DU CHATAULT
     */

    public static Horse builderHorse_R5_H2( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H2_ID() );
        horse.setNumber( 2 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 0.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 0.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N. LANGLOIS" ) );
        horse.setOwner( owner( "N. HERTAULT" ) );
        // no rancher
        horse.setJockey( jockey( "Y.A. BRIAND" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 3 - BAHIA DU FER
     * HorseID - BAHIA DU FER
     */
    public static HorseID builderHorse_R5_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BAHIA DU FER" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OLITRO" );
        horseID.setMother( "NINON DU FERT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 3 - BAHIA DU FER
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 744000.0 );
        horse.setPreviousYearProfit( 726000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 744000.0 );
        horse.setYearProfit( 18000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BUSSET" ) );
        horse.setOwner( owner( "ECURIE DES ATIAUX" ) );
        // no rancher
        horse.setJockey( jockey( "A. ROZZONI" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 4 - BOTROT
     * HorseID - BOTROT
     */
    public static HorseID builderHorse_R5_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOTROT" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "OLBLAK DU BOCAGE" );
        horseID.setMother( "MISKOYA BLUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 4 - BOTROT
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 759000.0 );
        horse.setPreviousYearProfit( 88000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 759000.0 );
        horse.setYearProfit( 671000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. BOILLEREAU" ) );
        horse.setOwner( owner( "MME K. BENMOUSSA" ) );
        // no rancher
        horse.setJockey( jockey( "B. RUET" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 5 - BANDIT DE MELODIE
     * HorseID - BANDIT DE MELODIE
     */
    public static HorseID builderHorse_R5_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BANDIT DE MELODIE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "IN LOVE WITH YOU" );
        horseID.setMother( "MYTHICAL RODNEY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 5 - BANDIT DE MELODIE
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 865000.0 );
        horse.setPreviousYearProfit( 303000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 865000.0 );
        horse.setYearProfit( 562000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J. BOILLEREAU" ) );
        horse.setOwner( owner( "CH. FAIVRE PIERRET" ) );
        // no rancher
        horse.setJockey( jockey( "J. BOILLEREAU" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 6 - BOLERO DU JOUR
     * HorseID - BOLERO DU JOUR
     */
    public static HorseID builderHorse_R5_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOLERO DU JOUR" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JAM PRIDEM" );
        horseID.setMother( "IBLANSCA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 6 - BOLERO DU JOUR
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 986000.0 );
        horse.setPreviousYearProfit( 533000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 986000.0 );
        horse.setYearProfit( 453000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "TH. BUSSET" ) );
        horse.setOwner( owner( "ECURIE THIERRY BUSSET" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE J. BUSSET" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 7 - BIP BIP FRAZEEN
     * HorseID - BIP BIP FRAZEEN
     */
    public static HorseID builderHorse_R5_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BIP BIP FRAZEEN" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JAIN DE BEVAL" );
        horseID.setMother( "REGGAE NIGHT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 7 - BIP BIP FRAZEEN
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 1200000.0 );
        horse.setPreviousYearProfit( 725000.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 615000.0 );
        horse.setYearProfit( 28000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "ECURIE LAURENT VIRICEL" ) );
        // no rancher
        horse.setJockey( jockey( "S. PELTIER" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 8 - BANCO DE HOERDT
     * HorseID - BANCO DE HOERDT
     */
    public static HorseID builderHorse_R5_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BANCO DE HOERDT" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "OTELLO PIERJI" );
        horseID.setMother( "REINE DE BA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 8 - BANCO DE HOERDT
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 1289000.0 );
        horse.setPreviousYearProfit( 953000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 749000.0 );
        horse.setYearProfit( 336000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F. JUNG" ) );
        horse.setOwner( owner( "F. JUNG" ) );
        // no rancher
        horse.setJockey( jockey( "L. GAZENGEL" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 9 - BASTA DE BERTRANGE
     * HorseID - BASTA DE BERTRANGE
     */
    public static HorseID builderHorse_R5_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BASTA DE BERTRANGE" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "JEANBAT DU VIVIER" );
        horseID.setMother( "MARMARA JET" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 9 - BASTA DE BERTRANGE
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 1847000.0 );
        horse.setPreviousYearProfit( 451000.0 );
        horse.setVictoryProfit( 1125000.0 );
        horse.setPlaceProfit( 722000.0 );
        horse.setYearProfit( 1396000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R. MOURLON" ) );
        horse.setOwner( owner( "D. MOURLON" ) );
        // no rancher
        horse.setJockey( jockey( "F. BONNEFOY" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 10 - BACCARA DUBONHEUR
     * HorseID - BACCARA DUBONHEUR
     */
    public static HorseID builderHorse_R5_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BACCARA DUBONHEUR" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "LILIUM MADRIK" );
        horseID.setMother( "HELLO LILI" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 10 - BACCARA DUBONHEUR
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 707000.0 );
        horse.setPreviousYearProfit( 707000.0 );
        horse.setVictoryProfit( 495000.0 );
        horse.setPlaceProfit( 212000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y. LAVIGNE" ) );
        horse.setOwner( owner( "MLLE E. MAISONNETTE" ) );
        // no rancher
        horse.setJockey( jockey( "Y. LAVIGNE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 11 - BONHEUR DE BANNES
     * HorseID - BONHEUR DE BANNES
     */
    public static HorseID builderHorse_R5_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BONHEUR DE BANNES" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "VIVALDI DE CHENU" );
        horseID.setMother( "PETULA DE BANNES" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 5
     * Horse 11 - BONHEUR DE BANNES
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1282000.0 );
        horse.setPreviousYearProfit( 13000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1282000.0 );
        horse.setYearProfit( 1269000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. FOURNIGAULT" ) );
        horse.setOwner( owner( "G.H. BUISSON" ) );
        // no rancher
        horse.setJockey( jockey( "J. FOURNIGAULT" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 12 - BOCCADOR
     * HorseID - BOCCADOR
     */
    public static HorseID builderHorse_R5_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOCCADOR" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "PRINCE GEDE" );
        horseID.setMother( "SYRACUSE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 12 - BOCCADOR
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1350000.0 );
        horse.setPreviousYearProfit( 815000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 810000.0 );
        horse.setYearProfit( 535000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. CHAUVE-LAFFAY" ) );
        horse.setOwner( owner( "R. GAJA" ) );
        // no rancher
        horse.setJockey( jockey( "H. CHAUVE-LAFFAY" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 13 - BISIXTINE CHENOU
     * HorseID - BISIXTINE CHENOU
     */
    public static HorseID builderHorse_R5_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BISIXTINE CHENOU" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "OYONNAX" );
        horseID.setMother( "PAMIA DE CHENOU" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 13 - BISIXTINE CHENOU
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1533000.0 );
        horse.setPreviousYearProfit( 440000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 1533000.0 );
        horse.setYearProfit( 1093000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. LERENARD" ) );
        horse.setOwner( owner( "F. LERENARD" ) );
        // no rancher
        horse.setJockey( jockey( "F. JAMARD" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 14 - BOUNTY DU MONCEL
     * HorseID - BOUNTY DU MONCEL
     */
    public static HorseID builderHorse_R5_H14_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BOUNTY DU MONCEL" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "DEFI D'AUNOU" );
        horseID.setMother( "KISS ME GIRL" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.AUBERE );

        return horseID;

    }


    /*
     * Race 5
     * Horse 14 - BOUNTY DU MONCEL
     */

    public static Horse builderHorse_R5_H14( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R5_H14_ID() );
        horse.setNumber( 14 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1584000.0 );
        horse.setPreviousYearProfit( 296000.0 );
        horse.setVictoryProfit( 585000.0 );
        horse.setPlaceProfit( 999000.0 );
        horse.setYearProfit( 1288000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "MME G. MASSCHAELE" ) );
        horse.setOwner( owner( "CH. LEJEUNE" ) );
        // no rancher
        horse.setJockey( jockey( "PH. MASSCHAELE" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 15 - BULLITT D'ORMOY
     * HorseID - BULLITT D'ORMOY
     */
    public static HorseID builderHorse_R5_H15_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BULLITT D'ORMOY" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "QUITUS DU MEXIQUE" );
        horseID.setMother( "ROXANE D'ORMOY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 15 - BULLITT D'ORMOY
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1758000.0 );
        horse.setPreviousYearProfit( 1035000.0 );
        horse.setVictoryProfit( 540000.0 );
        horse.setPlaceProfit( 1218000.0 );
        horse.setYearProfit( 723000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "P. CALLIER" ) );
        // no rancher
        horse.setJockey( jockey( "P. CALLIER" ) );

        return horse;

    }

    /*
     * Race 5
     * Horse 16 - BILL DE CAHOT
     * HorseID - BILL DE CAHOT
     */
    public static HorseID builderHorse_R5_H16_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "BILL DE CAHOT" );
        horseID.setBirth( parse( "01/01/2011 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MON PREMIER CEHERE" );
        horseID.setMother( "JOCONDE D'ATOUT" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 5
     * Horse 16 - BILL DE CAHOT
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 2175000.0 );
        horse.setPreviousYearProfit( 625000.0 );
        horse.setVictoryProfit( 1035000.0 );
        horse.setPlaceProfit( 1140000.0 );
        horse.setYearProfit( 1528000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "A. BONNEFOY" ) );
        horse.setOwner( owner( "A. BONNEFOY" ) );
        // no rancher
        horse.setJockey( jockey( "A. BONNEFOY" ) );

        return horse;

    }

    /*
     * Race 5
     * Odds 1 - 13/08/2015 12:30:50 +0200
     */

    public static Odds builderOdds_R5_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:50 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 31.4 ) );
        simples.add( simple( odds, "2", 36.7 ) );
        simples.add( simple( odds, "4", 73.4 ) );
        simples.add( simple( odds, "5", 22.0 ) );
        simples.add( simple( odds, "6", 55.0 ) );
        simples.add( simple( odds, "7", 24.4 ) );
        simples.add( simple( odds, "8", 9.1 ) );
        simples.add( simple( odds, "9", 7.8 ) );
        simples.add( simple( odds, "11", 36.7 ) );
        simples.add( simple( odds, "12", 36.7 ) );
        simples.add( simple( odds, "13", 73.4 ) );
        simples.add( simple( odds, "14", 1.6 ) );
        simples.add( simple( odds, "16", 11.0 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 5
     * Odds 2 - 13/08/2015 16:34:04 +0200
     */

    public static Odds builderOdds_R5_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 16:34:04 +0200" ) );
        odds.setTotal( 2209.0 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 31.0 ) );
        simples.add( simple( odds, "2", 11.1 ) );
        simples.add( simple( odds, "3", 62.7 ) );
        simples.add( simple( odds, "4", 23.2 ) );
        simples.add( simple( odds, "5", 6.1 ) );
        simples.add( simple( odds, "6", 60.6 ) );
        simples.add( simple( odds, "7", 2.6 ) );
        simples.add( simple( odds, "8", 38.5 ) );
        simples.add( simple( odds, "9", 10.8 ) );
        simples.add( simple( odds, "10", 90.2 ) );
        simples.add( simple( odds, "11", 9.4 ) );
        simples.add( simple( odds, "12", 11.6 ) );
        simples.add( simple( odds, "13", 13.3 ) );
        simples.add( simple( odds, "14", 1.8 ) );
        simples.add( simple( odds, "15", 21.5 ) );
        simples.add( simple( odds, "16", 9.5 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6 - PRIX APC ETANCH - PRIX DU TILLET
     */

    public static Race builderRace_R6( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 6 );
        race.setName( "PRIX APC ETANCH - PRIX DU TILLET" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 17:00:00 +0200" ) );
        // no real start
        race.setDistance( 2000.0 );
        race.setBenefit( 25000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.noneOf( Type.class ) );

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
        horses.add( builderHorse_R6_H13( race ) );
        race.setHorses( horses );

        // -- bets --
        race.setBets( EnumSet.of(
                BetType.SIMPLE_GAGNANT,
                BetType.SIMPLE_PLACE,
                BetType.COUPLE_GAGNANT,
                BetType.COUPLE_PLACE,
                BetType.TRIO,
                BetType.MULTI_EN_QUATRE,
                BetType.MULTI_EN_CINQ,
                BetType.MULTI_EN_SIX,
                BetType.QUARTE ) );

        // -- odds --
        SortedSet<Odds> oddsSet = new TreeSet<Odds>();
        oddsSet.add( builderOdds_R6_O1( race ) );
        oddsSet.add( builderOdds_R6_O2( race ) );
        race.setOdds( oddsSet );

        // no duration

        // -- finish --
        SortedSet<Place> places = new TreeSet<Place>();
        places.add( place( race,  1,  3 ) );
        places.add( place( race,  2, 12 ) );
        places.add( place( race,  3,  8 ) );
        places.add( place( race,  4,  2 ) );
        places.add( place( race,  5,  5 ) );
        places.add( place( race,  6,  9 ) );
        places.add( place( race,  7, 10 ) );
        places.add( place( race,  8, 11 ) );
        places.add( place( race,  9,  1 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "7" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 8.5, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.2, "12" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.7, "3" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.7, "8" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 8.5, "3" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 10.2, "3 12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.2, "12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.5, "12 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.7, "3" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.9, "3 12" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 24.9, "3 8" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.7, "8" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "3" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 10.2, "3 12" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 77.2, "3 12 8" ) );
        prices.add( price( race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 91.5, "3 12 8 2" ) );
        prices.add( price( race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 18.3, "3 12 8 2" ) );
        prices.add( price( race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 6.1, "3 12 8 2" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.DIRECT, 45.6, "3 12 8 2" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.ORDRE, 666.9, "3 12 8 2" ) );
        prices.add( price( race, BetType.QUARTE, PriceName.BONUS_3, 9.2, "3 12 8" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 6
     * Horse 1 - TENOR DU SOURCE
     * HorseID - TENOR DU SOURCE
     */
    public static HorseID builderHorse_R6_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TENOR DU SOURCE" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "COKTAIL JET" );
        horseID.setMother( "FADIR CASTELETS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 1 - TENOR DU SOURCE
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 6816000.0 );
        horse.setPreviousYearProfit( 1144000.0 );
        horse.setVictoryProfit( 4425000.0 );
        horse.setPlaceProfit( 2391000.0 );
        horse.setYearProfit( 482000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. HOJKA" ) );
        horse.setOwner( owner( "G. VANBELLE" ) );
        // no rancher
        horse.setJockey( jockey( "Y.A. BRIAND" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 2 - VEGA MESLOISE
     * HorseID - VEGA MESLOISE
     */
    public static HorseID builderHorse_R6_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VEGA MESLOISE" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "GANYMEDE" );
        horseID.setMother( "MANON MESLOISE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 2 - VEGA MESLOISE
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 6902000.0 );
        horse.setPreviousYearProfit( 2440000.0 );
        horse.setVictoryProfit( 2475000.0 );
        horse.setPlaceProfit( 4427000.0 );
        horse.setYearProfit( 882000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. CHAUVE-LAFFAY" ) );
        horse.setOwner( owner( "R. GAJA" ) );
        // no rancher
        horse.setJockey( jockey( "PH. MASSCHAELE" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 3 - VANINA LOULOU
     * HorseID - VANINA LOULOU
     */
    public static HorseID builderHorse_R6_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VANINA LOULOU" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "QUIDO DU GOUTIER" );
        horseID.setMother( "KANOU DE GENETINE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 3 - VANINA LOULOU
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 6987000.0 );
        horse.setPreviousYearProfit( 1291000.0 );
        horse.setVictoryProfit( 2485000.0 );
        horse.setPlaceProfit( 4502000.0 );
        horse.setYearProfit( 1835000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "H. CHAUVE-LAFFAY" ) );
        horse.setOwner( owner( "ECURIE HERVE CHAUVE-LAFFAY" ) );
        // no rancher
        horse.setJockey( jockey( "H. CHAUVE-LAFFAY" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 4 - ABSOLUTELY FASHION
     * HorseID - ABSOLUTELY FASHION
     */
    public static HorseID builderHorse_R6_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ABSOLUTELY FASHION" );
        horseID.setBirth( parse( "01/01/2010 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "GROS GRAIN" );
        horseID.setMother( "HEURE PRECISE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_FONCE );

        return horseID;

    }


    /*
     * Race 6
     * Horse 4 - ABSOLUTELY FASHION
     */

    public static Horse builderHorse_R6_H4( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H4_ID() );
        horse.setNumber( 4 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 6995000.0 );
        horse.setPreviousYearProfit( 1288000.0 );
        horse.setVictoryProfit( 1985000.0 );
        horse.setPlaceProfit( 5010000.0 );
        horse.setYearProfit( 1653000.0 );
        horse.setHorseshoe( Horseshoe.NO_POSTERIOR );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. BOUYER" ) );
        horse.setOwner( owner( "ECURIE PIERRE PILARSKI" ) );
        // no rancher
        horse.setJockey( jockey( "G. BOUYER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 5 - ULIMA DU CITRUS
     * HorseID - ULIMA DU CITRUS
     */
    public static HorseID builderHorse_R6_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "ULIMA DU CITRUS" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NIKY" );
        horseID.setMother( "ISKA BLEUE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 5 - ULIMA DU CITRUS
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 7031000.0 );
        horse.setPreviousYearProfit( 0.0 );
        horse.setVictoryProfit( 2200000.0 );
        horse.setPlaceProfit( 4831000.0 );
        horse.setYearProfit( 1028000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. RUET" ) );
        horse.setOwner( owner( "P. TAILPIED" ) );
        // no rancher
        horse.setJockey( jockey( "B. RUET" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 6 - VANESSE
     * HorseID - VANESSE
     */
    public static HorseID builderHorse_R6_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VANESSE" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.FEMALE );
        // no gelding
        horseID.setFather( "NUMBER MAJYC" );
        horseID.setMother( "LA RAFALE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.NOIR );

        return horseID;

    }


    /*
     * Race 6
     * Horse 6 - VANESSE
     */

    public static Horse builderHorse_R6_H6( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H6_ID() );
        horse.setNumber( 6 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 7041000.0 );
        horse.setPreviousYearProfit( 3807000.0 );
        horse.setVictoryProfit( 3525000.0 );
        horse.setPlaceProfit( 3516000.0 );
        horse.setYearProfit( 1599000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. LAMAZIERE" ) );
        horse.setOwner( owner( "CL. BODIN" ) );
        // no rancher
        horse.setJockey( jockey( "L. LAMAZIERE" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 7 - UN PREMIER AVRIL
     * HorseID - UN PREMIER AVRIL
     */
    public static HorseID builderHorse_R6_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UN PREMIER AVRIL" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "NIKY" );
        horseID.setMother( "ODYSSEE LEADER" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 7 - UN PREMIER AVRIL
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 7077000.0 );
        horse.setPreviousYearProfit( 768000.0 );
        horse.setVictoryProfit( 2715000.0 );
        horse.setPlaceProfit( 4362000.0 );
        horse.setYearProfit( 366000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "D. JAMARD" ) );
        horse.setOwner( owner( "N.R. LAMOUR" ) );
        // no rancher
        horse.setJockey( jockey( "J. BOILLEREAU" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 8 - TOTEM DE TOUCHYVON
     * HorseID - TOTEM DE TOUCHYVON
     */
    public static HorseID builderHorse_R6_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TOTEM DE TOUCHYVON" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "GANYMEDE" );
        horseID.setMother( "KORE FRANJAC" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 8 - TOTEM DE TOUCHYVON
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 7149000.0 );
        horse.setPreviousYearProfit( 884000.0 );
        horse.setVictoryProfit( 1175000.0 );
        horse.setPlaceProfit( 5974000.0 );
        horse.setYearProfit( 1361000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "G. TOURON" ) );
        horse.setOwner( owner( "G. TOURON" ) );
        // no rancher
        horse.setJockey( jockey( "G. TOURON" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 9 - TWEED DE CHANTEINS
     * HorseID - TWEED DE CHANTEINS
     */
    public static HorseID builderHorse_R6_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TWEED DE CHANTEINS" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "BASSANO" );
        horseID.setMother( "MAUVE DE DAV" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 9 - TWEED DE CHANTEINS
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
        horse.setDistance( 2000.0 );
        horse.setCareerProfit( 7160000.0 );
        horse.setPreviousYearProfit( 250000.0 );
        horse.setVictoryProfit( 2500000.0 );
        horse.setPlaceProfit( 4660000.0 );
        horse.setYearProfit( 735000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "S. DUMONT" ) );
        horse.setOwner( owner( "MME R. VACHERON" ) );
        // no rancher
        horse.setJockey( jockey( "L. GAZENGEL" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 10 - VENCEDOR
     * HorseID - VENCEDOR
     */
    public static HorseID builderHorse_R6_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VENCEDOR" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "PRODIGIOUS" );
        horseID.setMother( "NANGOON D'AR" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 10 - VENCEDOR
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1.12215E7 );
        horse.setPreviousYearProfit( 2370500.0 );
        horse.setVictoryProfit( 4150000.0 );
        horse.setPlaceProfit( 7071500.0 );
        horse.setYearProfit( 1741000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. PELTIER" ) );
        horse.setOwner( owner( "ECURIE PARADIS" ) );
        // no rancher
        horse.setJockey( jockey( "S. PELTIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 11 - TROPIC DE LORMAT
     * HorseID - TROPIC DE LORMAT
     */
    public static HorseID builderHorse_R6_H11_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TROPIC DE LORMAT" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FLASH DE COSSE" );
        horseID.setMother( "LADY LAURE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 6
     * Horse 11 - TROPIC DE LORMAT
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1.1806E7 );
        horse.setPreviousYearProfit( 3458000.0 );
        horse.setVictoryProfit( 4550000.0 );
        horse.setPlaceProfit( 7256000.0 );
        horse.setYearProfit( 631000.0 );
        horse.setHorseshoe( Horseshoe.NO_FORELEG );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "B. THOMAS" ) );
        horse.setOwner( owner( "B. THOMAS" ) );
        // no rancher
        horse.setJockey( jockey( "B. THOMAS" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 12 - VERY VERY FAST
     * HorseID - VERY VERY FAST
     */
    public static HorseID builderHorse_R6_H12_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "VERY VERY FAST" );
        horseID.setBirth( parse( "01/01/2009 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "QUARO" );
        horseID.setMother( "NOCTURNE DE BRESSE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 12 - VERY VERY FAST
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
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1.31877E7 );
        horse.setPreviousYearProfit( 2757700.0 );
        horse.setVictoryProfit( 7405000.0 );
        horse.setPlaceProfit( 5782700.0 );
        horse.setYearProfit( 6419000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "P. CALLIER" ) );
        // no rancher
        horse.setJockey( jockey( "P. CALLIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Horse 13 - SPIRIT DES LOGOS
     * HorseID - SPIRIT DES LOGOS
     */
    public static HorseID builderHorse_R6_H13_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "SPIRIT DES LOGOS" );
        horseID.setBirth( parse( "01/01/2006 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JOMO DU RIB" );
        horseID.setMother( "LOOK AT MARIE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 6
     * Horse 13 - SPIRIT DES LOGOS
     */

    public static Horse builderHorse_R6_H13( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R6_H13_ID() );
        horse.setNumber( 13 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2025.0 );
        horse.setCareerProfit( 1.497E7 );
        horse.setPreviousYearProfit( 1455000.0 );
        horse.setVictoryProfit( 4390000.0 );
        horse.setPlaceProfit( 1.058E7 );
        horse.setYearProfit( 290000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "F.J. PELTIER" ) );
        horse.setOwner( owner( "F.J. PELTIER" ) );
        // no rancher
        horse.setJockey( jockey( "F.J. PELTIER" ) );

        return horse;

    }

    /*
     * Race 6
     * Odds 1 - 13/08/2015 12:31:04 +0200
     */

    public static Odds builderOdds_R6_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:31:04 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 23.1 ) );
        simples.add( simple( odds, "2", 14.0 ) );
        simples.add( simple( odds, "3", 7.4 ) );
        simples.add( simple( odds, "4", 11.9 ) );
        simples.add( simple( odds, "5", 5.2 ) );
        simples.add( simple( odds, "7", 10.4 ) );
        simples.add( simple( odds, "8", 13.7 ) );
        simples.add( simple( odds, "9", 18.7 ) );
        simples.add( simple( odds, "10", 15.4 ) );
        simples.add( simple( odds, "11", 12.6 ) );
        simples.add( simple( odds, "12", 2.6 ) );
        simples.add( simple( odds, "13", 10.7 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 6
     * Odds 2 - 13/08/2015 17:01:37 +0200
     */

    public static Odds builderOdds_R6_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:01:37 +0200" ) );
        odds.setTotal( 3431.0 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 11.4 ) );
        simples.add( simple( odds, "2", 12.1 ) );
        simples.add( simple( odds, "3", 8.5 ) );
        simples.add( simple( odds, "4", 22.1 ) );
        simples.add( simple( odds, "5", 9.9 ) );
        simples.add( simple( odds, "6", 30.5 ) );
        simples.add( simple( odds, "7", 18.1 ) );
        simples.add( simple( odds, "8", 17.4 ) );
        simples.add( simple( odds, "9", 11.0 ) );
        simples.add( simple( odds, "10", 8.9 ) );
        simples.add( simple( odds, "11", 13.6 ) );
        simples.add( simple( odds, "12", 2.4 ) );
        simples.add( simple( odds, "13", 25.4 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7 - PRIX D'ALBERTVILLE
     */

    public static Race builderRace_R7( Meeting meeting ) {

        Race race = new Race();

        race.setMeeting( meeting );
        race.setNumber( 7 );
        race.setName( "PRIX D'ALBERTVILLE" );
        race.setStatus( RaceStatus.FINISHED );
        race.setStart( parse( "13/08/2015 17:30:00 +0200" ) );
        // no real start
        race.setDistance( 2725.0 );
        race.setBenefit( 4000.0 );
        race.setDiscipline( Discipline.TROT_ATTELE );
        race.setTypes( EnumSet.of(
                Type.RECLAMER,
                Type.AMATEURS ) );
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
        places.add( place( race,  1,  2 ) );
        places.add( place( race,  2,  5 ) );
        places.add( place( race,  3,  1 ) );
        places.add( place( race,  4,  8 ) );
        places.add( place( race,  5,  4 ) );
        places.add( place( race,  6,  9 ) );
        places.add( place( race,  7,  6 ) );
        places.add( place( race,  8, 10 ) );
        race.setPlaces( places );

        // no stopped
        race.setDisqualified( "7" );
        // no fallen

        // -- prices --
        SortedSet<Price> prices = new TreeSet<>();
        prices.add( price( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 23.3, "2" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.1, "1" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.1, "2" ) );
        prices.add( price( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.0, "5" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 23.3, "2" ) );
        prices.add( price( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 122.7, "2 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.1, "1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.1, "2" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 17.3, "2 1" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 31.1, "2 5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.0, "5" ) );
        prices.add( price( race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.3, "5 1" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 0.0, "2 5" ) );
        prices.add( price( race, BetType.TRIO, PriceName.DIRECT, 356.0, "2 5 1" ) );
        race.setPrices( prices );

        return race;

    }

    /*
     * Race 7
     * Horse 1 - UNCLE NED
     * HorseID - UNCLE NED
     */
    public static HorseID builderHorse_R7_H1_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UNCLE NED" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "MIRAGE DU GOUTIER" );
        horseID.setMother( "NOCARIA MAG" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 1 - UNCLE NED
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
        horse.setCareerProfit( 3800000.0 );
        horse.setPreviousYearProfit( 845000.0 );
        horse.setVictoryProfit( 0.0 );
        horse.setPlaceProfit( 3800000.0 );
        horse.setYearProfit( 44000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "P. CALLIER" ) );
        horse.setOwner( owner( "M. AGOSTINI" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE M. CALLIER" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 2 - TEAM DES ANDIERS
     * HorseID - TEAM DES ANDIERS
     */
    public static HorseID builderHorse_R7_H2_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TEAM DES ANDIERS" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "VIVIER DE MONTFORT" );
        horseID.setMother( "KALIE DES ANDIERS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 2 - TEAM DES ANDIERS
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
        horse.setCareerProfit( 4524000.0 );
        horse.setPreviousYearProfit( 522000.0 );
        horse.setVictoryProfit( 1735000.0 );
        horse.setPlaceProfit( 2789000.0 );
        horse.setYearProfit( 216000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "L. GOUT" ) );
        horse.setOwner( owner( "A.X. SOCIAS" ) );
        // no rancher
        horse.setJockey( jockey( "J. JOFFROY" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 3 - TIGRE DE MORCHIES
     * HorseID - TIGRE DE MORCHIES
     */
    public static HorseID builderHorse_R7_H3_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TIGRE DE MORCHIES" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "ISLERO DE BELLOUET" );
        horseID.setMother( "MELVA DES PINONS" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 3 - TIGRE DE MORCHIES
     */

    public static Horse builderHorse_R7_H3( Race race ) {

        Horse horse = new Horse();

        horse.setRace( race );
        horse.setHorseID( builderHorse_R7_H3_ID() );
        horse.setNumber( 3 );
        horse.setRunner( false );
        horse.setSupplemented( false );
        horse.setPregnant( false );
        // no stall
        // no stable
        // no weight
        horse.setDistance( 2700.0 );
        horse.setCareerProfit( 4983000.0 );
        horse.setPreviousYearProfit( 783000.0 );
        horse.setVictoryProfit( 500000.0 );
        horse.setPlaceProfit( 4483000.0 );
        horse.setYearProfit( 34000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N. HERTAULT" ) );
        horse.setOwner( owner( "N. HERTAULT" ) );
        // no rancher
        horse.setJockey( jockey( "N. HERTAULT" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 4 - TONTON PAUL
     * HorseID - TONTON PAUL
     */
    public static HorseID builderHorse_R7_H4_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TONTON PAUL" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "LOULOU JET" );
        horseID.setMother( "JENNA DU CHENE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 4 - TONTON PAUL
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
        horse.setCareerProfit( 5011000.0 );
        horse.setPreviousYearProfit( 936000.0 );
        horse.setVictoryProfit( 810000.0 );
        horse.setPlaceProfit( 4201000.0 );
        horse.setYearProfit( 153000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "E. GERBET" ) );
        horse.setOwner( owner( "B. GATHERON" ) );
        // no rancher
        horse.setJockey( jockey( "B. GATHERON" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 5 - URTADO
     * HorseID - URTADO
     */
    public static HorseID builderHorse_R7_H5_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "URTADO" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        // no gelding
        horseID.setFather( "OFFSHORE DREAM" );
        horseID.setMother( "DIVA DU BOUFFEY" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 5 - URTADO
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
        horse.setCareerProfit( 5043300.0 );
        horse.setPreviousYearProfit( 1859000.0 );
        horse.setVictoryProfit( 2505000.0 );
        horse.setPlaceProfit( 2480400.0 );
        horse.setYearProfit( 33000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "N. MOUROT" ) );
        horse.setOwner( owner( "G. LAUMESFELT" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE A. HARET" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 6 - TYCOON EXPRESS
     * HorseID - TYCOON EXPRESS
     */
    public static HorseID builderHorse_R7_H6_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TYCOON EXPRESS" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "KIWI" );
        horseID.setMother( "JURASSIENNE NOBLE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI_BRUN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 6 - TYCOON EXPRESS
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
        horse.setCareerProfit( 5615500.0 );
        horse.setPreviousYearProfit( 218000.0 );
        horse.setVictoryProfit( 2250000.0 );
        horse.setPlaceProfit( 3365500.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. PARLA" ) );
        horse.setOwner( owner( "M. PARLA" ) );
        // no rancher
        horse.setJockey( jockey( "M. PARLA" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 7 - TREVOR SHANNON
     * HorseID - TREVOR SHANNON
     */
    public static HorseID builderHorse_R7_H7_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TREVOR SHANNON" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "JULIANO STAR" );
        horseID.setMother( "FICTION DE SHANNON" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.ALEZAN );

        return horseID;

    }


    /*
     * Race 7
     * Horse 7 - TREVOR SHANNON
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
        horse.setCareerProfit( 5750000.0 );
        horse.setPreviousYearProfit( 205000.0 );
        horse.setVictoryProfit( 1950000.0 );
        horse.setPlaceProfit( 3800000.0 );
        horse.setYearProfit( 0.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "R.F. PERRET" ) );
        horse.setOwner( owner( "R.F. PERRET" ) );
        // no rancher
        horse.setJockey( jockey( "R.F. PERRET" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 8 - TARAK DES ERABLAIS
     * HorseID - TARAK DES ERABLAIS
     */
    public static HorseID builderHorse_R7_H8_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TARAK DES ERABLAIS" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FANACLAND" );
        horseID.setMother( "AQUATILE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 8 - TARAK DES ERABLAIS
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 5477000.0 );
        horse.setPreviousYearProfit( 810000.0 );
        horse.setVictoryProfit( 2645000.0 );
        horse.setPlaceProfit( 2832000.0 );
        horse.setYearProfit( 1213000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "Y.A. BRIAND" ) );
        horse.setOwner( owner( "MLLE S. BLANCHETIERE" ) );
        // no rancher
        horse.setJockey( jockey( "MLLE S. BLANCHETIERE" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 9 - TORRENT D'EMOTION
     * HorseID - TORRENT D'EMOTION
     */
    public static HorseID builderHorse_R7_H9_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "TORRENT D'EMOTION" );
        horseID.setBirth( parse( "01/01/2007 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "COROT" );
        horseID.setMother( "NOUVEAUTE DU CORTA" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 9 - TORRENT D'EMOTION
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 6635000.0 );
        horse.setPreviousYearProfit( 1299000.0 );
        horse.setVictoryProfit( 2050000.0 );
        horse.setPlaceProfit( 4585000.0 );
        horse.setYearProfit( 779000.0 );
        horse.setHorseshoe( Horseshoe.ALL );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "J.CL. LAMAZIERE" ) );
        horse.setOwner( owner( "J.CL. LAMAZIERE" ) );
        // no rancher
        horse.setJockey( jockey( "J.CL. LAMAZIERE" ) );

        return horse;

    }

    /*
     * Race 7
     * Horse 10 - UPSILON DARCHE
     * HorseID - UPSILON DARCHE
     */
    public static HorseID builderHorse_R7_H10_ID() {

        HorseID horseID = new HorseID();

        horseID.setName( "UPSILON DARCHE" );
        horseID.setBirth( parse( "01/01/2008 00:00:00 +0100" ) );
        horseID.setSex( Sex.MALE );
        horseID.setGelding( parse( "13/08/2015 00:00:00 +0200" ) );
        horseID.setFather( "FIRST WAY" );
        horseID.setMother( "NAVYDARCHE" );
        horseID.setBreed( Breed.TROTTEUR_FRANCAIS );
        horseID.setCoat( Coat.BAI );

        return horseID;

    }


    /*
     * Race 7
     * Horse 10 - UPSILON DARCHE
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
        horse.setDistance( 2725.0 );
        horse.setCareerProfit( 7080000.0 );
        horse.setPreviousYearProfit( 2556000.0 );
        horse.setVictoryProfit( 3455000.0 );
        horse.setPlaceProfit( 3625000.0 );
        horse.setYearProfit( 208000.0 );
        horse.setHorseshoe( Horseshoe.NONE );
        horse.setBlinder( Blinder.NONE );
        horse.setTrainer( trainer( "M. BONNEFOY" ) );
        horse.setOwner( owner( "CH. RULLY" ) );
        // no rancher
        horse.setJockey( jockey( "M. MONIER" ) );

        return horse;

    }

    /*
     * Race 7
     * Odds 1 - 13/08/2015 12:30:57 +0200
     */

    public static Odds builderOdds_R7_O1( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 12:30:57 +0200" ) );
        // no total

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 4.3 ) );
        simples.add( simple( odds, "4", 28.6 ) );
        simples.add( simple( odds, "5", 14.3 ) );
        simples.add( simple( odds, "7", 21.5 ) );
        simples.add( simple( odds, "8", 2.9 ) );
        simples.add( simple( odds, "9", 2.8 ) );
        simples.add( simple( odds, "10", 8.6 ) );
        odds.setSimples( simples );

        return odds;

    }

    /*
     * Race 7
     * Odds 2 - 13/08/2015 17:30:54 +0200
     */

    public static Odds builderOdds_R7_O2( Race race ) {

        Odds odds = new Odds();

        odds.setRace( race );
        odds.setDate( parse( "13/08/2015 17:30:54 +0200" ) );
        odds.setTotal( 2537.5 );

        SortedSet<Simple> simples = new TreeSet<>();
        simples.add( simple( odds, "1", 11.3 ) );
        simples.add( simple( odds, "2", 23.3 ) );
        simples.add( simple( odds, "3", 19.6 ) );
        simples.add( simple( odds, "4", 12.3 ) );
        simples.add( simple( odds, "5", 19.8 ) );
        simples.add( simple( odds, "6", 39.2 ) );
        simples.add( simple( odds, "7", 35.0 ) );
        simples.add( simple( odds, "8", 1.3 ) );
        simples.add( simple( odds, "9", 11.4 ) );
        simples.add( simple( odds, "10", 19.1 ) );
        odds.setSimples( simples );

        return odds;

    }

}
