import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithms {
	public static<E extends Comparable<E>> E findMin(Collection<E> c) {
//		E min = c.iterator().next();
//		for (E aVal : c) {
//			if (aVal.compareTo(min) < 0) {
//				min = aVal;
//			}
//		}
//		return min;

		Comparator<E> minComp = new AlgorithmComparator<E>();
		return Algorithms.findMin(c, minComp);
	}
	
	public static<E> E findMin(Collection<E> c, Comparator<E> comp) {
		E min = c.iterator().next();
		for (E aVal : c) {
			if (comp.compare(aVal, min) < 0) {
				min = aVal;
			}
		}
		return min;
	}

	public static<E extends Comparable<E>> E findMax(Collection<E> c) {
//		E max = c.iterator().next();
//		for (E aVal : c) {
//			if (aVal.compareTo(max) > 0) {
//				max = aVal;
//			}
//			System.out.println(aVal.compareTo(max));
//		}
//		return max;

		Comparator<E> maxComp = new FlipComparator<>(new AlgorithmComparator<E>());
		return Algorithms.findMin(c, maxComp);
	}
	
	public static<E> E findMax(Collection<E> c, Comparator<E> comp) {
//		E max = c.iterator().next();
//		for (E aVal : c) {
//			if (comp.compare(aVal, max) > 0) {
//				max = aVal;
//			}
//		}
//		return max;

		Comparator<E> maxComp = new FlipComparator<>(comp);
		return Algorithms.findMin(c, maxComp);
	}
	
	public static<E> int sequentialSearch(List<E> list, E searchVal) {
		for (Iterator<E> i = list.iterator(); i.hasNext(); ) {
			E val = i.next();
			if (val.equals(searchVal)) {
				return list.indexOf(val);
			}
		}
		return -1;
	}
}
