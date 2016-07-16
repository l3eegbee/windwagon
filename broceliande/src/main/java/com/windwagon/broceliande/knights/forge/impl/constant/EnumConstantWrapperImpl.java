package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.EnumConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.EnumConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class EnumConstantWrapperImpl extends ConstantWrapperImpl implements EnumConstantWrapper {

    @Override
    public EnumConstraints getEnumConstraints() throws ConstraintsFormatException {
        return readConstraints( EnumConstraints.class );
    }

    @Override
    @SuppressWarnings( { "unchecked", "rawtypes" } )
    protected Object resolveValue( Herald herald ) throws ConstantException {

        try {

            EnumConstraints constraints = getEnumConstraints();

            Class enumClass = actor.getClassLoader().loadClass( constraints.getClassName() );

            return Enum.valueOf( enumClass, constant.getValue() );

        } catch( ConstraintsFormatException | ClassNotFoundException ex ) {
            throw new ConstantException( ex );
        }

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitEnum( this );
    }

}
