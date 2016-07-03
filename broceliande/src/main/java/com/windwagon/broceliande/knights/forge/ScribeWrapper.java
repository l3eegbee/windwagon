package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.kaamelott.Scribe;

public interface ScribeWrapper extends TaskWrapper {

    @Override
    public ScribeData getActorData();

    @Override
    public ScribeRun getRunData();

    @Override
    public Scribe getActor();

}
