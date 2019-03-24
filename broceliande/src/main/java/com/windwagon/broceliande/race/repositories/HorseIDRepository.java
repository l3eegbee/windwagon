package com.windwagon.broceliande.race.repositories;

import com.windwagon.broceliande.race.entities.*;

import org.springframework.data.repository.*;

import java.util.*;

public interface HorseIDRepository extends CrudRepository<HorseID, Long>, HorseIDRepositoryCustom {

	HorseID findByNameAndBirthAndSexAndFatherAndMother(String name, Date birth, Sex sex, String father, String mother);

	HorseID findFirstByNameAndSexAndBirthBefore(String name, Sex sex, Date minBirth);

}
