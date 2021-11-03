import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {
	private Dog dog1;
	private Dog dog2;

	@Before
	public void setUp() throws Exception {
		dog1 = new Dog("Spot", true);
		dog2 = new Dog();
	}

	@Test
	public void testIsGoodDog() throws Exception {
		assertTrue(dog1.isGoodDog());
		assertFalse(dog2.isGoodDog());
	}

	@Test
	public void testTrain() throws Exception {
		dog1.train();
		assertTrue(dog1.isGoodDog());
		dog2.train();
		assertTrue(dog2.isGoodDog());
	}
}
