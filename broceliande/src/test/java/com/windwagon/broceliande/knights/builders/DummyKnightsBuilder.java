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
public class DummyKnightsBuilder {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private EnvironmentFactory environmentFactory;

    public Environment createEnv() {
        Environment env = environmentFactory.getEnvironment();
        buildEnv( env );
        return env;
    }

    public void buildEnv( Environment env ) {

        // create actors

        JARFileBuilder jarFileBuilder = knightBuilderFactory.getJARFileBuilder();
        jarFileBuilder.resource( "classpath:/dummy/target/avalon-dummy-1.0.jar" );
        JARFile jarFile = jarFileBuilder.build();

        // create knight

        ComponentDataBuilder knightComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        knightComponentBuilder.name( "DummyKnight" );
        knightComponentBuilder.description( "It's a dummy knight" );
        knightComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.dummy.DummyKnight" )
                .addType( "com.windwagon.avalon.dummy.DummyKnight" )
                .addType( "com.windwagon.kaamelott.Knight" )
                .addType( "java.lang.Object" )
                .description( "It's a dummy knight" )
                .addJarFile( jarFile );
        ComponentData knightComponent = knightComponentBuilder.build();

        KnightData knightData =
                knightBuilderFactory
                        .getKnightDataBuilder()
                        .description( "It's a dummy knight" )
                        .component( knightComponent )
                        .build();

        // create fencing master

        ComponentDataBuilder fencingMasterComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        fencingMasterComponentBuilder.name( "DummyFencingMaster" );
        fencingMasterComponentBuilder.description( "It's a dummy fencingMaster" );
        fencingMasterComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.dummy.DummyFencingMaster" )
                .addType( "com.windwagon.avalon.dummy.DummyFencingMaster" )
                .addType( "com.windwagon.kaamelott.FencingMaster" )
                .addType( "java.lang.Object" )
                .description( "It's a dummy fencingMaster" )
                .addJarFile( jarFile );
        ComponentData fencingMasterComponent = fencingMasterComponentBuilder.build();

        FencingMasterData fencingMasterData =
                knightBuilderFactory
                        .getFencingMasterDataBuilder()
                        .name( "DummyFencingMaster" )
                        .description( "It's a dummy fencingMaster" )
                        .component( fencingMasterComponent )
                        .knight( knightData )
                        .build();

        // create brotherhood

        ComponentDataBuilder brotherhoodComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        brotherhoodComponentBuilder.name( "DummyBrotherhood" );
        brotherhoodComponentBuilder.description( "It's a dummy brotherhood" );
        brotherhoodComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.dummy.DummyBrotherhood" )
                .addType( "com.windwagon.avalon.dummy.DummyBrotherhood" )
                .addType( "com.windwagon.kaamelott.Brotherhood" )
                .addType( "java.lang.Object" )
                .description( "It's a dummy brotherhood" )
                .addJarFile( jarFile );
        ComponentData brotherhoodComponent = brotherhoodComponentBuilder.build();

        BrotherhoodData brotherhoodData =
                knightBuilderFactory
                        .getBrotherhoodDataBuilder()
                        .name( "DummyKnight" )
                        .description( "It's a dummy brotherhood" )
                        .component( brotherhoodComponent )
                        .addFencingMaster( fencingMasterData )
                        .build();

        // create scribe

        ComponentDataBuilder scribeComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        scribeComponentBuilder.name( "DummyScribe" );
        scribeComponentBuilder.description( "It's a dummy scribe" );
        scribeComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.dummy.DummyScribe" )
                .addType( "com.windwagon.avalon.dummy.DummyScribe" )
                .addType( "com.windwagon.kaamelott.Scribe" )
                .addType( "java.lang.Object" )
                .description( "It's a dummy scribe" )
                .addJarFile( jarFile );
        ComponentData scribeComponent = scribeComponentBuilder.build();

        ScribeData scribeData =
                knightBuilderFactory
                        .getScribeDataBuilder()
                        .name( "DummyScribe" )
                        .description( "It's a dummy scribe" )
                        .component( scribeComponent )
                        .build();

        env
                .addKnightData( knightData )
                .addFencingMasterData( fencingMasterData )
                .addBrotherhoodData( brotherhoodData )
                .addScribeData( scribeData );

    }

}
