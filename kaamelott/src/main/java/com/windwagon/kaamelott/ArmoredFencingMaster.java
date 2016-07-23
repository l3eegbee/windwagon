package com.windwagon.kaamelott;

import com.windwagon.kaamelott.race.Race;
import com.windwagon.kaamelott.words.Words;

public interface ArmoredFencingMaster extends ArmoredActor<FencingMaster> {

    public ArmoredBrotherhood getBrotherhood();

    public ArmoredKnight getKnight();

    public Words getWords( Race race );

}
