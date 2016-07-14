package com.windwagon.broceliande.knights.forge.builder;

import com.windwagon.broceliande.knights.forge.constant.TemplateConstraints;
import com.windwagon.logres.builder.Builder;

public class TemplateConstraintsBuilder implements Builder<TemplateConstraints> {

    private TemplateConstraints templateConstraints = new TemplateConstraints();

    public TemplateConstraintsBuilder language( String language ) {
        templateConstraints.setLanguage( language );
        return this;
    }

    @Override
    public TemplateConstraints build() {
        return templateConstraints;
    }

}
