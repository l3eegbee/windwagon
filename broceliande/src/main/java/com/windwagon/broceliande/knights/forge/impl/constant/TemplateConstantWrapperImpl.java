package com.windwagon.broceliande.knights.forge.impl.constant;

import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.constant.TemplateConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.TemplateConstraints;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public class TemplateConstantWrapperImpl extends ConstantWrapperImpl
        implements TemplateConstantWrapper {

    @Override
    public TemplateConstraints getTemplateConstraints() throws ConstraintsFormatException {
        return readConstraints( TemplateConstraints.class );
    }

    @Override
    protected String resolveValue( Herald herald ) {

        return constant.getValue();

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitTemplate( this );
    }

}
