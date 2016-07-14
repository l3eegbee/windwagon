package com.windwagon.broceliande.knights.forge.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.logres.builder.Builder;

public class ConstantBuilder implements Builder<Constant> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    private Constant constant = new Constant();

    /*
     * Name
     */

    public ConstantBuilder name( String name ) {
        constant.setName( name );
        return this;
    }

    /*
     * Description
     */

    public ConstantBuilder description( String description ) {
        constant.setDescription( description );
        return this;
    }

    /*
     * Attribute
     */

    public ConstantBuilder attribute( String attribute ) {
        constant.setAttribute( attribute );
        return this;
    }

    /*
     * Type
     */

    public ConstantBuilder type( ConstantType type ) {
        constant.setType( type );
        return this;
    }

    /*
     * Constraints
     */

    public ConstantBuilder constraints( String constraints ) {
        constant.setConstraints( constraints );
        return this;
    }

    private EnumConstraintsBuilder enumConstraintsBuilder;

    public EnumConstraintsBuilder enumConstraints() {
        enumConstraintsBuilder = knightBuilderFactory.getEnumConstraintsBuilder();
        return enumConstraintsBuilder;
    }

    public ConstantBuilder enumConstraints( String className, String ... names ) {
        enumConstraintsBuilder = knightBuilderFactory.getEnumConstraintsBuilder().className( className ).names( names );

        return this;
    }

    private ComponentConstraintsBuilder componentConstraintsBuilder;

    public ComponentConstraintsBuilder componentConstraints() {
        componentConstraintsBuilder = knightBuilderFactory.getComponentConstraintsBuilder();
        return componentConstraintsBuilder;
    }

    public ConstantBuilder componentConstraints( String type ) {
        componentConstraintsBuilder = knightBuilderFactory.getComponentConstraintsBuilder().type( type );
        return this;
    }

    private TemplateConstraintsBuilder templateConstraintsBuilder;

    public TemplateConstraintsBuilder templateConstraints() {
        templateConstraintsBuilder = knightBuilderFactory.getTemplateConstraintsBuilder();
        return templateConstraintsBuilder;
    }

    public ConstantBuilder templateConstraints( String language ) {
        templateConstraintsBuilder = knightBuilderFactory.getTemplateConstraintsBuilder().language( language );
        return this;
    }

    private ListConstraintsBuilder listConstraintsBuilder;

    public ListConstraintsBuilder listConstraints() {
        listConstraintsBuilder = knightBuilderFactory.getListConstraintsBuilder();
        return listConstraintsBuilder;
    }

    public ConstantBuilder listConstraints( String type ) {
        listConstraintsBuilder = knightBuilderFactory.getListConstraintsBuilder().type( type );
        return this;
    }

    private MapConstraintsBuilder mapConstraintsBuilder;

    public MapConstraintsBuilder mapConstraints() {
        mapConstraintsBuilder = knightBuilderFactory.getMapConstraintsBuilder();
        return mapConstraintsBuilder;
    }

    public ConstantBuilder mapConstraints( String type ) {
        mapConstraintsBuilder = knightBuilderFactory.getMapConstraintsBuilder().type( type );
        return this;
    }

    /*
     * Value
     */

    public ConstantBuilder value( String value ) {
        constant.setValue( value );
        return this;
    }

    /*
     * Order
     */

    public ConstantBuilder order( Integer order ) {
        constant.setOrder( order );
        return this;
    }

    /*
     * Final
     */

    public ConstantBuilder finalValue( Boolean finalValue ) {
        constant.setFinalValue( finalValue );
        return this;
    }

    /*
     * Hidden
     */

    public ConstantBuilder hiddenValue( Boolean hiddenValue ) {
        constant.setHiddenValue( hiddenValue );
        return this;
    }

    /*
     * Build
     */

    private void buildConstraints( Builder<?> constraintsBuilder ) {

        if( constraintsBuilder != null )
            try {
                constraints( new ObjectMapper().writeValueAsString( constraintsBuilder.build() ) );
            } catch( JsonProcessingException ex ) {
                throw new RuntimeException( ex );
            }

    }

    @Override
    public Constant build() {

        buildConstraints( enumConstraintsBuilder );
        buildConstraints( componentConstraintsBuilder );
        buildConstraints( templateConstraintsBuilder );
        buildConstraints( listConstraintsBuilder );
        buildConstraints( mapConstraintsBuilder );

        return constant;
    }

}
