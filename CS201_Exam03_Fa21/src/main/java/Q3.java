// CS201 Exam 3 Fall 2021

import java.util.*;

public class Q3 {
	public static Map<String, Integer> condense(List<String> coll) {
		Map<String, Integer> map = new HashMap<>();
		for (String str : coll) {
			if (map.containsKey(str.toLowerCase())) {
				map.put(str.toLowerCase(), map.get(str.toLowerCase()) + 1);
			} else {
				map.put(str.toLowerCase(), 1);
			}
		}
		return map;
	}
}
