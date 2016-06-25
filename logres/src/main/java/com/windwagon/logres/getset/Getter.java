package com.windwagon.logres.getset;

import java.util.Objects;

public interface Getter < T, R > {

    public R get( T object );

    default public R safe( T object ) {
        return object == null ? null : get( object );
    }

    default public String str( T object ) {
        return Objects.toString( safe( object ) );
    }

    default public < S > Getter<T, S> then( Getter<? super R, S> sub ) {
        return (Getter<T, S>) ( obj -> sub.safe( safe( obj ) ) );
    }

    public static < T, R > Getter<T, R> get( Getter<T, R> getter ) {
        return getter;
    }

}
