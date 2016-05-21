package com.windwagon.daemon.tasks;

import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.RaceStatus;

@Component
public class OddsRaceTask extends UpdateRaceTask {

    public final static String NAME = "odds";

    public OddsRaceTask() {
        super( NAME, RaceStatus.SCHEDULED );
    }

}
