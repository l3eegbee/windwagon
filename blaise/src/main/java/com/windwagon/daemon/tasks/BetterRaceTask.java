package com.windwagon.daemon.tasks;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.daemon.RaceTask;

@Component
public class BetterRaceTask implements RaceTask {

    public final static String NAME = "better";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public RaceStatus getRaceStatus() {
        return RaceStatus.SCHEDULED;
    }

    @Override
    public void run( Map<String, Object> reportContext, Race race ) {
        // TODO
    }

}
