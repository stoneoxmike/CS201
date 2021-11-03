import java.io.*;
import java.util.Scanner;

public class ReadFile {
	public static final String PATH = "CS201_Lab07_Gradle/";

	//
	// Requirements:
	// - do not add "throws IOException" (or any other throws clause)
	//   to the main() method
	// - do not test whether or not the requested file exists
	//   before trying to open it
	// - use a try/finally block to make sure that the
	//   file reader or input stream is closed
	//
	public static void main(String[] args) {
		// Prompt the user to enter a filename and concatenate it with path
		System.out.print("Which file? ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = PATH + keyboard.next();
		try {
			readFile(fileName);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void readFile(String fileName) throws IOException {
		FileReader fileReader;
		BufferedReader reader;
		fileReader = new FileReader(fileName);
		reader = new BufferedReader(fileReader);
		try {
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} finally {
			reader.close();
		}
	}
}
