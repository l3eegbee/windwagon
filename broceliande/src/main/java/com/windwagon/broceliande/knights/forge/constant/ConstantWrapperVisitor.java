package com.windwagon.broceliande.knights.forge.constant;

public abstract class ConstantWrapperVisitor<R> {

    public R visitConstant( ConstantWrapper constant ) {
        throw new IllegalArgumentException(
                "No visitor defined for [" + constant.getClass() + "]" );
    }

    public R visitBoolean( BooleanConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitInteger( IntegerConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitDouble( DoubleConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitString( StringConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitEnum( EnumConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitTemplate( TemplateConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitComponent( ComponentConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitDrillHall( DrillHallConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitList( ListConstantWrapper constant ) {
        return visitConstant( constant );
    }

    public R visitMap( MapConstantWrapper constant ) {
        return visitConstant( constant );
    }

}
