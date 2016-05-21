package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.Iterator;

public interface Horse extends HorseID, Comparable<Horse> {

    /**
     * @return the race
     */
    public Race getRace();

    /**
     * @return the age
     */
    public Integer getAge();

    /**
     * @return the number
     */
    public int getNumber();

    /**
     * @return if runner
     */
    public boolean isRunner();

    /**
     * @return the supplemented
     */
    public boolean isSupplemented();

    /**
     * @return the pregnant
     */
    public boolean isPregnant();

    /**
     * @return the stall
     */
    public int getStall();

    /**
     * @return the stable
     */
    public String getStable();

    /**
     * @return the weight
     */
    public Double getWeight();

    /**
     * @return the distance
     */
    public double getDistance();

    /**
     * @return the careerProfit
     */
    public Double getCareerProfit();

    /**
     * @return the previousYearProfit
     */
    public Double getPreviousYearProfit();

    /**
     * @return the victoryProfit
     */
    public Double getVictoryProfit();

    /**
     * @return the yearProfit
     */
    public Double getYearProfit();

    /**
     * @return the horseshoe
     */
    public Horseshoe getHorseshoe();

    /**
     * @return the blinder
     */
    public Blinder getBlinder();

    /**
     * @return the trainer
     */
    public String getTrainer();

    /**
     * @return l'historique de l'entraineur
     */
    public Iterator<Horse> getTrainerHistory();

    /**
     * @return the owner
     */
    public String getOwner();

    /**
     * @return l'historique du propriétaire
     */
    public Iterator<Horse> getOwnerHistory();

    /**
     * @return the rancher
     */
    public String getRancher();

    /**
     * @return l'historique de l'éleveur
     */
    public Iterator<Horse> getRancherHistory();

    /**
     * @return the jockey
     */
    public String getJockey();

    /**
     * @return l'historique du jockey
     */
    public Iterator<Horse> getJockeyHistory();

    /**
     * @return la cote courante
     */
    public Double getOdds();

    /**
     * @return la cote enregistrée à la date donnée
     */
    @MainRaceInaccessibleField
    public Double getOdds( Date date );

    /**
     * @return la cote enregistrée après la course
     */
    @MainRaceInaccessibleField
    public Double getFinishOdds();

    /**
     * @return la cote courante (écurie)
     */
    public Double getStableOdds();

    /**
     * @return la cote (écurie) enregistrée à la date donnée
     */
    @MainRaceInaccessibleField
    public Double getStableOdds( Date date );

    /**
     * @return la cote (écurie) enregistrée après la course
     */
    @MainRaceInaccessibleField
    public Double getFinishStableOdds();

    /**
     * @return la position à l'arrivée, null si non présent
     */
    @MainRaceInaccessibleField
    public Integer getFinishPosition();

    /**
     * @return le temps de parcours. valable uniquement pour le trot.
     */
    @MainRaceInaccessibleField
    public Integer getFinishDuration();

    /**
     * @return true si arrêté
     */
    @MainRaceInaccessibleField
    public boolean isStopped();

    /**
     * @return true si disqualifié
     */
    @MainRaceInaccessibleField
    public boolean isDisqualified();

    /**
     * @return true si tombé
     */
    @MainRaceInaccessibleField
    public boolean isFallen();

}
