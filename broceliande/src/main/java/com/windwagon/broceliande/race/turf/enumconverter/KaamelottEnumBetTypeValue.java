package com.windwagon.broceliande.race.turf.enumconverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.FIELD )
public @interface KaamelottEnumBetTypeValue {

    com.windwagon.kaamelott.race.BetType value();

}
