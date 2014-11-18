/**
 * 
 * @author James Patrizi
 * EECS 233-P3
 * Entries in the HashTable Class
 *
 */
public class HashEntry implements Comparable<Object> {
	
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
	
	@Override
	public boolean equals(Object obj1){
		if(obj1 instanceof HashEntry){
			if(this.key.equals(((HashEntry) obj1).key)){
				return true;
			}
		}
		
			return false;
		}
	
	

	@Override
	public int compareTo(Object obj1) {
		if(obj1 instanceof HashEntry){
			if(this.value == ((HashEntry) obj1).value){
				return this.key.compareTo(((HashEntry)obj1).key);
			}
		    return ((HashEntry)obj1).value - this.value;
		  
			  
		  }
		return 0;
		}
	
		
	}
	
	
	


