package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.Iterator;

public interface Horse extends HorseID, Comparable<Horse> {

    /**
     * @return the race
     */
    Race getRace();

    /**
     * @return the age
     */
    Integer getAge();

    /**
     * @return the number
     */
    int getNumber();

    /**
     * @return if runner
     */
    boolean isRunner();

    /**
     * @return the supplemented
     */
    boolean isSupplemented();

    /**
     * @return the pregnant
     */
    boolean isPregnant();

    /**
     * @return the stall
     */
    int getStall();

    /**
     * @return the stable
     */
    String getStable();

    /**
     * @return the weight
     */
    Double getWeight();

    /**
     * @return the distance
     */
    double getDistance();

    /**
     * @return the careerProfit
     */
    Double getCareerProfit();

    /**
     * @return the previousYearProfit
     */
    Double getPreviousYearProfit();

    /**
     * @return the victoryProfit
     */
    Double getVictoryProfit();

    /**
     * @return the yearProfit
     */
    Double getYearProfit();

    /**
     * @return the horseshoe
     */
    Horseshoe getHorseshoe();

    /**
     * @return the blinder
     */
    Blinder getBlinder();

    /**
     * @return the trainer
     */
    String getTrainer();

    /**
     * @return l'historique de l'entraineur
     */
    Iterator<Horse> getTrainerHistory();

    /**
     * @return the owner
     */
    String getOwner();

    /**
     * @return l'historique du propriétaire
     */
    Iterator<Horse> getOwnerHistory();

    /**
     * @return the rancher
     */
    String getRancher();

    /**
     * @return l'historique de l'éleveur
     */
    Iterator<Horse> getRancherHistory();

    /**
     * @return the jockey
     */
    String getJockey();

    /**
     * @return l'historique du jockey
     */
    Iterator<Horse> getJockeyHistory();

    /**
     * @return la cote courante
     */
    Double getOdds();

    /**
     * @return la cote enregistrée à la date donnée
     */
    @MainRaceInaccessibleField
    Double getOdds(Date date);

    /**
     * @return la cote enregistrée après la course
     */
    @MainRaceInaccessibleField
    Double getFinishOdds();

    /**
     * @return la cote courante (écurie)
     */
    Double getStableOdds();

    /**
     * @return la cote (écurie) enregistrée à la date donnée
     */
    @MainRaceInaccessibleField
    Double getStableOdds(Date date);

    /**
     * @return la cote (écurie) enregistrée après la course
     */
    @MainRaceInaccessibleField
    Double getFinishStableOdds();

    /**
     * @return la position à l'arrivée, null si non présent
     */
    @MainRaceInaccessibleField
    Integer getFinishPosition();

    /**
     * @return le temps de parcours. valable uniquement pour le trot.
     */
    @MainRaceInaccessibleField
    Integer getFinishDuration();

    /**
     * @return true si arrêté
     */
    @MainRaceInaccessibleField
    boolean isStopped();

    /**
     * @return true si disqualifié
     */
    @MainRaceInaccessibleField
    boolean isDisqualified();

    /**
     * @return true si tombé
     */
    @MainRaceInaccessibleField
    boolean isFallen();

}
