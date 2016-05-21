package com.windwagon.kaamelott;

public interface Scribe extends Actor, Marshallable, WebVisu {

    default public void setInn( Inn inn ) {}

    public void evaluate();

}
