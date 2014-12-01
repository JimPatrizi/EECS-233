import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233 - P4
 * Word Vertices class that represents vertices on the graph.
 *
 */
public class WordNode implements Comparable<WordNode> {

	/**
	 * Word in the node.
	 */
	private String word;
	
	/**
	 * Counts of the word
	 */
	public int counts;
	
	/**
	 * adjacency list 
	 */
	public WordPair[] adjacencies; //adjacency list
	
	/**
	 * If this vertice has been encountered in the graph or not.
	 */
	private boolean encountered;
	
	
	public double minDistance = Double.POSITIVE_INFINITY;
	
	/**
	 * If this vertice has been finalized.
	 */
	private boolean done;
	
	/**
	 * The parent of this node or previous.
	 */
	public WordNode parent;
	
	/**
	 * Cost of this node.
	 */
	private double cost;
	
	/**
	 * Constructor of the word node. Sets the name of the node. 
	 * @param word
	 */
	public WordNode(String word){
		this.word = word;
	}
	
	public WordNode(String word, int count){
		this.word = word;
		this.counts = count;
	}
	
	public int compareTo(WordNode other){
		return Double.compare(minDistance,other.minDistance);
	}
	
	public String toString(){
		return word;
	}
		
		
		
		
		
		
		
		
	
}
