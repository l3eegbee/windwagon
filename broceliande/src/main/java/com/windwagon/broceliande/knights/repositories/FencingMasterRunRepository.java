package com.windwagon.broceliande.knights.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;

public interface FencingMasterRunRepository extends RunRepository<FencingMasterRun> {

    public FencingMasterRun findByCycleAndFencingMasterBrotherhoodNameAndFencingMasterName(
            Cycle cycle,
            String knightName,
            String fencingMasterName );

    public Set<FencingMasterRun> findByCycleAndFencingMasterBrotherhood(
            Cycle cycle,
            BrotherhoodData brotherhood );

    @Query( "SELECT fmr FROM FencingMasterRun fmr WHERE EXISTS "
            + "(SELECT c FROM Constant c where"
            + "     c.type = 'COMPONENT' and c.value = ?1 and c.component = fmr.fencingMaster.component)" )
    public Set<FencingMasterRun> findByContainedComponent( String value );

}
