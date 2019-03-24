package com.windwagon.broceliande.race.entities;

import com.windwagon.broceliande.race.turf.enumconverter.KaamelottEnumFieldValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumDefaultValue;
import com.windwagon.broceliande.utils.pmu.PMUEnumValue;

public enum Field {

	@PMUEnumValue("BON") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.BON) BON,

	@PMUEnumValue("SEC") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.SEC) SEC,

	@PMUEnumValue("LEGER") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.LEGER) LEGER,

	@PMUEnumValue("COLLANT") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.COLLANT) COLLANT,

	@PMUEnumValue("LOURD") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.LOURD) LOURD,

	@PMUEnumValue("SOUPLE") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.SOUPLE) SOUPLE,

	@PMUEnumValue("ASSEZ_SOUPLE") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.ASSEZ_SOUPLE) ASSEZ_SOUPLE,

	@PMUEnumValue("TRES_LEGER") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.TRES_LEGER) TRES_LEGER,

	@PMUEnumValue("TRES_SOUPLE") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.TRES_SOUPLE) TRES_SOUPLE,

	@PMUEnumValue("TRES_LOURD") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.TRES_LOURD) TRES_LOURD,

	@PMUEnumValue("PROFOND") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.PROFOND) PROFOND,

	@PMUEnumValue("BON_LEGER") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.BON_LEGER) BON_LEGER,

	@PMUEnumValue("BON_SOUPLE") @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.BON_SOUPLE) BON_SOUPLE,

	@PMUEnumDefaultValue @KaamelottEnumFieldValue(com.windwagon.kaamelott.race.Field.UNKNOWN) UNKNOWN

}
