package com.windwagon.broceliande.knights.forge.impl;

import java.lang.reflect.Constructor;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.errors.ConstructorException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.broceliande.knights.forge.errors.LoadClassException;

public class ComponentWrapperImpl implements ComponentWrapper {

    protected Herald herald;

    protected ComponentClass componentClass;

    public ComponentWrapperImpl( Herald herald, ComponentClass componentClass ) {
        this.herald = herald;
        this.componentClass = componentClass;
    }

    @Override
    public Object instanciateComponent() throws ForgeException {

        try {

            String mainClass = componentClass.getMainClass();

            // get class
            Class<?> clazz = Class.forName( mainClass );

            // get constructor and instanciate
            Constructor<?> constructor = clazz.getConstructor();

            return constructor.newInstance();

        } catch( ClassNotFoundException | ClassCastException ex ) {
            throw new LoadClassException( ex );
        } catch( Throwable ex ) {
            throw new ConstructorException( ex );
        }

    }

    /*
     * OTHERS
     */

    @Override
    public Herald getHerald() {
        return herald;
    }

    @Override
    public ComponentClass getComponentClass() {
        return componentClass;
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitComponent( this );
    }

}
