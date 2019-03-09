package com.windwagon.broceliande.race.entities;

import android.annotation.*;

import com.windwagon.logres.date.*;
import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

@Entity
@Table( name = "ww_price" )
@SuppressLint("NewApi")
public class Price implements Comparable<Price> {

    public static final Comparator<Price> COMPARATOR =
            Comparator
                    .comparing( Price::getRace )
                    .thenComparing( Price::getBet )
                    .thenComparing( Price::getPriceName )
                    .thenComparing( Price::getTicket );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "race" )
    private Race race;

    @Column( length = 20 )
    @Enumerated( EnumType.STRING )
    private BetType bet;

    @Column( name = "pricename", length = 15 )
    @Enumerated( EnumType.STRING )
    private PriceName priceName;

    private Double price;

    // format: "\d+( \d+)*"
    private String ticket;

    @Override
    public String toString() {

        String id = Getter.get( Price::getId ).str( this );

        Race race = Getter.get( Price::getRace ).safe( this );
        Meeting meeting = Getter.get( Race::getMeeting ).safe( race );

        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( meeting );
        String mNum = Getter.get( Meeting::getNumber ).str( meeting );
        String rNum = Getter.get( Race::getNumber ).str( race );
        String pBet = Getter.get( Price::getBet ).str( this );
        String pPrice = Getter.get( Price::getPriceName ).str( this );
        String pTicket = Getter.get( Price::getTicket ).str( this );

        return "price #"
                + id
                + " "
                + date
                + "-"
                + mNum
                + "-"
                + rNum
                + "-"
                + pBet
                + "-"
                + pPrice
                + "-"
                + pTicket;

    }

    @Override
    public int compareTo( Price price ) {
        return COMPARATOR.compare( this, price );
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id ) {
        this.id = id;
    }

    /**
     * @return the race
     */
    public Race getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace( Race race ) {
        this.race = race;
    }

    /**
     * @return the bet
     */
    public BetType getBet() {
        return bet;
    }

    /**
     * @param bet the bet to set
     */
    public void setBet( BetType bet ) {
        this.bet = bet;
    }

    /**
     * @return the priceName
     */
    public PriceName getPriceName() {
        return priceName;
    }

    /**
     * @param priceName the priceName to set
     */
    public void setPriceName( PriceName priceName ) {
        this.priceName = priceName;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice( Double price ) {
        this.price = price;
    }

    /**
     * @return the ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket( String ticket ) {
        this.ticket = ticket;
    }

}
