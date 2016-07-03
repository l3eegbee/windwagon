package com.windwagon.broceliande.knights.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.forge.builder.ComponentDataBuilder;
import com.windwagon.broceliande.knights.forge.builder.JARFileBuilder;
import com.windwagon.broceliande.knights.forge.builder.KnightBuilderFactory;

@Component
public class BrokenKnightsBuilder {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private EnvironmentFactory environmentFactory;

    public Environment createEnv() {

        // create actors

        JARFileBuilder jarFileBuilder = knightBuilderFactory.getJARFileBuilder();
        jarFileBuilder.resource( "classpath:/broken/target/avalon-broken-1.0.jar" );
        JARFile jarFile = jarFileBuilder.build();

        // create knight

        ComponentDataBuilder knightComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        knightComponentBuilder.name( "BrokenKnight" );
        knightComponentBuilder.description( "It's a broken knight" );
        knightComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.broken.BrokenKnight" )
                .addType( "com.windwagon.avalon.broken.BrokenKnight" )
                .addType( "com.windwagon.kaamelott.Knight" )
                .addType( "java.lang.Object" )
                .description( "It's a broken knight" )
                .addJarFile( jarFile );
        ComponentData knightComponent = knightComponentBuilder.build();

        KnightData knightData =
                knightBuilderFactory
                        .getKnightDataBuilder()
                        .name( "BrokenKnight" )
                        .description( "It's a broken knight" )
                        .component( knightComponent )
                        .build();

        // create fencing master

        ComponentDataBuilder fencingMasterComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        fencingMasterComponentBuilder.name( "BrokenFencingMaster" );
        fencingMasterComponentBuilder.description( "It's a broken fencingMaster" );
        fencingMasterComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.broken.BrokenFencingMaster" )
                .addType( "com.windwagon.avalon.broken.BrokenFencingMaster" )
                .addType( "com.windwagon.kaamelott.FencingMaster" )
                .addType( "java.lang.Object" )
                .description( "It's a broken fencingMaster" )
                .addJarFile( jarFile );
        ComponentData fencingMasterComponent = fencingMasterComponentBuilder.build();

        FencingMasterData fencingMasterData =
                knightBuilderFactory
                        .getFencingMasterDataBuilder()
                        .name( "BrokenFencingMaster" )
                        .description( "It's a broken fencingMaster" )
                        .component( fencingMasterComponent )
                        .knight( knightData )
                        .build();

        // create brotherhood

        ComponentDataBuilder brotherhoodComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        brotherhoodComponentBuilder.name( "BrokenBrotherhood" );
        brotherhoodComponentBuilder.description( "It's a broken brotherhood" );
        brotherhoodComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.broken.BrokenBrotherhood" )
                .addType( "com.windwagon.avalon.broken.BrokenBrotherhood" )
                .addType( "com.windwagon.kaamelott.Brotherhood" )
                .addType( "java.lang.Object" )
                .description( "It's a broken brotherhood" )
                .addJarFile( jarFile );
        ComponentData brotherhoodComponent = brotherhoodComponentBuilder.build();

        BrotherhoodData brotherhoodData =
                knightBuilderFactory
                        .getBrotherhoodDataBuilder()
                        .name( "BrokenBrotherhood" )
                        .description( "It's a broken brotherhood" )
                        .component( brotherhoodComponent )
                        .addFencingMaster( fencingMasterData )
                        .build();

        // create scribe

        ComponentDataBuilder scribeComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        scribeComponentBuilder.name( "BrokenScribe" );
        scribeComponentBuilder.description( "It's a broken scribe" );
        scribeComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.broken.BrokenScribe" )
                .addType( "com.windwagon.avalon.broken.BrokenScribe" )
                .addType( "com.windwagon.kaamelott.Scribe" )
                .addType( "java.lang.Object" )
                .description( "It's a broken scribe" )
                .addJarFile( jarFile );
        ComponentData scribeComponent = scribeComponentBuilder.build();

        ScribeData scribeData =
                knightBuilderFactory
                        .getScribeDataBuilder()
                        .name( "BrokenScribe" )
                        .description( "It's a broken scribe" )
                        .component( scribeComponent )
                        .build();

        return environmentFactory
                .getEnvironment()
                .addKnightData( knightData )
                .addFencingMasterData( fencingMasterData )
                .addBrotherhoodData( brotherhoodData )
                .addScribeData( scribeData );

    }

}
