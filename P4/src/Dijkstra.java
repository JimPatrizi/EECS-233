import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Dijkstra {
	public static void computePaths(WordNode source){
		source.minDistance = 0;
		PriorityQueue<WordNode> wordNodeQueue = new PriorityQueue<WordNode>();
		wordNodeQueue.add(source);

		while(!wordNodeQueue.isEmpty()){
			WordNode u = wordNodeQueue.poll();

			for(WordPair p : u.adjacencies){
				WordNode node = p.target;
				double weight = p.cost;
				double distanceThroughU = u.minDistance + weight;
				if(distanceThroughU < node.minDistance){
					wordNodeQueue.remove(node);
					node.minDistance = distanceThroughU;
					node.parent = u;
					wordNodeQueue.add(node);
				}
			}
		}
	}
	
	
	public static ArrayList<WordNode> getShortestPathTo(WordNode target){
		ArrayList<WordNode> path = new ArrayList<WordNode>();
		for(WordNode node = target; node != null; node = node.parent){
			path.add(node);
		}
		Collections.reverse(path);
		return path;
		
	}
	
	public static void main(String[] args)
    {
        WordNode v0 = new WordNode("Redvile");
	WordNode v1 = new WordNode("Blueville");
	WordNode v2 = new WordNode("Greenville");
	WordNode v3 = new WordNode("Orangeville");
	WordNode v4 = new WordNode("Purpleville");
/**
	v0.adjacencies = new LinkedList<WordPair>(v1,5) new WordPair(v1, 5),
	                             new WordPair(v2, 10),
                               new WordPair(v3, 8) };
	v1.adjacencies = new WordPair[]{ new WordPair(v0, 5),
	                             new WordPair(v2, 3),
	                             new WordPair(v4, 7) };
	v2.adjacencies = new WordPair[]{ new WordPair(v0, 10),
                               new WordPair(v1, 3) };
	v3.adjacencies = new WordPair[]{ new WordPair(v0, 8),
	                             new WordPair(v4, 2) };
	v4.adjacencies = new WordPair[]{ new WordPair(v1, 7),
                               new WordPair(v3, 2) };
	WordNode[] vertices = { v0, v1, v2, v3, v4 };
        computePaths(v0);
        for (WordNode v : vertices)
	{
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    ArrayList<WordNode> path = getShortestPathTo(v);
	    System.out.println("Path: " + path);
	}
    }
    **/

}
}
