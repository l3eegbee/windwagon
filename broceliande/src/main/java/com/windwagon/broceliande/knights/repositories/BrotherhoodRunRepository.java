package com.windwagon.broceliande.knights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.Cycle;

public interface BrotherhoodRunRepository extends RunRepository<BrotherhoodRun> {

    BrotherhoodRun findByCycleAndBrotherhoodName( Cycle cycle, String knightName );

    @Query( "SELECT br FROM BrotherhoodRun br WHERE EXISTS "
            + "(SELECT c FROM Constant c where"
            + "     c.type = 'COMPONENT' and c.value = ?1 and c.component = br.brotherhood.component)" )
    public Set<BrotherhoodRun> findByContainedComponent( String value );

}
