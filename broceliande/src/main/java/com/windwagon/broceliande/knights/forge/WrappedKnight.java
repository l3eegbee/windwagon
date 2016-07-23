package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.forge.armored.ArmoredWrappedKnight;

public interface WrappedKnight<Armored extends ArmoredWrappedKnight, D extends ActorData>
        extends ActorWrapper<Armored, D> {}
