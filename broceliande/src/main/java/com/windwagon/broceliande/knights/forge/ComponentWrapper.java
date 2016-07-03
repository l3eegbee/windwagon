package com.windwagon.broceliande.knights.forge;

import java.net.URLClassLoader;

import com.windwagon.broceliande.knights.entities.ComponentData;
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

    public ComponentData getComponent();

    public String getName();

    public String getDescription();

}
