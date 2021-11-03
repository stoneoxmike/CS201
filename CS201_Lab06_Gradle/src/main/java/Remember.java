import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Remember {
	public static final String PATH = "CS201_Lab06_Gradle/";

	public static void main(String[] args) throws IOException {
		String fileName = "name.txt";

		Scanner keyboard = new Scanner(System.in);
		File f = new File(PATH, fileName);

		String name;
		String newName;
		if (f.exists()) {
			FileReader fileReader = new FileReader(f);
			BufferedReader reader = new BufferedReader(fileReader);
			name = reader.readLine();
			reader.close();
			System.out.println("The last person to run the program was " + name);
			System.out.print("What is your name? ");
			newName = keyboard.next();
			System.out.println("Ok, " + newName + ", I'm writing your name to a file");
			keyboard.close();
		} else {
			System.out.println("No one has run this program before!");
			System.out.print("What is your name? ");
			newName = keyboard.next();
			System.out.println("Ok, " + newName + ", I'm writing your name to a file");
		}
		FileWriter writer = new FileWriter(f);
		writer.write(newName);
		writer.close();
	}
}
