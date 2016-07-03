package com.windwagon.broceliande.knights.forge.builder;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.logres.builder.Builder;

public class CycleBuilder implements Builder<Cycle> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    private Cycle cycle = new Cycle();

    public CycleBuilder creation( Date creation ) {
        cycle.setCreation( creation );
        return this;
    }

    public CycleBuilder description( String description ) {
        cycle.setDescription( description );
        return this;
    }

    public RaceSetBuilder raceSet() {

        RaceSetBuilder builder = knightBuilderFactory.getRaceSetBuilder();
        builder.cycle( build() );

        return builder;

    }

    @Override
    public Cycle build() {
        return cycle;
    }

}
