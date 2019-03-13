package com.windwagon.kaamelott;

public interface FencingMaster extends Actor, Marshallable, WebVisu {

	void setKnight(ArmoredKnight knight);

	default void setBrotherhood(ArmoredBrotherhood brotherhood) {}

	default void setInn(Inn inn) {}

	void train();

}
