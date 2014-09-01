import static org.junit.Assert.*;
import org.junit.Test;

public class AnnotationTest {

	/* 
	 * JUnit tests of fundamental functionality.
	 *
	 * Rename this file "AnnotationTest.java" and place with your source code to work with JUnit.
	 * Both Eclipse and DrJava include support for running JUnit tests.
	 *
	 * When you turn in your draft, your code must pass these 
	 * tests in order to receive a non-zero grade on the assignment.
	 */

	@Test
	public void testNullConstructor() {
		Annotation n = new Annotation();
        assertEquals("A constructor with no parameters should assume n is 0.",
        		0, n.getn());
	}
	@Test
	public void testIntegerConstructor() {
		Annotation n = new Annotation(1);
        assertEquals("A constructor with one integer parameter should store the value of that number.",
        		1, n.getn());
	}
	
	/* Other JUnit tests.
	 * 
	 * You should write your own test suite to check the correctness of your implementation.
	 * When you turn in your draft (and final) we will run our own JUnit test suite
	 * on your code and provide you with feedback. 
	 *
	 * For help with writing JUnit tests see junit.org
	 */
	@Test
	public void testSetn(){
		Annotation n = new Annotation(1);
		assertEquals("Return should = 1", 1, n.getn());
		n.setn(500);
		assertEquals("Mutated n to 500, should return 500 and be true.", 500, n.getn());
		}
	
	@Test
	public void testToString(){
		Annotation n1 = new Annotation(0);
		Annotation n2 = new Annotation(15);
		Annotation n3 = new Annotation(12);
		Annotation n4 = new Annotation(10);
		Annotation n5 = new Annotation(1);
		assertEquals("n = 0, should return 0", "0", n1.toString());
		assertEquals("n = 15, should return FizzBuzz", "FizzBuzz", n2.toString());
		assertEquals("n = 12, should return Fizz", "Fizz", n3.toString());
		assertEquals("n = 10, should return Buzz", "Buzz", n4.toString());
		assertEquals("n = 1, should return 1", "1", n5.toString());
	}
	
	@Test
	public void testAnnotateList() {
		assertEquals("Should annotate from 1 to 16 and match the sample from P0 pdf.", "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16", Annotation.annotateList(1,16));
		assertEquals("Tests the case if start = end", "FizzBuzz", Annotation.annotateList(15,15));
	}
}
