package com.windwagon.kaamelott;

public interface Scribe extends Actor, Marshallable, WebVisu {

	default void setInn(Inn inn) {}

	void evaluate();

}
