/**
 * 
 * @author James Patrizi EECS 233 P2 Node class that will be used to create a
 *         linked list to create a huffman tree.
 */
public class HuffmanNode {

	/**
	 * Byte to be stored
	 */
	public byte b;

	/**
	 * Count of this byte
	 */
	public int count;

	/**
	 * Code thus far in the tree.
	 */
	public  boolean[] code;

	/**
	 * Holds reference to this nodes left child.
	 */
	public HuffmanNode left;

	/**
	 * Holds refernce to this nodes right child.
	 */
	public HuffmanNode right;

	/**
	 * Constructor that passes in the byte and count for this node.
	 * 
	 * @param b
	 *            - byte
	 * @param c
	 *            - count
	 */
	public HuffmanNode(byte b, int c) {
		this.count = c;
		this.b = b;
		this.left = null;
		this.right = null;
	}
}
