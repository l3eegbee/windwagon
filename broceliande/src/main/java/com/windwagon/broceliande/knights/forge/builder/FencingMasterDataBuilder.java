package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.logres.builder.CachedBuilder;

public class FencingMasterDataBuilder extends TaskBuilder<FencingMasterData, FencingMasterDataBuilder> {

    public FencingMasterDataBuilder() {
        super( new FencingMasterData() );
    }

    /*
     * KnightData
     */

    private CachedBuilder<KnightData, KnightDataBuilder> knightDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getKnightDataBuilder() );

    public FencingMasterDataBuilder knight( KnightData knightData ) {
        knightDataBuilder.set( knightData );
        return this;
    }

    public KnightDataBuilder knight() {
        return knightDataBuilder.builder();
    }

    /*
     * BrotherhoodData
     */

    private CachedBuilder<BrotherhoodData, BrotherhoodDataBuilder> brotherhoodDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getBrotherhoodDataBuilder() );

    public FencingMasterDataBuilder brotherhood( BrotherhoodData brotherhoodData ) {
        brotherhoodDataBuilder.set( brotherhoodData );
        return this;
    }

    public BrotherhoodDataBuilder brotherhood() {
        return brotherhoodDataBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public FencingMasterData build() {

        actorData.setKnight( knightDataBuilder.build() );
        actorData.setBrotherhood( brotherhoodDataBuilder.build() );

        return super.build();

    }

}
