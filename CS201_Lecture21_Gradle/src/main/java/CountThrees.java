public class CountThrees {
	// Recursively count the number of "3" digits in an int value.
	// The approach is to treat 0 as the base case (containing 0 "3" digits).
	// The recursive case determines whether or not the last digit is
	// a "3" and recursively computing the number of "3" digits in the
	// int value consisting of all digits *except* the last digit.	
	public static int countThreesNaive(int n) {
		// Base case
		if (n == 0) { return 0; }
		
		// Get last digit
		int lastDigit = n % 10;
		int addThree = 0;
		
		// If digit is a three then add one
		if (lastDigit == 3) {
			addThree = 1;
		}
		
		// Count threes in all but last digit plus last digit value
		return countThreesNaive(n / 10) + addThree;
	}

	// Tail-recursive version of countThrees
	public static int countThreesTail(int n) {
		return countThreesTailWork(n, 0);
	}

	// Tail recursive worker method
	private static int countThreesTailWork(int n, int accum) {
		// Return answer when base case is reached
		if (n == 0) { return accum; }
		
		// Get last digit
		int lastDigit = n % 10;
		
		// If digit is a 3 then increment accumulator
		if (lastDigit == 3) {
			accum = accum + 1;
		}
		
		// Count threes in all but last digit
		return countThreesTailWork(n / 10, accum);
	}
	
}