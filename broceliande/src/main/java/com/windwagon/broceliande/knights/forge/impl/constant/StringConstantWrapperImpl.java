package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.StringConstantWrapper;

public class StringConstantWrapperImpl extends ConstantWrapperImpl
        implements StringConstantWrapper {

    @Override
    protected String resolveValue() {

        return constant.getValue();

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitString( this );
    }

}
