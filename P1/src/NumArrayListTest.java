import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class NumArrayListTest {
	
	
	 /* 
     * JUnit tests of fundamental functionality.
     *   
     * Use these JUnit tests to ensure that your code compiles
     * and correctly implements the fundamental functionality.
     * 
     * Code that does not pass these tests will not be graded.
     * Your draft submission needs to pass these tests in order
     * to receive a non-zero grade on the assignment.
     */

    @Test
    public void testDefaultConstructorAndToString() {
        NumArrayList list = new NumArrayList();     
        assertEquals("With no parameters, your constructors should initialize a list size 0. " + 
            "It also can be the problem in method TOSTRING.", 
            "", list.toString());
    }

    @Test
    public void testAddAndToString() {
        NumArrayList list = new NumArrayList();

        list.add(1.0);
        list.add(3.0);
        list.add(2.0);

        assertEquals("Add method should add element to the end of list each time. " +
            "It's also can be the problem in method TOSTRING.",
            "1.0 3.0 2.0", list.toString());
    }

    @Test
    public void testSize() {
        NumArrayList list = new NumArrayList();

        assertEquals("Method SIZE should return 0, when list is constructed by default constructor.",
            0, list.size());

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals("Method SIZE should return the size of the list, " + 
            "i.e. the number of elements, in the sequence.",
            3, list.size());
    }

    @Test
    public void testEquals() {
        NumArrayList listA = new NumArrayList();
        NumArrayList listB = new NumArrayList();
        NumArrayList listC = new NumArrayList();

        listA.add(1.0);
        listA.add(3.0);

        assertFalse("EQUALS method should return FALSE, when two lists are not the same.",
            listA.equals(listB));

        listB.add(1.0);
        listB.add(3.0);

        assertTrue("EQUALS method should return TRUE, when two lists are the same.",
            listA.equals(listB));

        listC.add(3.0);
        listC.add(1.0);

        assertFalse("EQUALS method should return FALSE, even if the same " + 
            "numbers are in different order in two lists.",
            listA.equals(listC));
    }

    /* Other JUnit tests.
     * 
     * Write your own JUnit tests below to check the correctness of your implementation.
     * 
     * When you turn in your draft (and final) we will run our own test suite on your code 
     * and provide you with the feedback.
     */

	
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
		
	
	@Test
	public void testInsert() {
		NumArrayList l = new NumArrayList(3);
		l.add(1);
		l.add(3);
		assertEquals("Size should be 2", 2, l.size());
		l.insert(1,2);
		assertEquals("Size should be 3", 3, l.size());
		//System.out.println(Arrays.toString(l.list));
		assertEquals("The new array should read because we inserted 2.0 at the 1 index","1.0 2.0 3.0",l.toString());
	}
}
	
