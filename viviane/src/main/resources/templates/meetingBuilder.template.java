package $buildersPackage;

import java.util.EnumSet;
import java.util.SortedSet;
import java.util.TreeSet;

import ${entitiesPackage}.BetType;
import ${entitiesPackage}.Blinder;
import ${entitiesPackage}.Breed;
import ${entitiesPackage}.Coat;
import ${entitiesPackage}.Discipline;
import ${entitiesPackage}.Field;
import ${entitiesPackage}.Horse;
import ${entitiesPackage}.HorseID;
import ${entitiesPackage}.Horseshoe;
import ${entitiesPackage}.Meeting;
import ${entitiesPackage}.Odds;
import ${entitiesPackage}.Place;
import ${entitiesPackage}.Price;
import ${entitiesPackage}.PriceName;
import ${entitiesPackage}.Race;
import ${entitiesPackage}.RaceStatus;
import ${entitiesPackage}.Sex;
import ${entitiesPackage}.Simple;
import ${entitiesPackage}.Type;
import ${entitiesPackage}.WindDirection;

		##
		## MACROS
		##
		#macro(alignNum $num)#if($num< 10) #end$num#end
		#macro(raceBuilderName $race)builderRace_R$race.getNumber()#end
		#macro(horseBuilderName $horse)builderHorse_R$horse.getRace().getNumber()_H$horse.getNumber()#end
		#macro(oddsBuilderName $odds $num)builderOdds_R$odds.getRace().getNumber()_O$num#end
		#macro(simpleBuilderName $oddsNum $simple)builderOdds_R$odds.getRace().getNumber()_O${oddsNum}_S$simple.getNumber()#end
		#macro(placeBuilderName $place)builderPlace_R$place.getRace().getNumber()_F$place.getNumber()#end
		##
		##
		##
		##
		#macro(enumSet $cont $setter $clazz $set)
		#if($set.size()==0)
		$cont.$setter(EnumSet.noneOf(${clazz}.class ));
		#else
		#if($set.size()==1)
		$cont.$setter(EnumSet.of($clazz.$set.iterator().next()));
		#else $cont.$setter(EnumSet.of(
		#foreach($elt in $sorter.sortSet($set))
		$clazz.$elt#if($velocityCount==$set.size())));#else,
		#end## IF END OF LIST
		#end## FOREACH ELT
		#end## IF SIZE==1
		#end## IF SIZE==0
		#end## MACRO
		##
		##
		##
		##
		#macro(horseIDBuilder $horse $horseID $suffix)
/*
 * Race $horse.getRace().getNumber()
 * Horse $horse.getNumber() - $horse.getHorseID().getName()
 * HorseID - $horseID.getName()
 */
public static HorseID #horseBuilderName($horse)_ID$suffix(){

		HorseID horseID=new HorseID();

		horseID.setName("$horseID.getName()");
		#if($null.isNotNull($horseID.getBirth()))
		horseID.setBirth(parse("$dateFormat.format($horseID.getBirth())"));
		#else
		// no birth
		#end
		#if($null.isNotNull($horseID.getSex()))
		horseID.setSex(Sex.$horseID.getSex());
		#else
		// no sex
		#end
		#if($null.isNotNull($horseID.getGelding()))
		horseID.setGelding(parse("$dateFormat.format($horseID.getGelding())"));
		#else
		// no gelding
		#end
		#if($null.isNotNull($horseID.getFather()))
		horseID.setFather("$horseID.getFather()");
		#else
		// no father
		#end
		#if($null.isNotNull($horseID.getMother()))
		horseID.setMother("$horseID.getMother()");
		#else
		// no mother
		#end
		#if($null.isNotNull($horseID.getBreed()))
		horseID.setBreed(Breed.$horseID.getBreed());
		#else
		// no breed
		#end
		#if($null.isNotNull($horseID.getCoat()))
		horseID.setCoat(Coat.$horseID.getCoat());
		#else
		// no coat
		#end

		return horseID;

		}

		#end##MACRO HORSEID
		##
		##
		##

public class $className extends MeetingBuilder {

	public static Meeting build() {

		Meeting meeting = new Meeting();

		meeting.setDate(parse("$dateFormat.format($meeting.getDate())"));
#if ($null.isNotNull($meeting.getRacecourse())) {
			meeting.setRacecourse(racecourse("$meeting.getRacecourse().getName()", "$meeting.getRacecourse().getCountry()"));
		}
#else
		// no racecourse
#end meeting.setNumber($meeting.getNumber());
#if ($null.isNotNull($meeting.getWindSpeed())) meeting.setWindSpeed($meeting.getWindSpeed());
#else
		// no wind speed
#end
#if ($null.isNotNull($meeting.getWindDirection())) {
			meeting.setWindDirection(WindDirection.$meeting.getWindDirection());
		}
#else
		// no wind direction
#end
#if ($null.isNotNull($meeting.getTemperature())) meeting.setTemperature($meeting.getTemperature());
#else
		// no temperature
#end
#if ($null.isNotNull($meeting.getClimat())) meeting.setClimat("$meeting.getClimat()");
#else
		// no climat
#end
#if ($null.isNotNull($meeting.getField())) meeting.setField(Field.$meeting.getField());
#else
		// no field
#end

		// -- races --
		SortedSet<Race> races = new TreeSet<>();
#foreach($race in $sorter.sortSet($meeting.getRaces())) races.add( #raceBuilderName($race) (meeting) )
		;
#end meeting.setRaces(races);

		return meeting;

	}

##RACES
#
	foreach($race in $sorter.sortSet($meeting.getRaces() ))
	/*
	 * Race $race.getNumber() - $race.getName()
	 */

	public static Race #
	raceBuilderName($race)(
	Meeting meeting )
	{

		Race race = new Race();

		race.setMeeting(meeting);
		race.setNumber($race.getNumber());
		race.setName("$race.getName()");
		race.setStatus(RaceStatus.$race.getStatus());
#if ($null.isNotNull($race.getStart())) {
		race.setStart(parse("$dateFormat.format($race.getStart())"));
	}
#else
		// no start
#end
#if ($null.isNotNull($race.getRealStart())) {
		race.setRealStart(parse("$dateFormat.format($race.getRealStart())"));
	}
#else
		// no real start
#end
#if ($null.isNotNull($race.getDistance())) race.setDistance($race.getDistance());
#else
		// no distance
#end
#if ($null.isNotNull($race.getBenefit())) race.setBenefit($race.getBenefit());
#else
		// no benefit
#end
#if ($null.isNotNull($race.getDiscipline())) race.setDiscipline(Discipline.$race.getDiscipline());
#else
		// no discipline
#end
#if ($null.isNotNull($race.getTypes()))
#enumSet("race""setTypes""Type"$race.getTypes())
#else
		// no type
#end##IF TYPES
#if ($null.isNotNull($race.getHorses()))

	// -- horses --
	{
		SortedSet<Horse> horses = new TreeSet<>();
	}
#foreach($horse in $sorter.sortSet($race.getHorses())) horses.add( #horseBuilderName($horse) (race) )
		;
#end race.setHorses(horses);
#else
		// no horse
#end
#if ($null.isNotNull($race.getBets()))

		// -- bets --
#enumSet("race""setBets""BetType"$race.getBets())

#else
		// no bets
#end
#if ($null.isNotNull($race.getOdds()))

	// -- odds --
	{
		SortedSet<Odds> oddsSet = new TreeSet<>();
	}
#foreach($odds in $sorter.sortSet($race.getOdds()))
		oddsSet.add( #oddsBuilderName($odds $velocityCount) (race) );
#end race.setOdds(oddsSet);

#else
		// no odds
#end
#if ($null.isNotNull($race.getDuration())) race.setDuration($race.getDuration());
#else
		// no duration
#end
#if ($null.isNotNull($race.getPlaces()))

	// -- finish --
	{
		SortedSet<Place> places = new TreeSet<>();
	}
#foreach($place in $sorter.sortSet($race.getPlaces()))
		places.add(place(race, #alignNum($place.getNumber()), #alignNum($place.getHorse())#
		if ($place.getDistance()),"$place.getDistance()"#end#if ($place.getDuration()),
		$place.getDuration()#end ) );
#end race.setPlaces(places);

#else
		// no finish
#end
#if ($null.isNotNull($race.getStopped())) race.setStopped("$race.getStopped()");
#else
		// no stopped
#end
#if ($null.isNotNull($race.getDisqualified())) race.setDisqualified("$race.getDisqualified()");
#else
		// no disqualified
#end
#if ($null.isNotNull($race.getFallen())) race.setFallen("$race.getFallen()");
#else
		// no fallen
#end
#if ($null.isNotNull($race.getPrices()))

	// -- prices --
	{
		SortedSet<Price> prices = new TreeSet<>();
	}
#foreach($price in $sorter.sortSet($race.getPrices()))
		prices.add(price(race, BetType.$price.getBet(), PriceName.$price.getPriceName(), $price.getPrice(), "$price.getTicket()"));
#end race.setPrices(prices);

#else
		// no price
#end return race;

	}

#
	foreach($horse in $sorter.sortSet($race.getHorses() ))
			#
	horseIDBuilder($horse $horse.getHorseID() "")

	/*
	 * Race $race.getNumber()
	 * Horse $horse.getNumber() - $horse.getHorseID().getName()
	 */

	public static Horse #
	horseBuilderName($horse)(
	Race race )
	{

		Horse horse = new Horse();

		horse.setRace(race);
		horse.setHorseID( #horseBuilderName($horse)_ID()); horse.setNumber($horse.getNumber());
		horse.setRunner($horse.getRunner());
#if ($null.isNotNull($horse.getSupplemented())) horse.setSupplemented($horse.getSupplemented());
#else
		// no supplemented value
#end
#if ($null.isNotNull($horse.getPregnant())) horse.setPregnant($horse.getPregnant());
#else
		// no pregnant value
#end
#if ($null.isNotNull($horse.getStall())) horse.setStall($horse.getStall());
#else
		// no stall
#end
#if ($null.isNotNull($horse.getStable())) horse.setStable("$horse.getStable()");
#else
		// no stable
#end
#if ($null.isNotNull($horse.getWeight())) horse.setWeight($horse.getWeight());
#else
		// no weight
#end
#if ($null.isNotNull($horse.getDistance())) horse.setDistance($horse.getDistance());
#else
		// no distance
#end
#if ($null.isNotNull($horse.getCareerProfit())) horse.setCareerProfit($horse.getCareerProfit());
#else
		// no career profit
#end
#if ($null.isNotNull($horse.getPreviousYearProfit())) {
		horse.setPreviousYearProfit($horse.getPreviousYearProfit());
	}
#else
		// no previous year profit
#end
#if ($null.isNotNull($horse.getVictoryProfit())) horse.setVictoryProfit($horse.getVictoryProfit());
#else
		// no victory profit
#end
#if ($null.isNotNull($horse.getPlaceProfit())) horse.setPlaceProfit($horse.getPlaceProfit());
#else
		// no place profit
#end
#if ($null.isNotNull($horse.getYearProfit())) horse.setYearProfit($horse.getYearProfit());
#else
		// no year profit
#end
#if ($null.isNotNull($horse.getHorseshoe())) horse.setHorseshoe(Horseshoe.$horse.getHorseshoe());
#else
		// no horseshoe
#end
#if ($null.isNotNull($horse.getBlinder())) horse.setBlinder(Blinder.$horse.getBlinder());
#else
		// no blinder
#end
#if ($null.isNotNull($horse.getTrainer())) {
		horse.setTrainer(trainer("$horse.getTrainer().getName()"));
	}
#else
		// no trainer
#end
#if ($null.isNotNull($horse.getOwner())) horse.setOwner(owner("$horse.getOwner().getName()"));
#else
		// no owner
#end
#if ($null.isNotNull($horse.getRancher())) {
		horse.setRancher(rancher("$horse.getRancher().getName()"));
	}
#else
		// no rancher
#end
#if ($null.isNotNull($horse.getJockey())) horse.setJockey(jockey("$horse.getJockey().getName()"));
#else
		// no jockey
#end

		return horse;

	}

#end##
	FOREACH HORSES
#
	foreach($odds in $sorter.sortSet($race.getOdds() ))
			#
	set($oddsNumber =$velocityCount)
	/*
	 * Race $race.getNumber()
	 * Odds $oddsNumber - $dateFormat.format($odds.getDate())
	 */

	public static Odds #
	oddsBuilderName($odds $oddsNumber)(
	Race race )
	{

		Odds odds = new Odds();

		odds.setRace(race);
		odds.setDate(parse("$dateFormat.format($odds.getDate())"));
#if ($null.isNotNull($odds.getTotal())) odds.setTotal($odds.getTotal());
#else
		// no total
#end
#if ($null.isNotNull($odds.getSimples())) {
		SortedSet<Simple> simples = new TreeSet<>();
	}
#foreach($simple in $sorter.sortSet($odds.getSimples()))
		simples.add(simple(odds, "$simple.getNumber()", $simple.getSimple()));
#end odds.setSimples(simples);
#else
		// no simples
#end

		return odds;

	}

#end##
	FOREACH ODDS
#end##
	FOREACH RACE
}
