package com.windwagon.broceliande.utils.pmu;

public class PMUFinderTooManyElementsFound extends PMUFinderException {

    private static final long serialVersionUID = 1L;

    public PMUFinderTooManyElementsFound( Class<?> clazz, String field ) {
        super( "More than one value in " + clazz + " for " + field );
    }

}
