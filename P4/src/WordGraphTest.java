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
		System.out.println(graph.inDegree("Hello"));
		System.out.println(graph.outDegree("heLLo"));
		System.out.println(Arrays.toString(graph.prevWords("hello")));
		System.out.println(Arrays.toString(graph.nextWords("hello")));
		System.out.println();
	}
	@Test
	public void testFile() throws FileNotFoundException, IOException{
		WordGraph g = new WordGraph("file.txt");
		System.out.println(g.numNodes());
		System.out.println(g.numEdges());
		System.out.println(g.wordCount("a"));
		System.out.println(g.inDegree("!a"));
		System.out.println(g.outDegree("a*"));
		System.out.println(Arrays.toString(g.prevWords("A")));
		System.out.println(Arrays.toString(g.nextWords("A@...")));
		System.out.println();
		System.out.println(g.wordCount("now"));
		System.out.println(g.inDegree("now"));
		System.out.println(g.outDegree("now"));
		System.out.println(Arrays.toString(g.prevWords("now")));
		System.out.println(Arrays.toString(g.nextWords("now...")));
		System.out.println();
		System.out.println(g.wordCount("wanna"));
		System.out.println(g.inDegree("wanna"));
		System.out.println(g.outDegree("wanna"));
		System.out.println(Arrays.toString(g.prevWords("wanna")));
		System.out.println(Arrays.toString(g.nextWords("wanna")));
		System.out.println();
		System.out.println(g.wordCount("something"));
		System.out.println(g.inDegree("something"));
		System.out.println(g.outDegree("something"));
		System.out.println(Arrays.toString(g.prevWords("something")));
		System.out.println(Arrays.toString(g.nextWords("something")));
		System.out.println();
	}
		
	@Test
	public void testTest_Input() throws FileNotFoundException, IOException{
		WordGraph g = new WordGraph("test_input.txt");
		System.out.println(g.numNodes());
		System.out.println(g.numEdges());
		System.out.println(g.wordCount("think"));
		System.out.println(g.inDegree("think"));
		System.out.println(g.outDegree("think"));
		System.out.println(Arrays.toString(g.prevWords("think")));
		System.out.println(Arrays.toString(g.nextWords("think")));
			
		}
	}

