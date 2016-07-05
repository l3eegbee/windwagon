package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.BooleanConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;

public class BooleanConstantWrapperImpl extends ConstantWrapperImpl
        implements BooleanConstantWrapper {

    @Override
    protected Boolean resolveValue( Herald herald ) {

        return Boolean.parseBoolean( constant.getValue() );

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitBoolean( this );
    }

}
