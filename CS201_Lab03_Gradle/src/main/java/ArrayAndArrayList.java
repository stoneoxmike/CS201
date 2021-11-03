import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayAndArrayList {
	/**
	 * Using the given Scanner object,
	 * read in the given number of integer values
	 * and return them in an array.
	 * 
	 * @param keyboard    the Scanner object to use
	 * @param numElements the number of integer values to read
	 * @return an array containing the integer values read from the keyboard
	 */
	public static int[] readArray(Scanner keyboard, int numElements) {
		int[] reference = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			reference[i] = keyboard.nextInt();
		}
		return reference;
	}
	
	/**
	 * Print out the values of all of the elements in the
	 * given array.
	 * 
	 * @param arr an array
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * Reverse the elements of the given array.
	 * 
	 * @param arr an array
	 */
	public static void reverseArray(int[] arr) {
		int[] revArr = new int[arr.length];
		int j = arr.length;
		// places each element in a temp array in reverse order
		for (int i = 0; i < arr.length; i++) {
			revArr[j - 1] = arr[i];
			j = j - 1;
		}
		// places each element from temp array in original array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = revArr[i];
		}
	}
	
	/**
	 * Using the given Scanner object,
	 * read in the given number of integer values
	 * and return them in an ArrayList.
	 * 
	 * @param keyboard    the Scanner object to use
	 * @param numElements the number of integer values to read
	 * @return an ArrayList containing the integer values read from the keyboard
	 */
	public static ArrayList<Integer> readArrayList(Scanner keyboard, int numElements) {
		ArrayList<Integer> reference = new ArrayList<>();
		for (int i = 0; i < numElements; i++) {
			reference.add(keyboard.nextInt());
		}
		return reference;
	}
	
	/**
	 * Print out the values of all of the elements in the
	 * given ArrayList.
	 * 
	 * @param arrList an ArrayList
	 */
	public static void printArrayList(ArrayList<Integer> arrList) {
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i));
		}
	}
	
	/**
	 * Reverse the elements of the given ArrayLis.
	 * 
	 * @param arrList an ArrayList
	 */
	public static void reverseArrayList(ArrayList<Integer> arrList) {
		ArrayList<Integer> revArrList = new ArrayList<>();
		// places each element in a temp arrayList in reverse order
		for (int i = arrList.size() - 1; i >= 0; i--) {
			revArrList.add(arrList.get(i));
		}
		// places each element from temp arrayList in original arrayList
		for (int i = 0; i < arrList.size(); i++) {
			arrList.set(i, revArrList.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int selection = -1;
		
		int[] a;
		ArrayList<Integer> aL;
		
		int numElements;
		
		while(selection != 0) {
			System.out.println("Select: \n1 Array\n2 ArrayList\n0 Quit");
			selection = keyboard.nextInt();
			
			if (selection == 1) {
				System.out.println("How many values? ");
				numElements = keyboard.nextInt();
		
				System.out.println("Please enter " + numElements + " values:");
				a = readArray(keyboard, numElements);
		
				System.out.println("You entered the following values:");
				printArray(a);
		
				System.out.println("Now I am going to reverse the array for you...");
				reverseArray(a);
		
				System.out.println("Here are the reversed array values:");
				printArray(a);
			} else if (selection == 2) {
				System.out.println("How many values? ");
				numElements = keyboard.nextInt();
		
				System.out.println("Please enter " + numElements + " values:");
				aL = readArrayList(keyboard, numElements);
		
				System.out.println("You entered the following values:");
				printArrayList(aL);
		
				System.out.println("Now I am going to reverse the ArrayList for you...");
				reverseArrayList(aL);
		
				System.out.println("Here are the reversed ArrayList values:");
				printArrayList(aL);
			
			}
		}
		keyboard.close();
		System.out.println("Goodbye");
	}
}
