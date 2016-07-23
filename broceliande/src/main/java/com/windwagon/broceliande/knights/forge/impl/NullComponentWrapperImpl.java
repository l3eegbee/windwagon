package com.windwagon.broceliande.knights.forge.impl;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.NullComponentWrapper;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class NullComponentWrapperImpl implements NullComponentWrapper {

    private Herald herald;

    public NullComponentWrapperImpl( Herald herald ) {
        this.herald = herald;
    }

    @Override
    public Object instanciateComponent() throws ForgeException {
        return null;
    }

    @Override
    public Herald getHerald() {
        return this.herald;
    }

    @Override
    public ComponentClass getComponentClass() {
        return null;
    }

    @Override
    public <R> R accept( ActorVisitor<R> visitor ) {
        return visitor.visitNull( this );
    }

}
