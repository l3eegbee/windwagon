package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Rancher;

public interface RancherRepository extends CrudRepository<Rancher, Long> {

	Rancher findByName(String name);

}
