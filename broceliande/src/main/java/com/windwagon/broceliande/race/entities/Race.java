package com.windwagon.broceliande.race.entities;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table( name = "ww_race" )
public class Race implements Comparable<Race> {

    public static final Comparator<Race> COMPARATOR =
            Comparator.comparing( Race::getMeeting ).thenComparing( Race::getNumber );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
    @JoinColumn( name = "meeting" )
    private Meeting meeting;

    private Integer number;

    @Column( length = 80 )
    private String name;

    @Column( length = 10 )
    @Enumerated( EnumType.STRING )
    private RaceStatus status;

    @Temporal( TemporalType.TIMESTAMP )
    private Date start;

    private Double distance;

    private Double benefit;

    @Column( length = 15 )
    @Enumerated( EnumType.STRING )
    private Discipline discipline;

    @ElementCollection( targetClass = Type.class )
    @CollectionTable( name = "ww_racetypes", joinColumns = @JoinColumn( name = "race" ) )
    @Column( length = 25 )
    @Enumerated( EnumType.STRING )
    private Set<Type> types;

    @OneToMany( mappedBy = "race", orphanRemoval = true, cascade = CascadeType.ALL )
    @SortNatural
    private SortedSet<Horse> horses;

    @ElementCollection( targetClass = BetType.class )
    @CollectionTable( name = "ww_racebets", joinColumns = @JoinColumn( name = "race" ) )
    @Column( length = 20 )
    @Enumerated( EnumType.STRING )
    private Set<BetType> bets;

    @OneToMany( mappedBy = "race", orphanRemoval = true, cascade = CascadeType.ALL )
    @SortNatural
    private SortedSet<Odds> odds;

    private Integer duration;

    @OneToMany( mappedBy = "race", orphanRemoval = true, cascade = CascadeType.ALL )
    @SortNatural
    private SortedSet<Place> places;

    // format: "(\d+ ?)*"
    private String stopped;

    // format: "(\d+ ?)*"
    private String disqualified;

    // format: "(\d+ ?)*"
    private String fallen;

    @OneToMany( mappedBy = "race", orphanRemoval = true, cascade = CascadeType.ALL )
    @SortNatural
    private SortedSet<Price> prices;

    @Override
    public String toString() {

        String id = Getter.get( Race::getId ).str( this );

        Meeting meeting = Getter.get( Race::getMeeting ).safe( this );

        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( meeting );
        String mNum = Getter.get( Meeting::getNumber ).str( meeting );
        String rNum = Getter.get( Race::getNumber ).str( this );

        return "race #" + id + " " + date + "-" + mNum + "-" + rNum;

    }

    @Override
    public int compareTo( Race race ) {
        return COMPARATOR.compare( this, race );
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
     * @return the meeting
     */
    public Meeting getMeeting() {
        return meeting;
    }

    /**
     * @param meeting the meeting to set
     */
    public void setMeeting( Meeting meeting ) {
        this.meeting = meeting;
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
     * @return the status
     */
    public RaceStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus( RaceStatus status ) {
        this.status = status;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart( Date start ) {
        this.start = start;
    }

    /**
     * @return the distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance( Double distance ) {
        this.distance = distance;
    }

    /**
     * @return the benefit
     */
    public Double getBenefit() {
        return benefit;
    }

    /**
     * @param benefit the benefit to set
     */
    public void setBenefit( Double benefit ) {
        this.benefit = benefit;
    }

    /**
     * @return the discipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * @param discipline the discipline to set
     */
    public void setDiscipline( Discipline discipline ) {
        this.discipline = discipline;
    }

    /**
     * @return the types
     */
    public Set<Type> getTypes() {
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes( Set<Type> types ) {
        this.types = types;
    }

    /**
     * @return the horses
     */
    public SortedSet<Horse> getHorses() {
        return horses;
    }

    /**
     * @param horses the horses to set
     */
    public void setHorses( SortedSet<Horse> horses ) {
        this.horses = horses;
    }

    /**
     * @return the bets
     */
    public Set<BetType> getBets() {
        return bets;
    }

    /**
     * @param bets the bets to set
     */
    public void setBets( Set<BetType> bets ) {
        this.bets = bets;
    }

    /**
     * @return the odds
     */
    public SortedSet<Odds> getOdds() {
        return odds;
    }

    /**
     * @param odds the odds to set
     */
    public void setOdds( SortedSet<Odds> odds ) {
        this.odds = odds;
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration( Integer duration ) {
        this.duration = duration;
    }

    /**
     * @return the places
     */
    public SortedSet<Place> getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces( SortedSet<Place> places ) {
        this.places = places;
    }

    /**
     * @return the stopped
     */
    public String getStopped() {
        return stopped;
    }

    /**
     * @param stopped the stopped to set
     */
    public void setStopped( String stopped ) {
        this.stopped = stopped;
    }

    /**
     * @return the disqualified
     */
    public String getDisqualified() {
        return disqualified;
    }

    /**
     * @param disqualified the disqualified to set
     */
    public void setDisqualified( String disqualified ) {
        this.disqualified = disqualified;
    }

    /**
     * @return the fallen
     */
    public String getFallen() {
        return fallen;
    }

    /**
     * @param fallen the fallen to set
     */
    public void setFallen( String fallen ) {
        this.fallen = fallen;
    }

    /**
     * @return the prices
     */
    public SortedSet<Price> getPrices() {
        return prices;
    }

    /**
     * @param prices the prices to set
     */
    public void setPrices( SortedSet<Price> prices ) {
        this.prices = prices;
    }

}
