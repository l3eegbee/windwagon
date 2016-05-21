package com.windwagon.kaamelott;

import java.util.Set;

public interface Brotherhood extends Actor, Marshallable, WebVisu {

    public void setFencingMasters( Set<? extends ArmoredFencingMaster> fencingMasters );

    default public void setInn( Inn inn ) {}

    public ArmoredFencingMaster getBest();

}
