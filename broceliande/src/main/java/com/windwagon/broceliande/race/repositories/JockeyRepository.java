package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Jockey;

public interface JockeyRepository extends CrudRepository<Jockey, Long> {

    Jockey findByName( String name );

}
