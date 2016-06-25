package com.windwagon.broceliande;

import java.time.Clock;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource( "broceliande.properties" )
public class Broceliande {

    @Bean
    public Clock getClock( @Value( "${timezone}" ) String timezone ) {

        TimeZone.setDefault( TimeZone.getTimeZone( timezone ) );

        return Clock.systemDefaultZone();

    }

}
