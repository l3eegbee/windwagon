package com.windwagon.broceliande.knights.forge.impl.constant;

import java.util.HashMap;
import java.util.Map;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.MapConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.MapConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class MapConstantWrapperImpl extends ConstantWrapperImpl implements MapConstantWrapper {

    public MapConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    public MapConstraints getMapConstraints() throws ConstraintsFormatException {
        return readConstraints( MapConstraints.class );
    }

    @Override
    @SuppressWarnings( "rawtypes" )
    protected Map resolveValue( ArmoredActorWrapper<?> armored ) throws ConstantException {
        return new HashMap();
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitMap( this );
    }

}
