import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * Computes the count of each byte from a file or byte[]
 * 
 * @author James Patrizi EECS 233 P2
 *
 */
public class ByteCounter {

	/**
	 * Initializes an ArrayList of Bytes
	 */
	public ArrayList<Byte> byteList = new ArrayList<Byte>(); 

	/**
	 * an ArrayList of Integers that keep track of the counts of each Byte.
	 */
	public ArrayList<Integer> intList = new ArrayList<Integer>();
	

	/**
	 * keeps track of the current order of this bytecounter object
	 */
	private String order = "default";

	/**
	 * Constructor for byte counter object with the given byte []
	 * 
	 * @param b
	 *            -byte Array to be counted
	 */
	public ByteCounter(byte[] b) {
		for (byte i : b) {
			if (!byteList.contains(i)) {
				byteList.add(i);
				intList.add(1);
			} else {
				Integer m = intList.get(byteList.indexOf(i));
				intList.set(byteList.indexOf(i), m + 1);
			}
		}
	}

	/**
	 * Constructor that creates object from an input file.
	 * 
	 * @param file
	 *            -file to be converted to bytes and counted.
	 * @throws IOException
	 */
	public ByteCounter(String file) throws IOException {
		this(Files.readAllBytes(Paths.get(file)));
	}

	/**
	 * Returns the count of the byte
	 * 
	 * @param b
	 *            - byte
	 * @return - return count of that byte b.
	 */
	public int getCount(byte b) {
		int index = byteList.indexOf(b);
		return intList.get(index);
	}

	/**
	 * Get the count of the entire byte array.
	 * 
	 * @param b
	 *            - byte []
	 * @return - int [] with bytes count corresponding to the same index.
	 */
	public int[] getCount(byte[] b) {
		int[] array = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			array[i] = getCount(b[i]);
		}
		return array;
	}

	/**
	 * Returns the elements of the bytecounter object.
	 * 
	 * @return- byte array of the object.
	 */
	public byte[] getElements() {
		String orderSaved = order;
		byte[] array = new byte[byteList.size()];
		setOrder("byte");
		for (int i = 0; i < byteList.size(); i++) {
			array[i] = byteList.get(i);
		}
		order = orderSaved;
		return array;
	}

	/**
	 * Sets the order of the elements to byte order through input "byte", increasing order of count and decreasing count, "countInc" and "countDec" respectively.
	 * @param order - String what the user wants the order to be.
	 */
	public void setOrder(String order) {
		LinkedList<Byte> bytelink = new LinkedList<Byte>();
		LinkedList<Integer> countlink = new LinkedList<Integer>();

		if (order == "byte") {
			this.order = "byte";
			bytelink.add(byteList.get(0));
			countlink.add(intList.get(0));
			for (int i = 1; i < byteList.size(); i++) {
				// travel left while the byte is less than the next byte left
				int j = i;
				while (j > 0
						&& byteList.get(i).compareTo(bytelink.get(j - 1)) < 0)
					j--;
				bytelink.add(j, byteList.get(i));
				countlink.add(j, intList.get(i));
			}
			byteList = new ArrayList<Byte>(bytelink);
			intList = new ArrayList<Integer>(countlink);
		}

		if (order == "countInc") {
			this.order = "countInc";
			bytelink.add(byteList.get(0));
			countlink.add(intList.get(0));
			for (int i = 1; i < intList.size(); i++) {
				// travel left while the count is less than the next count left
				int j = i;
				while (j > 0
						&& intList.get(i).compareTo(countlink.get(j - 1)) < 0)
					j--;
				// post condition: (j - 1) is the index of a count less than or
				// equal to this count and all counts at and to the right of j
				// are greater

				// if counts are equal, place according to byte order
				if (j > 0
						&& intList.get(i).compareTo(countlink.get(j - 1)) == 0) {
					// if this byte is greater, place to the right of (j - l)
					if (byteList.get(i).compareTo(bytelink.get(j - 1)) > 0) {
						countlink.add(j, intList.get(i));
						bytelink.add(j, byteList.get(i));
					}
					// if this byte is smaller
					else {
						// move until there's no more bytes smaller, then add at
						// j
						while (j > 0
								&& intList.get(i).compareTo(
										countlink.get(j - 1)) == 0
										&& byteList.get(i).compareTo(
												bytelink.get(j - 1)) < 0)
							j--;
						// post condition: j - 1 is not equal in count, or this
						// byte is greater than j - 1
						countlink.add(j, intList.get(i));
						bytelink.add(j, byteList.get(i));
					}
				}
				// if counts are not equal, place at index j
				else {
					countlink.add(j, intList.get(i));
					bytelink.add(j, byteList.get(i));
				}
			}
			byteList = new ArrayList<Byte>(bytelink);
			intList = new ArrayList<Integer>(countlink);
		}

		if (order == "countDec") {
			this.order = "countDec";
			bytelink.add(byteList.get(0));
			countlink.add(intList.get(0));
			for (int i = 1; i < intList.size(); i++) {
				// new index to traverse list
				int j = i;
				// travel left while the count is less than the next count left
				while (j > 0
						&& intList.get(i).compareTo(countlink.get(j - 1)) > 0)
					j--;
				// post condition: (j - 1) is the index of a count greater than
				
				// or equal to this count and all counts at and to the right of
				
				// j are less

				// if counts are equal, place according to byte order
				if (j > 0
						&& intList.get(i).compareTo(countlink.get(j - 1)) == 0) {
					// if this byte is greater, place to the right of (j - l)
					if (byteList.get(i).compareTo(bytelink.get(j - 1)) > 0) {
						countlink.add(j, intList.get(i));
						bytelink.add(j, byteList.get(i));
					}
					// if this byte is smaller
					else {
						// move until there's no more bytes smaller, then add at
						// j
						while (j > 0
								&& intList.get(i).compareTo(
										countlink.get(j - 1)) == 0
										&& byteList.get(i).compareTo(
												bytelink.get(j - 1)) < 0)
							j--;
						// post condition: j - 1 is not equal in count, or this
						
						// byte is greater than j - 1
						countlink.add(j, intList.get(i));
						bytelink.add(j, byteList.get(i));
					}
				}
				// if counts are not equal, place at index j
				else {
					countlink.add(j, intList.get(i));
					bytelink.add(j, byteList.get(i));
				}
			}
			byteList = new ArrayList<Byte>(bytelink);
			intList = new ArrayList<Integer>(countlink);
		}
	}

	/**
	 * Returns a String of the values of byte counter byte: count
	 * @return - byte: count
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteList.size() - 1; i++) {
			sb.append(byteList.get(i).intValue());
			sb.append(':');
			sb.append(intList.get(i));
			sb.append(" ");
		}
		sb.append(byteList.get(byteList.size() - 1));
		sb.append(':');
		sb.append(intList.get(byteList.size() - 1));
		return sb.toString();
	}

	/**
	 * Returns a string of the values within the object in a user defined format. Can be of the byte values or the char represented by byte value.
	 * @param format char or byte
	 * @return - ? : 1
	 */
	public String toString(String format) {
		if (format == "char") {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteList.size() - 1; i++) {
				sb.append((char) (byteList.get(i).byteValue()));
				sb.append(':');
				sb.append(intList.get(i));
				sb.append(" ");
			}
			sb.append((char) (byteList.get(byteList.size() - 1).byteValue()));
			sb.append(':');
			sb.append(intList.get(byteList.size() - 1));
			return sb.toString();
		} else {
			return this.toString();
		}
	}
}
