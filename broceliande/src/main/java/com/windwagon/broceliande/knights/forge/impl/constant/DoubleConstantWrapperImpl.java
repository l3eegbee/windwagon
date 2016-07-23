package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.DoubleConstantWrapper;

public class DoubleConstantWrapperImpl extends ConstantWrapperImpl implements DoubleConstantWrapper {

    public DoubleConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    protected Double resolveValue( ArmoredActorWrapper<?> armored ) {
        return Double.parseDouble( constant.getValue() );
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitDouble( this );
    }

}
