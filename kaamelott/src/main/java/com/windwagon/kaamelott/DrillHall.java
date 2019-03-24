package com.windwagon.kaamelott;

import com.windwagon.kaamelott.race.Race;

public interface DrillHall extends Iterable<Race> {

	String getName();

	String getDescription();

	int size();

}
