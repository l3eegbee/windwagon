package com.windwagon.broceliande.knights.forge;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentClass;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.SquireData;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.impl.BrotherhoodWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.ComponentWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.DrillHallWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.FencingMasterWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.KnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.NullComponentWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.OfficialKnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.SquireWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.ScribeWrapperImpl;

@Configuration
public class Casern {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public Herald getHerald() {
        return new Herald();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public Herald getHerald( Herald from ) {
        return new Herald( from );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public OfficialKnightWrapper getOfficialKnight( Herald herald, OfficialKnightData knightData ) {
        return new OfficialKnightWrapperImpl( herald, knightData );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public KnightWrapper getKnight( Herald herald, FencingMasterRun fencingMasterRun ) {
        return new KnightWrapperImpl( herald, fencingMasterRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public FencingMasterWrapper getFencingMaster( Herald herald, FencingMasterRun fencingMasterRun ) {
        return new FencingMasterWrapperImpl( herald, fencingMasterRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BrotherhoodWrapper getBrotherhood( Herald herald, BrotherhoodRun brotherhoodRun ) {
        return new BrotherhoodWrapperImpl( herald, brotherhoodRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ScribeWrapper getScribe( Herald herald, ScribeRun scribeRun ) {
        return new ScribeWrapperImpl( herald, scribeRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public SquireWrapper getSquire( Herald herald, Cycle cycle, SquireData squireData ) {
        return new SquireWrapperImpl( herald, cycle, squireData );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentWrapper getComponent( Herald herald, ComponentClass componentClass ) {
        return new ComponentWrapperImpl( herald, componentClass );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public NullComponentWrapper getNullComponent( Herald herald ) {
        return new NullComponentWrapperImpl( herald );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DrillHallWrapper getDrillHall( RaceSet raceSet ) {
        return new DrillHallWrapperImpl( raceSet );
    }

}
