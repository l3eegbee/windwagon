package com.windwagon.broceliande.knights.forge.impl.constant;

import java.util.List;
import java.util.Vector;

import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.ListConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ListConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class ListConstantWrapperImpl extends ConstantWrapperImpl implements ListConstantWrapper {

    @Override
    public ListConstraints getListConstraints() throws ConstraintsFormatException {
        return readConstraints( ListConstraints.class );
    }

    @Override
    @SuppressWarnings( "rawtypes" )
    protected List resolveValue() throws ConstantException {

        return new Vector( Integer.parseInt( constant.getValue() ) );

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitList( this );
    }

}
