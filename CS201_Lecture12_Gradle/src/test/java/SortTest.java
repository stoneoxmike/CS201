import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
    private String[] sArr;
    private Integer[] iArr;
    private CaseInsensitiveStringComparator strComp;
    private ReverseIntegerComparator intComp;

	@Before
	public void setUp() {
        sArr = new String[]{
                "Carl",
                "bob",
                "Dingus",
                "Alice",
        };

        iArr = new Integer[] {
                0, 67, 36, 70, 56, 69, 1, 96, 32, 35,
        };
        
        // Create functors
        strComp = new CaseInsensitiveStringComparator();
        intComp = new ReverseIntegerComparator();
    }

	@Test
    public void testBubbleSortCompareTo() throws Exception {
		// Sort Strings using built in compareTo
        BubbleSort.bubbleSort(sArr);
        assertEquals("Alice", sArr[0]);
        assertEquals("Carl", sArr[1]);
        assertEquals("Dingus", sArr[2]);
        assertEquals("bob", sArr[3]);

        // Sort Integers using built in compareTo
        BubbleSort.bubbleSort(iArr);
        assertEquals((Integer) 0, iArr[0]);
        assertEquals((Integer) 1, iArr[1]);
        assertEquals((Integer) 32, iArr[2]);
        assertEquals((Integer) 35, iArr[3]);
        assertEquals((Integer) 36, iArr[4]);
        assertEquals((Integer) 56, iArr[5]);
        assertEquals((Integer) 67, iArr[6]);
        assertEquals((Integer) 69, iArr[7]);
        assertEquals((Integer) 70, iArr[8]);
        assertEquals((Integer) 96, iArr[9]);
    }
    
	@Test
    public void testBubbleSortFunctor() throws Exception {
		// Sort Strings using CaseInsensitiveStringComparator functor
        BubbleSort.bubbleSort(sArr, strComp);
        assertEquals("Alice", sArr[0]);
        assertEquals("bob", sArr[1]);
        assertEquals("Carl", sArr[2]);
        assertEquals("Dingus", sArr[3]);

        // Sort Integers using ReverseIntegerComparator functor
        Arrays.sort(iArr, intComp);
        assertEquals((Integer) 96, iArr[0]);
        assertEquals((Integer) 70, iArr[1]);
        assertEquals((Integer) 69, iArr[2]);
        assertEquals((Integer) 67, iArr[3]);
        assertEquals((Integer) 56, iArr[4]);
        assertEquals((Integer) 36, iArr[5]);
        assertEquals((Integer) 35, iArr[6]);
        assertEquals((Integer) 32, iArr[7]);
        assertEquals((Integer) 1, iArr[8]);
        assertEquals((Integer) 0, iArr[9]);
    }
    
    
}
