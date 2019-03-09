package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.Iterator;

public interface HorseID {

    /**
     * @return the name
     */
    String getName();

    /**
     * @return l'historique
     */
    Iterator<Horse> getHistory();

    /**
     * @return le père
     */
    HorseID getFather();

    /**
     * @return la mère
     */
    HorseID getMother();

    /**
     * @return la date de naissance
     */
    Date getBirth();

    /**
     * @return the sex
     */
    Sex getSex();

    /**
     * @return la date de la première course castré
     */
    Date getGeldingDate();

    /**
     * @return the breed
     */
    Breed getBreed();

    /**
     * @return the coat
     */
    Coat getCoat();

}
