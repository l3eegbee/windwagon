package com.windwagon.broceliande.race.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;

public interface RaceRepository extends CrudRepository<Race, Long> {

    List<Race> findByStatus( RaceStatus status );

    Race findByMeetingAndNumber( Meeting meeting, Integer number );

}
