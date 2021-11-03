import java.util.List;

public class Reverse {
	public static<E> void reverseUsingGetAndSet(List<E> list) {
		//
		// TODO: reverse the elements of the list
		// Important: use the get and set methods to access and
		// modify the list's elements.
		//
		// Example algorithm: for each element in the first half
		// of the list, swap the element with its "mirror image"
		// element in the second half of the list.
		//
//		for (E val : list.subList(0, list.size()/2)) {
//			E swap = list.get(list.size() - list.indexOf(val) - 1);
//			list.set(list.size() - list.indexOf(val) - 1, list.get(list.indexOf(val)));
//			list.set(list.indexOf(val), swap);
//		}

		for (int i = 0; i < list.size()/2; i++) {
			E swap = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, swap);
		}
	}
}
