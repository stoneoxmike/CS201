import java.util.Scanner;

public class EstimatePi {
	private static final int NUM_POINTS = 100000000;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How many computation threads? ");
		int numThreads = keyboard.nextInt();

		double a = 0.0; // estimated area
		
		double begin = System.currentTimeMillis();
		
		if (numThreads == 1) {
			// TODO: sequential computation
			PiTask piTask = new PiTask(NUM_POINTS);
			Thread thread = new Thread(piTask);
			thread.start();
			try {
				for (int i = 0; i < 2; i++) {
					thread.join();
				}
			} catch (InterruptedException e) {
				System.err.println("A thread was interrupted");
			}
			a = (double) piTask.getCount()/(double) NUM_POINTS;
		} else if (numThreads == 2) {
			// TODO: parallel computation using 2 threads
			PiTask[] tasks = new PiTask[2];
			for (int i = 0; i < 2; i++) {
				tasks[i] = new PiTask(NUM_POINTS/2);
			}
			begin = System.currentTimeMillis();
			Thread[] threads = new Thread[2];
			for (int i = 0; i < 2; i++) {
				threads[i] = new Thread(tasks[i]);
				threads[i].start();
			}
			try {
				for (int i = 0; i < 2; i++) {
					threads[i].join();
				}
			} catch (InterruptedException e) {
				System.err.println("A thread was interrupted");
			}
			a = ((double) tasks[1].getCount() + (double) tasks[0].getCount())/(double) NUM_POINTS;
		} else {
			throw new IllegalArgumentException("only 1 or 2 threads are allowed");
		}
		
		double end = System.currentTimeMillis();
		
		System.out.println("Computation took " + (end - begin) + " milliseconds");

		// TODO: compute estimate of pi, print it
		System.out.println("Pi is estimated to be " + a * 4.0);
	}
}
