package com.windwagon.broceliande.knights.forge.impl.constant;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.forge.DrillHallWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.DrillHallConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.repositories.RaceSetRepository;

public class DrillHallConstantWrapperImpl extends ConstantWrapperImpl
        implements DrillHallConstantWrapper {

    @Autowired
    private RaceSetRepository raceSetRepository;

    @Override
    protected DrillHallWrapper resolveValue( Herald herald ) throws ConstantException {

        String name = constant.getValue();

        RaceSet raceSet = raceSetRepository.findByCycleAndName( actor.getCycle(), name );

        if( raceSet == null )
            throw new ConstantException( "Drill hall [" + name + "] not found." );

        return herald.getDrillHall( raceSet );

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitDrillHall( this );
    }

}
