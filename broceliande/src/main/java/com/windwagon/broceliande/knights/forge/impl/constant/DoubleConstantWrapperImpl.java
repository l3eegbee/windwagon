package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.DoubleConstantWrapper;

public class DoubleConstantWrapperImpl extends ConstantWrapperImpl
        implements DoubleConstantWrapper {

    @Override
    protected Double resolveValue() {

        return Double.parseDouble( constant.getValue() );

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitDouble( this );
    }

}
