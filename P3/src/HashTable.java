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
	
	/**
	 * Array list of the hashtable.
	 */
	public ArrayList<HashEntry> arrayform;
	
	
	/**
	 * Constructs the HashTable. Initializes the linked list in each array index.
	 */
	public HashTable(){
	    hashtable = new ArrayList<LinkedList<HashEntry>>(100);
		this.tablesize = 100;
		for(int i = 0; i < tablesize; i++){
			hashtable.add(i,new LinkedList<HashEntry>());
		}
	}
	
	/**
	 * Constructs the HashTable. Initializes the linked list in each array index. User defines size of table.
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
	 * Puts HashEntry in HashTable.
	 * @param key - String in this HashEntry key
	 * @param value - Value of the occurences of the key and is stored in HashEntry.
	 */
	public void put(String key, int value){
		if(value == 0){
			throw new NullPointerException();
		}
		if(computeLoadFactor() < 1.0){
			HashEntry newEntry = new HashEntry(key,value);
			//computes hash index using javas hashcode and mod by table size to get the appropriate index. Used later in this logic as well.
			int index = Math.abs(newEntry.getKey().hashCode()%tablesize);
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
		else{
			//rehashes if the load factor is greater than 1.
			rehash();
			HashEntry newEntry = new HashEntry(key,value);
			int index = Math.abs(newEntry.getKey().hashCode()%tablesize);
			hashtable.get(index).add(newEntry);
		    numItems++;
		}
	}
	
	/**
	 * Rehashes the current Hashtable and doubles the size.
	 */
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
	
	/**
	 * 
	 * @return - Returns the number of items currently in the table.
	 */
	public int getNumItems(){
		return this.numItems;
	}
	
	/**
	 * Computes the load factor of table.
	 * @return - returns load factor which is the ratio of how full the table is of items to max capacity.
	 */
	public double computeLoadFactor(){
		double loadfactor = (getNumItems()+ 1)/tablesize;
		return loadfactor;
	}
	
	/**
	 * 
	 * @return returns this hashtable.
	 */
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
	 * Updates the hashtable.
	 * @param key - key to be updated. If not in table already, it is added and assigned a value of 1.
	 * @param value - value of this key (num of occurences). If key is already in table, it updates that keys value to this value. 
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
	 * Gets the keys value.
	 * @param key - Key to be found.
	 * @return returns keys value.
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
	
	/**
	 * Gets the value of this key.
	 * @param key - key to be found.
	 * @param hashCode - user defined hashcode.
	 * @return - returns the keys value.
	 */
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
	
	/**
	 * Gets all items in the whole hashtable and adds to an ArrayList of HashEntrys. 
	 * @return - the hashtable as an ArrayList of HashEntries.
	 */
	public ArrayList<HashEntry> getHashArray(){
		arrayform = new ArrayList<HashEntry>(numItems);
		for(LinkedList<HashEntry> list : hashtable){
			for(HashEntry item : list){
				arrayform.add(item);
			}
		
		}
		return arrayform;
	}
}
		


