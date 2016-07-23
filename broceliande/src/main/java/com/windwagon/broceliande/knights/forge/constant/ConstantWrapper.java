package com.windwagon.broceliande.knights.forge.constant;

import com.windwagon.broceliande.knights.forge.InActorClassPathOperation;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.ConstantProp;

public interface ConstantWrapper extends ConstantProp {

    @InActorClassPathOperation
    public void affectValue( ArmoredActorWrapper<?> armored ) throws ForgeException;

    public String getAttribute();

    public <R> R accept( ConstantWrapperVisitor<R> visitor );

}
