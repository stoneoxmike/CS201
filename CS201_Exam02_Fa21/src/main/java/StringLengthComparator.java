import java.util.Comparator;
import java.util.Locale;

public class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		// TODO: Compare strings by length then lexicographically
		if (s1.length() != s2.length()) {
			return s1.length() - s2.length();
		} else {
			s1 = s1.toLowerCase(Locale.ROOT);
			s2 = s2.toLowerCase(Locale.ROOT);
			return s1.compareTo(s2);
		}

	}

}
