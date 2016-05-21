package com.windwagon.broceliande.race.entities;

import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SortNatural;

import com.windwagon.logres.date.LazyDate;
import com.windwagon.logres.getset.Getter;

@Entity
@Table( name = "ww_meeting" )
public class Meeting implements Comparable<Meeting> {

    public static final Comparator<Meeting> COMPARATOR =
            Comparator.comparing( Meeting::getDate ).thenComparing( Meeting::getNumber );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @Temporal( TemporalType.DATE )
    private Date date;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "racecourse" )
    private Racecourse racecourse;

    private Integer number;

    private Double windSpeed;

    @Column( length = 10 )
    @Enumerated( EnumType.STRING )
    private WindDirection windDirection;

    private Double temperature;

    @Column( length = 30 )
    private String climat;

    @Column( length = 15 )
    @Enumerated( EnumType.STRING )
    private Field field;

    @OneToMany( mappedBy = "meeting", orphanRemoval = true, cascade = CascadeType.ALL )
    @SortNatural
    private SortedSet<Race> races;

    @Override
    public String toString() {

        String id = Getter.get( Meeting::getId ).str( this );
        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( this );
        String mNum = Getter.get( Meeting::getNumber ).str( this );

        return "meeting #" + id + " " + date + "-" + mNum;

    }

    @Override
    public int compareTo( Meeting meeting ) {
        return COMPARATOR.compare( this, meeting );
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate( Date date ) {
        this.date = date;
    }

    /**
     * @return the racecourse
     */
    public Racecourse getRacecourse() {
        return racecourse;
    }

    /**
     * @param racecourse the racecourse to set
     */
    public void setRacecourse( Racecourse racecourse ) {
        this.racecourse = racecourse;
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
     * @return the windSpeed
     */
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed( Double windSpeed ) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return the windDirection
     */
    public WindDirection getWindDirection() {
        return windDirection;
    }

    /**
     * @param windDirection the windDirection to set
     */
    public void setWindDirection( WindDirection windDirection ) {
        this.windDirection = windDirection;
    }

    /**
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature( Double temperature ) {
        this.temperature = temperature;
    }

    /**
     * @return the climat
     */
    public String getClimat() {
        return climat;
    }

    /**
     * @param climat the climat to set
     */
    public void setClimat( String climat ) {
        this.climat = climat;
    }

    /**
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField( Field field ) {
        this.field = field;
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

}
