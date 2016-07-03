package com.windwagon.broceliande.knights.repositories;

import com.windwagon.broceliande.knights.entities.PageData;

public interface PageDataRepository extends ActorDataRepository<PageData> {

    public PageData findByName( String pageName );

}
