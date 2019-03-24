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

public class Meeting_20150813_M2 extends MeetingBuilder {

	public static Meeting build() {

		Meeting meeting = new Meeting();

		meeting.setDate(parse("13/08/2015 00:00:00 +0200"));
		meeting.setRacecourse(racecourse("MESLAY DU MAINE", "FRANCE"));
		meeting.setNumber(2);
		meeting.setWindSpeed(18.0);
		meeting.setWindDirection(WindDirection.SW);
		meeting.setTemperature(23.0);
		meeting.setClimat("RISQUE D'AVERSES");
		meeting.setField(Field.UNKNOWN);

		// -- races --
		SortedSet<Race> races = new TreeSet<>();
		races.add(builderRace_R1(meeting));
		races.add(builderRace_R2(meeting));
		races.add(builderRace_R3(meeting));
		races.add(builderRace_R4(meeting));
		races.add(builderRace_R5(meeting));
		races.add(builderRace_R6(meeting));
		races.add(builderRace_R7(meeting));
		races.add(builderRace_R8(meeting));
		meeting.setRaces(races);

		return meeting;

	}

	/*
	 * Race 1 - PRIX DE LA CCI DE LA MAYENNE
	 */

	public static Race builderRace_R1(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(1);
		race.setName("PRIX DE LA CCI DE LA MAYENNE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 12:30:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(20000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.NATIONALE));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R1_H1(race));
		horses.add(builderHorse_R1_H2(race));
		horses.add(builderHorse_R1_H3(race));
		horses.add(builderHorse_R1_H4(race));
		horses.add(builderHorse_R1_H5(race));
		horses.add(builderHorse_R1_H6(race));
		horses.add(builderHorse_R1_H7(race));
		horses.add(builderHorse_R1_H8(race));
		horses.add(builderHorse_R1_H9(race));
		horses.add(builderHorse_R1_H10(race));
		horses.add(builderHorse_R1_H11(race));
		horses.add(builderHorse_R1_H12(race));
		horses.add(builderHorse_R1_H13(race));
		horses.add(builderHorse_R1_H14(race));
		horses.add(builderHorse_R1_H15(race));
		horses.add(builderHorse_R1_H16(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R1_O1(race));
		oddsSet.add(builderOdds_R1_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 9, 223760));
		places.add(place(race, 2, 11, 223960));
		places.add(place(race, 3, 5, 224010));
		places.add(place(race, 4, 6, 224140));
		places.add(place(race, 4, 12, "DEAD_HEAT"));
		places.add(place(race, 6, 13, 224200));
		places.add(place(race, 7, 10, 224760));
		places.add(place(race, 8, 1, 224870));
		places.add(place(race, 9, 3, 225490));
		places.add(place(race, 10, 4, 225610));
		places.add(place(race, 11, 14, 228460));
		places.add(place(race, 12, 2, 228460));
		places.add(place(race, 13, 7, 237190));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("8 15 16");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 7.6, "9"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.5, "11"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.9, "5"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.6, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 77.3, "9 11"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 29.8, "9 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 39.3, "11 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 12.0, "9 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 32.7, "9 5"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 355.6, "9 11 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "11 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "11 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "11 6"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "5 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "5 6"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "9 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "9 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "9 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.1, "9 6"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 210.0, "9 11 5 12"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 210.0, "9 11 5 6"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 42.0, "9 11 5 12"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 42.0, "9 11 5 6"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 14.0, "9 11 5 12"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 14.0, "9 11 5 6"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 6.0, "9 11 5 12"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 6.0, "9 11 5 6"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 1
	 * Horse 1 - CONSTELLATION
	 * HorseID - CONSTELLATION
	 */
	public static HorseID builderHorse_R1_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CONSTELLATION");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OPUS VIERVIL");
		horseID.setMother("METEORITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 1 - CONSTELLATION
	 */

	public static Horse builderHorse_R1_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(575000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(575000.0);
		horse.setYearProfit(575000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. LEFEVRE"));
		horse.setOwner(owner("ECURIE BERTRAND LEFEVRE"));
		// no rancher
		horse.setJockey(jockey("MME CL.M. DELACOUR"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 2 - CADOR LEMAN
	 * HorseID - CADOR LEMAN
	 */
	public static HorseID builderHorse_R1_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CADOR LEMAN");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("KAISER SOZE");
		horseID.setMother("LUTECE LEMAN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 2 - CADOR LEMAN
	 */

	public static Horse builderHorse_R1_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(683000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(683000.0);
		horse.setYearProfit(683000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH.A. MARY"));
		horse.setOwner(owner("ECURIE CH. A. MARY"));
		// no rancher
		horse.setJockey(jockey("CH.A. MARY"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 3 - CROKS DE GUEZ
	 * HorseID - CROKS DE GUEZ
	 */
	public static HorseID builderHorse_R1_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CROKS DE GUEZ");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("OLITRO");
		horseID.setMother("LENA DE BELLOUET");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 3 - CROKS DE GUEZ
	 */

	public static Horse builderHorse_R1_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		horse.setStable("A");
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(720000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(720000.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(720000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE VAUTORS"));
		// no rancher
		horse.setJockey(jockey("N. CHEREAU"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 4 - CARABIN D'URZY
	 * HorseID - CARABIN D'URZY
	 */
	public static HorseID builderHorse_R1_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CARABIN D'URZY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GANYMEDE");
		horseID.setMother("PERLE D'URZY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 4 - CARABIN D'URZY
	 */

	public static Horse builderHorse_R1_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(744000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(450000.0);
		horse.setPlaceProfit(294000.0);
		horse.setYearProfit(744000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE DU HARAS D'ERABLE"));
		// no rancher
		horse.setJockey(jockey("T. COMPAS"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 5 - CANGNAM STYLE
	 * HorseID - CANGNAM STYLE
	 */
	public static HorseID builderHorse_R1_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CANGNAM STYLE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("DEFI D'AUNOU");
		horseID.setMother("GENTRY D'OMBREE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 5 - CANGNAM STYLE
	 */

	public static Horse builderHorse_R1_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(747000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(495000.0);
		horse.setPlaceProfit(252000.0);
		horse.setYearProfit(747000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ANDERS LINDQVIST"));
		horse.setOwner(owner("ANDERS LINDQVIST"));
		// no rancher
		horse.setJockey(jockey("J. BERGGREN"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 6 - CORSAIRE DU ROI
	 * HorseID - CORSAIRE DU ROI
	 */
	public static HorseID builderHorse_R1_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CORSAIRE DU ROI");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("REPEAT LOVE");
		horseID.setMother("PEDRA DE TOURELLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 6 - CORSAIRE DU ROI
	 */

	public static Horse builderHorse_R1_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(823000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(823000.0);
		horse.setYearProfit(823000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. HAMEL"));
		horse.setOwner(owner("ECURIE MARECHAL"));
		// no rancher
		horse.setJockey(jockey("J. KAUFFMANN"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 7 - CLEF D'OR JENILOU
	 * HorseID - CLEF D'OR JENILOU
	 */
	public static HorseID builderHorse_R1_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CLEF D'OR JENILOU");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("RANCHO GEDE");
		horseID.setMother("OLIVIA DE ROZOY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 7 - CLEF D'OR JENILOU
	 */

	public static Horse builderHorse_R1_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(858000.0);
		horse.setPreviousYearProfit(858000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(858000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. ROBIN"));
		horse.setOwner(owner("B. ROBIN"));
		// no rancher
		horse.setJockey(jockey("E. RAFFIN"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 8 - CRUELLA
	 * HorseID - CRUELLA
	 */
	public static HorseID builderHorse_R1_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CRUELLA");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("REDEO JOSSELYN");
		horseID.setMother("MAMELIE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 8 - CRUELLA
	 */

	public static Horse builderHorse_R1_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(903000.0);
		horse.setPreviousYearProfit(275000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(903000.0);
		horse.setYearProfit(628000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("H. SIONNEAU"));
		horse.setOwner(owner("ECURIE HERVE SIONNEAU"));
		// no rancher
		horse.setJockey(jockey("H. SIONNEAU"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 9 - CALL THE BEST
	 * HorseID - CALL THE BEST
	 */
	public static HorseID builderHorse_R1_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CALL THE BEST");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("REPEAT LOVE");
		horseID.setMother("LUNA CLASS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 9 - CALL THE BEST
	 */

	public static Horse builderHorse_R1_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(936000.0);
		horse.setPreviousYearProfit(169000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(936000.0);
		horse.setYearProfit(767000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PH. MOULIN"));
		horse.setOwner(owner("ECURIE VICTORIA DREAMS"));
		// no rancher
		horse.setJockey(jockey("ETIENNE DUBOIS"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 10 - CETTE LADY
	 * HorseID - CETTE LADY
	 */
	public static HorseID builderHorse_R1_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CETTE LADY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KOOL DU CAUX");
		horseID.setMother("IMPERIALE LADY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 10 - CETTE LADY
	 */

	public static Horse builderHorse_R1_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(942000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(540000.0);
		horse.setPlaceProfit(402000.0);
		horse.setYearProfit(942000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. DAUVERNE"));
		horse.setOwner(owner("D. DAUVERNE"));
		// no rancher
		horse.setJockey(jockey("D. DAUVERNE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 11 - CAPUCINE DES PRES
	 * HorseID - CAPUCINE DES PRES
	 */
	public static HorseID builderHorse_R1_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CAPUCINE DES PRES");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OAKWOOD DU CLOSET");
		horseID.setMother("RIMA DES PRES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 11 - CAPUCINE DES PRES
	 */

	public static Horse builderHorse_R1_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(979000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(585000.0);
		horse.setPlaceProfit(394000.0);
		horse.setYearProfit(979000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ARNAUD DESMOTTES"));
		horse.setOwner(owner("ARNAUD DESMOTTES"));
		// no rancher
		horse.setJockey(jockey("ARNAUD DESMOTTES"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 12 - COMTESSE DU GITE
	 * HorseID - COMTESSE DU GITE
	 */
	public static HorseID builderHorse_R1_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("COMTESSE DU GITE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("GANYMEDE");
		horseID.setMother("GISELLA DU GITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 12 - COMTESSE DU GITE
	 */

	public static Horse builderHorse_R1_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1012000.0);
		horse.setPreviousYearProfit(660000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(1012000.0);
		horse.setYearProfit(352000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. LELIEVRE"));
		horse.setOwner(owner("G. LELIEVRE"));
		// no rancher
		horse.setJockey(jockey("D. BONNE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 13 - CHOCHO DE GUEZ
	 * HorseID - CHOCHO DE GUEZ
	 */
	public static HorseID builderHorse_R1_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CHOCHO DE GUEZ");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JASMIN DE FLORE");
		horseID.setMother("OSSARIE JOLIE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 13 - CHOCHO DE GUEZ
	 */

	public static Horse builderHorse_R1_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		horse.setStable("A");
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1034000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(810000.0);
		horse.setPlaceProfit(224000.0);
		horse.setYearProfit(1034000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE VAUTORS"));
		// no rancher
		horse.setJockey(jockey("J.M. BAZIRE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 14 - CERISE D'AIMPE
	 * HorseID - CERISE D'AIMPE
	 */
	public static HorseID builderHorse_R1_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CERISE D'AIMPE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KENOR DE COSSE");
		horseID.setMother("SIGNORELLA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 14 - CERISE D'AIMPE
	 */

	public static Horse builderHorse_R1_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1035000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(990000.0);
		horse.setPlaceProfit(45000.0);
		horse.setYearProfit(1035000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. PAUMARD"));
		horse.setOwner(owner("S. PAUMARD"));
		// no rancher
		horse.setJockey(jockey("S. PAUMARD"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 15 - CESARIO
	 * HorseID - CESARIO
	 */
	public static HorseID builderHorse_R1_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CESARIO");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BLUE DREAM");
		horseID.setMother("MELODIE DE FRANCE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 15 - CESARIO
	 */

	public static Horse builderHorse_R1_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H15_ID());
		horse.setNumber(15);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1043000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(675000.0);
		horse.setPlaceProfit(368000.0);
		horse.setYearProfit(1043000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P.Y. LEMOINE"));
		horse.setOwner(owner("ECURIE DU MONT"));
		// no rancher
		horse.setJockey(jockey("B. PITON"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 16 - CANNISSE DE GUEZ
	 * HorseID - CANNISSE DE GUEZ
	 */
	public static HorseID builderHorse_R1_H16_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CANNISSE DE GUEZ");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("JASMIN DE FLORE");
		horseID.setMother("QUAVRINIS DE GUEZ");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 16 - CANNISSE DE GUEZ
	 */

	public static Horse builderHorse_R1_H16(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R1_H16_ID());
		horse.setNumber(16);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		horse.setStable("A");
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1045000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(765000.0);
		horse.setPlaceProfit(280000.0);
		horse.setYearProfit(1045000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE VAUTORS"));
		// no rancher
		horse.setJockey(jockey("L.D. BOURGEAIS"));

		return horse;

	}

	/*
	 * Race 1
	 * Odds 1 - 13/08/2015 12:30:55 +0200
	 */

	public static Odds builderOdds_R1_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:30:55 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 82.1));
		simples.add(simple(odds, "2", 68.0));
		simples.add(simple(odds, "3", 16.5));
		simples.add(simple(odds, "4", 42.3));
		simples.add(simple(odds, "5", 29.8));
		simples.add(simple(odds, "6", 6.4));
		simples.add(simple(odds, "7", 35.1));
		simples.add(simple(odds, "8", 18.7));
		simples.add(simple(odds, "9", 7.8));
		simples.add(simple(odds, "10", 53.2));
		simples.add(simple(odds, "11", 12.9));
		simples.add(simple(odds, "12", 44.3));
		simples.add(simple(odds, "13", 2.2));
		simples.add(simple(odds, "14", 35.7));
		simples.add(simple(odds, "15", 26.4));
		simples.add(simple(odds, "16", 17.8));
		simples.add(simple(odds, "A", 1.8));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 1
	 * Odds 2 - 13/08/2015 12:33:29 +0200
	 */

	public static Odds builderOdds_R1_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:33:29 +0200"));
		odds.setTotal(77853.65);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 87.0));
		simples.add(simple(odds, "2", 72.3));
		simples.add(simple(odds, "3", 16.5));
		simples.add(simple(odds, "4", 43.0));
		simples.add(simple(odds, "5", 31.8));
		simples.add(simple(odds, "6", 5.5));
		simples.add(simple(odds, "7", 36.2));
		simples.add(simple(odds, "8", 19.2));
		simples.add(simple(odds, "9", 7.6));
		simples.add(simple(odds, "10", 54.6));
		simples.add(simple(odds, "11", 11.8));
		simples.add(simple(odds, "12", 45.8));
		simples.add(simple(odds, "13", 2.3));
		simples.add(simple(odds, "14", 36.8));
		simples.add(simple(odds, "15", 27.2));
		simples.add(simple(odds, "16", 23.1));
		simples.add(simple(odds, "A", 1.9));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 2 - PRIX LOUIS CHRETIEN
	 */

	public static Race builderRace_R2(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(2);
		race.setName("PRIX LOUIS CHRETIEN");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 13:00:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(20000.0);
		race.setDiscipline(Discipline.TROT_MONTE);
		race.setTypes(EnumSet.noneOf(Type.class));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R2_H1(race));
		horses.add(builderHorse_R2_H2(race));
		horses.add(builderHorse_R2_H3(race));
		horses.add(builderHorse_R2_H4(race));
		horses.add(builderHorse_R2_H5(race));
		horses.add(builderHorse_R2_H6(race));
		horses.add(builderHorse_R2_H7(race));
		horses.add(builderHorse_R2_H8(race));
		horses.add(builderHorse_R2_H9(race));
		horses.add(builderHorse_R2_H10(race));
		horses.add(builderHorse_R2_H11(race));
		horses.add(builderHorse_R2_H12(race));
		horses.add(builderHorse_R2_H13(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R2_O1(race));
		oddsSet.add(builderOdds_R2_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 10, 216620));
		places.add(place(race, 2, 9, 216660));
		places.add(place(race, 3, 2, 216930));
		places.add(place(race, 4, 7, 217190));
		places.add(place(race, 5, 1, 219160));
		places.add(place(race, 6, 13, 219240));
		places.add(place(race, 7, 8, 219710));
		places.add(place(race, 8, 12, 222380));
		places.add(place(race, 9, 4, 223620));
		places.add(place(race, 10, 3, 224070));
		places.add(place(race, 11, 11, 237950));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("5 6");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 12.2, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.2, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.6, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.3, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 63.4, "10 9"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 23.8, "10 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.7, "10 2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.1, "10 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.9, "9 2"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 47.3, "10 9 2"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "10 2"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "10 7"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "10 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "2 7"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "9 2"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 4.6, "9 7"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 76.5, "10 9 2 7"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 15.3, "10 9 2 7"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 5.1, "10 9 2 7"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 2
	 * Horse 1 - ASLY DE FLORANGE
	 * HorseID - ASLY DE FLORANGE
	 */
	public static HorseID builderHorse_R2_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ASLY DE FLORANGE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KUADRO WILD");
		horseID.setMother("EASY PERRINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 1 - ASLY DE FLORANGE
	 */

	public static Horse builderHorse_R2_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(4928000.0);
		horse.setPreviousYearProfit(1646000.0);
		horse.setVictoryProfit(1305000.0);
		horse.setPlaceProfit(3623000.0);
		horse.setYearProfit(1963000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MLLE M. GROLIER"));
		horse.setOwner(owner("MLLE M. GROLIER"));
		// no rancher
		horse.setJockey(jockey("MLLE M. GROLIER"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 2 - ALROMICK VERDERIE
	 * HorseID - ALROMICK VERDERIE
	 */
	public static HorseID builderHorse_R2_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ALROMICK VERDERIE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("INSTALL");
		horseID.setMother("NUANCE VERDERIE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 2 - ALROMICK VERDERIE
	 */

	public static Horse builderHorse_R2_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(5156000.0);
		horse.setPreviousYearProfit(3226000.0);
		horse.setVictoryProfit(3780000.0);
		horse.setPlaceProfit(1376000.0);
		horse.setYearProfit(1930000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. ROBLOT"));
		horse.setOwner(owner("Y. ROBLOT"));
		// no rancher
		horse.setJockey(jockey("F. NIVARD"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 3 - ARIA DEL GREEN
	 * HorseID - ARIA DEL GREEN
	 */
	public static HorseID builderHorse_R2_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ARIA DEL GREEN");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PRINCE D'ESPACE");
		horseID.setMother("PINTA QUICK");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 3 - ARIA DEL GREEN
	 */

	public static Horse builderHorse_R2_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(5648000.0);
		horse.setPreviousYearProfit(3600000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(5648000.0);
		horse.setYearProfit(88000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. DOUSSET"));
		horse.setOwner(owner("D. BARBIN"));
		// no rancher
		horse.setJockey(jockey("F. PRIOUL"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 4 - VANTAGE
	 * HorseID - VANTAGE
	 */
	public static HorseID builderHorse_R2_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VANTAGE");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GAZOUILLIS");
		horseID.setMother("NINA DE MONTI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 4 - VANTAGE
	 */

	public static Horse builderHorse_R2_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(5685000.0);
		horse.setPreviousYearProfit(1266000.0);
		horse.setVictoryProfit(2545000.0);
		horse.setPlaceProfit(3140000.0);
		horse.setYearProfit(44000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("L.CL. ABRIVARD"));
		horse.setOwner(owner("J. COTTEL"));
		// no rancher
		horse.setJockey(jockey("LEO ABRIVARD"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 5 - ARTISTE VIVANCIERE
	 * HorseID - ARTISTE VIVANCIERE
	 */
	public static HorseID builderHorse_R2_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ARTISTE VIVANCIERE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ONYX DU GOUTIER");
		horseID.setMother("GIGA QUERY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 5 - ARTISTE VIVANCIERE
	 */

	public static Horse builderHorse_R2_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6039000.0);
		horse.setPreviousYearProfit(3539000.0);
		horse.setVictoryProfit(1440000.0);
		horse.setPlaceProfit(4599000.0);
		horse.setYearProfit(929000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. ABRIVARD"));
		horse.setOwner(owner("MLLE CL. DESMONTILS"));
		// no rancher
		horse.setJockey(jockey("M. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 6 - VOLADOR D'IRAI
	 * HorseID - VOLADOR D'IRAI
	 */
	public static HorseID builderHorse_R2_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VOLADOR D'IRAI");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("OTELLO PIERJI");
		horseID.setMother("ARIA DE BELLOUET");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 6 - VOLADOR D'IRAI
	 */

	public static Horse builderHorse_R2_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6042000.0);
		horse.setPreviousYearProfit(2535000.0);
		horse.setVictoryProfit(3275000.0);
		horse.setPlaceProfit(2767000.0);
		horse.setYearProfit(735000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. HERLEM"));
		horse.setOwner(owner("L.B. MARTIN"));
		// no rancher
		horse.setJockey(jockey("A. DABOUIS"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 7 - VICTORY COGLAIS
	 * HorseID - VICTORY COGLAIS
	 */
	public static HorseID builderHorse_R2_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VICTORY COGLAIS");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("LOVE YOU");
		horseID.setMother("KISS ME DU COGLAIS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 7 - VICTORY COGLAIS
	 */

	public static Horse builderHorse_R2_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6100000.0);
		horse.setPreviousYearProfit(1520000.0);
		horse.setVictoryProfit(2830000.0);
		horse.setPlaceProfit(3270000.0);
		horse.setYearProfit(436000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.P. THOMAIN"));
		horse.setOwner(owner("MME CL. MORAZIN"));
		// no rancher
		horse.setJockey(jockey("D. THOMAIN"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 8 - VERITABLE PRIOR
	 * HorseID - VERITABLE PRIOR
	 */
	public static HorseID builderHorse_R2_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VERITABLE PRIOR");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GAI BRILLANT");
		horseID.setMother("LINOTTE PRIOR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 8 - VERITABLE PRIOR
	 */

	public static Horse builderHorse_R2_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6189000.0);
		horse.setPreviousYearProfit(1437000.0);
		horse.setVictoryProfit(1845000.0);
		horse.setPlaceProfit(4344000.0);
		horse.setYearProfit(1942000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. DESMARRES"));
		horse.setOwner(owner("A. DESMARRES"));
		// no rancher
		horse.setJockey(jockey("AURELIEN DESMARRES"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 9 - VIGO DU GUILLAUMAS
	 * HorseID - VIGO DU GUILLAUMAS
	 */
	public static HorseID builderHorse_R2_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIGO DU GUILLAUMAS");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("NEUTRON DU CEBE");
		horseID.setMother("HIJA DU GUILLAUMAS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN_BRULE);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 9 - VIGO DU GUILLAUMAS
	 */

	public static Horse builderHorse_R2_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6201000.0);
		horse.setPreviousYearProfit(4822000.0);
		horse.setVictoryProfit(3600000.0);
		horse.setPlaceProfit(2601000.0);
		horse.setYearProfit(1015000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. MARIE"));
		horse.setOwner(owner("JEREMY LEVY"));
		// no rancher
		horse.setJockey(jockey("A. LAMY"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 10 - ANGEL PERRINE
	 * HorseID - ANGEL PERRINE
	 */
	public static HorseID builderHorse_R2_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ANGEL PERRINE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BLUE DREAM");
		horseID.setMother("KINA PERRINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ROUAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 10 - ANGEL PERRINE
	 */

	public static Horse builderHorse_R2_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6208000.0);
		horse.setPreviousYearProfit(2461000.0);
		horse.setVictoryProfit(3330000.0);
		horse.setPlaceProfit(2878000.0);
		horse.setYearProfit(3747000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.F. MARY"));
		horse.setOwner(owner("J.F. MARY"));
		// no rancher
		horse.setJockey(jockey("P.EDOUARD MARY"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 11 - ALTO PIERJI
	 * HorseID - ALTO PIERJI
	 */
	public static HorseID builderHorse_R2_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ALTO PIERJI");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("INTAILLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 11 - ALTO PIERJI
	 */

	public static Horse builderHorse_R2_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6248000.0);
		horse.setPreviousYearProfit(135000.0);
		horse.setVictoryProfit(1650000.0);
		horse.setPlaceProfit(4598000.0);
		horse.setYearProfit(534000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PH. BEUREL"));
		horse.setOwner(owner("PH. BEUREL"));
		// no rancher
		horse.setJockey(jockey("A. WIELS"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 12 - AU BORD
	 * HorseID - AU BORD
	 */
	public static HorseID builderHorse_R2_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AU BORD");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MAGNIFICENT RODNEY");
		horseID.setMother("LADY JANE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 12 - AU BORD
	 */

	public static Horse builderHorse_R2_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6359000.0);
		horse.setPreviousYearProfit(4110000.0);
		horse.setVictoryProfit(2745000.0);
		horse.setPlaceProfit(3614000.0);
		horse.setYearProfit(1675000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P. PLOQUIN"));
		horse.setOwner(owner("ECURIE SYLVAIN ROUBAUD"));
		// no rancher
		horse.setJockey(jockey("E. RAFFIN"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 13 - ATOUT MAJEUR
	 * HorseID - ATOUT MAJEUR
	 */
	public static HorseID builderHorse_R2_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ATOUT MAJEUR");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("OFFSHORE DREAM");
		horseID.setMother("QUICK SCARLET");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 13 - ATOUT MAJEUR
	 */

	public static Horse builderHorse_R2_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(6473000.0);
		horse.setPreviousYearProfit(4271000.0);
		horse.setVictoryProfit(900000.0);
		horse.setPlaceProfit(5573000.0);
		horse.setYearProfit(981000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH.A. MARY"));
		horse.setOwner(owner("ECURIE CH. A. MARY"));
		// no rancher
		horse.setJockey(jockey("MLLE ALEXIANE LEPAGE"));

		return horse;

	}

	/*
	 * Race 2
	 * Odds 1 - 13/08/2015 12:30:58 +0200
	 */

	public static Odds builderOdds_R2_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:30:58 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 22.1));
		simples.add(simple(odds, "2", 6.1));
		simples.add(simple(odds, "3", 22.6));
		simples.add(simple(odds, "4", 40.3));
		simples.add(simple(odds, "5", 3.8));
		simples.add(simple(odds, "6", 72.7));
		simples.add(simple(odds, "7", 11.1));
		simples.add(simple(odds, "8", 28.1));
		simples.add(simple(odds, "9", 7.2));
		simples.add(simple(odds, "10", 13.4));
		simples.add(simple(odds, "11", 20.5));
		simples.add(simple(odds, "12", 5.4));
		simples.add(simple(odds, "13", 14.7));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 2
	 * Odds 2 - 13/08/2015 13:01:49 +0200
	 */

	public static Odds builderOdds_R2_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 13:01:49 +0200"));
		odds.setTotal(98030.03);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 35.0));
		simples.add(simple(odds, "2", 7.2));
		simples.add(simple(odds, "3", 62.2));
		simples.add(simple(odds, "4", 79.5));
		simples.add(simple(odds, "5", 2.5));
		simples.add(simple(odds, "6", 93.9));
		simples.add(simple(odds, "7", 17.0));
		simples.add(simple(odds, "8", 49.8));
		simples.add(simple(odds, "9", 6.3));
		simples.add(simple(odds, "10", 12.2));
		simples.add(simple(odds, "11", 40.6));
		simples.add(simple(odds, "12", 5.2));
		simples.add(simple(odds, "13", 19.7));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3 - PRIX DU CONSEIL REGIONAL DES PAYS DE LOIRE
	 */

	public static Race builderRace_R3(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(3);
		race.setName("PRIX DU CONSEIL REGIONAL DES PAYS DE LOIRE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 13:30:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(19000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.NATIONALE));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R3_H1(race));
		horses.add(builderHorse_R3_H2(race));
		horses.add(builderHorse_R3_H3(race));
		horses.add(builderHorse_R3_H4(race));
		horses.add(builderHorse_R3_H5(race));
		horses.add(builderHorse_R3_H6(race));
		horses.add(builderHorse_R3_H7(race));
		horses.add(builderHorse_R3_H8(race));
		horses.add(builderHorse_R3_H9(race));
		horses.add(builderHorse_R3_H10(race));
		horses.add(builderHorse_R3_H11(race));
		horses.add(builderHorse_R3_H12(race));
		horses.add(builderHorse_R3_H13(race));
		horses.add(builderHorse_R3_H14(race));
		horses.add(builderHorse_R3_H15(race));
		horses.add(builderHorse_R3_H16(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R3_O1(race));
		oddsSet.add(builderOdds_R3_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 4, 215890));
		places.add(place(race, 2, 8, 217090));
		places.add(place(race, 3, 15, 217320));
		places.add(place(race, 4, 9, 217670));
		places.add(place(race, 5, 14, 217720));
		places.add(place(race, 6, 1, 218530));
		places.add(place(race, 7, 5, 218730));
		places.add(place(race, 8, 11, 218790));
		places.add(place(race, 9, 10, 219070));
		places.add(place(race, 10, 13, 219260));
		places.add(place(race, 11, 6, 221210));
		places.add(place(race, 12, 7, 226790));
		places.add(place(race, 13, 3, 227690));
		places.add(place(race, 14, 2, 228720));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("12 16");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 7.7, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "15"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.6, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "8"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 56.6, "4 8"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 43.3, "4 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 26.6, "4 15"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 21.4, "4 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 20.3, "8 15"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 163.8, "4 8 15"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "15 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "4 15"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "4 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "4 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "8 15"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 27.7, "8 9"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 2541.0, "4 8 15 9"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 508.2, "4 8 15 9"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 169.4, "4 8 15 9"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 72.6, "4 8 15 9"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 3
	 * Horse 1 - BRABANT DE BULIERE
	 * HorseID - BRABANT DE BULIERE
	 */
	public static HorseID builderHorse_R3_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BRABANT DE BULIERE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KENYA DU PONT");
		horseID.setMother("MISS DE FEUGERES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 1 - BRABANT DE BULIERE
	 */

	public static Horse builderHorse_R3_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2166000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1215000.0);
		horse.setPlaceProfit(951000.0);
		horse.setYearProfit(2166000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. BOISNARD"));
		horse.setOwner(owner("ECURIE CHRISTIAN BOISNARD"));
		// no rancher
		horse.setJockey(jockey("CH. BOISNARD"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 2 - BELCANTO GENTIL
	 * HorseID - BELCANTO GENTIL
	 */
	public static HorseID builderHorse_R3_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BELCANTO GENTIL");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KIWI");
		horseID.setMother("POLYANDRY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 2 - BELCANTO GENTIL
	 */

	public static Horse builderHorse_R3_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2175000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1305000.0);
		horse.setPlaceProfit(870000.0);
		horse.setYearProfit(2175000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P.Y. VERVA"));
		horse.setOwner(owner("ECURIE EQUINOXX"));
		// no rancher
		horse.setJockey(jockey("P.Y. VERVA"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 3 - BEAU BIJOU
	 * HorseID - BEAU BIJOU
	 */
	public static HorseID builderHorse_R3_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BEAU BIJOU");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("VIVALDI DE CHENU");
		horseID.setMother("INTRIGANTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 3 - BEAU BIJOU
	 */

	public static Horse builderHorse_R3_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2180000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(585000.0);
		horse.setPlaceProfit(1595000.0);
		horse.setYearProfit(2180000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. CHALON"));
		horse.setOwner(owner("CH. CHALON"));
		// no rancher
		horse.setJockey(jockey("CH. CHALON"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 4 - BOLERO BLEU
	 * HorseID - BOLERO BLEU
	 */
	public static HorseID builderHorse_R3_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOLERO BLEU");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JAG DE BELLOUET");
		horseID.setMother("LAETITIA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 4 - BOLERO BLEU
	 */

	public static Horse builderHorse_R3_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2225000.0);
		horse.setPreviousYearProfit(695000.0);
		horse.setVictoryProfit(2160000.0);
		horse.setPlaceProfit(65000.0);
		horse.setYearProfit(1530000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. ERNAULT"));
		horse.setOwner(owner("M. GALLIER"));
		// no rancher
		horse.setJockey(jockey("S. ERNAULT"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 5 - BOB DES CARREAUX
	 * HorseID - BOB DES CARREAUX
	 */
	public static HorseID builderHorse_R3_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOB DES CARREAUX");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ROCKLYN");
		horseID.setMother("QUETE DES CARREAUX");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 5 - BOB DES CARREAUX
	 */

	public static Horse builderHorse_R3_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2258000.0);
		horse.setPreviousYearProfit(1058000.0);
		horse.setVictoryProfit(540000.0);
		horse.setPlaceProfit(1718000.0);
		horse.setYearProfit(1200000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MLLE E. DESSARTRE"));
		horse.setOwner(owner("A. DESSARTRE"));
		// no rancher
		horse.setJockey(jockey("M. MOTTIER"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 6 - BAZAR DE L'EPAUD
	 * HorseID - BAZAR DE L'EPAUD
	 */
	public static HorseID builderHorse_R3_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BAZAR DE L'EPAUD");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUITUS DU MEXIQUE");
		horseID.setMother("OLIA DU BELLAY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 6 - BAZAR DE L'EPAUD
	 */

	public static Horse builderHorse_R3_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2295000.0);
		horse.setPreviousYearProfit(1755000.0);
		horse.setVictoryProfit(2295000.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(540000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. DOLLION"));
		horse.setOwner(owner("M. DOLLION"));
		// no rancher
		horse.setJockey(jockey("M. DOLLION"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 7 - BERNARDO DU BOULAY
	 * HorseID - BERNARDO DU BOULAY
	 */
	public static HorseID builderHorse_R3_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BERNARDO DU BOULAY");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUALYPSO JIEL");
		horseID.setMother("OPHELIA DE BREVOL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 7 - BERNARDO DU BOULAY
	 */

	public static Horse builderHorse_R3_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2319000.0);
		horse.setPreviousYearProfit(1493000.0);
		horse.setVictoryProfit(1170000.0);
		horse.setPlaceProfit(1149000.0);
		horse.setYearProfit(826000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("LOIC GROUSSARD"));
		horse.setOwner(owner("CH. THOISON"));
		// no rancher
		horse.setJockey(jockey("LOIC GROUSSARD"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 8 - BORIS DE KARA
	 * HorseID - BORIS DE KARA
	 */
	public static HorseID builderHorse_R3_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BORIS DE KARA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KENOR DE COSSE");
		horseID.setMother("PETITE CARA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 8 - BORIS DE KARA
	 */

	public static Horse builderHorse_R3_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2363000.0);
		horse.setPreviousYearProfit(1720000.0);
		horse.setVictoryProfit(1440000.0);
		horse.setPlaceProfit(923000.0);
		horse.setYearProfit(643000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ARNAUD DESMOTTES"));
		horse.setOwner(owner("ARNAUD DESMOTTES"));
		// no rancher
		horse.setJockey(jockey("ARNAUD DESMOTTES"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 9 - BARBIBUL
	 * HorseID - BARBIBUL
	 */
	public static HorseID builderHorse_R3_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BARBIBUL");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("OLITRO");
		horseID.setMother("OREZZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 9 - BARBIBUL
	 */

	public static Horse builderHorse_R3_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2366000.0);
		horse.setPreviousYearProfit(1702000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(2366000.0);
		horse.setYearProfit(408000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. GAUTIER"));
		horse.setOwner(owner("Y. AIRIAUD"));
		// no rancher
		horse.setJockey(jockey("A. WIELS"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 10 - BOSTON PARIS
	 * HorseID - BOSTON PARIS
	 */
	public static HorseID builderHorse_R3_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOSTON PARIS");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("SCIPION DU GOUTIER");
		horseID.setMother("MANIKA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 10 - BOSTON PARIS
	 */

	public static Horse builderHorse_R3_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2473000.0);
		horse.setPreviousYearProfit(446000.0);
		horse.setVictoryProfit(855000.0);
		horse.setPlaceProfit(1618000.0);
		horse.setYearProfit(2027000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. DAUVERNE"));
		horse.setOwner(owner("M.F. BERNARD"));
		// no rancher
		horse.setJockey(jockey("D. DAUVERNE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 11 - BANCO RYLD
	 * HorseID - BANCO RYLD
	 */
	public static HorseID builderHorse_R3_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BANCO RYLD");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("PAGALOR");
		horseID.setMother("MINETTE FLORETTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 11 - BANCO RYLD
	 */

	public static Horse builderHorse_R3_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2535000.0);
		horse.setPreviousYearProfit(519000.0);
		horse.setVictoryProfit(585000.0);
		horse.setPlaceProfit(1950000.0);
		horse.setYearProfit(2016000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. ROBLOT"));
		horse.setOwner(owner("Y. ROBLOT"));
		// no rancher
		horse.setJockey(jockey("Y. ROBLOT"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 12 - BARRY DE LA CAVEE
	 * HorseID - BARRY DE LA CAVEE
	 */
	public static HorseID builderHorse_R3_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BARRY DE LA CAVEE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("OCEANO NOX");
		horseID.setMother("PAOLITIA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 12 - BARRY DE LA CAVEE
	 */

	public static Horse builderHorse_R3_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2537000.0);
		horse.setPreviousYearProfit(1269000.0);
		horse.setVictoryProfit(540000.0);
		horse.setPlaceProfit(1997000.0);
		horse.setYearProfit(1268000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. BAUDE"));
		horse.setOwner(owner("S. BAUDE"));
		// no rancher
		horse.setJockey(jockey("S. BAUDE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 13 - BELLO NICO
	 * HorseID - BELLO NICO
	 */
	public static HorseID builderHorse_R3_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BELLO NICO");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KOREAN");
		horseID.setMother("NICOTERA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 13 - BELLO NICO
	 */

	public static Horse builderHorse_R3_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2538000.0);
		horse.setPreviousYearProfit(161000.0);
		horse.setVictoryProfit(1620000.0);
		horse.setPlaceProfit(918000.0);
		horse.setYearProfit(2377000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JULIEN RAFFESTIN"));
		horse.setOwner(owner("S. DALMASSE"));
		// no rancher
		horse.setJockey(jockey("JULIEN RAFFESTIN"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 14 - BRILLANT DE JIEL
	 * HorseID - BRILLANT DE JIEL
	 */
	public static HorseID builderHorse_R3_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BRILLANT DE JIEL");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DIAMANT GEDE");
		horseID.setMother("ROXANE JIEL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 14 - BRILLANT DE JIEL
	 */

	public static Horse builderHorse_R3_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2549000.0);
		horse.setPreviousYearProfit(230000.0);
		horse.setVictoryProfit(675000.0);
		horse.setPlaceProfit(1874000.0);
		horse.setYearProfit(1608000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. FRIBAULT"));
		horse.setOwner(owner("ECURIE MATHIEU FRIBAULT"));
		// no rancher
		horse.setJockey(jockey("M. FRIBAULT"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 15 - BALTHAZAR DU GITE
	 * HorseID - BALTHAZAR DU GITE
	 */
	public static HorseID builderHorse_R3_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BALTHAZAR DU GITE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MON PREMIER CEHERE");
		horseID.setMother("MISS DU GITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 15 - BALTHAZAR DU GITE
	 */

	public static Horse builderHorse_R3_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H15_ID());
		horse.setNumber(15);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2583000.0);
		horse.setPreviousYearProfit(903000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(2583000.0);
		horse.setYearProfit(1330000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. LELIEVRE"));
		horse.setOwner(owner("G. LELIEVRE"));
		// no rancher
		horse.setJockey(jockey("R. BARETTE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 16 - BE GOOD
	 * HorseID - BE GOOD
	 */
	public static HorseID builderHorse_R3_H16_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BE GOOD");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HALIMEDE");
		horseID.setMother("NIEMANA OLDESON");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 16 - BE GOOD
	 */

	public static Horse builderHorse_R3_H16(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H16_ID());
		horse.setNumber(16);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2594000.0);
		horse.setPreviousYearProfit(594000.0);
		horse.setVictoryProfit(1530000.0);
		horse.setPlaceProfit(1064000.0);
		horse.setYearProfit(1990000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. MICHEL"));
		horse.setOwner(owner("S. MICHEL"));
		// no rancher
		horse.setJockey(jockey("L. LAUDREN"));

		return horse;

	}

	/*
	 * Race 3
	 * Odds 1 - 13/08/2015 12:31:01 +0200
	 */

	public static Odds builderOdds_R3_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:31:01 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 20.6));
		simples.add(simple(odds, "2", 9.5));
		simples.add(simple(odds, "3", 19.2));
		simples.add(simple(odds, "4", 11.7));
		simples.add(simple(odds, "5", 4.2));
		simples.add(simple(odds, "6", 5.6));
		simples.add(simple(odds, "7", 40.7));
		simples.add(simple(odds, "8", 13.9));
		simples.add(simple(odds, "9", 37.1));
		simples.add(simple(odds, "10", 24.9));
		simples.add(simple(odds, "11", 17.0));
		simples.add(simple(odds, "12", 12.9));
		simples.add(simple(odds, "13", 35.1));
		simples.add(simple(odds, "14", 17.1));
		simples.add(simple(odds, "15", 13.8));
		simples.add(simple(odds, "16", 37.5));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3
	 * Odds 2 - 13/08/2015 13:31:46 +0200
	 */

	public static Odds builderOdds_R3_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 13:31:46 +0200"));
		odds.setTotal(98579.5);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 31.3));
		simples.add(simple(odds, "2", 5.6));
		simples.add(simple(odds, "3", 22.4));
		simples.add(simple(odds, "4", 7.7));
		simples.add(simple(odds, "5", 5.5));
		simples.add(simple(odds, "6", 4.7));
		simples.add(simple(odds, "7", 84.6));
		simples.add(simple(odds, "8", 12.0));
		simples.add(simple(odds, "9", 60.2));
		simples.add(simple(odds, "10", 48.8));
		simples.add(simple(odds, "11", 21.6));
		simples.add(simple(odds, "12", 12.3));
		simples.add(simple(odds, "13", 50.9));
		simples.add(simple(odds, "14", 19.4));
		simples.add(simple(odds, "15", 14.3));
		simples.add(simple(odds, "16", 75.0));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4 - GRAND PRIX DE LA VILLE DE MESLAY DU MAINE
	 */

	public static Race builderRace_R4(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(4);
		race.setName("GRAND PRIX DE LA VILLE DE MESLAY DU MAINE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 14:07:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(28000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.noneOf(Type.class));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R4_H1(race));
		horses.add(builderHorse_R4_H2(race));
		horses.add(builderHorse_R4_H3(race));
		horses.add(builderHorse_R4_H4(race));
		horses.add(builderHorse_R4_H5(race));
		horses.add(builderHorse_R4_H6(race));
		horses.add(builderHorse_R4_H7(race));
		horses.add(builderHorse_R4_H8(race));
		horses.add(builderHorse_R4_H9(race));
		horses.add(builderHorse_R4_H10(race));
		horses.add(builderHorse_R4_H11(race));
		horses.add(builderHorse_R4_H12(race));
		horses.add(builderHorse_R4_H13(race));
		horses.add(builderHorse_R4_H14(race));
		horses.add(builderHorse_R4_H15(race));
		horses.add(builderHorse_R4_H16(race));
		horses.add(builderHorse_R4_H17(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT, BetType.PICK5));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R4_O1(race));
		oddsSet.add(builderOdds_R4_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 15, 218910));
		places.add(place(race, 2, 9, 219000));
		places.add(place(race, 3, 11, 219860));
		places.add(place(race, 4, 5, 220140));
		places.add(place(race, 5, 10, 220240));
		places.add(place(race, 6, 3, 220630));
		places.add(place(race, 7, 6, 221480));
		places.add(place(race, 8, 17, 221530));
		places.add(place(race, 9, 4, 221620));
		places.add(place(race, 10, 8, 221700));
		places.add(place(race, 11, 16, 222020));
		places.add(place(race, 12, 13, 222290));
		places.add(place(race, 13, 12, 224110));
		places.add(place(race, 14, 1, 224230));
		places.add(place(race, 15, 14, 227130));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("2 7");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.7, "15"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "11"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "15"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 10.4, "15 9"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 7.6, "15 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.7, "15 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.8, "15 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.4, "9 11"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 11.2, "15 9 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "11 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "15 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "15 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "15 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "9 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.3, "9 5"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 21.0, "15 9 11 5"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 4.2, "15 9 11 5"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 1.4, "15 9 11 5"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 1.05, "15 9 11 5"));
		prices.add(price(race, BetType.PICK5, PriceName.DIRECT, 52.8, "15 9 11 5 10"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 4
	 * Horse 1 - UNO BAULOIS
	 * HorseID - UNO BAULOIS
	 */
	public static HorseID builderHorse_R4_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UNO BAULOIS");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MEAULNES DU CORTA");
		horseID.setMother("CLARKIA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 1 - UNO BAULOIS
	 */

	public static Horse builderHorse_R4_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(8899000.0);
		horse.setPreviousYearProfit(1461000.0);
		horse.setVictoryProfit(4610000.0);
		horse.setPlaceProfit(4289000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("H. SIONNEAU"));
		horse.setOwner(owner("ECURIE HERVE SIONNEAU"));
		// no rancher
		horse.setJockey(jockey("H. SIONNEAU"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 2 - ULTRA FISH
	 * HorseID - ULTRA FISH
	 */
	public static HorseID builderHorse_R4_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULTRA FISH");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BLUE DREAM");
		horseID.setMother("FLO DU CHENE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 2 - ULTRA FISH
	 */

	public static Horse builderHorse_R4_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(8991000.0);
		horse.setPreviousYearProfit(2827000.0);
		horse.setVictoryProfit(4310000.0);
		horse.setPlaceProfit(4681000.0);
		horse.setYearProfit(1252000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. DOLLION"));
		horse.setOwner(owner("D.CH. DELAUNAY"));
		// no rancher
		horse.setJockey(jockey("M. DOLLION"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 3 - VAMPIRE DU VIVIER
	 * HorseID - VAMPIRE DU VIVIER
	 */
	public static HorseID builderHorse_R4_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VAMPIRE DU VIVIER");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("NOTRE HAUFOR");
		horseID.setMother("ORIGNY DU VIVIER");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 3 - VAMPIRE DU VIVIER
	 */

	public static Horse builderHorse_R4_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(9204000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(5700000.0);
		horse.setPlaceProfit(3504000.0);
		horse.setYearProfit(1908000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. HERLEM"));
		horse.setOwner(owner("L.B. MARTIN"));
		// no rancher
		horse.setJockey(jockey("L. GUINOISEAU"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 4 - VIVALDI JET
	 * HorseID - VIVALDI JET
	 */
	public static HorseID builderHorse_R4_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIVALDI JET");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUATRE JUILLET");
		horseID.setMother("MAZARINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 4 - VIVALDI JET
	 */

	public static Horse builderHorse_R4_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(9232000.0);
		horse.setPreviousYearProfit(1999000.0);
		horse.setVictoryProfit(4885000.0);
		horse.setPlaceProfit(4347000.0);
		horse.setYearProfit(1572000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("TH. LE FLOCH"));
		horse.setOwner(owner("TH. LE FLOCH"));
		// no rancher
		horse.setJockey(jockey("TH. LE FLOCH"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 5 - VIATIK DU LOIR
	 * HorseID - VIATIK DU LOIR
	 */
	public static HorseID builderHorse_R4_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIATIK DU LOIR");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KAISY DREAM");
		horseID.setMother("INFANTE DU LOIR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 5 - VIATIK DU LOIR
	 */

	public static Horse builderHorse_R4_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(9365000.0);
		horse.setPreviousYearProfit(2797000.0);
		horse.setVictoryProfit(6460000.0);
		horse.setPlaceProfit(2905000.0);
		horse.setYearProfit(1492000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("M. MOUREAUX"));
		// no rancher
		horse.setJockey(jockey("J.M. BAZIRE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 6 - UDINE DE LA COUDRE
	 * HorseID - UDINE DE LA COUDRE
	 */
	public static HorseID builderHorse_R4_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UDINE DE LA COUDRE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("FORTUNA FANT");
		horseID.setMother("HAKIMORA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 6 - UDINE DE LA COUDRE
	 */

	public static Horse builderHorse_R4_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(9455000.0);
		horse.setPreviousYearProfit(991000.0);
		horse.setVictoryProfit(3585000.0);
		horse.setPlaceProfit(5870000.0);
		horse.setYearProfit(2959000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.L. FORGET"));
		horse.setOwner(owner("J.L. FORGET"));
		// no rancher
		horse.setJockey(jockey("F. GENCE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 7 - URBAN DE KA
	 * HorseID - URBAN DE KA
	 */
	public static HorseID builderHorse_R4_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("URBAN DE KA");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LOOK DE STAR");
		horseID.setMother("ETOILE DES RIOULTS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 7 - URBAN DE KA
	 */

	public static Horse builderHorse_R4_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(9506000.0);
		horse.setPreviousYearProfit(2115000.0);
		horse.setVictoryProfit(2035000.0);
		horse.setPlaceProfit(7471000.0);
		horse.setYearProfit(333000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P.Y. VERVA"));
		horse.setOwner(owner("R.H. CHARRIER"));
		// no rancher
		horse.setJockey(jockey("P.Y. VERVA"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 8 - TRIANON DE TAGOR
	 * HorseID - TRIANON DE TAGOR
	 */
	public static HorseID builderHorse_R4_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TRIANON DE TAGOR");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("IN LOVE WITH YOU");
		horseID.setMother("HARGOTE DE TAGOR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 8 - TRIANON DE TAGOR
	 */

	public static Horse builderHorse_R4_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.6166E7);
		horse.setPreviousYearProfit(1078000.0);
		horse.setVictoryProfit(5300000.0);
		horse.setPlaceProfit(1.0866E7);
		horse.setYearProfit(1680000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("F. REBECHE"));
		horse.setOwner(owner("JEAN JACQUES BESSE"));
		// no rancher
		horse.setJockey(jockey("MLLE D. BESSE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 9 - VULCAIN
	 * HorseID - VULCAIN
	 */
	public static HorseID builderHorse_R4_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VULCAIN");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DIAMANT GEDE");
		horseID.setMother("NOUVELLE PERLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 9 - VULCAIN
	 */

	public static Horse builderHorse_R4_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.6479E7);
		horse.setPreviousYearProfit(4168000.0);
		horse.setVictoryProfit(6065000.0);
		horse.setPlaceProfit(1.0414E7);
		horse.setYearProfit(3999000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("E. RUAULT"));
		horse.setOwner(owner("ECURIE COMTE P. DE MONTESSON"));
		// no rancher
		horse.setJockey(jockey("F. NIVARD"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 10 - VASCO DU GITE
	 * HorseID - VASCO DU GITE
	 */
	public static HorseID builderHorse_R4_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VASCO DU GITE");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LAETENTER DIEM");
		horseID.setMother("NAGEUSE DU GITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 10 - VASCO DU GITE
	 */

	public static Horse builderHorse_R4_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.6509E7);
		horse.setPreviousYearProfit(2474000.0);
		horse.setVictoryProfit(8365000.0);
		horse.setPlaceProfit(8144000.0);
		horse.setYearProfit(3070000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. LELIEVRE"));
		horse.setOwner(owner("G. LELIEVRE"));
		// no rancher
		horse.setJockey(jockey("D. BONNE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 11 - VENEZIA DE MAI
	 * HorseID - VENEZIA DE MAI
	 */
	public static HorseID builderHorse_R4_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VENEZIA DE MAI");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PRODIGIOUS");
		horseID.setMother("ISMIE DE TESSE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 11 - VENEZIA DE MAI
	 */

	public static Horse builderHorse_R4_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.6725E7);
		horse.setPreviousYearProfit(4755000.0);
		horse.setVictoryProfit(5960000.0);
		horse.setPlaceProfit(1.0765E7);
		horse.setYearProfit(6578000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. PAILLE"));
		horse.setOwner(owner("J. PAILLE"));
		// no rancher
		horse.setJockey(jockey("E. RAFFIN"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 12 - TETIAROA DE NAY
	 * HorseID - TETIAROA DE NAY
	 */
	public static HorseID builderHorse_R4_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TETIAROA DE NAY");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KLEYTON");
		horseID.setMother("MOOREA DE NAY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 12 - TETIAROA DE NAY
	 */

	public static Horse builderHorse_R4_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.747E7);
		horse.setPreviousYearProfit(4682000.0);
		horse.setVictoryProfit(6070000.0);
		horse.setPlaceProfit(1.14E7);
		horse.setYearProfit(2320000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("V. GOETZ"));
		horse.setOwner(owner("V. GOETZ"));
		// no rancher
		horse.setJockey(jockey("V. GOETZ"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 13 - TENOR DE MIENNAIS
	 * HorseID - TENOR DE MIENNAIS
	 */
	public static HorseID builderHorse_R4_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TENOR DE MIENNAIS");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("VIVALDI DE CHENU");
		horseID.setMother("FLORE DE MIENNAIS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 13 - TENOR DE MIENNAIS
	 */

	public static Horse builderHorse_R4_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.8224E7);
		horse.setPreviousYearProfit(2282000.0);
		horse.setVictoryProfit(1.381E7);
		horse.setPlaceProfit(4414000.0);
		horse.setYearProfit(175000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ARNAUD MORIN"));
		horse.setOwner(owner("CH. BOISSON"));
		// no rancher
		horse.setJockey(jockey("CH. BOISSON"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 14 - ROBINSON WIC
	 * HorseID - ROBINSON WIC
	 */
	public static HorseID builderHorse_R4_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ROBINSON WIC");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JASON DE VANDEL");
		horseID.setMother("JONQUIERE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 14 - ROBINSON WIC
	 */

	public static Horse builderHorse_R4_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.8293E7);
		horse.setPreviousYearProfit(373000.0);
		horse.setVictoryProfit(1.0815E7);
		horse.setPlaceProfit(7478000.0);
		horse.setYearProfit(3598000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. BOISNARD"));
		horse.setOwner(owner("ECURIE CHRISTIAN BOISNARD"));
		// no rancher
		horse.setJockey(jockey("CH. BOISNARD"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 15 - URASI DE LA VALLEE
	 * HorseID - URASI DE LA VALLEE
	 */
	public static HorseID builderHorse_R4_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("URASI DE LA VALLEE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ONYX DU GOUTIER");
		horseID.setMother("LA VALLEE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 15 - URASI DE LA VALLEE
	 */

	public static Horse builderHorse_R4_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H15_ID());
		horse.setNumber(15);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.8365E7);
		horse.setPreviousYearProfit(5759000.0);
		horse.setVictoryProfit(1.0575E7);
		horse.setPlaceProfit(7790000.0);
		horse.setYearProfit(4895000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. ERNAULT"));
		horse.setOwner(owner("ECURIE DELSEE"));
		// no rancher
		horse.setJockey(jockey("S. ERNAULT"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 16 - TWIST DES BAUX
	 * HorseID - TWIST DES BAUX
	 */
	public static HorseID builderHorse_R4_H16_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TWIST DES BAUX");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MODERN JAZZ");
		horseID.setMother("ANGELIQUE DES BAUX");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.NOIR);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 16 - TWIST DES BAUX
	 */

	public static Horse builderHorse_R4_H16(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H16_ID());
		horse.setNumber(16);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.8438E7);
		horse.setPreviousYearProfit(1222000.0);
		horse.setVictoryProfit(1.289E7);
		horse.setPlaceProfit(5548000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("L. LE DREAN"));
		horse.setOwner(owner("G. GUIBERT"));
		// no rancher
		horse.setJockey(jockey("A. WIELS"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 17 - SIBELLE DU LUOT
	 * HorseID - SIBELLE DU LUOT
	 */
	public static HorseID builderHorse_R4_H17_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SIBELLE DU LUOT");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("JASON DE VANDEL");
		horseID.setMother("LA BELLE DU LUOT");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 17 - SIBELLE DU LUOT
	 */

	public static Horse builderHorse_R4_H17(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H17_ID());
		horse.setNumber(17);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2900.0);
		horse.setCareerProfit(1.84805E7);
		horse.setPreviousYearProfit(4597000.0);
		horse.setVictoryProfit(6905000.0);
		horse.setPlaceProfit(1.15755E7);
		horse.setYearProfit(994500.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.Y. HERARD"));
		horse.setOwner(owner("J.Y. HERARD"));
		// no rancher
		horse.setJockey(jockey("M. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 4
	 * Odds 1 - 13/08/2015 12:30:52 +0200
	 */

	public static Odds builderOdds_R4_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:30:52 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 32.8));
		simples.add(simple(odds, "2", 76.1));
		simples.add(simple(odds, "3", 18.8));
		simples.add(simple(odds, "4", 16.0));
		simples.add(simple(odds, "5", 12.5));
		simples.add(simple(odds, "6", 15.7));
		simples.add(simple(odds, "7", 23.0));
		simples.add(simple(odds, "8", 98.1));
		simples.add(simple(odds, "9", 6.8));
		simples.add(simple(odds, "10", 19.2));
		simples.add(simple(odds, "11", 6.8));
		simples.add(simple(odds, "12", 50.7));
		simples.add(simple(odds, "13", 42.1));
		simples.add(simple(odds, "14", 40.1));
		simples.add(simple(odds, "15", 2.9));
		simples.add(simple(odds, "16", 42.5));
		simples.add(simple(odds, "17", 16.8));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4
	 * Odds 2 - 13/08/2015 14:09:54 +0200
	 */

	public static Odds builderOdds_R4_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:09:54 +0200"));
		odds.setTotal(121012.87);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 96.0));
		simples.add(simple(odds, "2", 89.9));
		simples.add(simple(odds, "3", 20.8));
		simples.add(simple(odds, "4", 23.7));
		simples.add(simple(odds, "5", 9.5));
		simples.add(simple(odds, "6", 13.9));
		simples.add(simple(odds, "7", 38.4));
		simples.add(simple(odds, "8", 159.5));
		simples.add(simple(odds, "9", 4.8));
		simples.add(simple(odds, "10", 30.4));
		simples.add(simple(odds, "11", 4.9));
		simples.add(simple(odds, "12", 100.1));
		simples.add(simple(odds, "13", 143.9));
		simples.add(simple(odds, "14", 142.1));
		simples.add(simple(odds, "15", 2.7));
		simples.add(simple(odds, "16", 111.2));
		simples.add(simple(odds, "17", 41.7));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5 - PRIX CLAUDE CHAUMOND
	 */

	public static Race builderRace_R5(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(5);
		race.setName("PRIX CLAUDE CHAUMOND");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 14:38:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(25000.0);
		race.setDiscipline(Discipline.TROT_MONTE);
		race.setTypes(EnumSet.noneOf(Type.class));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R5_H1(race));
		horses.add(builderHorse_R5_H2(race));
		horses.add(builderHorse_R5_H3(race));
		horses.add(builderHorse_R5_H4(race));
		horses.add(builderHorse_R5_H5(race));
		horses.add(builderHorse_R5_H6(race));
		horses.add(builderHorse_R5_H7(race));
		horses.add(builderHorse_R5_H8(race));
		horses.add(builderHorse_R5_H9(race));
		horses.add(builderHorse_R5_H10(race));
		horses.add(builderHorse_R5_H11(race));
		horses.add(builderHorse_R5_H12(race));
		horses.add(builderHorse_R5_H13(race));
		horses.add(builderHorse_R5_H14(race));
		horses.add(builderHorse_R5_H15(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R5_O1(race));
		oddsSet.add(builderOdds_R5_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 7, 212520));
		places.add(place(race, 2, 13, 212810));
		places.add(place(race, 3, 10, 213310));
		places.add(place(race, 4, 6, 214590));
		places.add(place(race, 5, 12, 214990));
		places.add(place(race, 6, 3, 215390));
		places.add(place(race, 7, 14, 217780));
		places.add(place(race, 8, 11, 218680));
		places.add(place(race, 9, 9, 218800));
		places.add(place(race, 10, 1, 224410));
		places.add(place(race, 11, 4, 234460));
		places.add(place(race, 12, 8, 252420));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("2 5 15");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 7.3, "7"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.5, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.3, "13"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.2, "7"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 67.0, "7 13"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 32.7, "7 13"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 11.9, "13 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.9, "7 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.5, "7 13"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 62.4, "7 13 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "10 6"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "13 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "13 6"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "7 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "7 13"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.9, "7 6"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 73.5, "7 13 10 6"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 14.7, "7 13 10 6"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 4.9, "7 13 10 6"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 2.1, "7 13 10 6"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 5
	 * Horse 1 - TEXANE DU SURF
	 * HorseID - TEXANE DU SURF
	 */
	public static HorseID builderHorse_R5_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TEXANE DU SURF");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CHAILLOT");
		horseID.setMother("UPELA COUDREENNE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 1 - TEXANE DU SURF
	 */

	public static Horse builderHorse_R5_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.3647E7);
		horse.setPreviousYearProfit(152000.0);
		horse.setVictoryProfit(5290000.0);
		horse.setPlaceProfit(8357000.0);
		horse.setYearProfit(1034000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A.H. VIEL"));
		horse.setOwner(owner("A.H. VIEL"));
		// no rancher
		horse.setJockey(jockey("H. GUEROT"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 2 - SULTAN DE BOUGY
	 * HorseID - SULTAN DE BOUGY
	 */
	public static HorseID builderHorse_R5_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SULTAN DE BOUGY");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("IDEAL DE L'ITON");
		horseID.setMother("MELROSE DE BOUGY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 2 - SULTAN DE BOUGY
	 */

	public static Horse builderHorse_R5_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.4417E7);
		horse.setPreviousYearProfit(6310000.0);
		horse.setVictoryProfit(8395000.0);
		horse.setPlaceProfit(6022000.0);
		horse.setYearProfit(1075000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. PITON"));
		horse.setOwner(owner("B. PITON"));
		// no rancher
		horse.setJockey(jockey("B. CHANONAT"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 3 - ULYSSE DE VRIE
	 * HorseID - ULYSSE DE VRIE
	 */
	public static HorseID builderHorse_R5_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULYSSE DE VRIE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("INSERT GEDE");
		horseID.setMother("NOBILIA DE VRIE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 3 - ULYSSE DE VRIE
	 */

	public static Horse builderHorse_R5_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.5246E7);
		horse.setPreviousYearProfit(8311000.0);
		horse.setVictoryProfit(1.1545E7);
		horse.setPlaceProfit(3701000.0);
		horse.setYearProfit(1140000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. BONNE"));
		horse.setOwner(owner("F. NAGI"));
		// no rancher
		horse.setJockey(jockey("D. BONNE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 4 - TIGRESSE GITANE
	 * HorseID - TIGRESSE GITANE
	 */
	public static HorseID builderHorse_R5_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TIGRESSE GITANE");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KUADRO WILD");
		horseID.setMother("NINE GITANE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 4 - TIGRESSE GITANE
	 */

	public static Horse builderHorse_R5_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.6536E7);
		horse.setPreviousYearProfit(2186000.0);
		horse.setVictoryProfit(6740000.0);
		horse.setPlaceProfit(9796000.0);
		horse.setYearProfit(547000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ST. ROUXEL"));
		horse.setOwner(owner("ECURIE DES PLAINES"));
		// no rancher
		horse.setJockey(jockey("M. KROUCHI"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 5 - SABRE NOIR
	 * HorseID - SABRE NOIR
	 */
	public static HorseID builderHorse_R5_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SABRE NOIR");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JULIANO STAR");
		horseID.setMother("DESNA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 5 - SABRE NOIR
	 */

	public static Horse builderHorse_R5_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.6575E7);
		horse.setPreviousYearProfit(75000.0);
		horse.setVictoryProfit(1.075E7);
		horse.setPlaceProfit(5825000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. LIZEE"));
		horse.setOwner(owner("D. LIZEE"));
		// no rancher
		horse.setJockey(jockey("AURELIEN DESMARRES"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 6 - VINCENT DES OBEAUX
	 * HorseID - VINCENT DES OBEAUX
	 */
	public static HorseID builderHorse_R5_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VINCENT DES OBEAUX");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DERBY DU GITE");
		horseID.setMother("LEILA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 6 - VINCENT DES OBEAUX
	 */

	public static Horse builderHorse_R5_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.6666E7);
		horse.setPreviousYearProfit(3680000.0);
		horse.setVictoryProfit(9395000.0);
		horse.setPlaceProfit(7271000.0);
		horse.setYearProfit(5671000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A. CHAVATTE"));
		horse.setOwner(owner("A. CHAVATTE"));
		// no rancher
		horse.setJockey(jockey("JULIEN RAFFESTIN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 7 - SIRIUS DE FELLIERE
	 * HorseID - SIRIUS DE FELLIERE
	 */
	public static HorseID builderHorse_R5_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SIRIUS DE FELLIERE");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GANYMEDE");
		horseID.setMother("JAMAIQUE DU PONT");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 7 - SIRIUS DE FELLIERE
	 */

	public static Horse builderHorse_R5_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.6952E7);
		horse.setPreviousYearProfit(2497000.0);
		horse.setVictoryProfit(6005000.0);
		horse.setPlaceProfit(1.0947E7);
		horse.setYearProfit(3137000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P.EMMANUEL MARY"));
		horse.setOwner(owner("ECURIE SYLVAIN ROUBAUD"));
		// no rancher
		horse.setJockey(jockey("E. RAFFIN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 8 - ULPIA DES JIPES
	 * HorseID - ULPIA DES JIPES
	 */
	public static HorseID builderHorse_R5_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULPIA DES JIPES");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("MON BELLOUET");
		horseID.setMother("OBIGA DES JIPES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 8 - ULPIA DES JIPES
	 */

	public static Horse builderHorse_R5_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.7439E7);
		horse.setPreviousYearProfit(4649000.0);
		horse.setVictoryProfit(1.0115E7);
		horse.setPlaceProfit(7324000.0);
		horse.setYearProfit(3948000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("F. NIVARD"));
		horse.setOwner(owner("HERVE CARLUS"));
		// no rancher
		horse.setJockey(jockey("F. NIVARD"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 9 - SPEED PACHA
	 * HorseID - SPEED PACHA
	 */
	public static HorseID builderHorse_R5_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SPEED PACHA");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KUADRO WILD");
		horseID.setMother("HELINE DE LA BUTTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 9 - SPEED PACHA
	 */

	public static Horse builderHorse_R5_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.7638E7);
		horse.setPreviousYearProfit(364000.0);
		horse.setVictoryProfit(9190000.0);
		horse.setPlaceProfit(8448000.0);
		horse.setYearProfit(912000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. CHERBONNEL"));
		horse.setOwner(owner("D. CHERBONNEL"));
		// no rancher
		horse.setJockey(jockey("MLLE ALEXIANE LEPAGE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 10 - TEMPO DE LEXLOR
	 * HorseID - TEMPO DE LEXLOR
	 */
	public static HorseID builderHorse_R5_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TEMPO DE LEXLOR");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LILIUM MADRIK");
		horseID.setMother("ISIS DE MARINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 10 - TEMPO DE LEXLOR
	 */

	public static Horse builderHorse_R5_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.7855E7);
		horse.setPreviousYearProfit(2454000.0);
		horse.setVictoryProfit(4760000.0);
		horse.setPlaceProfit(1.3095E7);
		horse.setYearProfit(4465000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("P. COMPAS"));
		horse.setOwner(owner("J.M. JOSSIC"));
		// no rancher
		horse.setJockey(jockey("M. MOTTIER"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 11 - TANGO DU LYS
	 * HorseID - TANGO DU LYS
	 */
	public static HorseID builderHorse_R5_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TANGO DU LYS");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUADROPHENIO");
		horseID.setMother("HI FI D'ERONVILLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.NOIR);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 11 - TANGO DU LYS
	 */

	public static Horse builderHorse_R5_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.8139E7);
		horse.setPreviousYearProfit(3449000.0);
		horse.setVictoryProfit(1.1995E7);
		horse.setPlaceProfit(6144000.0);
		horse.setYearProfit(950000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.L. BIGEON"));
		horse.setOwner(owner("J. SECHE"));
		// no rancher
		horse.setJockey(jockey("CL. FRECELLE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 12 - VERRAZANO BRIDGE
	 * HorseID - VERRAZANO BRIDGE
	 */
	public static HorseID builderHorse_R5_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VERRAZANO BRIDGE");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("OFFSHORE DREAM");
		horseID.setMother("KUALA LUMPUR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 12 - VERRAZANO BRIDGE
	 */

	public static Horse builderHorse_R5_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.8458E7);
		horse.setPreviousYearProfit(3914000.0);
		horse.setVictoryProfit(1.2835E7);
		horse.setPlaceProfit(5623000.0);
		horse.setYearProfit(7878000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. LENDERS"));
		horse.setOwner(owner("ECURIE PIERRE LEVESQUE"));
		// no rancher
		horse.setJockey(jockey("MLLE C. LEVESQUE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 13 - ULYSSE D'EPINAY
	 * HorseID - ULYSSE D'EPINAY
	 */
	public static HorseID builderHorse_R5_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULYSSE D'EPINAY");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KUADRO WILD");
		horseID.setMother("IMPERATRICE NOBLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 13 - ULYSSE D'EPINAY
	 */

	public static Horse builderHorse_R5_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.8826E7);
		horse.setPreviousYearProfit(4773000.0);
		horse.setVictoryProfit(9380000.0);
		horse.setPlaceProfit(9446000.0);
		horse.setYearProfit(5660000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. GUARATO"));
		horse.setOwner(owner("ECURIE PODIUM"));
		// no rancher
		horse.setJockey(jockey("A. LAMY"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 14 - SILICE DANICA
	 * HorseID - SILICE DANICA
	 */
	public static HorseID builderHorse_R5_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SILICE DANICA");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("INDY DE VIVE");
		horseID.setMother("DIVINE D'USSEAU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 14 - SILICE DANICA
	 */

	public static Horse builderHorse_R5_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.9474E7);
		horse.setPreviousYearProfit(468000.0);
		horse.setVictoryProfit(1.026E7);
		horse.setPlaceProfit(9214000.0);
		horse.setYearProfit(503000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.P. LECOURT"));
		horse.setOwner(owner("MME A. LECOURT"));
		// no rancher
		horse.setJockey(jockey("MLLE L. DRAPIER"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 15 - TOP DU CHENE
	 * HorseID - TOP DU CHENE
	 */
	public static HorseID builderHorse_R5_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TOP DU CHENE");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("NOBODY DU CHENE");
		horseID.setMother("LISE SAINT LATUIN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 15 - TOP DU CHENE
	 */

	public static Horse builderHorse_R5_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H15_ID());
		horse.setNumber(15);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		horse.setWeight(67.0);
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.9941E7);
		horse.setPreviousYearProfit(3463000.0);
		horse.setVictoryProfit(1.147E7);
		horse.setPlaceProfit(8471000.0);
		horse.setYearProfit(120000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. VARIN"));
		horse.setOwner(owner("CL. GUEDJ"));
		// no rancher
		horse.setJockey(jockey("A. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 5
	 * Odds 1 - 13/08/2015 12:31:02 +0200
	 */

	public static Odds builderOdds_R5_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:31:02 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 63.0));
		simples.add(simple(odds, "2", 32.7));
		simples.add(simple(odds, "3", 11.6));
		simples.add(simple(odds, "4", 28.4));
		simples.add(simple(odds, "5", 74.4));
		simples.add(simple(odds, "6", 5.8));
		simples.add(simple(odds, "7", 6.9));
		simples.add(simple(odds, "8", 15.5));
		simples.add(simple(odds, "9", 19.7));
		simples.add(simple(odds, "10", 8.4));
		simples.add(simple(odds, "11", 12.1));
		simples.add(simple(odds, "12", 4.8));
		simples.add(simple(odds, "13", 10.8));
		simples.add(simple(odds, "14", 37.4));
		simples.add(simple(odds, "15", 19.8));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5
	 * Odds 2 - 13/08/2015 14:41:11 +0200
	 */

	public static Odds builderOdds_R5_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:41:11 +0200"));
		odds.setTotal(143619.54);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 78.2));
		simples.add(simple(odds, "2", 79.2));
		simples.add(simple(odds, "3", 9.5));
		simples.add(simple(odds, "4", 63.8));
		simples.add(simple(odds, "5", 121.3));
		simples.add(simple(odds, "6", 4.2));
		simples.add(simple(odds, "7", 7.3));
		simples.add(simple(odds, "8", 18.7));
		simples.add(simple(odds, "9", 28.9));
		simples.add(simple(odds, "10", 9.8));
		simples.add(simple(odds, "11", 16.0));
		simples.add(simple(odds, "12", 3.7));
		simples.add(simple(odds, "13", 9.0));
		simples.add(simple(odds, "14", 101.8));
		simples.add(simple(odds, "15", 41.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6 - PRIX DU CONSEIL DEPARTEMENTAL DE LA MAYENNE
	 */

	public static Race builderRace_R6(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(6);
		race.setName("PRIX DU CONSEIL DEPARTEMENTAL DE LA MAYENNE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 15:08:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(21000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.NATIONALE));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R6_H1(race));
		horses.add(builderHorse_R6_H2(race));
		horses.add(builderHorse_R6_H3(race));
		horses.add(builderHorse_R6_H4(race));
		horses.add(builderHorse_R6_H5(race));
		horses.add(builderHorse_R6_H6(race));
		horses.add(builderHorse_R6_H7(race));
		horses.add(builderHorse_R6_H8(race));
		horses.add(builderHorse_R6_H9(race));
		horses.add(builderHorse_R6_H10(race));
		horses.add(builderHorse_R6_H11(race));
		horses.add(builderHorse_R6_H12(race));
		horses.add(builderHorse_R6_H13(race));
		horses.add(builderHorse_R6_H14(race));
		horses.add(builderHorse_R6_H15(race));
		horses.add(builderHorse_R6_H16(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R6_O1(race));
		oddsSet.add(builderOdds_R6_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 12, 212220));
		places.add(place(race, 2, 16, 212270));
		places.add(place(race, 3, 4, 212760));
		places.add(place(race, 4, 9, 213490));
		places.add(place(race, 5, 14, 213650));
		places.add(place(race, 6, 8, 214290));
		places.add(place(race, 7, 15, 214520));
		places.add(place(race, 8, 6, 214870));
		places.add(place(race, 9, 10, 216000));
		places.add(place(race, 10, 7, 217300));
		places.add(place(race, 11, 11, 227820));
		places.add(place(race, 12, 13, 236170));
		places.add(place(race, 13, 5, 245040));
		places.add(place(race, 14, 1, 245240));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("2 3");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 93.5, "12"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 15.7, "12"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.2, "16"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.4, "4"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 834.7, "12 16"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 395.7, "12 16"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 95.0, "12 16"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 216.8, "12 4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 13.5, "16 4"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 2324.4, "12 16 4"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "12 16"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "12 4"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "12 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "16 4"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "16 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.2, "4 9"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 1848.0, "12 16 4 9"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 369.6, "12 16 4 9"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 123.2, "12 16 4 9"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 52.8, "12 16 4 9"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 6
	 * Horse 1 - ANEMONE DU GITE
	 * HorseID - ANEMONE DU GITE
	 */
	public static HorseID builderHorse_R6_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ANEMONE DU GITE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("DERBY DU GITE");
		horseID.setMother("BAUXITE BOCAIN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 1 - ANEMONE DU GITE
	 */

	public static Horse builderHorse_R6_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6065000.0);
		horse.setPreviousYearProfit(2643000.0);
		horse.setVictoryProfit(3600000.0);
		horse.setPlaceProfit(2465000.0);
		horse.setYearProfit(2997000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. LELIEVRE"));
		horse.setOwner(owner("G. LELIEVRE"));
		// no rancher
		horse.setJockey(jockey("D. BONNE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 2 - AS DE BREVOL
	 * HorseID - AS DE BREVOL
	 */
	public static HorseID builderHorse_R6_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AS DE BREVOL");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("OPUS VIERVIL");
		horseID.setMother("LADY DE BREVOL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 2 - AS DE BREVOL
	 */

	public static Horse builderHorse_R6_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6234000.0);
		horse.setPreviousYearProfit(2004000.0);
		horse.setVictoryProfit(4500000.0);
		horse.setPlaceProfit(1734000.0);
		horse.setYearProfit(1980000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. ERNAULT"));
		horse.setOwner(owner("ECURIE AUGUSTIN-NORMAND"));
		// no rancher
		horse.setJockey(jockey("S. ERNAULT"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 3 - ARME BLANCHE
	 * HorseID - ARME BLANCHE
	 */
	public static HorseID builderHorse_R6_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ARME BLANCHE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("DEFI D'AUNOU");
		horseID.setMother("OREADE BLANCHE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 3 - ARME BLANCHE
	 */

	public static Horse builderHorse_R6_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		horse.setStable("A");
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6331000.0);
		horse.setPreviousYearProfit(4365000.0);
		horse.setVictoryProfit(3795000.0);
		horse.setPlaceProfit(2536000.0);
		horse.setYearProfit(896000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("L.CL. ABRIVARD"));
		horse.setOwner(owner("J. COTTEL"));
		// no rancher
		horse.setJockey(jockey("A. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 4 - AUSTRALIA ZEN
	 * HorseID - AUSTRALIA ZEN
	 */
	public static HorseID builderHorse_R6_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AUSTRALIA ZEN");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PRODIGIOUS");
		horseID.setMother("JUST LOVE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 4 - AUSTRALIA ZEN
	 */

	public static Horse builderHorse_R6_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6400000.0);
		horse.setPreviousYearProfit(3541000.0);
		horse.setVictoryProfit(3735000.0);
		horse.setPlaceProfit(2665000.0);
		horse.setYearProfit(2064000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. KOUBICHE"));
		horse.setOwner(owner("J. KOUBICHE"));
		// no rancher
		horse.setJockey(jockey("J. KOUBICHE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 5 - ARNOLD FOUTEAU
	 * HorseID - ARNOLD FOUTEAU
	 */
	public static HorseID builderHorse_R6_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ARNOLD FOUTEAU");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KALLIGHAN");
		horseID.setMother("LICORNE D'AZE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 5 - ARNOLD FOUTEAU
	 */

	public static Horse builderHorse_R6_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6413000.0);
		horse.setPreviousYearProfit(4361000.0);
		horse.setVictoryProfit(4860000.0);
		horse.setPlaceProfit(1553000.0);
		horse.setYearProfit(1980000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A. DREUX"));
		horse.setOwner(owner("A. DREUX"));
		// no rancher
		horse.setJockey(jockey("A. VELANY"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 6 - ALDO DE CONNEE
	 * HorseID - ALDO DE CONNEE
	 */
	public static HorseID builderHorse_R6_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ALDO DE CONNEE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GROS GRAIN");
		horseID.setMother("KANA D'OLAINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 6 - ALDO DE CONNEE
	 */

	public static Horse builderHorse_R6_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6460000.0);
		horse.setPreviousYearProfit(1629000.0);
		horse.setVictoryProfit(2970000.0);
		horse.setPlaceProfit(3490000.0);
		horse.setYearProfit(2758000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH.A. MALLET"));
		horse.setOwner(owner("CH.A. MALLET"));
		// no rancher
		horse.setJockey(jockey("L. GUINOISEAU"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 7 - ARANO JOSSELYN
	 * HorseID - ARANO JOSSELYN
	 */
	public static HorseID builderHorse_R6_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ARANO JOSSELYN");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("LOOK DE STAR");
		horseID.setMother("HEZIA JOSSELYN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 7 - ARANO JOSSELYN
	 */

	public static Horse builderHorse_R6_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6513000.0);
		horse.setPreviousYearProfit(4725000.0);
		horse.setVictoryProfit(6435000.0);
		horse.setPlaceProfit(78000.0);
		horse.setYearProfit(900000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.L. DERSOIR"));
		horse.setOwner(owner("ECURIE LUCK"));
		// no rancher
		horse.setJockey(jockey("M. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 8 - AS DE KARA
	 * HorseID - AS DE KARA
	 */
	public static HorseID builderHorse_R6_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AS DE KARA");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KUADRO WILD");
		horseID.setMother("KARA DE CLERLANDE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 8 - AS DE KARA
	 */

	public static Horse builderHorse_R6_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6645000.0);
		horse.setPreviousYearProfit(2809000.0);
		horse.setVictoryProfit(5175000.0);
		horse.setPlaceProfit(1470000.0);
		horse.setYearProfit(3589000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. TESSIER"));
		horse.setOwner(owner("S. TESSIER"));
		// no rancher
		horse.setJockey(jockey("S. TESSIER"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 9 - ANAR DE JOUDES
	 * HorseID - ANAR DE JOUDES
	 */
	public static HorseID builderHorse_R6_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ANAR DE JOUDES");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("AND ARIFANT");
		horseID.setMother("PEARL DE JOUDES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_CERISE);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 9 - ANAR DE JOUDES
	 */

	public static Horse builderHorse_R6_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6650000.0);
		horse.setPreviousYearProfit(3149000.0);
		horse.setVictoryProfit(3105000.0);
		horse.setPlaceProfit(3545000.0);
		horse.setYearProfit(2793000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.L. BIGEON"));
		horse.setOwner(owner("J. SECHE"));
		// no rancher
		horse.setJockey(jockey("CL. FRECELLE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 10 - ALIENOR DE ROCHE
	 * HorseID - ALIENOR DE ROCHE
	 */
	public static HorseID builderHorse_R6_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ALIENOR DE ROCHE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("HULK DES CHAMPS");
		horseID.setMother("QUELLE JOLIE IDEE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 10 - ALIENOR DE ROCHE
	 */

	public static Horse builderHorse_R6_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6656000.0);
		horse.setPreviousYearProfit(2041000.0);
		horse.setVictoryProfit(2430000.0);
		horse.setPlaceProfit(4226000.0);
		horse.setYearProfit(3670000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A. LENOIR"));
		horse.setOwner(owner("ECURIE DES ALIZES"));
		// no rancher
		horse.setJockey(jockey("A. LENOIR"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 11 - ASTUCE DE KACY
	 * HorseID - ASTUCE DE KACY
	 */
	public static HorseID builderHorse_R6_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ASTUCE DE KACY");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QUALMIO DE VANDEL");
		horseID.setMother("OLLY BLUE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 11 - ASTUCE DE KACY
	 */

	public static Horse builderHorse_R6_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		horse.setStable("A");
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6696000.0);
		horse.setPreviousYearProfit(4610000.0);
		horse.setVictoryProfit(4365000.0);
		horse.setPlaceProfit(2331000.0);
		horse.setYearProfit(418000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("F. LEBLANC"));
		horse.setOwner(owner("J. COTTEL"));
		// no rancher
		horse.setJockey(jockey("D. GARCIAS"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 12 - AURORE ECLATANTE
	 * HorseID - AURORE ECLATANTE
	 */
	public static HorseID builderHorse_R6_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AURORE ECLATANTE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("LAETENTER DIEM");
		horseID.setMother("MISS ECLATANTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 12 - AURORE ECLATANTE
	 */

	public static Horse builderHorse_R6_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6718000.0);
		horse.setPreviousYearProfit(4287000.0);
		horse.setVictoryProfit(1350000.0);
		horse.setPlaceProfit(5368000.0);
		horse.setYearProfit(530000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. PERRIL"));
		horse.setOwner(owner("F.A. BELLANGER"));
		// no rancher
		horse.setJockey(jockey("M. PERRIL"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 13 - AS DODIENVILLE
	 * HorseID - AS DODIENVILLE
	 */
	public static HorseID builderHorse_R6_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AS DODIENVILLE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("CHEF DU CHATELET");
		horseID.setMother("LIANE DODIENVILLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 13 - AS DODIENVILLE
	 */

	public static Horse builderHorse_R6_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6721000.0);
		horse.setPreviousYearProfit(6047000.0);
		horse.setVictoryProfit(3330000.0);
		horse.setPlaceProfit(3391000.0);
		horse.setYearProfit(674000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.P. MARMION"));
		horse.setOwner(owner("ECURIE JEAN PAUL MARMION"));
		// no rancher
		horse.setJockey(jockey("A. WIELS"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 14 - AERO
	 * HorseID - AERO
	 */
	public static HorseID builderHorse_R6_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AERO");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("QUARO");
		horseID.setMother("ROME TO PARIS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 14 - AERO
	 */

	public static Horse builderHorse_R6_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6811000.0);
		horse.setPreviousYearProfit(2811000.0);
		horse.setVictoryProfit(1750000.0);
		horse.setPlaceProfit(5061000.0);
		horse.setYearProfit(2115000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. ARMELLINI"));
		horse.setOwner(owner("M. AHRES"));
		// no rancher
		horse.setJockey(jockey("D. ARMELLINI"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 15 - ASTON DE MEAUTIS
	 * HorseID - ASTON DE MEAUTIS
	 */
	public static HorseID builderHorse_R6_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ASTON DE MEAUTIS");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("OPIUM");
		horseID.setMother("MICHKA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 15 - ASTON DE MEAUTIS
	 */

	public static Horse builderHorse_R6_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H15_ID());
		horse.setNumber(15);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6881000.0);
		horse.setPreviousYearProfit(2988000.0);
		horse.setVictoryProfit(5175000.0);
		horse.setPlaceProfit(1706000.0);
		horse.setYearProfit(3157000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. LENDERS"));
		horse.setOwner(owner("ECURIE PIERRE LEVESQUE"));
		// no rancher
		horse.setJockey(jockey("TH. LEVESQUE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 16 - ADAGIO DE LA TOUR
	 * HorseID - ADAGIO DE LA TOUR
	 */
	public static HorseID builderHorse_R6_H16_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ADAGIO DE LA TOUR");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LILIUM MADRIK");
		horseID.setMother("QUEEN OF CELTES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 16 - ADAGIO DE LA TOUR
	 */

	public static Horse builderHorse_R6_H16(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H16_ID());
		horse.setNumber(16);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6977000.0);
		horse.setPreviousYearProfit(3379000.0);
		horse.setVictoryProfit(3150000.0);
		horse.setPlaceProfit(3827000.0);
		horse.setYearProfit(1625000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("F. ANNE"));
		horse.setOwner(owner("ECURIE FRANCK ANNE"));
		// no rancher
		horse.setJockey(jockey("F. ANNE"));

		return horse;

	}

	/*
	 * Race 6
	 * Odds 1 - 13/08/2015 12:31:07 +0200
	 */

	public static Odds builderOdds_R6_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:31:07 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 19.3));
		simples.add(simple(odds, "2", 3.8));
		simples.add(simple(odds, "3", 22.8));
		simples.add(simple(odds, "4", 18.5));
		simples.add(simple(odds, "5", 76.2));
		simples.add(simple(odds, "6", 25.3));
		simples.add(simple(odds, "7", 6.0));
		simples.add(simple(odds, "8", 71.7));
		simples.add(simple(odds, "9", 21.7));
		simples.add(simple(odds, "10", 32.0));
		simples.add(simple(odds, "11", 53.9));
		simples.add(simple(odds, "12", 35.3));
		simples.add(simple(odds, "13", 21.4));
		simples.add(simple(odds, "14", 8.6));
		simples.add(simple(odds, "15", 10.9));
		simples.add(simple(odds, "16", 6.0));
		simples.add(simple(odds, "A", 16.0));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6
	 * Odds 2 - 13/08/2015 15:15:31 +0200
	 */

	public static Odds builderOdds_R6_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 15:15:31 +0200"));
		odds.setTotal(174950.66);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 33.6));
		simples.add(simple(odds, "2", 4.1));
		simples.add(simple(odds, "3", 44.3));
		simples.add(simple(odds, "4", 24.5));
		simples.add(simple(odds, "5", 104.4));
		simples.add(simple(odds, "6", 58.7));
		simples.add(simple(odds, "7", 3.3));
		simples.add(simple(odds, "8", 75.4));
		simples.add(simple(odds, "9", 13.4));
		simples.add(simple(odds, "10", 32.3));
		simples.add(simple(odds, "11", 118.3));
		simples.add(simple(odds, "12", 93.5));
		simples.add(simple(odds, "13", 30.1));
		simples.add(simple(odds, "14", 14.2));
		simples.add(simple(odds, "15", 7.4));
		simples.add(simple(odds, "16", 6.5));
		simples.add(simple(odds, "A", 32.2));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7 - PRIX DE LA COMMUNAUTE DE COMMUNES
	 */

	public static Race builderRace_R7(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(7);
		race.setName("PRIX DE LA COMMUNAUTE DE COMMUNES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 15:40:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(22000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.APPRENTIS, Type.LADS_JOCKEYS));
		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R7_H1(race));
		horses.add(builderHorse_R7_H2(race));
		horses.add(builderHorse_R7_H3(race));
		horses.add(builderHorse_R7_H4(race));
		horses.add(builderHorse_R7_H5(race));
		horses.add(builderHorse_R7_H6(race));
		horses.add(builderHorse_R7_H7(race));
		horses.add(builderHorse_R7_H8(race));
		horses.add(builderHorse_R7_H9(race));
		horses.add(builderHorse_R7_H10(race));
		horses.add(builderHorse_R7_H11(race));
		horses.add(builderHorse_R7_H12(race));
		horses.add(builderHorse_R7_H13(race));
		horses.add(builderHorse_R7_H14(race));
		horses.add(builderHorse_R7_H15(race));
		horses.add(builderHorse_R7_H16(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R7_O1(race));
		oddsSet.add(builderOdds_R7_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 10, 228270));
		places.add(place(race, 2, 2, 228540));
		places.add(place(race, 3, 9, 228600));
		places.add(place(race, 4, 13, 228910));
		places.add(place(race, 5, 6, 228950));
		places.add(place(race, 6, 11, 228990));
		places.add(place(race, 7, 4, 229200));
		places.add(place(race, 8, 7, 229230));
		places.add(place(race, 9, 3, 230060));
		places.add(place(race, 10, 8, 230070));
		places.add(place(race, 11, 12, 230150));
		places.add(place(race, 12, 5, 230650));
		places.add(place(race, 13, 1, 230910));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("14 16");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 5.4, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.6, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 0.0, "10"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 49.2, "10 2"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 5.4, "10"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 24.9, "10 2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.8, "10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.7, "10 2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.8, "10 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.6, "2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.1, "2 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.6, "9"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 23.8, "10 2"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 23.8, "10 2 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "10 13"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "10 2"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "10 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "13"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "2"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "2 13"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "2 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.1, "9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.2, "9 13"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 42.0, "10 2 9 13"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 8.4, "10 2 9 13"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 2.8, "10 2 9 13"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 1.2, "10 2 9 13"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 7
	 * Horse 1 - URANUS DARCHE
	 * HorseID - URANUS DARCHE
	 */
	public static HorseID builderHorse_R7_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("URANUS DARCHE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HASTING");
		horseID.setMother("KERMESSE DU RELAIS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 1 - URANUS DARCHE
	 */

	public static Horse builderHorse_R7_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(6795000.0);
		horse.setPreviousYearProfit(1079000.0);
		horse.setVictoryProfit(1500000.0);
		horse.setPlaceProfit(5295000.0);
		horse.setYearProfit(390000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. BOISNARD"));
		horse.setOwner(owner("ECURIE CHRISTIAN BOISNARD"));
		// no rancher
		horse.setJockey(jockey("A.PH. GRIMAULT"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 2 - URKO DES BROUSSES
	 * HorseID - URKO DES BROUSSES
	 */
	public static HorseID builderHorse_R7_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("URKO DES BROUSSES");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GANYMEDE");
		horseID.setMother("NADIA DE BEL AIR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN_BRULE);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 2 - URKO DES BROUSSES
	 */

	public static Horse builderHorse_R7_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(8309000.0);
		horse.setPreviousYearProfit(1380000.0);
		horse.setVictoryProfit(5175000.0);
		horse.setPlaceProfit(3134000.0);
		horse.setYearProfit(3481000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("LOIC GROUSSARD"));
		horse.setOwner(owner("LOIC GROUSSARD"));
		// no rancher
		horse.setJockey(jockey("P. GROUSSARD"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 3 - UN FIRST
	 * HorseID - UN FIRST
	 */
	public static HorseID builderHorse_R7_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UN FIRST");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("FIRST DE RETZ");
		horseID.setMother("OPERA MELODY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 3 - UN FIRST
	 */

	public static Horse builderHorse_R7_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0026E7);
		horse.setPreviousYearProfit(1732000.0);
		horse.setVictoryProfit(6880000.0);
		horse.setPlaceProfit(3146000.0);
		horse.setYearProfit(1935000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE DES CHARMES"));
		// no rancher
		horse.setJockey(jockey("N. CHEREAU"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 4 - ULTRA DU GITE
	 * HorseID - ULTRA DU GITE
	 */
	public static HorseID builderHorse_R7_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULTRA DU GITE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("GISELLA DU GITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 4 - ULTRA DU GITE
	 */

	public static Horse builderHorse_R7_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0114E7);
		horse.setPreviousYearProfit(6873000.0);
		horse.setVictoryProfit(6650000.0);
		horse.setPlaceProfit(3464000.0);
		horse.setYearProfit(176000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("S. FERCHAUD"));
		horse.setOwner(owner("S. FERCHAUD"));
		// no rancher
		horse.setJockey(jockey("P. FERCHAUD"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 5 - VORMENSITO
	 * HorseID - VORMENSITO
	 */
	public static HorseID builderHorse_R7_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VORMENSITO");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUATRE JUILLET");
		horseID.setMother("CARMENSITA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 5 - VORMENSITO
	 */

	public static Horse builderHorse_R7_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0154E7);
		horse.setPreviousYearProfit(720000.0);
		horse.setVictoryProfit(6530000.0);
		horse.setPlaceProfit(3624000.0);
		horse.setYearProfit(2085000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("Y. BOIREAU"));
		horse.setOwner(owner("J.P. DUBOIS"));
		// no rancher
		horse.setJockey(jockey("B. HOLLSTEN"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 6 - VAENA FUN
	 * HorseID - VAENA FUN
	 */
	public static HorseID builderHorse_R7_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VAENA FUN");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("JAG DE BELLOUET");
		horseID.setMother("GRACE D'ALLIGNY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 6 - VAENA FUN
	 */

	public static Horse builderHorse_R7_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0603E7);
		horse.setPreviousYearProfit(5289000.0);
		horse.setVictoryProfit(4815000.0);
		horse.setPlaceProfit(5788000.0);
		horse.setYearProfit(1904000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("F. LEBLANC"));
		horse.setOwner(owner("F. LEBLANC"));
		// no rancher
		horse.setJockey(jockey("D. GARCIAS"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 7 - ULOTTE DE TAGOR
	 * HorseID - ULOTTE DE TAGOR
	 */
	public static HorseID builderHorse_R7_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULOTTE DE TAGOR");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ONYX DU GOUTIER");
		horseID.setMother("HARGOTE DE TAGOR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 7 - ULOTTE DE TAGOR
	 */

	public static Horse builderHorse_R7_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0803E7);
		horse.setPreviousYearProfit(2420000.0);
		horse.setVictoryProfit(2940000.0);
		horse.setPlaceProfit(7863000.0);
		horse.setYearProfit(2637000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. DESLANDES"));
		horse.setOwner(owner("B. DESLANDES"));
		// no rancher
		horse.setJockey(jockey("AURELIEN DESMARRES"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 8 - VOLCAN DE JAUDRAIS
	 * HorseID - VOLCAN DE JAUDRAIS
	 */
	public static HorseID builderHorse_R7_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VOLCAN DE JAUDRAIS");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("L'ECU DU VERNAY");
		horseID.setMother("LADY SENONCHOISE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 8 - VOLCAN DE JAUDRAIS
	 */

	public static Horse builderHorse_R7_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0843E7);
		horse.setPreviousYearProfit(3676000.0);
		horse.setVictoryProfit(4230000.0);
		horse.setPlaceProfit(6613000.0);
		horse.setYearProfit(4651000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ET. HERBEAU"));
		horse.setOwner(owner("ET. HERBEAU"));
		// no rancher
		horse.setJockey(jockey("E. HERBEAU"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 9 - VINTAGE
	 * HorseID - VINTAGE
	 */
	public static HorseID builderHorse_R7_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VINTAGE");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("NICKNAME");
		horseID.setMother("SHADLINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 9 - VINTAGE
	 */

	public static Horse builderHorse_R7_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0926E7);
		horse.setPreviousYearProfit(46000.0);
		horse.setVictoryProfit(8870000.0);
		horse.setPlaceProfit(2056000.0);
		horse.setYearProfit(6414000.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. LENDERS"));
		horse.setOwner(owner("MME DANIELE GOZLAN"));
		// no rancher
		horse.setJockey(jockey("P.CH. JEAN"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 10 - VERSO DU JAAR
	 * HorseID - VERSO DU JAAR
	 */
	public static HorseID builderHorse_R7_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VERSO DU JAAR");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ICO KIKI");
		horseID.setMother("PAOLA D'OR FIX");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 10 - VERSO DU JAAR
	 */

	public static Horse builderHorse_R7_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.0995E7);
		horse.setPreviousYearProfit(4080000.0);
		horse.setVictoryProfit(5940000.0);
		horse.setPlaceProfit(5055000.0);
		horse.setYearProfit(3327000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. MICHARDIERE"));
		horse.setOwner(owner("B. MICHARDIERE"));
		// no rancher
		horse.setJockey(jockey("C. GODARD"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 11 - VERITABLE FOUTEAU
	 * HorseID - VERITABLE FOUTEAU
	 */
	public static HorseID builderHorse_R7_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VERITABLE FOUTEAU");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GAZOUILLIS");
		horseID.setMother("GIKITA FOUTEAU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 11 - VERITABLE FOUTEAU
	 */

	public static Horse builderHorse_R7_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.1005E7);
		horse.setPreviousYearProfit(5731000.0);
		horse.setVictoryProfit(5360000.0);
		horse.setPlaceProfit(5645000.0);
		horse.setYearProfit(1824000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A. DREUX"));
		horse.setOwner(owner("A. DREUX"));
		// no rancher
		horse.setJockey(jockey("A. VELANY"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 12 - ULTIME DES BORDES
	 * HorseID - ULTIME DES BORDES
	 */
	public static HorseID builderHorse_R7_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULTIME DES BORDES");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ORSY DREAM");
		horseID.setMother("GALEA DES BORDES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 12 - ULTIME DES BORDES
	 */

	public static Horse builderHorse_R7_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.1026E7);
		horse.setPreviousYearProfit(598000.0);
		horse.setVictoryProfit(4835000.0);
		horse.setPlaceProfit(6191000.0);
		horse.setYearProfit(1416000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("B. LEFEVRE"));
		horse.setOwner(owner("ECURIE BERTRAND LEFEVRE"));
		// no rancher
		horse.setJockey(jockey("MLLE V. CAPITAINE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 13 - VIF GALBE
	 * HorseID - VIF GALBE
	 */
	public static HorseID builderHorse_R7_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIF GALBE");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("NIL DU RIB");
		horseID.setMother("GRACE GALBE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 13 - VIF GALBE
	 */

	public static Horse builderHorse_R7_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.1082E7);
		horse.setPreviousYearProfit(2615000.0);
		horse.setVictoryProfit(4290000.0);
		horse.setPlaceProfit(6792000.0);
		horse.setYearProfit(3925000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ARNAUD MORIN"));
		horse.setOwner(owner("ARNAUD MORIN"));
		// no rancher
		horse.setJockey(jockey("L. SZCZESNY"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 14 - UPRIGHT
	 * HorseID - UPRIGHT
	 */
	public static HorseID builderHorse_R7_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UPRIGHT");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GAZOUILLIS");
		horseID.setMother("GOLD ARROW");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 14 - UPRIGHT
	 */

	public static Horse builderHorse_R7_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.117E7);
		horse.setPreviousYearProfit(3429000.0);
		horse.setVictoryProfit(3165000.0);
		horse.setPlaceProfit(8005000.0);
		horse.setYearProfit(1704000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ST. MEUNIER"));
		horse.setOwner(owner("I. COLLIN"));
		// no rancher
		horse.setJockey(jockey("N. DELAROCHE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 15 - ULA DE NAVARY
	 * HorseID - ULA DE NAVARY
	 */
	public static HorseID builderHorse_R7_H15_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULA DE NAVARY");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KEPLER");
		horseID.setMother("JASMINE DE NAVARY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 15 - ULA DE NAVARY
	 */

	public static Horse builderHorse_R7_H15(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H15_ID());
		horse.setNumber(15);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.1254E7);
		horse.setPreviousYearProfit(4050000.0);
		horse.setVictoryProfit(3420000.0);
		horse.setPlaceProfit(7834000.0);
		horse.setYearProfit(466000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("TH. LONCKE"));
		horse.setOwner(owner("TH. LONCKE"));
		// no rancher
		horse.setJockey(jockey("TH.R. LONCKE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 16 - VERDI DE TILLARD
	 * HorseID - VERDI DE TILLARD
	 */
	public static HorseID builderHorse_R7_H16_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VERDI DE TILLARD");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HERMES DE PERICARD");
		horseID.setMother("MELODIE DE TILLARD");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 16 - VERDI DE TILLARD
	 */

	public static Horse builderHorse_R7_H16(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H16_ID());
		horse.setNumber(16);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1.1259E7);
		horse.setPreviousYearProfit(4959000.0);
		horse.setVictoryProfit(7580000.0);
		horse.setPlaceProfit(3679000.0);
		horse.setYearProfit(2828000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ET. LEFRANC"));
		horse.setOwner(owner("ECURIE CHAUNION"));
		// no rancher
		horse.setJockey(jockey("NICOLAS LEFEVRE"));

		return horse;

	}

	/*
	 * Race 7
	 * Odds 1 - 13/08/2015 12:31:10 +0200
	 */

	public static Odds builderOdds_R7_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:31:10 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 29.2));
		simples.add(simple(odds, "2", 12.2));
		simples.add(simple(odds, "3", 43.2));
		simples.add(simple(odds, "4", 21.8));
		simples.add(simple(odds, "5", 18.0));
		simples.add(simple(odds, "6", 14.6));
		simples.add(simple(odds, "7", 26.3));
		simples.add(simple(odds, "8", 17.9));
		simples.add(simple(odds, "9", 4.1));
		simples.add(simple(odds, "10", 6.7));
		simples.add(simple(odds, "11", 8.5));
		simples.add(simple(odds, "12", 11.6));
		simples.add(simple(odds, "13", 16.8));
		simples.add(simple(odds, "14", 13.3));
		simples.add(simple(odds, "15", 14.3));
		simples.add(simple(odds, "16", 15.6));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7
	 * Odds 2 - 13/08/2015 15:41:56 +0200
	 */

	public static Odds builderOdds_R7_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 15:41:56 +0200"));
		odds.setTotal(125097.81);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 96.4));
		simples.add(simple(odds, "2", 10.4));
		simples.add(simple(odds, "3", 58.9));
		simples.add(simple(odds, "4", 30.7));
		simples.add(simple(odds, "5", 28.8));
		simples.add(simple(odds, "6", 16.4));
		simples.add(simple(odds, "7", 40.4));
		simples.add(simple(odds, "8", 29.5));
		simples.add(simple(odds, "9", 2.9));
		simples.add(simple(odds, "10", 5.4));
		simples.add(simple(odds, "11", 10.5));
		simples.add(simple(odds, "12", 24.5));
		simples.add(simple(odds, "13", 13.1));
		simples.add(simple(odds, "14", 32.6));
		simples.add(simple(odds, "15", 11.2));
		simples.add(simple(odds, "16", 8.7));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 8 - PRIX FIESTA D'ANJOU
	 */

	public static Race builderRace_R8(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(8);
		race.setName("PRIX FIESTA D'ANJOU");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 16:10:00 +0200"));
		// no real start
		race.setDistance(2875.0);
		race.setBenefit(19000.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.NATIONALE));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R8_H1(race));
		horses.add(builderHorse_R8_H2(race));
		horses.add(builderHorse_R8_H3(race));
		horses.add(builderHorse_R8_H4(race));
		horses.add(builderHorse_R8_H5(race));
		horses.add(builderHorse_R8_H6(race));
		horses.add(builderHorse_R8_H7(race));
		horses.add(builderHorse_R8_H8(race));
		horses.add(builderHorse_R8_H9(race));
		horses.add(builderHorse_R8_H10(race));
		horses.add(builderHorse_R8_H11(race));
		horses.add(builderHorse_R8_H12(race));
		horses.add(builderHorse_R8_H13(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R8_O1(race));
		oddsSet.add(builderOdds_R8_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 12, 218030));
		places.add(place(race, 2, 10, 218310));
		places.add(place(race, 3, 5, 218530));
		places.add(place(race, 4, 7, 218940));
		places.add(place(race, 5, 11, 219630));
		places.add(place(race, 6, 6, 219790));
		places.add(place(race, 7, 4, 220500));
		places.add(place(race, 8, 9, 220880));
		places.add(place(race, 9, 3, 222210));
		places.add(place(race, 10, 2, 226130));
		places.add(place(race, 11, 13, 232970));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("1");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 4.6, "12"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "12"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "5"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 4.6, "12"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 39.4, "12 10"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 0.0, "12"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 20.0, "12 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.3, "10 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "12"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.0, "12 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.5, "12 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "5"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 0.0, "12 10"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 15.3, "12 10 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "10 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "10 7"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "12 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "12 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "12 7"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.6, "5 7"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 123.0, "12 10 5 7"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 24.6, "12 10 5 7"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 8.2, "12 10 5 7"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 8
	 * Horse 1 - BAMBINA BLUE
	 * HorseID - BAMBINA BLUE
	 */
	public static HorseID builderHorse_R8_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BAMBINA BLUE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("LUCKY BLUE");
		horseID.setMother("QUEA BLUE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 1 - BAMBINA BLUE
	 */

	public static Horse builderHorse_R8_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1484000.0);
		horse.setPreviousYearProfit(1384000.0);
		horse.setVictoryProfit(900000.0);
		horse.setPlaceProfit(584000.0);
		horse.setYearProfit(100000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.PH. MARY"));
		horse.setOwner(owner("MME C. DABOUIS-MARY"));
		// no rancher
		horse.setJockey(jockey("J.PH. MARY"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 2 - BALANCE FLEURIE
	 * HorseID - BALANCE FLEURIE
	 */
	public static HorseID builderHorse_R8_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BALANCE FLEURIE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OURAGAN DE CELLAND");
		horseID.setMother("JAPRILLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 2 - BALANCE FLEURIE
	 */

	public static Horse builderHorse_R8_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1498000.0);
		horse.setPreviousYearProfit(156000.0);
		horse.setVictoryProfit(630000.0);
		horse.setPlaceProfit(868000.0);
		horse.setYearProfit(1342000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CH. BEZIER"));
		horse.setOwner(owner("CH. BEZIER"));
		// no rancher
		horse.setJockey(jockey("CH. BEZIER"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 3 - BEAUTE DU NIEL
	 * HorseID - BEAUTE DU NIEL
	 */
	public static HorseID builderHorse_R8_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BEAUTE DU NIEL");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("MEAULNES DU CORTA");
		horseID.setMother("MISS DU NIEL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 3 - BEAUTE DU NIEL
	 */

	public static Horse builderHorse_R8_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1782000.0);
		horse.setPreviousYearProfit(250000.0);
		horse.setVictoryProfit(630000.0);
		horse.setPlaceProfit(1152000.0);
		horse.setYearProfit(1532000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("TH. LE FLOCH"));
		horse.setOwner(owner("TH. LE FLOCH"));
		// no rancher
		horse.setJockey(jockey("TH. LE FLOCH"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 4 - BASELIA GEDE
	 * HorseID - BASELIA GEDE
	 */
	public static HorseID builderHorse_R8_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BASELIA GEDE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("BIESOLO");
		horseID.setMother("LALIFLO GEDE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 4 - BASELIA GEDE
	 */

	public static Horse builderHorse_R8_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1892000.0);
		horse.setPreviousYearProfit(442000.0);
		horse.setVictoryProfit(1125000.0);
		horse.setPlaceProfit(767000.0);
		horse.setYearProfit(1450000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M. SASSIER"));
		horse.setOwner(owner("ECURIE SASSIER"));
		// no rancher
		horse.setJockey(jockey("M. SASSIER"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 5 - BEVERLY LOVE
	 * HorseID - BEVERLY LOVE
	 */
	public static HorseID builderHorse_R8_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BEVERLY LOVE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("JUST IN LOVE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 5 - BEVERLY LOVE
	 */

	public static Horse builderHorse_R8_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1894000.0);
		horse.setPreviousYearProfit(540000.0);
		horse.setVictoryProfit(1440000.0);
		horse.setPlaceProfit(454000.0);
		horse.setYearProfit(1354000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.M. BAZIRE"));
		horse.setOwner(owner("ECURIE JEAN MICHEL BAZIRE"));
		// no rancher
		horse.setJockey(jockey("J.M. BAZIRE"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 6 - BUSINESS LADY
	 * HorseID - BUSINESS LADY
	 */
	public static HorseID builderHorse_R8_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BUSINESS LADY");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CHEF DU CHATELET");
		horseID.setMother("NINA DE MONTI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 6 - BUSINESS LADY
	 */

	public static Horse builderHorse_R8_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1946000.0);
		horse.setPreviousYearProfit(1236000.0);
		horse.setVictoryProfit(675000.0);
		horse.setPlaceProfit(1271000.0);
		horse.setYearProfit(710000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.PH. RAFFEGEAU"));
		horse.setOwner(owner("J. COTTEL"));
		// no rancher
		horse.setJockey(jockey("M. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 7 - BELINIERE
	 * HorseID - BELINIERE
	 */
	public static HorseID builderHorse_R8_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BELINIERE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OYONNAX");
		horseID.setMother("OGELINIERE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 7 - BELINIERE
	 */

	public static Horse builderHorse_R8_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(1983000.0);
		horse.setPreviousYearProfit(1221000.0);
		horse.setVictoryProfit(450000.0);
		horse.setPlaceProfit(1533000.0);
		horse.setYearProfit(762000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.CL. MAUCOURT"));
		horse.setOwner(owner("ECURIE FOSKALEO"));
		// no rancher
		horse.setJockey(jockey("J.CL. MAUCOURT"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 8 - BARTAVELLE
	 * HorseID - BARTAVELLE
	 */
	public static HorseID builderHorse_R8_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BARTAVELLE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("LA PERLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 8 - BARTAVELLE
	 */

	public static Horse builderHorse_R8_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H8_ID());
		horse.setNumber(8);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2028000.0);
		horse.setPreviousYearProfit(2028000.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(2028000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("E. RUAULT"));
		horse.setOwner(owner("ECURIE COMTE P. DE MONTESSON"));
		// no rancher
		horse.setJockey(jockey("F. NIVARD"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 9 - BANANA MOON
	 * HorseID - BANANA MOON
	 */
	public static HorseID builderHorse_R8_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BANANA MOON");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("NIKY");
		horseID.setMother("QUEEN STEPPA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 9 - BANANA MOON
	 */

	public static Horse builderHorse_R8_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2055000.0);
		horse.setPreviousYearProfit(96000.0);
		horse.setVictoryProfit(1665000.0);
		horse.setPlaceProfit(390000.0);
		horse.setYearProfit(1959000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("L.CL. ABRIVARD"));
		horse.setOwner(owner("ECURIE L.CL. ABRIVARD"));
		// no rancher
		horse.setJockey(jockey("A. ABRIVARD"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 10 - BOHEME DU JUILLE
	 * HorseID - BOHEME DU JUILLE
	 */
	public static HorseID builderHorse_R8_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOHEME DU JUILLE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OZIO ROYAL");
		horseID.setMother("GAMINETTE DES PRES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 10 - BOHEME DU JUILLE
	 */

	public static Horse builderHorse_R8_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2179000.0);
		horse.setPreviousYearProfit(585000.0);
		horse.setVictoryProfit(1710000.0);
		horse.setPlaceProfit(469000.0);
		horse.setYearProfit(1594000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("E. BEUDARD"));
		horse.setOwner(owner("E. BEUDARD"));
		// no rancher
		horse.setJockey(jockey("A. BARRIER"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 11 - BRISE DE MEMARTIN
	 * HorseID - BRISE DE MEMARTIN
	 */
	public static HorseID builderHorse_R8_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BRISE DE MEMARTIN");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PARIS HAUFOR");
		horseID.setMother("SISSI DE MEMARTIN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 11 - BRISE DE MEMARTIN
	 */

	public static Horse builderHorse_R8_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2416000.0);
		horse.setPreviousYearProfit(617000.0);
		horse.setVictoryProfit(1350000.0);
		horse.setPlaceProfit(1066000.0);
		horse.setYearProfit(1799000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("H. GILLES"));
		horse.setOwner(owner("H. GILLES"));
		// no rancher
		horse.setJockey(jockey("H. GILLES"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 12 - BOMINA
	 * HorseID - BOMINA
	 */
	public static HorseID builderHorse_R8_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOMINA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QUICK WOOD");
		horseID.setMother("NOMINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 12 - BOMINA
	 */

	public static Horse builderHorse_R8_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2445000.0);
		horse.setPreviousYearProfit(545000.0);
		horse.setVictoryProfit(1800000.0);
		horse.setPlaceProfit(645000.0);
		horse.setYearProfit(1900000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ANTHONY DOLLION"));
		horse.setOwner(owner("ANTHONY DOLLION"));
		// no rancher
		horse.setJockey(jockey("ANTHONY DOLLION"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 13 - BE IN LOVE
	 * HorseID - BE IN LOVE
	 */
	public static HorseID builderHorse_R8_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BE IN LOVE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("AMOUR D'AUNOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 13 - BE IN LOVE
	 */

	public static Horse builderHorse_R8_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		// no stall
		// no stable
		// no weight
		horse.setDistance(2875.0);
		horse.setCareerProfit(2449000.0);
		horse.setPreviousYearProfit(1963000.0);
		horse.setVictoryProfit(900000.0);
		horse.setPlaceProfit(1549000.0);
		horse.setYearProfit(486000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("V. RENAULT"));
		horse.setOwner(owner("R. BONNEL"));
		// no rancher
		horse.setJockey(jockey("V. RENAULT"));

		return horse;

	}

	/*
	 * Race 8
	 * Odds 1 - 13/08/2015 12:31:06 +0200
	 */

	public static Odds builderOdds_R8_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 12:31:06 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 15.8));
		simples.add(simple(odds, "2", 24.8));
		simples.add(simple(odds, "3", 14.2));
		simples.add(simple(odds, "4", 13.3));
		simples.add(simple(odds, "5", 2.5));
		simples.add(simple(odds, "6", 13.8));
		simples.add(simple(odds, "7", 27.8));
		simples.add(simple(odds, "9", 10.2));
		simples.add(simple(odds, "10", 8.7));
		simples.add(simple(odds, "11", 12.6));
		simples.add(simple(odds, "12", 8.5));
		simples.add(simple(odds, "13", 40.1));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 8
	 * Odds 2 - 13/08/2015 16:11:04 +0200
	 */

	public static Odds builderOdds_R8_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:11:04 +0200"));
		odds.setTotal(143750.69);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 48.9));
		simples.add(simple(odds, "2", 83.0));
		simples.add(simple(odds, "3", 26.1));
		simples.add(simple(odds, "4", 17.3));
		simples.add(simple(odds, "5", 1.9));
		simples.add(simple(odds, "6", 21.5));
		simples.add(simple(odds, "7", 75.8));
		simples.add(simple(odds, "9", 6.8));
		simples.add(simple(odds, "10", 11.6));
		simples.add(simple(odds, "11", 35.9));
		simples.add(simple(odds, "12", 4.6));
		simples.add(simple(odds, "13", 48.0));
		odds.setSimples(simples);

		return odds;

	}

}
