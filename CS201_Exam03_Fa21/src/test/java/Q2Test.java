import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class Q2Test {
	private Map<String, Double> examplePrices;
	private Map<String, Integer> exampleOrder1;
	private Map<String, Integer> exampleOrder2;
	private Map<String, Integer> blankOrder;
	
	@Before
	public void setUp() {
		examplePrices = new HashMap<String, Double>();
		examplePrices.put("apple", 0.80);
		examplePrices.put("orange", 1.20);
		examplePrices.put("lemon", 0.75);
		examplePrices.put("persimmon", 2.00);
		
		exampleOrder1 = new HashMap<String,Integer>();
		exampleOrder1.put("apple", 2);
		exampleOrder1.put("orange", 1);
		exampleOrder1.put("lemon", 1);

		exampleOrder2 = new HashMap<String,Integer>();
		exampleOrder2.put("persimmon", 2);
		exampleOrder2.put("lemon", 1);
		exampleOrder2.put("apple", 1);
		exampleOrder2.put("orange", 1);
		
		blankOrder = new TreeMap<String,Integer>();
	}
	
	@Test
	public void testOrderTotal1() throws Exception {
		assertEquals(3.55, Q2.orderTotal(examplePrices, exampleOrder1), 0.001);
	}
	
	@Test
	public void testOrderTotal2() throws Exception {
		assertEquals(6.75, Q2.orderTotal(examplePrices, exampleOrder2), 0.001);
	}

	@Test
	public void testOrderTotalBlank() throws Exception {
		assertEquals(0.0, Q2.orderTotal(examplePrices, blankOrder),0.001);
	}

}
