package com.windwagon.broceliande.race.turf;

import java.util.Date;

import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.Place;

public interface HorseWrapper extends ObjectWrapper<Horse>, com.windwagon.kaamelott.race.Horse {

    public Double getOddsValue( Date date );

    public Double getStableOddsValue( Date date );

    public Double getOddsValue( Date date, String target );

    public Place getPlace();

}
