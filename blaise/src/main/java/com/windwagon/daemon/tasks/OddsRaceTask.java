package com.windwagon.daemon.tasks;

import com.windwagon.broceliande.race.entities.*;

import org.slf4j.*;
import org.springframework.stereotype.*;

@Component
public class OddsRaceTask extends UpdateRaceTask {

	public final static String NAME = "odds";

	private final static Logger logger = LoggerFactory.getLogger(ProgrammeLoader.class);

	public OddsRaceTask() {
		super(NAME, RaceStatus.SCHEDULED);
	}

}
