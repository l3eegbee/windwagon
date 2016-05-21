package com.windwagon.daemon.tasks;

import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.RaceStatus;

@Component
public class FinishRaceTask extends UpdateRaceTask {

    public final static String NAME = "finish";

    public FinishRaceTask() {
        super( NAME, RaceStatus.STARTED );
    }

}
