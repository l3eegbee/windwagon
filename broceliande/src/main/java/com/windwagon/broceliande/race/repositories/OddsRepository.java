package com.windwagon.broceliande.race.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Race;

public interface OddsRepository extends CrudRepository<Odds, Long> {

	Odds findByRaceAndDate(Race race, Date date);

}
