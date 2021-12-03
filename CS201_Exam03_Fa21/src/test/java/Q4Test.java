import static org.junit.Assert.*;

import org.junit.Test;

public class Q4Test {
	@Test
	public void test0() {
		assertEquals(0, Q4.sumOfOdds(0));
	}
	
	@Test
	public void test1() {
		assertEquals(1, Q4.sumOfOdds(1));
	}
	
	@Test
	public void test3() {
		assertEquals(9, Q4.sumOfOdds(3));
	}
	
	@Test
	public void test10() {
		assertEquals(100, Q4.sumOfOdds(10));
	}
	
	@Test
	public void test63() {
		assertEquals(3969, Q4.sumOfOdds(63));
	}
}
