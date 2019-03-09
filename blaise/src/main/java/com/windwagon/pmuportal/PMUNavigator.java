package com.windwagon.pmuportal;

import android.annotation.*;

import com.fasterxml.jackson.databind.*;
import com.windwagon.logres.date.*;
import com.windwagon.pmuportal.exceptions.*;

import org.apache.commons.io.IOUtils;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;

@Component
@SuppressLint("NewApi")
public class PMUNavigator {

    private final Logger logger = LoggerFactory.getLogger( PMUNavigator.class );

    public static final String URL_PROGRAMME =
            "http://www.pmu.fr/turfInfo/client/1/programmes/{date}?meteo=true&specialisation=INTERNET";

    public static final String URL_RACE =
            "http://www.pmu.fr/turfInfo/client/1/programmes/{date}/R{meeting}/C{race}?specialisation=INTERNET";

    public static final String URL_HORSES =
            "http://www.pmu.fr/turfInfo/client/1/programmes/{date}/R{meeting}/C{race}/participants?specialisation=INTERNET";

    public static final String URL_TOTALBETS =
            "http://www.pmu.fr/turfInfo/client/1/programme/{date}/R{meeting}/C{race}/masse-enjeu?specialisation=INTERNET";

    public static final String URL_PRICES =
            "http://www.pmu.fr/turfInfo/client/1/programme/{date}/R{meeting}/C{race}/rapports-definitifs?combinaisonEnTableau=true&specialisation=INTERNET";

    private final static Pattern CHARSET_PATTERN =
            Pattern.compile( "text/html;\\s+charset=([^\\s]+)\\s*" );

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern( "ddMMyyyy" );

    private final static int MAX_RETRY = 3;

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String getContent( String url ) throws PMUNavigatorError {

        URL target;
        try {
            target = new URL( url );
        } catch( MalformedURLException ex ) {
            throw new PMUNavigatorError( "Incorrect URL: " + url, ex );
        }

        int tryNumber = 0;
        boolean correctExecution = false;

        String source = null;

        while( !correctExecution ) {

            try {

                HttpURLConnection conn = (HttpURLConnection) target.openConnection();

                if( conn.getResponseCode() == PMUMethodFailureResponse.HTTP_RESPONSE_CODE ) {
                    logger.warn(
                            "Try #{} access {}: HTTP response code {}",
                            tryNumber,
                            url,
                            PMUMethodFailureResponse.HTTP_RESPONSE_CODE );
                    throw new PMUMethodFailureResponse( url );
                }

                Matcher charsetMatcher = CHARSET_PATTERN.matcher( conn.getContentType() );
                String charset = charsetMatcher.matches() ? charsetMatcher.group( 1 ) : "UTF-8";

                source = IOUtils.toString( conn.getInputStream(), charset ).trim();
                if( source == null || source.isEmpty() ) {
                    logger.warn( "Try #{} access {}: no content returned", tryNumber, url );
                    throw new PMUNoContent( url );
                }

                correctExecution = true;

            } catch( Exception ex ) {

                if( ++tryNumber > MAX_RETRY )
                    throw ex instanceof PMUNavigatorError
                            ? (PMUNavigatorError) ex
                            : new PMUNavigatorError( "Can't load " + url, ex );

            }

        }

        return source;

    }

    public JsonNode getJSON( String url ) throws PMUNavigatorError {

        String source = getContent( url ).trim();

        JsonNode json;

        try {
            json = OBJECT_MAPPER.readTree( source );
        } catch( IOException ex ) {
            throw new PMUNavigatorError( "Malformed json at " + url, ex );
        }

        return json;

    }

    private static String setup( String url, LocalDate date, int meeting, int race ) {

        return url
                .replaceAll( "\\{date\\}", date.format( DATE_FORMAT ) )
                .replaceAll( "\\{meeting\\}", Integer.toString( meeting ) )
                .replaceAll( "\\{race\\}", Integer.toString( race ) );

    }

    private static String setup( String url, Date date, int meeting, int race ) {
        return setup( url, DateConverter.toLocalDate( date ), meeting, race );
    }

    private static String setup( String url, LocalDate date ) {
        return setup( url, date, 0, 0 );
    }

    private static String setup( String url, Date date ) {
        return setup( url, DateConverter.toLocalDate( date ), 0, 0 );
    }

    public JsonNode getJSONProgramme( LocalDate date ) throws PMUNavigatorError {
        return getJSON( setup( URL_PROGRAMME, date ) );
    }

    public JsonNode getJSONProgramme( Date date ) throws PMUNavigatorError {
        return getJSON( setup( URL_PROGRAMME, date ) );
    }

    public JsonNode getJSONRace( LocalDate date, int meeting, int race ) throws PMUNavigatorError {
        return getJSON( setup( URL_RACE, date, meeting, race ) );
    }

    public JsonNode getJSONRace( Date date, int meeting, int race ) throws PMUNavigatorError {
        return getJSON( setup( URL_RACE, date, meeting, race ) );
    }

    public JsonNode getJSONHorses( LocalDate date, int meeting, int race )
            throws PMUNavigatorError {
        return getJSON( setup( URL_HORSES, date, meeting, race ) );
    }

    public JsonNode getJSONHorses( Date date, int meeting, int race ) throws PMUNavigatorError {
        return getJSON( setup( URL_HORSES, date, meeting, race ) );
    }

    public JsonNode getJSONTotalBets( LocalDate date, int meeting, int race )
            throws PMUNavigatorError {
        return getJSON( setup( URL_TOTALBETS, date, meeting, race ) );
    }

    public JsonNode getJSONTotalBets( Date date, int meeting, int race ) throws PMUNavigatorError {
        return getJSON( setup( URL_TOTALBETS, date, meeting, race ) );
    }

    public JsonNode getJSONPrices( LocalDate date, int meeting, int race )
            throws PMUNavigatorError {
        return getJSON( setup( URL_PRICES, date, meeting, race ) );
    }

    public JsonNode getJSONPrices( Date date, int meeting, int race ) throws PMUNavigatorError {
        return getJSON( setup( URL_PRICES, date, meeting, race ) );
    }

}
