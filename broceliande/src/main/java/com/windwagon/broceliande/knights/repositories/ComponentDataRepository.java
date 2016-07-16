package com.windwagon.broceliande.knights.repositories;

import com.windwagon.broceliande.knights.entities.ComponentData;

public interface ComponentDataRepository extends LongIdentifiedRepository<ComponentData> {

    public ComponentData findByName( String componentName );

}
