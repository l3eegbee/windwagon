package com.windwagon.pmuportal;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.logres.date.LazyDate;
import com.windwagon.pmuportal.exceptions.PMUError;
import com.windwagon.pmuportal.exceptions.PMUMethodFailureResponse;
import com.windwagon.pmuportal.exceptions.PMUNoContent;

@Component
public class RaceLoader {

    private final Logger logger = LoggerFactory.getLogger( RaceParser.class );

    @Autowired
    private PMUNavigator pmuNavigator;

    @Autowired
    private MeetingParser meetingParser;

    @Autowired
    private RaceParser raceParser;

    public synchronized List<Meeting> loadAllRaces( LocalDate date ) throws PMUError {

        List<Meeting> meetings = new LinkedList<Meeting>();

        try {

            JsonNode programme = pmuNavigator.getJSONProgramme( date );

            for( JsonNode meetingNode : programme.at( "/programme/reunions" ) )
                meetings.add( meetingParser.loadAndSaveMeeting( meetingNode ) );

        } catch( PMUNoContent | PMUMethodFailureResponse ex ) {
            logger.warn( "Skip loading of day {} (PMU nominal error)", date );
        } catch( Exception ex ) {
            throw new PMUError( "Error during getting meetings of day " + LazyDate.D( date ), ex );
        }

        return meetings;

    }

    public synchronized void update( Race race ) throws PMUError {

        try {

            raceParser.updateRace( race );

        } catch( Exception ex ) {
            throw new PMUError( "Error while update " + race, ex );
        }

    }

}
