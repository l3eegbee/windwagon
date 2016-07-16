package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.kaamelott.Page;

public interface PageWrapper extends ActorWrapper {

    @Override
    public PageData getActorData();

    @Override
    public Page getActor();

}