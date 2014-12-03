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
	public String word;
	
	/**
	 * Counts of the word
	 */
	public int counts;
	
	/**
	 * adjacency list forward
	 */
	public LinkedList<WordPair> adjforward = new LinkedList<WordPair>(); //adjacency list forward
	
	/**
	 * adjacency list backward
	 */
	public LinkedList<WordPair> adjbackward = new LinkedList<WordPair>(); //adjacent list backward for out degree
	
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
	 * Cost of this node aka count.
	 */
	//private double cost;
	
	/**
	 * Constructor of the word node. Sets the name of the node. 
	 * @param word
	 */
	
	
	public WordNode(String word, int count){
		this.word = word;
		this.counts = count;
	}
	
	public int compareTo(WordNode other){
		return Double.compare(minDistance,other.minDistance);
		
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof WordNode){
			return word.equals(((WordNode) obj).word);
		}
		else{
			return false;
		}
	}
			
	public void increaseCount(int i){
		counts = counts + i;
	}
	
	public int costTo(WordNode other){
		WordPair temp = new WordPair(other, 1);
		int index = adjforward.indexOf(temp);
		if(index != -1){
			return adjforward.get(index).cost;
		}
		else{
			return -1;
		}
	}
	
	public String toString(){
		return word;
	}
		
		
		
		
		
		
		
		
	
}
