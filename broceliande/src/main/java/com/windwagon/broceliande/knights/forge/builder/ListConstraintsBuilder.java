package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.forge.constant.ListConstraints;
import com.windwagon.logres.builder.Builder;

public class ListConstraintsBuilder implements Builder<ListConstraints> {

    private ListConstraints listConstraints = new ListConstraints();

    public ListConstraintsBuilder type( String type ) {
        listConstraints.setType( type );
        return this;
    }

    @Override
    public ListConstraints build() {
        return listConstraints;
    }

}
