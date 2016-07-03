package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public interface TemplateConstantWrapper extends ConstantWrapper {

    public TemplateConstraints getTemplateConstraints() throws ConstraintsFormatException;

}
