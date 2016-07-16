package com.windwagon.kaamelott;

import java.util.Set;

public interface ArmoredBrotherhood extends ArmoredActor<Brotherhood> {

    public Set<? extends ArmoredFencingMaster> getFencingMasters();

    public ArmoredFencingMaster getBest();

}
