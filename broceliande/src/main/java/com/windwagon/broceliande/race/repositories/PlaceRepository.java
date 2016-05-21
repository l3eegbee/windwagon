package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Place;
import com.windwagon.broceliande.race.entities.Race;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    Place findByRaceAndNumberAndHorse( Race race, Integer number, Integer horse );

}
