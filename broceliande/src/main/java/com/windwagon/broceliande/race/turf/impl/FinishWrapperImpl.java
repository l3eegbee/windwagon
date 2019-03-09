package com.windwagon.broceliande.race.turf.impl;

import android.annotation.*;

import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.turf.*;

import java.util.*;

@SuppressLint("NewApi")
public class FinishWrapperImpl extends ObjectWrapperImpl<Place> implements FinishWrapper {

    public final static Comparator<com.windwagon.kaamelott.race.Finish> COMPARATOR = Comparator
            .comparingInt( com.windwagon.kaamelott.race.Finish::getPlace );

    public FinishWrapperImpl( Reference ref, Place place, HorseWrapper horse ) {
        super( ref, place );
        this.horse = horse;
    }

    @Override
    public int compareTo( com.windwagon.kaamelott.race.Finish finish ) {
        return COMPARATOR.compare( this, finish );
    }

    @Override
    public int getPlace() {
        return daoObject.getNumber();
    }

    @Override
    public String getDistance() {
        return daoObject.getDistance();
    }

    @Override
    public Integer getDuration() {
        return daoObject.getDuration();
    }

    private HorseWrapper horse = null;

    @Override
    public com.windwagon.kaamelott.race.Horse getHorse() {
        return horse;
    }

}
