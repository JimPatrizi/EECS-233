import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233 - P4
 * Word Vertices class that represents vertices on the graph.
 *
 */
public class WordNode {

	/**
	 * Word in the node.
	 */
	private String word;
	
	/**
	 * adjacency list 
	 */
	private LinkedList<WordPair> edges; //adjacency list
	
	/**
	 * If this vertice has been encountered in the graph or not.
	 */
	private boolean encountered;
	
	/**
	 * If this vertice has been finalized.
	 */
	private boolean done;
	
	/**
	 * The parent of this node.
	 */
	private WordNode parent;
	
	/**
	 * Cost of this node.
	 */
	private double cost;
}
