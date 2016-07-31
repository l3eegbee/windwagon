package com.windwagon.broceliande.knights.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.avalon.simple.SimpleBrotherhood;
import com.windwagon.avalon.simple.SimpleFencingMaster;
import com.windwagon.avalon.simple.SimpleKnight;
import com.windwagon.avalon.simple.SimpleParameter;
import com.windwagon.avalon.simple.SimpleScribe;
import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.ComponentClass;
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

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private EnvironmentFactory environmentFactory;

    public Environment createEnv() {
        Environment env = environmentFactory.getEnvironment();
        buildActors( env );
        return env;
    }

    public void buildActors( Environment env ) {

        // create actors

        JARFileBuilder jarFileBuilder = knightBuilderFactory.getJARFileBuilder();
        jarFileBuilder.resource( "classpath:/simple/target/avalon-simple-1.0.jar" );
        JARFile jarFile = jarFileBuilder.build();

        // create SimpleParameter components

        ComponentClass simpleParameterClass =
                knightBuilderFactory
                        .getComponentClassBuilder()
                        .mainClass( SimpleParameter.class )
                        .description( "It's a simple component" )
                        .addJarFile( jarFile )
                        .build();

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
                .name( "Constant - Boolean" )
                .type( ConstantType.BOOLEAN )
                .attribute( "constants.paramBoolean" )
                .value( "true" );
        knightComponentBuilder
                .constant()
                .name( "Constant - String" )
                .type( ConstantType.STRING )
                .attribute( "constants.paramString" )
                .value( "My name is Arnold." );
        knightComponentBuilder
                .constant()
                .name( "Constant - Integer" )
                .type( ConstantType.INTEGER )
                .attribute( "constants.paramInt" )
                .value( "42" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Double" )
                .type( ConstantType.DOUBLE )
                .attribute( "constants.paramDouble" )
                .value( "3.14159" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Enum" )
                .type( ConstantType.ENUM )
                .enumConstraints( "com.windwagon.avalon.simple.EnumParameter", "RED", "BLUE", "YELLOW", "GREEN" )
                .attribute( "constants.paramEnum" )
                .value( "BLUE" );
        knightComponentBuilder
                .constant()
                .name( "Constant - List" )
                .type( ConstantType.LIST )
                .listConstraints( "com.windwagon.avalon.simple.SimpleParameter" )
                .attribute( "listConstant" )
                .value( "2" );
        knightComponentBuilder
                .constant()
                .name( "Constant - List - 1" )
                .type( ConstantType.COMPONENT )
                .attribute( "listConstant[0]" )
                .value( "com.windwagon.avalon.simple.SimpleParameter" );
        knightComponentBuilder
                .constant()
                .name( "Constant - List - 1 - value" )
                .type( ConstantType.STRING )
                .attribute( "listConstant[0].value" )
                .value( "sifa" );
        knightComponentBuilder
                .constant()
                .name( "Constant - List - 2" )
                .type( ConstantType.COMPONENT )
                .attribute( "listConstant[1]" )
                .value( "com.windwagon.avalon.simple.SimpleParameter" );
        knightComponentBuilder
                .constant()
                .name( "Constant - List - 2 - value" )
                .type( ConstantType.STRING )
                .attribute( "listConstant[1].value" )
                .value( "siaedng" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Map" )
                .type( ConstantType.MAP )
                .mapConstraints( "com.windwagon.avalon.simple.SimpleParameter" )
                .attribute( "mapConstant" )
                .value( "2" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Map - 1" )
                .type( ConstantType.COMPONENT )
                .attribute( "mapConstant['yellow']" )
                .value( "com.windwagon.avalon.simple.SimpleParameter" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Map - 1 - value" )
                .type( ConstantType.STRING )
                .attribute( "mapConstant['yellow'].value" )
                .value( "siheuong" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Map - 2" )
                .type( ConstantType.COMPONENT )
                .attribute( "mapConstant['green']" )
                .value( "com.windwagon.avalon.simple.SimpleParameter" );
        knightComponentBuilder
                .constant()
                .name( "Constant - Map - 2 - value" )
                .type( ConstantType.STRING )
                .attribute( "mapConstant['green'].value" )
                .value( "sikhiav" );
        ComponentData knightComponent = knightComponentBuilder.build();

        KnightData knightData =
                knightBuilderFactory
                        .getKnightDataBuilder()
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
        fencingMasterComponentBuilder
                .constant()
                .name( "Constant" )
                .type( ConstantType.COMPONENT )
                .attribute( "parameter" )
                .value( "com.windwagon.avalon.simple.SimpleParameter" );
        fencingMasterComponentBuilder
                .constant()
                .name( "Constant value" )
                .type( ConstantType.STRING )
                .attribute( "parameter.value" )
                .value( "Hey, I'm in the band!" );
        fencingMasterComponentBuilder
                .constant()
                .name( "Drill hall" )
                .type( ConstantType.DRILL_HALL )
                .attribute( "drillHall" )
                .value( "all.drill.hall" );
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
                        .name( "SimpleKnight" )
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

        env
                .addComponentClass( simpleParameterClass )
                .addKnightData( knightData )
                .addFencingMasterData( fencingMasterData )
                .addBrotherhoodData( brotherhoodData )
                .addScribeData( scribeData );

    }

}
