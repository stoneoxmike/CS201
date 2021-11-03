import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {
	private Coins empty;
	private Coins oneOfEach;
	private Coins fiveQuartersOnePenny;
	private Coins twelveDimesOneNickelOnePenny;
	private Coins fifteenEach;
	private Coins lotsOfPennies;
	private Coins inDebt;
	private Coins dollars;
	private Coins defaultConstructor;
	private Coins coins;
	
	@Before
	public void setUp() throws Exception {
		empty = new Coins(0, 0, 0, 0);
		oneOfEach = new Coins(1, 1, 1, 1);
		fiveQuartersOnePenny = new Coins(1, 0, 0, 5);
		twelveDimesOneNickelOnePenny = new Coins(1, 1, 12, 0);
		fifteenEach = new Coins(15,15,15,15);
		lotsOfPennies = new Coins(300,0,0,0);
		inDebt = new Coins(-1,0,0,0);
		dollars = new Coins(3.24);
		defaultConstructor = new Coins();
		coins = new Coins(oneOfEach);
	}

	@Test
	public void testGetPennies() throws Exception {
		assertEquals(0, empty.getPennies());
		assertEquals(1, oneOfEach.getPennies());
		assertEquals(1, fiveQuartersOnePenny.getPennies());
		assertEquals(1, twelveDimesOneNickelOnePenny.getPennies());
		assertEquals(15, fifteenEach.getPennies());
		assertEquals(300, lotsOfPennies.getPennies());
		assertEquals(-1, inDebt.getPennies());
		assertEquals(4, dollars.getPennies());
		assertEquals(0, defaultConstructor.getPennies());
		assertTrue(oneOfEach != coins);
	}

	@Test
	public void testGetNickels() throws Exception {
		assertEquals(0, empty.getNickels());
		assertEquals(1, oneOfEach.getNickels());
		assertEquals(0, fiveQuartersOnePenny.getNickels());
		assertEquals(1, twelveDimesOneNickelOnePenny.getNickels());
		assertEquals(15, fifteenEach.getNickels());
		assertEquals(0, lotsOfPennies.getNickels());
		assertEquals(0, inDebt.getNickels());
		assertEquals(0, dollars.getNickels());
		assertEquals(0, defaultConstructor.getNickels());
		assertEquals(1, coins.getNickels());
	}

	@Test
	public void testGetDimes() throws Exception {
		assertEquals(0, empty.getDimes());
		assertEquals(1, oneOfEach.getDimes());
		assertEquals(0, fiveQuartersOnePenny.getDimes());
		assertEquals(12, twelveDimesOneNickelOnePenny.getDimes());
		assertEquals(15, fifteenEach.getDimes());
		assertEquals(0, lotsOfPennies.getDimes());
		assertEquals(0, inDebt.getDimes());
		assertEquals(2, dollars.getDimes());
		assertEquals(0, defaultConstructor.getDimes());
		assertEquals(1, coins.getDimes());
	}

	@Test
	public void testGetQuarters() throws Exception {
		assertEquals(0, empty.getQuarters());
		assertEquals(1, oneOfEach.getQuarters());
		assertEquals(5, fiveQuartersOnePenny.getQuarters());
		assertEquals(0, twelveDimesOneNickelOnePenny.getQuarters());
		assertEquals(15, fifteenEach.getQuarters());
		assertEquals(0, lotsOfPennies.getQuarters());
		assertEquals(0, inDebt.getQuarters());
		assertEquals(12, dollars.getQuarters());
		assertEquals(0, defaultConstructor.getQuarters());
		assertEquals(1, coins.getQuarters());
	}

	@Test
	public void testFindCentsValue() throws Exception {
		assertEquals(0, empty.findCentsValue());
		assertEquals(41, oneOfEach.findCentsValue());
		assertEquals(126, fiveQuartersOnePenny.findCentsValue());
		assertEquals(126, twelveDimesOneNickelOnePenny.findCentsValue());
		assertEquals(615, fifteenEach.findCentsValue());
		assertEquals(300, lotsOfPennies.findCentsValue());
		assertEquals(-1, inDebt.findCentsValue());
		assertEquals(324, dollars.findCentsValue());
		assertEquals(0, defaultConstructor.findCentsValue());
		assertEquals(41, coins.findCentsValue());
	}
	
	@Test
	public void testFindDollars() throws Exception {
		assertEquals(0, empty.findDollars());
		assertEquals(0, oneOfEach.findDollars());
		assertEquals(1, fiveQuartersOnePenny.findDollars());
		assertEquals(1, twelveDimesOneNickelOnePenny.findDollars());
		assertEquals(6, fifteenEach.findDollars());
		assertEquals(3, lotsOfPennies.findDollars());
		assertEquals(0, inDebt.findDollars());
		assertEquals(3, dollars.findDollars());
		assertEquals(0, defaultConstructor.findDollars());
		assertEquals(0, coins.findDollars());
	}
	
	@Test
	public void testFindChange() throws Exception {
		assertEquals(0, empty.findChange());
		assertEquals(41, oneOfEach.findChange());
		assertEquals(26, fiveQuartersOnePenny.findChange());
		assertEquals(26, twelveDimesOneNickelOnePenny.findChange());
		assertEquals(15, fifteenEach.findChange());
		assertEquals(0, lotsOfPennies.findChange());
		assertEquals(-1, inDebt.findChange());
		assertEquals(24, dollars.findChange());
		assertEquals(0, defaultConstructor.findChange());
		assertEquals(41, coins.findChange());
	}

	@Test
	public void testEquals() throws Exception {
		assertTrue(empty.equals(defaultConstructor));
		assertFalse(empty.equals(oneOfEach));
	}
}
