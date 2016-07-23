package com.windwagon.broceliande.knights.forge.constant;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.broceliande.knights.forge.impl.constant.BooleanConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.ComponentConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.DoubleConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.DrillHallConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.EnumConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.IntegerConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.ListConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.MapConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.StringConstantWrapperImpl;
import com.windwagon.broceliande.knights.forge.impl.constant.TemplateConstantWrapperImpl;

@Configuration
public class ConstantWrapperFactory {

    public ConstantWrapper getConstantWrapper( Constant constant ) {

        ConstantType type = constant.getType();

        switch( type ) {

            case BOOLEAN:
                return getBooleanConstantWrapper( constant );

            case INTEGER:
                return getIntegerConstantWrapper( constant );

            case DOUBLE:
                return getDoubleConstantWrapper( constant );

            case STRING:
                return getStringConstantWrapper( constant );

            case ENUM:
                return getEnumConstantWrapper( constant );

            case TEMPLATE:
                return getTemplateConstantWrapper( constant );

            case COMPONENT:
                return getComponentConstantWrapper( constant );

            case DRILL_HALL:
                return getDrillHallConstantWrapper( constant );

            case LIST:
                return getListConstantWrapper( constant );

            case MAP:
                return getMapConstantWrapper( constant );

            default:
                throw new IllegalArgumentException( "No implementation defined for " + type + "." );

        }

    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BooleanConstantWrapper getBooleanConstantWrapper( Constant constant ) {
        return new BooleanConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public IntegerConstantWrapper getIntegerConstantWrapper( Constant constant ) {
        return new IntegerConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DoubleConstantWrapper getDoubleConstantWrapper( Constant constant ) {
        return new DoubleConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public StringConstantWrapper getStringConstantWrapper( Constant constant ) {
        return new StringConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public EnumConstantWrapper getEnumConstantWrapper( Constant constant ) {
        return new EnumConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public TemplateConstantWrapper getTemplateConstantWrapper( Constant constant ) {
        return new TemplateConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentConstantWrapper getComponentConstantWrapper( Constant constant ) {
        return new ComponentConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DrillHallConstantWrapper getDrillHallConstantWrapper( Constant constant ) {
        return new DrillHallConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ListConstantWrapper getListConstantWrapper( Constant constant ) {
        return new ListConstantWrapperImpl( constant );
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public MapConstantWrapper getMapConstantWrapper( Constant constant ) {
        return new MapConstantWrapperImpl( constant );
    }

}
