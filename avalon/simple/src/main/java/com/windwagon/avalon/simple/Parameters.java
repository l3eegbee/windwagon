package com.windwagon.avalon.simple;

import java.io.Serializable;

public class Parameters implements Serializable {

    private static final long serialVersionUID = 1l;

    private String simpleString;

    private int simpleInt;

    /**
     * @return the simpleString
     */
    public String getSimpleString() {
        return simpleString;
    }

    /**
     * @param simpleString the simpleString to set
     */
    public void setSimpleString( String simpleString ) {
        this.simpleString = simpleString;
    }

    /**
     * @return the simpleInt
     */
    public int getSimpleInt() {
        return simpleInt;
    }

    /**
     * @param simpleInt the simpleInt to set
     */
    public void setSimpleInt( int simpleInt ) {
        this.simpleInt = simpleInt;
    }

}
