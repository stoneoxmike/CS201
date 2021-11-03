public class Fib {
	public static int fibNaive(int n) {
		if(n == 1 || n == 0) {
			return n;
		}

		return fibNaive(n-2) + fibNaive(n-1);
	}
	
	public static int fibMemo(int n) {
		return fibMemoWork(n, new int[n+1]);
	}

	private static int fibMemoWork(int n, int[] memo) {
		if(n == 1 || n == 0) {
			return n;
		}
		
		int ans = memo[n];
		if (ans == 0) {
			ans = fibMemoWork(n-2,memo) + fibMemoWork(n-1,memo);
			memo[n] = ans;
		}
		
		return ans;

	}

	public static int fibDynamic(int n) {
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i-2] + memo[i-1];
		}
		
		return memo[n];
	}
}