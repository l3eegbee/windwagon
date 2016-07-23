package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.BooleanConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;

public class BooleanConstantWrapperImpl extends ConstantWrapperImpl implements BooleanConstantWrapper {

    public BooleanConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    protected Boolean resolveValue( ArmoredActorWrapper<?> armored ) {
        return Boolean.parseBoolean( constant.getValue() );
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitBoolean( this );
    }

}
