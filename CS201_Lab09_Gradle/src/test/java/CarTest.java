import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	private Trip legalTrip;
	private Trip illegalTrip;
	private Car myCar;
	private double maxSpeed;
	private static final double DELTA = 0.00001;
	
	@Before
	public void setUp() throws Exception {
		maxSpeed = 100;
		// a Trip that can be completed by Car
		legalTrip = new Trip(4);
		legalTrip.setHop(0, Terrain.AIRPORT);
		legalTrip.setHop(1, Terrain.ROAD);
		legalTrip.setHop(2, Terrain.ROAD);
		legalTrip.setHop(3, Terrain.MARINA);
		
		// a Trip that cannot be completed by Car
		// because it contains a hop through WATER
		illegalTrip = new Trip(5);
		illegalTrip.setHop(0, Terrain.WATER);
		illegalTrip.setHop(1, Terrain.ROAD);
		illegalTrip.setHop(2, Terrain.ROAD);
		illegalTrip.setHop(3, Terrain.WATER);   // Not possible by Car!
		illegalTrip.setHop(4, Terrain.MARINA);
		
		myCar = new Car(maxSpeed);
	}
	
	@Test
	public void testLegalTrip() throws Exception {
		assertTrue(legalTrip.isTripPossible(myCar));
	}
	
	@Test
	public void testIllegalTrip() throws Exception {
		assertFalse(illegalTrip.isTripPossible(myCar));
	}

	@Test
	public void testGetSpeed() {
		// full speed over road
		assertEquals( 100.0, myCar.getSpeed(Terrain.ROAD), DELTA );

		// one-quarter speed through an airport
		assertEquals( 0.25 * 100.0, myCar.getSpeed(Terrain.AIRPORT), DELTA );

		// one-quarter speed through a marina
		assertEquals( 0.25 * 100.0, myCar.getSpeed(Terrain.MARINA), DELTA );
	}

	@Test
	public void testFindAverageSpeed() throws Exception {
		double dist = 4.0;
		double time = (1.0/(0.25*100)) + (1.0/(100)) + (1.0/(100)) + (1.0/(0.25*100));
		assertEquals(dist / time, legalTrip.findAverageSpeed(myCar), DELTA);
	}
}
