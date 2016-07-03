package com.windwagon.logres.builder;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Supplier;

public class SortedSetCachedBuilder<O, B extends Builder<O>> implements Builder<SortedSet<O>> {

    private Supplier<B> supplier;

    private SortedSet<O> sortedSet = new TreeSet<>();

    private List<B> builders = new LinkedList<>();

    public SortedSetCachedBuilder( Supplier<B> supplier ) {
        this.supplier = supplier;
    }

    public void set( SortedSet<O> sortedSet ) {
        this.sortedSet = sortedSet;
    }

    public void add( O object ) {
        sortedSet.add( object );
    }

    public B builder() {

        B builder = supplier.get();
        builders.add( builder );

        return builder;

    }

    public SortedSet<O> build() {

        for( Builder<O> builder : builders )
            sortedSet.add( builder.build() );

        return sortedSet;

    }

}
