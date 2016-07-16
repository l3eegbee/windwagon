package com.windwagon.broceliande.knights.forge;

import java.net.URLClassLoader;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public interface ComponentWrapper {

    /*
     * CLASS LOADER
     */

    public void setClassLoader( URLClassLoader classLoader );

    public URLClassLoader getClassLoader();

    /*
     * INSTANCIATE
     */

    @InActorClassPathOperation
    public void inClasspathInstanciate() throws ForgeException;

    public Object getInstance();

    /*
     * OTHERS
     */

    public ComponentClass getComponentClass();

}
