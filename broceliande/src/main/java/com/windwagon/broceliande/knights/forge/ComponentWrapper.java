package com.windwagon.broceliande.knights.forge;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public interface ComponentWrapper {

    /*
     * INSTANCIATE
     */

    @InActorClassPathOperation
    public Object instanciateComponent() throws ForgeException;

    /*
     * OTHERS
     */

    public Herald getHerald();

    public ComponentClass getComponentClass();

    public <R> R accept( ActorVisitor<R> visitor );

}
