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
	
	/**
	 * Lets instances of HashEntries be equated to.
	 * @param obj1 - object to be compared, but checked to see that's a HashEntry.
	 * @return - true if objects are equal, false if not.
	 */
	@Override
	public boolean equals(Object obj1){
		if(obj1 instanceof HashEntry){
			if(this.key.equals(((HashEntry) obj1).key)){
				return true;
			}
		}
		
			return false;
		}
	
	/**
	 * Compares HashEntries first by value, and then if same value sorts alphabetically.
	 * @param obj1 Compares object which is a HashEntry by value, and if the same value, compares alphabetically
	 * @return 1 if value is greater, -1 if value is less. If same value returns -1 if not in alphabet order
	 */
	@Override
	public int compareTo(Object obj1) {
		if(obj1 instanceof HashEntry){
			if(this.value == ((HashEntry) obj1).value){
				//Compares key alphabetically instead of by value if values are the same.
				return this.key.compareTo(((HashEntry)obj1).key);
			}
		    return ((HashEntry)obj1).value - this.value;
		  
			  
		  }
		return 0;
		}
	
		
	}
	
	
	


