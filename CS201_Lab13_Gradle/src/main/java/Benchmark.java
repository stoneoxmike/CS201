public class  Benchmark {
	public static void main(String[] args) {
		// TODO: benchmark removing all elements from an ArrayList
		// using two techniques
		//
		//   - repeatedly removing the last element
		//   - repeatedly removing the first element
		//
		// Measure the time to remove 10,000, 20,000, etc. elements,
		// up to 100,000 elements, for each technique.

		for (int i = 1; i <= 10; i++) {
			ArrayList<Integer> arr = create(i*10000);
			System.gc();
			int size = arr.size();
			long start = System.currentTimeMillis();
			for (int j = size; j > 0; j--) {
				arr.remove(arr.size()-1);
			}
			long end = System.currentTimeMillis();
			long elapsed = end - start;
			ArrayList<Integer> arr2 = create(i*10000);
			System.gc();
			int size2 = arr2.size();
			long start2 = System.currentTimeMillis();
			for (int j = size2; j > 0; j--) {
				arr2.remove(0);
			}
			long end2 = System.currentTimeMillis();
			long elapsed2 = end2 - start2;
			System.out.println(i*10000+","+elapsed+","+elapsed2);
		}
	}

	public static ArrayList<Integer> create(int count) {
		ArrayList<Integer> a = new ArrayList<Integer>(count);
		for (int i = 0; i < count; i++) {
			a.add((Integer) 42);
		}
		return a;
	}
}

