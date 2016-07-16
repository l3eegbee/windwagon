package com.windwagon.broceliande.knights.forge.impl;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.errors.ConstructorException;
import com.windwagon.broceliande.knights.forge.errors.LoadClassException;

public class ComponentWrapperImpl implements ComponentWrapper {

    protected Herald herald;

    protected URLClassLoader classLoader;

    protected ComponentClass componentClass;

    protected Object componentInstance;

    public ComponentWrapperImpl( Herald herald, ComponentClass componentClass ) {
        this.herald = herald;
        this.componentClass = componentClass;
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

            String mainClass = componentClass.getMainClass();

            // get class
            Class clazz = classLoader.loadClass( mainClass );

            // get constructor and instanciate
            Constructor constructor = clazz.getConstructor();
            componentInstance = constructor.newInstance();

            // only actors affect constants

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
    public ComponentClass getComponentClass() {
        return componentClass;
    }

    @Override
    public String getName() {
        return componentClass.getMainClass();
    }

    @Override
    public String getDescription() {
        return componentClass.getDescription();
    }

}
