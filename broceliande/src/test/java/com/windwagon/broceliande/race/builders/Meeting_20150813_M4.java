package com.windwagon.broceliande.race.builders;

import java.util.EnumSet;
import java.util.SortedSet;
import java.util.TreeSet;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Blinder;
import com.windwagon.broceliande.race.entities.Breed;
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

public class Meeting_20150813_M4 extends MeetingBuilder {

	public static Meeting build() {

		Meeting meeting = new Meeting();

		meeting.setDate(parse("13/08/2015 00:00:00 +0200"));
		meeting.setRacecourse(racecourse("SALISBURY", "ROYAUME-UNI"));
		meeting.setNumber(4);
		meeting.setWindSpeed(12.0);
		meeting.setWindDirection(WindDirection.SE);
		meeting.setTemperature(24.0);
		meeting.setClimat("TRES NUAGEUX");
		meeting.setField(Field.UNKNOWN);

		// -- races --
		SortedSet<Race> races = new TreeSet<>();
		races.add(builderRace_R4(meeting));
		races.add(builderRace_R5(meeting));
		races.add(builderRace_R6(meeting));
		races.add(builderRace_R7(meeting));
		meeting.setRaces(races);

		return meeting;

	}

	/*
	 * Race 4 - EBF STALLIONS FILLIES' HANDICAP STAKES
	 */

	public static Race builderRace_R4(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(4);
		race.setName("EBF STALLIONS FILLIES' HANDICAP STAKES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 16:55:00 +0200"));
		// no real start
		race.setDistance(2400.0);
		race.setBenefit(14152.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.HANDICAP));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R4_O1(race));
		oddsSet.add(builderOdds_R4_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 2));
		places.add(place(race, 2, 5, "TROIS_LONGUEURS_ET_DEMIE"));
		places.add(place(race, 3, 4, "DEUX_LONGUEURS"));
		places.add(place(race, 4, 6, "CINQ_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 5, 1, "QUATRE_LONGUEURS_ET_DEMIE"));
		places.add(place(race, 6, 8, "DEMI_LONGUEUR"));
		places.add(place(race, 7, 9, "DIX_LONGUEURS"));
		places.add(place(race, 8, 7, "TRENTE_LONGUEURS"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 14.6, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.2, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.2, "5"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 14.6, "2"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 68.5, "2 5"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 14.6, "2"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 24.0, "2 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.2, "2"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.8, "2 4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 6.0, "2 5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.4, "4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.2, "5"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.1, "5 4"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 24.0, "2 5"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 24.4, "2 5 4"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 4
	 * Horse 1 - MYSTERY DRAMA
	 * HorseID - MYSTERY DRAMA
	 */
	public static HorseID builderHorse_R4_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MYSTERY DRAMA");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("HERNANDO");
		horseID.setMother("MYSTERY LOT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 1 - MYSTERY DRAMA
	 */

	public static Horse builderHorse_R4_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(63.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(1965700.0);
		// no previous year profit
		horse.setVictoryProfit(1296500.0);
		horse.setPlaceProfit(669200.0);
		horse.setYearProfit(834600.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ALAN KING"));
		horse.setOwner(owner("INCIPE PARTNERSHIP"));
		// no rancher
		horse.setJockey(jockey("ADAM KIRBY"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 2 - STOCKHILL DIVA
	 * HorseID - STOCKHILL DIVA
	 */
	public static HorseID builderHorse_R4_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("STOCKHILL DIVA");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("HAAFHD");
		horseID.setMother("APRIL STOCK");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 2 - STOCKHILL DIVA
	 */

	public static Horse builderHorse_R4_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		horse.setWeight(59.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(1344400.0);
		// no previous year profit
		horse.setVictoryProfit(824100.0);
		horse.setPlaceProfit(520300.0);
		horse.setYearProfit(391000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BRENDAN POWELL"));
		horse.setOwner(owner("MRS M. FAIRBAIRN & E. GADSDEN"));
		// no rancher
		horse.setJockey(jockey("LIAM KENIRY"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 3 - MIKANDY
	 * HorseID - MIKANDY
	 */
	public static HorseID builderHorse_R4_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MIKANDY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ARCANO");
		horseID.setMother("BELLE DE CADIX");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 3 - MIKANDY
	 */

	public static Horse builderHorse_R4_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H3_ID());
		horse.setNumber(3);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(58.5);
		horse.setDistance(2400.0);
		horse.setCareerProfit(1801300.0);
		// no previous year profit
		horse.setVictoryProfit(1030000.0);
		horse.setPlaceProfit(771300.0);
		horse.setYearProfit(1137300.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CLIVE COX"));
		horse.setOwner(owner("THE MIKANDY PARTNERSHIP"));
		// no rancher
		horse.setJockey(jockey("GERALD MOSSE"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 4 - ZAMANI
	 * HorseID - ZAMANI
	 */
	public static HorseID builderHorse_R4_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ZAMANI");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("TEOFILO");
		horseID.setMother("ZAM ZOOM");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 4 - ZAMANI
	 */

	public static Horse builderHorse_R4_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		horse.setWeight(57.5);
		horse.setDistance(2400.0);
		horse.setCareerProfit(539200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(411900.0);
		horse.setPlaceProfit(127200.0);
		horse.setYearProfit(539200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JAMES TATE"));
		horse.setOwner(owner("MR SAEED MANANA"));
		// no rancher
		horse.setJockey(jockey("JIM CROWLEY"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 5 - MILL SPRINGS
	 * HorseID - MILL SPRINGS
	 */
	public static HorseID builderHorse_R4_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MILL SPRINGS");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SHIROCCO");
		horseID.setMother("MEZZOGIORNO");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 5 - MILL SPRINGS
	 */

	public static Horse builderHorse_R4_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(648400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(457800.0);
		horse.setPlaceProfit(190600.0);
		horse.setYearProfit(648300.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHN GOSDEN"));
		horse.setOwner(owner("MRS R. PHILIPPS"));
		// no rancher
		horse.setJockey(jockey("ROBERT HAVLIN"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 6 - VANISHING
	 * HorseID - VANISHING
	 */
	public static HorseID builderHorse_R4_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("VANISHING");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SIR PERCY");
		horseID.setMother("VALORIA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 6 - VANISHING
	 */

	public static Horse builderHorse_R4_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		horse.setWeight(56.5);
		horse.setDistance(2400.0);
		horse.setCareerProfit(1279500.0);
		// no previous year profit
		horse.setVictoryProfit(1052800.0);
		horse.setPlaceProfit(226700.0);
		horse.setYearProfit(1175400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ED WALKER"));
		horse.setOwner(owner("MR S. STUCKEY"));
		// no rancher
		horse.setJockey(jockey("ANTONIO FRESU"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 7 - TINGLEO
	 * HorseID - TINGLEO
	 */
	public static HorseID builderHorse_R4_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TINGLEO");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("GALILEO");
		horseID.setMother("TINGLING");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 7 - TINGLEO
	 */

	public static Horse builderHorse_R4_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(56.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(522000.0);
		// no previous year profit
		horse.setVictoryProfit(430200.0);
		horse.setPlaceProfit(91800.0);
		horse.setYearProfit(494900.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ROGER VARIAN"));
		horse.setOwner(owner("MR NURLAN BIZAKOV"));
		// no rancher
		horse.setJockey(jockey("FREDERIK TYLICKI"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 8 - JERSEY JEWEL
	 * HorseID - JERSEY JEWEL
	 */
	public static HorseID builderHorse_R4_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("JERSEY JEWEL");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("NAAQOOS");
		horseID.setMother("NIKOLENKA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 8 - JERSEY JEWEL
	 */

	public static Horse builderHorse_R4_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(1438000.0);
		// no previous year profit
		horse.setVictoryProfit(457800.0);
		horse.setPlaceProfit(980200.0);
		horse.setYearProfit(825400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("RICHARD HANNON"));
		horse.setOwner(owner("CORIOLAN PARTNERSHIP"));
		// no rancher
		horse.setJockey(jockey("TOM MARQUAND"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 9 - TOXARIS
	 * HorseID - TOXARIS
	 */
	public static HorseID builderHorse_R4_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TOXARIS");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("TEOFILO");
		horseID.setMother("RIGHT KEY");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 9 - TOXARIS
	 */

	public static Horse builderHorse_R4_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(54.0);
		horse.setDistance(2400.0);
		horse.setCareerProfit(439400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(439400.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(439400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("GARY MOORE"));
		horse.setOwner(owner("CHEGWIDDEN SYSTEMS LTD"));
		// no rancher
		horse.setJockey(jockey("SHANE KELLY"));

		return horse;

	}

	/*
	 * Race 4
	 * Odds 1 - 13/08/2015 16:51:24 +0200
	 */

	public static Odds builderOdds_R4_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:51:24 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 17.7));
		simples.add(simple(odds, "2", 100.6));
		simples.add(simple(odds, "3", 2.1));
		simples.add(simple(odds, "4", 4.0));
		simples.add(simple(odds, "5", 3.0));
		simples.add(simple(odds, "6", 5.1));
		simples.add(simple(odds, "7", 3.4));
		simples.add(simple(odds, "8", 10.0));
		simples.add(simple(odds, "9", 8.6));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4
	 * Odds 2 - 13/08/2015 16:55:47 +0200
	 */

	public static Odds builderOdds_R4_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:55:47 +0200"));
		odds.setTotal(64644.87);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 16.0));
		simples.add(simple(odds, "2", 14.6));
		simples.add(simple(odds, "3", 3.8));
		simples.add(simple(odds, "4", 5.1));
		simples.add(simple(odds, "5", 2.1));
		simples.add(simple(odds, "6", 7.7));
		simples.add(simple(odds, "7", 6.7));
		simples.add(simple(odds, "8", 10.6));
		simples.add(simple(odds, "9", 27.4));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5 - SOVEREIGN STAKES
	 */

	public static Race builderRace_R5(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(5);
		race.setName("SOVEREIGN STAKES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 17:25:00 +0200"));
		// no real start
		race.setDistance(1600.0);
		race.setBenefit(106144.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.GROUPE_III));

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
		places.add(place(race, 1, 10));
		places.add(place(race, 2, 4, "QUATRE_LONGUEURS_ET_DEMIE"));
		places.add(place(race, 3, 1, "CINQ_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 4, 8, "UN_NEZ"));
		places.add(place(race, 5, 2, "DEUX_LONGUEURS"));
		places.add(place(race, 6, 3, "UNE_LONGUEUR_ET_DEMIE"));
		places.add(place(race, 7, 5, "UNE_LONGUEUR"));
		places.add(place(race, 8, 6, "TROIS_LONGUEURS"));
		places.add(place(race, 9, 11, "UN_NEZ"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 2.4, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "1"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.4, "10"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.4, "4"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 2.4, "10"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 42.8, "10 4"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 2.4, "10"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 29.7, "10 4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 2.1, "1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 1.4, "10"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 4.8, "10 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.4, "10 4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.4, "4"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 22.3, "4 1"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 0.0, "10"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 29.7, "10 4"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 56.7, "10 4 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "1 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "10"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "10 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "10 4"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "10 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "4"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "4 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 5.7, "4 8"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 1.4, "8"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 142.5, "10 4 1 8"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 28.5, "10 4 1 8"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 9.5, "10 4 1 8"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 5
	 * Horse 1 - CUSTOM CUT
	 * HorseID - CUSTOM CUT
	 */
	public static HorseID builderHorse_R5_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CUSTOM CUT");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("NOTNOWCATO");
		horseID.setMother("POLISHED GEM");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 1 - CUSTOM CUT
	 */

	public static Horse builderHorse_R5_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(11);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(5.30889E7);
		// no previous year profit
		horse.setVictoryProfit(4.27095E7);
		horse.setPlaceProfit(1.03793E7);
		horse.setYearProfit(1.05131E7);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DAVID O'MEARA"));
		horse.setOwner(owner("MR GARY DOUGLAS & MR PAT BRESLIN"));
		// no rancher
		horse.setJockey(jockey("DANIEL TUDHOPE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 2 - TULLIUS
	 * HorseID - TULLIUS
	 */
	public static HorseID builderHorse_R5_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TULLIUS");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("LE VIE DEI COLORI");
		horseID.setMother("WHIPPED QUEEN");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 2 - TULLIUS
	 */

	public static Horse builderHorse_R5_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(6.1209E7);
		// no previous year profit
		horse.setVictoryProfit(3.37954E7);
		horse.setPlaceProfit(2.74135E7);
		horse.setYearProfit(1.37327E7);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ANDREW BALDING"));
		horse.setOwner(owner("KENNET VALLEY THOROUGHBREDS VI"));
		// no rancher
		horse.setJockey(jockey("JIMMY FORTUNE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 3 - CAPTAIN CAT
	 * HorseID - CAPTAIN CAT
	 */
	public static HorseID builderHorse_R5_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CAPTAIN CAT");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DYLAN THOMAS");
		horseID.setMother("MOTHER OF PEARL");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 3 - CAPTAIN CAT
	 */

	public static Horse builderHorse_R5_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(3.70541E7);
		// no previous year profit
		horse.setVictoryProfit(2.57618E7);
		horse.setPlaceProfit(1.12923E7);
		horse.setYearProfit(380700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ROGER CHARLTON"));
		horse.setOwner(owner("SEASONS HOLIDAYS"));
		// no rancher
		horse.setJockey(jockey("JAMIE SPENCER"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 4 - DARK EMERALD
	 * HorseID - DARK EMERALD
	 */
	public static HorseID builderHorse_R5_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("DARK EMERALD");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DARK ANGEL");
		horseID.setMother("XEMA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 4 - DARK EMERALD
	 */

	public static Horse builderHorse_R5_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(3.0676E7);
		// no previous year profit
		horse.setVictoryProfit(2.08923E7);
		horse.setPlaceProfit(9783600.0);
		horse.setYearProfit(2.22594E7);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BRENDAN POWELL"));
		horse.setOwner(owner("MR K. RHATIGAN"));
		// no rancher
		horse.setJockey(jockey("ADAM KIRBY"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 5 - MOOHAARIB
	 * HorseID - MOOHAARIB
	 */
	public static HorseID builderHorse_R5_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MOOHAARIB");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("OASIS DREAM");
		horseID.setMother("EVITA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 5 - MOOHAARIB
	 */

	public static Horse builderHorse_R5_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(8816200.0);
		// no previous year profit
		horse.setVictoryProfit(5847700.0);
		horse.setPlaceProfit(2968500.0);
		horse.setYearProfit(4288500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MARCO BOTTI"));
		horse.setOwner(owner("SHEIKH MOHAMMED BIN KHALIFA AL M"));
		// no rancher
		horse.setJockey(jockey("MARTIN HARLEY"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 6 - SHIFTING POWER
	 * HorseID - SHIFTING POWER
	 */
	public static HorseID builderHorse_R5_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SHIFTING POWER");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("COMPTON PLACE");
		horseID.setMother("PROFIT ALERT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 6 - SHIFTING POWER
	 */

	public static Horse builderHorse_R5_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(2.96334E7);
		// no previous year profit
		horse.setVictoryProfit(7037900.0);
		horse.setPlaceProfit(2.25954E7);
		horse.setYearProfit(4416200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("RICHARD HANNON"));
		horse.setOwner(owner("MS ELAINE CHIVERS & POTENSIS B'S"));
		// no rancher
		horse.setJockey(jockey("PAT DOBBS"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 7 - SHORT SQUEEZE
	 * HorseID - SHORT SQUEEZE
	 */
	public static HorseID builderHorse_R5_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SHORT SQUEEZE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("CAPE CROSS");
		horseID.setMother("SUNSETTER");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 7 - SHORT SQUEEZE
	 */

	public static Horse builderHorse_R5_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H7_ID());
		horse.setNumber(7);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(1.84929E7);
		// no previous year profit
		horse.setVictoryProfit(1.28158E7);
		horse.setPlaceProfit(5677000.0);
		horse.setYearProfit(4672500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUGO PALMER"));
		horse.setOwner(owner("W DUFF GORDON, R SMITH, B MATHIE"));
		// no rancher
		horse.setJockey(jockey("HARRY BENTLEY"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 8 - WANNABE YOURS
	 * HorseID - WANNABE YOURS
	 */
	public static HorseID builderHorse_R5_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("WANNABE YOURS");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("DUBAWI");
		horseID.setMother("WANNABE POSH");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 8 - WANNABE YOURS
	 */

	public static Horse builderHorse_R5_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(7584500.0);
		// no previous year profit
		horse.setVictoryProfit(7104400.0);
		horse.setPlaceProfit(480000.0);
		horse.setYearProfit(418800.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHN GOSDEN"));
		horse.setOwner(owner("NORMANDIE STUD LTD"));
		// no rancher
		horse.setJockey(jockey("ROBERT HAVLIN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 9 - FANCIFUL ANGEL
	 * HorseID - FANCIFUL ANGEL
	 */
	public static HorseID builderHorse_R5_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("FANCIFUL ANGEL");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("DARK ANGEL");
		horseID.setMother("FANCIFUL DANCER");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 9 - FANCIFUL ANGEL
	 */

	public static Horse builderHorse_R5_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H9_ID());
		horse.setNumber(9);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(54.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(8489500.0);
		// no previous year profit
		horse.setVictoryProfit(3427400.0);
		horse.setPlaceProfit(5062100.0);
		horse.setYearProfit(6946100.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MARCO BOTTI"));
		horse.setOwner(owner("SCUDERIA BLUEBERRY S. R. L."));
		// no rancher
		horse.setJockey(jockey("MARTIN LANE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 10 - KODI BEAR
	 * HorseID - KODI BEAR
	 */
	public static HorseID builderHorse_R5_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("KODI BEAR");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("KODIAC");
		horseID.setMother("HAWATTEF");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 10 - KODI BEAR
	 */

	public static Horse builderHorse_R5_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(54.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(2.23354E7);
		// no previous year profit
		horse.setVictoryProfit(5377400.0);
		horse.setPlaceProfit(1.6958E7);
		horse.setYearProfit(5475200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CLIVE COX"));
		horse.setOwner(owner("MRS OLIVE SHAW"));
		// no rancher
		horse.setJockey(jockey("GERALD MOSSE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 11 - MUSTADEEM
	 * HorseID - MUSTADEEM
	 */
	public static HorseID builderHorse_R5_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MUSTADEEM");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("ARCANO");
		horseID.setMother("HUREYA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 11 - MUSTADEEM
	 */

	public static Horse builderHorse_R5_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(10);
		// no stable
		horse.setWeight(54.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(3122200.0);
		// no previous year profit
		horse.setVictoryProfit(549200.0);
		horse.setPlaceProfit(2572900.0);
		horse.setYearProfit(2409500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("BRIAN MEEHAN"));
		horse.setOwner(owner("MR HAMDAN AL MAKTOUM"));
		// no rancher
		horse.setJockey(jockey("PAUL HANAGAN"));

		return horse;

	}

	/*
	 * Race 5
	 * Odds 1 - 13/08/2015 16:03:14 +0200
	 */

	public static Odds builderOdds_R5_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:03:14 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 31.1));
		simples.add(simple(odds, "2", 5.1));
		simples.add(simple(odds, "3", 18.4));
		simples.add(simple(odds, "4", 23.8));
		simples.add(simple(odds, "5", 45.0));
		simples.add(simple(odds, "6", 13.0));
		simples.add(simple(odds, "7", 136.1));
		simples.add(simple(odds, "8", 3.1));
		simples.add(simple(odds, "10", 2.7));
		simples.add(simple(odds, "11", 13.0));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5
	 * Odds 2 - 13/08/2015 17:26:28 +0200
	 */

	public static Odds builderOdds_R5_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 17:26:28 +0200"));
		odds.setTotal(82098.71);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 6.9));
		simples.add(simple(odds, "2", 8.2));
		simples.add(simple(odds, "3", 10.8));
		simples.add(simple(odds, "4", 22.3));
		simples.add(simple(odds, "5", 7.2));
		simples.add(simple(odds, "6", 8.4));
		simples.add(simple(odds, "7", 98.4));
		simples.add(simple(odds, "8", 17.1));
		simples.add(simple(odds, "10", 2.4));
		simples.add(simple(odds, "11", 15.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6 - THE BILL GARNETT MEMORIAL FILLIES' HANDICAP STAKES
	 */

	public static Race builderRace_R6(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(6);
		race.setName("THE BILL GARNETT MEMORIAL FILLIES' HANDICAP STAKES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 17:55:00 +0200"));
		// no real start
		race.setDistance(1200.0);
		race.setBenefit(7076.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.HANDICAP));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R6_O1(race));
		oddsSet.add(builderOdds_R6_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 6));
		places.add(place(race, 2, 3, "UN_NEZ"));
		places.add(place(race, 3, 12, "UNE_LONGUEUR_TROIS_QUARTS"));
		places.add(place(race, 4, 11, "DEMI_LONGUEUR"));
		places.add(place(race, 5, 10, "ENCOLURE"));
		places.add(place(race, 6, 1, "DEUX_LONGUEURS"));
		places.add(place(race, 7, 5, "CINQ_LONGUEURS"));
		places.add(place(race, 8, 9, "CINQ_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 9, 2, "TROIS_LONGUEURS"));
		places.add(place(race, 10, 4, "TREIZE_LONGUEURS"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 8.8, "6"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "12"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.4, "6"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 8.8, "6"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 119.0, "6 3"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 8.8, "6"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 51.1, "6 3"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.7, "12"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.7, "3"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 16.1, "3 12"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 3.4, "6"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 16.7, "6 12"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 13.7, "6 3"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 0.0, "6 3"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 219.4, "6 3 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "12 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "3 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "3 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 3.1, "6"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "6 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "6 12"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 15.5, "6 3"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 426.0, "6 3 12 11"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 85.2, "6 3 12 11"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 28.4, "6 3 12 11"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 6
	 * Horse 1 - THREAVE
	 * HorseID - THREAVE
	 */
	public static HorseID builderHorse_R6_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("THREAVE");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("DIKTAT");
		horseID.setMother("BIANCA SFORZA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 1 - THREAVE
	 */

	public static Horse builderHorse_R6_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(62.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1646700.0);
		// no previous year profit
		horse.setVictoryProfit(1190200.0);
		horse.setPlaceProfit(456500.0);
		horse.setYearProfit(211400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JO CROWLEY"));
		horse.setOwner(owner("MRS JACKIE CORNWELL"));
		// no rancher
		horse.setJockey(jockey("ADAM BESCHIZZA"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 2 - LUCKY DI
	 * HorseID - LUCKY DI
	 */
	public static HorseID builderHorse_R6_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("LUCKY DI");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ARAAFA");
		horseID.setMother("LUCKY DATE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 2 - LUCKY DI
	 */

	public static Horse builderHorse_R6_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(62.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(3085600.0);
		// no previous year profit
		horse.setVictoryProfit(2258000.0);
		horse.setPlaceProfit(827600.0);
		horse.setYearProfit(991800.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PETER HEDGER"));
		horse.setOwner(owner("P C F RACING LTD"));
		// no rancher
		horse.setJockey(jockey("MARTIN LANE"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 3 - CAPELITA
	 * HorseID - CAPELITA
	 */
	public static HorseID builderHorse_R6_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CAPELITA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CAPE CROSS");
		horseID.setMother("ZAMHREAR");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 3 - CAPELITA
	 */

	public static Horse builderHorse_R6_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(61.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(426900.0);
		// no previous year profit
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(426900.0);
		horse.setYearProfit(243100.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CLIVE BRITTAIN"));
		horse.setOwner(owner("MR SAEED MANANA"));
		// no rancher
		horse.setJockey(jockey("JIM CROWLEY"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 4 - SAKHEE'S ROSE
	 * HorseID - SAKHEE'S ROSE
	 */
	public static HorseID builderHorse_R6_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SAKHEE'S ROSE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SAKHEE'S SECRET");
		horseID.setMother("ISOBEL ROSE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 4 - SAKHEE'S ROSE
	 */

	public static Horse builderHorse_R6_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(61.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1661000.0);
		// no previous year profit
		horse.setVictoryProfit(1007000.0);
		horse.setPlaceProfit(653900.0);
		horse.setYearProfit(938200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("ED MCMAHON"));
		horse.setOwner(owner("MR J. R. DWYER"));
		// no rancher
		horse.setJockey(jockey("GEORGE BAKER"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 5 - DEAR BRUIN
	 * HorseID - DEAR BRUIN
	 */
	public static HorseID builderHorse_R6_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("DEAR BRUIN");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("KODIAC");
		horseID.setMother("NAMU");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 5 - DEAR BRUIN
	 */

	public static Horse builderHorse_R6_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		horse.setWeight(60.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(933500.0);
		// no previous year profit
		horse.setVictoryProfit(430200.0);
		horse.setPlaceProfit(503200.0);
		horse.setYearProfit(781600.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHN SPEARING"));
		horse.setOwner(owner("ADVANTAGE CHEMICALS HOLDINGS LTD"));
		// no rancher
		horse.setJockey(jockey("TOM MARQUAND"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 6 - HIPZ
	 * HorseID - HIPZ
	 */
	public static HorseID builderHorse_R6_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("HIPZ");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("INTENSE FOCUS");
		horseID.setMother("RADHA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 6 - HIPZ
	 */

	public static Horse builderHorse_R6_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(11);
		// no stable
		horse.setWeight(60.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(2334100.0);
		// no previous year profit
		horse.setVictoryProfit(1463500.0);
		horse.setPlaceProfit(870600.0);
		horse.setYearProfit(999600.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("LAURA MONGAN"));
		horse.setOwner(owner("ABERDOUR RACING CLUB"));
		// no rancher
		horse.setJockey(jockey("MEGAN NICHOLLS"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 7 - BALAYAGE
	 * HorseID - BALAYAGE
	 */
	public static HorseID builderHorse_R6_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BALAYAGE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("INVINCIBLE SPIRIT");
		horseID.setMother("SHAMWARI LODGE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 7 - BALAYAGE
	 */

	public static Horse builderHorse_R6_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H7_ID());
		horse.setNumber(7);
		horse.setRunner(false);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(10);
		// no stable
		horse.setWeight(60.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(201500.0);
		// no previous year profit
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(201500.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("MARCO BOTTI"));
		horse.setOwner(owner("MR MARC KELLER"));
		// no rancher
		horse.setJockey(jockey("DANIEL MUSCUTT"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 8 - QUITE A STORY
	 * HorseID - QUITE A STORY
	 */
	public static HorseID builderHorse_R6_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("QUITE A STORY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("EQUIANO");
		horseID.setMother("PERFECT STORY");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 8 - QUITE A STORY
	 */

	public static Horse builderHorse_R6_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(12);
		// no stable
		horse.setWeight(60.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(633100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(411900.0);
		horse.setPlaceProfit(221200.0);
		horse.setYearProfit(633200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("CLIVE COX"));
		horse.setOwner(owner("MILDMAY RACING & D. H. CASLON"));
		// no rancher
		horse.setJockey(jockey("ADAM KIRBY"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 9 - MOUNTAIN MUSIC
	 * HorseID - MOUNTAIN MUSIC
	 */
	public static HorseID builderHorse_R6_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MOUNTAIN MUSIC");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("THREE VALLEYS");
		horseID.setMother("MEADOW FLOSS");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 9 - MOUNTAIN MUSIC
	 */

	public static Horse builderHorse_R6_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(378400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(347800.0);
		horse.setPlaceProfit(30500.0);
		horse.setYearProfit(378400.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("SYLVESTER KIRK"));
		horse.setOwner(owner("MR D. J. HUELIN"));
		// no rancher
		horse.setJockey(jockey("PAT DOBBS"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 10 - BABYFACT
	 * HorseID - BABYFACT
	 */
	public static HorseID builderHorse_R6_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BABYFACT");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("PICCOLO");
		horseID.setMother("PENNYSPIDER");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 10 - BABYFACT
	 */

	public static Horse builderHorse_R6_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(58.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(553200.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(320400.0);
		horse.setPlaceProfit(232800.0);
		horse.setYearProfit(553200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MALCOLM SAUNDERS"));
		horse.setOwner(owner("MRS GINNY NICHOLAS"));
		// no rancher
		horse.setJockey(jockey("PAUL HANAGAN"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 11 - POTTERNELLO
	 * HorseID - POTTERNELLO
	 */
	public static HorseID builderHorse_R6_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("POTTERNELLO");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CAPTAIN MARVELOUS");
		horseID.setMother("PUREPLEASURESEEKER");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 11 - POTTERNELLO
	 */

	public static Horse builderHorse_R6_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		horse.setWeight(58.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(585900.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(320400.0);
		horse.setPlaceProfit(265500.0);
		horse.setYearProfit(585900.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MICK CHANNON"));
		horse.setOwner(owner("MR M. CHANNON"));
		// no rancher
		horse.setJockey(jockey("TED DURCAN"));

		return horse;

	}

	/*
	 * Race 6
	 * Horse 12 - SASKIA'S DREAM
	 * HorseID - SASKIA'S DREAM
	 */
	public static HorseID builderHorse_R6_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SASKIA'S DREAM");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("OASIS DREAM");
		horseID.setMother("SWYNFORD PLEASURE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 6
	 * Horse 12 - SASKIA'S DREAM
	 */

	public static Horse builderHorse_R6_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R6_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		horse.setWeight(56.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(2874100.0);
		// no previous year profit
		horse.setVictoryProfit(1138100.0);
		horse.setPlaceProfit(1735900.0);
		horse.setYearProfit(464500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JANE CHAPPLE-HYAM"));
		horse.setOwner(owner("MR P. BOTTOMLEY"));
		// no rancher
		horse.setJockey(jockey("JAMIE SPENCER"));

		return horse;

	}

	/*
	 * Race 6
	 * Odds 1 - 13/08/2015 16:52:45 +0200
	 */

	public static Odds builderOdds_R6_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 16:52:45 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 7.8));
		simples.add(simple(odds, "2", 52.2));
		simples.add(simple(odds, "3", 4.6));
		simples.add(simple(odds, "4", 6.5));
		simples.add(simple(odds, "5", 13.0));
		simples.add(simple(odds, "6", 13.0));
		simples.add(simple(odds, "7", 10.2));
		simples.add(simple(odds, "8", 5.6));
		simples.add(simple(odds, "9", 17.4));
		simples.add(simple(odds, "10", 10.4));
		simples.add(simple(odds, "11", 10.4));
		simples.add(simple(odds, "12", 9.2));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 6
	 * Odds 2 - 13/08/2015 17:57:23 +0200
	 */

	public static Odds builderOdds_R6_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 17:57:23 +0200"));
		odds.setTotal(75103.21);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 9.1));
		simples.add(simple(odds, "2", 21.0));
		simples.add(simple(odds, "3", 9.0));
		simples.add(simple(odds, "4", 12.7));
		simples.add(simple(odds, "5", 6.1));
		simples.add(simple(odds, "6", 8.8));
		simples.add(simple(odds, "7", 15.6));
		simples.add(simple(odds, "8", 3.5));
		simples.add(simple(odds, "9", 17.6));
		simples.add(simple(odds, "10", 13.0));
		simples.add(simple(odds, "11", 18.6));
		simples.add(simple(odds, "12", 10.6));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7 - THE KEVIN HALL AND PAT BOAKES MEMORIAL HANDICAP STAKES
	 */

	public static Race builderRace_R7(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(7);
		race.setName("THE KEVIN HALL AND PAT BOAKES MEMORIAL HANDICAP STAKES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 18:25:00 +0200"));
		// no real start
		race.setDistance(2800.0);
		race.setBenefit(11322.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.HANDICAP));

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
		places.add(place(race, 1, 4));
		places.add(place(race, 2, 9, "UNE_LONGUEUR"));
		places.add(place(race, 3, 6, "CINQ_LONGUEURS"));
		places.add(place(race, 4, 5, "DEMI_LONGUEUR"));
		places.add(place(race, 5, 8, "UNE_LONGUEUR"));
		places.add(place(race, 6, 3, "TROIS_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 7, 2, "SEPT_LONGUEURS"));
		places.add(place(race, 8, 1, "TREIZE_LONGUEURS"));
		places.add(place(race, 9, 7, "LOIN"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 6.3, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.2, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.1, "6"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.3, "9"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 69.2, "4 9"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 32.6, "4 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 8.0, "4 6"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 10.2, "4 9"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 11.0, "9 6"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 84.1, "4 9 6"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 7
	 * Horse 1 - L'INGENUE
	 * HorseID - L'INGENUE
	 */
	public static HorseID builderHorse_R7_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("L'INGENUE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("NEW APPROACH");
		horseID.setMother("GREEN ROOM");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 1 - L'INGENUE
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
		horse.setWeight(60.0);
		horse.setDistance(2800.0);
		horse.setCareerProfit(610900.0);
		// no previous year profit
		horse.setVictoryProfit(457800.0);
		horse.setPlaceProfit(153100.0);
		horse.setYearProfit(556300.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("RALPH BECKETT"));
		horse.setOwner(owner("NIGEL & CAROLYN ELWES"));
		// no rancher
		horse.setJockey(jockey("PATRICK O'DONNELL"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 2 - IRISH HAWKE
	 * HorseID - IRISH HAWKE
	 */
	public static HorseID builderHorse_R7_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("IRISH HAWKE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("MONTJEU");
		horseID.setMother("AHDAAB");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 2 - IRISH HAWKE
	 */

	public static Horse builderHorse_R7_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(2800.0);
		horse.setCareerProfit(483700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(439400.0);
		horse.setPlaceProfit(44200.0);
		horse.setYearProfit(483700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("LUCA CUMANI"));
		horse.setOwner(owner("MR JON S. KELLY"));
		// no rancher
		horse.setJockey(jockey("ADAM KIRBY"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 3 - EMIRATES SKYWARDS
	 * HorseID - EMIRATES SKYWARDS
	 */
	public static HorseID builderHorse_R7_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("EMIRATES SKYWARDS");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DUBAWI");
		horseID.setMother("MONT ETOILE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 3 - EMIRATES SKYWARDS
	 */

	public static Horse builderHorse_R7_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(59.0);
		horse.setDistance(2800.0);
		horse.setCareerProfit(811900.0);
		// no previous year profit
		horse.setVictoryProfit(457800.0);
		horse.setPlaceProfit(354000.0);
		horse.setYearProfit(457700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("CHARLIE APPLEBY"));
		horse.setOwner(owner("GODOLPHIN"));
		// no rancher
		horse.setJockey(jockey("MARTIN LANE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 4 - THE TWISLER
	 * HorseID - THE TWISLER
	 */
	public static HorseID builderHorse_R7_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("THE TWISLER");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MOTIVATOR");
		horseID.setMother("PANNA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 4 - THE TWISLER
	 */

	public static Horse builderHorse_R7_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(57.5);
		horse.setDistance(2800.0);
		horse.setCareerProfit(353600.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(353600.0);
		horse.setYearProfit(353700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JANE CHAPPLE-HYAM"));
		horse.setOwner(owner("KWIKDELIVERY LIMITED"));
		// no rancher
		horse.setJockey(jockey("JAMIE SPENCER"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 5 - ISAMOL
	 * HorseID - ISAMOL
	 */
	public static HorseID builderHorse_R7_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ISAMOL");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("INTIKHAB");
		horseID.setMother("UVINZA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 5 - ISAMOL
	 */

	public static Horse builderHorse_R7_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		horse.setWeight(57.5);
		horse.setDistance(2800.0);
		horse.setCareerProfit(594900.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(411900.0);
		horse.setPlaceProfit(182900.0);
		horse.setYearProfit(595000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("AMANDA PERRETT"));
		horse.setOwner(owner("JOHN CONNOLLY & ODILE GRIFFITH"));
		// no rancher
		horse.setJockey(jockey("JIM CROWLEY"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 6 - STAR RIDER
	 * HorseID - STAR RIDER
	 */
	public static HorseID builderHorse_R7_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("STAR RIDER");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CAPE CROSS");
		horseID.setMother("STARFALA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 6 - STAR RIDER
	 */

	public static Horse builderHorse_R7_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2800.0);
		horse.setCareerProfit(845400.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(549200.0);
		horse.setPlaceProfit(296200.0);
		horse.setYearProfit(845500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("HUGHIE MORRISON"));
		horse.setOwner(owner("BEN & SIR MARTYN ARBIB"));
		// no rancher
		horse.setJockey(jockey("JIMMY FORTUNE"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 7 - MASHKOOR APPROACH
	 * HorseID - MASHKOOR APPROACH
	 */
	public static HorseID builderHorse_R7_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MASHKOOR APPROACH");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("NEW APPROACH");
		horseID.setMother("WINNERS CHANT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 7 - MASHKOOR APPROACH
	 */

	public static Horse builderHorse_R7_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(2800.0);
		horse.setCareerProfit(224700.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(224700.0);
		horse.setYearProfit(224700.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("SIR MICHAEL STOUTE"));
		horse.setOwner(owner("MR SAEED SUHAIL"));
		// no rancher
		horse.setJockey(jockey("TED DURCAN"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 8 - OPERA LAD
	 * HorseID - OPERA LAD
	 */
	public static HorseID builderHorse_R7_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("OPERA LAD");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("TEOFILO");
		horseID.setMother("OPERA GLASS");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 8 - OPERA LAD
	 */

	public static Horse builderHorse_R7_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(56.5);
		horse.setDistance(2800.0);
		horse.setCareerProfit(519100.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(457800.0);
		horse.setPlaceProfit(61200.0);
		horse.setYearProfit(519000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ANDREW BALDING"));
		horse.setOwner(owner("MR J. C. SMITH"));
		// no rancher
		horse.setJockey(jockey("DAVID PROBERT"));

		return horse;

	}

	/*
	 * Race 7
	 * Horse 9 - DIAMOND JOEL
	 * HorseID - DIAMOND JOEL
	 */
	public static HorseID builderHorse_R7_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("DIAMOND JOEL");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("YOUMZAIN");
		horseID.setMother("MISS LACROIX");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 7
	 * Horse 9 - DIAMOND JOEL
	 */

	public static Horse builderHorse_R7_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R7_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(2800.0);
		horse.setCareerProfit(1341100.0);
		// no previous year profit
		horse.setVictoryProfit(915500.0);
		horse.setPlaceProfit(425500.0);
		horse.setYearProfit(1300200.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MICK CHANNON"));
		horse.setOwner(owner("MRS NORMA HARRIS"));
		// no rancher
		horse.setJockey(jockey("DANIEL CREMIN"));

		return horse;

	}

	/*
	 * Race 7
	 * Odds 1 - 13/08/2015 14:57:52 +0200
	 */

	public static Odds builderOdds_R7_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 14:57:52 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 3.4));
		simples.add(simple(odds, "2", 5.2));
		simples.add(simple(odds, "3", 4.9));
		simples.add(simple(odds, "4", 10.3));
		simples.add(simple(odds, "5", 9.4));
		simples.add(simple(odds, "6", 10.3));
		simples.add(simple(odds, "7", 15.1));
		simples.add(simple(odds, "8", 25.2));
		simples.add(simple(odds, "9", 10.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 7
	 * Odds 2 - 13/08/2015 18:28:34 +0200
	 */

	public static Odds builderOdds_R7_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 18:28:34 +0200"));
		odds.setTotal(76449.77);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 7.0));
		simples.add(simple(odds, "2", 5.6));
		simples.add(simple(odds, "3", 3.9));
		simples.add(simple(odds, "4", 6.3));
		simples.add(simple(odds, "5", 8.0));
		simples.add(simple(odds, "6", 10.7));
		simples.add(simple(odds, "7", 9.6));
		simples.add(simple(odds, "8", 18.2));
		simples.add(simple(odds, "9", 12.5));
		odds.setSimples(simples);

		return odds;

	}

}
