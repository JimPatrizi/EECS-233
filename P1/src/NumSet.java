/**
 * Provides minimal functionality for a set of numbers
 * @author James Patrizi
 * EECS 233 P1
 *
 */
public class NumSet {
	
	private NumArrayList list; //the set using the NumArrayList ADT
	
	/**
	 * Constructor that passes a double array into
	 * a set format of the NumArrayList ADT.
	 * @param array - array that defines the NumSet
	 */
	public NumSet(double[] array){
		list = new NumArrayList(array.length);
		for(int i = 0;  i < array.length; i++){
			list.add(array[i]);
		}
		list.removeDuplicates();
	}
	
	/**
	 * 
	 * @return the NumArrayList that is storing set.
	 */
	public NumArrayList getList(){
		return list;
	}
	
	/**
	 * 
	 * @return- returns the size of the set.
	 */
	public int size(){
		return getList().size();
	}
	
	
	public boolean contains(double value){
		return getList().contains(value);
	}
}
	
	
	
	
	
	
	
	


