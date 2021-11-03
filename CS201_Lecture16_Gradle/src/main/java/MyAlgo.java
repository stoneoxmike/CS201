import java.util.Collection;
import java.util.Comparator;

public class MyAlgo {
	public static <E> int countMatches(Collection<E> c, E searchVal, Comparator<E> comp) {
		int count = 0;
		for (E e : c) {
			if (comp.compare(e,searchVal)==0) {
				count++;
			}
		}
	
		return count;
	} 
}