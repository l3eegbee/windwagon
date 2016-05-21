package com.windwagon.broceliande.race.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.entities.Jockey;
import com.windwagon.broceliande.race.entities.Owner;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.Rancher;
import com.windwagon.broceliande.race.entities.Trainer;

public interface HorseRepository extends CrudRepository<Horse, Long> {

    Horse findByRaceAndNumber( Race race, Integer number );

    @Query( "select h from Horse h where h.horseID = ?1 and h.race.start < ?2 order by h.race.start desc" )
    List<Horse> getHorseHistory( HorseID horseID, Date date );

    @Query( "select h from Horse h where h.trainer = ?1 and h.race.start < ?2 order by h.race.start desc" )
    List<Horse> getTrainerHistory( Trainer trainer, Date date );

    @Query( "select h from Horse h where h.owner = ?1 and h.race.start < ?2 order by h.race.start desc" )
    List<Horse> getOwnerHistory( Owner owner, Date date );

    @Query( "select h from Horse h where h.rancher = ?1 and h.race.start < ?2 order by h.race.start desc" )
    List<Horse> getRancherHistory( Rancher rancher, Date date );

    @Query( "select h from Horse h where h.jockey = ?1 and h.race.start < ?2 order by h.race.start desc" )
    List<Horse> getJockeyHistory( Jockey jockey, Date date );

}
