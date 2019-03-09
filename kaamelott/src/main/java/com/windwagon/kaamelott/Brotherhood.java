package com.windwagon.kaamelott;

import java.util.Set;

public interface Brotherhood extends Actor, Marshallable, WebVisu {

    void setFencingMasters(Set<? extends ArmoredFencingMaster> fencingMasters);

    default void setInn(Inn inn) {}

    ArmoredFencingMaster getBest();

}
