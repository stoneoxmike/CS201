import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTests {
	private Stack s;
	private Stack sEmpty;
	private Box b1;
	private Box b2;
	private Box b3;
	
	@Before
	public void setUp() {
		s = new Stack();
		sEmpty = new Stack();
		b1 = new Box(8, 4);
		b2 = new Box(2, 4);
		b3 = new Box(1, 3);
	}
	
	@Test
	public void testGetNumBoxes() throws Exception {
		assertEquals(0, sEmpty.getStackSize());
	}

	@Test
	public void testIsEmpty() throws Exception {
		s.addBox(b1);
		assertFalse(s.isEmpty());
		assertTrue(sEmpty.isEmpty());
	}
	
	@Test
	public void testAdd3() throws Exception {
		assertTrue(s.canNest(b1));
		s.addBox(b1);
		assertEquals(1, s.getStackSize());
		
		assertTrue(s.canNest(b2));
		s.addBox(b2);
		assertEquals(2, s.getStackSize());
		
		assertTrue(s.canNest(b3));
		s.addBox(b3);
		assertEquals(3, s.getStackSize());
	}
	
	@Test
	public void testRemove() throws Exception {
		s.addBox(b1);
		s.addBox(b2);
		s.addBox(b3);
		
		assertEquals(3, s.getStackSize());
		assertEquals(b3, s.removeBox());
		assertEquals(2, s.getStackSize());
		assertEquals(b2, s.removeBox());
		assertEquals(1, s.getStackSize());
		assertEquals(b1, s.removeBox());
		assertEquals(0, s.getStackSize());
	}
	
	@Test
	public void testAdd10() throws Exception {
		// Add 10 boxes, width 40 down to 20
		for (int w = 40; w > 20; w-=2) {
			Box b = new Box(w, (3*w)/4);
			assertTrue(s.canNest(b));
			s.addBox(b);
		}
		
		assertEquals(10, s.getStackSize());
		
		// Normally, a width 1 block could be added.
		// However, because there are already 10 blocks,
		// the tower is full, and we can't add another.
		Box last = new Box(1,1);
		assertFalse(s.canNest(last));
		
		// Removing the top block will make space to
		// put the width 1 block.
		Box top = s.removeBox();
		assertEquals(22, top.getWidth());
		assertTrue(s.canNest(last));
		s.addBox(last);
		assertEquals(10, s.getStackSize());
	}
}
