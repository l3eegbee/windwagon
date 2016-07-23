package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.forge.armored.ArmoredOfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.kaamelott.words.Words;

public interface OfficialKnightWrapper extends WrappedKnight<ArmoredOfficialKnightWrapper, OfficialKnightData> {

    public Words getWords( Race race ) throws ForgeException;

}
