package com.windwagon.broceliande;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Clock;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@PropertySource( "broceliande.properties" )
public class GlobalInitializer {

    @Value( "${jarfiles}" )
    private String jarRootPathName;

    @Bean
    public Clock getClock( @Value( "${timezone}" ) String timezone ) {

        TimeZone.setDefault( TimeZone.getTimeZone( timezone ) );

        return Clock.systemDefaultZone();

    }

    @Bean
    public FileSystem getFileSystem() {
        return FileSystems.getDefault();
    }

    @Bean
    public FactoryBean<ConversionService> getConversionServiceFactory() {
        return new ConversionServiceFactoryBean();
    }

    @PostConstruct
    public void init() {

        Path jarRootPath = getFileSystem().getPath( jarRootPathName );
        try {
            Files.createDirectories( jarRootPath );
        } catch( IOException ex ) {
            throw new RuntimeException( "Can't create directory for jar files", ex );
        }

    }

}
