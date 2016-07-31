package com.windwagon.avalon.complex.component;

public class ComplexComponent {

    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue( String value ) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder().append( "{component:'" ).append( value ).append( "'}" ).toString();
    }

}
