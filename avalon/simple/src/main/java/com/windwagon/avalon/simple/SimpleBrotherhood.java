package com.windwagon.avalon.simple;

import java.util.Set;

import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;

public class SimpleBrotherhood implements Brotherhood {

    private Set<? extends ArmoredFencingMaster> fencingMasters;

    @Override
    public void setFencingMasters( Set<? extends ArmoredFencingMaster> fencingMasters ) {
        this.fencingMasters = fencingMasters;
    }

    @Override
    public ArmoredFencingMaster getBest() {
        return fencingMasters.iterator().next();
    }

    @Override
    public void getWebVisu() {}

}
