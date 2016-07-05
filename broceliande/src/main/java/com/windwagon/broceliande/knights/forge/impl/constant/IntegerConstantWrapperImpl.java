package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.IntegerConstantWrapper;

public class IntegerConstantWrapperImpl extends ConstantWrapperImpl
        implements IntegerConstantWrapper {

    @Override
    protected Integer resolveValue( Herald herald ) {

        return Integer.parseInt( constant.getValue() );

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitInteger( this );
    }

}
