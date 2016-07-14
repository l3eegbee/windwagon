package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public interface MapConstantWrapper extends ConstantWrapper {

    public MapConstraints getMapConstraints() throws ConstraintsFormatException;

}
