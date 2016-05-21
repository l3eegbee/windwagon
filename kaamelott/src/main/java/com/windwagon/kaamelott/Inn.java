package com.windwagon.kaamelott;

public interface Inn {

    /**
     * @throws TaskInterruptedException
     */
    public void rest();

    /**
     * @throws TaskInterruptedException
     */
    public void rest( float progress, String message );

}
