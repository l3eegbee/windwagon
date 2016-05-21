package com.windwagon.broceliande.race.entities;

import java.util.Comparator;

import javax.persistence.CascadeType;
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
@Table( name = "ww_place" )
public class Place implements Comparable<Place> {

    public static final Comparator<Place> COMPARATOR =
            Comparator.comparing( Place::getRace ).thenComparing( Place::getNumber ).thenComparing(
                    Place::getHorse );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "race" )
    private Race race;

    private Integer number;

    private String distance;

    private Integer duration;

    private Integer horse;

    @Override
    public String toString() {

        String id = Getter.get( Place::getId ).str( this );

        Race race = Getter.get( Place::getRace ).safe( this );
        Meeting meeting = Getter.get( Race::getMeeting ).safe( race );

        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( meeting );
        String mNum = Getter.get( Meeting::getNumber ).str( meeting );
        String rNum = Getter.get( Race::getNumber ).str( race );
        String pNum = Getter.get( Place::getNumber ).str( this );
        String hNum = Getter.get( Place::getHorse ).str( this );

        return "place #"
                + id
                + " "
                + date
                + "-"
                + mNum
                + "-"
                + rNum
                + "-"
                + pNum
                + " ("
                + hNum
                + ")";

    }

    @Override
    public int compareTo( Place place ) {
        return COMPARATOR.compare( this, place );
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
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber( Integer number ) {
        this.number = number;
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance( String distance ) {
        this.distance = distance;
    }

    /**
     * @return the time
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param time the time to set
     */
    public void setDuration( Integer duration ) {
        this.duration = duration;
    }

    /**
     * @return the horse
     */
    public Integer getHorse() {
        return horse;
    }

    /**
     * @param horse the horse to set
     */
    public void setHorse( Integer horse ) {
        this.horse = horse;
    }

}
