package com.windwagon.broceliande.race.entities;

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.windwagon.logres.date.LazyDate;
import com.windwagon.logres.getset.Getter;

@Entity
@Table( name = "ww_simple" )
public class Simple implements Comparable<Simple> {

    public static final Comparator<Simple> COMPARATOR =
            Comparator.comparing( Simple::getOdds ).thenComparing( s -> {
                try {
                    return Integer.parseInt( s.getNumber() );
                } catch( NumberFormatException ex ) {}
                return Integer.MAX_VALUE;
            } ).thenComparing( Simple::getNumber );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "odds" )
    private Odds odds;

    @Column( length = 3 )
    private String number;

    private Double simple;

    @Override
    public String toString() {

        String id = Getter.get( Simple::getId ).str( this );

        Odds odds = Getter.get( Simple::getOdds ).safe( this );
        Race race = Getter.get( Odds::getRace ).safe( odds );
        Meeting meeting = Getter.get( Race::getMeeting ).safe( race );

        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( meeting );
        String mNum = Getter.get( Meeting::getNumber ).str( meeting );
        String rNum = Getter.get( Race::getNumber ).str( race );
        String oDate = Getter.get( Odds::getDate ).then( LazyDate::M ).str( odds );
        String sNum = Getter.get( Simple::getNumber ).str( this );

        return "simple #" + id + " " + date + "-" + mNum + "-" + rNum + "-" + oDate + "-" + sNum;

    }

    @Override
    public int compareTo( Simple simple ) {
        return COMPARATOR.compare( this, simple );
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
     * @return the odds
     */
    public Odds getOdds() {
        return odds;
    }

    /**
     * @param odds the odds to set
     */
    public void setOdds( Odds odds ) {
        this.odds = odds;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber( String number ) {
        this.number = number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber( Integer number ) {
        this.number = Integer.toString( number );
    }

    /**
     * @return the simple
     */
    public Double getSimple() {
        return simple;
    }

    /**
     * @param simple the simple to set
     */
    public void setSimple( Double simple ) {
        this.simple = simple;
    }

}
