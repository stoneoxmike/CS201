import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;

public class WordCount {
	private static final Pattern wordPattern =
		Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
	
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Read which file? ");
		String fileName = keyboard.next();
		
		// TODO: read all of the words in the file,
		//       storing occurrence counts for each word
		//       in a map.  After the file has been
		//       fully read, print a histogram
		//       showing the frequencies of each
		//       word, in alphabetical order.

		BufferedReader reader = new BufferedReader(new FileReader("./CS201_Lab20_Gradle/" + fileName));
		
		// This loop reads each line of the input file
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			
			Matcher m = wordPattern.matcher(line);
			
			// This loop finds each work in the current line
			while (m.find()) {
				String word = m.group(0);
				word = word.toLowerCase();
				
				// TODO: do something with word
			}
		}
	}
}
