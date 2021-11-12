public class Recursion {
	//
	// Return the factorial of the parameter n.
	// The factorial of n is defined as 
	//
	//    1 * 2 * 3 * ... * (n-1) * n
	//
	// Assume that n is positive.
	//
	// Examples:
	//     factorial(3) returns 6
	//     factorial(4) returns 24
	//     factorial(5) returns 120
	//
	public static int factorial(int n) {
		if (n == 1) { return 1; }
		return factorial(n - 1) * n;
	}
	
	//
	// Return a string which reverses the characters
	// of the given string.
	//
	// Examples:
	//     reverseString("abc") returns "cba"
	//     reverseString("adanishcustard") returns "dratsuchsinada"
	//
	// Hint: use the charAt(int) and substring(int,int) methods
	// to divide the string into two parts.
	//
	public static String reverseString(String s) {
		if (s.length() == 1) { return s; }
		return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
	}
	
	//
	// Return the number of even digits in the decimal representation
	// of n.
	//
	// Examples:
	//     countEvenDigits(0) returns 1
	//     countEvenDigits(42) returns 2
	//     countEvenDigits(131) returns 0
	//     countEvenDigits(90125) returns 2
	//
	// Hint: n % 10 is the value of the rightmost digit.
	// n / 10 contains all of the digits except the rightmost
	// digit.
	//
	public static int countEvenDigits(int n) {
		if (n / 10 == 0) { return -(n%2-1); }
		int lastDigit = n%10;
		int count = 0;
		if (lastDigit%2 == 0) {
			count = 1;
		}
		return countEvenDigits(n / 10) + count;
	}
	
	//
	// Convert given string, which contains a sequence of
	// decimal digits, to the integer value represented by
	// the sequence of digits.
	//
	// You don't need to handle strings beginning with "-"
	// (representing a negative value.)
	// 
	// Examples:
	//     stringToInt("42") returns 42
	//     stringToInt("131") returns 131
	//
	// Hint: use the charAt(int) and substring(int,int) methods
	// to divide the string into two parts.
	//
	public static int stringToInt(String s) {
		if (s.length() == 0) { return 0; }
		return Character.digit(s.charAt(s.length() - 1), 10) + stringToInt(s.substring(0, s.length() - 1)) * 10;
	}
}
