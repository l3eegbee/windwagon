package com.windwagon.logres.builder;

import java.util.function.Supplier;

public class CachedBuilder<O, B extends Builder<O>> implements Builder<O> {

    private Supplier<B> supplier;

    private B builder;

    private O object;

    public CachedBuilder( Supplier<B> supplier ) {
        this.supplier = supplier;
    }

    public void set( O object ) {
        this.object = object;
    }

    public B builder() {
        if( builder == null )
            builder = supplier.get();
        return builder;
    }

    public O build() {
        if( object == null && builder != null )
            object = builder.build();
        return object;
    }

}
