import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	public HashEntry[] rankarray;
	public ArrayList<String> pairlist;
	public HashTable pairtable;
	public HashEntry[] pair_rank_array;
 	
	
	public WordStat(String file){
		
	}
	
	public WordStat(String[] array){
		list = new Tokenizer(array).wordList();
		table = new HashTable(list.size() * 2);
		ArrayList<HashEntry> listOfEntries = new ArrayList<HashEntry>((int)(table.getNumItems()));
		for(String i : list){
			int count = table.get(i);
			if(count == -1){
				table.update(i,1);
			}
			else{
				table.update(i, count+1);
			}
		}
	    listOfEntries = table.getHashArray();
		rankarray = listOfEntries.toArray(new HashEntry[(int)(table.getNumItems())]);
		Arrays.sort(rankarray);
		
		
		list = new Tokenizer(array).wordList();
		pairlist = new ArrayList<String>(list.size());
		pairtable = new HashTable(list.size() * 2);
		listOfEntries = new ArrayList<HashEntry>(pairtable.getNumItems());
		
		pairtable = new HashTable((list.size()-1)*2);
		int i = 0;
		int j = 1;
		int value;
		while(j < list.size()){
			value = pairtable.get(list.get(i) + " " + list.get(j));
			if(value == -1){
				pairtable.update(list.get(i) + " " + list.get(j), 1);
			}
			else{
				table.update(list.get(i) + " " + list.get(j), value +1);
			}
			i++;
			j++;
		}
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
		word = word.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","");
		int index = 0;
		while(index < rankarray.length && word.equals(rankarray[index].getKey())== false ){
			index++;
		}
		if(index==0){
			return index + 1;
		}
		else{
			if(index == rankarray.length){
				return 0;
			}
			if(rankarray[index].getValue() != rankarray[index-1].getValue()){
				return index + 1;
			}
			else{
				while(index > 0 && rankarray[index].getValue() == rankarray[index -1].getValue()){
					index = index -1;
				}
				return index +1;
			}
		}
		
	}
	
	public String[] mostCommonWords(int k){
		String[] common = new String[k];
		for(int i = 0 ; i < k; i++){
			common[i] = rankarray[i].getKey();
		}
		return common;
	}
	
	public String[] leastCommonWords(int k){
		String[] leastcommon = new String[k];
		for(int i = 0; i < k; i++){
			leastcommon[i] = rankarray[(rankarray.length-1) - i].getKey();
		}
		return leastcommon;
	}
	
	
	
	public int wordPairCount(String w1, String w2){
		String wordpair = (w1.toLowerCase().replaceAll("\\s+","").replaceAll("\\W",""))+ " " + (w2.toLowerCase().replaceAll("\\s+","").replaceAll("\\W",""));
		if(table.get(wordpair) == -1){
			return 0;
		}
		else{
			return table.get(wordpair);
		}
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
	
	public String[] mostCommonCollocsExc(int k, String baseWord, int i, String[] exclusions){
		return null;
	}
	
	public String generateWordString(int k, String startWord){
		return null;
	}
	
	

}
