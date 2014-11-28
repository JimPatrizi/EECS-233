/**
 * 
 * @author James Patrizi
 * EECS 233 -  P4
 * Represents Edges of graph.
 *
 */
public class WordPair {

	/**
	 * Second vertex of the word pair.
	 */
	private WordNode endNode;
	
	/**
	 * Edge Cost
	 */
	private double cost;
	
	/**
	 * Makes the edge in the graph between this edge to the next node and the cost of this path.
	 * @param w1 - next word in the adjacency list. 
	 * @param c - cost of this next word.
	 */
	public WordPair(WordNode w1, double c){
		this.endNode = w1;
		this.cost = c; 
	}
	
	
}
