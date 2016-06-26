package com.windwagon.avalon.broken;

import java.util.Set;

import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;

public class BrokenBrotherhood implements Brotherhood {

    @Override
    public void setFencingMasters( Set<? extends ArmoredFencingMaster> fencingMasters ) {}

    @Override
    public ArmoredFencingMaster getBest() {
        throw new RuntimeException( "I'm broken" );
    }

}
