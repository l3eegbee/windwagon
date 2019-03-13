package com.windwagon.logres.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LazyLoadNavigableMap<K, V> {

	public interface Initializer<K, V> {

		void init(NavigableMap<K, V> navigableMap);

	}

	private boolean initialized = false;

	private Comparator<? super K> comparator = null;

	private Initializer<K, V> initializer = (NavigableMap<K, V> navigableMap) -> {
	};

	private Map<K, V> initialMap = new HashMap<K, V>();

	private NavigableMap<K, V> navigableMap = null;

	public LazyLoadNavigableMap(Initializer<K, V> initializer) {
		this(null, initializer);
	}

	public LazyLoadNavigableMap(Comparator<? super K> comparator, Initializer<K, V> initializer) {
		this.comparator = comparator;
		this.initializer = initializer;
	}

	public void initAdd(K key, V value) {
		initialMap.put(key, value);
	}

	public NavigableMap<K, V> getNavigableMap() {

		if (!initialized) {

			navigableMap = comparator == null ? new TreeMap<K, V>() : new TreeMap<K, V>(comparator);
			navigableMap.putAll(initialMap);

			initializer.init(navigableMap);

			navigableMap = Collections.unmodifiableNavigableMap(navigableMap);

			initialized = true;

		}

		return navigableMap;

	}

}
