import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PrereqApp {
	public static void main(String[] args) {
		Map<String,Double> cs101Grades = new TreeMap<String,Double>();
		
		cs101Grades.put("g", 1.0);
		cs101Grades.put("a", 2.0);
		cs101Grades.put("h", 3.5);
		cs101Grades.put("e", 2.5);
		cs101Grades.put("d", 0.0);
		cs101Grades.put("b", 1.0);
		cs101Grades.put("c", 3.0);
		cs101Grades.put("f", 4.0);


		Set<String> cs101Students = cs101Grades.keySet();
		
		for (String student : cs101Students) {
			System.out.print(student + " ");
		}
		System.out.println("");
		
		
		List<String> cs201Roster = new ArrayList<String>();
		cs201Roster.addAll(Arrays.asList("g","f","b","c","a","e"));

		List<String> notMet = Prerequisite.prereqNotMet(cs101Grades, cs201Roster);
		
		System.out.println("Students not meeting prerequisite:");
		for (String name : notMet) {
			System.out.println(name);
			cs201Roster.remove(name);
		}
		
		System.out.println("Updated CS201 Roster:");
		for(String name : cs201Roster) {
			System.out.println(name);
		}
		
	} 
}