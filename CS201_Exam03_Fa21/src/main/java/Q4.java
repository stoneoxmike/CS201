// CS201 Exam 3 Fall 2021

public class Q4 {
//	public static int sumOfOdds(int n) {
//		if (n == 0) {
//			return 0;
//		}
//		int sum = 2*n - 1;
//		return sumOfOdds(n - 1) + sum;
//	}

	public static int sumOfOdds(int n) {
		return sumOfOddsWork(n, 0);
	}

	private static int sumOfOddsWork(int n, int sum) {
		if (n == 0) { return sum; }
		sum = sum + 2*n - 1;
		return sumOfOddsWork(n - 1, sum);
	}
}
