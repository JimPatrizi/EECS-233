/**
 * Represents an ordered sequence of double precision floating point numbers. LinkedList Implementation.
 * EECS 233 P1
 * @author James Patrizi
 *
 */
public class NumLinkedList implements NumList {
	
	/**
	 * Node class
	 */
	private class LLNode{
	
		private double element; //Stores value of the node
		private LLNode next;//a reference to the next node in the list.
		
		/**
		 * the constructor of the node.
		 * @param element - element in node
		 * @param next - reference to the next node in the list.
		 */
		public LLNode(double element , LLNode next){
			this.element = element;
			this.next = next;
		}
		
		/**
		 * Returns the element.
		 * @return -element of the current node in the list.
		 */
		public double getElement(){
			return this.element;
		}
		
		/**
		 * Returns the address of the next node.
		 * @return - returns the address of the next node in the list.
		 */
		public LLNode next(){
			return this.next;
		}
		
		
		public void setNext(LLNode next){
			this.next = next;
		}
	}
	
	private LLNode head;//holds the head of the linked list.
	private LLNode tail;//holds the tail of the linked list.
	private int size; //number of elements in the list.
	
	/**
	 * Constructor that created an empty linked list.
	 */
	public NumLinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * @return - returns the address of the head of the list.
	 */
	public LLNode getHead(){
		return this.head;
	}
	
	/**
	 * 
	 * @return - returns the address of the tail of the list.
	 */
	public LLNode getTail(){
		return this.tail;
	}
	
	/**
	 * @return - returns the size of the list.
	 */
	public int size() {
		return this.size;
	}

	
	public void add(double value) {
		// TODO Auto-generated method stub
		
	}

	
	public void insert(int i, double value) {
		// TODO Auto-generated method stub
		
	}

	
	public void remove(int i) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return false;
	}

	
	public void removeDuplicates() {
		// TODO Auto-generated method stub
		
	}

}
