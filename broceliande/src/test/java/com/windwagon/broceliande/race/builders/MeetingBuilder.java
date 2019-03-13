package com.windwagon.broceliande.race.builders;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Jockey;
import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Owner;
import com.windwagon.broceliande.race.entities.Place;
import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.entities.PriceName;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.Racecourse;
import com.windwagon.broceliande.race.entities.Rancher;
import com.windwagon.broceliande.race.entities.Simple;
import com.windwagon.broceliande.race.entities.Trainer;

public class MeetingBuilder {

	protected final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");

	public static Date parse(String formatedDate) {
		try {
			return DATE_FORMAT.parse(formatedDate);
		} catch (ParseException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	public static Racecourse racecourse(String name, String country) {

		Racecourse racecourse = new Racecourse();
		racecourse.setName(name);
		racecourse.setCountry(country);

		return racecourse;

	}

	public static Place place(Race race, Integer num, Integer horse, String distance, Integer duration) {

		Place place = new Place();
		place.setRace(race);
		place.setNumber(num);
		place.setDistance(distance);
		place.setDuration(duration);
		place.setHorse(horse);

		return place;

	}

	public static Place place(Race race, Integer num, Integer horse) {
		return place(race, num, horse, null, null);
	}

	public static Place place(Race race, Integer num, Integer horse, String distance) {
		return place(race, num, horse, distance, null);
	}

	public static Place place(Race race, Integer num, Integer horse, Integer duration) {
		return place(race, num, horse, null, duration);
	}

	public static Price price(Race race, BetType bet, PriceName priceName, Double value, String ticket) {

		Price price = new Price();
		price.setRace(race);
		price.setBet(bet);
		price.setPriceName(priceName);
		price.setPrice(value);
		price.setTicket(ticket);

		return price;

	}

	public static Simple simple(Odds odds, String number, Double value) {

		Simple simple = new Simple();
		simple.setOdds(odds);
		simple.setNumber(number);
		simple.setSimple(value);

		return simple;

	}

	public static Trainer trainer(String name) {

		Trainer trainer = new Trainer();
		trainer.setName(name);

		return trainer;

	}

	public static Owner owner(String name) {

		Owner owner = new Owner();
		owner.setName(name);

		return owner;

	}

	public static Rancher rancher(String name) {

		Rancher rancher = new Rancher();
		rancher.setName(name);

		return rancher;

	}

	public static Jockey jockey(String name) {

		Jockey jockey = new Jockey();
		jockey.setName(name);

		return jockey;

	}

}
