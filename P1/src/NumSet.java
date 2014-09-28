/**
 * Provides minimal functionality for a set of numbers
 * 
 * @author James Patrizi EECS 233 P1
 *
 */
public class NumSet {

	private NumArrayList list; // the set using the NumArrayList ADT

	/**
	 * Constructor that passes a double array into a set format of the
	 * NumArrayList ADT.
	 * 
	 * @param array
	 *            - array that defines the NumSet
	 */
	public NumSet(double[] array) {
		list = new NumArrayList(array.length);
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		list.removeDuplicates();
	}

	/**
	 * 
	 * @return the NumArrayList that is storing set.
	 */
	public NumArrayList getList() {
		return list;
	}

	/**
	 * 
	 * @return- returns the size of the set.
	 */
	public int size() {
		return getList().size();
	}

	/**
	 * 
	 * @param value
	 *            -value that is checked to see if it is in the set
	 * @return - returns true if in the set, false if not in the set.
	 */
	public boolean contains(double value) {
		return getList().contains(value);
	}

	/**
	 * 
	 * @param S1
	 *            - set 1
	 * @param S2
	 *            - set 2
	 * @return - a new NumSet where S1 intersects S2, or S2 intersects S1
	 *         depending on size.
	 */
	public static NumSet intersect(NumSet S1, NumSet S2) {
		if (S1.size() > S2.size()) {
			int intersectSize = 0;
			for (int i = 0; i < S2.size(); i++) {
				if (S1.contains(S2.getList().lookup(i))) {
					intersectSize++;
				}
			}
			double[] array = new double[intersectSize];
			int index = 0;
			for (int i = 0; i < intersectSize; i++) {
				if (S1.contains(S2.getList().lookup(i))) {
					array[index] = S2.getList().lookup(i);
					index++;
				}
			}
			return new NumSet(array);
		} else {
			int intersectSize = 0;
			for (int i = 0; i < S1.size(); i++) {
				if (S2.contains(S1.getList().lookup(i))) {
					intersectSize++;
				}
			}

			double[] array = new double[intersectSize];
			int index = 0;
			for (int i = 0; i < intersectSize; i++) {
				if (S2.contains(S1.getList().lookup(i))) {
					array[index] = S1.getList().lookup(i);
					index++;
				}

			}
			return new NumSet(array);
		}
	}

	/**
	 * Returns a new NumSet that is a combination of the given sets.
	 * 
	 * @param S1
	 *            - set 1
	 * @param S2
	 *            - set 2
	 * @return returns a new set that is a union of set 1 and set 2.
	 */
	public static NumSet union(NumSet S1, NumSet S2) {
		double[] array = new double[S1.size() + S2.size()];
		for (int i = 0; i < S1.size(); i++) {
			array[i] = S1.getList().lookup(i);
		}
		for (int i = S1.size(); i < (S1.size() + S2.size()); i++) {
			array[i] = S2.getList().lookup(i - S1.size());
		}
		NumSet set = new NumSet(array);
		set.getList().removeDuplicates();
		return set;
	}

	/**
	 * Turns the set into a string representation.
	 */
	public String toString() {
		return getList().toString();
	}

	/**
	 * checks equivalence of the two sets.
	 * 
	 * @param S1
	 *            - set 1
	 * @param S2
	 *            - set 2
	 * @return returns true if the two sets are equivalent, regardless of order.
	 */
	public static boolean equivalence(NumSet S1, NumSet S2) {
		if (S1.size() != S2.size()) {
			return false;
		}
		for (int i = 0; i < S1.size(); i++) {
			if (!S1.contains(S2.getList().lookup(i)))
				return false;
		}

		return true;
	}
}
