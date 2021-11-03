import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q1Test {
	private Integer[] intArr1;
	private Integer[] intArr2;
	private String[] strArr1;
	private String[] strArr2;
	private Foo[] fooArr;
	private Card[] cardArr;
	private Integer[] evenInt;
	
	@Before
	public void setUp() {
		intArr1 = new Integer[5];
		intArr2 = new Integer[5];
		intArr1[0] = 1;
		intArr1[1] = 2;
		intArr1[2] = 1;
		intArr1[3] = 2;
		intArr1[4] = 1;
		
		intArr2[0] = 5;
		intArr2[1] = 2;
		intArr2[2] = 4;
		intArr2[3] = 3;
		intArr2[4] = 1;

		evenInt = new Integer[4];
		evenInt[0] = 1;
		evenInt[1] = 2;
		evenInt[2] = 3;
		evenInt[3] = 4;
		
		strArr1 = new String[5];
		strArr2 = new String[4];
		
		strArr1[0] = "A";
		strArr1[1] = "A";
		strArr1[2] = "B";
		strArr1[3] = "A";
		strArr1[4] = "C";
		
		strArr2[0] = "BC";
		strArr2[1] = "DEF";
		strArr2[2] = "AB";
		strArr2[3] = "BC";
		
		fooArr = new Foo[5];
		fooArr[0] = new Foo(1, new Card(Rank.TWO, Suit.HEARTS));
		fooArr[1] = new Foo(2, new Card(Rank.JACK, Suit.DIAMONDS));
		fooArr[2] = new Foo(1, new Card(Rank.FIVE, Suit.SPADES));
		fooArr[3] = new Foo(3, new Card(Rank.NINE, Suit.HEARTS));
		fooArr[4] = new Foo(1, new Card(Rank.KING, Suit.CLUBS));

		cardArr = new Card[5];
		cardArr[0] = new Card(Rank.EIGHT, Suit.DIAMONDS);
		cardArr[1] = new Card(Rank.QUEEN, Suit.CLUBS);
		cardArr[2] = new Card(Rank.FOUR, Suit.DIAMONDS);
		cardArr[3] = new Card(Rank.QUEEN, Suit.SPADES);
		cardArr[4] = new Card(Rank.ACE, Suit.HEARTS);
	}
	
	@Test
	public void testFindMedianInt() throws Exception {
		assertEquals((Integer) 1, Q1.findMedian(intArr1));
		assertEquals((Integer) 3, Q1.findMedian(intArr2));
	}

	@Test
	public void testFindMedianStr() throws Exception {
		assertEquals("A", Q1.findMedian(strArr1));
		assertTrue(Q1.findMedian(strArr2)==null);
	}

	@Test
	public void testFindMedianFoo() throws Exception {
		assertEquals(new Foo(1, new Card(Rank.KING, Suit.CLUBS)), Q1.findMedian(fooArr));
	}

	@Test
	public void testFindMedianCard() throws Exception {
		assertEquals(new Card(Rank.QUEEN, Suit.CLUBS), Q1.findMedian(cardArr));
	}

	@Test
	public void testFindMedianEven() throws Exception {
		assertEquals(null, Q1.findMedian(evenInt));
	}

}
