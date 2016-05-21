package com.windwagon.broceliande.race.turf;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.windwagon.broceliande.race.entities.Horse;

public class HorseIterator implements Iterator<com.windwagon.kaamelott.race.Horse> {

    public static final Iterator<com.windwagon.kaamelott.race.Horse> EMPTY_ITERATOR =
            new Iterator<com.windwagon.kaamelott.race.Horse>() {

                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public com.windwagon.kaamelott.race.Horse next() {
                    throw new NoSuchElementException();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

            };

    private Stud stud;

    private Iterator<Horse> iterator;

    protected Reference ref;

    public HorseIterator( Stud stud, Reference ref, List<Horse> listHorse ) {
        this.stud = stud;
        this.iterator = listHorse.iterator();
        this.ref = ref;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public com.windwagon.kaamelott.race.Horse next() {
        return stud.getHorse( ref, iterator.next() );
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
