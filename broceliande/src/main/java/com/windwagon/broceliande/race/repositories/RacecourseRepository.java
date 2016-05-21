package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Racecourse;

public interface RacecourseRepository extends CrudRepository<Racecourse, Long> {

    Racecourse findByNameAndCountry( String name, String country );

}
