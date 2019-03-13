package com.windwagon.daemon.tasks;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.entities.RaceStatus;
import com.windwagon.daemon.RaceTask;
import com.windwagon.pmuportal.RaceLoader;
import com.windwagon.pmuportal.exceptions.PMUError;

public abstract class UpdateRaceTask implements RaceTask {

	@Autowired
	private RaceLoader raceLoader;

	private String name;

	private RaceStatus raceStatus;

	protected UpdateRaceTask(String name, RaceStatus raceStatus) {
		this.name = name;
		this.raceStatus = raceStatus;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public RaceStatus getRaceStatus() {
		return raceStatus;
	}

	@Override
	public void run(Map<String, Object> reportContext, Race race) throws PMUError {
		raceLoader.update(race);
	}

}
