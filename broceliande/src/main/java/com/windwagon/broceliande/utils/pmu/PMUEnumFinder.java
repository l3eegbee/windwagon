package com.windwagon.broceliande.utils.pmu;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PMUEnumFinder {

	private static class EnumMapper<E extends Enum<E>> {

		private Class<E> clazz;

		private Map<String, Set<E>> mapping;

		private Set<String> noValues;

		public EnumMapper(Class<E> clazz) {
			this.clazz = clazz;
			this.mapping = new HashMap<String, Set<E>>();
			this.noValues = new HashSet<String>();
		}

		private Set<E> getSet(String name) {

			if (mapping.containsKey(name)) {
				return mapping.get(name);
			} else {
				Set<E> set = EnumSet.noneOf(clazz);
				mapping.put(name, set);
				return set;
			}

		}

		public void addValue(String name, E value) {
			getSet(name).add(value);
		}

		public void addDefaultValue(E value) {
			getSet(null).add(value);
		}

		public void addNoValue(String name) {
			noValues.add(name);
		}

		public Set<E> findAll(String name) throws PMUFinderException {

			if (noValues.contains(name)) {
				return Collections.emptySet();
			} else if (mapping.containsKey(name)) {
				return mapping.get(name);
			} else if (mapping.containsKey(null)) {
				return mapping.get(null);
			} else {
				throw new PMUFinderNoElementFound(clazz, name);
			}

		}

	}

	private static Map<Class<?>, EnumMapper<?>> generalmap = new HashMap<Class<?>, EnumMapper<?>>();

	@SuppressWarnings("unchecked")
	public static <E extends Enum<E>> Set<E> findAll(Class<E> clazz, String name) throws PMUFinderException {

		if (generalmap.containsKey(clazz)) {
			return ((EnumMapper<E>) generalmap.get(clazz)).findAll(name);
		}

		EnumMapper<E> mapper = new EnumMapper<E>(clazz);
		generalmap.put(clazz, mapper);

		PMUEnumNoValue noAnno = clazz.getAnnotation(PMUEnumNoValue.class);
		if (noAnno != null) {
			for (String key : noAnno.value())
				mapper.addNoValue(key);
		}

		for (Field field : clazz.getFields())
			if (field.isEnumConstant()) {

				E value = null;
				try {
					value = (E) field.get(null);
				} catch (IllegalAccessException ex) {
					throw new PMUFinderAccessException(clazz, field);
				}

				// default value
				PMUEnumDefaultValue defAnno = field.getAnnotation(PMUEnumDefaultValue.class);
				if (defAnno != null) mapper.addDefaultValue(value);

				// values
				PMUEnumValue anno = field.getAnnotation(PMUEnumValue.class);
				if (anno != null) {
					for (String key : anno.value())
						mapper.addValue(key, value);
				}

			}

		return mapper.findAll(name);

	}

	public static <E extends Enum<E>> E find(Class<E> clazz, String name) throws PMUFinderException {

		Set<E> set = findAll(clazz, name);

		if (set.isEmpty()) {
			return null;
		} else if (set.size() > 1) {
			throw new PMUFinderTooManyElementsFound(clazz, name);
		} else {
			return set.iterator().next();
		}

	}

}
