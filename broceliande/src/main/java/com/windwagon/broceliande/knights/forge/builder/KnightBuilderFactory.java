package com.windwagon.broceliande.knights.forge.builder;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class KnightBuilderFactory {

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public JARFileBuilder getJARFileBuilder() {
        return new JARFileBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentClassBuilder getComponentClassBuilder() {
        return new ComponentClassBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentDataBuilder getComponentDataBuilder() {
        return new ComponentDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ConstantBuilder getConstantBuilder() {
        return new ConstantBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public OfficialKnightDataBuilder getOfficialKnightDataBuilder() {
        return new OfficialKnightDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public KnightDataBuilder getKnightDataBuilder() {
        return new KnightDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public PageDataBuilder getPageDataBuilder() {
        return new PageDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public FencingMasterDataBuilder getFencingMasterDataBuilder() {
        return new FencingMasterDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BrotherhoodDataBuilder getBrotherhoodDataBuilder() {
        return new BrotherhoodDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ScribeDataBuilder getScribeDataBuilder() {
        return new ScribeDataBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public CycleBuilder getCycleBuilder() {
        return new CycleBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public RaceSetBuilder getRaceSetBuilder() {
        return new RaceSetBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public FencingMasterRunBuilder getFencingMasterRunBuilder() {
        return new FencingMasterRunBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BrotherhoodRunBuilder getBrotherhoodRunBuilder() {
        return new BrotherhoodRunBuilder();
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ScribeRunBuilder getScribeRunBuilder() {
        return new ScribeRunBuilder();
    }

}
