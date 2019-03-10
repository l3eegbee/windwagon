package com.windwagon.logres.collection;



import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;


public class Sets {

	static public <T> NavigableSet<T> navigableSetFromList(List<T> list) {

		Map<T, Integer> map = new HashMap<T, Integer>(list.size());
		for (int i = 0; i < list.size(); i++)
			map.put(list.get(i), i);

		TreeSet<T> set = new TreeSet<T>(Comparator.comparingInt(map::get));
		set.addAll(list);

		return set;

	}

}
