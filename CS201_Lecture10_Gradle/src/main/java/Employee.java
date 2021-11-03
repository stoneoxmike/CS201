public class Employee implements Comparable {
	private String lastName;
	private String firstName;
	private int salary;
	
	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int compareTo(Object o) {
		Employee other = (Employee) o;

		int cmp;
		// compare last names first
		cmp = this.lastName.compareTo(other.lastName);
		if (cmp != 0) {
			return cmp;
		}

		// last names are the same - compare first names second
		cmp = this.firstName.compareTo(other.firstName);
		if (cmp != 0) {
			return cmp;
		}

		// last and first names are the same - compare salaries
		if (this.salary < other.salary) {
			return -1;
		} else if (this.salary == other.salary) {
			return 0;
		} else {
			return 1;
		}
	}
}
