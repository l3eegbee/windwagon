package com.windwagon.broceliande.race.turf.impl;

import java.util.Collections;
import java.util.SortedSet;

import com.windwagon.broceliande.race.entities.Price;
import com.windwagon.broceliande.race.turf.PriceWrapper;
import com.windwagon.broceliande.race.turf.RaceWrapper;
import com.windwagon.broceliande.race.turf.Reference;
import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumConverter;
import com.windwagon.logres.collection.Sets;

public class PriceWrapperImpl extends ObjectWrapperImpl<Price> implements PriceWrapper {

    public PriceWrapperImpl( Reference ref, Price price, RaceWrapper race ) {

        super( ref, price );

        // ticket
        ticket = Sets.navigableSetFromList( race.getHorsesByNum( price.getTicket() ) );

    }

    @Override
    public com.windwagon.kaamelott.race.BetType getBetType() {
        return KaamelottEnumConverter.betType.castToKaamelott( daoObject.getBet() );
    }

    @Override
    public com.windwagon.kaamelott.race.PriceName getPriceName() {
        return KaamelottEnumConverter.priceName.castToKaamelott( daoObject.getPriceName() );
    }

    @Override
    public Double getPrice() {
        return daoObject.getPrice();
    }

    @SuppressWarnings( { "all", "unchecked" } )
    private SortedSet ticket;

    @Override
    @SuppressWarnings( { "all", "unchecked" } )
    public SortedSet<com.windwagon.kaamelott.race.Horse> getTicket() {
        return Collections.unmodifiableSortedSet( ticket );
    }

}
