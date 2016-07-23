package com.windwagon.broceliande.knights.forge.impl.constant;

import java.io.IOException;

import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.windwagon.broceliande.knights.entities.Constant;
import com.windwagon.broceliande.knights.forge.armored.ArmoredActorWrapper;
import com.windwagon.broceliande.knights.forge.constant.ConstantWrapper;
import com.windwagon.broceliande.knights.forge.errors.ConstantException;
import com.windwagon.broceliande.knights.forge.errors.ConstraintsFormatException;
import com.windwagon.broceliande.knights.forge.errors.ForgeException;
import com.windwagon.kaamelott.ConstantProp;

public abstract class ConstantWrapperImpl implements ConstantWrapper {

    protected Constant constant;

    public ConstantWrapperImpl( Constant constant ) {
        this.constant = constant;
    }

    protected abstract Object resolveValue( ArmoredActorWrapper<?> armored ) throws ForgeException;

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
    public int compareTo( ConstantProp constantProp ) {
        return Integer.compare( constant.getOrder(), constantProp.getOrder() );
    }

    @Override
    public void affectValue( ArmoredActorWrapper<?> armored ) throws ForgeException {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression( constant.getAttribute() );

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject( armored.getActor() );

        try {
            exp.setValue( context, resolveValue( armored ) );
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
