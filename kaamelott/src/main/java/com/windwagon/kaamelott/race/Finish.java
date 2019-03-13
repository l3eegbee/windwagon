package com.windwagon.kaamelott.race;

public interface Finish extends Comparable<Finish> {

	/**
	 * @return the place number
	 */
	int getPlace();

	/**
	 * @return the distance
	 */
	String getDistance();

	/**
	 * @return the duration
	 */
	Integer getDuration();

	/**
	 * @return the horse
	 */
	Horse getHorse();

}
