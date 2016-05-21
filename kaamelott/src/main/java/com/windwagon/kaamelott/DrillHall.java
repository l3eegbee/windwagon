package com.windwagon.kaamelott;

import com.windwagon.kaamelott.race.Race;

public interface DrillHall extends Iterable<Race> {

    public String getName();

    public String getDescription();

    public int size();

}
