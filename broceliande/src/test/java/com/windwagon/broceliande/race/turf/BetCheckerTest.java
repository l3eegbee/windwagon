package com.windwagon.broceliande.race.turf;

import com.windwagon.broceliande.*;
import com.windwagon.broceliande.race.builders.*;
import com.windwagon.broceliande.race.entities.Meeting;
import com.windwagon.broceliande.race.entities.Race;
import com.windwagon.broceliande.utils.*;
import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.words.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

@RunWith( /*SpringJUnit4Class*/SpringRunner.class )
@SpringBootTest(classes = Broceliande.class)
//@SpringApplicationConfiguration( classes = Broceliande.class )
public class BetCheckerTest {

    @Autowired
    private Stud stud;

    private RaceWrapper getRaceWrapper( Meeting meeting, int numRace ) {
        Race race = MeetingNavigator.getRace( meeting, numRace );
        return stud.getRace( new Reference( race.getStart() ), race );
    }

    private Bet createBet( RaceWrapper race, BetType betType, double stake, int ... horseNums ) {

        List<com.windwagon.kaamelott.race.Horse> ticket = new Vector<>( horseNums.length );
        for( int num : horseNums )
            ticket.add( race.getHorseByNum( num ) );

        return new Bet( betType, stake, ticket );

    }

    /*
     * BET VALIDITY
     */

    private void checkValidity(
            boolean shouldBeValid,
            RaceWrapper race,
            BetType betType,
            double stake,
            int ... horseNums ) {

        Bet bet = createBet( race, betType, stake, horseNums );

        assertThat( race.isValidBet( bet ), is( shouldBeValid ) );

    }

    @Test
    public void simpleValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.SIMPLE_GAGNANT, 2.00d, 5 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 1.00d, 5 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 3.20d, 5 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 2.00d, 17 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 2.00d, 5, 4 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 2.00d, 5, 5 );
        checkValidity( false, race, BetType.SIMPLE_GAGNANT, 2.00d );

        checkValidity( true, race, BetType.SIMPLE_PLACE, 2.00d, 5 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 1.00d, 5 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 3.20d, 5 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 2.00d, 17 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 2.00d, 5, 4 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 2.00d, 5, 5 );
        checkValidity( false, race, BetType.SIMPLE_PLACE, 2.00d );

    }

    @Test
    public void coupleValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.COUPLE_ORDRE, 2.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 1.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 3.20d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 2.00d, 17, 4 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 2.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 2.00d, 5, 5 );
        checkValidity( false, race, BetType.COUPLE_ORDRE, 2.00d );

        checkValidity( true, race, BetType.COUPLE_GAGNANT, 2.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 1.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 3.20d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 2.00d, 17, 4 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 2.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 2.00d, 5, 5 );
        checkValidity( false, race, BetType.COUPLE_GAGNANT, 2.00d );

        checkValidity( true, race, BetType.COUPLE_PLACE, 2.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 1.00d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 3.20d, 5, 4 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 2.00d, 17, 4 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 2.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 2.00d, 5, 5 );
        checkValidity( false, race, BetType.COUPLE_PLACE, 2.00d );

    }

    @Test
    public void trioValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.TRIO, 2.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.TRIO, 1.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.TRIO, 3.20d, 5, 4, 3 );
        checkValidity( false, race, BetType.TRIO, 2.00d, 5, 17, 3 );
        checkValidity( false, race, BetType.TRIO, 2.00d, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.TRIO, 2.00d, 5, 4, 4 );
        checkValidity( false, race, BetType.TRIO, 2.00d );

        // no trio ordre
        checkValidity( false, race, BetType.TRIO_ORDRE, 2.00d, 5, 4, 3 );

    }

    @Test
    public void deuxSurQuatreValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.DEUX_SUR_QUATRE, 3.00, 5, 4 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 2.00, 5, 4 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 5.30, 5, 4 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 3.00, 5, 17 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 3.00, 5, 4, 6 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 3.00, 4, 4 );
        checkValidity( false, race, BetType.DEUX_SUR_QUATRE, 3.00 );

    }

    @Test
    public void multiValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.MULTI_EN_QUATRE, 3.00, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 2.00, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 3.30, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 3.00, 5, 4, 17, 2 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 3.00, 5, 4, 3, 2, 1 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 3.00, 5, 4, 4, 2 );
        checkValidity( false, race, BetType.MULTI_EN_QUATRE, 3.00 );

        checkValidity( true, race, BetType.MULTI_EN_CINQ, 3.00, 6, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 2.00, 5, 6, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 3.30, 5, 4, 6, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 3.00, 5, 4, 17, 6, 2 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 3.00, 5, 4, 6, 3, 2, 1 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 3.00, 5, 6, 4, 4, 2 );
        checkValidity( false, race, BetType.MULTI_EN_CINQ, 3.00 );

        checkValidity( true, race, BetType.MULTI_EN_SIX, 3.00, 6, 5, 7, 4, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 2.00, 5, 6, 4, 7, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 3.30, 5, 7, 4, 6, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 3.00, 5, 4, 17, 6, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 3.00, 5, 4, 6, 7, 3, 2, 1 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 3.00, 5, 7, 6, 4, 4, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SIX, 3.00 );

        checkValidity( true, race, BetType.MULTI_EN_SEPT, 3.00, 6, 5, 7, 4, 8, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 2.00, 8, 5, 6, 4, 7, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 3.30, 5, 7, 4, 6, 8, 3, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 3.00, 5, 8, 4, 17, 6, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 3.00, 5, 4, 6, 7, 3, 8, 2, 1 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 3.00, 8, 5, 7, 6, 4, 4, 2 );
        checkValidity( false, race, BetType.MULTI_EN_SEPT, 3.00 );

    }

    @Test
    public void tierceValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.TIERCE, 2.00d, 5, 4, 3 );
        checkValidity( false, race, BetType.TIERCE, 0.50d, 5, 4, 3 );
        checkValidity( false, race, BetType.TIERCE, 3.20d, 5, 4, 3 );
        checkValidity( false, race, BetType.TIERCE, 2.00d, 5, 17, 3 );
        checkValidity( false, race, BetType.TIERCE, 2.00d, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.TIERCE, 2.00d, 5, 4, 4 );
        checkValidity( false, race, BetType.TIERCE, 2.00d );

    }

    @Test
    public void quarteValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.QUARTE, 2.00d, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUARTE, 0.50d, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUARTE, 3.20d, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUARTE, 2.00d, 5, 17, 3, 2 );
        checkValidity( false, race, BetType.QUARTE, 2.00d, 5, 4, 3, 2, 1 );
        checkValidity( false, race, BetType.QUARTE, 2.00d, 5, 4, 4, 2 );
        checkValidity( false, race, BetType.QUARTE, 2.00d );

    }

    @Test
    public void quinteValidityTest() {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        checkValidity( true, race, BetType.QUINTE, 2.00d, 6, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUINTE, 0.50d, 6, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUINTE, 3.20d, 6, 5, 4, 3, 2 );
        checkValidity( false, race, BetType.QUINTE, 2.00d, 6, 5, 17, 3, 2 );
        checkValidity( false, race, BetType.QUINTE, 2.00d, 6, 5, 4, 3, 2, 1 );
        checkValidity( false, race, BetType.QUINTE, 2.00d, 6, 5, 4, 4, 2 );
        checkValidity( false, race, BetType.QUINTE, 2.00d );

    }

    /*
     * BET BALANCE
     */

    private void testBet(
            RaceWrapper race,
            double rapport,
            BetType betType,
            double stake,
            int ... horseNums ) throws InvalidBet {

        Bet bet = createBet( race, betType, stake, horseNums );

        assertThat(
                1d + race.getBalance( bet ) / stake,
                is( closeTo( rapport, BetChecker.DOUBLE_TOLERANCE ) ) );

    }

    @Test
    public void simpleBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 10.30d, BetType.SIMPLE_GAGNANT, 2d, 1 );
        testBet( race, 00.00d, BetType.SIMPLE_GAGNANT, 2d, 5 );
        testBet( race, 00.00d, BetType.SIMPLE_GAGNANT, 2d, 8 );
        testBet( race, 00.00d, BetType.SIMPLE_GAGNANT, 2d, 4 );

        testBet( race, 04.20d, BetType.SIMPLE_PLACE, 2d, 1 );
        testBet( race, 03.20d, BetType.SIMPLE_PLACE, 2d, 5 );
        testBet( race, 13.20d, BetType.SIMPLE_PLACE, 2d, 8 );
        testBet( race, 00.00d, BetType.SIMPLE_PLACE, 2d, 4 );
        testBet( race, 01.00d, BetType.SIMPLE_PLACE, 2d, 17 );

    }

    @Test
    public void coupleBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 52.40d, BetType.COUPLE_ORDRE, 2d, 1, 5 );
        testBet( race, 00.00d, BetType.COUPLE_ORDRE, 2d, 5, 1 );
        testBet( race, 00.00d, BetType.COUPLE_ORDRE, 2d, 5, 8 );

        testBet( race, 31.40d, BetType.COUPLE_GAGNANT, 2d, 1, 5 );
        testBet( race, 31.40d, BetType.COUPLE_GAGNANT, 2d, 5, 1 );
        testBet( race, 00.00d, BetType.COUPLE_GAGNANT, 2d, 5, 8 );

        testBet( race, 14.60d, BetType.COUPLE_PLACE, 2d, 1, 5 );
        testBet( race, 14.60d, BetType.COUPLE_PLACE, 2d, 5, 1 );
        testBet( race, 59.80d, BetType.COUPLE_PLACE, 2d, 8, 5 );
        testBet( race, 59.80d, BetType.COUPLE_PLACE, 2d, 5, 8 );
        testBet( race, 00.00d, BetType.COUPLE_PLACE, 2d, 5, 4 );

    }

    @Test
    public void trioBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 599.10d, BetType.TRIO, 2d, 1, 5, 8 );
        testBet( race, 599.10d, BetType.TRIO, 2d, 5, 8, 1 );
        testBet( race, 000.00d, BetType.TRIO, 2d, 5, 8, 4 );

    }

    @Test
    public void deuxSurQuatreBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 17.70d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 1, 5 );
        testBet( race, 17.70d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 5, 1 );
        testBet( race, 17.70d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 5, 8 );
        testBet( race, 17.70d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 4, 8 );
        testBet( race, 00.00d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 7, 8 );

    }

    @Test
    public void multiBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 2583.00d / 3d, BetType.MULTI_EN_QUATRE, 3d, 1, 5, 8, 4 );
        testBet( race, 2583.00d / 3d, BetType.MULTI_EN_QUATRE, 3d, 4, 5, 1, 8 );
        testBet( race, 0000.00d / 3d, BetType.MULTI_EN_QUATRE, 3d, 8, 4, 7, 1 );

        testBet( race, 516.60d / 3d, BetType.MULTI_EN_CINQ, 3d, 1, 5, 8, 4, 7 );
        testBet( race, 516.60d / 3d, BetType.MULTI_EN_CINQ, 3d, 8, 4, 7, 5, 1 );
        testBet( race, 000.00d / 3d, BetType.MULTI_EN_CINQ, 3d, 8, 3, 5, 4, 7 );

        testBet( race, 172.20d / 3d, BetType.MULTI_EN_SIX, 3d, 1, 5, 8, 4, 7, 3 );
        testBet( race, 172.20d / 3d, BetType.MULTI_EN_SIX, 3d, 1, 5, 3, 7, 8, 4 );
        testBet( race, 000.00d / 3d, BetType.MULTI_EN_SIX, 3d, 1, 4, 2, 5, 7, 3 );

        testBet( race, 73.80d / 3d, BetType.MULTI_EN_SEPT, 3d, 1, 5, 8, 4, 7, 3, 2 );
        testBet( race, 73.80d / 3d, BetType.MULTI_EN_SEPT, 3d, 7, 2, 1, 8, 4, 5, 3 );
        testBet( race, 00.00d / 3d, BetType.MULTI_EN_SEPT, 3d, 1, 3, 7, 2, 8, 6, 5 );

    }

    @Test
    public void tierceBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 955.50d, BetType.TIERCE, 2d, 1, 5, 8 );
        testBet( race, 191.10d, BetType.TIERCE, 2d, 5, 1, 8 );
        testBet( race, 000.00d, BetType.TIERCE, 2d, 5, 4, 8 );

    }

    @Test
    public void quarteBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 4108.78d / 1.30d, BetType.QUARTE, 2d, 1, 5, 8, 4 );
        testBet( race, 0302.64d / 1.30d, BetType.QUARTE, 2d, 4, 8, 5, 1 );
        testBet( race, 0075.66d / 1.30d, BetType.QUARTE, 2d, 1, 8, 5, 2 );
        testBet( race, 0000.00d / 1.30d, BetType.QUARTE, 2d, 7, 8, 4, 2 );

    }

    @Test
    public void quinteBalanceTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 3 );

        testBet( race, 91697.40d / 2.00d, BetType.QUINTE, 2d, 1, 5, 8, 4, 13 );
        testBet( race, 01343.00d / 2.00d, BetType.QUINTE, 2d, 5, 1, 13, 8, 4 );
        testBet( race, 00086.40d / 2.00d, BetType.QUINTE, 2d, 4, 5, 1, 8, 15 );
        testBet( race, 00043.20d / 2.00d, BetType.QUINTE, 2d, 15, 1, 8, 13, 5 );
        testBet( race, 00028.80d / 2.00d, BetType.QUINTE, 2d, 1, 8, 5, 2, 15 );

    }

    @Test
    public void notRunningTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 2 );

        testBet( race, 4.50d, BetType.COUPLE_ORDRE, 2d, 12, 6 );
        testBet( race, 4.50d, BetType.COUPLE_ORDRE, 2d, 12, 6 );

        testBet( race, 4.50d, BetType.COUPLE_GAGNANT, 2d, 6, 12 );
        testBet( race, 4.50d, BetType.COUPLE_GAGNANT, 2d, 12, 6 );

        testBet( race, 1.60d, BetType.COUPLE_PLACE, 2d, 6, 12 );
        testBet( race, 1.60d, BetType.COUPLE_PLACE, 2d, 12, 6 );

        testBet( race, 4.20d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 12, 6 );
        testBet( race, 4.20d / 3d, BetType.DEUX_SUR_QUATRE, 3d, 6, 12 );

    }

    @Test
    public void stableTest() throws InvalidBet {

        RaceWrapper race = getRaceWrapper( Meeting_20150813_M1.build(), 7 );

        testBet( race, 6.20d, BetType.SIMPLE_GAGNANT, 2d, 2 );
        testBet( race, 6.20d, BetType.SIMPLE_GAGNANT, 2d, 3 );

        testBet( race, 0.00d, BetType.SIMPLE_PLACE, 2d, 3 );

    }

}
