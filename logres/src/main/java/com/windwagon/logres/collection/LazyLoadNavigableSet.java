package com.windwagon.logres.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class LazyLoadNavigableSet<E> {

    public interface Initializer<E> {

        public void init( NavigableSet<E> navigableSet );

    }

    private boolean initialized = false;

    private Comparator<? super E> comparator = null;

    private Initializer<E> initializer = ( NavigableSet<E> navigableSet ) -> {};

    private Set<E> initialSet = new HashSet<E>();

    private NavigableSet<E> navigableSet = null;

    public LazyLoadNavigableSet( Initializer<E> initializer ) {
        this( null, initializer );
    }

    public LazyLoadNavigableSet( Comparator<? super E> comparator, Initializer<E> initializer ) {
        this.comparator = comparator;
        this.initializer = initializer;
    }

    public void initAdd( E obj ) {
        initialSet.add( obj );
    }

    public NavigableSet<E> getNavigableSet() {

        if( !initialized ) {

            navigableSet = comparator == null ? new TreeSet<E>() : new TreeSet<E>( comparator );
            navigableSet.addAll( initialSet );

            initializer.init( navigableSet );

            navigableSet = Collections.unmodifiableNavigableSet( navigableSet );

            initialized = true;

        }

        return navigableSet;

    }

}
