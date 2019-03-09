package com.windwagon.broceliande.race.entities;

import android.annotation.*;

import com.windwagon.logres.date.*;
import com.windwagon.logres.getset.*;

import java.util.*;

import javax.persistence.*;

@Entity
@Table( name = "ww_horse" )
@SuppressLint("NewApi")
public class Horse implements Comparable<Horse> {

    public static final Comparator<Horse> COMPARATOR =
            Comparator.comparing( Horse::getRace ).thenComparing( Horse::getNumber );

    @Id
    @SequenceGenerator( name = "sequence_id", sequenceName = "ww_sequence_id" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sequence_id" )
    private Long id;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "race" )
    private Race race;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "horse_id" )
    private HorseID horseID;

    private Integer number;

    private Boolean runner;

    private Boolean supplemented;

    private Boolean pregnant;

    private Integer stall;

    @Column( length = 3 )
    private String stable;

    private Double weight;

    private Double distance;

    private Double careerProfit;

    private Double previousYearProfit;

    private Double victoryProfit;

    private Double placeProfit;

    private Double yearProfit;

    @Column( length = 15 )
    @Enumerated( EnumType.STRING )
    private Horseshoe horseshoe;

    @Column( length = 15 )
    @Enumerated( EnumType.STRING )
    private Blinder blinder;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "trainer" )
    private Trainer trainer;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "owner" )
    private Owner owner;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "rancher" )
    private Rancher rancher;

    @ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "jockey" )
    private Jockey jockey;

    @Override
    public String toString() {

        String id = Getter.get( Horse::getId ).str( this );

        Race race = Getter.get( Horse::getRace ).get( this );
        Meeting meeting = Getter.get( Race::getMeeting ).get( race );

        String date = Getter.get( Meeting::getDate ).then( LazyDate::D ).str( meeting );
        String mNum = Getter.get( Meeting::getNumber ).str( meeting );
        String rNum = Getter.get( Race::getNumber ).str( race );
        String hNum = Getter.get( Horse::getNumber ).str( this );

        return "horse #" + id + " " + date + "-" + mNum + "-" + rNum + "-" + hNum;

    }

    @Override
    public int compareTo( Horse horse ) {
        return COMPARATOR.compare( this, horse );
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
     * @return the horseID
     */
    public HorseID getHorseID() {
        return horseID;
    }

    /**
     * @param horseID the horseID to set
     */
    public void setHorseID( HorseID horseID ) {
        this.horseID = horseID;
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
     * @return the runner
     */
    public Boolean getRunner() {
        return runner;
    }

    /**
     * @param runner the runner to set
     */
    public void setRunner( Boolean runner ) {
        this.runner = runner;
    }

    /**
     * @return the supplemented
     */
    public Boolean getSupplemented() {
        return supplemented;
    }

    /**
     * @param supplemented the supplemented to set
     */
    public void setSupplemented( Boolean supplemented ) {
        this.supplemented = supplemented;
    }

    /**
     * @return the pregnant
     */
    public Boolean getPregnant() {
        return pregnant;
    }

    /**
     * @param pregnant the pregnant to set
     */
    public void setPregnant( Boolean pregnant ) {
        this.pregnant = pregnant;
    }

    /**
     * @return the stall
     */
    public Integer getStall() {
        return stall;
    }

    /**
     * @param stall the stall to set
     */
    public void setStall( Integer stall ) {
        this.stall = stall;
    }

    /**
     * @return the stable
     */
    public String getStable() {
        return stable;
    }

    /**
     * @param stable the stable to set
     */
    public void setStable( String stable ) {
        this.stable = stable;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight( Double weight ) {
        this.weight = weight;
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
     * @return the careerProfit
     */
    public Double getCareerProfit() {
        return careerProfit;
    }

    /**
     * @param careerProfit the careerProfit to set
     */
    public void setCareerProfit( Double careerProfit ) {
        this.careerProfit = careerProfit;
    }

    /**
     * @return the previousYearProfit
     */
    public Double getPreviousYearProfit() {
        return previousYearProfit;
    }

    /**
     * @param previousYearProfit the previousYearProfit to set
     */
    public void setPreviousYearProfit( Double previousYearProfit ) {
        this.previousYearProfit = previousYearProfit;
    }

    /**
     * @return the victoryProfit
     */
    public Double getVictoryProfit() {
        return victoryProfit;
    }

    /**
     * @param victoryProfit the victoryProfit to set
     */
    public void setVictoryProfit( Double victoryProfit ) {
        this.victoryProfit = victoryProfit;
    }

    /**
     * @return the placeProfit
     */
    public Double getPlaceProfit() {
        return placeProfit;
    }

    /**
     * @param placeProfit the placeProfit to set
     */
    public void setPlaceProfit( Double placeProfit ) {
        this.placeProfit = placeProfit;
    }

    /**
     * @return the yearProfit
     */
    public Double getYearProfit() {
        return yearProfit;
    }

    /**
     * @param yearProfit the yearProfit to set
     */
    public void setYearProfit( Double yearProfit ) {
        this.yearProfit = yearProfit;
    }

    /**
     * @return the horseshoe
     */
    public Horseshoe getHorseshoe() {
        return horseshoe;
    }

    /**
     * @param horseshoe the horseshoe to set
     */
    public void setHorseshoe( Horseshoe horseshoe ) {
        this.horseshoe = horseshoe;
    }

    /**
     * @return the blinder
     */
    public Blinder getBlinder() {
        return blinder;
    }

    /**
     * @param blinder the blinder to set
     */
    public void setBlinder( Blinder blinder ) {
        this.blinder = blinder;
    }

    /**
     * @return the trainer
     */
    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * @param trainer the trainer to set
     */
    public void setTrainer( Trainer trainer ) {
        this.trainer = trainer;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner( Owner owner ) {
        this.owner = owner;
    }

    /**
     * @return the rancher
     */
    public Rancher getRancher() {
        return rancher;
    }

    /**
     * @param rancher the rancher to set
     */
    public void setRancher( Rancher rancher ) {
        this.rancher = rancher;
    }

    /**
     * @return the jockey
     */
    public Jockey getJockey() {
        return jockey;
    }

    /**
     * @param jockey the jockey to set
     */
    public void setJockey( Jockey jockey ) {
        this.jockey = jockey;
    }

}
