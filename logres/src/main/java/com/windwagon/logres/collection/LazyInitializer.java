package com.windwagon.logres.collection;

public class LazyInitializer < T > {

    public interface Initializer < T > {

        public T init();

    }

    public LazyInitializer( Initializer<T> initializer ) {
        this.initializer = initializer;
    }

    private boolean initialized = false;

    private Initializer<T> initializer;

    private T object = null;

    public T get() {
        if( !initialized ) {
            object = initializer.init();
            initialized = true;
        }
        return object;
    }

    public void set( T object ) {
        this.object = object;
        initialized = true;
    }

    public void reset() {
        object = null;
        initialized = false;
    }

}
