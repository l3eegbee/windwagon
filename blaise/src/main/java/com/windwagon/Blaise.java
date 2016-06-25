package com.windwagon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.windwagon.broceliande.Broceliande;

@SpringBootApplication
@Import( Broceliande.class )
public class Blaise {

    @Bean
    public ThreadPoolTaskScheduler getScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    public static void main( String ... args ) {
        new SpringApplicationBuilder( Blaise.class ).properties( "maestro.start=true" ).run( args );
    }

}
