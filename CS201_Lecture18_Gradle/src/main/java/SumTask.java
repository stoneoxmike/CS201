public class SumTask implements Runnable {
	private Integer[] arr;
	private int startIdx;
	private int endIdx;
	private long sum;
	
	// Constructor to store array reference and
	// indicies to sum over
	public SumTask(Integer[] arr, int startIdx, int endIdx) {
		this.arr = arr;
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		sum = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = startIdx; i < endIdx; i++) {
			sum += arr[i];
		}
	}
	
	public long getSum() {
		return sum;
	}

}