package com.windwagon.avalon.broken;

import com.windwagon.kaamelott.Scribe;

public class BrokenScribe implements Scribe {

    @Override
    public void evaluate() {
        throw new RuntimeException( "I'm broken" );
    }

}
