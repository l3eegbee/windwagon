package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public interface ComponentConstantWrapper extends ConstantWrapper {

    public ComponentConstraints getComponentConstraints() throws ConstraintsFormatException;

}
