package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public interface EnumConstantWrapper extends ConstantWrapper {

    public EnumConstraints getEnumConstraints() throws ConstraintsFormatException;

}
