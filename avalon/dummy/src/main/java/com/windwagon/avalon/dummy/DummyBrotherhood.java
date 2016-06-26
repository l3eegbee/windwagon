package com.windwagon.avalon.dummy;

import java.util.Set;

import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;

public class DummyBrotherhood implements Brotherhood {

    private Set<? extends ArmoredFencingMaster> fencingMasters;

    @Override
    public void setFencingMasters( Set<? extends ArmoredFencingMaster> fencingMasters ) {
        this.fencingMasters = fencingMasters;
    }

    @Override
    public ArmoredFencingMaster getBest() {
        return fencingMasters.iterator().next();
    }

}
