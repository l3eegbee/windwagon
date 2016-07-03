package com.windwagon.broceliande.knights.repositories;

import com.windwagon.broceliande.knights.entities.ScribeData;

public interface ScribeDataRepository extends ActorDataRepository<ScribeData> {

    public ScribeData findByName( String name );

}
