package com.windwagon.broceliande.knights.forge;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.entities.BrotherhoodRun;
import com.windwagon.broceliande.knights.entities.ComponentData;
import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.entities.FencingMasterRun;
import com.windwagon.broceliande.knights.entities.OfficialKnightData;
import com.windwagon.broceliande.knights.entities.PageData;
import com.windwagon.broceliande.knights.entities.RaceSet;
import com.windwagon.broceliande.knights.entities.ScribeRun;
import com.windwagon.broceliande.knights.forge.impl.BrotherhoodWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.ComponentWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.FencingMasterWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.KnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.OfficialKnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.PageWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.ScribeWrapperImpl;

@Configuration
public class Casern {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public OfficialKnightWrapper getOfficialKnight( OfficialKnightData knightData ) {
        return new OfficialKnightWrapperImpl( knightData );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public KnightWrapper getKnight( FencingMasterRun fencingMasterRun ) {
        return new KnightWrapperImpl( fencingMasterRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public FencingMasterWrapper getFencingMaster( FencingMasterRun fencingMasterRun ) {
        return new FencingMasterWrapperImpl( fencingMasterRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BrotherhoodWrapper getBrotherhood( BrotherhoodRun brotherhoodRun ) {
        return new BrotherhoodWrapperImpl( brotherhoodRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ScribeWrapper getScribe( ScribeRun scribeRun ) {
        return new ScribeWrapperImpl( scribeRun );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public PageWrapper getPage( Cycle cycle, PageData pageData ) {
        return new PageWrapperImpl( cycle, pageData );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentWrapper getComponent( ComponentData component ) {
        return new ComponentWrapperImpl( component );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DrillHallWrapper getDrillHall( RaceSet raceSet ) {
        return new DrillHallWrapper( raceSet );
    }

}
