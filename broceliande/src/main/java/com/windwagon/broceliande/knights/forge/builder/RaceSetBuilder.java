package com.windwagon.broceliande.knights.forge.builder;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.logres.builder.Builder;
import com.windwagon.logres.builder.CachedBuilder;

public class RaceSetBuilder implements Builder<RaceSet> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    private RaceSet raceSet = new RaceSet();

    /*
     * Name
     */

    public RaceSetBuilder name( String name ) {
        raceSet.setName( name );
        return this;
    }

    /*
     * Description
     */

    public RaceSetBuilder description( String description ) {
        raceSet.setDescription( description );
        return this;
    }

    /*
     * Races
     */

    public RaceSetBuilder races( SortedSet<Race> races ) {
        raceSet.setRaces( races );
        return this;
    }

    public RaceSetBuilder addRace( Race race ) {

        if( raceSet.getRaces() == null )
            raceSet.setRaces( new TreeSet<>() );

        raceSet.getRaces().add( race );

        return this;

    }

    /*
     * Cycle
     */

    private CachedBuilder<Cycle, CycleBuilder> cycleBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getCycleBuilder() );

    public RaceSetBuilder cycle( Cycle cycle ) {
        cycleBuilder.set( cycle );
        return this;
    }

    public CycleBuilder cycle() {
        return cycleBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public RaceSet build() {

        raceSet.setCycle( cycleBuilder.build() );

        return raceSet;

    }

}
