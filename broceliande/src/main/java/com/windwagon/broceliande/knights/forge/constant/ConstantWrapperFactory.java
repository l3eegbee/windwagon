package com.windwagon.broceliande.knights.forge.constant;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.entities.ConstantType;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
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

    public ConstantWrapper getConstantWrapper( ActorWrapper actor, Constant constant ) {

        ConstantType type = constant.getType();

        switch( type ) {

            case BOOLEAN:
                return getBooleanConstantWrapper( actor, constant );

            case INTEGER:
                return getIntegerConstantWrapper( actor, constant );

            case DOUBLE:
                return getDoubleConstantWrapper( actor, constant );

            case STRING:
                return getStringConstantWrapper( actor, constant );

            case ENUM:
                return getEnumConstantWrapper( actor, constant );

            case TEMPLATE:
                return getTemplateConstantWrapper( actor, constant );

            case COMPONENT:
                return getComponentConstantWrapper( actor, constant );

            case DRILL_HALL:
                return getDrillHallConstantWrapper( actor, constant );

            case LIST:
                return getListConstantWrapper( actor, constant );

            case MAP:
                return getMapConstantWrapper( actor, constant );

            default:
                throw new IllegalArgumentException( "No implementation defined for " + type + "." );

        }

    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public BooleanConstantWrapper getBooleanConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        BooleanConstantWrapperImpl wrapper = new BooleanConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public IntegerConstantWrapper getIntegerConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        IntegerConstantWrapperImpl wrapper = new IntegerConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DoubleConstantWrapper getDoubleConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        DoubleConstantWrapperImpl wrapper = new DoubleConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public StringConstantWrapper getStringConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        StringConstantWrapperImpl wrapper = new StringConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public EnumConstantWrapper getEnumConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        EnumConstantWrapperImpl wrapper = new EnumConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public TemplateConstantWrapper getTemplateConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        TemplateConstantWrapperImpl wrapper = new TemplateConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ComponentConstantWrapper getComponentConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        ComponentConstantWrapperImpl wrapper = new ComponentConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public DrillHallConstantWrapper getDrillHallConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        DrillHallConstantWrapperImpl wrapper = new DrillHallConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public ListConstantWrapper getListConstantWrapper(
            ActorWrapper actor,
            Constant constant ) {
        ListConstantWrapperImpl wrapper = new ListConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

    @Bean
    @Scope( ConfigurableBeanFactory.SCOPE_PROTOTYPE )
    public MapConstantWrapper getMapConstantWrapper( ActorWrapper actor, Constant constant ) {
        MapConstantWrapperImpl wrapper = new MapConstantWrapperImpl();
        wrapper.setActor( actor );
        wrapper.setConstant( constant );
        return wrapper;
    }

}
