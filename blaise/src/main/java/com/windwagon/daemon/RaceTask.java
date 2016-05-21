package com.windwagon.daemon;

import java.util.Map;

import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;

public interface RaceTask {

    public String getName();

    default public String getEnvKey() {
        return Maestro.ENV_TASKS_PREFIX + getName();
    }

    public RaceStatus getRaceStatus();

    public void run( Map<String, Object> reportContext, Race race ) throws Exception;

}
