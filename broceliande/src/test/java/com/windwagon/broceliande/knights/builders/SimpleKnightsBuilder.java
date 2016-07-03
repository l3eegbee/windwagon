package com.windwagon.broceliande.knights.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.avalon.simple.SimpleBrotherhood;
import com.windwagon.avalon.simple.SimpleFencingMaster;
import com.windwagon.avalon.simple.SimpleKnight;
import com.windwagon.avalon.simple.SimpleScribe;
import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.JARFile;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.forge.builder.ComponentDataBuilder;
import com.windwagon.broceliande.knights.forge.builder.JARFileBuilder;
import com.windwagon.broceliande.knights.forge.builder.KnightBuilderFactory;

@Component
public class SimpleKnightsBuilder {

    public final static String SIMPLE_STING_VALUE = "My name is Arnold.";

    public final static String SIMPLE_INT_VALUE = "42";

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private EnvironmentFactory environmentFactory;

    public Environment createEnv() {

        // create actors

        JARFileBuilder jarFileBuilder = knightBuilderFactory.getJARFileBuilder();
        jarFileBuilder.resource( "classpath:/simple/target/avalon-simple-1.0.jar" );
        JARFile jarFile = jarFileBuilder.build();

        // create knight

        ComponentDataBuilder knightComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        knightComponentBuilder.name( "SimpleKnight" );
        knightComponentBuilder.description( "It's a simple knight" );
        knightComponentBuilder
                .componentClass()
                .mainClass( SimpleKnight.class )
                .description( "It's a simple knight" )
                .addJarFile( jarFile );
        knightComponentBuilder
                .constant()
                .name( "Simple String" )
                .type( ConstantType.STRING )
                .attribute( "constants.simpleString" )
                .value( SIMPLE_STING_VALUE );
        knightComponentBuilder
                .constant()
                .name( "Simple Int" )
                .type( ConstantType.INTEGER )
                .attribute( "constants.simpleInt" )
                .value( SIMPLE_INT_VALUE );
        ComponentData knightComponent = knightComponentBuilder.build();

        KnightData knightData =
                knightBuilderFactory
                        .getKnightDataBuilder()
                        .name( "SimpleKnight" )
                        .description( "It's a simple knight" )
                        .component( knightComponent )
                        .build();

        // create fencing master

        ComponentDataBuilder fencingMasterComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        fencingMasterComponentBuilder.name( "SimpleFencingMaster" );
        fencingMasterComponentBuilder.description( "It's a simple fencingMaster" );
        fencingMasterComponentBuilder
                .componentClass()
                .mainClass( SimpleFencingMaster.class )
                .description( "It's a simple fencingMaster" )
                .addJarFile( jarFile );
        ComponentData fencingMasterComponent = fencingMasterComponentBuilder.build();

        FencingMasterData fencingMasterData =
                knightBuilderFactory
                        .getFencingMasterDataBuilder()
                        .name( "SimpleFencingMaster" )
                        .description( "It's a simple fencingMaster" )
                        .component( fencingMasterComponent )
                        .knight( knightData )
                        .build();

        // create brotherhood

        ComponentDataBuilder brotherhoodComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        brotherhoodComponentBuilder.name( "SimpleBrotherhood" );
        brotherhoodComponentBuilder.description( "It's a simple brotherhood" );
        brotherhoodComponentBuilder
                .componentClass()
                .mainClass( SimpleBrotherhood.class )
                .description( "It's a simple brotherhood" )
                .addJarFile( jarFile );
        ComponentData brotherhoodComponent = brotherhoodComponentBuilder.build();

        BrotherhoodData brotherhoodData =
                knightBuilderFactory
                        .getBrotherhoodDataBuilder()
                        .name( "SimpleBrotherhood" )
                        .description( "It's a simple brotherhood" )
                        .component( brotherhoodComponent )
                        .addFencingMaster( fencingMasterData )
                        .build();

        // create scribe

        ComponentDataBuilder scribeComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        scribeComponentBuilder.name( "SimpleScribe" );
        scribeComponentBuilder.description( "It's a simple scribe" );
        scribeComponentBuilder
                .componentClass()
                .mainClass( SimpleScribe.class )
                .description( "It's a simple scribe" )
                .addJarFile( jarFile );
        ComponentData scribeComponent = scribeComponentBuilder.build();

        ScribeData scribeData =
                knightBuilderFactory
                        .getScribeDataBuilder()
                        .name( "SimpleScribe" )
                        .description( "It's a simple scribe" )
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
