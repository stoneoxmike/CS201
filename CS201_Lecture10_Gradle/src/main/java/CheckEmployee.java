public class CheckEmployee {
	public static void main(String[] args) {
		Employee jDoe = new Employee("Jane", "Doe", 50000);
		Employee kDoe = new Employee("Kevin", "Doe", 60000);
		Employee jbDoe = new Employee("Jane", "Doe", 50000);
		Employee jmDoe = jDoe;
		
		// Test jDoe and kDoe
		if (jDoe.compareTo(kDoe) == 0) {
			System.out.println("JDoe and KDoe are the same");
		} else {
			System.out.println("JDoe and KDoe are not the same");		
		}

		// Test jDoe and jbDoe
		if (jDoe.compareTo(jbDoe) == 0) {
			if (jDoe == jbDoe) {
				System.out.println("JDoe and JBDoe are the same person");
			} else {
				System.out.println("JDoe and JBDoe are different people with the same information");			
			}
		} else {
			System.out.println("JDoe and JBDoe are not the same");		
		}
		
		// Test jDoe and jmDoe
		if (jDoe.compareTo(jmDoe) == 0) {
			if (jDoe == jmDoe) {
				System.out.println("JDoe and JMDoe are the same person");
			} else {
				System.out.println("JDoe and JMDoe are different people with the same information");			
			}
		} else {
			System.out.println("JDoe and JMDoe are not the same");		
		}

	}
}
