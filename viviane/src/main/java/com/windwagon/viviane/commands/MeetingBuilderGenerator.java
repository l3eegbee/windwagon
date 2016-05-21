package com.windwagon.viviane.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.repositories.MeetingRepository;

@Component
public class MeetingBuilderGenerator {

    @Value( "${builders.builders.package}" )
    private String BUILDERS_PACKAGE;

    @Value( "${builders.entities.package}" )
    private String ENTITIES_PACKAGE;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MeetingRepository meetingRepository;

    private VelocityEngine velocityEngine;

    private final static DateFormat BUILDER_CLASSNAME_DATE_FORMAT = new SimpleDateFormat(
            "yyyyMMdd" );

    private final static String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm:ss Z";

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat( DATE_FORMAT_PATTERN );

    public MeetingBuilderGenerator() {

        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty( RuntimeConstants.RESOURCE_LOADER, "classpath" );
        velocityEngine.setProperty(
                "classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName() );
        velocityEngine.setProperty( "classpath.resource.loader.cache", false );
        velocityEngine.setProperty( "velocimacro.library.autoreload", true );
        velocityEngine.init();

    }

    public static class Sorter {

        public < T extends Comparable<T>> List<T> sortSet( Set<T> set ) {

            List<T> list = new Vector<T>( set );
            Collections.sort( list );
            return list;

        }

    }

    public static class NullObject {

        public boolean isNull( Object object ) {
            return object == null;
        }

        public boolean isNotNull( Object object ) {
            return object != null;
        }

    }

    private String getMeetingBuilderFileName( Meeting meeting ) {

        return new StringBuilder( "Meeting_" )
                .append( BUILDER_CLASSNAME_DATE_FORMAT.format( meeting.getDate() ) )
                .append( "_M" )
                .append( meeting.getNumber() )
                .toString();

    }

    @Transactional
    public String transactionalMeetingBuilder( String directory ) throws IOException {

        Path rootDirectory = Paths.get( directory ).toAbsolutePath();
        Files.createDirectories( rootDirectory );

        Template template = velocityEngine.getTemplate( "templates/meetingBuilder.template.java" );

        for( Meeting meeting : meetingRepository.findAll() ) {

            String fileName = getMeetingBuilderFileName( meeting );
            File meetingFile = Paths.get( rootDirectory.toString(), fileName + ".java" ).toFile();

            VelocityContext context = new VelocityContext();
            context.put( "buildersPackage", BUILDERS_PACKAGE );
            context.put( "entitiesPackage", ENTITIES_PACKAGE );
            context.put( "className", fileName );
            context.put( "meeting", meeting );
            context.put( "dateFormatPattern", DATE_FORMAT_PATTERN );
            context.put( "dateFormat", DATE_FORMAT );
            context.put( "sorter", new Sorter() );
            context.put( "null", new NullObject() );

            try( FileWriter writer = new FileWriter( meetingFile ) ) {
                template.merge( context, writer );
            }

        }

        return "OK";

    }

}
