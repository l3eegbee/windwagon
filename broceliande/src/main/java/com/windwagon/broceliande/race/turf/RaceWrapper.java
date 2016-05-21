package com.windwagon.broceliande.race.turf;

import java.util.Date;
import java.util.List;

import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Race;

public interface RaceWrapper extends ObjectWrapper<Race>, com.windwagon.kaamelott.race.Race {

    public HorseWrapper getHorseByNum( int num );

    public HorseWrapper getHorseByNum( String horseNum );

    public List<HorseWrapper> getHorsesByNum( String horseList );

    public Odds getOddsNextDate( Date date );

}
