import static org.junit.Assert.*;

import org.junit.Test;

/**
 * EECS 233 P1
 * @author James Patrizi hehe
 *
 */
public class NumSetTest {

	@Test
	public void testSize() {
		double[] array = { 1, 2, 3, 4 };
		NumSet set = new NumSet(array);
		assertEquals("Reports size", 4, set.size());
		double[] array1 = {};
		NumSet set2 = new NumSet(array1);
		assertEquals("Reports size,", 0, set2.size());	
	}

	@Test
	public void testContain() {
		double[] array = { 1, 2, 3, 4 };
		NumSet set = new NumSet(array);
		double[] array1 = {};
		NumSet set2 = new NumSet(array1);
		assertTrue("Contains 3.0", set.contains(3.0));
		assertFalse("Contains 5", set.contains(5));
		assertFalse("contains 0", set2.contains(0));
	}

	@Test
	public void testIntersect() {
		double[] array = { 1, 2, 3, 4, 5, 6 };
		double[] array1 = { 3, 4, 5, 6 };
		NumSet set = new NumSet(array);
		NumSet set1 = new NumSet(array1);
		NumSet result = NumSet.intersect(set, set1);
		// System.out.println(result);asdadad
		assertEquals("Should be size size 4", 4, result.size());
		assertTrue(result.contains(3));
		assertTrue(result.contains(4));
		assertTrue(result.contains(5));
		assertTrue(result.contains(6));
	}

	@Test
	public void testUnion() {
		double[] array = { 1, 2, 3, 4, 5, 6 };
		double[] array1 = { 3, 4, 5, 6 };
		NumSet set = new NumSet(array);
		NumSet set1 = new NumSet(array1);
		NumSet result = NumSet.union(set, set1);
		assertEquals("Should be size size 6", 6, result.size());
		assertTrue(result.contains(1));
		assertTrue(result.contains(2));
		assertTrue(result.contains(3));
		assertTrue(result.contains(4));
		assertTrue(result.contains(5));
		assertTrue(result.contains(6));
	}

	@Test
	public void testToString() {
		double[] array = { 1, 2, 3, 4, 5, 6 };
		NumSet set = new NumSet(array);
		assertEquals("Should be converting to this string:",
				"1.0 2.0 3.0 4.0 5.0 6.0", set.toString());
	}

	@Test
	public void testEquivalence() {
		double[] array1 = { 1, 2, 3, 4, 5, 6 };
		double[] array2 = { 6, 5, 4, 3, 2, 1 };
		double[] array3 = { 1, 3, 4, 2, 5, 6 };
		double[] array4 = { 1, 2, 3, 4, 5, 7 };
		NumSet set1 = new NumSet(array1);
		NumSet set2 = new NumSet(array2);
		NumSet set3 = new NumSet(array3);
		NumSet set4 = new NumSet(array4);
		assertTrue(NumSet.equivalence(set1, set2));
		assertTrue(NumSet.equivalence(set1, set3));
		assertTrue(NumSet.equivalence(set2, set3));
		assertFalse(NumSet.equivalence(set1, set4));
	}
}
