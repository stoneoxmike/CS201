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
		} else if (numThreads == 2) {
			// TODO: parallel computation using 2 threads
		} else {
			throw new IllegalArgumentException("only 1 or 2 threads are allowed");
		}
		
		double end = System.currentTimeMillis();
		
		System.out.println("Computation took " + (end - begin) + " milliseconds");

		// TODO: compute estimate of pi, print it
	}
}
