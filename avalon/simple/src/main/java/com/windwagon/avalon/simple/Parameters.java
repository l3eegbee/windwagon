package com.windwagon.avalon.simple;

public class Parameters {

    private boolean paramBoolean;

    private String paramString;

    private int paramInt;

    private double paramDouble;

    private EnumParameter paramEnum;

    public boolean getParamBoolean() {
        return this.paramBoolean;
    }

    public void setParamBoolean( boolean paramBoolean ) {
        this.paramBoolean = paramBoolean;
    }

    public String getParamString() {
        return this.paramString;
    }

    public void setParamString( String paramString ) {
        this.paramString = paramString;
    }

    public int getParamInt() {
        return this.paramInt;
    }

    public void setParamInt( int paramInt ) {
        this.paramInt = paramInt;
    }

    public double getParamDouble() {
        return this.paramDouble;
    }

    public void setParamDouble( double paramDouble ) {
        this.paramDouble = paramDouble;
    }

    public EnumParameter getParamEnum() {
        return this.paramEnum;
    }

    public void setParamEnum( EnumParameter paramEnum ) {
        this.paramEnum = paramEnum;
    }

    private String getParamValue( String name, Object obj ) {
        return name + ":" + ( obj == null ? "null" : "'" + obj.toString() + "'" );
    }

    @Override
    public String toString() {

        return new StringBuilder( "{" )
                .append( getParamValue( "boolean", paramBoolean ) )
                .append( "," )
                .append( getParamValue( "string", paramString ) )
                .append( "," )
                .append( getParamValue( "int", Integer.toString( paramInt ) ) )
                .append( "," )
                .append( getParamValue( "double", Double.toString( paramDouble ) ) )
                .append( "," )
                .append( getParamValue( "enum", paramEnum ) )
                .append( "}" )
                .toString();

    }

}
