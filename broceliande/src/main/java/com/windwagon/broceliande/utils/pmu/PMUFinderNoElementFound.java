package com.windwagon.broceliande.utils.pmu;

public class PMUFinderNoElementFound extends PMUFinderException {

    private static final long serialVersionUID = 1L;

    public PMUFinderNoElementFound( Class<?> clazz, String name ) {
        super( "No value in " + clazz + " corresponds to " + name + "." );
    }

}
