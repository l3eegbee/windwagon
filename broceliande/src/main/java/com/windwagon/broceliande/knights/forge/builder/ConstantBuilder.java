package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.logres.builder.Builder;

public class ConstantBuilder implements Builder<Constant> {

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

    @Override
    public Constant build() {
        return constant;
    }

}
