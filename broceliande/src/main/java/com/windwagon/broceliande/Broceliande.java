package com.windwagon.broceliande;

import android.annotation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.time.*;
import java.util.*;

@SpringBootApplication
@PropertySource( "broceliande.properties" )
public class Broceliande {

    @SuppressLint("NewApi")
    @Bean
    public Clock getClock( @Value( "${timezone}" ) String timezone ) {

        TimeZone.setDefault( TimeZone.getTimeZone( timezone ) );

        return Clock.systemDefaultZone();

    }

}
