package com.windwagon.broceliande.race.turf.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.race.entities.Horse;
import com.windwagon.broceliande.race.entities.HorseID;
import com.windwagon.broceliande.race.repositories.HorseIDRepository;
import com.windwagon.broceliande.race.repositories.HorseRepository;
import com.windwagon.broceliande.race.turf.HorseIDWrapper;
import com.windwagon.broceliande.race.turf.Reference;
import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumConverter;
import com.windwagon.logres.collection.LazyInitializer;

public class HorseIDWrapperImpl extends ObjectWrapperImpl<HorseID> implements HorseIDWrapper {

    @Autowired
    private HorseIDRepository horseIDRepository;

    @Autowired
    private HorseRepository horseRepository;

    public HorseIDWrapperImpl( Reference ref, HorseID horseID ) {
        super( ref, horseID );
    }

    @Override
    public String getName() {
        return daoObject.getName();
    }

    @Override
    public Iterator<com.windwagon.kaamelott.race.Horse> getHistory() {
        List<Horse> listHorse = horseRepository.getHorseHistory( daoObject, ref.getNow() );
        return stud.iterate( ref, listHorse );
    }

    private LazyInitializer<HorseIDWrapper> father = new LazyInitializer<>( () -> {

        HorseID fid = horseIDRepository.findFather( daoObject );
        return ( fid == null ) ? null : stud.getHorseID( ref, fid );

    } );

    @Override
    public com.windwagon.kaamelott.race.HorseID getFather() {
        return father.get();
    }

    private LazyInitializer<HorseIDWrapper> mother = new LazyInitializer<>( () -> {

        HorseID fid = horseIDRepository.findMother( daoObject );
        return ( fid == null ) ? null : stud.getHorseID( ref, fid );

    } );

    @Override
    public com.windwagon.kaamelott.race.HorseID getMother() {
        return mother.get();
    }

    @Override
    public Date getBirth() {
        return daoObject.getBirth();
    }

    @Override
    public com.windwagon.kaamelott.race.Sex getSex() {
        return KaamelottEnumConverter.sex.castToKaamelott( daoObject.getSex() );
    }

    @Override
    public Date getGeldingDate() {
        Date gdate = daoObject.getGelding();
        return ( gdate == null || gdate.after( ref.getNow() ) ) ? null : gdate;
    }

    @Override
    public com.windwagon.kaamelott.race.Breed getBreed() {
        return KaamelottEnumConverter.breed.castToKaamelott( daoObject.getBreed() );
    }

    @Override
    public com.windwagon.kaamelott.race.Coat getCoat() {
        return KaamelottEnumConverter.coat.castToKaamelott( daoObject.getCoat() );
    }

}
