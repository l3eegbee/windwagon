package com.windwagon.broceliande.knights;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.windwagon.broceliande.Broceliande;
import com.windwagon.broceliande.knights.builders.Environment;
import com.windwagon.broceliande.knights.builders.SimpleKnightsBuilder;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.Casern;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.race.turf.RaceWrapper;
import com.windwagon.broceliande.race.turf.Stud;
import com.windwagon.broceliande.utils.MeetingNavigator;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.BetWords;
import com.windwagon.kaamelott.words.Words;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = Broceliande.class )
public class SimpleKnightsTest {

    @Autowired
    private Casern casern;

    @Autowired
    private Stud stud;

    @Autowired
    private SimpleKnightsBuilder simpleKnightsBuilder;

    @Test
    @Transactional
    public void testSimpleKnight() throws Exception {

        Environment env = simpleKnightsBuilder.createEnv().createRuns().saveAll();

        // instanciate
        KnightWrapper knight = casern.getHerald().getKnight( env.getFencingMasterRun() );
        assertThat( knight.getName(), is( "SimpleBrotherhood" ) );

        // check constants

        String string = knight.call( armored -> armored.getActor().toString() );

        String expected = new StringBuilder( "{" )
                .append( "constants:{" )
                .append( "boolean:'true'," )
                .append( "string:'My name is Arnold.'," )
                .append( "int:'42'," )
                .append( "double:'3.14159'," )
                .append( "enum:'BLUE'}," )
                .append( "list:[" )
                .append( "{value:'sifa'}," )
                .append( "{value:'siaedng'}]," )
                .append( "map:{" )
                .append( "green:{value:'sikhiav'}," )
                .append( "yellow:{value:'siheuong'}}," )
                .append( "parameter:{value:null}}" )
                .toString();

        assertThat( string, is( expected ) );

        // check words

        RaceWrapper kaamRace = stud.getRace( MeetingNavigator.getRace( env.getMeeting(), 1 ) );
        Words words = knight.call( armored -> armored.getWords( kaamRace ) );

        Horse horse = kaamRace.getHorses().first();
        Words expectedWord = new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );

        assertThat( words, sameBeanAs( expectedWord ) );

    }

    @Test
    @Transactional
    public void testSimpleFencingMaster() throws Exception {

        Environment env = simpleKnightsBuilder.createEnv().createRuns().saveAll();

        FencingMasterRun fencingMasterRun = env.getFencingMasterRun();
        assertThat( fencingMasterRun.getFencingMaster().getName(), is( "SimpleFencingMaster" ) );

        FencingMasterWrapper fencingMaster = casern.getHerald().getFencingMaster( fencingMasterRun );
        fencingMaster.run();

        assertThat( fencingMasterRun.getStatus(), is( RunStatus.DONE ) );

        // check fencing master constants

        String fmString = fencingMaster.call( armored -> armored.getActor().toString() );

        String fmExpected = new StringBuilder( "{" )
                .append( "parameter:{value:'Hey, I'm in the band!'}," )
                .append( "drillHall:8}" )
                .toString();

        assertThat( fmString, is( fmExpected ) );

        // check knight learning

        String kString = fencingMaster.call( armored -> armored.getKnight().getActor().toString() );

        String kExpected = new StringBuilder( "{" )
                .append( "constants:{" )
                .append( "boolean:'true'," )
                .append( "string:'My name is Arnold.'," )
                .append( "int:'42'," )
                .append( "double:'3.14159'," )
                .append( "enum:'BLUE'}," )
                .append( "list:[" )
                .append( "{value:'sifa'}," )
                .append( "{value:'siaedng'}]," )
                .append( "map:{" )
                .append( "green:{value:'sikhiav'}," )
                .append( "yellow:{value:'siheuong'}}," )
                .append( "parameter:{value:'Hey, I'm in the band!'}}" )
                .toString();

        assertThat( kString, is( kExpected ) );

    }

    @Test
    @Transactional
    public void testSimpleBrotherhood() throws Exception {

        Environment env = simpleKnightsBuilder.createEnv().createRuns().saveAll();

        BrotherhoodRun brotherhoodRun = env.getBrotherhoodRun();
        assertThat( brotherhoodRun.getBrotherhood().getName(), is( "SimpleBrotherhood" ) );

        casern.getHerald().getBrotherhood( brotherhoodRun ).run();

        assertThat( brotherhoodRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testSimpleScribe() throws Exception {

        Environment env = simpleKnightsBuilder.createEnv().createRuns().saveAll();

        ScribeRun scribeRun = env.getScribeRun();
        assertThat( scribeRun.getScribe().getName(), is( "SimpleScribe" ) );

        casern.getHerald().getScribe( scribeRun ).run();

        assertThat( scribeRun.getStatus(), is( RunStatus.DONE ) );

    }

}
