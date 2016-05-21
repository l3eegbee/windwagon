package com.windwagon.kaamelott;

import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public interface ArmoredKnight extends ArmoredActor<Knight> {

    public Words getWords( Race race );

}
