package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.InActorClassPathOperation;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.kaamelott.ConstantProp;

public interface ConstantWrapper extends ConstantProp {

    @InActorClassPathOperation
    public void affectValue( Herald herald ) throws ConstantException;

    public String getAttribute();

    public int getOrder();

    public boolean isHidden();

    public <R> R accept( ConstantWrapperVisitor<R> visitor );

}
