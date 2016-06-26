package com.windwagon.avalon.complex.brotherhood;

import java.util.Set;

import com.windwagon.kaamelott.ArmoredFencingMaster;
import com.windwagon.kaamelott.Brotherhood;

public class ComplexBrotherhood implements Brotherhood {

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
