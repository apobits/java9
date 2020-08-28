package apo.java.practice.codewars;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class MyLanguages {

    public static void main(String[] args) {
	var map = new HashMap<String, Integer>();
	map.put("Java", 90);
	map.put("Angular", 80);
	map.put("React", 65);
	map.put("PLSQL", 90);
	assertEquals(Arrays.asList("Java", "PLSQL", "Angular"), myLanguages(map));
    }

    public static List<String> myLanguages(final Map<String, Integer> results) {
	var map = new TreeMap<Integer, List<String>>(Comparator.reverseOrder());
	results.forEach((m, n) -> map.merge(n, new ArrayList<>(Collections.singletonList(m)), (t, u) -> {
	    t.addAll(u);
	    return t;
	}));

	var result = new ArrayList<String>();
	map.forEach((t, u) -> {
	    if (t >= 60)
		result.addAll(u);
	});
	return result;
    }
}
