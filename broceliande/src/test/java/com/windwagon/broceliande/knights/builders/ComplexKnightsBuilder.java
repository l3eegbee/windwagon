package com.windwagon.broceliande.knights.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.windwagon.broceliande.knights.entities.BrotherhoodData;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.FencingMasterData;
import com.windwagon.broceliande.knights.entities.KnightData;
import com.windwagon.broceliande.knights.entities.ScribeData;
import com.windwagon.broceliande.knights.forge.builder.ComponentDataBuilder;
import com.windwagon.broceliande.knights.forge.builder.KnightBuilderFactory;

@Component
public class ComplexKnightsBuilder {

    @Autowired
    private KnightBuilderFactory knightBuilderFactory;

    @Autowired
    private EnvironmentFactory environmentFactory;

    public Environment createEnv() {

        // create knight

        ComponentDataBuilder knightComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        knightComponentBuilder.name( "ComplexKnight" );
        knightComponentBuilder.description( "It's a complex knight" );
        knightComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.complex.knight.ComplexKnight" )
                .addType( "com.windwagon.avalon.complex.knight.ComplexKnight" )
                .addType( "com.windwagon.kaamelott.Knight" )
                .addType( "java.lang.Object" )
                .description( "It's a complex knight" )
                .jarFile()
                .resource( "classpath:/complex/knight/target/avalon-complex-knight-1.0.jar" );
        ComponentData knightComponent = knightComponentBuilder.build();

        KnightData knightData =
                knightBuilderFactory
                        .getKnightDataBuilder()
                        .name( "ComplexKnight" )
                        .description( "It's a complex knight" )
                        .component( knightComponent )
                        .build();

        // create fencing master

        ComponentDataBuilder fencingMasterComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        fencingMasterComponentBuilder.name( "ComplexFencingMaster" );
        fencingMasterComponentBuilder.description( "It's a complex fencingMaster" );
        fencingMasterComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.complex.fencingmaster.ComplexFencingMaster" )
                .addType( "com.windwagon.avalon.complex.fencingmaster.ComplexFencingMaster" )
                .addType( "com.windwagon.kaamelott.FencingMaster" )
                .addType( "java.lang.Object" )
                .description( "It's a complex fencingMaster" )
                .jarFile()
                .resource( "classpath:/complex/fencingmaster/target/avalon-complex-fencingmaster-1.0.jar" );
        ComponentData fencingMasterComponent = fencingMasterComponentBuilder.build();

        FencingMasterData fencingMasterData =
                knightBuilderFactory
                        .getFencingMasterDataBuilder()
                        .name( "ComplexFencingMaster" )
                        .description( "It's a complex fencingMaster" )
                        .component( fencingMasterComponent )
                        .knight( knightData )
                        .build();

        // create brotherhood

        ComponentDataBuilder brotherhoodComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        brotherhoodComponentBuilder.name( "ComplexBrotherhood" );
        brotherhoodComponentBuilder.description( "It's a complex brotherhood" );
        brotherhoodComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.complex.brotherhood.ComplexBrotherhood" )
                .addType( "com.windwagon.avalon.complex.brotherhood.ComplexBrotherhood" )
                .addType( "com.windwagon.kaamelott.Brotherhood" )
                .addType( "java.lang.Object" )
                .description( "It's a complex brotherhood" )
                .jarFile()
                .resource( "classpath:/complex/brotherhood/target/avalon-complex-brotherhood-1.0.jar" );
        ComponentData brotherhoodComponent = brotherhoodComponentBuilder.build();

        BrotherhoodData brotherhoodData =
                knightBuilderFactory
                        .getBrotherhoodDataBuilder()
                        .name( "ComplexBrotherhood" )
                        .description( "It's a complex brotherhood" )
                        .component( brotherhoodComponent )
                        .addFencingMaster( fencingMasterData )
                        .build();

        // create scribe

        ComponentDataBuilder scribeComponentBuilder = knightBuilderFactory.getComponentDataBuilder();
        scribeComponentBuilder.name( "ComplexScribe" );
        scribeComponentBuilder.description( "It's a complex scribe" );
        scribeComponentBuilder
                .componentClass()
                .mainClass( "com.windwagon.avalon.complex.scribe.ComplexScribe" )
                .addType( "com.windwagon.avalon.complex.scribe.ComplexScribe" )
                .addType( "com.windwagon.kaamelott.Scribe" )
                .addType( "java.lang.Object" )
                .description( "It's a complex scribe" )
                .jarFile()
                .resource( "classpath:/complex/scribe/target/avalon-complex-scribe-1.0.jar" );
        ComponentData scribeComponent = scribeComponentBuilder.build();

        ScribeData scribeData =
                knightBuilderFactory
                        .getScribeDataBuilder()
                        .name( "ComplexScribe" )
                        .description( "It's a complex scribe" )
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
