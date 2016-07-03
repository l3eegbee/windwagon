package com.windwagon.broceliande.knights.forge.builder;

import java.util.SortedSet;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.logres.builder.SortedSetCachedBuilder;

public class BrotherhoodDataBuilder extends TaskBuilder<BrotherhoodData, BrotherhoodDataBuilder> {

    public BrotherhoodDataBuilder() {
        super( new BrotherhoodData() );
    }

    /*
     * FencingMasterData
     */

    private SortedSetCachedBuilder<FencingMasterData, FencingMasterDataBuilder> fencingMasterDataBuilder =
            new SortedSetCachedBuilder<>( () -> knightBuilderFactory.getFencingMasterDataBuilder() );

    public BrotherhoodDataBuilder fencingMasters( SortedSet<FencingMasterData> fencingMasters ) {
        fencingMasterDataBuilder.set( fencingMasters );
        return this;
    }

    public BrotherhoodDataBuilder addFencingMaster( FencingMasterData fencingMasterData ) {
        fencingMasterDataBuilder.add( fencingMasterData );
        return this;
    }

    public FencingMasterDataBuilder fencingMaster() {
        return fencingMasterDataBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public BrotherhoodData build() {

        SortedSet<FencingMasterData> fencingMasters = fencingMasterDataBuilder.build();
        actorData.setFencingMasters( fencingMasters );
        for( FencingMasterData fm : fencingMasters )
            fm.setBrotherhood( actorData );

        return super.build();

    }

}
