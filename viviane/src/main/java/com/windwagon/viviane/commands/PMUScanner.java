package com.windwagon.viviane.commands;

import static com.windwagon.logres.date.LazyDate.FORMAT_D;

import java.io.IOException;
import java.time.LocalDate;

import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import com.windwagon.pmuportal.RaceLoader;

@Component
public class PMUScanner implements CommandMarker {

    private final static Logger logger = LoggerFactory.getLogger( PMUScanner.class );

    @Autowired
    private RaceLoader raceLoader;

    @Autowired
    private MeetingBuilderGenerator meetingBuilderGenerator;

    @CliCommand( value = "scan", help = "Load programs" )
    public String pmuScan(
            @CliOption( key = { "", "date", "from" }, help = "Date (dd-mm-yyyy)" ) String from,
            @CliOption( key = "to", help = "Date (dd-mm-yyyy)", mandatory = false ) String to ) {

        try {

            if( to == null )
                to = from;

            LocalDate fromDate = LocalDate.parse( from, FORMAT_D );
            LocalDate toDate = LocalDate.parse( to, FORMAT_D );

            if( toDate.isBefore( fromDate ) )
                throw new RuntimeException( "'from' date after 'to' date" );

            for( LocalDate current = fromDate; !current.isAfter( toDate ); current =
                    current.plusDays( 1 ) ) {
                logger.info( "Load " + current.format( FORMAT_D ) );
                raceLoader.loadAllRaces( current );
            }

        } catch( Exception ex ) {
            ex.printStackTrace();
            return Ansi.ansi().fg( Ansi.Color.RED ).a( "FAILED!" ).toString();
        }

        return Ansi.ansi().fg( Ansi.Color.GREEN ).a( "OK!" ).toString();

    }

    @CliCommand( value = "builder", help = "Generate builder" )
    public String meetingBuilder(
            @CliOption(
                    key = { "" },
                    help = "Root directory",
                    unspecifiedDefaultValue = "." ) String directory )
            throws IOException {

        return meetingBuilderGenerator.transactionalMeetingBuilder( directory );

    }

}
