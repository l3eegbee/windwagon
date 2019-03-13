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

public class Meeting_20150813_M5 extends MeetingBuilder {

	public static Meeting build() {

		Meeting meeting = new Meeting();

		meeting.setDate(parse("13/08/2015 00:00:00 +0200"));
		meeting.setRacecourse(racecourse("LEOPARDSTOWN", "IRLANDE"));
		meeting.setNumber(5);
		meeting.setWindSpeed(11.0);
		meeting.setWindDirection(WindDirection.NE);
		meeting.setTemperature(17.0);
		meeting.setClimat("TRES NUAGEUX");
		meeting.setField(Field.BON);

		// -- races --
		SortedSet<Race> races = new TreeSet<>();
		races.add(builderRace_R2(meeting));
		races.add(builderRace_R3(meeting));
		races.add(builderRace_R4(meeting));
		races.add(builderRace_R5(meeting));
		meeting.setRaces(races);

		return meeting;

	}

	/*
	 * Race 2 - THE EBF FILLIES HANDICAP
	 */

	public static Race builderRace_R2(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(2);
		race.setName("THE EBF FILLIES HANDICAP");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 18:55:00 +0200"));
		// no real start
		race.setDistance(1200.0);
		race.setBenefit(19000.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.HANDICAP));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R2_H1(race));
		horses.add(builderHorse_R2_H2(race));
		horses.add(builderHorse_R2_H3(race));
		horses.add(builderHorse_R2_H4(race));
		horses.add(builderHorse_R2_H5(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R2_O1(race));
		oddsSet.add(builderOdds_R2_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 3));
		places.add(place(race, 2, 4, "UNE_LONGUEUR_ET_QUART"));
		places.add(place(race, 3, 2, "UNE_TETE"));
		places.add(place(race, 4, 5, "TROIS_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 5, 1, "UNE_LONGUEUR"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 4.8, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.9, "3"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.1, "4"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 14.6, "3 4"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 2
	 * Horse 1 - OCTAVIA
	 * HorseID - OCTAVIA
	 */
	public static HorseID builderHorse_R2_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("OCTAVIA");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ACCLAMATION");
		horseID.setMother("DANAMIGHT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 1 - OCTAVIA
	 */

	public static Horse builderHorse_R2_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(60.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(2020500.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(945000.0);
		horse.setPlaceProfit(1075500.0);
		horse.setYearProfit(2020500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("DAVID MARNANE"));
		horse.setOwner(owner("GLOBAL EQUINE SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("C.R. KING"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 2 - BAINNE
	 * HorseID - BAINNE
	 */
	public static HorseID builderHorse_R2_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BAINNE");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("STRATEGIC PRINCE");
		horseID.setMother("LAEMEEN");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 2 - BAINNE
	 */

	public static Horse builderHorse_R2_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(58.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(3695500.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(3027500.0);
		horse.setPlaceProfit(668000.0);
		horse.setYearProfit(850000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M.D. O'CALLAGHAN"));
		horse.setOwner(owner("MORNING FRESH SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("S.B. KELLY"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 3 - CREGGS PIPES
	 * HorseID - CREGGS PIPES
	 */
	public static HorseID builderHorse_R2_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CREGGS PIPES");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("RIP VAN WINKLE");
		horseID.setMother("SOPHIE GERMAIN");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 3 - CREGGS PIPES
	 */

	public static Horse builderHorse_R2_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(59.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1421500.0);
		horse.setPreviousYearProfit(162500.0);
		horse.setVictoryProfit(875000.0);
		horse.setPlaceProfit(546500.0);
		horse.setYearProfit(1259000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("ANDREW SLATTERY"));
		horse.setOwner(owner("DELPHI SIX SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("D.P. MCDONOGH"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 4 - PEACE MISSION
	 * HorseID - PEACE MISSION
	 */
	public static HorseID builderHorse_R2_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PEACE MISSION");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ALFRED NOBEL");
		horseID.setMother("BREACH OF PEACE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 4 - PEACE MISSION
	 */

	public static Horse builderHorse_R2_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(59.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(957000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(770000.0);
		horse.setPlaceProfit(187000.0);
		horse.setYearProfit(957000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("THOMAS MULLINS"));
		horse.setOwner(owner("MELVYN J. KENNEDY"));
		// no rancher
		horse.setJockey(jockey("G.F. CARROLL"));

		return horse;

	}

	/*
	 * Race 2
	 * Horse 5 - LOCAL FLIER
	 * HorseID - LOCAL FLIER
	 */
	public static HorseID builderHorse_R2_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("LOCAL FLIER");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("BYRON");
		horseID.setMother("LOCAL FANCY");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 2
	 * Horse 5 - LOCAL FLIER
	 */

	public static Horse builderHorse_R2_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R2_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(58.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(2457500.0);
		horse.setPreviousYearProfit(2457500.0);
		horse.setVictoryProfit(1750000.0);
		horse.setPlaceProfit(707500.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("T.G.MCCOURT"));
		horse.setOwner(owner("MISS SARAH FORAN"));
		// no rancher
		horse.setJockey(jockey("COLIN KEANE"));

		return horse;

	}

	/*
	 * Race 2
	 * Odds 1 - 13/08/2015 18:36:55 +0200
	 */

	public static Odds builderOdds_R2_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 18:36:55 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 2.8));
		simples.add(simple(odds, "2", 7.5));
		simples.add(simple(odds, "3", 4.6));
		simples.add(simple(odds, "4", 2.8));
		simples.add(simple(odds, "5", 7.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 2
	 * Odds 2 - 13/08/2015 18:55:42 +0200
	 */

	public static Odds builderOdds_R2_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 18:55:42 +0200"));
		odds.setTotal(43.36);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 2.2));
		simples.add(simple(odds, "2", 2.9));
		simples.add(simple(odds, "3", 4.8));
		simples.add(simple(odds, "4", 5.5));
		simples.add(simple(odds, "5", 13.7));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3 - THE BULMERS ORIGINAL SUMMIT MUSIC NIGHT HANDICAP
	 */

	public static Race builderRace_R3(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(3);
		race.setName("THE BULMERS ORIGINAL SUMMIT MUSIC NIGHT HANDICAP");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 19:25:00 +0200"));
		// no real start
		race.setDistance(1200.0);
		race.setBenefit(9000.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.HANDICAP));

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
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE, BetType.COUPLE_GAGNANT, BetType.COUPLE_PLACE, BetType.TRIO, BetType.DEUX_SUR_QUATRE, BetType.MULTI_EN_QUATRE, BetType.MULTI_EN_CINQ, BetType.MULTI_EN_SIX));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R3_O1(race));
		oddsSet.add(builderOdds_R3_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 4));
		places.add(place(race, 2, 1, "UN_NEZ"));
		places.add(place(race, 3, 11, "DEMI_LONGUEUR"));
		places.add(place(race, 4, 3, "DEMI_LONGUEUR"));
		places.add(place(race, 5, 7, "UNE_LONGUEUR_ET_QUART"));
		places.add(place(race, 6, 6, "TROIS_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 7, 5, "UNE_LONGUEUR"));
		places.add(place(race, 8, 2, "TROIS_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 9, 9, "UNE_LONGUEUR_TROIS_QUARTS"));
		places.add(place(race, 10, 10, "UN_NEZ"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 9.6, "4"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.8, "1"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 3.7, "11"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.9, "4"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 27.3, "4 1"));
		prices.add(price(race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, 10.8, "4 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 17.8, "1 11"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 7.4, "4 1"));
		prices.add(price(race, BetType.COUPLE_PLACE, PriceName.DIRECT, 25.3, "4 11"));
		prices.add(price(race, BetType.TRIO, PriceName.DIRECT, 129.9, "4 1 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "1 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "1 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "11 3"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "4 1"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "4 11"));
		prices.add(price(race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, 8.0, "4 3"));
		prices.add(price(race, BetType.MULTI_EN_QUATRE, PriceName.DIRECT, 417.0, "4 1 11 3"));
		prices.add(price(race, BetType.MULTI_EN_CINQ, PriceName.DIRECT, 83.4, "4 1 11 3"));
		prices.add(price(race, BetType.MULTI_EN_SIX, PriceName.DIRECT, 27.8, "4 1 11 3"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 3
	 * Horse 1 - CAPTAIN POWER
	 * HorseID - CAPTAIN POWER
	 */
	public static HorseID builderHorse_R3_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CAPTAIN POWER");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("CAPTAIN RIO");
		horseID.setMother("INVINCIBLE POWER");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 1 - CAPTAIN POWER
	 */

	public static Horse builderHorse_R3_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(7);
		// no stable
		horse.setWeight(62.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1987500.0);
		horse.setPreviousYearProfit(72500.0);
		horse.setVictoryProfit(1540000.0);
		horse.setPlaceProfit(447500.0);
		horse.setYearProfit(1915000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("EDWARD LYNAM"));
		horse.setOwner(owner("MRS S POWER PARTNERSHIP"));
		// no rancher
		horse.setJockey(jockey("R.P. DOWNEY"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 2 - ISHEBAYORGREY
	 * HorseID - ISHEBAYORGREY
	 */
	public static HorseID builderHorse_R3_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ISHEBAYORGREY");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("CLODOVIL");
		horseID.setMother("SUPERJET");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 2 - ISHEBAYORGREY
	 */

	public static Horse builderHorse_R3_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(11);
		// no stable
		horse.setWeight(61.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(3339000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(2695000.0);
		horse.setPlaceProfit(644000.0);
		horse.setYearProfit(3339000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PATRICK MARTIN"));
		horse.setOwner(owner("RAYMOND C. MOORE"));
		// no rancher
		horse.setJockey(jockey("C.T. KEANE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 3 - OOR JOCK
	 * HorseID - OOR JOCK
	 */
	public static HorseID builderHorse_R3_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("OOR JOCK");
		horseID.setBirth(parse("01/01/2008 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("SHAMARDAL");
		horseID.setMother("KATDOGAWN");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 3 - OOR JOCK
	 */

	public static Horse builderHorse_R3_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(12);
		// no stable
		horse.setWeight(61.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(6476500.0);
		horse.setPreviousYearProfit(2305500.0);
		horse.setVictoryProfit(3134000.0);
		horse.setPlaceProfit(3342500.0);
		horse.setYearProfit(1394500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("ADRIAN MCGUINNESS"));
		horse.setOwner(owner("T. HEATRICK"));
		// no rancher
		horse.setJockey(jockey("D.P. MCDONOGH"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 4 - THREE BELLS
	 * HorseID - THREE BELLS
	 */
	public static HorseID builderHorse_R3_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("THREE BELLS");
		horseID.setBirth(parse("01/01/2009 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("MOSS VALE");
		horseID.setMother("SILVER SPOON");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 4 - THREE BELLS
	 */

	public static Horse builderHorse_R3_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(59.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(3125700.0);
		horse.setPreviousYearProfit(652500.0);
		horse.setVictoryProfit(2187500.0);
		horse.setPlaceProfit(938200.0);
		horse.setYearProfit(1028500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PATRICK DOWNEY"));
		horse.setOwner(owner("BELLS SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("W.M. LORDAN"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 5 - NANCY ASTOR
	 * HorseID - NANCY ASTOR
	 */
	public static HorseID builderHorse_R3_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("NANCY ASTOR");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SHAMARDAL");
		horseID.setMother("SUMMER'S LEASE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 5 - NANCY ASTOR
	 */

	public static Horse builderHorse_R3_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(58.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(0.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("PATRICK J.FLYNN"));
		horse.setOwner(owner("MRS B. COONEY"));
		// no rancher
		horse.setJockey(jockey("D.M. GRANT"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 6 - GLIMMER OF PEACE
	 * HorseID - GLIMMER OF PEACE
	 */
	public static HorseID builderHorse_R3_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("GLIMMER OF PEACE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("INTIKHAB");
		horseID.setMother("MAGICAL PEACE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 6 - GLIMMER OF PEACE
	 */

	public static Horse builderHorse_R3_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(58.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(504500.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(504500.0);
		horse.setYearProfit(504500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("W. MCCREERY"));
		horse.setOwner(owner("JOHN MALONE"));
		// no rancher
		horse.setJockey(jockey("P.J. SMULLEN"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 7 - TOM DOOLEY
	 * HorseID - TOM DOOLEY
	 */
	public static HorseID builderHorse_R3_H7_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TOM DOOLEY");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("DYLAN THOMAS");
		horseID.setMother("SHIZAO");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 7 - TOM DOOLEY
	 */

	public static Horse builderHorse_R3_H7(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H7_ID());
		horse.setNumber(7);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(13);
		// no stable
		horse.setWeight(57.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(3146500.0);
		horse.setPreviousYearProfit(1120000.0);
		horse.setVictoryProfit(1680000.0);
		horse.setPlaceProfit(1466500.0);
		horse.setYearProfit(1689000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MICHAEL MULVANY"));
		horse.setOwner(owner("L.MULVANY"));
		// no rancher
		horse.setJockey(jockey("G.F. CARROLL"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 8 - PRETTY FAMOUS
	 * HorseID - PRETTY FAMOUS
	 */
	public static HorseID builderHorse_R3_H8_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("PRETTY FAMOUS");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("INVINCIBLE SPIRIT");
		horseID.setMother("INFAMOUS ANGEL");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 8 - PRETTY FAMOUS
	 */

	public static Horse builderHorse_R3_H8(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H8_ID());
		horse.setNumber(8);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(10);
		// no stable
		horse.setWeight(56.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(136000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(136000.0);
		horse.setYearProfit(136000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A. OLIVER"));
		horse.setOwner(owner("PRETTY FAMOUS PARTNERSHIP"));
		// no rancher
		horse.setJockey(jockey("C.D. HAYES"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 9 - COUNT OF CARABASS
	 * HorseID - COUNT OF CARABASS
	 */
	public static HorseID builderHorse_R3_H9_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("COUNT OF CARABASS");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("AD VALOREM");
		horseID.setMother("THREE PENNIES");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 9 - COUNT OF CARABASS
	 */

	public static Horse builderHorse_R3_H9(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H9_ID());
		horse.setNumber(9);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(8);
		// no stable
		horse.setWeight(55.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1407500.0);
		horse.setPreviousYearProfit(1234000.0);
		horse.setVictoryProfit(700000.0);
		horse.setPlaceProfit(707500.0);
		horse.setYearProfit(123500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MISS HILARY MCLOUGHLIN"));
		horse.setOwner(owner("GOLD & BLUE SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("J.A. HEFFERNAN"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 10 - SHOWCARD
	 * HorseID - SHOWCARD
	 */
	public static HorseID builderHorse_R3_H10_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("SHOWCARD");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("SHOWCASING");
		horseID.setMother("DIMAKYA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 10 - SHOWCARD
	 */

	public static Horse builderHorse_R3_H10(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H10_ID());
		horse.setNumber(10);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(55.0);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1245000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(1190000.0);
		horse.setPlaceProfit(55000.0);
		horse.setYearProfit(1245000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHN JAMES FEANE"));
		horse.setOwner(owner("JOHN JAMES FEANE"));
		// no rancher
		horse.setJockey(jockey("F.M. BERRY"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 11 - ACROLEINA
	 * HorseID - ACROLEINA
	 */
	public static HorseID builderHorse_R3_H11_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("ACROLEINA");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("CAPTAIN GERRARD");
		horseID.setMother("ASK JENNY");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 11 - ACROLEINA
	 */

	public static Horse builderHorse_R3_H11(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H11_ID());
		horse.setNumber(11);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(54.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(1257500.0);
		horse.setPreviousYearProfit(60000.0);
		horse.setVictoryProfit(525000.0);
		horse.setPlaceProfit(732500.0);
		horse.setYearProfit(1197500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("H.ROGERS"));
		horse.setOwner(owner("MRS S. BURY"));
		// no rancher
		horse.setJockey(jockey("S. FOLEY"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 12 - JEMBATT
	 * HorseID - JEMBATT
	 */
	public static HorseID builderHorse_R3_H12_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("JEMBATT");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("CAPTAIN RIO");
		horseID.setMother("SILLY IMP");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 12 - JEMBATT
	 */

	public static Horse builderHorse_R3_H12(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H12_ID());
		horse.setNumber(12);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(52.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(5671700.0);
		horse.setPreviousYearProfit(797500.0);
		horse.setVictoryProfit(3622500.0);
		horse.setPlaceProfit(2049200.0);
		horse.setYearProfit(114500.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("MICHAEL MULVANY"));
		horse.setOwner(owner("MIGHTY FOUR SYNDICATE"));
		// no rancher
		horse.setJockey(jockey("L.F. ROCHE"));

		return horse;

	}

	/*
	 * Race 3
	 * Horse 13 - TROJAN VALLEY
	 * HorseID - TROJAN VALLEY
	 */
	public static HorseID builderHorse_R3_H13_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TROJAN VALLEY");
		horseID.setBirth(parse("01/01/2010 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ANTONIUS PIUS");
		horseID.setMother("MIKES BABY");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 3
	 * Horse 13 - TROJAN VALLEY
	 */

	public static Horse builderHorse_R3_H13(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R3_H13_ID());
		horse.setNumber(13);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(9);
		// no stable
		horse.setWeight(52.5);
		horse.setDistance(1200.0);
		horse.setCareerProfit(0.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KEITH HENRY CLARKE"));
		horse.setOwner(owner("CONALL TOAL"));
		// no rancher
		horse.setJockey(jockey("C.P. HOBAN"));

		return horse;

	}

	/*
	 * Race 3
	 * Odds 1 - 13/08/2015 19:03:21 +0200
	 */

	public static Odds builderOdds_R3_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:03:21 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 6.5));
		simples.add(simple(odds, "2", 4.7));
		simples.add(simple(odds, "3", 6.5));
		simples.add(simple(odds, "5", 9.4));
		simples.add(simple(odds, "6", 5.6));
		simples.add(simple(odds, "7", 14.1));
		simples.add(simple(odds, "8", 11.5));
		simples.add(simple(odds, "9", 28.2));
		simples.add(simple(odds, "11", 14.1));
		simples.add(simple(odds, "12", 21.1));
		simples.add(simple(odds, "13", 14.1));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 3
	 * Odds 2 - 13/08/2015 19:25:57 +0200
	 */

	public static Odds builderOdds_R3_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:25:57 +0200"));
		odds.setTotal(50.18);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 3.7));
		simples.add(simple(odds, "2", 4.4));
		simples.add(simple(odds, "3", 10.9));
		simples.add(simple(odds, "4", 9.6));
		simples.add(simple(odds, "5", 41.2));
		simples.add(simple(odds, "6", 6.0));
		simples.add(simple(odds, "7", 12.7));
		simples.add(simple(odds, "8", 13.1));
		simples.add(simple(odds, "9", 24.1));
		simples.add(simple(odds, "10", 16.8));
		simples.add(simple(odds, "11", 14.6));
		simples.add(simple(odds, "12", 31.3));
		simples.add(simple(odds, "13", 44.3));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4 - THE EBF MAIDEN
	 */

	public static Race builderRace_R4(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(4);
		race.setName("THE EBF MAIDEN");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 19:55:00 +0200"));
		// no real start
		race.setDistance(1600.0);
		race.setBenefit(16500.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.CONDITIONS));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R4_H1(race));
		horses.add(builderHorse_R4_H2(race));
		horses.add(builderHorse_R4_H3(race));
		horses.add(builderHorse_R4_H4(race));
		horses.add(builderHorse_R4_H5(race));
		horses.add(builderHorse_R4_H6(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R4_O1(race));
		oddsSet.add(builderOdds_R4_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 6));
		places.add(place(race, 2, 5, "QUATRE_LONGUEURS_ET_DEMIE"));
		places.add(place(race, 3, 4, "DEMI_LONGUEUR"));
		places.add(place(race, 4, 1, "DEMI_LONGUEUR"));
		places.add(place(race, 5, 3, "ONZE_LONGUEURS"));
		places.add(place(race, 6, 2, "ENCOLURE"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 1.2, "6"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 2.1, "5"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.1, "6"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 3.2, "6 5"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 4
	 * Horse 1 - CHURCHILL D
	 * HorseID - CHURCHILL D
	 */
	public static HorseID builderHorse_R4_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CHURCHILL D");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("TIZNOW");
		horseID.setMother("MOUSSE AU CHOCOLAT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 1 - CHURCHILL D
	 */

	public static Horse builderHorse_R4_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(6);
		// no stable
		horse.setWeight(58.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(0.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J.P. MURTAGH"));
		horse.setOwner(owner("ANTHONY PAUL SMURFIT"));
		// no rancher
		horse.setJockey(jockey("C.R. KING"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 2 - HUNTERS POINT
	 * HorseID - HUNTERS POINT
	 */
	public static HorseID builderHorse_R4_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("HUNTERS POINT");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("HOLY ROMAN EMPEROR");
		horseID.setMother("FAIRY DANCE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 2 - HUNTERS POINT
	 */

	public static Horse builderHorse_R4_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(0.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("JOHN C. MCCONNELL"));
		horse.setOwner(owner("DEREK KIERANS"));
		// no rancher
		horse.setJockey(jockey("G.F. CARROLL"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 3 - MOGAZ
	 * HorseID - MOGAZ
	 */
	public static HorseID builderHorse_R4_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MOGAZ");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("SAKHEE'S SECRET");
		horseID.setMother("TINA'S SPIRIT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 3 - MOGAZ
	 */

	public static Horse builderHorse_R4_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(80000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(80000.0);
		horse.setYearProfit(80000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KEVIN PRENDERGAST"));
		horse.setOwner(owner("HAMDAN AL MAKTOUM"));
		// no rancher
		horse.setJockey(jockey("C.D. HAYES"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 4 - MONOCLE
	 * HorseID - MONOCLE
	 */
	public static HorseID builderHorse_R4_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("MONOCLE");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("KING'S BEST");
		horseID.setMother("SPECTACLE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 4 - MONOCLE
	 */

	public static Horse builderHorse_R4_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(0.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(0.0);
		horse.setYearProfit(0.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("D. K. WELD"));
		horse.setOwner(owner("K. ABDULLAH"));
		// no rancher
		horse.setJockey(jockey("P.J. SMULLEN"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 5 - THEODORICO
	 * HorseID - THEODORICO
	 */
	public static HorseID builderHorse_R4_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("THEODORICO");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("TEOFILO");
		horseID.setMother("YES OH YES");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 5 - THEODORICO
	 */

	public static Horse builderHorse_R4_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(132000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(132000.0);
		horse.setYearProfit(132000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("J. S. BOLGER"));
		horse.setOwner(owner("GODOLPHIN"));
		// no rancher
		horse.setJockey(jockey("K.J. MANNING"));

		return horse;

	}

	/*
	 * Race 4
	 * Horse 6 - UNICORN
	 * HorseID - UNICORN
	 */
	public static HorseID builderHorse_R4_H6_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("UNICORN");
		horseID.setBirth(parse("01/01/2013 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("GALILEO");
		horseID.setMother("ONE MOMENT IN TIME");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 4
	 * Horse 6 - UNICORN
	 */

	public static Horse builderHorse_R4_H6(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R4_H6_ID());
		horse.setNumber(6);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(132000.0);
		horse.setPreviousYearProfit(0.0);
		horse.setVictoryProfit(0.0);
		horse.setPlaceProfit(132000.0);
		horse.setYearProfit(132000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A.P.O'BRIEN"));
		horse.setOwner(owner("DERRICK SMITH"));
		// no rancher
		horse.setJockey(jockey("J.P. O'BRIEN"));

		return horse;

	}

	/*
	 * Race 4
	 * Odds 1 - 13/08/2015 19:34:53 +0200
	 */

	public static Odds builderOdds_R4_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:34:53 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 3.3));
		simples.add(simple(odds, "2", 5.6));
		simples.add(simple(odds, "4", 5.6));
		simples.add(simple(odds, "5", 11.2));
		simples.add(simple(odds, "6", 2.2));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 4
	 * Odds 2 - 13/08/2015 19:56:31 +0200
	 */

	public static Odds builderOdds_R4_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 19:56:31 +0200"));
		odds.setTotal(20.0);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 9.1));
		simples.add(simple(odds, "2", 20.8));
		simples.add(simple(odds, "3", 22.7));
		simples.add(simple(odds, "4", 6.5));
		simples.add(simple(odds, "5", 8.2));
		simples.add(simple(odds, "6", 1.2));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5 - THE DESMOND STAKES
	 */

	public static Race builderRace_R5(Meeting meeting) {

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber(5);
		race.setName("THE DESMOND STAKES");
		race.setStatus(RaceStatus.FINISHED);
		race.setStart(parse("13/08/2015 20:25:00 +0200"));
		// no real start
		race.setDistance(1600.0);
		race.setBenefit(62500.0);
		race.setDiscipline(Discipline.PLAT);
		race.setTypes(EnumSet.of(Type.GROUPE_III));

		// -- horses --
		SortedSet<Horse> horses = new TreeSet<>();
		horses.add(builderHorse_R5_H1(race));
		horses.add(builderHorse_R5_H2(race));
		horses.add(builderHorse_R5_H3(race));
		horses.add(builderHorse_R5_H4(race));
		horses.add(builderHorse_R5_H5(race));
		race.setHorses(horses);

		// -- bets --
		race.setBets(EnumSet.of(BetType.SIMPLE_GAGNANT, BetType.SIMPLE_PLACE, BetType.COUPLE_ORDRE));

		// -- odds --
		SortedSet<Odds> oddsSet = new TreeSet<Odds>();
		oddsSet.add(builderOdds_R5_O1(race));
		oddsSet.add(builderOdds_R5_O2(race));
		race.setOdds(oddsSet);

		// no duration

		// -- finish --
		SortedSet<Place> places = new TreeSet<Place>();
		places.add(place(race, 1, 2));
		places.add(place(race, 2, 4, "TROIS_QUARTS_DE_LONGUEUR"));
		places.add(place(race, 3, 3, "UNE_TETE"));
		places.add(place(race, 4, 5, "UNE_LONGUEUR"));
		places.add(place(race, 5, 1, "DEMI_LONGUEUR"));
		race.setPlaces(places);

		// no stopped
		// no disqualified
		// no fallen

		// -- prices --
		SortedSet<Price> prices = new TreeSet<>();
		prices.add(price(race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, 1.8, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.1, "2"));
		prices.add(price(race, BetType.SIMPLE_PLACE, PriceName.DIRECT, 1.7, "4"));
		prices.add(price(race, BetType.COUPLE_ORDRE, PriceName.DIRECT, 3.9, "2 4"));
		race.setPrices(prices);

		return race;

	}

	/*
	 * Race 5
	 * Horse 1 - BOLD THADY QUILL
	 * HorseID - BOLD THADY QUILL
	 */
	public static HorseID builderHorse_R5_H1_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("BOLD THADY QUILL");
		horseID.setBirth(parse("01/01/2007 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		horseID.setGelding(parse("13/08/2015 00:00:00 +0200"));
		horseID.setFather("TALE OF THE CAT");
		horseID.setMother("JAZZIE");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 1 - BOLD THADY QUILL
	 */

	public static Horse builderHorse_R5_H1(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H1_ID());
		horse.setNumber(1);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(3);
		// no stable
		horse.setWeight(61.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(2.4439E7);
		horse.setPreviousYearProfit(4298000.0);
		horse.setVictoryProfit(1.1584E7);
		horse.setPlaceProfit(1.2855E7);
		horse.setYearProfit(2484000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.WITH);
		horse.setTrainer(trainer("K.J. CONDON"));
		horse.setOwner(owner("MRS PAULINE CONDON"));
		// no rancher
		horse.setJockey(jockey("P.J. SMULLEN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 2 - COUGAR MOUNTAIN
	 * HorseID - COUGAR MOUNTAIN
	 */
	public static HorseID builderHorse_R5_H2_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("COUGAR MOUNTAIN");
		horseID.setBirth(parse("01/01/2011 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("FASTNET ROCK");
		horseID.setMother("DESCANT");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 2 - COUGAR MOUNTAIN
	 */

	public static Horse builderHorse_R5_H2(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H2_ID());
		horse.setNumber(2);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(2);
		// no stable
		horse.setWeight(61.0);
		horse.setDistance(1600.0);
		horse.setCareerProfit(880000.0);
		horse.setPreviousYearProfit(700000.0);
		horse.setVictoryProfit(700000.0);
		horse.setPlaceProfit(180000.0);
		horse.setYearProfit(180000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("A.P.O'BRIEN"));
		horse.setOwner(owner("MICHAEL TABOR"));
		// no rancher
		horse.setJockey(jockey("J.P. O'BRIEN"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 3 - CONVERGENCE
	 * HorseID - CONVERGENCE
	 */
	public static HorseID builderHorse_R5_H3_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("CONVERGENCE");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.MALE);
		// no gelding
		horseID.setFather("CAPE CROSS");
		horseID.setMother("ZAHOO");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 3 - CONVERGENCE
	 */

	public static Horse builderHorse_R5_H3(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H3_ID());
		horse.setNumber(3);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(1);
		// no stable
		horse.setWeight(59.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(1.32535E7);
		horse.setPreviousYearProfit(6023500.0);
		horse.setVictoryProfit(1.1455E7);
		horse.setPlaceProfit(1798500.0);
		horse.setYearProfit(7230000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("G.M.LYONS"));
		horse.setOwner(owner("VINCENT GAUL"));
		// no rancher
		horse.setJockey(jockey("C.T. KEANE"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 4 - RAYDARA
	 * HorseID - RAYDARA
	 */
	public static HorseID builderHorse_R5_H4_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("RAYDARA");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ROCK OF GIBRALTAR");
		horseID.setMother("RAYDIYA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 4 - RAYDARA
	 */

	public static Horse builderHorse_R5_H4(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H4_ID());
		horse.setNumber(4);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(4);
		// no stable
		horse.setWeight(56.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(8840500.0);
		horse.setPreviousYearProfit(8380500.0);
		horse.setVictoryProfit(7860000.0);
		horse.setPlaceProfit(980500.0);
		horse.setYearProfit(460000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("M.HALFORD"));
		horse.setOwner(owner("H.H.AGA KHAN"));
		// no rancher
		horse.setJockey(jockey("S. FOLEY"));

		return horse;

	}

	/*
	 * Race 5
	 * Horse 5 - TAMADHOR
	 * HorseID - TAMADHOR
	 */
	public static HorseID builderHorse_R5_H5_ID() {

		HorseID horseID = new HorseID();

		horseID.setName("TAMADHOR");
		horseID.setBirth(parse("01/01/2012 00:00:00 +0100"));
		horseID.setSex(Sex.FEMALE);
		// no gelding
		horseID.setFather("ARCANO");
		horseID.setMother("HEDAAYA");
		horseID.setBreed(Breed.PUR_SANG);
		// no coat

		return horseID;

	}


	/*
	 * Race 5
	 * Horse 5 - TAMADHOR
	 */

	public static Horse builderHorse_R5_H5(Race race) {

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID(builderHorse_R5_H5_ID());
		horse.setNumber(5);
		horse.setRunner(true);
		horse.setSupplemented(false);
		horse.setPregnant(false);
		horse.setStall(5);
		// no stable
		horse.setWeight(56.5);
		horse.setDistance(1600.0);
		horse.setCareerProfit(5350500.0);
		horse.setPreviousYearProfit(3700500.0);
		horse.setVictoryProfit(3030000.0);
		horse.setPlaceProfit(2320500.0);
		horse.setYearProfit(1650000.0);
		horse.setHorseshoe(Horseshoe.ALL);
		horse.setBlinder(Blinder.NONE);
		horse.setTrainer(trainer("KEVIN PRENDERGAST"));
		horse.setOwner(owner("HAMDAN AL MAKTOUM"));
		// no rancher
		horse.setJockey(jockey("C.D. HAYES"));

		return horse;

	}

	/*
	 * Race 5
	 * Odds 1 - 13/08/2015 20:05:23 +0200
	 */

	public static Odds builderOdds_R5_O1(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 20:05:23 +0200"));
		// no total

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 18.9));
		simples.add(simple(odds, "2", 1.2));
		simples.add(simple(odds, "3", 21.0));
		simples.add(simple(odds, "4", 4.4));
		simples.add(simple(odds, "5", 31.6));
		odds.setSimples(simples);

		return odds;

	}

	/*
	 * Race 5
	 * Odds 2 - 13/08/2015 20:33:51 +0200
	 */

	public static Odds builderOdds_R5_O2(Race race) {

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("13/08/2015 20:33:51 +0200"));
		odds.setTotal(112.5);

		SortedSet<Simple> simples = new TreeSet<>();
		simples.add(simple(odds, "1", 10.2));
		simples.add(simple(odds, "2", 1.8));
		simples.add(simple(odds, "3", 5.2));
		simples.add(simple(odds, "4", 3.1));
		simples.add(simple(odds, "5", 10.6));
		odds.setSimples(simples);

		return odds;

	}

}
