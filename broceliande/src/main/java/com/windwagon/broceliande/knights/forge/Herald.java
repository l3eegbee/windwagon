package com.windwagon.broceliande.knights.forge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.SquireData;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.logres.collection.LazyInitializer;

public class Herald {

    @Autowired
    private Casern casern;

    private Map<OfficialKnightData, OfficialKnightWrapper> officialKnights;

    private Map<Cycle, Map<ActorData, KnightWrapper>> knights;

    private Map<Cycle, Map<ActorData, FencingMasterWrapper>> fencingMasters;

    private Map<Cycle, Map<ActorData, BrotherhoodWrapper>> brotherhoods;

    private Map<Cycle, Map<ActorData, ScribeWrapper>> scribes;

    private Map<Cycle, Map<ActorData, SquireWrapper>> squires;

    private Map<ComponentClass, ComponentWrapper> components;

    private LazyInitializer<NullComponentWrapper> nullWrapper;

    private Map<RaceSet, DrillHallWrapper> drillHalls;

    public Herald() {

        this.officialKnights = new HashMap<>();
        this.knights = new HashMap<>();
        this.fencingMasters = new HashMap<>();
        this.brotherhoods = new HashMap<>();
        this.scribes = new HashMap<>();
        this.squires = new HashMap<>();
        this.components = new HashMap<>();
        this.nullWrapper = new LazyInitializer<>( () -> casern.getNullComponent( this ) );
        this.drillHalls = new HashMap<>();

    }

    public Herald( Herald from ) {

        this.officialKnights = new HashMap<>( from.officialKnights );
        this.knights = new HashMap<>( from.knights );
        this.fencingMasters = new HashMap<>( from.fencingMasters );
        this.brotherhoods = new HashMap<>( from.brotherhoods );
        this.scribes = new HashMap<>( from.scribes );
        this.squires = new HashMap<>( from.squires );
        this.components = new HashMap<>( from.components );
        this.nullWrapper = from.nullWrapper;
        this.drillHalls = new HashMap<>( from.drillHalls );

    }

    private <K, V> Map<K, V> newhash( Cycle cycle ) {
        return new HashMap<>();
    }

    public OfficialKnightWrapper getOfficialKnight( OfficialKnightData knightData ) {
        return officialKnights.computeIfAbsent( knightData, data -> casern.getOfficialKnight( this, knightData ) );
    }

    public KnightWrapper getKnight( FencingMasterRun fencingMasterRun ) {
        return knights.computeIfAbsent( fencingMasterRun.getCycle(), this::newhash ).computeIfAbsent(
                fencingMasterRun.getFencingMaster().getKnight(),
                data -> casern.getKnight( this, fencingMasterRun ) );
    }

    public FencingMasterWrapper getFencingMaster( FencingMasterRun fencingMasterRun ) {
        return fencingMasters.computeIfAbsent( fencingMasterRun.getCycle(), this::newhash ).computeIfAbsent(
                fencingMasterRun.getFencingMaster(),
                data -> casern.getFencingMaster( this, fencingMasterRun ) );
    }

    public BrotherhoodWrapper getBrotherhood( BrotherhoodRun brotherhoodRun ) {
        return brotherhoods.computeIfAbsent( brotherhoodRun.getCycle(), this::newhash ).computeIfAbsent(
                brotherhoodRun.getBrotherhood(),
                data -> casern.getBrotherhood( this, brotherhoodRun ) );
    }

    public ScribeWrapper getScribe( ScribeRun scribeRun ) {
        return scribes.computeIfAbsent( scribeRun.getCycle(), this::newhash ).computeIfAbsent(
                scribeRun.getScribe(),
                data -> casern.getScribe( this, scribeRun ) );
    }

    public SquireWrapper getSquire( Cycle cycle, SquireData squireData ) {
        return squires.computeIfAbsent( cycle, this::newhash ).computeIfAbsent(
                squireData,
                data -> casern.getSquire( this, cycle, squireData ) );
    }

    public ComponentWrapper getComponent( ComponentClass componentClass ) {
        return components.computeIfAbsent( componentClass, data -> casern.getComponent( this, componentClass ) );
    }

    public NullComponentWrapper getNull() {
        return nullWrapper.get();
    }

    public DrillHallWrapper getDrillHall( RaceSet raceSet ) {
        return drillHalls.computeIfAbsent( raceSet, data -> casern.getDrillHall( raceSet ) );
    }

}
