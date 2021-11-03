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

		// Create set of Integers
		Set<Integer> set = new TreeSet<Integer>();
		set.addAll(list);
		// Print set
		System.out.println("Set");
		printCollection(set);
		System.out.println("");
		
		// Check list contains
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter integer to check ");
		Integer val = keyboard.nextInt();
		System.out.println("List contains " + list.contains(val));
		System.out.println("");
		
		// Check set contains
		System.out.println("Set contains " + set.contains(val));
		System.out.println("");
		
		
		// Duplicate list
		List<Integer> list2 = new LinkedList<Integer>();
		list2.addAll(list);
		// Print list2
		System.out.println("LinkedList");
		printCollection(list);
		System.out.println("");
		
		// Remove evens incorrect
		removeEvensIncorrect(list);
		// Print list
		System.out.println("ArrayList, no evens");
		printCollection(list);
		System.out.println("");
		

		// Remove evens correct
		removeEvens(list2);
		// Print list
		System.out.println("LinkedList, no evens");
		printCollection(list2);
		System.out.println("");

	}
	
	
//	public static<E> void printCollectionIncorrect(Collection<E> coll) {
//		for (int i = 0; i < coll.size(); i++) {
//			E e = coll.get(i);
//			System.out.print(e.toString() + " ");			
//		}
//		System.out.println("");
//	}
	
	public static<E> void printCollection(Collection<E> coll) {
		Iterator<E> i = coll.iterator();
		
		while (i.hasNext()) {
			E e = i.next();
			System.out.print(e.toString() + " ");
		}
		System.out.println("");
	}
	
	public static void removeEvensIncorrect(List<Integer> nums) {
	    for (int i = 0; i < nums.size(); i++) {
	        if (nums.get(i) % 2 == 0) {
	            nums.remove(i);
	        }
	    }
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