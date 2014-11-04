/**
 * 
 * @author James Patrizi
 * EECS 233-P3
 * Entries in the HashTable Class
 *
 */
public class HashEntry {
	
	/**
	 * Stores the String in each Hash entry.
	 */
	private String key = "";
	
	/**
	 * Stores the value of the key entry.
	 */
	private int value = 0;
	
	/**
	 * Initializes HashEntry with key and value.
	 * @param key - the Word in each key
	 * @param value - the value of the key
	 */
	public HashEntry(String key, int value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * 
	 * @return - returns the key of the HashEntry
	 */
	public String getKey(){
		return this.key;
	}
	
	/**
	 * 
	 * @return value of the HashEntry
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Sets value parameter
	 * @param value - changes value to this value.
	 */
	public void setValue(int value){
		this.value = value;
	}
	
	

}
