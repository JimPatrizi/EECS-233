import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233 - P3
 * Computes Word stats from the HashTable
 *
 */
public class WordStat {
	
	public ArrayList<String> list;
	public HashTable table;
	public ArrayList<HashEntry> ranklist;
 	
	
	public WordStat(String file){
		
	}
	
	public WordStat(String[] array){
		list = new Tokenizer(array).wordList();
		table = new HashTable(list.size() * 2);
		for(String i : list){
			int count = table.get(i);
			if(count == -1){
				table.update(i,1);
			}
			else{
				table.update(i, count+1);
			}
		}
		ranklist = table.getHashArray();
		
			
		}
			
		
	
	
	public int wordCount(String word){
		word = word.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","");
		if(table.get(word) == -1){
			return 0;
		}
		else{
			return table.get(word);
		}
	}
	
	public int wordRank(String word){
		return 0;
	}
	
	public String[] mostCommonWords(int k){
		return null;
	}
	
	public String[] leastCommonWords(int k){
		return null;
	}
	
	public int wordPairCount(String w1, String w2){
		return 0;
	}
	
	public int wordPairRank(String w1, String w2){
		return 0;
	}
	
	public String[] mostCommonWordPairs(int k){
		return null;
	}
	
	public String[] mostCommonCollocs(int k, String baseWord, int i){
		return null;
	}
	
	public String[] mostCommonCollocsExc(int k, String baseWord, int i, ArrayList<String> exclusions){
		return null;
	}
	
	public String generateWordString(int k, String startWord){
		return null;
	}
	
	

}
