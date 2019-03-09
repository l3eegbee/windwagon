package com.windwagon.pmuportal;

import com.fasterxml.jackson.databind.*;
import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.*;
import com.windwagon.pmuportal.exceptions.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Component
public class MeetingParser {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private RacecourseRepository racecourseRepository;

    @Autowired
    private PMUUtils pmuUtils;

    @Autowired
    private RaceParser raceParser;

    @Transactional
    public synchronized Meeting loadAndSaveMeeting( JsonNode meetingNode ) throws PMUError {

        Meeting meeting = loadMeeting( meetingNode );

        meetingRepository.save( meeting );

        return meeting;

    }

    @Transactional
    public synchronized Meeting loadMeeting( JsonNode meetingNode ) throws PMUError {

        Date date = new Date( meetingNode.at( "/dateReunion" ).asLong() );
        int mnum = meetingNode.at( "/numOfficiel" ).asInt();

        Meeting meeting = meetingRepository.findByDateAndNumber( date, mnum );
        if( meeting == null ) {

            meeting = new Meeting();

            meeting.setDate( date );
            meeting.setNumber( mnum );

        }

        try {

            // racecourse

            JsonNode rcNameNode = meetingNode.at( "/hippodrome/libelleCourt" );
            JsonNode rcCountryNode = meetingNode.at( "/pays/libelle" );

            if( !rcNameNode.isMissingNode() && !rcCountryNode.isMissingNode() ) {

                String rcName = pmuUtils.asText( rcNameNode );
                String rcCountry = pmuUtils.asText( rcCountryNode );

                Racecourse racecourse =
                        racecourseRepository.findByNameAndCountry( rcName, rcCountry );
                if( racecourse == null ) {

                    racecourse = new Racecourse();

                    racecourse.setName( rcName );
                    racecourse.setCountry( rcCountry );

                }

                pmuUtils.shouldNotBeModified( meeting, meeting.getRacecourse(), racecourse );

                meeting.setRacecourse( racecourse );

            }

            // wind speed
            JsonNode windSpeedNode = meetingNode.at( "/meteo/forceVent" );
            if( !windSpeedNode.isMissingNode() )
                meeting.setWindSpeed( windSpeedNode.asDouble() );

            // wind direction
            JsonNode windDirectionNode = meetingNode.at( "/meteo/directionVent" );
            if( !windDirectionNode.isMissingNode() )
                meeting.setWindDirection(
                        pmuUtils.findPMU( WindDirection.class, windDirectionNode ) );
            else
                meeting.setWindDirection( WindDirection.UNKNOWN );

            // temperature
            JsonNode temperatureNode = meetingNode.at( "/meteo/temperature" );
            if( !temperatureNode.isMissingNode() )
                meeting.setTemperature( temperatureNode.asDouble() );

            // climat
            JsonNode climatNode = meetingNode.at( "/meteo/nebulositeLibelleCourt" );
            if( !climatNode.isMissingNode() )
                meeting.setClimat( pmuUtils.asText( climatNode ) );

            // field
            JsonNode fieldNode = meetingNode.at( "/penetrometre/intitule" );
            if( !fieldNode.isMissingNode() )
                meeting.setField( pmuUtils.findPMU( Field.class, fieldNode ) );
            else
                meeting.setField( Field.UNKNOWN );

            // races

            SortedSet<Race> races = new TreeSet<>();

            for( JsonNode raceNode : meetingNode.at( "/courses" ) )
                try {
                    races.add( raceParser.parseRace( meeting, raceNode ) );
                } catch( PMUMethodFailureResponse ignored) {}

            pmuUtils.updateSet( meeting::getRaces, meeting::setRaces, races );

        } catch( PMUNoContent | PMUMethodFailureResponse ex ) {
            throw ex;
        } catch( PMUError ex ) {
            throw new PMUError( "Error during parse of " + meeting, ex );
        }

        return meeting;

    }

}
