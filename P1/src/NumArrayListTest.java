import static org.junit.Assert.*;

import org.junit.Test;


public class NumArrayListTest {

	@Test
	public void testNullConstructor() {
		NumArrayList l = new NumArrayList();
		assertEquals("A constructor that initalizes an empty list", 100, l.capacity());
	}
	
	@Test
	public void testUserDefinedConstructor() {
		NumArrayList l = new NumArrayList(2);
		NumArrayList l2 = new NumArrayList(10000);
		NumArrayList l3 = new NumArrayList(0);
		assertEquals("A constructor that initalizes a list to defined user capacity.", 2, l.capacity());
		assertEquals("A constructor that initalizes a list to defined user capacity.", 10000, l2.capacity());
		assertEquals("A constructor that initalizes a list to defined user capacity.", 0, l3.capacity());
	}
	
	@Test
	public void testAddandSize() {
		NumArrayList l = new NumArrayList(3);
		assertEquals("Size should be 0", 0, l.size());
		assertEquals("Capacity = 3", 3, l.capacity());
		l.add(1);
		l.add(2);
		l.add(3);
		assertEquals("Size should be 3", 3, l.size());
	}
		
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		NumArrayList l = new NumArrayList(2);
		l.add(1);
		l.add(2);
		l.add(3);
		
	}
}
	
