package com.windwagon.broceliande.knights.forge.impl.armored;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.windwagon.broceliande.knights.entities.Cycle;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.Herald;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.armored.Camp;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.kaamelott.Actor;
import com.windwagon.kaamelott.ConstantProp;

public abstract class ArmoredActorWrapperImpl<A extends Actor, W extends ActorWrapper<?, ?>>
        implements ArmoredActorWrapper<A> {

    protected Camp camp;

    protected W wrapper;

    protected A instance;

    protected SortedSet<ConstantWrapper> sortedConstants = new TreeSet<>();

    protected Map<String, ConstantWrapper> constants = new HashMap<>();

    public ArmoredActorWrapperImpl( Camp camp, W wrapper ) {

        this.camp = camp;
        this.wrapper = wrapper;

        sortedConstants.addAll( wrapper.getConstants() );
        sortedConstants = Collections.unmodifiableSortedSet( sortedConstants );

        for( ConstantWrapper constant : sortedConstants )
            constants.put( constant.getName(), constant );

    }

    @Override
    public Herald getHerald() {
        return camp.getHerald();
    }

    @Override
    public Cycle getCycle() {
        return camp.getCycle();
    }

    @Override
    public Camp getCamp() {
        return camp;
    }

    @Override
    public W getWrapper() {
        return wrapper;
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
    public SortedSet<? extends ConstantWrapper> getConstantProps() {
        return sortedConstants;
    }

    @Override
    public ConstantProp getConstantProp( String name ) {
        return constants.get( name );
    }

    @Override
    public void setActor( A instance ) {
        this.instance = instance;
    }

    @Override
    public A getActor() {
        return instance;
    }

}
