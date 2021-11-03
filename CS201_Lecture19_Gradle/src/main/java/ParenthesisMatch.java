import java.util.Scanner;

public class ParenthesisMatch {
	
	public static void main(String[] args) {		
		// Load array with random numbers
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter expression: ");
		String exp = keyboard.nextLine();
		keyboard.close();
		
		// Create stack
		MyStack<Character> stack = new MyStack<Character>();
		boolean matched = true;
		
		// Loop over expression
		for (int i = 0; i < exp.length(); i++) {
			// Get character
			char c = exp.charAt(i);
			
			// If open ( push on stack
			if (c == '(') {
				stack.push(c);
			}
			
			// If close ) check if stack is empty otherwise pop (
			if (c == ')') {
				if (stack.isEmpty()) {
					System.out.println("No matching )");
					matched = false;
					break;
				} else {
					stack.pop();
				}
			}
		}
		
		// Check that stack is empty at end
		if (!stack.isEmpty()) {
			System.out.println("Extra (");
			matched = false;
		}
		
		System.out.println("Expression match is: " + matched);
	
	}
}
