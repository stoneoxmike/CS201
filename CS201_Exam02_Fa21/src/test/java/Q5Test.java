import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q5Test {
	private String s1, s2, s3, s4, s5, s6, s7;
	private StringLengthComparator comp;
	
	@Before
	public void setUp() {
		s1 = "Hello!";
		s2 = "Z";
		s3 = "abc123";
		s4 = "CS101 is Great!";
		s5 = "";
		s6 = "W";
		s7 = "abc123";
		
		comp = new StringLengthComparator();
	}
	
	@Test
	public void testShorterComparison() throws Exception {
		assertTrue(comp.compare(s2, s3) < 0);
		assertTrue(comp.compare(s1, s4) < 0);
	}
	
	@Test
	public void testLongerComparison() throws Exception {
		assertTrue(comp.compare(s1, s2) > 0);
		assertTrue(comp.compare(s4, s2) > 0);		
	}
	
	@Test
	public void testSameComparison() throws Exception {
		assertTrue(comp.compare(s1, s3) > 0);
		assertTrue(comp.compare(s3, s1) < 0);
		assertTrue(comp.compare(s2, s6) > 0);
		assertTrue(comp.compare(s3, s7) == 0);
	}
	
	@Test
	public void testBlankComparison() throws Exception {
		assertTrue(comp.compare(s5, s3) < 0);
		assertTrue(comp.compare(s5, s1) < 0);
		assertTrue(comp.compare(s5, s6) < 0);
		assertTrue(comp.compare(s5, s5) == 0);
	}

}
