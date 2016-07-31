package com.windwagon.broceliande.knights.builders;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.builder.KnightBuilderFactory;
import com.windwagon.broceliande.knights.repositories.BrotherhoodDataRepository;
import com.windwagon.broceliande.knights.repositories.BrotherhoodRunRepository;
import com.windwagon.broceliande.knights.repositories.ComponentClassRepository;
import com.windwagon.broceliande.knights.repositories.CycleRepository;
import com.windwagon.broceliande.knights.repositories.FencingMasterDataRepository;
import com.windwagon.broceliande.knights.repositories.FencingMasterRunRepository;
import com.windwagon.broceliande.knights.repositories.KnightDataRepository;
import com.windwagon.broceliande.knights.repositories.RaceSetRepository;
import com.windwagon.broceliande.knights.repositories.ScribeDataRepository;
import com.windwagon.broceliande.knights.repositories.ScribeRunRepository;
import com.windwagon.broceliande.race.builders.Meeting_20150813_M1;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.repositories.MeetingRepository;

public class Environment {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @PostConstruct
    public void init() {

        cycle = knightBuilderFactory.getCycleBuilder().creation( new Date() ).build();

        meeting = Meeting_20150813_M1.build();
        allRaceSet =
                knightBuilderFactory
                        .getRaceSetBuilder()
                        .name( "all.drill.hall" )
                        .races( new TreeSet<>( meeting.getRaces() ) )
                        .cycle( getCycle() )
                        .build();

    }

    /*
     * Cycle
     */

    @Autowired
    private CycleRepository cycleRepository;

    private Cycle cycle;

    public Cycle getCycle() {
        return cycle;
    }

    /*
     * RaceSet
     */

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private RaceSetRepository raceSetRepository;

    private Meeting meeting;

    private RaceSet allRaceSet;

    public Meeting getMeeting() {
        return this.meeting;
    }

    /*
     * Actors
     */

    @Autowired
    private ComponentClassRepository componentClassRepository;

    @Autowired
    private KnightDataRepository knightDataRepository;

    @Autowired
    private FencingMasterDataRepository fencingMasterDataRepository;

    @Autowired
    private BrotherhoodDataRepository brotherhoodDataRepository;

    @Autowired
    private ScribeDataRepository scribeDataRepository;

    @Autowired
    private FencingMasterRunRepository fencingMasterRunRepository;

    @Autowired
    private BrotherhoodRunRepository brotherhoodRunRepository;

    @Autowired
    private ScribeRunRepository scribeRunRepository;

    private List<ComponentClass> listComponentClass = new LinkedList<>();

    private List<KnightData> listKnightData = new LinkedList<>();

    private List<FencingMasterData> listFencingMasterData = new LinkedList<>();

    private List<BrotherhoodData> listBrotherhoodData = new LinkedList<>();

    private List<ScribeData> listScribeData = new LinkedList<>();

    private List<FencingMasterRun> listFencingMasterRun = new LinkedList<>();

    private List<BrotherhoodRun> listBrotherhoodRun = new LinkedList<>();

    private List<ScribeRun> listScribeRun = new LinkedList<>();

    public Environment addComponentClass( ComponentClass componentClass ) {
        listComponentClass.add( componentClass );
        return this;
    }

    public Environment addKnightData( KnightData knightData ) {
        listKnightData.add( knightData );
        return this;
    }

    public Environment addFencingMasterData( FencingMasterData fencingMasterData ) {
        listFencingMasterData.add( fencingMasterData );
        return this;
    }

    public Environment addBrotherhoodData( BrotherhoodData brotherhoodData ) {
        listBrotherhoodData.add( brotherhoodData );
        return this;
    }

    public Environment addScribeData( ScribeData scribeData ) {
        listScribeData.add( scribeData );
        return this;
    }

    public KnightData getKnightData() {
        return getKnightData( 0 );
    }

    public KnightData getKnightData( int i ) {
        return listKnightData.get( i );
    }

    public FencingMasterData getFencingMasterData() {
        return getFencingMasterData( 0 );
    }

    public FencingMasterData getFencingMasterData( int i ) {
        return listFencingMasterData.get( i );
    }

    public BrotherhoodData getBrotherhoodData() {
        return getBrotherhoodData( 0 );
    }

    public BrotherhoodData getBrotherhoodData( int i ) {
        return listBrotherhoodData.get( i );
    }

    public ScribeData getScribeData() {
        return getScribeData( 0 );
    }

    public ScribeData getScribeData( int i ) {
        return listScribeData.get( i );
    }

    public FencingMasterRun getFencingMasterRun() {
        return getFencingMasterRun( 0 );
    }

    public FencingMasterRun getFencingMasterRun( int i ) {
        return listFencingMasterRun.get( i );
    }

    public BrotherhoodRun getBrotherhoodRun() {
        return getBrotherhoodRun( 0 );
    }

    public BrotherhoodRun getBrotherhoodRun( int i ) {
        return listBrotherhoodRun.get( i );
    }

    public ScribeRun getScribeRun() {
        return getScribeRun( 0 );
    }

    public ScribeRun getScribeRun( int i ) {
        return listScribeRun.get( i );
    }

    public Environment createRuns() {

        Cycle cycle = getCycle();

        Map<FencingMasterData, FencingMasterRun> fencingMasterMap = new HashMap<>();

        for( FencingMasterData fencingMasterData : listFencingMasterData ) {

            FencingMasterRun fencingMasterRun =
                    knightBuilderFactory
                            .getFencingMasterRunBuilder()
                            .cycle( cycle )
                            .status( RunStatus.TODO )
                            .fencingMaster( fencingMasterData )
                            .build();

            fencingMasterMap.put( fencingMasterData, fencingMasterRun );
            listFencingMasterRun.add( fencingMasterRun );

        }

        for( BrotherhoodData brotherhoodData : listBrotherhoodData )
            listBrotherhoodRun.add(
                    knightBuilderFactory
                            .getBrotherhoodRunBuilder()
                            .cycle( cycle )
                            .status( RunStatus.TODO )
                            .brotherhood( brotherhoodData )
                            .fencingMasters(
                                    new TreeSet<>(
                                            brotherhoodData
                                                    .getFencingMasters()
                                                    .stream()
                                                    .map( fm -> fencingMasterMap.get( fm ) )
                                                    .collect( Collectors.toList() ) ) )
                            .build() );

        for( ScribeData scribeData : listScribeData )
            listScribeRun.add(
                    knightBuilderFactory
                            .getScribeRunBuilder()
                            .cycle( cycle )
                            .status( RunStatus.TODO )
                            .scribe( scribeData )
                            .build() );

        return this;

    }

    @Transactional
    public Environment saveAll() {

        meetingRepository.save( meeting );

        componentClassRepository.save( listComponentClass );

        knightDataRepository.save( listKnightData );
        brotherhoodDataRepository.save( listBrotherhoodData );
        fencingMasterDataRepository.save( listFencingMasterData );
        scribeDataRepository.save( listScribeData );

        cycleRepository.save( getCycle() );
        raceSetRepository.save( allRaceSet );

        brotherhoodRunRepository.save( listBrotherhoodRun );
        fencingMasterRunRepository.save( listFencingMasterRun );
        scribeRunRepository.save( listScribeRun );

        return this;

    }

    @Transactional
    public void deleteAll() {

        scribeRunRepository.deleteAll();
        fencingMasterRunRepository.deleteAll();
        brotherhoodRunRepository.deleteAll();

        raceSetRepository.deleteAll();
        cycleRepository.deleteAll();

        scribeDataRepository.deleteAll();
        fencingMasterDataRepository.deleteAll();
        brotherhoodDataRepository.deleteAll();
        knightDataRepository.deleteAll();

        componentClassRepository.deleteAll();

        meetingRepository.deleteAll();

    }

}
