
public class NumArrayList {
	
	private double [] list = null; //list itself. 
	private int capacity; //max capacity of the list
	private int num = 0; //current size of the list
	private static final int DEFAULT_CAPACITY = 100;
	

	public NumArrayList(){
		this(DEFAULT_CAPACITY);
		}
	
	public NumArrayList(int capacity){
		this.capacity = capacity;
		list = new double[capacity]; //this is null array
		num = 0;
	}
	
	public int size(){
		return this.num;
	}
	
	public int capacity(){
		return this.capacity;
	}
	
	public void add(double value){
		
	}
	
		
}
