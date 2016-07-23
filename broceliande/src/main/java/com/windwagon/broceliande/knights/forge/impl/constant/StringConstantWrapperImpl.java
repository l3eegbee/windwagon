package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.StringConstantWrapper;

public class StringConstantWrapperImpl extends ConstantWrapperImpl implements StringConstantWrapper {

    public StringConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    protected String resolveValue( ArmoredActorWrapper<?> armored ) {
        return constant.getValue();
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitString( this );
    }

}
