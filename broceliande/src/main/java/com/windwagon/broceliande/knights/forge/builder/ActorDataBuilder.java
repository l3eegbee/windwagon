package com.windwagon.broceliande.knights.forge.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ActorData;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.logres.builder.Builder;
import com.windwagon.logres.builder.CachedBuilder;

public abstract class ActorDataBuilder<A extends ActorData, B extends ActorDataBuilder<A, B>> implements Builder<A> {

    @Autowired
    protected KnightBuilderFactory knightBuilderFactory;

    protected A actorData;

    protected ActorDataBuilder( A actorData ) {
        this.actorData = actorData;
    }

    /*
     * Name
     */

    @SuppressWarnings( "unchecked" )
    public B name( String name ) {
        actorData.setName( name );
        return (B) this;
    }

    /*
     * Description
     */

    @SuppressWarnings( "unchecked" )
    public B description( String description ) {
        actorData.setDescription( description );
        return (B) this;
    }

    /*
     * ComponentData
     */

    private CachedBuilder<ComponentData, ComponentDataBuilder> componentDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getComponentDataBuilder() );

    @SuppressWarnings( "unchecked" )
    public B component( ComponentData component ) {
        componentDataBuilder.set( component );
        return (B) this;
    }

    public ComponentDataBuilder component() {
        return componentDataBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public A build() {

        actorData.setComponent( componentDataBuilder.build() );

        return actorData;

    }

}
