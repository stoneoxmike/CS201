import java.util.Arrays;

public class Q1 {
	public static<E extends Comparable<E>> E findMedian(E[] arr) {
		Arrays.sort(arr);
		if (arr.length % 2 == 0) {
			return null;
		} else {
			return arr[(arr.length - 1)/2];
		}
		
	}
}
