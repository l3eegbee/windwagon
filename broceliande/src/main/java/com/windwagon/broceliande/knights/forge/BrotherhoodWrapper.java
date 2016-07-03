package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.kaamelott.Brotherhood;

public interface BrotherhoodWrapper extends TaskWrapper {

    @Override
    public BrotherhoodData getActorData();

    @Override
    public BrotherhoodRun getRunData();

    @Override
    public Brotherhood getActor();

}
