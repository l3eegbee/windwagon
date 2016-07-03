package com.windwagon.broceliande.knights.repositories;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;

public interface OfficialKnightDataRepository extends ActorDataRepository<OfficialKnightData> {

    public OfficialKnightData findByNameAndComponentComponentClassOfficialId( String name, String officialId );

}
