package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperFactory;
import com.windwagon.kaamelott.Actor;
import com.windwagon.kaamelott.ConstantProp;

public abstract class ArmoredActorWrapperImpl<A extends Actor> implements ArmoredActorWrapper<A> {

    @Autowired
    private ConstantWrapperFactory constantWrapperFactory;

    protected ActorWrapper<A, ?> wrapper;

    protected A instance;

    protected SortedSet<ConstantWrapper> sortedConstants = new TreeSet<>();

    protected Map<String, ConstantWrapper> constants = new HashMap<>();

    public ArmoredActorWrapperImpl( ActorWrapper<A, ?> wrapper, A instance ) {

        this.wrapper = wrapper;
        this.instance = instance;

        for( Constant constant : wrapper.getActorData().getComponent().getConstants() ) {
            ConstantWrapper constantWrapper = constantWrapperFactory.getConstantWrapper( wrapper, constant );
            sortedConstants.add( constantWrapper );
            constants.put( constantWrapper.getName(), constantWrapper );
        }

        sortedConstants = Collections.unmodifiableSortedSet( sortedConstants );

    }

    @Override
    public String getName() {
        return wrapper.getActorData().getName();
    }

    @Override
    public String getDescription() {
        return wrapper.getActorData().getDescription();
    }

    @Override
    public SortedSet<? extends ConstantProp> getConstantProps() {
        return sortedConstants;
    }

    @Override
    public ConstantProp getConstantProp( String name ) {
        return constants.get( name );
    }

    @Override
    public A getActor() {
        return instance;
    }

}
