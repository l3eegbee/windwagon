package com.windwagon.broceliande.race.turf;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Place;
import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.race.turf.impl.FinishWrapperImpl;
import com.windwagon.broceliande.race.turf.impl.HorseIDWrapperImpl;
import com.windwagon.broceliande.race.turf.impl.HorseWrapperImpl;
import com.windwagon.broceliande.race.turf.impl.MeetingWrapperImpl;
import com.windwagon.broceliande.race.turf.impl.PriceWrapperImpl;
import com.windwagon.broceliande.race.turf.impl.RaceWrapperImpl;

@Configuration
public class Stud {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public MeetingWrapper getMeeting( Reference ref, Meeting meeting ) {
        return new MeetingWrapperImpl( ref, meeting );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public MeetingWrapper getMeeting( Reference ref, Meeting meeting, RaceWrapper race ) {
        return new MeetingWrapperImpl( ref, meeting, race );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public RaceWrapper getRace( Reference ref, Race race ) {
        return new RaceWrapperImpl( ref, race );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public RaceWrapper getRace( Reference ref, Race race, MeetingWrapper meeting ) {
        return new RaceWrapperImpl( ref, race, meeting );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public RaceWrapper getRace( Reference ref, Race race, HorseWrapper horse ) {
        return new RaceWrapperImpl( ref, race, horse );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public HorseWrapper getHorse( Reference ref, Horse horse ) {
        return new HorseWrapperImpl( ref, horse );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public FinishWrapper getFinish( Reference ref, Place place, HorseWrapper horse ) {
        return new FinishWrapperImpl( ref, place, horse );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public PriceWrapper getPrice( Reference ref, Price price, RaceWrapper race ) {
        return new PriceWrapperImpl( ref, price, race );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public HorseIDWrapper getHorseID( Reference ref, HorseID horseID ) {
        return new HorseIDWrapperImpl( ref, horseID );
    }

    // not a bean
    public HorseIterator iterate( Reference ref, List<Horse> horses ) {
        return new HorseIterator( this, ref, horses );
    }

}
