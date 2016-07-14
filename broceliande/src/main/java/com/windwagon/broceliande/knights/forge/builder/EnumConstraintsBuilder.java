package com.windwagon.broceliande.knights.forge.builder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.windwagon.broceliande.knights.forge.constant.EnumConstraints;
import com.windwagon.logres.builder.Builder;

public class EnumConstraintsBuilder implements Builder<EnumConstraints> {

    private EnumConstraints enumConstraints = new EnumConstraints();

    public EnumConstraintsBuilder className( String className ) {
        enumConstraints.setClassName( className );
        return this;
    }

    public EnumConstraintsBuilder names( List<String> names ) {
        enumConstraints.setNames( names );
        return this;
    }

    public EnumConstraintsBuilder names( String ... names ) {
        enumConstraints.setNames( Arrays.asList( names ) );
        return this;
    }

    public EnumConstraintsBuilder addName( String name ) {

        if( enumConstraints.getNames() == null )
            enumConstraints.setNames( new LinkedList<String>() );

        enumConstraints.getNames().add( name );

        return this;

    }

    @Override
    public EnumConstraints build() {
        return enumConstraints;
    }

}
