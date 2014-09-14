/**
 * Represents an ordered sequence of double precison floating point numbers. Array Implementation.
 * EECS 233 P1
 * @author James Patrizi
 *
 */
public class NumArrayList {
	
	private double [] list = null; //list itself. 
	private int capacity; //max capacity of the list
	private int num = 0; //current size of the list
	private static final int DEFAULT_CAPACITY = 100; //default capacity
	
    /**
     * Constructor that initializes list to default capacity. 
     */
	public NumArrayList(){
		this(DEFAULT_CAPACITY);
		}
	
	/**
	 * Constructor that initializes list to user defined capacity.
	 * @param capacity - the size of the list to be created.
	 */
	public NumArrayList(int capacity){
		this.capacity = capacity;
		list = new double[capacity]; //this is null array
		num = 0;
	}
	
	/**
	 * 
	 * @return-current number of items in the list.
	 */
	public int size(){
		return this.num;
	}
	
	/**
	 * 
	 * @return - the total capacity of the array.
	 */
	public int capacity(){
		return this.capacity;
	}
	
	/**
	 * Adds the specified double value to the list. also helps keep track of the total sum.
	 * @param value - value to be added to array.
	 * @throws ArrayIndexOutOfBoundsException - thrown if user tries to add to array and its already at capacity.
	 */
	public void add(double value) throws ArrayIndexOutOfBoundsException{
		if(num == capacity) {
			throw new ArrayIndexOutOfBoundsException("list capacity exceeded");
		}
		this.list[num] = value;
		num++;
	}
	
	/**
	 * Inserts a new element before the i-th index. 
	 * @param i - we insert the item right before this index
	 * @param value - value to be inserted.
	 */
	public void insert(int i, double value){
		if (i > num) {
			this.add(value);
		}
		else {
			this.list[i-1] = value;
			num++;
		}
	
	}
	
	public void remove(int i){
	}
	
	public boolean contains(double value){
		return false;
	}
	
	public double lookup(int i){
		return 0;
	}
	
	public boolean equals(NumArrayList otherList){
		return false;
	}
	
	public void removeDupilcates() {
		
	}
	
	/**
	public void toString() {
		
	}
	**/
}
