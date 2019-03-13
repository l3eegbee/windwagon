package com.windwagon.daemon.tasks;

import com.windwagon.broceliande.race.entities.*;

import org.slf4j.*;
import org.springframework.stereotype.*;

@Component
public class FinishRaceTask extends UpdateRaceTask {

	public final static String NAME = "finish";

	private final static Logger logger = LoggerFactory.getLogger(ProgrammeLoader.class);

	public FinishRaceTask() {
		super(NAME, RaceStatus.STARTED);
	}

}
