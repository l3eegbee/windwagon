package com.windwagon.avalon.simple;

public class SimpleParameter {

    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue( String value ) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append( "{value:" )
                .append( value == null ? "null" : "'" + value + "'" )
                .append( "}" )
                .toString();
    }

}
