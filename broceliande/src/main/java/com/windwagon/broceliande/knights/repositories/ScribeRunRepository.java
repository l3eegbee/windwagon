package com.windwagon.broceliande.knights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.ScribeRun;

public interface ScribeRunRepository extends RunRepository<ScribeRun> {

    public ScribeRun findByCycleAndScribeName( Cycle cycle, String scribeName );

    @Query( "SELECT sr FROM ScribeRun sr WHERE EXISTS "
            + "(SELECT c FROM Constant c where"
            + "     c.type = 'COMPONENT' and c.value = ?1 and c.component = sr.scribe.component)" )
    public Set<ScribeRun> findByContainedComponent( String value );

}
