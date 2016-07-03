package com.windwagon.broceliande.knights.forge.impl;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.errors.ConstructorException;
import com.windwagon.broceliande.knights.forge.errors.LoadClassException;

public class ComponentWrapperImpl implements ComponentWrapper {

    protected URLClassLoader classLoader;

    protected ComponentData component;

    protected Object componentInstance;

    public ComponentWrapperImpl( ComponentData component ) {
        this.component = component;
    }

    /*
     * CLASS LOADER
     */

    @Override
    public void setClassLoader( URLClassLoader classLoader ) {
        this.classLoader = classLoader;
    }

    @Override
    public URLClassLoader getClassLoader() {
        return classLoader;
    }

    /*
     * INSTANCIATE
     */

    @Override
    @SuppressWarnings( { "rawtypes", "unchecked" } )
    public void inClasspathInstanciate() throws LoadClassException, ConstructorException {

        try {

            // get class
            Class componentClass = classLoader.loadClass( component.getComponentClass().getMainClass() );

            // get constructor and instanciate
            Constructor constructor = componentClass.getConstructor();
            componentInstance = constructor.newInstance();

        } catch( ClassNotFoundException | ClassCastException ex ) {
            throw new LoadClassException( ex );
        } catch( Throwable ex ) {
            throw new ConstructorException( ex );
        }

    }

    @Override
    public Object getInstance() {
        return componentInstance;
    }

    /*
     * OTHERS
     */

    @Override
    public ComponentData getComponent() {
        return component;
    }

    @Override
    public String getName() {
        return component.getName();
    }

    @Override
    public String getDescription() {
        return component.getDescription();
    }

}
