package com.windwagon.broceliande.knights.forge.armored;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.Casern;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.OfficialKnightWrapper;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredBrotherhoodWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredFencingMasterWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredKnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredOfficialKnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredPageWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredScribeWrapperImpl;

@Configuration
public class Armory {

    @Autowired
    private Casern casern;

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public Camp getCamp( Cycle cycle, Herald herald ) {
        return new Camp( cycle, casern.getHerald( herald ) );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredKnightWrapper getArmoredKnight( Camp camp, KnightWrapper wrapper ) {
        return new ArmoredKnightWrapperImpl( camp, wrapper );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredOfficialKnightWrapper getArmoredOfficialKnight( Camp camp, OfficialKnightWrapper wrapper ) {
        return new ArmoredOfficialKnightWrapperImpl( camp, wrapper );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredFencingMasterWrapper getArmoredFencingMaster( Camp camp, FencingMasterWrapper wrapper ) {
        return new ArmoredFencingMasterWrapperImpl( camp, wrapper );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredBrotherhoodWrapper getArmoredBrotherhood( Camp camp, BrotherhoodWrapper wrapper ) {
        return new ArmoredBrotherhoodWrapperImpl( camp, wrapper );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredScribeWrapper getArmoredScribe( Camp camp, ScribeWrapper wrapper ) {
        return new ArmoredScribeWrapperImpl( camp, wrapper );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredPageWrapper getArmoredPage( Camp camp, PageWrapper wrapper ) {
        return new ArmoredPageWrapperImpl( camp, wrapper );
    }

}
