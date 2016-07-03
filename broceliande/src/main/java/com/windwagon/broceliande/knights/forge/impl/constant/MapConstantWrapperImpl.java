package com.windwagon.broceliande.knights.forge.impl.constant;

import java.util.HashMap;
import java.util.Map;

import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.MapConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;

public class MapConstantWrapperImpl extends ConstantWrapperImpl implements MapConstantWrapper {

    @Override
    @SuppressWarnings( "rawtypes" )
    protected Map resolveValue() throws ConstantException {

        return new HashMap();

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitMap( this );
    }

}
