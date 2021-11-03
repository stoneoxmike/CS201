public class ParallelApp {
	public static final int ARRAY_SIZE = 134217728;  // (2^27)
	public static final int MAX_NUM_THREADS = 1024;
	
	
	public static void main(String[] args) {
		// Create array of Integers containing all 1's
		Integer[] ints = new Integer[ARRAY_SIZE];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = 1;
		}
		
		// Loop for different number of threads
		for (int numThreads = 1; numThreads <= MAX_NUM_THREADS; numThreads*=2 ) {
			// Create task array
			SumTask[] tasks = new SumTask[numThreads];

			// Determine number of points per task
			// Assume evenly divisible
			int numVals = ARRAY_SIZE/numThreads;

			// Allocate tasks
			for (int i = 0; i < numThreads; i++) {
				tasks[i] = new SumTask(ints, i*numVals, (i+1)*numVals);
			}
			
			// Create thread array
			Thread[] threads = new Thread[numThreads];
			
			// Benchmark parallel computation
			System.gc();
			double begin = System.currentTimeMillis();
			// Assign tasks to threads and start threads
			for (int i = 0; i < numThreads; i++) {
				threads[i] = new Thread(tasks[i]);
				threads[i].start();
			}
			
			// Wait for all threads to finish
			try {
				for (int i = 0; i < numThreads; i++) {
					threads[i].join();
				}
			} catch (InterruptedException e) {
				System.out.println("Computation was interrupted");
			}
			
			int total = 0;
			for (int i = 0; i < numThreads; i++) {
				total += tasks[i].getSum();
			}
			
			double end = System.currentTimeMillis();
			
			System.out.println(numThreads + " threads took " + (end - begin) + " milliseconds for final sum " + total);
		}

	}
}