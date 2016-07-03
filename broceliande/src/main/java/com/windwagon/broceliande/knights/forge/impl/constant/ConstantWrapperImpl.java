package com.windwagon.broceliande.knights.forge.impl.constant;

import java.io.IOException;

import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.ActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;

public abstract class ConstantWrapperImpl implements ConstantWrapper {

    protected ActorWrapper actor;

    protected Constant constant;

    public void setActor( ActorWrapper actor ) {
        this.actor = actor;
    }

    public void setConstant( Constant constant ) {
        this.constant = constant;
    }

    protected abstract Object resolveValue() throws ConstantException;

    protected Object cachedValue;

    protected Object getCached() throws ConstantException {
        if( cachedValue == null )
            cachedValue = resolveValue();
        return cachedValue;
    }

    @Override
    public String getName() {
        return constant.getName();
    }

    @Override
    public String getDescription() {
        return constant.getDescription();
    }

    @Override
    public String getAttribute() {
        return constant.getAttribute();
    }

    @Override
    public String getValue() {
        return constant.getValue();
    }

    @Override
    public int getOrder() {
        return constant.getOrder();
    }

    @Override
    public boolean isHidden() {
        return constant.getHiddenValue();
    }

    @Override
    public void affectValue() throws ConstantException {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression( constant.getAttribute() );

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject( actor.getInstance() );

        try {
            exp.setValue( context, getCached() );
        } catch( EvaluationException ex ) {
            throw new ConstantException( ex );
        }

    }

    protected <T> T readConstraints( Class<T> contraintsClass ) throws ConstraintsFormatException {

        try {

            String constraints = constant.getConstraints();

            T constraintsValue = new ObjectMapper().readValue( constraints, contraintsClass );

            if( constraintsValue == null )
                throw new ConstraintsFormatException(
                        "Can not cast [" + constraints + "] to " + contraintsClass.getName() );

            return constraintsValue;

        } catch( IOException ex ) {
            throw new ConstraintsFormatException( ex );
        }

    }

}
