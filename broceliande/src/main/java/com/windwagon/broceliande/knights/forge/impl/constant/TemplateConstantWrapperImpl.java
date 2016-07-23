package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.TemplateConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.TemplateConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class TemplateConstantWrapperImpl extends ConstantWrapperImpl implements TemplateConstantWrapper {

    public TemplateConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    public TemplateConstraints getTemplateConstraints() throws ConstraintsFormatException {
        return readConstraints( TemplateConstraints.class );
    }

    @Override
    protected String resolveValue( ArmoredActorWrapper<?> armored ) {
        return constant.getValue();
    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitTemplate( this );
    }

}
