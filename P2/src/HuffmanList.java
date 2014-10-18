import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi EECS 233 P2 Constructs the initial linked list of
 *         HuffmanNodes to build the HuffmanTree.
 * @param <HuffmanNode>
 */
@SuppressWarnings("serial")
public class HuffmanList extends LinkedList<HuffmanNode> {

	/**
	 * Constructs the HuffmanList from the array of bytes.
	 * 
	 * @param b
	 */
	public HuffmanList(byte[] b) {
		ByteCounter counter = new ByteCounter(b);
		counter.setOrder("countInc");
		for (int i = 0; i < counter.byteList.size(); i++) {
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}

	/**
	 * Constructs the HuffmanList from a file.
	 * 
	 * @param file
	 *            - file location
	 * @throws IOException
	 */
	public HuffmanList(String file) throws IOException {
		ByteCounter counter = new ByteCounter(file);
		counter.setOrder("countInc");
		for (int i = 0; i < counter.byteList.size(); i++) {
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}

	/**
	 * Constructs a HuffmanList from an array of bytes and a separate array of
	 * their counts
	 * 
	 * @param b
	 *            - byte array
	 * @param array
	 *            - byte's count array
	 * @throws Exception
	 */
	public HuffmanList(byte[] b, int[] array) throws Exception {
		ByteCounter counter = new ByteCounter(b);
		if (counter.intList.size() != b.length) {
			throw new Exception();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 1) {
				throw new Exception();
			}
		}
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		for (int i = 0; i < b.length; i++) {
			byteList.add(b[i]);
		}
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < b.length; i++) {
			intList.add(array[i]);
		}
		/**
		 * Unnesscary use of reflection but too close to deadline to change,
		 * works.
		 */
		Class<ByteCounter> byteCounter = ByteCounter.class;
		Field field = byteCounter.getDeclaredField("byteList");
		field.setAccessible(true);
		field.set(counter, byteList);
		Field dos = byteCounter.getDeclaredField("intList");
		dos.setAccessible(true);
		dos.set(counter, intList);
		counter.setOrder("countInc");
		for (int i = 0; i < counter.byteList.size(); i++) {
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}

}
