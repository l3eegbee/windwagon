package com.windwagon.broceliande.knights.forge;

import java.util.Set;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.forge.armored.ArmoredBrotherhoodWrapper;

public interface BrotherhoodWrapper extends TaskWrapper<ArmoredBrotherhoodWrapper, BrotherhoodData, BrotherhoodRun> {

    public Set<FencingMasterWrapper> getFencingMasterWrappers();

    public FencingMasterWrapper getSelectedWrapper();

}
