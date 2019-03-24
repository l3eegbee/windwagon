package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Trainer;

public interface TrainerRepository extends CrudRepository<Trainer, Long> {

	Trainer findByName(String name);

}
