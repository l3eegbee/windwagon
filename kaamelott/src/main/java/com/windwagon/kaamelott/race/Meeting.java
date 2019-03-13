package com.windwagon.kaamelott.race;

import java.util.Date;
import java.util.SortedSet;

public interface Meeting extends Comparable<Meeting> {

	/**
	 * @return the date
	 */
	Date getDate();

	/**
	 * @return the racecourse
	 */
	String getRacecourse();

	/**
	 * @return the country
	 */
	String getCountry();

	/**
	 * @return the number
	 */
	int getNumber();

	/**
	 * @return the windSpeed
	 */
	Double getWindSpeed();

	/**
	 * @return the windDirection
	 */
	WindDirection getWindDirection();

	/**
	 * @return the temperature
	 */
	Double getTemperature();

	/**
	 * @return the climat
	 */
	String getClimat();

	/**
	 * @return the field
	 */
	Field getField();

	/**
	 * @return the races
	 */
	SortedSet<Race> getRaces();

}
