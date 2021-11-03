public class Q2 {
	public static<E extends Comparable<E>> boolean isDecreasing(E[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i+1]) <= 0) {
				return false;
			}
		} return true;
	}
}
