package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Odds;
import com.windwagon.broceliande.race.entities.Simple;

public interface SimpleRepository extends CrudRepository<Simple, Long> {

    Simple findByOddsAndNumber( Odds odds, String number );

}
