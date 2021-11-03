import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Benchmark {
	private static final int CHUNK = 10000;
	
	public static void main(String[] args) {
		//
		// TODO: measure how long it takes to reverse
		// lists of length 10000, 20000, 30000, etc.
		// up to 100,000, for both ArrayList and LinkedList.
		// Print each data point in the format
		//
		//     numElements,arrayListTime,linkedListTime
		//
		
		for (int size = CHUNK; size <= CHUNK * 10; size += CHUNK) {
			List<Integer> arrList = createArrayList(size);
			List<Integer> linkedList = createLinkedList(size);

			// TODO: measure how long it takes to reverse each list,
			// output one data point to System.out
			System.gc();
			long startArr = System.currentTimeMillis();
			Reverse.reverseUsingGetAndSet(arrList);
			long endArr = System.currentTimeMillis();
			long elapsedArr = endArr - startArr;

			System.gc();
			long startLinked = System.currentTimeMillis();
			Reverse.reverseUsingGetAndSet(linkedList);
			long endLinked = System.currentTimeMillis();
			long elapsedLinked = endLinked - startLinked;
			System.out.println(size + ", " + elapsedArr + ", " + elapsedLinked);
		}
	}
	
	private static List<Integer> createArrayList(int numElements) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < numElements; i++) {
			l.add((Integer) 42);
		}
		return l;
	}

	private static List<Integer> createLinkedList(int numElements) {
		List<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i < numElements; i++) {
			l.add((Integer) 42);
		}
		return l;
	}
}
