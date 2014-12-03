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
	
	/**
	 * The graph of word nodes 
	 */
	public ArrayList<WordNode> words;
	
	public int numWords;
	public int maxNum;


	/**
	 * Constructs the WordGraph from the given file. See comments within for construction process.
	 * @param file - txt file to be passed in and tokenized.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public WordGraph(String file) throws IOException, FileNotFoundException{
		list = new Tokenizer(file).wordList();
		words = new ArrayList<WordNode>(list.size()/2); //this is the graph

		if(list.size() == 1){
			WordNode word = new WordNode(list.get(0),1);
			words.add(word);
		}
		else{
			//handles the first word of the list
			WordNode inital = new WordNode(list.get(0),1);
			words.add(inital);
			WordNode second = new WordNode(list.get(1), 1);
			words.add(second);
			//next handles the pair.
			WordPair firstsecond = new WordPair(second,1);
			inital.adjforward.add(firstsecond);

			//handle the words except for last word

			int i = 0;//not used but instead the i and jnodes take the place of the indexes for comparison.
			int j = 1;
			int k = 2;

			WordNode iNode = inital;
			WordNode jNode = second;
			WordNode kNode = null;

			while(k < list.size()){
				//looks at JI pair looking previously adjacent.
				WordPair tempJI = new WordPair(iNode,1);
				if(jNode.adjbackward.contains(tempJI)){
					WordPair JIPair = jNode.adjbackward.get(jNode.adjbackward.indexOf(tempJI));//this is just coping the address which is why this works.
					JIPair.increaseCount(1);
					}
				else{
					jNode.adjbackward.add(tempJI);
				}
				
				//the index k
				WordNode temp = new WordNode(list.get(k),1);
				//increases count if already present of node.
				if(words.contains(temp)){
					kNode = words.get(words.indexOf(temp));
					kNode.increaseCount(1);
				}
				//adds to the graph if not there with a count of 1.
				else{
					kNode = new WordNode(list.get(k),1);
					words.add(kNode);
				}
				
				//checks adjacency list forward of JK edge.
				WordPair tempJK = new WordPair(kNode,1);
				if(jNode.adjforward.contains(tempJK)){
					WordPair WordPairJK = jNode.adjforward.get(jNode.adjforward.indexOf(tempJK));
					WordPairJK.increaseCount(1);
				}
				else{
					jNode.adjforward.add(tempJK);
				}
				k++;
				iNode = jNode;
				jNode = kNode;
				kNode = null;
			}
			//for the last word check JI pair backwards
			WordPair tempJI = new WordPair(iNode,1);
			if(jNode.adjbackward.contains(tempJI)){
				WordPair wordPairJI = jNode.adjbackward.get(jNode.adjbackward.indexOf(tempJI));
				wordPairJI.increaseCount(1);
			}
			else{
				jNode.adjbackward.add(tempJI);
			}
		}
	}
	
	/**
	 * Number of nodes in the graph
	 * @return number of total nodes in graph.
	 */
	public int numNodes(){
		return words.size();
	}

	/**
	 * Returns the number of forward and backward edges in the graph. 
	 * @return - number of edges total.
	 */
	public int numEdges(){
		int edgeNum = 0;
		for(WordNode i : words){
			edgeNum = edgeNum + i.adjforward.size() + i.adjbackward.size();
		}
		return edgeNum;
	}

	/**
	 * Retrieves the number of times a word appears in text.
	 * @param w - word to be looked for in graph
	 * @return - number of counts of that word in the file.
	 */
	public int wordCount(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		WordNode temp = new WordNode(w,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));
			return temp.counts;
		}
		else{
		return 0;
		}
	}

	/**
	 * Returns the number of unique words that precede word w.
	 * @param w - word to look up in graph.
	 * @return - the size of the backward adjacency list for the degree.
	 */
	public int inDegree(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		WordNode temp = new WordNode(w,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));
			int degree = temp.adjbackward.size();
			return degree;
		}
		else{
		return -1;
		}
	}

	/**
	 * Returns the number of unique words that follow word w.
	 * @param w - word to be looked up in the graph.
	 * @return - the size of the forward adjacency list to determine the degree.
	 */
	public int outDegree(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		WordNode temp = new WordNode(w,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));
			int degree = temp.adjforward.size();
			return degree;
		}
		else{
		return -1;
		}
	}
	

	/**
	 * Returns a String array of all words that preceded the word w,i.e all nodes that have a backwards connection to that word node.
	 * @param w - word to be looked up in the graph.
	 * @return - return the String array of the preceding words.
	 */
	public String[] prevWords(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		WordNode temp = new WordNode(w,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));	
			String[] prevwords = new String[temp.adjbackward.size()];
			for(int i = 0 ; i < temp.adjbackward.size();i++){
				prevwords[i] = temp.adjbackward.get(i).target.word;
			}
			return prevwords;
		}
		else{
			return new String[0];
		}
	}

	/**
	 * Returns a String array of all words that come after the word w,i.e all nodes that have a forward connection to that word node.
	 * @param w word to be looked up in the graph. 
	 * @return string array of the following connected words of of word node containing w.
	 */
	public String[] nextWords(String w){
		w = w.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		WordNode temp = new WordNode(w,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));	
			String[] nextwords = new String[temp.adjforward.size()];
			for(int i = 0 ; i < nextwords.length ;i++){
				nextwords[i] = temp.adjforward.get(i).target.word;
			}
			return nextwords;
		}
		else{
			return new String[0];	
		}
	}

	public double wordSeqCost(String[] wordSeq){
		String[] normalizedSeq = new String[wordSeq.length];
		for(int i = 0 ; i < wordSeq.length ; i++){
			normalizedSeq[i] = wordSeq[i].toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
			WordNode tempNode = new WordNode(normalizedSeq[i],-2);
			if(!words.contains(tempNode)){
				throw  new IllegalArgumentException();
			}
		}
		wordSeq = normalizedSeq;
		double cost = 0;
		WordNode temp1 = getNode(wordSeq[0]);
		cost += Math.log((double)list.size())/((double)temp1.counts);
		for(int i = 0 ; i < wordSeq.length - 1; i++){
			WordNode temp = getNode(wordSeq[i]);
			WordNode tempnext = getNode(wordSeq[i+1]);
			WordPair temppair = new WordPair(tempnext,1);
			if(temp.adjforward.contains(temppair)){
				cost += Math.log(((double)temp.counts/(double)(temp.costTo(tempnext))));
			
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		return cost;
	}
	
	
	private WordNode getNode(String s){
		WordNode temp = new WordNode(s,-1);
		if(words.contains(temp)){
			temp = words.get(words.indexOf(temp));
			return temp;
		}
		else{
			return null;
		}
	}

	public String generatePhrase(String startWord, String endWord, int N){
		return "";
	}
	
	

	public static void main(String[] args){

	}


}

