import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoatTest {
    private Trip legalTrip;
    private Trip illegalTrip;
    private Boat myBoat;

    @Before
    public void setUp() throws Exception {
        // a Trip that can be completed by Boat
        legalTrip = new Trip(4);
        legalTrip.setHop(0, Terrain.MARINA);
        legalTrip.setHop(1, Terrain.WATER);
        legalTrip.setHop(2, Terrain.WATER);
        legalTrip.setHop(3, Terrain.MARINA);

        // a trip that cannot be completed by a Boat
        // because it does not start and end at MARINA
        // and because it has hops over not water
        illegalTrip = new Trip(5);
        illegalTrip.setHop(0, Terrain.AIRPORT);  // not possible by Boat!
        illegalTrip.setHop(1, Terrain.ROAD);  // not possible by Boat!
        illegalTrip.setHop(2, Terrain.ROAD);  // not possible by Boat!
        illegalTrip.setHop(3, Terrain.WATER);
        illegalTrip.setHop(4, Terrain.MARINA);

        myBoat = new Boat();
    }

    @Test
    public void testLegalTrip() throws Exception {
        assertTrue(legalTrip.isTripPossible(myBoat));
    }

    @Test
    public void testIllegalTrip() throws Exception {
        assertFalse(illegalTrip.isTripPossible(myBoat));
    }
}
