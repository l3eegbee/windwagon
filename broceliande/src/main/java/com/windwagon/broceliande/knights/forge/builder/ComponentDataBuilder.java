package com.windwagon.broceliande.knights.forge.builder;

import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.logres.builder.Builder;
import com.windwagon.logres.builder.CachedBuilder;
import com.windwagon.logres.builder.SortedSetCachedBuilder;

public class ComponentDataBuilder implements Builder<ComponentData> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    private ComponentData component = new ComponentData();

    /*
     * Name
     */

    public ComponentDataBuilder name( String name ) {
        component.setName( name );
        return this;
    }

    /*
     * Description
     */

    public ComponentDataBuilder description( String description ) {
        component.setDescription( description );
        return this;
    }

    /*
     * ComponentClass
     */

    private CachedBuilder<ComponentClass, ComponentClassBuilder> componentClassBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getComponentClassBuilder() );

    public ComponentDataBuilder componentClass( ComponentClass componentClass ) {
        componentClassBuilder.set( componentClass );
        return this;
    }

    public ComponentClassBuilder componentClass() {
        return componentClassBuilder.builder();
    }

    /*
     * Constant
     */

    private SortedSetCachedBuilder<Constant, ConstantBuilder> constantBuilder =
            new SortedSetCachedBuilder<>( this::newConstantBuilder );

    private ConstantBuilder newConstantBuilder() {
        ConstantBuilder builder = knightBuilderFactory.getConstantBuilder();
        builder.order( constantBuilder.builders().size() );
        return builder;
    }

    public ComponentDataBuilder constants( SortedSet<Constant> constants ) {
        constantBuilder.set( constants );
        return this;
    }

    public ComponentDataBuilder addConstant( Constant constant ) {
        constantBuilder.add( constant );
        return this;
    }

    public ConstantBuilder constant() {
        return constantBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public ComponentData build() {

        component.setComponentClass( componentClassBuilder.build() );

        SortedSet<Constant> constants = constantBuilder.build();
        for( Constant constant : constants )
            constant.setComponent( component );
        component.setConstants( constants );

        return component;

    }

}
