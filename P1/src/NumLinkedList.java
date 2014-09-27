/**
 * Represents an ordered sequence of double precision floating point numbers.
 * LinkedList Implementation. EECS 233 P1
 * 
 * @author James Patrizi
 *
 */
public class NumLinkedList implements NumList {

	/**
	 * Node class
	 */
	private class LLNode {

		private double element; // Stores value of the node
		private LLNode next;// a reference to the next node in the list.

		/**
		 * the constructor of the node.
		 * 
		 * @param element
		 *            - element in node
		 * @param next
		 *            - reference to the next node in the list.
		 */
		public LLNode(double element, LLNode next) {
			this.element = element;
			this.next = next;
		}

		/**
		 * Returns the element.
		 * 
		 * @return -element of the current node in the list.
		 */
		public double getElement() {
			return this.element;
		}

		/**
		 * Returns the address of the next node.
		 * 
		 * @return - returns the address of the next node in the list.
		 */
		public LLNode next() {
			return this.next;
		}

		public void setNext(LLNode next) {
			this.next = next;
		}
	}

	private LLNode head;// holds the head of the linked list.
	private LLNode tail;// holds the tail of the linked list.
	private int size; // number of elements in the list.

	/**
	 * Constructor that created an empty linked list.
	 */
	public NumLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * @return - returns the address of the head of the list.
	 */
	public LLNode getHead() {
		return this.head;
	}

	/**
	 * 
	 * @return - returns the address of the tail of the list.
	 */
	public LLNode getTail() {
		return this.tail;
	}

	/**
	 * 
	 * @param node
	 *            - the node that head is then set to.
	 */
	public void setHead(LLNode node) {
		this.head = node;
	}

	/**
	 * 
	 * @param node
	 *            - the node that tail is then set to.
	 */
	public void setTail(LLNode node) {
		this.tail = node;
	}

	/**
	 * @return - returns the size of the list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * 
	 * @param value
	 *            -sets size to this value
	 */
	public void setSize(int value) {
		this.size = value;
	}
	
	/**
	 * Adds a value to the list.
	 * @param value - the value to be added to the list.
	 */
	public void add(double value) {
		if (size == 0) {
			setHead(new LLNode(value, null));
			setTail(getHead());
			this.size = 1;
		} else {
			LLNode nextNode = new LLNode(value, null);
			getTail().setNext(nextNode);
			setTail(nextNode);
			size++;
		}

	}

	/**
	 * Inserts the specified value at point i in the list.
	 * @param i - the spot in the list where we want to insert the value.
	 * @param value - the value to be inserted in the list.
	 */
	public void insert(int i, double value) {
		LLNode ndptr = getHead();
		if (i >=size()) {
			add(value);
		}
			else {
			for (int index = 0; index < i - 1; index++) {
				ndptr = ndptr.next();
			}
				LLNode save = ndptr.next();
				LLNode adding = new LLNode(value,null);
				ndptr.setNext(adding);
				ndptr.next().setNext(save);
				setSize(size()+1);
			}
	}
	/**
	 * Removes the node at ith spot in the list.
	 * @param i - the index of what node we want to remove. 
	 */
	public void remove(int i) {
		LLNode ndptr = getHead();
		if (i == 0) {
			size--;
			setHead(getHead().next());
		} else if (i == size - 1) {
			for (int index = 0; index < i - 1; index++) {
				ndptr.setNext(null);
				setTail(ndptr);
				size--;
			}
		} else {
			for (int index = 0; index < i - 1; index++) {
				ndptr = ndptr.next();
			}
			ndptr.setNext(ndptr.next().next());
			size--;
		}
	}

	/**
	 * Tells us if the list contains the specified value, returns true for yes, false for no.
	 * @param value - the value that is checked if its in the list or not. The value.
	 */
	public boolean contains(double value) {
		LLNode ndptr = getHead();
		for (int index = 0; index < size; index++) {
			if (ndptr.getElement() == value) {
				return true;
			}
			ndptr = ndptr.next();
		}
		return false;
	}

	/**
	 * Looks up the node at index i and returns the element in that node. 
	 * @param i - index in the list to be looked up.
	 */
	public double lookup(int i) {
		LLNode ndptr = getHead();
		for (int index = 0; index < i; index++) {
			try{
			ndptr= ndptr.next();
		}
			 catch (IndexOutOfBoundsException c) {
				System.out.println(c.getMessage());
			}
		}
		return ndptr.getElement();
	}

	/**
	 * Checks if the equivalent numlist is equal by converting both lists to strings and comparing their equivalence. 
	 * @param otherList- the other NumList that is being compared to this list.
	 * @return true if the list is equivalent.
	 */
	public boolean equals(NumList otherList) {
		return (this.toString().equals(otherList.toString()));
	}

	/**
	 * Removes the duplicates in the list.
	 */
	public void removeDuplicates() {
		NumLinkedList noduplist = new NumLinkedList();
		LLNode ndptr = getHead();
		for (int index = 0; index < size - 1; index++) {
			if (!noduplist.contains(lookup(index))) {
				noduplist.add(lookup(index));
			}
			ndptr = ndptr.next();
		}
		if (!noduplist.contains(ndptr.getElement())) {
			noduplist.add(ndptr.getElement());
		}
		setHead(noduplist.getHead());
		setTail(noduplist.getTail());
		setSize(noduplist.size());

	}

	/**
	 * Convert list to string with no braces or spaces in between the ends of the string.
	 * @return - the list in string format.
	 */
	public String toString() {
		if (size == 0) {
			return "";
		} else {
			StringBuilder result = new StringBuilder();
			LLNode ndptr = getHead();
			for (; ndptr.next() != getTail(); ndptr = ndptr.next()) {
				result.append(ndptr.getElement());
				result.append(" ");
			}
			result.append(ndptr.getElement());
			result.append(" ");
			ndptr = ndptr.next();
			result.append(ndptr.getElement());
			return result.toString();
		}
	}
}
