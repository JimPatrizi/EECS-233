import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	/**
	 * List of the Words and holds the tokenized file.
	 */
	public ArrayList<String> list;
	
	/**
	 * Hash table of the tokenized file.
	 */
	public HashTable table;
	
	/**
	 * HashEntry[] of the Hashentries in order of decreasing rank, with the highest rank at index 0.
	 */
	public HashEntry[] rankarray;
	
	/**
	 * List of the tokenized word pairs.
	 */
	public ArrayList<String> pairlist;
	
	/**
	 * HashTable of the word pairs.
	 */
	public HashTable pairtable;
	
	/**
	 * HashEntry[] of the Hashentries of word pairs in order of decreasing rank, with the highest rank at index 0.
	 */
	public HashEntry[] pair_rank_array;
 	
	/**
	 * Computes various word statistics.
	 * @param file file to be read and performed statistics on
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public WordStat(String file) throws IOException, FileNotFoundException{
		list = new Tokenizer(file).wordList();
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
		
		
		list = new Tokenizer(file).wordList();
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
		ArrayList<HashEntry> arrayListOfPairEntries = new ArrayList<HashEntry>((int)(pairtable.getNumItems()));
		ArrayList<LinkedList<HashEntry>> pairHashTable = pairtable.getHashTable();
		for(LinkedList<HashEntry> s : pairHashTable){
			for(HashEntry e : s){
				arrayListOfPairEntries.add(e);
			}
		}
		pair_rank_array = arrayListOfPairEntries.toArray(new HashEntry[(int)(pairtable.getNumItems())]);
		Arrays.sort(pair_rank_array);
	}
	
	
	/**
	 * Computes various word statistics on a String[]
	 * @param array String[] to compute the stats from. 
	 */
	public WordStat(String[] array){
		list = new Tokenizer(array).wordList();
		table = new HashTable(list.size() * 2);
		ArrayList<HashEntry> listOfEntries = new ArrayList<HashEntry>((int)(table.getNumItems()));
		//Goes through the list of words and updates the hashtable.
		for(String i : list){
			int count = table.get(i);
			if(count == -1){
				table.update(i,1);
			}
			else{
				table.update(i, count+1);
			}
		}
		//helper method to convert hashtable to ArrayList<HashEntry> in HashTable
	    listOfEntries = table.getHashArray();
		rankarray = listOfEntries.toArray(new HashEntry[(int)(table.getNumItems())]);
		//sorts in descending order.
		Arrays.sort(rankarray);
		
		
		list = new Tokenizer(array).wordList();
		pairlist = new ArrayList<String>(list.size());
		pairtable = new HashTable(list.size() * 2);
		pair_rank_array = new HashEntry[list.size()];
		
		pairtable = new HashTable((list.size()-1)*2);
		int i = 0;
		int j = 1;
		int value;
		//gets the counts and words and updates the pairtable.
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
		
		ArrayList<HashEntry> arrayListOfPairEntries = new ArrayList<HashEntry>((int)(pairtable.getNumItems()));
		ArrayList<LinkedList<HashEntry>> pairHashTable = pairtable.getHashTable();
		for(LinkedList<HashEntry> s : pairHashTable){
			for(HashEntry e : s){
				arrayListOfPairEntries.add(e);
			}
		}
		pair_rank_array = arrayListOfPairEntries.toArray(new HashEntry[(int)(pairtable.getNumItems())]);
		Arrays.sort(pair_rank_array);
	}
			
	/**
	 * Gets the word count of the specified word.
	 * @param word the word to be seen if you get a word count. 
	 * @return Returns the number of times the word appears in the file.
	 */
	public int wordCount(String word){
		word = word.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
		if(table.get(word) == -1){
			return 0;
		}
		else{
			return table.get(word);
		}
	}
	
	/**
	 * Gets the Rank of the word.
	 * @param word - finds this word's rank.
	 * @return
	 */
	public int wordRank(String word){
		word = word.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
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
	
	/**
	 * Gets the most common words in the file.
	 * @param k number of the most common words in the file
	 * @return returns the String[] of k most words in the file.
	 */
	public String[] mostCommonWords(int k){
		String[] common = new String[k];
		for(int i = 0 ; i < k; i++){
			common[i] = rankarray[i].getKey();
		}
		return common;
	}
	
	/**
	 * Gets the least common words in the file.
	 * @param k number of the least common words in the file.
	 * @return returns the String[] of k least common words in the file.
	 */
	public String[] leastCommonWords(int k){
		String[] leastcommon = new String[k];
		for(int i = 0; i < k; i++){
			leastcommon[i] = rankarray[(rankarray.length-1) - i].getKey();
		}
		return leastcommon;
	}
	
	/**
	 * Gets the word pair count.
	 * @param w1 word 1
	 * @param w2 word 2
	 * @return returns the number of times the word pair occurs.
	 */
	public int wordPairCount(String w1, String w2){
		w1 = w1.toLowerCase().replaceAll("\\s+","").replaceAll("\\W+","").replaceAll("\\p{Punct}+","");
		w2 = w2.toLowerCase().replaceAll("\\s+","").replaceAll("\\W+","").replaceAll("\\p{Punct}+","");
		String wordpair = w1 + " " + w2;
		if(table.get(wordpair) == -1){
			return 0;
		}
		else{
			return table.get(wordpair);
		}
	}
	
	/**
	 * Gets the word pair ranking.
	 * @param w1 word 1
	 * @param w2 word 2
	 * @return returns the rank of the word pair
	 */
	public int wordPairRank(String w1, String w2){
		w1 = w1.toLowerCase().replaceAll("\\s+","").replaceAll("\\W+","").replaceAll("\\p{Punct}+","");
		w2 = w2.toLowerCase().replaceAll("\\s+","").replaceAll("\\W+","").replaceAll("\\p{Punct}+","");
		String wordpair = w1 + " " + w2;
		int index = 0;
		while(index < pair_rank_array.length && wordpair.equals(pair_rank_array[index].getKey())== false ){
			index++;
		}
		if(index==0){
			return index + 1;
		}
		else{
			if(index == pair_rank_array.length){
				return 0;
			}
			if(pair_rank_array[index].getValue() != pair_rank_array[index-1].getValue()){
				return index + 1;
			}
			else{
				while(index > 0 && pair_rank_array[index].getValue() == pair_rank_array[index -1].getValue()){
					index = index -1;
				}
				return index + 1;
			}
		}

	}
	/**
	 * Gets the most common word pairs 
	 * @param k number of common word pairs
	 * @return returns the string[] of k most common word pairs.
	 */
	public String[] mostCommonWordPairs(int k){
		String[] common = new String[k];
		for(int i = 0 ; i < k; i++){
			common[i] = pair_rank_array[i].getKey();
		}
		return common;
	}
	
	/**
	 * Returns the k most common words at a given position + or - 1 of the baseword
	 * @param k number of words to get
	 * @param baseWord baseword to base collocations about.
	 * @param i + or - 1 of baseword is only functionality. 
	 * @return String[] of the k most common words at a given position +- 1 of baseword.
	 */
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
