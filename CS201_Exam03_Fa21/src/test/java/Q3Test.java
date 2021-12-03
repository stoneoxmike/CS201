import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class Q3Test {
	private List<String> food;
	private List<String> colors;
	
	@Before
	public void setUp() {
		food = Arrays.asList("Ham", "Eggs", "Beans", "ham", "Beans", "HaM");
		colors = Arrays.asList(
				"Red", "Green", "blue", "Blue", "Red",
				"Purple", "oranGe", "Red", "Yellow",
				"RED", "Puce", "Blue", "Yellow");
	}
	
	@Test
	public void testCondense1() throws Exception {
		Map<String, Integer> result = Q3.condense(food);
		assertEquals(3, result.size());
		assertEquals((Integer)3, result.get("ham"));
		assertEquals((Integer)1, result.get("eggs"));
		assertEquals((Integer)2, result.get("beans"));
	}
	
	@Test
	public void testCondense2() throws Exception {
		Map<String, Integer> result = Q3.condense(colors);
		assertEquals(7, result.size());
		assertEquals((Integer)4, result.get("red"));
		assertEquals((Integer)1, result.get("green"));
		assertEquals((Integer)3, result.get("blue"));
		assertEquals((Integer)1, result.get("purple"));
		assertEquals((Integer)1, result.get("orange"));
		assertEquals((Integer)2, result.get("yellow"));
		assertEquals((Integer)1, result.get("puce"));
	}
}
