package com.windwagon.broceliande.knights;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Date;
import java.util.TreeSet;

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
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.RunStatus;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.Casern;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.builder.CycleBuilder;
import com.windwagon.broceliande.knights.forge.builder.KnightBuilderFactory;
import com.windwagon.broceliande.race.builders.Meeting_20150813_M1;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.repositories.MeetingRepository;
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
    private MeetingRepository meetingRepository;

    @Autowired
    private Casern casern;

    @Autowired
    private Stud stud;

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private ComplexKnightsBuilder complexKnightsBuilder;

    private Meeting meeting;

    public Environment setUp() {

        meeting = Meeting_20150813_M1.build();
        meetingRepository.save( meeting );

        CycleBuilder cycleBuilder = knightBuilderFactory.getCycleBuilder();
        cycleBuilder.creation( new Date() ).raceSet().description( "Meeting races" ).races(
                new TreeSet<>( meeting.getRaces() ) );
        Cycle cycle = cycleBuilder.build();

        return complexKnightsBuilder.createEnv().createRuns( cycle ).saveAll();

    }

    @Test
    @Transactional
    public void testComplexKnight() throws Exception {

        Environment env = setUp();

        // instanciate
        KnightWrapper knight = casern.getKnight( env.getFencingMasterRun() );
        knight.instanciate();

        try {

            // check words

            RaceWrapper kaamRace = stud.getRace( MeetingNavigator.getRace( meeting, 1 ) );
            Words words = knight.call( () -> knight.getWords( kaamRace ) );

            Horse horse = kaamRace.getHorses().first();
            Words expectedWord = new BetWords( new Bet( BetType.SIMPLE_GAGNANT, horse ) );

            assertThat( words, sameBeanAs( expectedWord ) );

        } finally {

            knight.close();

        }

    }

    @Test
    @Transactional
    public void testComplexFencingMaster() throws Exception {

        FencingMasterRun fencingMasterRun = setUp().getFencingMasterRun();

        casern.getFencingMaster( fencingMasterRun ).run();

        assertThat( fencingMasterRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testComplexBrotherhood() throws Exception {

        BrotherhoodRun brotherhoodRun = setUp().getBrotherhoodRun();

        casern.getBrotherhood( brotherhoodRun ).run();

        assertThat( brotherhoodRun.getStatus(), is( RunStatus.DONE ) );

    }

    @Test
    @Transactional
    public void testComplexScribe() throws Exception {

        ScribeRun scribeRun = setUp().getScribeRun();

        casern.getScribe( scribeRun ).run();

        assertThat( scribeRun.getStatus(), is( RunStatus.DONE ) );

    }

}
