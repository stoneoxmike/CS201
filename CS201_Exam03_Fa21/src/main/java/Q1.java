// CS201 Exam 3 Fall 2021

import java.util.*;

public class Q1 {
	public static<E extends Comparable<E>> List<E> outOfRange(Collection<E> coll, E low, E high) {
		List<E> returnList = new ArrayList<>();
		Iterator<E> iter = coll.iterator();
		while (iter.hasNext()) {
			E val = iter.next();
			if (val.compareTo(low) < 0 || val.compareTo(high) > 0) {
				returnList.add(val);
			}
		}
		return returnList;
	}
}
