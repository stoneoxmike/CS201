import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prerequisite {
	public static List<String> prereqNotMet(Map<String,Double> prereqGrades, List<String> roster) {
		Set<String> notMet = new HashSet<String>();
		
		Set<String> names = prereqGrades.keySet();
		for(String name : names) {
			if (prereqGrades.get(name) < 2.0) {
				notMet.add(name);
			}
		}
		
		List<String> toRemove = new ArrayList<String>();
		for (String name : roster) {
			if (notMet.contains(name)) {
				toRemove.add(name);
			}
		}
		
		return toRemove;
	}
}