import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsApp {
	public static void main(String[] args) {
		// Create list of Integers
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(6);
		list.add(8);
		// Print list
		System.out.println("ArrayList");
		printCollection(list);
		System.out.println("");
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list);

		// Create set of Integers
		Set<Integer> set = new TreeSet<Integer>();
		set.addAll(list);
		// Print set
		System.out.println("Set");
		printCollection(set);
		System.out.println("");

		// Remove evens correct
		removeEvens(list);
		// Print list
		System.out.println("List, no evens");
		printCollection(list);
		System.out.println("");
		
		// Call generic algorithm on list to find less than or equal to 7 elements
		int num7 = MyAlgo.countMatches(list2, (Integer) 7, new GreaterThanIntegerComparator());
		System.out.println("In the list there were " + num7 + " values less than or equal to 7");
		
		// Call generic algorithm on set to find equal to 5 elements
		int num5 = MyAlgo.countMatches(set, (Integer) 5, new StandardIntegerComparator());
		System.out.println("In the set there were " + num5 + " values equal to 5");
		

	}
	
		
	public static<E> void printCollection(Collection<E> coll) {
		Iterator<E> i = coll.iterator();
		
		while (i.hasNext()) {
			E e = i.next();
			System.out.print(e.toString() + " ");
		}
		System.out.println("");
	}
		
	public static void removeEvens(List<Integer> nums) {
	    Iterator<Integer> i = nums.iterator();

	    while (i.hasNext()) {
	        Integer val = i.next();
	        if (val % 2 == 0) {
	            i.remove();
	        }
	    }
	}

}