import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HorseTest {
    private Trip legalTrip;
    private Trip illegalTrip;
    private Horse silver;

    @Before
    public void setUp() throws Exception {
        // a Trip that can be completed by Horse
        legalTrip = new Trip(4);
        legalTrip.setHop(0, Terrain.FIELD);
        legalTrip.setHop(1, Terrain.MOUNTAIN);
        legalTrip.setHop(2, Terrain.FIELD);
        legalTrip.setHop(2, Terrain.ROAD);

        // a Trip that cannot be completed by Horse
        // because it contains a hop through WATER
        illegalTrip = new Trip(5);
        illegalTrip.setHop(0, Terrain.FIELD);
        illegalTrip.setHop(1, Terrain.FIELD);
        illegalTrip.setHop(2, Terrain.ROAD);
        illegalTrip.setHop(3, Terrain.WATER);   // Not possible by Horse!
        illegalTrip.setHop(4, Terrain.MARINA);

        silver = new Horse(20.0);
    }

    @Test
    public void testLegalTrip() throws Exception {
        assertTrue(legalTrip.isTripPossible(silver));
    }

    @Test
    public void testIllegalTrip() throws Exception {
        assertFalse(illegalTrip.isTripPossible(silver));
    }

    @Test
    public void testNumberOfLegs() throws Exception {
        assertEquals(4,silver.numberOfLegs());
    }
}