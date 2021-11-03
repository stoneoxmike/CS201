import java.util.Scanner;

public class RecurseApp {	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a value? ");
		int val = keyboard.nextInt();
		keyboard.close();

		int num3Naive = CountThrees.countThreesNaive(val);
		
		System.out.println("There are " + num3Naive + " 3s in " + val + " - naive");

		int num3Tail = CountThrees.countThreesTail(val);
		
		System.out.println("There are " + num3Tail + " 3s in " + val + " - tail");

	
	}

}