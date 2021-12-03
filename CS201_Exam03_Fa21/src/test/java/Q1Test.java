import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class Q1Test {
	private List<String> strList;
	private Set<String> strSet;
	private List<Integer> intList;
	private Set<Integer> intSet;
	
	@Before
	public void setUp() {
		strList = Arrays.asList("a", "b", "c", "A", "B", "C", "d", "D", "z", "ZZ");
		strSet = new TreeSet<String>();
		strSet.addAll(strList);
		
		intList = Arrays.asList(5, 3, 6, 9, 10, 19, 6, 2, 3);
		intSet = new TreeSet<Integer>();
		intSet.addAll(intList);
	}
	
	@Test
	public void testOutOfRangeStrList1() throws Exception {
		List<String> out = Q1.outOfRange(strList, "C", "c");
		assertEquals(4 , out.size());
		assertTrue(out.contains("A"));
		assertTrue(out.contains("B"));
		assertTrue(out.contains("d"));
		assertTrue(out.contains("z"));
	}

	@Test
	public void testOutOfRangeStrList2() throws Exception {
		List<String> out = Q1.outOfRange(strList, "Z", "ZZZ");
		assertEquals(9 , out.size());
		assertTrue(out.contains("a"));
		assertTrue(out.contains("b"));
		assertTrue(out.contains("c"));
		assertTrue(out.contains("A"));
		assertTrue(out.contains("B"));
		assertTrue(out.contains("C"));
		assertTrue(out.contains("d"));
		assertTrue(out.contains("D"));
		assertTrue(out.contains("z"));
	}

	@Test
	public void testOutOfRangeStrSet1() throws Exception {
		List<String> out = Q1.outOfRange(strSet, "D", "b");
		assertEquals(6 , out.size());
		assertTrue(out.contains("c"));
		assertTrue(out.contains("A"));
		assertTrue(out.contains("B"));
		assertTrue(out.contains("C"));
		assertTrue(out.contains("d"));
		assertTrue(out.contains("z"));
	}

	@Test
	public void testOutOfRangeStrSet2() throws Exception {
		List<String> out = Q1.outOfRange(strSet, "Z", "ZZZ");
		assertEquals(9 , out.size());
		assertTrue(out.contains("a"));
		assertTrue(out.contains("b"));
		assertTrue(out.contains("c"));
		assertTrue(out.contains("A"));
		assertTrue(out.contains("B"));
		assertTrue(out.contains("C"));
		assertTrue(out.contains("d"));
		assertTrue(out.contains("D"));
		assertTrue(out.contains("z"));
	}

	@Test
	public void testOutOfRangeIntList1() throws Exception {
		List<Integer> out = Q1.outOfRange(intList,1, 10);
		assertEquals(1 ,out.size());
		assertTrue(out.contains(19));

	}

	@Test
	public void testOutOfRangeIntList2() throws Exception {
		List<Integer> out = Q1.outOfRange(intList,11, 20);
		assertEquals(8 ,out.size());
		assertTrue(out.contains(5));
		assertTrue(out.contains(3));
		assertTrue(out.contains(6));
		assertTrue(out.contains(9));
		assertTrue(out.contains(10));
		assertTrue(out.contains(2));
	}

	@Test
	public void testOutOfRangeIntSet1() throws Exception {
		List<Integer> out = Q1.outOfRange(intSet,1, 10);
		assertEquals(1 ,out.size());
		assertTrue(out.contains(19));

	}

	@Test
	public void testOutOfRangeIntSet2() throws Exception {
		List<Integer> out = Q1.outOfRange(intSet,11, 20);
		assertEquals(6 ,out.size());
		assertTrue(out.contains(5));
		assertTrue(out.contains(3));
		assertTrue(out.contains(6));
		assertTrue(out.contains(9));
		assertTrue(out.contains(10));
		assertTrue(out.contains(2));
	}

}
