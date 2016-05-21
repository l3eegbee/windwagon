package com.windwagon.kaamelott;

import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public interface Knight extends Actor, Marshallable {

    public Words getWords( Race race );

}
