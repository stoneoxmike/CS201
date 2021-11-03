import java.util.Comparator;
import java.util.Locale;

public class CaseInsensitiveStringComparator implements Comparator<String> {
    public int compare(String left, String right) {
        left = left.toLowerCase(Locale.US);
        right = right.toLowerCase(Locale.US);
        return left.compareTo(right);
    }
}
