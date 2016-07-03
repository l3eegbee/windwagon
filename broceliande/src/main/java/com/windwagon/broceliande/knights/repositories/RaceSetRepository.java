package com.windwagon.broceliande.knights.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.RaceSet;

public interface RaceSetRepository extends CrudRepository<RaceSet, Long> {

    public RaceSet findByCycleAndName( Cycle cycle, String raceSetName );

}
