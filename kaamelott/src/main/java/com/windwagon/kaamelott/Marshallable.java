package com.windwagon.kaamelott;

public interface Marshallable {

    default public byte[] marshal() {
        return null;
    }

    default public void unmarshal( byte[] data ) {}

}
