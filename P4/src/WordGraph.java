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
	public ArrayList<WordNode> words;
	public int numWords;
	public int maxNum;


	public WordGraph(String file) throws IOException, FileNotFoundException{
		list = new Tokenizer(file).wordList();
		words = new ArrayList<WordNode>(list.size()); //this is the graph

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

			int i = 0;
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

	public int numEdges(){
		int edgeNum = 0;
		for(WordNode i : words){
			edgeNum = edgeNum + i.adjforward.size() + i.adjbackward.size();
		}
		return edgeNum;
	}

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
			return null;
		}
	}

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
			return null;	
		}
	}

	public double wordSeqCount(String[] wordSeq){
		return 0;
	}

	public String generatePhrase(String startWord, String endWord, int N){
		return "";
	}
	
	

	public static void main(String[] args){

	}


}
