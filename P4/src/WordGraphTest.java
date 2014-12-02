import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class WordGraphTest {

	
	@Test
	public void testOneWord() throws IOException{
		WordGraph graph = new WordGraph("single_word.txt");
		System.out.println(graph.numNodes());
		System.out.println(graph.numEdges());
		System.out.println();
	}
	@Test
	public void testConstructor() throws FileNotFoundException, IOException{
		WordGraph wg = new WordGraph("test.txt");
		//System.out.println(wg.wordCount("a"));
		//System.out.println(wg.numNodes());
		//System.out.println(wg.numEdges());
		System.out.println(wg.inDegree("only"));
		//System.out.println(wg.inDegree("only"));
		//String[] array = wg.nextWords("hello");
		System.out.println(Arrays.toString(wg.nextWords("hello")));
		//System.out.println(Arrays.toString(wg.prevWords("only")));
		//System.out.println(wg.inDegree("only"));
		/**
		for(int i = 0 ; i < array.length ; i++){
			System.out.println(array[i]);
		}
		**/
		
	}
}
