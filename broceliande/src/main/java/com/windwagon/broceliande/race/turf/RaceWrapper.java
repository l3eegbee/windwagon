package com.windwagon.broceliande.race.turf;

import com.windwagon.broceliande.race.entities.*;

import java.util.*;

public interface RaceWrapper extends ObjectWrapper<Race>, com.windwagon.kaamelott.race.Race {

	HorseWrapper getHorseByNum(int num);

	HorseWrapper getHorseByNum(String horseNum);

	List<HorseWrapper> getHorsesByNum(String horseList);

	Odds getOddsNextDate(Date date);

}
