package com.windwagon.broceliande.knights.forge.impl.constant;

import org.springframework.beans.factory.annotation.Autowired;

import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.ActorVisitor;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.ComponentWrapper;
import com.windwagon.broceliande.knights.forge.Tavern;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstantWrapper;
import com.windwagon.broceliande.knights.forge.constant.ComponentConstraints;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapperVisitor;
import com.windwagon.broceliande.knights.forge.errors.ArmoredComponentException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;

public class ComponentConstantWrapperImpl extends ConstantWrapperImpl implements ComponentConstantWrapper {

    @Autowired
    private Tavern tavern;

    public ComponentConstantWrapperImpl( Constant constant ) {
        super( constant );
    }

    @Override
    public ComponentConstraints getComponentConstraints() throws ConstraintsFormatException {
        return readConstraints( ComponentConstraints.class );
    }

    private interface Instanciator {

        public Object instanciate() throws ForgeException;

    }

    private boolean testIfArmored() throws ForgeException {

        boolean isArmored = false;
        if( constant.getConstraints() != null ) {
            ComponentConstraints constraints = readConstraints( ComponentConstraints.class );
            isArmored = constraints.isArmored();
        }

        return isArmored;

    }

    @Override
    protected Object resolveValue( ArmoredActorWrapper<?> armored ) throws ForgeException {

        boolean isArmored = testIfArmored();

        ComponentWrapper wrapper = tavern.findComponent( armored.getHerald(), armored.getCycle(), constant.getValue() );

        return wrapper.accept( new ActorVisitor<Instanciator>() {

            public Instanciator visitComponent( ComponentWrapper wrapper ) {
                return () -> {
                    if( isArmored )
                        throw new ArmoredComponentException();
                    return wrapper.instanciateComponent();
                };
            }

            public Instanciator visitActor( ActorWrapper<?, ?> wrapper ) {
                return () -> {
                    ArmoredActorWrapper<?> armoredValue = wrapper.instanciate( armored.getCamp() );
                    return isArmored ? armoredValue : armoredValue.getActor();
                };
            }

        } ).instanciate();

    }

    @Override
    public <R> R accept( ConstantWrapperVisitor<R> visitor ) {
        return visitor.visitComponent( this );
    }

}
