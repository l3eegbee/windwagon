package com.windwagon.broceliande.race.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    @Query( "select max( m.date ) from Meeting m" )
    Date getLastMeetingDate();

    Meeting findByDateAndNumber( Date date, Integer number );

}
