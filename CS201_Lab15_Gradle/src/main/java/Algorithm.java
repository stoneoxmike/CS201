import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	/**
	 * Return a List containing the interleaving of collections a and b,
	 * using Iterators to retrieve the elements from each collection.
	 * 
	 * The returned list should contain the first element of a,
	 * first element of b,  second element of a, second element of b, etc.
	 * If one of the collections run out of elements, then the method should
	 * add all of the elements in the non-empty collection.
	 * (See the JUnit tests.)
	 * 
	 * @param a  the first collection
	 * @param b  the second collection
	 * @return a List containing the interleaving of the elements of collections a and b
	 */
	public static<E> List<E> interleave(Collection<E> a, Collection<E> b) {
		List<E> result = new ArrayList<E>();
		
		Iterator<E> aIter = a.iterator();
		Iterator<E> bIter = b.iterator();
		
		// TODO - implement
		while (aIter.hasNext() || bIter.hasNext()) {
			if (aIter.hasNext()) {
				result.add(aIter.next());
			}
			if (bIter.hasNext()) {
				result.add(bIter.next());
			}
		}

		return result;
	}
	
	/**
	 * Return a List containing all of the elements of two sorted lists,
	 * a and b, in sorted order.  E, the element type, implements the
	 * Comparable<E> interface, so you can call compareTo to compare objects.
	 * 
	 * Use PushbackIterators to get elements from the lists a and b.
	 * A PushbackIterator is like a regular Iterator, except that it has a
	 * pushback(E) method which is like an "undo" method for next(): whatever
	 * value is passed to pushback(E) will be the next value returned by
	 * next().
	 * 
	 * Algorithm: until both aIter and bIter have no more elements to return
	 * - if both aIter and bIter have a next element, than get an element
	 *   from each, determine which is smaller,
	 *   add it to the result list, and pushback the other (larger) element
	 * - if a has no more elements, get an element from b's iterator and
	 *   add it to the result lsit
	 * - if b has no more elements, get an element from a's iterator and
	 *   add it to the result list
	 * 
	 * @param a a sorted List
	 * @param b another sortedList
	 * @return a sorted List containing all of the elements from a and b
	 */
	public static<E extends Comparable<E>> List<E> mergeSortedLists(List<E> a, List<E> b) {
		List<E> result = new ArrayList<E>();
		
		PushbackIterator<E> aIter = new PushbackIterator<E>(a.iterator());
		PushbackIterator<E> bIter = new PushbackIterator<E>(b.iterator());
		
		// TODO: implement
		while (aIter.hasNext() || bIter.hasNext()) {
			if (aIter.hasNext() && bIter.hasNext()) {
				E aVal = aIter.next();
				E bVal = bIter.next();
				if (aVal.compareTo(bVal) > 0) {
					result.add(bVal);
					aIter.pushback(aVal);
				} else {
					result.add(aVal);
					bIter.pushback(bVal);
				}
			}
			if (aIter.hasNext() && !bIter.hasNext()) {
				result.add(aIter.next());
			}
			if (bIter.hasNext() && !aIter.hasNext()) {
				result.add(bIter.next());
			}
		}
		
		return result;
	}
}
