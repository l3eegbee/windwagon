package com.windwagon.broceliande.knights.repositories;

import com.windwagon.broceliande.knights.entities.SquireData;

public interface SquireDataRepository extends ActorDataRepository<SquireData> {

    public SquireData findByName( String squireName );

}
