import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {
	private Coins empty;
	private Coins oneOfEach;
	private Coins fiveQuartersOnePenny;
	private Coins twelveDimesOneNickelOnePenny;
	
	@Before
	public void setUp() throws Exception {
		empty = new Coins(0, 0, 0, 0);
		oneOfEach = new Coins(1, 1, 1, 1);
		fiveQuartersOnePenny = new Coins(1, 0, 0, 5);
		twelveDimesOneNickelOnePenny = new Coins(1, 1, 12, 0);
	}

	@Test
	public void testGetPennies() throws Exception {
		assertEquals(0, empty.getPennies());
		assertEquals(1, oneOfEach.getPennies());
		assertEquals(1, fiveQuartersOnePenny.getPennies());
		assertEquals(1, twelveDimesOneNickelOnePenny.getPennies());
	}

	@Test
	public void testGetNickels() throws Exception {
		assertEquals(0, empty.getNickels());
		assertEquals(1, oneOfEach.getNickels());
		assertEquals(0, fiveQuartersOnePenny.getNickels());
		assertEquals(1, twelveDimesOneNickelOnePenny.getNickels());
	}

	@Test
	public void testGetDimes() throws Exception {
		assertEquals(0, empty.getDimes());
		assertEquals(1, oneOfEach.getDimes());
		assertEquals(0, fiveQuartersOnePenny.getDimes());
		assertEquals(12, twelveDimesOneNickelOnePenny.getDimes());
	}

	@Test
	public void testGetQuarters() throws Exception {
		assertEquals(0, empty.getQuarters());
		assertEquals(1, oneOfEach.getQuarters());
		assertEquals(5, fiveQuartersOnePenny.getQuarters());
		assertEquals(0, twelveDimesOneNickelOnePenny.getQuarters());
	}

	@Test
	public void testFindCentsValue() throws Exception {
		assertEquals(0, empty.findCentsValue());
		assertEquals(41, oneOfEach.findCentsValue());
		assertEquals(126, fiveQuartersOnePenny.findCentsValue());
		assertEquals(126, twelveDimesOneNickelOnePenny.findCentsValue());
	}
	
	@Test
	public void testFindDollars() throws Exception {
		assertEquals(0, empty.findDollars());
		assertEquals(0, oneOfEach.findDollars());
		assertEquals(1, fiveQuartersOnePenny.findDollars());
		assertEquals(1, twelveDimesOneNickelOnePenny.findDollars());
	}
	
	@Test
	public void testFindChange() throws Exception {
		assertEquals(0, empty.findChange());
		assertEquals(41, oneOfEach.findChange());
		assertEquals(26, fiveQuartersOnePenny.findChange());
		assertEquals(26, twelveDimesOneNickelOnePenny.findChange());
	}
}
