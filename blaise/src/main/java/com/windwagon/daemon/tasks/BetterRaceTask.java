package com.windwagon.daemon.tasks;

import com.windwagon.broceliande.race.entities.*;
import com.windwagon.daemon.*;

import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class BetterRaceTask implements RaceTask {

	public final static String NAME = "better";

	private final static Logger logger = LoggerFactory.getLogger(ProgrammeLoader.class);

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public RaceStatus getRaceStatus() {
		return RaceStatus.SCHEDULED;
	}

	@Override
	public void run(Map<String, Object> reportContext, Race race) {
		// TODO
	}

}
