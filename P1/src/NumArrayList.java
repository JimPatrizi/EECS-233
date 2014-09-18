/**
 * Represents an ordered sequence of double precision floating point numbers.
 * Array Implementation. EECS 233 P1
 * 
 * @author James Patrizi
 *
 */
public class NumArrayList implements NumList {

	public double[] list = null; // list itself.
	private int capacity; // max capacity of the list
	private int num = 0; // current size of the list

	// private static final int DEFAULT_CAPACITY = 100;

	/**
	 * Constructor that initializes list to default capacity.
	 */
	public NumArrayList() {
		this(0);
	}

	/**
	 * Constructor that initializes list to user defined capacity.
	 * 
	 * @param capacity - the size of the list to be created.
	 */
	public NumArrayList(int capacity) {
		this.capacity = capacity;
		list = new double[capacity]; // this is null array
		num = 0;
	}

	/**
	 * 
	 * @return-current number of items in the list.
	 */
	public int size() {
		return this.num;
	}

	/**
	 * 
	 * @return - the total capacity of the array.
	 */
	public int capacity() {
		return this.capacity;
	}

	/**
	 * Adds the specified double value to the list. also helps keep track of the
	 * total sum.
	 * 
	 * @param value
	 *            - value to be added to array.
	 * 
	 */
	public void add(double value) {
		if (num == capacity) {
			double temp[] = new double[capacity + 1];
			for (int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			list = temp;
			this.capacity = 1 + capacity;
		}
		this.list[num] = value;
		num++;
	}

	/**
	 * Inserts a new element before the i-th index.
	 * 
	 * @param i
	 *            - we insert the item right before this index
	 * @param value
	 *            - value to be inserted.
	 */
	public void insert(int i, double value) {
		if (i > num) {
			this.add(value);
		} else {
			for (int j = list.length - 2; j >= i; j--) {
				list[j + 1] = list[j];
			}
			list[i] = value;
			num++;
		}

	}

	public void remove(int i) {
	}

	public boolean contains(double value) {
		for (int i = 0; i <= list.length - 1; i++) {
			if (list[i] == value) {
				return true;
			}
		}
		return false;
	}

	public double lookup(int i) {
		if (i > num) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.list[i];
	}

	public boolean equals(NumList otherList) {
		return (toString().equals(otherList.toString()));
	}

	public void removeDuplicates() {

	}

	/**
	 * Converts the contents of the array to a string in the form "0.0 0.0 0.0".
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		// result.append("[");
		for (int i = 0; i <= list.length - 1; i++) { // traverses array and
														// appends every index
														// to result.
			result.append(list[i]);
			if (i != list.length - 1) {
				result.append(" ");
			}
		}
		// result.append("]");
		return result.toString();
	}
}
