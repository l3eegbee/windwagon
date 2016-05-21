package com.windwagon.broceliande.race.repositories;

import org.springframework.data.repository.CrudRepository;

import com.windwagon.broceliande.race.entities.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByName( String name );

}
