public class NaiveRecursive implements ComputeBinomialCoefficient {
	public int compute(int n, int k) {
		// TODO: implement
		if (k == 0 || k == n) {
			return 1;
		}
		return compute(n-1,k) + compute(n-1,k-1);
	}
	
	public String toString() {
		return "Naive Recursive";
	}
}
