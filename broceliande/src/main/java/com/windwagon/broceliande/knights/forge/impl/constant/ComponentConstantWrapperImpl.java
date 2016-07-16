package com.windwagon.broceliande.knights.forge.impl.constant;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.Tavern;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstraints;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class ComponentConstantWrapperImpl extends ConstantWrapperImpl
        implements ComponentConstantWrapper {

    @Autowired
    private Tavern tavern;

    @Override
    public ComponentConstraints getComponentConstraints() throws ConstraintsFormatException {
        return readConstraints( ComponentConstraints.class );
    }

    @Override
    public ComponentWrapper getComponent( Herald herald ) throws ConstantException {

        try {

            return tavern.findComponent( herald, constant.getValue(), actor.getCycle() );

        } catch( ForgeException ex ) {
            throw new ConstantException( ex );
        }

    }

    @Override
    protected Object resolveValue( Herald herald ) throws ConstantException {

        try {

            ComponentWrapper wrapper = getComponent( herald );

            wrapper.setClassLoader( actor.getClassLoader() );
            wrapper.inClasspathInstanciate();

            return wrapper.getInstance();

        } catch( ForgeException ex ) {
            throw new ConstantException( ex );
        }

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitComponent( this );
    }

}
