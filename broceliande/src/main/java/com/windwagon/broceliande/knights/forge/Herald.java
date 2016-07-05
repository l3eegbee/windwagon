package com.windwagon.broceliande.knights.forge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.entities.ScribeRun;

public class Herald {

    @Autowired
    private Casern casern;

    private Map<OfficialKnightData, OfficialKnightWrapper> officialKnights = new HashMap<>();

    private Map<Cycle, Map<ActorData, KnightWrapper>> knights = new HashMap<>();

    private Map<Cycle, Map<ActorData, FencingMasterWrapper>> fencingMasters = new HashMap<>();

    private Map<Cycle, Map<ActorData, BrotherhoodWrapper>> brotherhoods = new HashMap<>();

    private Map<Cycle, Map<ActorData, ScribeWrapper>> scribes = new HashMap<>();

    private Map<Cycle, Map<ActorData, PageWrapper>> pages = new HashMap<>();

    private Map<ComponentData, ComponentWrapper> components = new HashMap<>();

    private Map<RaceSet, DrillHallWrapper> drillHalls = new HashMap<>();

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

    public PageWrapper getPage( Cycle cycle, PageData pageData ) {
        return pages.computeIfAbsent( cycle, this::newhash ).computeIfAbsent(
                pageData,
                data -> casern.getPage( this, cycle, pageData ) );
    }

    public ComponentWrapper getComponent( ComponentData component ) {
        return components.computeIfAbsent( component, data -> casern.getComponent( this, component ) );
    }

    public DrillHallWrapper getDrillHall( RaceSet raceSet ) {
        return drillHalls.computeIfAbsent( raceSet, data -> casern.getDrillHall( raceSet ) );
    }

}
