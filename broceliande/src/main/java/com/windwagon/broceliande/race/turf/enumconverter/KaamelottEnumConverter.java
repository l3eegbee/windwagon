package com.windwagon.broceliande.race.turf.enumconverter;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.Map;

import com.windwagon.broceliande.race.entities.BetType;
import com.windwagon.broceliande.race.entities.Blinder;
import com.windwagon.broceliande.race.entities.Breed;
import com.windwagon.broceliande.race.entities.Coat;
import com.windwagon.broceliande.race.entities.Discipline;
import com.windwagon.broceliande.race.entities.Horseshoe;
import com.windwagon.broceliande.race.entities.PriceName;
import com.windwagon.broceliande.race.entities.Sex;
import com.windwagon.broceliande.race.entities.Type;
import com.windwagon.broceliande.race.entities.WindDirection;

public abstract class KaamelottEnumConverter<K extends Enum<K>, B extends Enum<B>> {

	public static class WindDirectionEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.WindDirection, WindDirection> {

		private WindDirectionEnumConverter() {
			super(com.windwagon.kaamelott.race.WindDirection.class, WindDirection.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.WindDirection getKaamelottValue(Field field) {

			KaamelottEnumWindDirectionValue anno = field.getAnnotation(KaamelottEnumWindDirectionValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class FieldEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Field, com.windwagon.broceliande.race.entities.Field> {

		private FieldEnumConverter() {
			super(com.windwagon.kaamelott.race.Field.class, com.windwagon.broceliande.race.entities.Field.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Field getKaamelottValue(Field field) {

			KaamelottEnumFieldValue anno = field.getAnnotation(KaamelottEnumFieldValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class DisciplineEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Discipline, Discipline> {

		private DisciplineEnumConverter() {
			super(com.windwagon.kaamelott.race.Discipline.class, Discipline.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Discipline getKaamelottValue(Field field) {

			KaamelottEnumDisciplineValue anno = field.getAnnotation(KaamelottEnumDisciplineValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class RaceTypeEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.RaceType, Type> {

		private RaceTypeEnumConverter() {
			super(com.windwagon.kaamelott.race.RaceType.class, Type.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.RaceType getKaamelottValue(Field field) {

			KaamelottEnumRaceTypeValue anno = field.getAnnotation(KaamelottEnumRaceTypeValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class BetTypeEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.BetType, BetType> {

		private BetTypeEnumConverter() {
			super(com.windwagon.kaamelott.race.BetType.class, BetType.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.BetType getKaamelottValue(Field field) {

			KaamelottEnumBetTypeValue anno = field.getAnnotation(KaamelottEnumBetTypeValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class PriceNameEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.PriceName, PriceName> {

		private PriceNameEnumConverter() {
			super(com.windwagon.kaamelott.race.PriceName.class, PriceName.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.PriceName getKaamelottValue(Field field) {

			KaamelottEnumPriceNameValue anno = field.getAnnotation(KaamelottEnumPriceNameValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class SexEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Sex, Sex> {

		private SexEnumConverter() {
			super(com.windwagon.kaamelott.race.Sex.class, Sex.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Sex getKaamelottValue(Field field) {

			KaamelottEnumSexValue anno = field.getAnnotation(KaamelottEnumSexValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class BreedEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Breed, Breed> {

		private BreedEnumConverter() {
			super(com.windwagon.kaamelott.race.Breed.class, Breed.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Breed getKaamelottValue(Field field) {

			KaamelottEnumBreedValue anno = field.getAnnotation(KaamelottEnumBreedValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class CoatEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Coat, Coat> {

		private CoatEnumConverter() {
			super(com.windwagon.kaamelott.race.Coat.class, Coat.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Coat getKaamelottValue(Field field) {

			KaamelottEnumCoatValue anno = field.getAnnotation(KaamelottEnumCoatValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class BlinderEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Blinder, Blinder> {

		private BlinderEnumConverter() {
			super(com.windwagon.kaamelott.race.Blinder.class, Blinder.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Blinder getKaamelottValue(Field field) {

			KaamelottEnumBlinderValue anno = field.getAnnotation(KaamelottEnumBlinderValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	public static class HorseshoeEnumConverter extends KaamelottEnumConverter<com.windwagon.kaamelott.race.Horseshoe, Horseshoe> {

		private HorseshoeEnumConverter() {
			super(com.windwagon.kaamelott.race.Horseshoe.class, Horseshoe.class);
		}

		@Override
		protected com.windwagon.kaamelott.race.Horseshoe getKaamelottValue(Field field) {

			KaamelottEnumHorseshoeValue anno = field.getAnnotation(KaamelottEnumHorseshoeValue.class);
			if (anno == null) throw new RuntimeException("No associated field for " + field);

			return anno.value();

		}

	}

	static final public WindDirectionEnumConverter windDirection = new WindDirectionEnumConverter();

	static final public FieldEnumConverter field = new FieldEnumConverter();

	static final public DisciplineEnumConverter discipline = new DisciplineEnumConverter();

	static final public RaceTypeEnumConverter raceType = new RaceTypeEnumConverter();

	static final public BetTypeEnumConverter betType = new BetTypeEnumConverter();

	static final public PriceNameEnumConverter priceName = new PriceNameEnumConverter();

	static final public SexEnumConverter sex = new SexEnumConverter();

	static final public BreedEnumConverter breed = new BreedEnumConverter();

	static final public CoatEnumConverter coat = new CoatEnumConverter();

	static final public BlinderEnumConverter blinder = new BlinderEnumConverter();

	static final public HorseshoeEnumConverter horseshoe = new HorseshoeEnumConverter();

	protected Map<K, B> kaam2bro;

	protected Map<B, K> bro2kaam;

	@SuppressWarnings("unchecked")
	protected KaamelottEnumConverter(Class<K> classK, Class<B> classB) {

		this.kaam2bro = new EnumMap<K, B>(classK);
		this.bro2kaam = new EnumMap<B, K>(classB);

		for (Field field : classB.getFields())
			if (field.isEnumConstant()) {

				B broValue = null;
				try {
					broValue = (B) field.get(null);
				} catch (IllegalAccessException ex) {
					throw new RuntimeException(ex);
				}

				K kaamValue = getKaamelottValue(field);

				kaam2bro.put(kaamValue, broValue);
				bro2kaam.put(broValue, kaamValue);

			}

	}

	abstract protected K getKaamelottValue(Field broceliandeField);

	public B castToBroceliande(K kaamelottValue) {
		return kaamelottValue == null ? null : kaam2bro.get(kaamelottValue);
	}

	public K castToKaamelott(B broceliandeValue) {
		return broceliandeValue == null ? null : bro2kaam.get(broceliandeValue);
	}

}
