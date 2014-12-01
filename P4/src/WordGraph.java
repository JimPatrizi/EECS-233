import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author James Patrizi
 * EECS 233- P4
 * Computes word sequence statistics.  
 *
 */
public class WordGraph {

	/**
	 * List of the Words and holds the tokenized file.
	 */
	public ArrayList<String> list;
	private WordNode[] words;
	public int numWords;
	public int maxNum;
	
	
	public WordGraph(String file) throws IOException, FileNotFoundException{
		list = new Tokenizer(file).wordList();
		words = new WordNode[list.size()];
		numWords = 0;
		maxNum = list.size();
	}
	
	public int numNodes(){
		return numWords;
	}
	
	public int numEdges(){
		return 0;
	}
	
	public int wordCount(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		return 0;
	}
	
	public int inDegree(String w){
		return 0;
	}
	
	public int outDegree(String w){
		return 0;
	}
	
	public String[] prevWords(String w){
		return null;
	}
	
	public String[] nextWords(String w){
		return null;
	}
	
	public double wordSeqCount(String[] wordSeq){
		return 0;
	}
	
	public String generatePhrase(String startWord, String endWord, int N){
		return "";
	}
	//dont know if this is right.
	public int addNode(String word , int cost){
		if(numWords == maxNum){
			WordNode[] copyarray = new WordNode[maxNum*2];
			for(int i = 0; i < words.length;i++){
				copyarray[i]= words[i];
			}
			words = copyarray;
		}
		words[numWords] = new WordNode(word, cost);
		numWords++;
		return numWords-1;//returns the index
	}
	//this is probably wrong and isnt finished
	public void addEdge(String word1, String word2, int cost){
		//add an edge from i to j
		WordNode newNode = new WordNode(word2,cost);
		WordPair newPair = new WordPair(newNode, cost);
		
	}
	
	public static void main(String[] args){
		
	}
	
	
}
