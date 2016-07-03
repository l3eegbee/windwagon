package com.windwagon.broceliande.knights.forge.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.logres.builder.CachedBuilder;

public class ScribeRunBuilder extends RunBuilder<ScribeRun, ScribeRunBuilder> {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    public ScribeRunBuilder() {
        super( new ScribeRun() );
    }

    /*
     * ScribeData
     */

    private CachedBuilder<ScribeData, ScribeDataBuilder> scribeDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getScribeDataBuilder() );

    public ScribeRunBuilder scribe( ScribeData scribeData ) {
        scribeDataBuilder.set( scribeData );
        return this;
    }

    public ScribeDataBuilder scribe() {
        return scribeDataBuilder.builder();
    }

    /*
     * Build
     */

    @Autowired
    public ScribeRun build() {

        run.setScribe( scribeDataBuilder.build() );

        return super.build();

    }

}
