package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.SortedSet;

public interface Meeting extends Comparable<Meeting> {

    /**
     * @return the date
     */
    public Date getDate();

    /**
     * @return the racecourse
     */
    public String getRacecourse();

    /**
     * @return the country
     */
    public String getCountry();

    /**
     * @return the number
     */
    public int getNumber();

    /**
     * @return the windSpeed
     */
    public Double getWindSpeed();

    /**
     * @return the windDirection
     */
    public WindDirection getWindDirection();

    /**
     * @return the temperature
     */
    public Double getTemperature();

    /**
     * @return the climat
     */
    public String getClimat();

    /**
     * @return the field
     */
    public Field getField();

    /**
     * @return the races
     */
    public SortedSet<Race> getRaces();

}
