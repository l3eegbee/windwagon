package com.windwagon.logres.getset;

import java.util.Objects;

public interface Getter < T, R > {

    R get(T object);

    default R safe(T object) {
        return object == null ? null : get( object );
    }

    default String str(T object) {
        return Objects.toString( safe( object ) );
    }

    default < S > Getter<T, S> then(Getter<? super R, S> sub) {
        return (Getter<T, S>) ( obj -> sub.safe( safe( obj ) ) );
    }

    static < T, R > Getter<T, R> get(Getter<T, R> getter) {
        return getter;
    }

}
