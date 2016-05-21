package com.windwagon.broceliande.race.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.entities.Sex;

public interface HorseIDRepository extends CrudRepository<HorseID, Long>, HorseIDRepositoryCustom {

    HorseID findByNameAndBirthAndSexAndFatherAndMother(
            String name,
            Date birth,
            Sex sex,
            String father,
            String mother );

    HorseID findFirstByNameAndSexAndBirthBefore( String name, Sex sex, Date minBirth );

}
