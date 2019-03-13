package com.windwagon.daemon;

import com.windwagon.broceliande.race.entities.*;

import java.util.*;

public interface RaceTask {

	String getName();

	default String getEnvKey() {
		return Maestro.ENV_TASKS_PREFIX + getName();
	}

	RaceStatus getRaceStatus();

	void run(Map<String, Object> reportContext, Race race) throws Exception;

}
