package com.windwagon.broceliande.knights.forge.impl.constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.ListConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ListConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class ListConstantWrapperImpl extends ConstantWrapperImpl implements ListConstantWrapper {

    public ListConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    public ListConstraints getListConstraints() throws ConstraintsFormatException {
        return readConstraints( ListConstraints.class );
    }

    @Override
    @SuppressWarnings( { "unchecked", "rawtypes" } )
    protected List resolveValue( ArmoredActorWrapper<?> armored ) throws ConstantException {
        return new ArrayList( Collections.nCopies( Integer.parseInt( constant.getValue() ), null ) );
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitList( this );
    }

}
