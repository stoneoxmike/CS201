import java.util.*;

public class Q3 {
	public static<E> List<E> chopN(List<E> list, int n) {
		List<E> returnList = new ArrayList<E>();
		for (E val : list) {
			if ((list.indexOf(val) + 1) % n == 0) {
				returnList.add(val);
			}
		}
		for (E val : returnList) {
			list.remove(val);
		}
		return returnList;
	}
}
