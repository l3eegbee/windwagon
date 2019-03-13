package com.windwagon.broceliande.race.turf;

import com.windwagon.broceliande.race.entities.*;

import java.util.*;

public interface HorseWrapper extends ObjectWrapper<Horse>, com.windwagon.kaamelott.race.Horse {

	Double getOddsValue(Date date);

	Double getStableOddsValue(Date date);

	Double getOddsValue(Date date, String target);

	Place getPlace();

}
