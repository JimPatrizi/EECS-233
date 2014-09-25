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

	public void insert(int i, double value) {
		LLNode ndptr = getHead();
		LLNode node = new LLNode(value,null);
		if(i == 0){
			node.setNext(head);
		}
		if(i == size){
			node.setNext(null);
			this.getTail().setNext(node);
			this.setTail(node);
		}
		else{
			for(int index = 0; index < i -1; index++){
				ndptr = ndptr.next();
				LLNode keep = ndptr.next();
				LLNode add = new LLNode(value,null);
				ndptr.setNext(add);
				ndptr.next().setNext(keep);
				size++;
				
			}
			
		}
			
	}

	public void remove(int i) {
		

	}

	public boolean contains(double value) {
		// TODO Auto-generated method stub
		return false;
	}

	public double lookup(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean equals(NumList otherList) {
		return (this.toString().equals(otherList.toString()));
	}

	public void removeDuplicates() {
		// TODO Auto-generated method stub

	}

	public String toString() {
		if (size == 0) {
			return "";
		} else {
			StringBuilder result = new StringBuilder();
			LLNode ndptr = getHead();
			for (; ndptr.next() != getTail(); ndptr = ndptr.next()) {// will
																		// loop
																		// to
																		// second
																		// to
																		// last
																		// node.
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
