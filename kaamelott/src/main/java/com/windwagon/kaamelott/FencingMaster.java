package com.windwagon.kaamelott;

public interface FencingMaster extends Actor, Marshallable, WebVisu {

    public void setKnight( ArmoredKnight knight );

    default public void setBrotherhood( ArmoredBrotherhood brotherhood ) {}

    default public void setInn( Inn inn ) {}

    public void train();

}
