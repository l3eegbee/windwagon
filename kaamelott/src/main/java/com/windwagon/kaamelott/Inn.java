package com.windwagon.kaamelott;

public interface Inn {

    /**
     * @throws TaskInterruptedException
     */
    void rest();

    /**
     * @throws TaskInterruptedException
     */
    void rest(float progress, String message);

}
