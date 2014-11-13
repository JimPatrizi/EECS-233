import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233- P3
 * HashTable for string keys.
 *
 */
public class HashTable {
	
	/**
	 * ArrayList acting as a hashtable for our implementation for use with word stat. 
	 */
	private ArrayList<LinkedList<HashEntry>> hashtable = new ArrayList<LinkedList<HashEntry>>();
	
	/**
	 * The table's max size
	 */
	public int tablesize = 0;
	
	/**
	 * The number of items currently in the table.
	 */
	public int numItems = 0;
	
	public ArrayList<HashEntry> arrayform;
	
	
	 
	public ArrayList<HashEntry> getHashArray(){
		arrayform = new ArrayList<HashEntry>(numItems);
		for(LinkedList<HashEntry> list : hashtable){
			for(HashEntry item : list){
				arrayform.add(item);
			}
		
		}
		return arrayform;
	}
	

	
	/**
	 * 
	 */
	public HashTable(){
	    hashtable = new ArrayList<LinkedList<HashEntry>>(100);
		this.tablesize = 100;
		for(int i = 0; i < tablesize; i++){
			hashtable.add(i,new LinkedList<HashEntry>());
		}
	}
	
	/**
	 * 
	 * @param size -size of hashtable user wants
	 */
	public HashTable(int size){
		hashtable = new ArrayList<LinkedList<HashEntry>>(size);
		this.tablesize = size;
		for(int i = 0; i < tablesize; i++){
			hashtable.add(i,new LinkedList<HashEntry>());
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, int value){
		if(value == 0){
			throw new NullPointerException();
		}
		if(computeLoadFactor() < 1.0){
			HashEntry newEntry = new HashEntry(key,value);
			int index = Math.abs(newEntry.getKey().hashCode()%tablesize);
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
		else{
			rehash();
			HashEntry newEntry = new HashEntry(key,value);
			int index = Math.abs(newEntry.getKey().hashCode()%tablesize);
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
	}
	
	public void rehash(){
		HashTable copy = new HashTable(tablesize * 2);
		for(LinkedList<HashEntry> i : hashtable){
			for(HashEntry element : i){
				copy.put(element.getKey(),element.getValue());
			}
		}
		tablesize = tablesize*2;
		numItems = copy.getNumItems();
		hashtable = copy.getHashTable();
	}
	
	public int getNumItems(){
		return this.numItems;
	}
	
	public double computeLoadFactor(){
		double loadfactor = (getNumItems()+ 1)/tablesize;
		return loadfactor;
	}
	
	public ArrayList<LinkedList<HashEntry>> getHashTable(){
		return hashtable;
	}
	
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @param hashCode
	 */
	public void put(String key, int value, int hashCode){
		if(computeLoadFactor() < 1.0){
			HashEntry newEntry = new HashEntry(key,value);
			int index = Math.abs(hashCode) % tablesize;
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
		else{
			rehash();
			HashEntry newEntry = new HashEntry(key,value);
			int index = Math.abs(hashCode) % tablesize;
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void update(String key, int value){
		int index = Math.abs(key.hashCode()) % tablesize;
		LinkedList<HashEntry> list = hashtable.get(index);
		if(list.size()==0){
			put(key,value);
		}
		else if(!list.contains(new HashEntry(key,value))){
			put(key,value);
		}
		else {
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getKey().equals(key)){
					list.get(i).setValue(value);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public int get(String key){
		int index = Math.abs(key.hashCode()) % tablesize;
		LinkedList<HashEntry> list = hashtable.get(index);
		if(list.size() == 0){
			return -1;
		}
		
		else{
			for(int i = 0 ; i < list.size(); i++){
				if(list.get(i).getKey().equals(key)){
					return list.get(i).getValue();
				}
			}
		}
		return -1;
	}
	
	public int get(String key, int hashCode){
		int index = Math.abs(hashCode) % tablesize;
		LinkedList<HashEntry> list = hashtable.get(index);
		if(list.size() == 0){
			return -1;
		}
		
		else{
			for(int i = 0 ; i < list.size(); i++){
				if(list.get(i).getKey().equals(key)){
					return list.get(i).getValue();
				}
			}
		}
		return -1;
	}
}
		


