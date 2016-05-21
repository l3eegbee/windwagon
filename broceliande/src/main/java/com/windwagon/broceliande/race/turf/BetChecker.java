package com.windwagon.broceliande.race.turf;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import org.springframework.stereotype.Component;

import com.windwagon.kaamelott.race.BetType;
import com.windwagon.kaamelott.race.Finish;
import com.windwagon.kaamelott.race.Horse;
import com.windwagon.kaamelott.race.Price;
import com.windwagon.kaamelott.race.PriceName;
import com.windwagon.kaamelott.words.Bet;
import com.windwagon.kaamelott.words.InvalidBet;

@Component
public class BetChecker {

    static public final double DOUBLE_TOLERANCE = 1e-8d;

    static private double reminder( double q, double d ) {
        return q - Math.floor( q / d ) * d;
    }

    private class CleanBet {

        private BetType betType;

        public void setBetType( BetType betType ) {
            this.betType = betType;
        }

        public BetType getBetType() {
            return this.betType;
        }

        private List<Horse> ticket;

        public void setTicket( List<Horse> ticket ) {
            this.ticket = ticket;
        }

        public List<Horse> getTicket() {
            return this.ticket;
        }

        private double stake;

        public void setStake( double stake ) {
            this.stake = stake;
        }

        public double getStake() {
            return this.stake;
        }

    }

    private CleanBet clean( Bet bet, RaceWrapper race, boolean checkNotRunner ) throws InvalidBet {

        if( bet == null )
            throw new InvalidBet( "Bet null" );

        // betType

        BetType betType = bet.getBetType();
        if( betType == null )
            throw new InvalidBet( "BetType null" );

        Set<BetType> raceBetTypes = race.getBets();
        if( raceBetTypes == null || !raceBetTypes.contains( betType ) )
            throw new InvalidBet( "Indisponible betType: " + betType );

        // horses

        List<Horse> betTicket = bet.getTicket( race );
        if( betTicket == null )
            throw new InvalidBet( "Bet without horses" );

        int ticketLength = betType.getTicketLength();
        if( betTicket.size() != ticketLength )
            throw new InvalidBet( "Invalid horse number (expected: "
                    + ticketLength
                    + ", actual: "
                    + betTicket.size()
                    + ")" );

        Set<Horse> raceHorses = race.getHorses();
        Set<Horse> copyRaceHorses = new HashSet<Horse>( raceHorses );
        for( Horse h : betTicket )
            if( h == null )
                throw new InvalidBet( "Null horse" );
            else if( checkNotRunner && !h.isRunner() )
                throw new InvalidBet( "Not runner horse: " + h );
            else if( !raceHorses.contains( h ) )
                throw new InvalidBet( "Invalid horse: " + h );
            else if( !copyRaceHorses.contains( h ) )
                throw new InvalidBet( "Horse betted twice: " + h );
            else
                copyRaceHorses.remove( h );

        // stake

        double base = betType.getBase();

        double stake = bet.getStake();
        if( Double.compare( stake, Double.NaN ) == 0 )
            stake = base;

        if( base - stake > DOUBLE_TOLERANCE )
            throw new InvalidBet( "Not enought stake (base: " + base + ", stake: " + stake + ")" );

        if( reminder( stake, 1 ) > DOUBLE_TOLERANCE && reminder( stake, base ) > DOUBLE_TOLERANCE )
            throw new InvalidBet( "Stake not acceptable (base: " + base + ", stake: " + stake + ")" );

        // create clean bet

        CleanBet cleanBet = new CleanBet();
        cleanBet.setBetType( betType );
        cleanBet.setTicket( betTicket );
        cleanBet.setStake( stake );

        return cleanBet;

    }

    public boolean isValid( Bet bet, RaceWrapper race ) {

        try {
            clean( bet, race, true );
        } catch( InvalidBet ex ) {
            return false;
        }

        return true;

    }

    private class PriceBean implements Price {

        private BetType bet;

        public void setBet( BetType bet ) {
            this.bet = bet;
        }

        @Override
        public BetType getBetType() {
            return this.bet;
        }

        private PriceName priceName;

        public void setPriceName( PriceName priceName ) {
            this.priceName = priceName;
        }

        @Override
        public PriceName getPriceName() {
            return this.priceName;
        }

        private Double price;

        public void setPrice( Double price ) {
            this.price = price;
        }

        @Override
        public Double getPrice() {
            return price;
        }

        private SortedSet<Horse> ticket;

        public void setTicket( SortedSet<Horse> ticket ) {
            this.ticket = ticket;
        }

        public SortedSet<Horse> getTicket() {
            return this.ticket;
        }

    }

    private class OrderComparator < T > implements Comparator<T> {

        private Map<T, Integer> order = new HashMap<T, Integer>();

        public OrderComparator( Collection<T> c ) {
            int i = 0;
            for( T o : c )
                order.put( o, i++ );
        }

        @Override
        public int compare( T o1, T o2 ) {
            int i1 = order.containsKey( o1 ) ? order.get( o1 ) : order.size();
            int i2 = order.containsKey( o2 ) ? order.get( o2 ) : order.size();
            return Integer.compare( i1, i2 );
        }

    }

    private Price createPrice(
            RaceWrapper race,
            BetType betType,
            PriceName priceName,
            Double priceValue,
            List<Horse> ticket ) {

        PriceBean price = new PriceBean();

        price.setBet( betType );
        price.setPriceName( priceName );
        price.setPrice( priceValue );

        SortedSet<Horse> sortedTicket = new TreeSet<Horse>( new OrderComparator<Horse>( ticket ) );
        sortedTicket.addAll( ticket );
        price.setTicket( sortedTicket );

        return price;

    }

    private List<Price> createRembPrice( RaceWrapper race, BetType betType, List<Horse> ticket ) {
        return Arrays.asList( createPrice( race, betType, PriceName.REMBOURSEMENT, 1d, ticket ) );
    }

    private int order( Collection<Horse> finish, Collection<Horse> ticket ) {

        Iterator<Horse> finishIterator = finish.iterator();
        Iterator<Horse> ticketIterator = ticket.iterator();

        int i = 0;

        while( finishIterator.hasNext()
                && ticketIterator.hasNext()
                && finishIterator.next().equals( ticketIterator.next() ) )
            i++;

        return i;

    }

    private int unorder( Collection<Horse> finish, Collection<Horse> ticket ) {

        int i = 0;
        for( Horse h : finish )
            if( ticket.contains( h ) )
                i++;

        return i;

    }

    private Price searchPrice(
            RaceWrapper race,
            BetType betType,
            PriceName priceName,
            List<Horse> ticket,
            boolean order ) {

        Set<Price> prices = race.getPrices();
        if( prices == null )
            return null;

        int length = ticket.size();

        for( Price price : prices )
            if( betType.equals( price.getBetType() ) && priceName.equals( price.getPriceName() ) ) {
                SortedSet<Horse> priceTicket = price.getTicket();
                boolean sizeCheck = priceTicket.size() == length;
                boolean orderCheck = order && order( priceTicket, ticket ) == length;
                boolean unorderCheck = !order && unorder( priceTicket, ticket ) == length;
                if( sizeCheck && ( orderCheck || unorderCheck ) )
                    return price;
            }

        return null;

    }

    private List<Price> searchPrice_SIMPLE_GAGNANT(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 1 )
            return createRembPrice( race, BetType.SIMPLE_GAGNANT, ticket );

        Price price = searchPrice( race, BetType.SIMPLE_GAGNANT, PriceName.DIRECT, ticket, true );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_SIMPLE_PLACE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 1 )
            return createRembPrice( race, BetType.SIMPLE_PLACE, ticket );

        Price price = searchPrice( race, BetType.SIMPLE_PLACE, PriceName.DIRECT, ticket, true );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_COUPLE_ORDRE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 2 )
            return createRembPrice( race, BetType.COUPLE_ORDRE, ticket );

        Price price = searchPrice( race, BetType.COUPLE_ORDRE, PriceName.DIRECT, fTicket, true );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_COUPLE_GAGNANT(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 2 )
            return createRembPrice( race, BetType.COUPLE_GAGNANT, ticket );

        Price price = searchPrice( race, BetType.COUPLE_GAGNANT, PriceName.DIRECT, fTicket, false );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_COUPLE_PLACE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 2 )
            return createRembPrice( race, BetType.COUPLE_PLACE, ticket );

        Price price = searchPrice( race, BetType.COUPLE_PLACE, PriceName.DIRECT, fTicket, false );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_TRIO_ORDRE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 3 )
            return createRembPrice( race, BetType.TRIO_ORDRE, ticket );

        Price price = searchPrice( race, BetType.TRIO_ORDRE, PriceName.DIRECT, fTicket, true );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_TRIO(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 3 )
            return createRembPrice( race, BetType.TRIO, ticket );

        Price price = searchPrice( race, BetType.TRIO, PriceName.DIRECT, fTicket, false );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_DEUX_SUR_QUATRE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 2 )
            return createRembPrice( race, BetType.DEUX_SUR_QUATRE, ticket );

        Price price = searchPrice( race, BetType.DEUX_SUR_QUATRE, PriceName.DIRECT, fTicket, false );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_MULTI_EN_QUATRE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 1 )
            return createRembPrice( race, BetType.MULTI_EN_QUATRE, ticket );

        finish = finish.subList( 0, 4 );
        if( unorder( finish, ticket ) == 4 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.MULTI_EN_QUATRE,
                    PriceName.DIRECT,
                    finish,
                    false ) );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_MULTI_EN_CINQ(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 2 )
            return createRembPrice( race, BetType.MULTI_EN_CINQ, ticket );

        if( nbNotRunner == 1 )
            return searchPrice_MULTI_EN_QUATRE( race, finish, fTicket, fTicket );

        finish = finish.subList( 0, 4 );
        if( unorder( finish, ticket ) == 4 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.MULTI_EN_CINQ,
                    PriceName.DIRECT,
                    finish,
                    false ) );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_MULTI_EN_SIX(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 3 )
            return createRembPrice( race, BetType.MULTI_EN_SIX, ticket );

        if( nbNotRunner == 2 )
            return searchPrice_MULTI_EN_QUATRE( race, finish, fTicket, fTicket );

        if( nbNotRunner == 1 )
            return searchPrice_MULTI_EN_CINQ( race, finish, fTicket, fTicket );

        finish = finish.subList( 0, 4 );
        if( unorder( finish, ticket ) == 4 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.MULTI_EN_SIX,
                    PriceName.DIRECT,
                    finish,
                    false ) );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_MULTI_EN_SEPT(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 4 )
            return createRembPrice( race, BetType.MULTI_EN_SEPT, ticket );

        if( nbNotRunner == 3 )
            return searchPrice_MULTI_EN_QUATRE( race, finish, fTicket, fTicket );

        if( nbNotRunner == 2 )
            return searchPrice_MULTI_EN_CINQ( race, finish, fTicket, fTicket );

        if( nbNotRunner == 1 )
            return searchPrice_MULTI_EN_SIX( race, finish, fTicket, fTicket );

        finish = finish.subList( 0, 4 );
        if( unorder( finish, ticket ) == 4 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.MULTI_EN_SEPT,
                    PriceName.DIRECT,
                    finish,
                    false ) );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_PICK5(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 2 )
            return createRembPrice( race, BetType.PICK5, ticket );

        Price price = searchPrice( race, BetType.PICK5, PriceName.DIRECT, fTicket, false );
        return price != null ? Arrays.asList( price ) : Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_TIERCE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner == 3 )
            return createRembPrice( race, BetType.TIERCE, ticket );

        Price price = searchPrice( race, BetType.TIERCE, PriceName.ORDRE, fTicket, true );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.TIERCE, PriceName.DIRECT, fTicket, false );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.TIERCE, PriceName.DEGRADE, fTicket, false );
        if( price != null )
            return Arrays.asList( price );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_QUARTE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 2 )
            return createRembPrice( race, BetType.QUARTE, ticket );

        if( nbNotRunner == 1 ) {
            finish = finish.subList( 0, 3 );
            if( unorder( finish, fTicket ) == 3 ) {
                Price bonus =
                        searchPrice( race, BetType.QUARTE, PriceName.BONUS_TROIS, finish, true );
                return Arrays.asList( bonus, bonus );
            }
            return Collections.<Price>emptyList();
        }

        Price price = searchPrice( race, BetType.QUARTE, PriceName.ORDRE, ticket, true );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.QUARTE, PriceName.DIRECT, ticket, false );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.QUARTE, PriceName.DEGRADE, ticket, false );
        if( price != null )
            return Arrays.asList( price );

        finish = finish.subList( 0, 3 );
        if( unorder( finish, ticket ) == 3 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.QUARTE,
                    PriceName.BONUS_TROIS,
                    finish,
                    true ) );

        return Collections.<Price>emptyList();

    }

    private List<Price> searchPrice_QUINTE(
            RaceWrapper race,
            List<Horse> finish,
            List<Horse> ticket,
            List<Horse> fTicket ) {

        int nbNotRunner = ticket.size() - fTicket.size();

        if( nbNotRunner >= 3 )
            return createRembPrice( race, BetType.QUINTE, ticket );

        if( nbNotRunner == 2 ) {
            finish = finish.subList( 0, 3 );
            if( unorder( finish, fTicket ) == 3 ) {
                Price bonus =
                        searchPrice( race, BetType.QUINTE, PriceName.BONUS_TROIS, finish, true );
                return Arrays.asList( bonus, bonus, bonus, bonus );
            }
            return Collections.<Price>emptyList();
        }

        if( nbNotRunner == 1 ) {

            if( unorder( finish.subList( 0, 4 ), fTicket ) == 4 ) {
                Price bonus =
                        searchPrice(
                                race,
                                BetType.QUINTE,
                                PriceName.BONUS_QUATRE,
                                finish.subList( 0, 4 ),
                                true );
                return Arrays.asList( bonus, bonus, bonus, bonus );
            }

            if( unorder( finish.subList( 0, 5 ), fTicket ) == 4 ) {
                Price bonus =
                        searchPrice(
                                race,
                                BetType.QUINTE,
                                PriceName.BONUS_QUATRE_SUR_CINQ,
                                fTicket,
                                false );
                return Arrays.asList( bonus, bonus, bonus, bonus );
            }

            if( unorder( finish.subList( 0, 3 ), fTicket ) == 3 ) {
                Price bonus =
                        searchPrice(
                                race,
                                BetType.QUINTE,
                                PriceName.BONUS_TROIS,
                                finish.subList( 0, 3 ),
                                true );
                return Arrays.asList( bonus, bonus );
            }

            return Collections.<Price>emptyList();

        }

        Price price = searchPrice( race, BetType.QUINTE, PriceName.ORDRE, ticket, true );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.QUINTE, PriceName.DIRECT, ticket, false );
        if( price != null )
            return Arrays.asList( price );

        price = searchPrice( race, BetType.QUINTE, PriceName.DEGRADE, ticket, false );
        if( price != null )
            return Arrays.asList( price );

        if( unorder( finish.subList( 0, 4 ), ticket ) == 4 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.QUINTE,
                    PriceName.BONUS_QUATRE,
                    finish.subList( 0, 4 ),
                    true ) );

        if( unorder( finish.subList( 0, 5 ), ticket ) == 4 ) {
            finish = finish.subList( 0, 5 );
            List<Horse> inter = new Vector<Horse>();
            for( Horse h : ticket )
                if( finish.contains( h ) )
                    inter.add( h );
            return Arrays.asList( searchPrice(
                    race,
                    BetType.QUINTE,
                    PriceName.BONUS_QUATRE_SUR_CINQ,
                    inter,
                    false ) );

        }

        if( unorder( finish.subList( 0, 3 ), ticket ) == 3 )
            return Arrays.asList( searchPrice(
                    race,
                    BetType.QUINTE,
                    PriceName.BONUS_TROIS,
                    finish.subList( 0, 3 ),
                    true ) );

        return Collections.<Price>emptyList();

    }

    public List<Price> getPrice( Bet knightbet, RaceWrapper race ) throws InvalidBet {

        List<Horse> finish = new Vector<Horse>();
        for( Finish f : race.getFinish() )
            finish.add( f.getHorse() );

        CleanBet bet = clean( knightbet, race, false );
        List<Horse> ticket = bet.getTicket();
        List<Horse> fTicket = new Vector<Horse>();
        for( Horse horse : ticket )
            if( horse.isRunner() )
                fTicket.add( horse );

        switch( bet.getBetType() ) {

            case SIMPLE_GAGNANT :
                return searchPrice_SIMPLE_GAGNANT( race, finish, ticket, fTicket );
            case SIMPLE_PLACE :
                return searchPrice_SIMPLE_PLACE( race, finish, ticket, fTicket );

            case COUPLE_ORDRE :
                return searchPrice_COUPLE_ORDRE( race, finish, ticket, fTicket );
            case COUPLE_GAGNANT :
                return searchPrice_COUPLE_GAGNANT( race, finish, ticket, fTicket );
            case COUPLE_PLACE :
                return searchPrice_COUPLE_PLACE( race, finish, ticket, fTicket );

            case TRIO_ORDRE :
                return searchPrice_TRIO_ORDRE( race, finish, ticket, fTicket );
            case TRIO :
                return searchPrice_TRIO( race, finish, ticket, fTicket );

            case DEUX_SUR_QUATRE :
                return searchPrice_DEUX_SUR_QUATRE( race, finish, ticket, fTicket );

            case MULTI_EN_QUATRE :
                return searchPrice_MULTI_EN_QUATRE( race, finish, ticket, fTicket );
            case MULTI_EN_CINQ :
                return searchPrice_MULTI_EN_CINQ( race, finish, ticket, fTicket );
            case MULTI_EN_SIX :
                return searchPrice_MULTI_EN_SIX( race, finish, ticket, fTicket );
            case MULTI_EN_SEPT :
                return searchPrice_MULTI_EN_SEPT( race, finish, ticket, fTicket );

            case PICK5 :
                return searchPrice_PICK5( race, finish, ticket, fTicket );

            case TIERCE :
                return searchPrice_TIERCE( race, finish, ticket, fTicket );
            case QUARTE :
                return searchPrice_QUARTE( race, finish, ticket, fTicket );
            case QUINTE :
                return searchPrice_QUINTE( race, finish, ticket, fTicket );

        }

        return Collections.emptyList();

    }

    public double getBalance( Bet bet, RaceWrapper race ) throws InvalidBet {

        List<Price> prices = getPrice( bet, race );

        if( ( prices.size() == 1 )
                && prices.get( 0 ).getPriceName().equals( PriceName.REMBOURSEMENT ) )
            return 0d;

        CleanBet cleanBet = clean( bet, race, false );
        double balance = -cleanBet.getStake();

        for( Price price : prices ) {
            Double priceValue = price.getPrice();
            balance += cleanBet.getStake() * ( priceValue == null ? 1 : priceValue );
        }

        return balance;

    }

}
