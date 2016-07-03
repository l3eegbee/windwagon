package com.windwagon.broceliande.knights.entities;

import java.util.Comparator;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

import com.windwagon.broceliande.race.entities.Race;

@Entity
@Table( name = "ww_raceset" )
public class RaceSet implements Comparable<RaceSet> {

    public static final Comparator<RaceSet> COMPARATOR =
            Comparator.comparing( RaceSet::getName, Comparator.nullsFirst( String::compareTo ) );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinTable(
            name = "ww_raceset_races",
            joinColumns = @JoinColumn( name = "raceset" ),
            inverseJoinColumns = @JoinColumn( name = "race" ) )
    @ElementCollection( targetClass = Race.class )
    @SortNatural
    private SortedSet<Race> races;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "cycle" )
    private Cycle cycle;

    @Override
    public int compareTo( RaceSet raceSet ) {
        return COMPARATOR.compare( this, raceSet );
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription( String description ) {
        this.description = description;
    }

    /**
     * @return the races
     */
    public SortedSet<Race> getRaces() {
        return races;
    }

    /**
     * @param races the races to set
     */
    public void setRaces( SortedSet<Race> races ) {
        this.races = races;
    }

    /**
     * @return the cycle
     */
    public Cycle getCycle() {
        return cycle;
    }

    /**
     * @param cycle the cycle to set
     */
    public void setCycle( Cycle cycle ) {
        this.cycle = cycle;
    }

}
