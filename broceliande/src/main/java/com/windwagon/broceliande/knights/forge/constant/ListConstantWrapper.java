package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public interface ListConstantWrapper extends ConstantWrapper{
    
    public ListConstraints getListConstraints() throws ConstraintsFormatException;

}
