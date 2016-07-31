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
import com.windwagon.broceliande.knights.builders.ComplexKnightsBuilder;
import com.windwagon.broceliande.knights.builders.Environment;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.Casern;
import com.windwagon.broceliande.knights.forge.Herald;
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
public class ComplexKnightsTest {

    @Autowired
    private Casern casern;

    @Autowired
    private Stud stud;

    @Autowired
    private ComplexKnightsBuilder complexKnightsBuilder;

    @Test
    @Transactional
    public void testComplexKnight() throws Exception {

        Environment env = complexKnightsBuilder.createEnv().createRuns().saveAll();

        Herald herald = casern.getHerald();

        // run simple things
        herald.getBrotherhood( env.getBrotherhoodRun( 0 ) ).run();

        // instanciate
        KnightWrapper knight = herald.getKnight( env.getFencingMasterRun( 1 ) );
        assertThat( knight.getName(), is( "ComplexKnight" ) );

        // check constants

        String string = knight.call( armored -> armored.getActor().toString() );

        String expected = new StringBuilder( "{" )
                .append( "component:{component:'Hello, World!'}," )
                .append( "knight:{" )
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
                .append( "parameter:{value:null}}," )
                .append( "hidden:{" )
                .append( "constants:{" )
                .append( "boolean:'false'," )
                .append( "string:null," )
                .append( "int:'0'," )
                .append( "double:'0.0'," )
                .append( "enum:null}," )
                .append( "list:[]," )
                .append( "map:{}," )
                .append( "parameter:{value:null}}}" )
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
    public void testComplexFencingMaster() throws Exception {

        Environment env = complexKnightsBuilder.createEnv().createRuns().saveAll();

        Herald herald = casern.getHerald();

        // run simple things
        herald.getBrotherhood( env.getBrotherhoodRun( 0 ) ).run();

        FencingMasterRun fencingMasterRun = env.getFencingMasterRun( 1 );
        assertThat( fencingMasterRun.getFencingMaster().getName(), is( "ComplexFencingMaster" ) );

        herald.getFencingMaster( fencingMasterRun ).run();

        assertThat( fencingMasterRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testComplexBrotherhood() throws Exception {

        Environment env = complexKnightsBuilder.createEnv().createRuns().saveAll();

        Herald herald = casern.getHerald();

        // run simple things
        herald.getBrotherhood( env.getBrotherhoodRun( 0 ) ).run();

        BrotherhoodRun brotherhoodRun = env.getBrotherhoodRun( 1 );
        assertThat( brotherhoodRun.getBrotherhood().getName(), is( "ComplexKnight" ) );

        herald.getBrotherhood( brotherhoodRun ).run();

        assertThat( brotherhoodRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testComplexScribe() throws Exception {

        Environment env = complexKnightsBuilder.createEnv().createRuns().saveAll();

        Herald herald = casern.getHerald();

        // run simple things
        herald.getBrotherhood( env.getBrotherhoodRun( 0 ) ).run();

        ScribeRun scribeRun = env.getScribeRun( 1 );
        assertThat( scribeRun.getScribe().getName(), is( "ComplexScribe" ) );

        herald.getScribe( scribeRun ).run();

        assertThat( scribeRun.getStatus(), is( RunStatus.DONE ) );

    }

}
