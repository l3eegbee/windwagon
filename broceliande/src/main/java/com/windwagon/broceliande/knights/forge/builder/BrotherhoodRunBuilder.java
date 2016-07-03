package com.windwagon.broceliande.knights.forge.builder;

import java.util.SortedSet;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.logres.builder.CachedBuilder;
import com.windwagon.logres.builder.SortedSetCachedBuilder;

public class BrotherhoodRunBuilder extends RunBuilder<BrotherhoodRun, BrotherhoodRunBuilder> {

    public BrotherhoodRunBuilder() {
        super( new BrotherhoodRun() );
    }

    /*
     * BrotherhoodData
     */

    private CachedBuilder<BrotherhoodData, BrotherhoodDataBuilder> brotherhoodDataBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getBrotherhoodDataBuilder() );

    public BrotherhoodRunBuilder brotherhood( BrotherhoodData brotherhoodData ) {
        brotherhoodDataBuilder.set( brotherhoodData );
        return this;
    }

    public BrotherhoodDataBuilder brotherhood() {
        return brotherhoodDataBuilder.builder();
    }

    /*
     * FencingMasterRun
     */

    private SortedSetCachedBuilder<FencingMasterRun, FencingMasterRunBuilder> fencingMasterRunBuilder =
            new SortedSetCachedBuilder<>( () -> knightBuilderFactory.getFencingMasterRunBuilder() );

    public BrotherhoodRunBuilder fencingMasters( SortedSet<FencingMasterRun> fencingMasters ) {
        fencingMasterRunBuilder.set( fencingMasters );
        return this;
    }

    public BrotherhoodRunBuilder addFencingMaster( FencingMasterRun fencingMaster ) {
        fencingMasterRunBuilder.add( fencingMaster );
        return this;
    }

    public FencingMasterRunBuilder fencingMaster() {
        return fencingMasterRunBuilder.builder();
    }

    /*
     * Selected
     */

    private CachedBuilder<FencingMasterRun, FencingMasterRunBuilder> selectedBuilder =
            new CachedBuilder<>( () -> knightBuilderFactory.getFencingMasterRunBuilder() );

    public BrotherhoodRunBuilder selected( FencingMasterRun selected ) {
        selectedBuilder.set( selected );
        return this;
    }

    public FencingMasterRunBuilder selected() {
        return selectedBuilder.builder();
    }

    /*
     * Build
     */

    @Override
    public BrotherhoodRun build() {

        run.setBrotherhood( brotherhoodDataBuilder.build() );

        SortedSet<FencingMasterRun> fencingMasters = fencingMasterRunBuilder.build();

        FencingMasterRun selected = selectedBuilder.build();
        if( selected != null ) {
            run.setSelected( selected );
            selected.setBrotherhood( run );
            fencingMasters.add( selected );
        }

        run.setFencingMasters( fencingMasters );
        for( FencingMasterRun fm : fencingMasters )
            fm.setBrotherhood( run );

        return super.build();

    }

}
