package com.windwagon.broceliande.race.entities;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.windwagon.logres.getset.Getter;

@Entity
@Table( name = "ww_racecourse" )
public class Racecourse implements Comparable<Racecourse> {

    public final static String DEFAULT_COUNTRY = "FRANCE";

    public static final Comparator<Racecourse> COMPARATOR =
            Comparator.comparing( Racecourse::getName ).thenComparing( Racecourse::getCountry );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @Column( length = 50 )
    private String name;

    @Column( length = 30 )
    private String country;

    @Override
    public String toString() {

        String id = Getter.get( Racecourse::getId ).str( this );
        String name = Getter.get( Racecourse::getName ).str( this );
        String country = Getter.get( Racecourse::getCountry ).str( this );

        return "racecourse #" + id + " [" + name + "(" + country + ")]";

    }

    @Override
    public int compareTo( Racecourse racecourse ) {
        return COMPARATOR.compare( this, racecourse );
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry( String country ) {
        this.country = country;
    }

}
