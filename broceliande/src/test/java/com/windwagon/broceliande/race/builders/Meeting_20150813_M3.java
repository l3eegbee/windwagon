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

public class Meeting_20150813_M3 extends MeetingBuilder {

	public static Meeting build() {

		Meeting meeting = new Meeting();

		meeting.setDate(parse("13/08/2015 00:00:00 +0200"));
		meeting.setRacecourse(racecourse("AVENCHES", "SUISSE"));
		meeting.setNumber(3);
		meeting.setWindSpeed(3.0);
		meeting.setWindDirection(WindDirection.SW);
		meeting.setTemperature(28.0);
		meeting.setClimat("PEU NUAGEUX");
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
	 * Race 1 - PRIX D'ECOMMOY SUISSE
	 */

	public static Race builderRace_R1(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(1);
		race.setName("PRIX D'ECOMMOY SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 16:40:00 +0200"));
		// no real start
		race.setDistance(2100.0);
		race.setBenefit(6661.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.noneOf(Type.class));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R1_O1(race));
		oddsSet.add(builderOdds_R1_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 9, 170730));
		places.add(place(race, 2, 10, 170950));
		places.add(place(race, 3, 8, 171060));
		places.add(place(race, 4, 1, 171250));
		places.add(place(race, 5, 2, 171390));
		places.add(place(race, 6, 6, 171400));
		places.add(place(race, 7, 5, 173990));
		places.add(place(race, 8, 3, 181690));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("4 7");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 1.6, "9"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.8, "8"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.2, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 5.0, "9 10"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 5.6, "9 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.8, "10 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.1, "9 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.7, "9 8"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 19.2, "9 10 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "10 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "10 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "8 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "9 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "9 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.0, "9 8"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 24.0, "9 10 8 1"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 4.8, "9 10 8 1"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 1.6, "9 10 8 1"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 1
	 * Horse 1 - OPÉRA HOUSE
	 * HorseID - OPÉRA HOUSE
	 */
	public static HorseID builderHorse_R1_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("OPÉRA HOUSE");
		horseID.setBirth(parse("01/01/2002 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("CAPRICCIO");
		horseID.setMother("FLAME EVER");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 1 - OPÉRA HOUSE
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
		horse.setDistance(2125.0);
		horse.setCareerProfit(2.13488E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(4700000.0);
		horse.setPlaceProfit(6403000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FELBER PATRICIA"));
		horse.setOwner(owner("FELBER PATRICIA"));
		// no rancher
		horse.setJockey(jockey("MME FELBER PATRICIA"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 2 - RAMSÈS GES
	 * HorseID - RAMSÈS GES
	 */
	public static HorseID builderHorse_R1_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RAMSÈS GES");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("SANCHO PANCA");
		horseID.setMother("JAKILAH");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 2 - RAMSÈS GES
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
		horse.setDistance(2125.0);
		horse.setCareerProfit(2.07527E7);
		horse.setPreviousYearProfit(1686000.0);
		horse.setVictoryProfit(1.14133E7);
		horse.setPlaceProfit(6920200.0);
		horse.setYearProfit(1205500.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("RYFFEL WERNER"));
		// no rancher
		horse.setJockey(jockey("MME THEUREAU SIMONE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 3 - PLAY BOY ESJI
	 * HorseID - PLAY BOY ESJI
	 */
	public static HorseID builderHorse_R1_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PLAY BOY ESJI");
		horseID.setBirth(parse("01/01/2003 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GOGO");
		horseID.setMother("CYBELE DE VILREAL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 3 - PLAY BOY ESJI
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
		// no stable
		// no weight
		horse.setDistance(2125.0);
		horse.setCareerProfit(1.89727E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(5232900.0);
		horse.setPlaceProfit(1.07933E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DAENZER FERNANDEZ M."));
		horse.setOwner(owner("DAENZER FERNANDEZ M."));
		// no rancher
		horse.setJockey(jockey("BASTARD J.-F."));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 4 - ROBIN DU VAL
	 * HorseID - ROBIN DU VAL
	 */
	public static HorseID builderHorse_R1_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ROBIN DU VAL");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ECLAT DE LA CRAU");
		horseID.setMother("IXIA DU VAL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 4 - ROBIN DU VAL
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
		horse.setDistance(2125.0);
		horse.setCareerProfit(1.79019E7);
		horse.setPreviousYearProfit(1034000.0);
		horse.setVictoryProfit(6150000.0);
		horse.setPlaceProfit(8916000.0);
		horse.setYearProfit(190000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KINDLER LAURENCE"));
		horse.setOwner(owner("KINDLER LAURENCE"));
		// no rancher
		horse.setJockey(jockey("MME KINDLER LAURENCE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 5 - QUÉNOR PRIOR
	 * HorseID - QUÉNOR PRIOR
	 */
	public static HorseID builderHorse_R1_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUÉNOR PRIOR");
		horseID.setBirth(parse("01/01/2004 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("TENOR DE BAUNE");
		horseID.setMother("JOVIALE PRIOR");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 5 - QUÉNOR PRIOR
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
		horse.setDistance(2125.0);
		horse.setCareerProfit(1.54289E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(5700000.0);
		horse.setPlaceProfit(6493000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BESSON PHILIPPE"));
		horse.setOwner(owner("ECURIE BESSON"));
		// no rancher
		horse.setJockey(jockey("BESSON PHILIPPE"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 6 - REBUS
	 * HorseID - REBUS
	 */
	public static HorseID builderHorse_R1_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("REBUS");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("IN LOVE WITH YOU");
		horseID.setMother("KATTNOUGA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 6 - REBUS
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
		horse.setDistance(2125.0);
		horse.setCareerProfit(1.45565E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT MARCEL"));
		horse.setOwner(owner("STALL ALLEGRA RACING CLUB"));
		// no rancher
		horse.setJockey(jockey("HUMBERT MARCEL"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 7 - ROUKY DE GOINCET
	 * HorseID - ROUKY DE GOINCET
	 */
	public static HorseID builderHorse_R1_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ROUKY DE GOINCET");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("FLASH DES SARTS");
		horseID.setMother("LILY DE GOINCET");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 7 - ROUKY DE GOINCET
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
		horse.setDistance(2100.0);
		horse.setCareerProfit(1.22791E7);
		horse.setPreviousYearProfit(665400.0);
		horse.setVictoryProfit(4765000.0);
		horse.setPlaceProfit(5507400.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FRESNEAU RAPHAËL"));
		horse.setOwner(owner("MUTTON ALDO"));
		// no rancher
		horse.setJockey(jockey("FRESNEAU RAPHAËL"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 8 - TROÏKA DE L'ABBAYE
	 * HorseID - TROÏKA DE L'ABBAYE
	 */
	public static HorseID builderHorse_R1_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TROÏKA DE L'ABBAYE");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("FLASH DE COSSE");
		horseID.setMother("IDOLE ARLETTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 8 - TROÏKA DE L'ABBAYE
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
		horse.setDistance(2100.0);
		horse.setCareerProfit(1.024E7);
		horse.setPreviousYearProfit(1601000.0);
		horse.setVictoryProfit(3510000.0);
		horse.setPlaceProfit(6002000.0);
		horse.setYearProfit(584000.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUBER MICHÈLE"));
		horse.setOwner(owner("HUBER MICHÈLE"));
		// no rancher
		horse.setJockey(jockey("BURGER ADRIAN"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 9 - UN GÉANT D'AMOUR
	 * HorseID - UN GÉANT D'AMOUR
	 */
	public static HorseID builderHorse_R1_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UN GÉANT D'AMOUR");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GOETMALS WOOD");
		horseID.setMother("IRINA DU BOURG");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 9 - UN GÉANT D'AMOUR
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
		horse.setDistance(2100.0);
		horse.setCareerProfit(9424400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MATTHEY J.-B."));
		horse.setOwner(owner("HAUSER JEAN-PIERRE"));
		// no rancher
		horse.setJockey(jockey("MATTHEY JEAN-BERNARD"));

		return horse;

	}

	/*
	 * Race 1
	 * Horse 10 - RETBUTLER
	 * HorseID - RETBUTLER
	 */
	public static HorseID builderHorse_R1_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RETBUTLER");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KENYA DU PONT");
		horseID.setMother("IMA DU HOUX");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.NOIR);

		return horseID;

	}


	/*
	 * Race 1
	 * Horse 10 - RETBUTLER
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
		horse.setDistance(2100.0);
		horse.setCareerProfit(8097800.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(2560000.0);
		horse.setPlaceProfit(2526000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("THEUREAU LUDOVIC"));
		horse.setOwner(owner("ECURIE MAX GORDON"));
		// no rancher
		horse.setJockey(jockey("THEUREAU LUDOVIC"));

		return horse;

	}

	/*
	 * Race 1
	 * Odds 1 - 13/08/2015 14:41:35 +0200
	 */

	public static Odds builderOdds_R1_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:41:35 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 13.6));
		simples.add(simple(odds, "2", 33.4));
		simples.add(simple(odds, "3", 70.1));
		simples.add(simple(odds, "4", 8.6));
		simples.add(simple(odds, "5", 101.6));
		simples.add(simple(odds, "6", 18.9));
		simples.add(simple(odds, "7", 29.8));
		simples.add(simple(odds, "8", 31.0));
		simples.add(simple(odds, "9", 1.2));
		simples.add(simple(odds, "10", 46.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 1
	 * Odds 2 - 13/08/2015 16:42:32 +0200
	 */

	public static Odds builderOdds_R1_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:42:32 +0200"));
		odds.setTotal(85279.86);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 9.8));
		simples.add(simple(odds, "2", 21.0));
		simples.add(simple(odds, "3", 72.3));
		simples.add(simple(odds, "4", 18.3));
		simples.add(simple(odds, "5", 78.3));
		simples.add(simple(odds, "6", 7.9));
		simples.add(simple(odds, "7", 29.5));
		simples.add(simple(odds, "8", 9.5));
		simples.add(simple(odds, "9", 1.6));
		simples.add(simple(odds, "10", 10.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 2 - TROPHEE VERT SUISSE
	 */

	public static Race builderRace_R2(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(2);
		race.setName("TROPHEE VERT SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 17:10:00 +0200"));
		// no real start
		race.setDistance(2000.0);
		race.setBenefit(12489.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.AUTOSTART));

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
		horses.add(builderHorse_R2_H14(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX, BetType.MULTI_EN_SEPT));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R2_O1(race));
		oddsSet.add(builderOdds_R2_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 13, 154930));
		places.add(place(race, 2, 14, 154990));
		places.add(place(race, 3, 3, 155000));
		places.add(place(race, 4, 8, 155380));
		places.add(place(race, 5, 12, 155610));
		places.add(place(race, 6, 10, 155850));
		places.add(place(race, 7, 11, 156150));
		places.add(place(race, 8, 1, 156300));
		places.add(place(race, 9, 4, 156520));
		places.add(place(race, 10, 9, 157520));
		places.add(place(race, 11, 2, 158620));
		places.add(place(race, 12, 7, 172730));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("5");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 26.1, "13"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.3, "13"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "14"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "3"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 0.0, "13"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 80.5, "13 14"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 0.0, "13"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 23.5, "13 14"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "13"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.2, "13 14"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 14.1, "13 3"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "14"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.4, "14 3"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 0.0, "3"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 0.0, "13 14"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 44.0, "13 14 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "13 14"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "13 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "13 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "14 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "14 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.0, "3 8"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 115.5, "13 14 3 8"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 23.1, "13 14 3 8"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 7.7, "13 14 3 8"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 3.3, "13 14 3 8"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 2
	 * Horse 1 - TIGER DE GINAI
	 * HorseID - TIGER DE GINAI
	 */
	public static HorseID builderHorse_R2_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TIGER DE GINAI");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("CARPE DIEM");
		horseID.setMother("NYMPHE DE GINAI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 1 - TIGER DE GINAI
	 */

	public static Horse builderHorse_R2_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2.40936E7);
		horse.setPreviousYearProfit(4791000.0);
		horse.setVictoryProfit(1.341E7);
		horse.setPlaceProfit(9138900.0);
		horse.setYearProfit(875900.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FELBER PATRICIA"));
		horse.setOwner(owner("PAVONE CARLO"));
		// no rancher
		horse.setJockey(jockey("BRACHER HEINER"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 2 - SISKA DE L'ETANG
	 * HorseID - SISKA DE L'ETANG
	 */
	public static HorseID builderHorse_R2_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SISKA DE L'ETANG");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SANCHO PANCA");
		horseID.setMother("HAVANE DE LOIRE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 2 - SISKA DE L'ETANG
	 */

	public static Horse builderHorse_R2_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(8489400.0);
		horse.setPreviousYearProfit(1432000.0);
		horse.setVictoryProfit(2689600.0);
		horse.setPlaceProfit(5391400.0);
		horse.setYearProfit(1323000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MARASCO DAVID"));
		horse.setOwner(owner("MARASCO DAVID"));
		// no rancher
		horse.setJockey(jockey("MARASCO DAVID"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 3 - PADOLIN
	 * HorseID - PADOLIN
	 */
	public static HorseID builderHorse_R2_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PADOLIN");
		horseID.setBirth(parse("01/01/2003 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GIANT CAT");
		horseID.setMother("ADOLINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 3 - PADOLIN
	 */

	public static Horse builderHorse_R2_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3.27986E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1.16E7);
		horse.setPlaceProfit(1.0659E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("MÜLLER ROLAND"));
		// no rancher
		horse.setJockey(jockey("BOVAY MARC-ANDRÉ"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 4 - RÊVE DE COEUR
	 * HorseID - RÊVE DE COEUR
	 */
	public static HorseID builderHorse_R2_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RÊVE DE COEUR");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("KIWI");
		horseID.setMother("FINE PERLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 4 - RÊVE DE COEUR
	 */

	public static Horse builderHorse_R2_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2.31202E7);
		horse.setPreviousYearProfit(437700.0);
		horse.setVictoryProfit(8811900.0);
		horse.setPlaceProfit(9680400.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DAVET JOSÉ"));
		horse.setOwner(owner("DAVET JOSÉ"));
		// no rancher
		horse.setJockey(jockey("DAVET JOSÉ"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 5 - QUODIAK
	 * HorseID - QUODIAK
	 */
	public static HorseID builderHorse_R2_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUODIAK");
		horseID.setBirth(parse("01/01/2004 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LOVE YOU");
		horseID.setMother("GRIVE DE VIRE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 5 - QUODIAK
	 */

	public static Horse builderHorse_R2_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2.79736E7);
		horse.setPreviousYearProfit(2422000.0);
		horse.setVictoryProfit(1.61E7);
		horse.setPlaceProfit(8682000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT MARCEL"));
		horse.setOwner(owner("STALL ALLEGRA RACING CLUB"));
		// no rancher
		horse.setJockey(jockey("HUMBERT MARCEL"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 6 - MAÎTRE DE LA PISTE
	 * HorseID - MAÎTRE DE LA PISTE
	 */
	public static HorseID builderHorse_R2_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MAÎTRE DE LA PISTE");
		horseID.setBirth(parse("01/01/2000 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUITO DE TALONAY");
		horseID.setMother("PARISSIA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 6 - MAÎTRE DE LA PISTE
	 */

	public static Horse builderHorse_R2_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H6_ID());
		horse.setNumber(6);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3.2197E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1.335E7);
		horse.setPlaceProfit(4743000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHNER J.-F."));
		horse.setOwner(owner("JOHNER JEAN-FRANÇOIS"));
		// no rancher
		horse.setJockey(jockey("NON PARTANT"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 7 - RUBIS DE LA PORTE
	 * HorseID - RUBIS DE LA PORTE
	 */
	public static HorseID builderHorse_R2_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RUBIS DE LA PORTE");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HAND DU VIVIER");
		horseID.setMother("HAKARINA PRAIL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 7 - RUBIS DE LA PORTE
	 */

	public static Horse builderHorse_R2_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3.02651E7);
		horse.setPreviousYearProfit(5405500.0);
		horse.setVictoryProfit(1.06E7);
		horse.setPlaceProfit(1.57965E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JURIENS PIERRE-A."));
		horse.setOwner(owner("ECURIE P.-A. JURIENS"));
		// no rancher
		horse.setJockey(jockey("FRESNEAU RAPHAËL"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 8 - TSAR D'ACANTHE
	 * HorseID - TSAR D'ACANTHE
	 */
	public static HorseID builderHorse_R2_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TSAR D'ACANTHE");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BIESOLO");
		horseID.setMother("FEERIE DE L'ITON");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 8 - TSAR D'ACANTHE
	 */

	public static Horse builderHorse_R2_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2.4169E7);
		horse.setPreviousYearProfit(6518000.0);
		horse.setVictoryProfit(1.015E7);
		horse.setPlaceProfit(1.2235E7);
		horse.setYearProfit(22000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("SCHNEIDER PASCAL"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 9 - NÉGOTIANS D'ORTIGE
	 * HorseID - NÉGOTIANS D'ORTIGE
	 */
	public static HorseID builderHorse_R2_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("NÉGOTIANS D'ORTIGE");
		horseID.setBirth(parse("01/01/2001 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GIANT CAT");
		horseID.setMother("ETOILE DE GINAI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 9 - NÉGOTIANS D'ORTIGE
	 */

	public static Horse builderHorse_R2_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(6.9857E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(3.615E7);
		horse.setPlaceProfit(1.5075E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FELBER PATRICIA"));
		horse.setOwner(owner("FELBER PATRICIA"));
		// no rancher
		horse.setJockey(jockey("MME FELBER PATRICIA"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 10 - SERGENT DU RIB
	 * HorseID - SERGENT DU RIB
	 */
	public static HorseID builderHorse_R2_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SERGENT DU RIB");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BACCARAT DU PONT");
		horseID.setMother("HERMINE DU RIB");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 10 - SERGENT DU RIB
	 */

	public static Horse builderHorse_R2_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(10);
		horse.setStable("A");
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3.4432E7);
		horse.setPreviousYearProfit(6688000.0);
		horse.setVictoryProfit(1.66E7);
		horse.setPlaceProfit(1.57055E7);
		horse.setYearProfit(385500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PERRIN BERNARD"));
		horse.setOwner(owner("PERRIN BERNARD"));
		// no rancher
		horse.setJockey(jockey("GARDAZ JEAN-CLAUDE"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 11 - RACING CHARM
	 * HorseID - RACING CHARM
	 */
	public static HorseID builderHorse_R2_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RACING CHARM");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("LOVE YOU");
		horseID.setMother("FERAINE D'OCCAGNES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN_BRULE);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 11 - RACING CHARM
	 */

	public static Horse builderHorse_R2_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(11);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3.92627E7);
		horse.setPreviousYearProfit(1970400.0);
		horse.setVictoryProfit(2.91551E7);
		horse.setPlaceProfit(7386300.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("THEUREAU LUDOVIC"));
		horse.setOwner(owner("KÜMIN KATRIN"));
		// no rancher
		horse.setJockey(jockey("THEUREAU LUDOVIC"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 12 - SWING D'ERONVILLE
	 * HorseID - SWING D'ERONVILLE
	 */
	public static HorseID builderHorse_R2_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SWING D'ERONVILLE");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JAG DE BELLOUET");
		horseID.setMother("LUCIE D'ERONVILLE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 12 - SWING D'ERONVILLE
	 */

	public static Horse builderHorse_R2_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(12);
		horse.setStable("A");
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(4.00946E7);
		horse.setPreviousYearProfit(4469000.0);
		horse.setVictoryProfit(2.6785E7);
		horse.setPlaceProfit(1.0231E7);
		horse.setYearProfit(3135000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PERRIN BERNARD"));
		horse.setOwner(owner("PERRIN BERNARD"));
		// no rancher
		horse.setJockey(jockey("JURIENS JACQUES"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 13 - PODIUM DU RIB
	 * HorseID - PODIUM DU RIB
	 */
	public static HorseID builderHorse_R2_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PODIUM DU RIB");
		horseID.setBirth(parse("01/01/2003 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("GIANT CAT");
		horseID.setMother("GALLIA DE VANDEL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 13 - PODIUM DU RIB
	 */

	public static Horse builderHorse_R2_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(13);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(5.01285E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(2.3125E7);
		horse.setPlaceProfit(1.6963E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("AEBISCHER RENÉ"));
		horse.setOwner(owner("ECURIE RHYTHM & BLUES"));
		// no rancher
		horse.setJockey(jockey("MME AEBISCHER BARBARA"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 14 - PLUTO DU VIVIER
	 * HorseID - PLUTO DU VIVIER
	 */
	public static HorseID builderHorse_R2_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PLUTO DU VIVIER");
		horseID.setBirth(parse("01/01/2003 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("EXTREME DREAM");
		horseID.setMother("IGUINE DU VIVIER");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 14 - PLUTO DU VIVIER
	 */

	public static Horse builderHorse_R2_H14(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H14_ID());
		horse.setNumber(14);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(14);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(1.02267E8);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(7.375E7);
		horse.setPlaceProfit(1.0092E7);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("HENRY VALÉRIE"));
		// no rancher
		horse.setJockey(jockey("MME HENRY VALÉRIE"));

		return horse;

	}

	/*
	 * Race 2
	 * Odds 1 - 13/08/2015 14:42:05 +0200
	 */

	public static Odds builderOdds_R2_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:42:05 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 35.4));
		simples.add(simple(odds, "2", 9.6));
		simples.add(simple(odds, "3", 8.1));
		simples.add(simple(odds, "4", 52.9));
		simples.add(simple(odds, "5", 28.9));
		simples.add(simple(odds, "7", 43.1));
		simples.add(simple(odds, "8", 26.8));
		simples.add(simple(odds, "9", 31.7));
		simples.add(simple(odds, "10", 8.7));
		simples.add(simple(odds, "11", 45.2));
		simples.add(simple(odds, "12", 15.3));
		simples.add(simple(odds, "13", 16.2));
		simples.add(simple(odds, "14", 1.9));
		simples.add(simple(odds, "A", 5.5));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 2
	 * Odds 2 - 13/08/2015 17:12:13 +0200
	 */

	public static Odds builderOdds_R2_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 17:12:13 +0200"));
		odds.setTotal(86875.15);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 46.1));
		simples.add(simple(odds, "2", 13.5));
		simples.add(simple(odds, "3", 4.0));
		simples.add(simple(odds, "4", 70.6));
		simples.add(simple(odds, "5", 29.7));
		simples.add(simple(odds, "7", 58.9));
		simples.add(simple(odds, "8", 15.4));
		simples.add(simple(odds, "9", 10.7));
		simples.add(simple(odds, "10", 16.2));
		simples.add(simple(odds, "11", 59.9));
		simples.add(simple(odds, "12", 6.5));
		simples.add(simple(odds, "13", 26.1));
		simples.add(simple(odds, "14", 2.8));
		simples.add(simple(odds, "A", 4.6));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3 - PRIX DES SABLES-D'OLONNE SUISSE
	 */

	public static Race builderRace_R3(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(3);
		race.setName("PRIX DES SABLES-D'OLONNE SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 17:40:00 +0200"));
		// no real start
		race.setDistance(2400.0);
		race.setBenefit(6661.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.noneOf(Type.class));

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
		places.add(place(race, 1, 8, 188750));
		places.add(place(race, 2, 11, 188950));
		places.add(place(race, 3, 3, 189230));
		places.add(place(race, 4, 5, 189740));
		places.add(place(race, 5, 13, 190080));
		places.add(place(race, 6, 1, 190220));
		places.add(place(race, 7, 2, 190540));
		places.add(place(race, 8, 9, 190590));
		places.add(place(race, 9, 7, 192650));
		places.add(place(race, 10, 6, 192800));
		places.add(place(race, 11, 10, 192950));
		places.add(place(race, 12, 14, 193130));
		race.setPlaces(places);

		race.setStopped("12");
		race.setDisqualified("4");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 41.5, "8"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 5.5, "11"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 4.5, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 7.7, "8"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 629.1, "8 11"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 225.7, "8 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 25.7, "11 3"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 54.7, "8 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 47.6, "8 3"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 428.1, "8 11 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "11 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "11 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "3 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "8 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "8 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 20.5, "8 5"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 955.5, "8 11 3 5"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 191.1, "8 11 3 5"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 63.7, "8 11 3 5"));
		prices.add(price(race, BetType.MULTI_EN_SEPT, PriceName.DIRECT, 27.3, "8 11 3 5"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 3
	 * Horse 1 - BONATTELA
	 * HorseID - BONATTELA
	 */
	public static HorseID builderHorse_R3_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BONATTELA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OTELLO PIERJI");
		horseID.setMother("JULIA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 1 - BONATTELA
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
		horse.setDistance(2425.0);
		horse.setCareerProfit(1301100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("NUNES DE OLIVEIRA V."));
		horse.setOwner(owner("ECURIE TURRETTINI"));
		// no rancher
		horse.setJockey(jockey("TURRETTINI HENRI"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 2 - BOY DES CHAUMES
	 * HorseID - BOY DES CHAUMES
	 */
	public static HorseID builderHorse_R3_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOY DES CHAUMES");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("BUVETIER D'AUNOU");
		horseID.setMother("OHLA WOOD");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 2 - BOY DES CHAUMES
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
		horse.setDistance(2425.0);
		horse.setCareerProfit(1265500.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("BOVAY MYRIAM"));
		// no rancher
		horse.setJockey(jockey("BOVAY MARC-ANDRÉ"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 3 - SHERIDAN BI
	 * HorseID - SHERIDAN BI
	 */
	public static HorseID builderHorse_R3_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SHERIDAN BI");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("OTELLO PIERJI");
		horseID.setMother("JULIA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 3 - SHERIDAN BI
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(636100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("MARLON SAGL"));
		// no rancher
		horse.setJockey(jockey("FERRO LORIS"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 4 - BETHOVEN DU MARTZA
	 * HorseID - BETHOVEN DU MARTZA
	 */
	public static HorseID builderHorse_R3_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BETHOVEN DU MARTZA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("IN LOVE WITH YOU");
		horseID.setMother("MATTMARA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 4 - BETHOVEN DU MARTZA
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(585300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PUJOL RENAUD"));
		horse.setOwner(owner("ECURIE DU MARTZA SÀRL"));
		// no rancher
		horse.setJockey(jockey("QUATREUIL FRANCK"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 5 - BANDERAS
	 * HorseID - BANDERAS
	 */
	public static HorseID builderHorse_R3_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BANDERAS");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("POWER JET");
		horseID.setMother("RISE AND SHINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 5 - BANDERAS
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(553600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BURGER ADRIAN"));
		horse.setOwner(owner("STALL NYBURG"));
		// no rancher
		horse.setJockey(jockey("BURGER ADRIAN"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 6 - BERENICE
	 * HorseID - BERENICE
	 */
	public static HorseID builderHorse_R3_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BERENICE");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QWERTY");
		horseID.setMother("SENORA DE LOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 6 - BERENICE
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(537800.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(284700.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(284700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PUJOL RENAUD"));
		horse.setOwner(owner("BLÖCHLIGER MARTINA"));
		// no rancher
		horse.setJockey(jockey("EGLI MARGAUX"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 7 - JUSTINA
	 * HorseID - JUSTINA
	 */
	public static HorseID builderHorse_R3_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("JUSTINA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		// no father
		// no mother
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 7 - JUSTINA
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(388400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(63300.0);
		horse.setYearProfit(63300.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("WELTI MARC"));
		horse.setOwner(owner("WELTI MARC"));
		// no rancher
		horse.setJockey(jockey("WELTI MARC"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 8 - SCUSE ME BI
	 * HorseID - SCUSE ME BI
	 */
	public static HorseID builderHorse_R3_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SCUSE ME BI");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("POWER JET");
		horseID.setMother("RISE AND SHINE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 8 - SCUSE ME BI
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(347600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("PITTET CÉDRIC"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 9 - BÉRÉNICE DU SOLEIL
	 * HorseID - BÉRÉNICE DU SOLEIL
	 */
	public static HorseID builderHorse_R3_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BÉRÉNICE DU SOLEIL");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QWERTY");
		horseID.setMother("SENORA DE LOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 9 - BÉRÉNICE DU SOLEIL
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(221400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(142400.0);
		horse.setYearProfit(142400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CONSOLE ANNE-MARIE"));
		horse.setOwner(owner("ECURIE DU SOLEIL"));
		// no rancher
		horse.setJockey(jockey("MME CONSOLE ANNE-MARIE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 10 - BINGO DU MOULIN
	 * HorseID - BINGO DU MOULIN
	 */
	public static HorseID builderHorse_R3_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BINGO DU MOULIN");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QWERTY");
		horseID.setMother("SENORA DE LOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 10 - BINGO DU MOULIN
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(166100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(31600.0);
		horse.setYearProfit(31600.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PERRIN RÉMY"));
		horse.setOwner(owner("PERRIN RÉMY"));
		// no rancher
		horse.setJockey(jockey("PERRIN RÉMY"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 11 - BONITA WAY
	 * HorseID - BONITA WAY
	 */
	public static HorseID builderHorse_R3_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BONITA WAY");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QWERTY");
		horseID.setMother("SENORA DE LOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 11 - BONITA WAY
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(158100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(94900.0);
		horse.setYearProfit(94900.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("VULLIAMY CHRISTOPHE"));
		horse.setOwner(owner("LACIGA PAUL"));
		// no rancher
		horse.setJockey(jockey("VULLIAMY CHRISTOPHE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 12 - BABOUCHKA MIA
	 * HorseID - BABOUCHKA MIA
	 */
	public static HorseID builderHorse_R3_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BABOUCHKA MIA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("LOOK DE STAR");
		horseID.setMother("OPALINE DES ANGES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 12 - BABOUCHKA MIA
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(112700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HILTEBRAND PAMINA"));
		horse.setOwner(owner("HILTEBRAND PAMINA"));
		// no rancher
		horse.setJockey(jockey("MME HILTEBRAND PAMINA"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 13 - BRUME DU COPY
	 * HorseID - BRUME DU COPY
	 */
	public static HorseID builderHorse_R3_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BRUME DU COPY");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("IN LOVE WITH YOU");
		horseID.setMother("MATTMARA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 13 - BRUME DU COPY
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(47400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BESSON PHILIPPE"));
		horse.setOwner(owner("ECURIE BESSON"));
		// no rancher
		horse.setJockey(jockey("BESSON PHILIPPE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 14 - BELLADONA DU THOT
	 * HorseID - BELLADONA DU THOT
	 */
	public static HorseID builderHorse_R3_H14_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BELLADONA DU THOT");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("NIKY");
		horseID.setMother("KIMIE KISS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 14 - BELLADONA DU THOT
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(15800.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("THEUREAU LUDOVIC"));
		horse.setOwner(owner("ECURIE MAX GORDON"));
		// no rancher
		horse.setJockey(jockey("THEUREAU LUDOVIC"));

		return horse;

	}

	/*
	 * Race 3
	 * Odds 1 - 13/08/2015 14:42:06 +0200
	 */

	public static Odds builderOdds_R3_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:42:06 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 5.0));
		simples.add(simple(odds, "2", 8.8));
		simples.add(simple(odds, "3", 7.7));
		simples.add(simple(odds, "4", 6.4));
		simples.add(simple(odds, "5", 11.2));
		simples.add(simple(odds, "6", 13.4));
		simples.add(simple(odds, "7", 21.1));
		simples.add(simple(odds, "8", 33.5));
		simples.add(simple(odds, "9", 18.5));
		simples.add(simple(odds, "10", 22.0));
		simples.add(simple(odds, "11", 9.3));
		simples.add(simple(odds, "12", 30.6));
		simples.add(simple(odds, "13", 12.8));
		simples.add(simple(odds, "14", 32.0));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3
	 * Odds 2 - 13/08/2015 17:43:19 +0200
	 */

	public static Odds builderOdds_R3_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 17:43:19 +0200"));
		odds.setTotal(88541.64);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 2.7));
		simples.add(simple(odds, "2", 6.7));
		simples.add(simple(odds, "3", 11.6));
		simples.add(simple(odds, "4", 4.9));
		simples.add(simple(odds, "5", 10.2));
		simples.add(simple(odds, "6", 13.2));
		simples.add(simple(odds, "7", 21.2));
		simples.add(simple(odds, "8", 41.5));
		simples.add(simple(odds, "9", 44.0));
		simples.add(simple(odds, "10", 55.4));
		simples.add(simple(odds, "11", 17.7));
		simples.add(simple(odds, "12", 71.8));
		simples.add(simple(odds, "13", 41.4));
		simples.add(simple(odds, "14", 85.8));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4 - PRIX DE PORNICHET SUISSE
	 */

	public static Race builderRace_R4(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(4);
		race.setName("PRIX DE PORNICHET SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 18:40:00 +0200"));
		// no real start
		race.setDistance(2350.0);
		race.setBenefit(6661.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.AUTOSTART));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R4_O1(race));
		oddsSet.add(builderOdds_R4_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 3, 186710));
		places.add(place(race, 2, 9, 186760));
		places.add(place(race, 3, 10, 186910));
		places.add(place(race, 4, 5, 187000));
		places.add(place(race, 5, 7, 187140));
		places.add(place(race, 6, 4, 187370));
		places.add(place(race, 7, 1, 189450));
		places.add(place(race, 8, 2, 190060));
		places.add(place(race, 9, 8, 190110));
		places.add(place(race, 10, 6, 192160));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.4, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.3, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 28.2, "3 9"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 11.2, "3 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.2, "3 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.6, "3 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.6, "9 10"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 50.8, "3 9 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "10 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "3 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "3 5"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "3 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "9 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.1, "9 5"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 30.0, "3 9 10 5"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 6.0, "3 9 10 5"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 2.0, "3 9 10 5"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 4
	 * Horse 1 - TSAR ROSE
	 * HorseID - TSAR ROSE
	 */
	public static HorseID builderHorse_R4_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TSAR ROSE");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ISPALION JARZEEN");
		horseID.setMother("DELIA DE LAUNAY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 1 - TSAR ROSE
	 */

	public static Horse builderHorse_R4_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		horse.setStable("A");
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(5685200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("VULLIAMY CHRISTOPHE"));
		horse.setOwner(owner("VULLIAMY CHRISTOPHE"));
		// no rancher
		horse.setJockey(jockey("VULLIAMY CHRISTOPHE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 2 - ROMÉO DU HOUSSEL
	 * HorseID - ROMÉO DU HOUSSEL
	 */
	public static HorseID builderHorse_R4_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ROMÉO DU HOUSSEL");
		horseID.setBirth(parse("01/01/2005 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HASTING");
		horseID.setMother("HOULBA DES ANDIERS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 2 - ROMÉO DU HOUSSEL
	 */

	public static Horse builderHorse_R4_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(7776100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1550000.0);
		horse.setPlaceProfit(3377500.0);
		horse.setYearProfit(126500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FRESNEAU RAPHAËL"));
		horse.setOwner(owner("MEYSTRE SUSANNE"));
		// no rancher
		horse.setJockey(jockey("FRESNEAU RAPHAËL"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 3 - UNUBU
	 * HorseID - UNUBU
	 */
	public static HorseID builderHorse_R4_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UNUBU");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("FANACLAND");
		horseID.setMother("OURGA DE MAI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 3 - UNUBU
	 */

	public static Horse builderHorse_R4_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(7295900.0);
		horse.setPreviousYearProfit(1413000.0);
		horse.setVictoryProfit(2922500.0);
		horse.setPlaceProfit(3278500.0);
		horse.setYearProfit(90000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MATTHEY J.-B."));
		horse.setOwner(owner("BERKE CLAUDIA"));
		// no rancher
		horse.setJockey(jockey("MATTHEY JEAN-BERNARD"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 4 - TAINAC
	 * HorseID - TAINAC
	 */
	public static HorseID builderHorse_R4_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TAINAC");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MODERN JAZZ");
		horseID.setMother("KLADINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 4 - TAINAC
	 */

	public static Horse builderHorse_R4_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(6702000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1050000.0);
		horse.setPlaceProfit(2739300.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PUJOL RENAUD"));
		horse.setOwner(owner("SCHNEIDER-AEBISCHER V."));
		// no rancher
		horse.setJockey(jockey("QUATREUIL FRANCK"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 5 - SILLÉNIUM PALACE
	 * HorseID - SILLÉNIUM PALACE
	 */
	public static HorseID builderHorse_R4_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SILLÉNIUM PALACE");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MILLENIUM WOOD");
		horseID.setMother("KALISTA CASTELETS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 5 - SILLÉNIUM PALACE
	 */

	public static Horse builderHorse_R4_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(6888300.0);
		horse.setPreviousYearProfit(1447000.0);
		horse.setVictoryProfit(2000000.0);
		horse.setPlaceProfit(3778000.0);
		horse.setYearProfit(275000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("TSCHUDIN HANS"));
		horse.setOwner(owner("TSCHUDIN HANS"));
		// no rancher
		horse.setJockey(jockey("BURGER ADRIAN"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 6 - PAN'S WILLIAMS
	 * HorseID - PAN'S WILLIAMS
	 */
	public static HorseID builderHorse_R4_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PAN'S WILLIAMS");
		horseID.setBirth(parse("01/01/2003 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DERBY DU GITE");
		horseID.setMother("JAN'S WILLIAMS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 6 - PAN'S WILLIAMS
	 */

	public static Horse builderHorse_R4_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(6941200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(2550000.0);
		horse.setPlaceProfit(2498000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KRÜSI BARBARA"));
		horse.setOwner(owner("KRÜSI BARBARA"));
		// no rancher
		horse.setJockey(jockey("MME KRÜSI BARBARA"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 7 - TINTO WAY
	 * HorseID - TINTO WAY
	 */
	public static HorseID builderHorse_R4_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TINTO WAY");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HULK DES CHAMPS");
		horseID.setMother("IDEE DU GILET");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 7 - TINTO WAY
	 */

	public static Horse builderHorse_R4_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		horse.setStable("A");
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(5562500.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("VULLIAMY CHRISTOPHE"));
		horse.setOwner(owner("VULLIAMY CHRISTOPHE"));
		// no rancher
		horse.setJockey(jockey("KOCHER JAN"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 8 - SACASSOU
	 * HorseID - SACASSOU
	 */
	public static HorseID builderHorse_R4_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SACASSOU");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JOE L'AMOROSO");
		horseID.setMother("LISELOTTE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 8 - SACASSOU
	 */

	public static Horse builderHorse_R4_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(7891100.0);
		horse.setPreviousYearProfit(582000.0);
		horse.setVictoryProfit(3150000.0);
		horse.setPlaceProfit(3957000.0);
		horse.setYearProfit(407000.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("SCHNEIDER PASCAL"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 9 - URIEL DE SAUSSAIE
	 * HorseID - URIEL DE SAUSSAIE
	 */
	public static HorseID builderHorse_R4_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("URIEL DE SAUSSAIE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		// no father
		// no mother
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 9 - URIEL DE SAUSSAIE
	 */

	public static Horse builderHorse_R4_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(6098700.0);
		horse.setPreviousYearProfit(3446500.0);
		horse.setVictoryProfit(3290700.0);
		horse.setPlaceProfit(1560300.0);
		horse.setYearProfit(39500.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("HENRY VALÉRIE"));
		// no rancher
		horse.setJockey(jockey("MME HENRY VALÉRIE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 10 - VALCOURT
	 * HorseID - VALCOURT
	 */
	public static HorseID builderHorse_R4_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VALCOURT");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("QUATRE JUILLET");
		horseID.setMother("DARLING DU ROCHER");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 10 - VALCOURT
	 */

	public static Horse builderHorse_R4_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(10);
		// no stable
		// no weight
		horse.setDistance(2350.0);
		horse.setCareerProfit(7862900.0);
		horse.setPreviousYearProfit(2256600.0);
		horse.setVictoryProfit(4863400.0);
		horse.setPlaceProfit(2829500.0);
		horse.setYearProfit(627200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("DAMBACH GÉRALD"));
		// no rancher
		horse.setJockey(jockey("BOVAY MARC-ANDRÉ"));

		return horse;

	}

	/*
	 * Race 4
	 * Odds 1 - 13/08/2015 14:41:53 +0200
	 */

	public static Odds builderOdds_R4_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:41:53 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 10.3));
		simples.add(simple(odds, "2", 20.5));
		simples.add(simple(odds, "3", 12.8));
		simples.add(simple(odds, "4", 11.8));
		simples.add(simple(odds, "5", 4.5));
		simples.add(simple(odds, "6", 30.7));
		simples.add(simple(odds, "7", 3.0));
		simples.add(simple(odds, "8", 20.0));
		simples.add(simple(odds, "9", 5.0));
		simples.add(simple(odds, "10", 19.7));
		simples.add(simple(odds, "A", 2.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4
	 * Odds 2 - 13/08/2015 18:42:15 +0200
	 */

	public static Odds builderOdds_R4_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 18:42:15 +0200"));
		odds.setTotal(91262.34);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 22.7));
		simples.add(simple(odds, "2", 26.9));
		simples.add(simple(odds, "3", 6.4));
		simples.add(simple(odds, "4", 16.4));
		simples.add(simple(odds, "5", 4.0));
		simples.add(simple(odds, "6", 39.5));
		simples.add(simple(odds, "7", 4.0));
		simples.add(simple(odds, "8", 16.8));
		simples.add(simple(odds, "9", 4.2));
		simples.add(simple(odds, "10", 14.4));
		simples.add(simple(odds, "A", 3.4));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5 - PRIX DE CORDEMAIS SUISSE
	 */

	public static Race builderRace_R5(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(5);
		race.setName("PRIX DE CORDEMAIS SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 19:10:00 +0200"));
		// no real start
		race.setDistance(2400.0);
		race.setBenefit(6661.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R5_O1(race));
		oddsSet.add(builderOdds_R5_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 7, 192140));
		places.add(place(race, 2, 1, 192150));
		places.add(place(race, 3, 10, 193160));
		places.add(place(race, 4, 9, 193930));
		places.add(place(race, 5, 2, 194640));
		places.add(place(race, 6, 3, 196300));
		places.add(place(race, 7, 6, 200730));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("4 5 8");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 22.6, "7"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "1"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "7"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 232.7, "7 1"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 83.2, "7 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.1, "1 10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 23.4, "7 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 15.9, "7 10"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 126.1, "7 1 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "1 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "1 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "10 9"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "7 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "7 10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 2.7, "7 9"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 103.5, "7 1 10 9"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 20.7, "7 1 10 9"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 6.9, "7 1 10 9"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 5
	 * Horse 1 - ULYSSE HUCHETIÈRE
	 * HorseID - ULYSSE HUCHETIÈRE
	 */
	public static HorseID builderHorse_R5_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ULYSSE HUCHETIÈRE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ISPALION JARZEEN");
		horseID.setMother("DELIA DE LAUNAY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 1 - ULYSSE HUCHETIÈRE
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
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(3652600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(1193000.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FRESNEAU RAPHAËL"));
		horse.setOwner(owner("ECURIE DIAMOND"));
		// no rancher
		horse.setJockey(jockey("FRESNEAU RAPHAËL"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 2 - VIGO DU VERGER
	 * HorseID - VIGO DU VERGER
	 */
	public static HorseID builderHorse_R5_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIGO DU VERGER");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("IN FOOT");
		horseID.setMother("KALINDARA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 2 - VIGO DU VERGER
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
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(3500000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MATTHEY J.-B."));
		horse.setOwner(owner("MATTHEY JEAN-BERNARD"));
		// no rancher
		horse.setJockey(jockey("MATTHEY JEAN-BERNARD"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 3 - ANTOINE
	 * HorseID - ANTOINE
	 */
	public static HorseID builderHorse_R5_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ANTOINE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LOVE YOU");
		horseID.setMother("QUINTINA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 3 - ANTOINE
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
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(3488700.0);
		horse.setPreviousYearProfit(291700.0);
		horse.setVictoryProfit(1824700.0);
		horse.setPlaceProfit(1069100.0);
		horse.setYearProfit(284700.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("DAMBACH GÉRALD"));
		// no rancher
		horse.setJockey(jockey("BOVAY MARC-ANDRÉ"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 4 - PEPPERMINT DVM
	 * HorseID - PEPPERMINT DVM
	 */
	public static HorseID builderHorse_R5_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PEPPERMINT DVM");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("LUTIN MALIN");
		horseID.setMother("JANNETTE BOUM");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 4 - PEPPERMINT DVM
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
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(3181600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DESSAULES FRANCIS"));
		horse.setOwner(owner("DESSAULES FRANCIS"));
		// no rancher
		horse.setJockey(jockey("FERRO LORIS"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 5 - UNA FIGHTER
	 * HorseID - UNA FIGHTER
	 */
	public static HorseID builderHorse_R5_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UNA FIGHTER");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OPIUM");
		horseID.setMother("KIMIE KISS");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 5 - UNA FIGHTER
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
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(2483700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT ANDRÉ"));
		horse.setOwner(owner("HUMBERT ANDRÉ"));
		// no rancher
		horse.setJockey(jockey("HUMBERT ANDRÉ"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 6 - SUPER LOVE BOY
	 * HorseID - SUPER LOVE BOY
	 */
	public static HorseID builderHorse_R5_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SUPER LOVE BOY");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("PAD D'URZY");
		horseID.setMother("POLKA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 6 - SUPER LOVE BOY
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
		horse.setStable("A");
		// no weight
		horse.setDistance(2425.0);
		horse.setCareerProfit(1912000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("SCHNEIDER PASCAL"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 7 - AVRIL PECCAU
	 * HorseID - AVRIL PECCAU
	 */
	public static HorseID builderHorse_R5_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AVRIL PECCAU");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("KALLIGHAN");
		horseID.setMother("MORGANE D'YVEL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 7 - AVRIL PECCAU
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
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(1822300.0);
		horse.setPreviousYearProfit(1005600.0);
		horse.setVictoryProfit(900000.0);
		horse.setPlaceProfit(905500.0);
		horse.setYearProfit(799900.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHNER J.-F."));
		horse.setOwner(owner("JOHNER JEAN-FRANÇOIS"));
		// no rancher
		horse.setJockey(jockey("MME KINDLER LAURENCE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 8 - RAPID ROC
	 * HorseID - RAPID ROC
	 */
	public static HorseID builderHorse_R5_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RAPID ROC");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PAD D'URZY");
		horseID.setMother("POLKA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 8 - RAPID ROC
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
		horse.setStable("A");
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(1800300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("PITTET CÉDRIC"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 9 - ANSHY
	 * HorseID - ANSHY
	 */
	public static HorseID builderHorse_R5_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ANSHY");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QUALYPSO JIEL");
		horseID.setMother("QUANIKA JIEL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 9 - ANSHY
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
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(1754300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KRÜSI BARBARA"));
		horse.setOwner(owner("KRÜSI BARBARA"));
		// no rancher
		horse.setJockey(jockey("KRÜSI SILVAN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 10 - VICKY CROWN
	 * HorseID - VICKY CROWN
	 */
	public static HorseID builderHorse_R5_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VICKY CROWN");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("HOOPER");
		horseID.setMother("FRENCH CROWN");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 10 - VICKY CROWN
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
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(379600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("RIESEN HANS"));
		horse.setOwner(owner("RIESEN HANS"));
		// no rancher
		horse.setJockey(jockey("MASSONNET ETIENNE"));

		return horse;

	}

	/*
	 * Race 5
	 * Odds 1 - 13/08/2015 14:41:57 +0200
	 */

	public static Odds builderOdds_R5_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:41:57 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 11.9));
		simples.add(simple(odds, "2", 9.0));
		simples.add(simple(odds, "3", 3.5));
		simples.add(simple(odds, "4", 41.7));
		simples.add(simple(odds, "5", 13.9));
		simples.add(simple(odds, "6", 6.8));
		simples.add(simple(odds, "7", 6.5));
		simples.add(simple(odds, "8", 10.6));
		simples.add(simple(odds, "9", 125.2));
		simples.add(simple(odds, "10", 4.8));
		simples.add(simple(odds, "A", 4.1));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5
	 * Odds 2 - 13/08/2015 19:10:59 +0200
	 */

	public static Odds builderOdds_R5_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:10:59 +0200"));
		odds.setTotal(65268.81);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 7.6));
		simples.add(simple(odds, "2", 8.1));
		simples.add(simple(odds, "3", 4.2));
		simples.add(simple(odds, "4", 24.3));
		simples.add(simple(odds, "5", 31.7));
		simples.add(simple(odds, "6", 10.3));
		simples.add(simple(odds, "7", 22.6));
		simples.add(simple(odds, "8", 32.8));
		simples.add(simple(odds, "9", 8.0));
		simples.add(simple(odds, "10", 3.0));
		simples.add(simple(odds, "A", 7.8));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6 - PRIX DE NANTES SUISSE
	 */

	public static Race builderRace_R6(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(6);
		race.setName("PRIX DE NANTES SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 19:40:00 +0200"));
		// no real start
		race.setDistance(2400.0);
		race.setBenefit(8326.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.noneOf(Type.class));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R6_O1(race));
		oddsSet.add(builderOdds_R6_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 7, 196550));
		places.add(place(race, 2, 1, 197120));
		places.add(place(race, 3, 5, 198420));
		places.add(place(race, 4, 6, 199040));
		places.add(place(race, 5, 4, 200440));
		places.add(place(race, 6, 2, 201530));
		places.add(place(race, 7, 8, 205620));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("3");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 8.5, "7"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "1"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.6, "5"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.0, "7"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 49.7, "7 1"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 13.5, "7 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.4, "1 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 5.0, "7 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.7, "7 5"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 30.6, "7 1 5"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 6
	 * Horse 1 - GLOBAL SPOTIFY
	 * HorseID - GLOBAL SPOTIFY
	 */
	public static HorseID builderHorse_R6_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("GLOBAL SPOTIFY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("LILIUM MADRIK");
		horseID.setMother("PERLE DE L'AMICAL");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 1 - GLOBAL SPOTIFY
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
		horse.setDistance(2425.0);
		horse.setCareerProfit(3280200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT MARCEL"));
		horse.setOwner(owner("STALL ALLEGRA RACING CLUB"));
		// no rancher
		horse.setJockey(jockey("BESSON PHILIPPE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 2 - CHARMEUR DELLY
	 * HorseID - CHARMEUR DELLY
	 */
	public static HorseID builderHorse_R6_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CHARMEUR DELLY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ROI DU COQ");
		horseID.setMother("NOUBA DELLY");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 2 - CHARMEUR DELLY
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(1087600.0);
		horse.setPreviousYearProfit(665200.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(752200.0);
		horse.setYearProfit(87000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("ECURIE PICORA"));
		// no rancher
		horse.setJockey(jockey("SCHNEIDER PASCAL"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 3 - FAST AND FURIOUS
	 * HorseID - FAST AND FURIOUS
	 */
	public static HorseID builderHorse_R6_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("FAST AND FURIOUS");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("ROI DU COQ");
		horseID.setMother("EURYDICE DES ANGES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 3 - FAST AND FURIOUS
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
		// no stable
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(1020300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT ANDRÉ"));
		horse.setOwner(owner("HUMBERT ANDRÉ"));
		// no rancher
		horse.setJockey(jockey("HUMBERT ANDRÉ"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 4 - CIGALE DES CHAUMES
	 * HorseID - CIGALE DES CHAUMES
	 */
	public static HorseID builderHorse_R6_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CIGALE DES CHAUMES");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("REPEAT LOVE");
		horseID.setMother("NIKITA WOOD");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 4 - CIGALE DES CHAUMES
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
		horse.setStable("A");
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(808700.0);
		horse.setPreviousYearProfit(551600.0);
		horse.setVictoryProfit(284700.0);
		horse.setPlaceProfit(524000.0);
		horse.setYearProfit(257100.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("BOVAY MYRIAM"));
		// no rancher
		horse.setJockey(jockey("BOVAY MARC-ANDRÉ"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 5 - CÂLINE DES CHAUMES
	 * HorseID - CÂLINE DES CHAUMES
	 */
	public static HorseID builderHorse_R6_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CÂLINE DES CHAUMES");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("REPEAT LOVE");
		horseID.setMother("OHLA WOOD");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 5 - CÂLINE DES CHAUMES
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
		horse.setStable("A");
		// no weight
		horse.setDistance(2400.0);
		horse.setCareerProfit(808700.0);
		horse.setPreviousYearProfit(29200.0);
		horse.setVictoryProfit(284700.0);
		horse.setPlaceProfit(523500.0);
		horse.setYearProfit(779000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BOVAY MARC-ANDRÉ"));
		horse.setOwner(owner("BOVAY MYRIAM"));
		// no rancher
		horse.setJockey(jockey("BURGER ADRIAN"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 6 - COME ON HORSE
	 * HorseID - COME ON HORSE
	 */
	public static HorseID builderHorse_R6_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("COME ON HORSE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ISLERO DE BELLOUET");
		horseID.setMother("MOOREA D'ORGERES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 6 - COME ON HORSE
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(803300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUMBERT MARCEL"));
		horse.setOwner(owner("WEND AXEL"));
		// no rancher
		horse.setJockey(jockey("HUMBERT MARCEL"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 7 - PRINCESS TABAIBA
	 * HorseID - PRINCESS TABAIBA
	 */
	public static HorseID builderHorse_R6_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PRINCESS TABAIBA");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ISLERO DE BELLOUET");
		horseID.setMother("MOOREA D'ORGERES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 7 - PRINCESS TABAIBA
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(790900.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DAVET JOSÉ"));
		horse.setOwner(owner("DAVET JOSÉ"));
		// no rancher
		horse.setJockey(jockey("DAVET JOSÉ"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 8 - CRÉSUS DE COVY
	 * HorseID - CRÉSUS DE COVY
	 */
	public static HorseID builderHorse_R6_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CRÉSUS DE COVY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("AND ARIFANT");
		horseID.setMother("RUN AWAY FOX");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 8 - CRÉSUS DE COVY
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
		horse.setDistance(2400.0);
		horse.setCareerProfit(71100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CONSOLE ANNE-MARIE"));
		horse.setOwner(owner("ECURIE DE COVY"));
		// no rancher
		horse.setJockey(jockey("LEFEBVRE GILLES"));

		return horse;

	}

	/*
	 * Race 6
	 * Odds 1 - 13/08/2015 14:42:06 +0200
	 */

	public static Odds builderOdds_R6_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:42:06 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 3.8));
		simples.add(simple(odds, "2", 16.3));
		simples.add(simple(odds, "3", 3.1));
		simples.add(simple(odds, "4", 4.8));
		simples.add(simple(odds, "5", 12.9));
		simples.add(simple(odds, "6", 18.5));
		simples.add(simple(odds, "7", 6.0));
		simples.add(simple(odds, "8", 21.3));
		simples.add(simple(odds, "A", 3.5));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6
	 * Odds 2 - 13/08/2015 19:40:56 +0200
	 */

	public static Odds builderOdds_R6_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:40:56 +0200"));
		odds.setTotal(53645.74);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 2.3));
		simples.add(simple(odds, "2", 12.5));
		simples.add(simple(odds, "3", 3.4));
		simples.add(simple(odds, "4", 8.4));
		simples.add(simple(odds, "5", 15.0));
		simples.add(simple(odds, "6", 16.6));
		simples.add(simple(odds, "7", 8.5));
		simples.add(simple(odds, "8", 36.8));
		simples.add(simple(odds, "A", 5.4));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7 - CHAMPIONNAT DES INDIGENES SUISSE
	 */

	public static Race builderRace_R7(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(7);
		race.setName("CHAMPIONNAT DES INDIGENES SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 20:10:00 +0200"));
		// no real start
		race.setDistance(2000.0);
		race.setBenefit(9991.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.AUTOSTART));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R7_O1(race));
		oddsSet.add(builderOdds_R7_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 5, 158200));
		places.add(place(race, 2, 2, 158800));
		places.add(place(race, 3, 8, 159170));
		places.add(place(race, 4, 6, 160030));
		places.add(place(race, 5, 4, 160130));
		places.add(place(race, 6, 3, 161040));
		places.add(place(race, 7, 1, 162060));
		places.add(place(race, 8, 7, 163710));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 1.5, "5"));
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 1.5, "6"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.1, "5"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "8"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 18.0, "5 2"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 16.8, "5 2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.6, "2 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.8, "5 2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.5, "5 8"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 24.6, "5 2 8"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 7
	 * Horse 1 - SCHUBERT DU MARTZA
	 * HorseID - SCHUBERT DU MARTZA
	 */
	public static HorseID builderHorse_R7_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SCHUBERT DU MARTZA");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("VOICI DU NIEL");
		horseID.setMother("JUMELLE JAMES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 1 - SCHUBERT DU MARTZA
	 */

	public static Horse builderHorse_R7_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(8684600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(279200.0);
		horse.setPlaceProfit(88400.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("GERBER-FLÜHMANN TANJA"));
		horse.setOwner(owner("GERBER HANS-UELI"));
		// no rancher
		horse.setJockey(jockey("MATTHEY JEAN-BERNARD"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 2 - BELLA VITA
	 * HorseID - BELLA VITA
	 */
	public static HorseID builderHorse_R7_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BELLA VITA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("REPEAT LOVE");
		horseID.setMother("QUIERA LUNA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 2 - BELLA VITA
	 */

	public static Horse builderHorse_R7_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3751100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(282900.0);
		horse.setPlaceProfit(141500.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("AEBISCHER RENÉ"));
		horse.setOwner(owner("ECURIE RHYTHM & BLUES"));
		// no rancher
		horse.setJockey(jockey("MME AEBISCHER BARBARA"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 3 - QUELLE DAME FLAMY
	 * HorseID - QUELLE DAME FLAMY
	 */
	public static HorseID builderHorse_R7_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUELLE DAME FLAMY");
		horseID.setBirth(parse("01/01/2004 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CHAILLOT");
		horseID.setMother("COTE DE GRANIT");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 3 - QUELLE DAME FLAMY
	 */

	public static Horse builderHorse_R7_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(1.48838E7);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PITTET CÉDRIC"));
		horse.setOwner(owner("PITTET PIERRE"));
		// no rancher
		horse.setJockey(jockey("SCHNEIDER PASCAL"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 4 - VITESSE DU VAL
	 * HorseID - VITESSE DU VAL
	 */
	public static HorseID builderHorse_R7_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VITESSE DU VAL");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("QUATRE JUILLET");
		horseID.setMother("DARLING DU ROCHER");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 4 - VITESSE DU VAL
	 */

	public static Horse builderHorse_R7_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(9422400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_FORELEG);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PERRIN BERNARD"));
		horse.setOwner(owner("PERRIN BERNARD"));
		// no rancher
		horse.setJockey(jockey("JURIENS JACQUES"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 5 - ATTENARCO
	 * HorseID - ATTENARCO
	 */
	public static HorseID builderHorse_R7_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ATTENARCO");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("READY CASH");
		horseID.setMother("MATTMARA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 5 - ATTENARCO
	 */

	public static Horse builderHorse_R7_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		horse.setStable("A");
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(1.06303E7);
		horse.setPreviousYearProfit(1750500.0);
		horse.setVictoryProfit(2925000.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(1174500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("NUNES DE OLIVEIRA V."));
		horse.setOwner(owner("ECURIE TURRETTINI"));
		// no rancher
		horse.setJockey(jockey("TURRETTINI HENRI"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 6 - ATTALINE
	 * HorseID - ATTALINE
	 */
	public static HorseID builderHorse_R7_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ATTALINE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		// no father
		// no mother
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 6 - ATTALINE
	 */

	public static Horse builderHorse_R7_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		horse.setStable("A");
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(5924100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("NUNES DE OLIVEIRA V."));
		horse.setOwner(owner("ECURIE TURRETTINI"));
		// no rancher
		horse.setJockey(jockey("MME LAUBSCHER ANNE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 7 - QUARNAC DU JURA
	 * HorseID - QUARNAC DU JURA
	 */
	public static HorseID builderHorse_R7_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUARNAC DU JURA");
		horseID.setBirth(parse("01/01/2004 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JOYAU D'AMOUR");
		horseID.setMother("ELSA DES AITRES");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 7 - QUARNAC DU JURA
	 */

	public static Horse builderHorse_R7_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(8793700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ETIENNE OLBERT"));
		horse.setOwner(owner("ETIENNE OLBERT"));
		// no rancher
		horse.setJockey(jockey("ETIENNE ROGER"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 8 - TANGO DU MARTZA
	 * HorseID - TANGO DU MARTZA
	 */
	public static HorseID builderHorse_R7_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TANGO DU MARTZA");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("JAG DE BELLOUET");
		horseID.setMother("AIDA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 8 - TANGO DU MARTZA
	 */

	public static Horse builderHorse_R7_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(1.67663E7);
		horse.setPreviousYearProfit(4270700.0);
		horse.setVictoryProfit(1.10692E7);
		horse.setPlaceProfit(3038200.0);
		horse.setYearProfit(140000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PUJOL RENAUD"));
		horse.setOwner(owner("ECURIE DU MARTZA SÀRL"));
		// no rancher
		horse.setJockey(jockey("QUATREUIL FRANCK"));

		return horse;

	}

	/*
	 * Race 7
	 * Odds 1 - 13/08/2015 14:42:15 +0200
	 */

	public static Odds builderOdds_R7_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:42:15 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 23.8));
		simples.add(simple(odds, "2", 34.8));
		simples.add(simple(odds, "3", 67.7));
		simples.add(simple(odds, "4", 19.4));
		simples.add(simple(odds, "5", 1.1));
		simples.add(simple(odds, "6", 31.5));
		simples.add(simple(odds, "7", 18.9));
		simples.add(simple(odds, "8", 26.1));
		simples.add(simple(odds, "A", 1.1));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7
	 * Odds 2 - 13/08/2015 20:11:17 +0200
	 */

	public static Odds builderOdds_R7_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 20:11:17 +0200"));
		odds.setTotal(41142.66);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 9.7));
		simples.add(simple(odds, "2", 16.3));
		simples.add(simple(odds, "3", 23.8));
		simples.add(simple(odds, "4", 8.6));
		simples.add(simple(odds, "5", 1.8));
		simples.add(simple(odds, "6", 8.4));
		simples.add(simple(odds, "7", 15.3));
		simples.add(simple(odds, "8", 6.8));
		simples.add(simple(odds, "A", 1.5));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 8 - PRIX DE CRAON SUISSE
	 */

	public static Race builderRace_R8(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(8);
		race.setName("PRIX DE CRAON SUISSE");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 20:35:00 +0200"));
		// no real start
		race.setDistance(2000.0);
		race.setBenefit(8326.0);
		race.setDiscipline(Discipline.TROT_ATTELE);
		race.setTypes(EnumSet.of(Type.AUTOSTART));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R8_O1(race));
		oddsSet.add(builderOdds_R8_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 7, 161800));
		places.add(place(race, 2, 8, 161900));
		places.add(place(race, 3, 6, 162280));
		places.add(place(race, 4, 1, 163840));
		places.add(place(race, 5, 4, 164250));
		places.add(place(race, 6, 9, 164660));
		places.add(place(race, 7, 5, 164920));
		places.add(place(race, 8, 3, 167130));
		race.setPlaces(places);

		// no stopped
		race.setDisqualified("2");
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.7, "7"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.5, "6"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.6, "7"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.5, "8"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 56.4, "7 8"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 17.9, "7 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.3, "7 6"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.3, "7 8"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 9.1, "8 6"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 31.1, "7 8 6"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 8
	 * Horse 1 - UBAR ROSE
	 * HorseID - UBAR ROSE
	 */
	public static HorseID builderHorse_R8_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UBAR ROSE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		// no father
		// no mother
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 1 - UBAR ROSE
	 */

	public static Horse builderHorse_R8_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3724400.0);
		horse.setPreviousYearProfit(938800.0);
		horse.setVictoryProfit(60000.0);
		horse.setPlaceProfit(2019800.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PERRIN BERNARD"));
		horse.setOwner(owner("PERRIN BERNARD"));
		// no rancher
		horse.setJockey(jockey("JURIENS JACQUES"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 2 - ATLAS PÉREYRE
	 * HorseID - ATLAS PÉREYRE
	 */
	public static HorseID builderHorse_R8_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ATLAS PÉREYRE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LUTIN MALIN");
		horseID.setMother("JANNETTE BOUM");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 2 - ATLAS PÉREYRE
	 */

	public static Horse builderHorse_R8_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3796900.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NO_POSTERIOR);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("FRESNEAU RAPHAËL"));
		horse.setOwner(owner("ECURIE PÉREYRE"));
		// no rancher
		horse.setJockey(jockey("FRESNEAU RAPHAËL"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 3 - SUSPENSE JENILOU
	 * HorseID - SUSPENSE JENILOU
	 */
	public static HorseID builderHorse_R8_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SUSPENSE JENILOU");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("L'AS DE VIRETAUTE");
		horseID.setMother("LOUVE JENILOU");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 3 - SUSPENSE JENILOU
	 */

	public static Horse builderHorse_R8_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(4164200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1250000.0);
		horse.setPlaceProfit(2001600.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("WYSS SANDRA"));
		horse.setOwner(owner("WYSS SANDRA"));
		// no rancher
		horse.setJockey(jockey("MME WYSS SANDRA"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 4 - VIKING DU REGARD
	 * HorseID - VIKING DU REGARD
	 */
	public static HorseID builderHorse_R8_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VIKING DU REGARD");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("HERMES PERRINE");
		horseID.setMother("OMAHA DU REGARD");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_BRUN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 4 - VIKING DU REGARD
	 */

	public static Horse builderHorse_R8_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2105900.0);
		horse.setPreviousYearProfit(708700.0);
		horse.setVictoryProfit(205000.0);
		horse.setPlaceProfit(791700.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BLANC FRANÇOIS"));
		horse.setOwner(owner("BLANC FRANÇOIS"));
		// no rancher
		horse.setJockey(jockey("BLANC PHILIPPE"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 5 - AXELLE DU MARTZA
	 * HorseID - AXELLE DU MARTZA
	 */
	public static HorseID builderHorse_R8_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AXELLE DU MARTZA");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PAD D'URZY");
		horseID.setMother("POLKA DU MARTZA");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.ALEZAN);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 5 - AXELLE DU MARTZA
	 */

	public static Horse builderHorse_R8_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(2400700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CONSOLE ANNE-MARIE"));
		horse.setOwner(owner("ECURIE DU SOLEIL"));
		// no rancher
		horse.setJockey(jockey("MME CONSOLE ANNE-MARIE"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 6 - SUBTIL DE COVY
	 * HorseID - SUBTIL DE COVY
	 */
	public static HorseID builderHorse_R8_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SUBTIL DE COVY");
		horseID.setBirth(parse("01/01/2006 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ANAKIR");
		horseID.setMother("FANTAISIE D'ICI");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI_FONCE);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 6 - SUBTIL DE COVY
	 */

	public static Horse builderHorse_R8_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(4554000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1070300.0);
		horse.setPlaceProfit(1458900.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("SOUTTER DENISE"));
		horse.setOwner(owner("SOUTTER DENISE"));
		// no rancher
		horse.setJockey(jockey("BESSON PHILIPPE"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 7 - AYERS ROCK
	 * HorseID - AYERS ROCK
	 */
	public static HorseID builderHorse_R8_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("AYERS ROCK");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("PAD D'URZY");
		horseID.setMother("MONTLUCONNAISE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 7 - AYERS ROCK
	 */

	public static Horse builderHorse_R8_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(4958700.0);
		horse.setPreviousYearProfit(1126000.0);
		horse.setVictoryProfit(1318800.0);
		horse.setPlaceProfit(2486700.0);
		horse.setYearProfit(79100.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MATTHEY J.-B."));
		horse.setOwner(owner("ECURIE WILTON"));
		// no rancher
		horse.setJockey(jockey("MATTHEY JEAN-BERNARD"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 8 - VALENTINO DU SEC
	 * HorseID - VALENTINO DU SEC
	 */
	public static HorseID builderHorse_R8_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VALENTINO DU SEC");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("PAD D'URZY");
		horseID.setMother("MONTLUCONNAISE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 8 - VALENTINO DU SEC
	 */

	public static Horse builderHorse_R8_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(1837300.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MARASCO DAVID"));
		horse.setOwner(owner("PICARD OLIVIER"));
		// no rancher
		horse.setJockey(jockey("MARASCO DAVID"));

		return horse;

	}

	/*
	 * Race 8
	 * Horse 9 - QUINAPRIL
	 * HorseID - QUINAPRIL
	 */
	public static HorseID builderHorse_R8_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUINAPRIL");
		horseID.setBirth(parse("01/01/2004 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("ITON DU GITE");
		horseID.setMother("CLANDESTINITE");
		horseID.setBreed(Breed.TROTTEUR_FRANCAIS);
		horseID.setCoat(Coat.BAI);

		return horseID;

	}


	/*
	 * Race 8
	 * Horse 9 - QUINAPRIL
	 */

	public static Horse builderHorse_R8_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R8_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		// no weight
		horse.setDistance(2000.0);
		horse.setCareerProfit(3248100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(550000.0);
		horse.setPlaceProfit(1142700.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.NONE);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("GLOOR MAJA"));
		horse.setOwner(owner("GLOOR MAJA"));
		// no rancher
		horse.setJockey(jockey("MME GLOOR MAJA"));

		return horse;

	}

	/*
	 * Race 8
	 * Odds 1 - 13/08/2015 14:42:04 +0200
	 */

	public static Odds builderOdds_R8_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:42:04 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 4.5));
		simples.add(simple(odds, "2", 6.0));
		simples.add(simple(odds, "3", 26.0));
		simples.add(simple(odds, "4", 13.4));
		simples.add(simple(odds, "5", 8.8));
		simples.add(simple(odds, "6", 5.8));
		simples.add(simple(odds, "7", 7.9));
		simples.add(simple(odds, "8", 3.9));
		simples.add(simple(odds, "9", 46.5));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 8
	 * Odds 2 - 13/08/2015 20:37:01 +0200
	 */

	public static Odds builderOdds_R8_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 20:37:01 +0200"));
		odds.setTotal(33182.95);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 8.3));
		simples.add(simple(odds, "2", 5.0));
		simples.add(simple(odds, "3", 48.0));
		simples.add(simple(odds, "4", 9.1));
		simples.add(simple(odds, "5", 21.4));
		simples.add(simple(odds, "6", 4.8));
		simples.add(simple(odds, "7", 2.7));
		simples.add(simple(odds, "8", 10.7));
		simples.add(simple(odds, "9", 33.5));
		odds.setSimples(simples);

		return odds;

	}

}
