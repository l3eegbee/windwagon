package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.IntegerConstantWrapper;

public class IntegerConstantWrapperImpl extends ConstantWrapperImpl implements IntegerConstantWrapper {

    public IntegerConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    protected Integer resolveValue( ArmoredActorWrapper<?> armored ) {
        return Integer.parseInt( constant.getValue() );
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitInteger( this );
    }

}
