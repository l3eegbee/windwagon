package com.windwagon.broceliande.knights.forge.armored;

import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.forge.BrotherhoodWrapper;
import com.windwagon.broceliande.knights.forge.FencingMasterWrapper;
import com.windwagon.broceliande.knights.forge.KnightWrapper;
import com.windwagon.broceliande.knights.forge.PageWrapper;
import com.windwagon.broceliande.knights.forge.ScribeWrapper;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredBrotherhoodWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredFencingMasterWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredKnightWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredPageWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.armored.ArmoredScribeWrapperImpl;
import com.windwagon.kaamelott.Brotherhood;
import com.windwagon.kaamelott.FencingMaster;
import com.windwagon.kaamelott.Knight;
import com.windwagon.kaamelott.Page;
import com.windwagon.kaamelott.Scribe;

@Configuration
public class Foundry {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredKnightWrapper getArmoredKnight( KnightWrapper wrapper, Knight instance ) {
        return new ArmoredKnightWrapperImpl( wrapper, instance );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredFencingMasterWrapper getArmoredFencingMaster(
            FencingMasterWrapper wrapper,
            FencingMaster instance,
            ArmoredKnightWrapper armoredKnight ) {
        return new ArmoredFencingMasterWrapperImpl( wrapper, instance, armoredKnight );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredBrotherhoodWrapper getArmoredBrotherhood(
            BrotherhoodWrapper wrapper,
            Brotherhood instance,
            Set<? extends ArmoredFencingMasterWrapper> fencingMasters,
            ArmoredFencingMasterWrapper theone ) {
        return new ArmoredBrotherhoodWrapperImpl( wrapper, instance, fencingMasters, theone );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredScribeWrapper getArmoredScribe( ScribeWrapper wrapper, Scribe instance ) {
        return new ArmoredScribeWrapperImpl( wrapper, instance );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ArmoredPageWrapper getArmoredPage( PageWrapper wrapper, Page instance ) {
        return new ArmoredPageWrapperImpl( wrapper, instance );
    }

}
