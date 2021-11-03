import java.util.Scanner;

public class FibApp {	
	public static void main(String[] args) {
		long begin, end;
		int result;
		
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();

		while (n > 0) {
			if (n < 50) {
				try {
					System.gc();
					begin = System.currentTimeMillis();
					result = Fib.fibNaive(n);
					end = System.currentTimeMillis();
					System.out.println("Naive fib("+n+")=" + result + "[" + (end-begin) + " ms]");
				} catch (StackOverflowError e) {
					System.out.println("Naive stack overflow");
				}
			} else {
				System.out.println("n too large for naive");
			}
				
			try {
				System.gc();
				begin = System.currentTimeMillis();
				result = Fib.fibMemo(n);
				end = System.currentTimeMillis();
				System.out.println("Memo fib("+n+")=" + result + "[" + (end-begin) + " ms]");
			} catch (StackOverflowError e) {
				System.out.println("Memoization stack overflow");
			}
			
		    System.gc();
		    begin = System.currentTimeMillis();
		    result = Fib.fibDynamic(n);
		    end = System.currentTimeMillis();
		    System.out.println("Dynamic fib("+n+")=" + result + "[" + (end-begin) + " ms]");
	
		    n = keyboard.nextInt();
		}
	}

}