import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AirplaneTest {
    private Trip legalTrip;
    private Trip illegalTrip;
    private Airplane myAirplane;
    private double maxSpeed;
    private static final double DELTA = 0.00001;

    @Before
    public void setUp() throws Exception {
        maxSpeed = 500;
        // a Trip that can be completed by Airplane
        legalTrip = new Trip(4);
        legalTrip.setHop(0, Terrain.AIRPORT);
        legalTrip.setHop(1, Terrain.ROAD);
        legalTrip.setHop(2, Terrain.FIELD);
        legalTrip.setHop(3, Terrain.AIRPORT);

        // a trip that cannot be completed by an Airlane
        // because it does not start and end at AIRPORT
        illegalTrip = new Trip(5);
        illegalTrip.setHop(0, Terrain.AIRPORT);
        illegalTrip.setHop(1, Terrain.ROAD);
        illegalTrip.setHop(2, Terrain.ROAD);
        illegalTrip.setHop(3, Terrain.WATER);
        illegalTrip.setHop(4, Terrain.MARINA);  // Not possible by Airplane!

        myAirplane = new Airplane(maxSpeed);
    }

    @Test
    public void testLegalTrip() throws Exception {
        assertTrue(legalTrip.isTripPossible(myAirplane));
    }

    @Test
    public void testIllegalTrip() throws Exception {
        assertFalse(illegalTrip.isTripPossible(myAirplane));
    }

    @Test
    public void testGetSpeed() {
        // full speed over road
        assertEquals( 500.0, myAirplane.getSpeed(Terrain.ROAD), DELTA );

        // full speed through an airport
        assertEquals( 500.0, myAirplane.getSpeed(Terrain.AIRPORT), DELTA );

        // full speed through a marina
        assertEquals( 500.0, myAirplane.getSpeed(Terrain.MARINA), DELTA );
    }

    @Test
    public void testFindAverageSpeed() throws Exception {
        double dist = 4.0;
        double time = (1.0/(500)) + (1.0/(500)) + (1.0/(500)) + (1.0/(500));
        assertEquals(dist / time, legalTrip.findAverageSpeed(myAirplane), DELTA);
    }
}
