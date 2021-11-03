import java.util.Comparator;

public class StandardIntegerComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a < b) {
        	return -1;
        } else if (a > b) {
        	return 1;
        }
        return 0;
    }
}
