import static org.junit.Assert.*;

import org.junit.Test;


public class NumArrayListTest {

	@Test
	public void testNullConstructor() {
		NumArrayList l = new NumArrayList();
		assertEquals("A constructor that initalizes an empty list", 100, l.capacity());
	}
}
