import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class ArrayTest {
	private int[] a1;
	private int[] a2;
	private ArrayList<Integer> aL1;
	private ArrayList<Integer> aL2;
	
	@Before
	public void setUp() throws Exception {
		a1 = new int[] {9,0,1,2,5};
		a2 = new int[] {8};
		
		aL1 = new ArrayList<Integer>();
		for (int i : a1) {
			aL1.add(i);
		}
		
		aL2 = new ArrayList<Integer>();
		for (int i : a2) {
			aL2.add(i);
		}
	}
	@Test
	public void testReverseArray() throws Exception {
		ArrayAndArrayList.reverseArray(a1);
		assertEquals(5, a1[0]);
		assertEquals(2, a1[1]);
		assertEquals(1, a1[2]);
		assertEquals(0, a1[3]);
		assertEquals(9, a1[4]);
		
		ArrayAndArrayList.reverseArray(a2);
		assertEquals(8, a2[0]);
		
	}

	@Test
	public void testReverseArrayList() throws Exception {
		ArrayAndArrayList.reverseArrayList(aL1);
		assertEquals((Integer)5, aL1.get(0));
		assertEquals((Integer)2, aL1.get(1));
		assertEquals((Integer)1, aL1.get(2));
		assertEquals((Integer)0, aL1.get(3));
		assertEquals((Integer)9, aL1.get(4));
		
		ArrayAndArrayList.reverseArrayList(aL2);
		assertEquals(8, (int) aL2.get(0));

	}
}

