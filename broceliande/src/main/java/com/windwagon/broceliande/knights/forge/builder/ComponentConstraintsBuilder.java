package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.forge.constant.ComponentConstraints;
import com.windwagon.logres.builder.Builder;

public class ComponentConstraintsBuilder implements Builder<ComponentConstraints> {

    private ComponentConstraints componentConstraints = new ComponentConstraints();

    public ComponentConstraintsBuilder type( String type ) {
        componentConstraints.setType( type );
        return this;
    }

    @Override
    public ComponentConstraints build() {
        return componentConstraints;
    }

}
