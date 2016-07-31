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
import com.windwagon.broceliande.knights.builders.DummyKnightsBuilder;
import com.windwagon.broceliande.knights.builders.Environment;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.Casern;
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
public class DummyKnightsTest {

    @Autowired
    private Casern casern;

    @Autowired
    private Stud stud;

    @Autowired
    private DummyKnightsBuilder dummyKnightsBuilder;

    @Test
    @Transactional
    public void testDummyKnight() throws Exception {

        Environment env = dummyKnightsBuilder.createEnv().createRuns().saveAll();

        // instanciate
        KnightWrapper knight = casern.getHerald().getKnight( env.getFencingMasterRun() );
        assertThat( knight.getName(), is( "DummyBrotherhood" ) );

        // check words

        RaceWrapper kaamRace = stud.getRace( MeetingNavigator.getRace( env.getMeeting(), 1 ) );
        Words words = knight.call( armored -> armored.getWords( kaamRace ) );

        Horse horse = kaamRace.getHorses().first();
        Words expectedWord = new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );

        assertThat( words, sameBeanAs( expectedWord ) );

    }

    @Test
    @Transactional
    public void testDummyFencingMaster() throws Exception {

        Environment env = dummyKnightsBuilder.createEnv().createRuns().saveAll();

        FencingMasterRun fencingMasterRun = env.getFencingMasterRun();
        assertThat( fencingMasterRun.getFencingMaster().getName(), is( "DummyFencingMaster" ) );

        casern.getHerald().getFencingMaster( fencingMasterRun ).run();

        assertThat( fencingMasterRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testDummyBrotherhood() throws Exception {

        Environment env = dummyKnightsBuilder.createEnv().createRuns().saveAll();

        BrotherhoodRun brotherhoodRun = env.getBrotherhoodRun();
        assertThat( brotherhoodRun.getBrotherhood().getName(), is( "DummyBrotherhood" ) );

        casern.getHerald().getBrotherhood( brotherhoodRun ).run();

        assertThat( brotherhoodRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testDummyScribe() throws Exception {

        Environment env = dummyKnightsBuilder.createEnv().createRuns().saveAll();

        ScribeRun scribeRun = env.getScribeRun();
        assertThat( scribeRun.getScribe().getName(), is( "DummyScribe" ) );

        casern.getHerald().getScribe( scribeRun ).run();

        assertThat( scribeRun.getStatus(), is( RunStatus.DONE ) );

    }

}
