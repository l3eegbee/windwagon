package com.windwagon.broceliande.race.repositories;

import com.windwagon.broceliande.race.entities.HorseID;

public interface HorseIDRepositoryCustom {

	HorseID findFather(HorseID child);

	HorseID findMother(HorseID child);

}
