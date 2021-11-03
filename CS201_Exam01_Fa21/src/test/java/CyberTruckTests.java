import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CyberTruckTests {
	private CyberTruck sMotor;
	private CyberTruck dMotor;
	private CyberTruck tMotor;

	
	@Before
	public void setUp() {
		sMotor = new CyberTruck(1);
		dMotor = new CyberTruck(2);
		tMotor = new CyberTruck(3);
	}

	@Test
	public void testGetNumMotors() throws Exception {
		assertEquals(1, sMotor.getNumMotors());
		assertEquals(2, dMotor.getNumMotors());
		assertEquals(3, tMotor.getNumMotors());
	}

	@Test
	public void testSetRange() throws Exception {
		sMotor.setRange();
		assertEquals(250, sMotor.getMaxRange());
		dMotor.setRange();
		assertEquals(300, dMotor.getMaxRange());
		tMotor.setRange();
		assertEquals(500, tMotor.getMaxRange());
	}

	@Test
	public void testGetRange() throws Exception {
		sMotor.setRange();
		assertEquals(250*(1-(500.0/10000.0)), sMotor.getRange(500.0), 0.0001);
		dMotor.setRange();
		assertEquals(300*(1-(750.0/(2*10000.0))), dMotor.getRange(750), 0.0001);
		tMotor.setRange();
		assertEquals(500*(1-(10000.0/(3*10000.0))), tMotor.getRange(10000), 0.0001);

	}

	@Test
	public void testGetAcceleration() throws Exception {
		assertEquals(6.5, sMotor.getAcceleration(), 0.0001);
		assertEquals(4.5, dMotor.getAcceleration(), 0.0001);
		assertEquals(2.9, tMotor.getAcceleration(), 0.0001);
	}

}
