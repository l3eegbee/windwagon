package com.windwagon.broceliande.race.turf.impl;

import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.*;
import com.windwagon.broceliande.race.turf.*;
import com.windwagon.broceliande.race.turf.enumconverter.*;
import com.windwagon.logres.collection.*;

import org.springframework.beans.factory.annotation.*;

import java.time.temporal.*;
import java.util.*;

public class HorseWrapperImpl extends ObjectWrapperImpl<Horse> implements HorseWrapper {

	public final static Comparator<com.windwagon.kaamelott.race.Horse> COMPARATOR = Comparator.comparing(com.windwagon.kaamelott.race.Horse::getRace).thenComparingInt(com.windwagon.kaamelott.race.Horse::getNumber);

	@Autowired
	private HorseRepository horseRepository;

	private LazyInitializer<HorseIDWrapper> horseIDWrapper = new LazyInitializer<HorseIDWrapper>(() -> stud.getHorseID(ref, daoObject.getHorseID()));

	public HorseWrapperImpl(Reference ref, Horse horse) {
		super(ref, horse);
	}

	static public int compare(com.windwagon.kaamelott.race.Horse h1, com.windwagon.kaamelott.race.Horse h2) {
		return COMPARATOR.compare(h1, h2);
	}

	@Override
	public int compareTo(com.windwagon.kaamelott.race.Horse horse) {
		return compare(this, horse);
	}

	LazyInitializer<RaceWrapper> race = new LazyInitializer<RaceWrapper>(() -> stud.getRace(ref, daoObject.getRace(), this));

	@Override
	public com.windwagon.kaamelott.race.Race getRace() {
		return race.get();
	}

	@Override
	public String getName() {
		return horseIDWrapper.get().getName();
	}

	@Override
	public boolean isRunner() {
		return daoObject.getRunner();
	}

	@Override
	public Iterator<com.windwagon.kaamelott.race.Horse> getHistory() {
		List<Horse> listHorse = horseRepository.getHorseHistory(daoObject.getHorseID(), ref.getNow());
		return stud.iterate(ref, listHorse);
	}

	@Override
	public com.windwagon.kaamelott.race.HorseID getFather() {
		return horseIDWrapper.get().getFather();
	}

	@Override
	public com.windwagon.kaamelott.race.HorseID getMother() {
		return horseIDWrapper.get().getMother();
	}

	@Override
	public Date getBirth() {
		return horseIDWrapper.get().getBirth();
	}

	private LazyInitializer<Integer> age = new LazyInitializer<>(() -> {

		Date birth = daoObject.getHorseID().getBirth();
		if (birth == null) return null;

		int raceYear = race.get().getStart().toInstant().get(ChronoField.YEAR);
		int birthYear = birth.toInstant().get(ChronoField.YEAR);

		return raceYear - birthYear;

	});

	@Override
	public Integer getAge() {
		return age.get();
	}

	private LazyInitializer<com.windwagon.kaamelott.race.Sex> sex = new LazyInitializer<>(() -> {

		Sex sex = daoObject.getHorseID().getSex();
		if (sex == null) return null;

		if (sex == Sex.MALE) {
			Date gdate = daoObject.getHorseID().getGelding();
			Date today = daoObject.getRace().getMeeting().getDate();
			if (gdate != null && !gdate.after(today)) sex = Sex.GELDING;
		}

		return KaamelottEnumConverter.sex.castToKaamelott(sex);

	});

	@Override
	public com.windwagon.kaamelott.race.Sex getSex() {
		return sex.get();
	}

	private LazyInitializer<Date> geldingDate = new LazyInitializer<Date>(() -> {
		Date gdate = daoObject.getHorseID().getGelding();
		return (gdate == null || gdate.after(race.get().getStart())) ? null : gdate;
	});

	@Override
	public Date getGeldingDate() {
		return geldingDate.get();
	}

	@Override
	public com.windwagon.kaamelott.race.Breed getBreed() {
		return horseIDWrapper.get().getBreed();
	}

	@Override
	public com.windwagon.kaamelott.race.Coat getCoat() {
		return horseIDWrapper.get().getCoat();
	}

	@Override
	public int getNumber() {
		return daoObject.getNumber();
	}

	@Override
	public boolean isSupplemented() {
		return daoObject.getSupplemented();
	}

	@Override
	public boolean isPregnant() {
		return daoObject.getPregnant();
	}

	@Override
	public int getStall() {
		return daoObject.getStall();
	}

	@Override
	public String getStable() {
		return daoObject.getStable();
	}

	@Override
	public Double getWeight() {
		return daoObject.getWeight();
	}

	@Override
	public double getDistance() {
		return daoObject.getDistance();
	}

	@Override
	public Double getCareerProfit() {
		return daoObject.getCareerProfit();
	}

	@Override
	public Double getPreviousYearProfit() {
		return daoObject.getPreviousYearProfit();
	}

	@Override
	public Double getVictoryProfit() {
		return daoObject.getVictoryProfit();
	}

	@Override
	public Double getYearProfit() {
		return daoObject.getYearProfit();
	}

	@Override
	public com.windwagon.kaamelott.race.Horseshoe getHorseshoe() {
		return KaamelottEnumConverter.horseshoe.castToKaamelott(daoObject.getHorseshoe());
	}

	@Override
	public com.windwagon.kaamelott.race.Blinder getBlinder() {
		return KaamelottEnumConverter.blinder.castToKaamelott(daoObject.getBlinder());
	}

	private LazyInitializer<String> trainer = new LazyInitializer<String>(() -> daoObject.getTrainer().getName());

	@Override
	public String getTrainer() {
		return trainer.get();
	}

	@Override
	public Iterator<com.windwagon.kaamelott.race.Horse> getTrainerHistory() {
		List<Horse> listHorse = horseRepository.getTrainerHistory(daoObject.getTrainer(), ref.getNow());
		return stud.iterate(ref, listHorse);
	}

	private LazyInitializer<String> owner = new LazyInitializer<String>(() -> daoObject.getOwner().getName());

	@Override
	public String getOwner() {
		return owner.get();
	}

	@Override
	public Iterator<com.windwagon.kaamelott.race.Horse> getOwnerHistory() {
		List<Horse> listHorse = horseRepository.getOwnerHistory(daoObject.getOwner(), ref.getNow());
		return stud.iterate(ref, listHorse);
	}

	private LazyInitializer<String> rancher = new LazyInitializer<String>(() -> daoObject.getRancher().getName());

	@Override
	public String getRancher() {
		return rancher.get();
	}

	@Override
	public Iterator<com.windwagon.kaamelott.race.Horse> getRancherHistory() {
		List<Horse> listHorse = horseRepository.getRancherHistory(daoObject.getRancher(), ref.getNow());
		return stud.iterate(ref, listHorse);
	}

	private LazyInitializer<String> jockey = new LazyInitializer<String>(() -> daoObject.getJockey().getName());

	@Override
	public String getJockey() {
		return jockey.get();
	}

	@Override
	public Iterator<com.windwagon.kaamelott.race.Horse> getJockeyHistory() {
		List<Horse> listHorse = horseRepository.getJockeyHistory(daoObject.getJockey(), ref.getNow());
		return stud.iterate(ref, listHorse);
	}

	public Double getOddsValue(Date date) {
		return getOddsValue(date, daoObject.getNumber().toString());
	}

	public Double getStableOddsValue(Date date) {
		String stable = daoObject.getStable();
		String target = (stable == null || stable.isEmpty()) ? daoObject.getNumber().toString() : stable;
		return getOddsValue(date, target);
	}

	public Double getOddsValue(Date date, String target) {

		Odds odds = race.get().getOddsNextDate(date);
		if (odds == null) return null;

		for (Simple simple : odds.getSimples())
			if (simple.getNumber().equals(target)) return simple.getSimple();

		return null;

	}

	@Override
	public Double getOdds() {
		return getOddsValue(ref.getNow());
	}

	@Override
	public Double getOdds(Date date) {
		return getOddsValue(date);
	}

	@Override
	public Double getFinishOdds() {
		return getOddsValue(race.get().getRealStart());
	}

	@Override
	public Double getStableOdds() {
		return getStableOddsValue(ref.getNow());
	}

	@Override
	public Double getStableOdds(Date date) {
		return getStableOddsValue(date);
	}

	@Override
	public Double getFinishStableOdds() {
		return getStableOddsValue(race.get().getRealStart());
	}

	public Place getPlace() {

		Set<Place> places = daoObject.getRace().getPlaces();
		if (places == null) return null;

		for (Place place : places)
			if (place.getHorse().equals(daoObject)) return place;

		return null;

	}

	private LazyInitializer<Integer> finishPosition = new LazyInitializer<Integer>(() -> getPlace().getNumber());

	@Override
	public Integer getFinishPosition() {
		return finishPosition.get();
	}

	private LazyInitializer<Integer> finishDuration = new LazyInitializer<Integer>(() -> getPlace().getDuration());

	@Override
	public Integer getFinishDuration() {
		return finishDuration.get();
	}

	private LazyInitializer<Boolean> stopped = new LazyInitializer<Boolean>(() -> getRace().getStopped().contains(this));

	@Override
	public boolean isStopped() {
		return stopped.get();
	}

	private LazyInitializer<Boolean> disqualified = new LazyInitializer<Boolean>(() -> getRace().getDisqualified().contains(this));

	@Override
	public boolean isDisqualified() {
		return disqualified.get();
	}

	private LazyInitializer<Boolean> fallen = new LazyInitializer<Boolean>(() -> getRace().getFallen().contains(this));

	@Override
	public boolean isFallen() {
		return fallen.get();
	}

}
