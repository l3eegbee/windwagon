package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.kaamelott.ArmoredKnight;
import com.windwagon.kaamelott.Knight;

public interface WrappedKnight<D extends ActorData> extends ActorWrapper<Knight, D>, ArmoredKnight {}
