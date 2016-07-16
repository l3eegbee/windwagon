package com.windwagon.broceliande.knights.forge;

import java.net.URLClassLoader;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class NullComponentWrapper implements ComponentWrapper {

    private URLClassLoader classLoader;

    public void setClassLoader( URLClassLoader classLoader ) {
        this.classLoader = classLoader;
    }

    public URLClassLoader getClassLoader() {
        return this.classLoader;
    }

    public void inClasspathInstanciate() throws ForgeException {}

    public Object getInstance() {
        return null;
    }

    public ComponentClass getComponentClass() {
        return null;
    }

}
