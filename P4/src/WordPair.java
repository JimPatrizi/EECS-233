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
	public WordNode target;
	
	/**
	 * Edge Cost. Also the the word pair count between the word pair.
	 */
	public double cost;
	
	/**
	 * Makes the edge in the graph between this edge to the next node and the cost of this path.
	 * @param w1 - next word in the adjacency list. 
	 * @param c - cost of this next word.
	 */
	public WordPair(WordNode w1, int c){
		this.target = w1;
		this.cost = c; 
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof WordPair){
			return target.equals(((WordPair) other).target);
		}
		else{
			return false;
		}
	}
	
	public void increaseCount(int i){
		cost = cost + i;
	}
	
	
}
