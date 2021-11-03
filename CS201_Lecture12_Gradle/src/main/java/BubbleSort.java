import java.util.Comparator;

public class BubbleSort {
	// Bubble sort using Comparable interface objects
	public static<E extends Comparable<E>> void bubbleSort(E[] arr) {
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = 1; i <= j; i++) {
				if (arr[i-1].compareTo(arr[i]) > 0) {
					E tmp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}
	
	// Bubble sort using functor
	public static<E> void bubbleSort(E[] arr, Comparator<E> comp) {
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = 1; i <= j; i++) {
				if (comp.compare(arr[i-1],arr[i]) > 0) {
					E tmp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}

}