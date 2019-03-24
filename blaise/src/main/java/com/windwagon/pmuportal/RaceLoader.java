package com.windwagon.pmuportal;

import com.fasterxml.jackson.databind.*;
import com.windwagon.broceliande.race.entities.*;
import com.windwagon.logres.date.*;
import com.windwagon.pmuportal.exceptions.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Component
public class RaceLoader {

	private final Logger logger = LoggerFactory.getLogger(RaceParser.class);

	@Autowired
	private PMUNavigator pmuNavigator;

	@Autowired
	private MeetingParser meetingParser;

	@Autowired
	private RaceParser raceParser;

	public synchronized List<Meeting> loadAllRaces(LocalDate date) throws PMUError {

		List<Meeting> meetings = new LinkedList<Meeting>();

		try {

			JsonNode programme = pmuNavigator.getJSONProgramme(date);

			for (JsonNode meetingNode : programme.at("/programme/reunions"))
				meetings.add(meetingParser.loadAndSaveMeeting(meetingNode));

		} catch (PMUNoContent | PMUMethodFailureResponse ex) {
			logger.warn("Skip loading of day {} (PMU nominal error)", date);
		} catch (Exception ex) {
			throw new PMUError("Error during getting meetings of day " + LazyDate.D(date), ex);
		}

		return meetings;

	}

	public synchronized void update(Race race) throws PMUError {

		try {

			raceParser.updateRace(race);

		} catch (Exception ex) {
			throw new PMUError("Error while update " + race, ex);
		}

	}

}
