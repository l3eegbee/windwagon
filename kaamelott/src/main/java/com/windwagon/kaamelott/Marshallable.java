package com.windwagon.kaamelott;

public interface Marshallable {

	default byte[] marshal() {
		return null;
	}

	default void unmarshal(byte[] data) {}

}
