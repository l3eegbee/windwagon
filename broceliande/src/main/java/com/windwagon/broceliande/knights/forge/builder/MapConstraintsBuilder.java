package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.forge.constant.MapConstraints;
import com.windwagon.logres.builder.Builder;

public class MapConstraintsBuilder implements Builder<MapConstraints> {

    private MapConstraints mapConstraints = new MapConstraints();

    public MapConstraintsBuilder type( String type ) {
        mapConstraints.setType( type );
        return this;
    }

    @Override
    public MapConstraints build() {
        return mapConstraints;
    }

}
