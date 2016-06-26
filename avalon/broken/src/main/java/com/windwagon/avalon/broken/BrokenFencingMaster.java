package com.windwagon.avalon.broken;

import com.windwagon.kaamelott.ArmoredKnight;
import com.windwagon.kaamelott.FencingMaster;

public class BrokenFencingMaster implements FencingMaster {

    @Override
    public void setKnight( ArmoredKnight knight ) {}

    @Override
    public void train() {
        throw new RuntimeException( "I'm broken" );
    }

}
