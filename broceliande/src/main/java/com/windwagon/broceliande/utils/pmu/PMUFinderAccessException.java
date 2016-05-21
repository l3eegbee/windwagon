package com.windwagon.broceliande.utils.pmu;

import java.lang.reflect.Field;

public class PMUFinderAccessException extends PMUFinderException {

    private static final long serialVersionUID = 1L;

    public PMUFinderAccessException( Class<?> clazz, Field field ) {
        super( "Field " + field + " in " + clazz + "can not be accessed." );
    }

}
