package com.windwagon.kaamelott.race;

public interface Finish extends Comparable<Finish> {

    /**
     * @return the place number
     */
    public int getPlace();

    /**
     * @return the distance
     */
    public String getDistance();

    /**
     * @return the duration
     */
    public Integer getDuration();

    /**
     * @return the horse
     */
    public Horse getHorse();

}
