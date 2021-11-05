import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// This loop reads all of the lines of input from System.in
		while (true) {
			// Read a line
			String line = reader.readLine();
			
			// Time to quit?
			if (line.toLowerCase().equals("quit")) {
				break;
			}
			
			// TODO: Check to see if line is a palindrome
			// and print "Palindrome" or "Not a palindrome"
			// to System.out.  Use a stack.
			
			// Hints:
			//  - Ignore characters that aren't letters:
			//    use the Character.isLetter(char) method to
			//    determine which characters are letters
			//  - The Character.toLowerCase(char) method converts
			//    a letter to lower case
			
			// Use the following java.util.Stack object
			// and java.util.Queue object
			Stack<Character> stack = new Stack<Character>();
			Queue<Character> queue = new LinkedList<Character>();
			boolean palindrome = true;
			for (int i = 0; i < line.length(); i++) {
				Character c = line.charAt(i);
				c = Character.toLowerCase(c);
				if (Character.isLetter(c)) {
					stack.push(c);
					queue.add(c);
				}
			}
			while (!stack.isEmpty() && !queue.isEmpty()) {
				if (stack.pop() != queue.remove() && palindrome) {
					palindrome = false;
					System.out.println("Not a palindrome");
				}
			}
			if (palindrome) {
				System.out.println("Palindrome");
			}
		}
		reader.close();
	}
}
