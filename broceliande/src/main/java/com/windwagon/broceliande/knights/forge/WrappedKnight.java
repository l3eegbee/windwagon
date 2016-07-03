package com.windwagon.broceliande.knights.forge;

import com.windwagon.kaamelott.ArmoredKnight;
import com.windwagon.kaamelott.Knight;

public interface WrappedKnight extends ArmoredKnight, ActorWrapper {

    @Override
    public Knight getActor();

}
