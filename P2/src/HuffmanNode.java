/**
 * 
 * @author James Patrizi
 *EECS 233 P2
 *Node class that will be used to create a linked list to create a huffman tree.
 */
public class HuffmanNode {
	
	public byte b;
	
	public int count;
	
	public boolean[] code;
	
	//public HuffmanNode next;
	
	public HuffmanNode left;
	
	public HuffmanNode right;
	
	public HuffmanNode(byte b, int c){
		this.count = c;
		this.b = b;
		this.left = null;
		this.right = null;
	}
}
