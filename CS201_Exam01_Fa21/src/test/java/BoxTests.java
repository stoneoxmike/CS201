import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoxTests {
	private Box b1;
	private Box b2;
	private Box b3;
	
	private Box b1_same;
	
	@Before
	public void setUp() {
		b1 = new Box(8, 4);
		b2 = new Box(4, 2);
		b3 = new Box(1, 3);
		
		// block with same width as b1
		b1_same = new Box(8, 4);
	}
	
	@Test
	public void testGetWidthFirst() throws Exception {
		assertEquals(8, b1.getWidth());
		assertEquals(4, b2.getWidth());
	}

	@Test
	public void testGetWidthSecond() throws Exception {
		assertEquals(3, b3.getWidth());
	}

	@Test
	public void testGetHeightSecond() throws Exception {
		assertEquals(4, b1.getHeight());
		assertEquals(2, b2.getHeight());
	}

	@Test
	public void testGetHeightFirst() throws Exception {
		assertEquals(1, b3.getHeight());
	}

	@Test
	public void testFitsInsideDecrease() throws Exception {
		// b1 is the widest block: it can't be placed on either of the others
		assertFalse(b1.fitsInside(b2));
		
		// b2 can be placed on b1, but not b3
		assertTrue(b2.fitsInside(b1));
	}

	@Test
	public void testFitsInsideIncrease() throws Exception {		
		// b2 can be placed on b1, but not b3
		assertTrue(b2.fitsInside(b1));
		assertFalse(b2.fitsInside(b3));
		
		// b3 can be placed on both other blocks
		assertTrue(b3.fitsInside(b1));
		assertTrue(b3.fitsInside(b2));
	}

	@Test
	public void testFitsInsideSameWidth() throws Exception {
		// it should not be possible to place a block on another
		// block with the same width
		assertFalse(b1.fitsInside(b1_same));
		assertFalse(b1_same.fitsInside(b1));
	}
}
