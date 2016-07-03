package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.logres.builder.CachedBuilder;

public class FencingMasterRunBuilder extends RunBuilder<FencingMasterRun, FencingMasterRunBuilder> {

    public FencingMasterRunBuilder() {
        super( new FencingMasterRun() );
    }

    /*
     * FencingMasterData
     */

    private CachedBuilder<FencingMasterData, FencingMasterDataBuilder> fencingMasterDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getFencingMasterDataBuilder() );

    public FencingMasterRunBuilder fencingMaster( FencingMasterData fencingMasterData ) {
        fencingMasterDataBuilder.set( fencingMasterData );
        return this;
    }

    public FencingMasterDataBuilder fencingMaster() {
        return fencingMasterDataBuilder.builder();
    }

    /*
     * Knight serialization
     */

    public FencingMasterRunBuilder knightSerialization( String knightSerialization ) {
        run.setKnightSerialization( knightSerialization );
        return this;
    }

    /*
     * Build
     */

    @Override
    public FencingMasterRun build() {

        run.setFencingMaster( fencingMasterDataBuilder.build() );

        return super.build();

    }

}
