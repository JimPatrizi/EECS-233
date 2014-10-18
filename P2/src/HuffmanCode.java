import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi EECS 233 P2 Class that constructs full HuffmanTree
 */
public class HuffmanCode {

	/**
	 * Stores the transformed HuffmanList into a huffman code tree.
	 */
	public HuffmanList tree;

	/**
	 * Stores original List.
	 */
	public HuffmanList ogList;

	/**
	 * Creates Huffman tree with the given byte[]
	 * 
	 * @param b
	 *            - byte array to be passed into a tree.
	 */
	public HuffmanCode(byte[] b) {
		HuffmanList list = new HuffmanList(b);
		ogList = list;
		while (list.size() > 1) {
			HuffmanNode lowest1 = list.remove(0);
			HuffmanNode lowest2 = list.remove(0);
			HuffmanNode newNode = new HuffmanNode((byte) 0, lowest1.count
					+ lowest2.count);
			newNode.left = lowest1;
			newNode.right = lowest2;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).count > newNode.count) {
					list.add(i, newNode);
					break;
				}
			}
			tree = list;
			traverseAndBuild(tree.getFirst(), null);
		}
	}

	/**
	 * Creates a Huffman tree given a text file.
	 * 
	 * @param file
	 *            - file location to be passed into the huffmantree.
	 * @throws IOException
	 */
	public HuffmanCode(String file) throws IOException {
		this(Files.readAllBytes(Paths.get(file)));
	}

	/**
	 * Creates a Huffman tree from the array of bytes and an array of their
	 * representative counts.
	 * 
	 * @param b
	 *            - byte array
	 * @param array
	 *            - count array
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws Exception
	 */
	public HuffmanCode(byte[] b, int[] array) throws IllegalArgumentException,
			NoSuchFieldException, SecurityException, IllegalAccessException,
			Exception {
		HuffmanList list = new HuffmanList(b, array);
		ogList = list;
		while (list.size() > 1) {
			HuffmanNode lowest1 = list.remove(0);
			HuffmanNode lowest2 = list.remove(0);
			HuffmanNode newNode = new HuffmanNode((byte) 0, lowest1.count
					+ lowest2.count);
			newNode.left = lowest1;
			newNode.right = lowest2;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).count > newNode.count) {
					list.add(i, newNode);
					break;
				}
			}
		}
		tree = list;
		traverseAndBuild(tree.getFirst(), null);
	}

	/**
	 * Gets the code of the node.
	 * 
	 * @param b
	 * @return
	 */
	public boolean[] code(byte b) {
		if (traverseAndSearch(tree.getFirst(), b) == null) {
			throw new IllegalArgumentException();
		}
		return traverseAndSearch(tree.getFirst(), b).code;
	}

	/**
	 * Returns the represented code of the node in string form.
	 * 
	 * @param b
	 * @return
	 */
	public String codeString(byte b) {
		boolean[] unformated = code(b);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < unformated.length; i++) {
			if (unformated[i] == true) {
				sb.append(1);
			}

			else {
				sb.append(0);
			}
		}
		return sb.toString();
	}

	public String toString() {
		return "eh";
	}

	/**
	 * Gos through and finds the byte in the tree
	 * 
	 * @param root
	 *            - root of tree
	 * @param b
	 *            - byte searching for
	 * @return - the HuffmanNode
	 */
	private HuffmanNode traverseAndSearch(HuffmanNode root, Byte b) {
		if (root.b == b) {
			return root;
		}

		if (root.left != null) {
			return traverseAndSearch(root.left, b);
		}

		if (root.right != null) {
			return traverseAndSearch(root.right, b);
		}
		return null;
	}

	/**
	 * Goes through the tree and builds the code
	 * 
	 * @param root
	 *            - root of tree
	 * @param prevCode
	 *            - code of node before this root.
	 */
	private void traverseAndBuild(HuffmanNode root, boolean[] prevCode) {
		LinkedList<Boolean> code = new LinkedList<Boolean>();
		if (root.left != null) {
			code.add(false);
			traverseAndBuild(root.left, addToArr(prevCode, false));
		}

		if (root.right != null) {
			code.add(true);
			traverseAndBuild(root.right, addToArr(prevCode, true));
		}

		if (root.left == null && root.right == null) {
			root.code = prevCode;
		}
	}

	/**
	 * Adds to a boolean[]
	 * 
	 * @param array
	 *            - array to be added to
	 * @param add
	 *            - boolean to be added
	 * @return - returns the newly added to boolean[]
	 */
	private boolean[] addToArr(boolean[] array, boolean add) {
		if (array == null) {
			boolean[] newArray = new boolean[] { add };
			return newArray;
		} else {

			boolean[] newArray = new boolean[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			newArray[array.length] = add;
			return newArray;
		}
	}
}
