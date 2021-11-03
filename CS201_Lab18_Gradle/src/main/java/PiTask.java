import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class PiTask implements Runnable {
	// This is used to ensure that each PiTask's Random object
	// gets a different seed, ensuring that each PiTask gets
	// a different sequence of random numbers.
	private static AtomicLong taskCount = new AtomicLong();
	
	private int numRandomPointsToCompute;
	private Random rand;
	private int count;
	
	public PiTask(int numRandomPointsToCompute) {
		this.numRandomPointsToCompute = numRandomPointsToCompute;
		this.rand = new Random(123L + taskCount.getAndIncrement());
		this.count = 0;
	}
	
	@Override
	public void run() {
		// TODO: compute the number of random points indicated by numRandomPointsToCompute,
		// count how many fall within the circle
		
	}
	
	// This method returns the count of random points that fell within the circle
	// once the computation is done.
	public int getCount() {
		return count;
	}
}
