package com.windwagon.broceliande.knights.forge.impl;

import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.forge.DrillHallWrapper;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.turf.Stud;

public class DrillHallWrapperImpl implements DrillHallWrapper {

    @Autowired
    private Stud stud;

    private RaceSet raceSet;

    public DrillHallWrapperImpl( RaceSet raceSet ) {
        this.raceSet = raceSet;
    }

    @Override
    public String getName() {
        return raceSet.getName();
    }

    @Override
    public String getDescription() {
        return raceSet.getDescription();
    }

    @Override
    @Transactional
    public int size() {
        return raceSet.getRaces().size();
    }

    @Override
    @Transactional
    public Iterator<com.windwagon.kaamelott.race.Race> iterator() {
        return new RaceIterator( raceSet.getRaces().iterator() );
    }

    private class RaceIterator implements Iterator<com.windwagon.kaamelott.race.Race> {

        Iterator<Race> iterator;

        public RaceIterator( Iterator<Race> iterator ) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public com.windwagon.kaamelott.race.Race next() {
            return stud.getRace( iterator.next() );
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException( "Can't remove a race from a DrillHall." );
        }

    }

}
