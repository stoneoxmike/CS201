import java.util.ArrayList;
import java.util.LinkedList;

import junit.framework.TestCase;

public class ReverseTest extends TestCase {
	private ArrayList<String> names;
	private LinkedList<Integer> nums;
	
	@Override
	protected void setUp() throws Exception {
		names = new ArrayList<String>();
		names.add("Alice");
		names.add("Bob");
		names.add("Carla");
		names.add("Delores");
		names.add("Eli");
		
		nums = new LinkedList<Integer>();
		nums.add(42);
		nums.add(17);
		nums.add(121);
		nums.add(44);
		nums.add(412);
		nums.add(101);
	}
	
	public void testReverse() throws Exception {
		Reverse.reverseUsingGetAndSet(names);
		Reverse.reverseUsingGetAndSet(nums);
		
		assertEquals("Eli", names.get(0));
		assertEquals("Delores", names.get(1));
		assertEquals("Carla", names.get(2));
		assertEquals("Bob", names.get(3));
		assertEquals("Alice", names.get(4));
		
		assertEquals((Integer) 101, nums.get(0));
		assertEquals((Integer) 412, nums.get(1));
		assertEquals((Integer) 44, nums.get(2));
		assertEquals((Integer) 121, nums.get(3));
		assertEquals((Integer) 17, nums.get(4));
		assertEquals((Integer) 42, nums.get(5));
	}
}
