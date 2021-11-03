import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
	// Create test object references
	private Point p;
	private Point q;

	@Before
	public void setUp() throws Exception {
		// Instantiate test objects
		p = new Point(4, 5);
		q = new Point(13, 14);
	}

	// Test class methods
	@Test
	public void testGetX() throws Exception {
		assertEquals(4, p.getX());
		assertEquals(13, q.getX());
	}

	@Test
	public void testGetY() throws Exception {
		assertEquals(5, p.getY());
		assertEquals(14, q.getY());
	}

	@Test
	public void testSetX() throws Exception {
		p.setX(55);
		assertEquals(55, p.getX());

		q.setX(101);
		assertEquals(101, q.getX());
	}

	@Test
	public void testSetY() throws Exception {
		p.setY(1331);
		assertEquals(1331, p.getY());

		q.setY(90125);
		assertEquals(90125, q.getY());
	}
}
