/**
 * Annotates a integer following the "Fizz Buzz" 
 * game scheme.
 * EECS 233
 * @author James Patrizi
 *
 */

public class Annotation {
	/**
	 * The integer that will be annotated.
	 */
	private int n = 0;
	
	/**
	 * Constructor that initializes n to 0 with no
	 * given parameters.
	 */
	public Annotation() {
		
	}
	/**
	 * Constructor that initializes n to given parameter
	 * integer i.
	 * @param i - the value n will be assigned.
	 */
	public Annotation(int i){
		this.n = i;
	}
	
	/**
	 * Gets the current value of n.
	 * @return - returns the value of n.
	 */
	public int getn() {
		return this.n;
	}
	
	/**
	 * Mutates the current value of n.
	 * @param i - the value n will be assigned to.
	 */
	public void setn(int i) {
		this.n = i;
	}
	
	/**
	 * Mutates n according to the rules of FizzBuzz.
	 */
	public String toString(){
		if(getn() == 0){
			return "0";
		}
		if((getn() % 3 ==0) && (getn() % 5 ==0)){
			return "FizzBuzz";
		}
		if(getn()% 3 == 0){
			return "Fizz"; 
		}
		if(getn()% 5 == 0){
			return "Buzz";
		}
		else {
			return new Integer(getn()).toString();
		}
	}
	
	/**
	 * Annotates each integer from start to end and returns the string of all annotations separated by spaces. 
	 * No leading or trail spaces will be present.
	 * @param start - starting integer.
	 * @param end - ending integer.
	 * @return - returns a string of annotated numbers from the start to end value that comply to "FizzBuzz".
	 */
	public static String annotateList(int start, int end){
		Annotation list = new Annotation();
		if(start == end){
			list.setn(end);
			return list.toString();
		}
		
		StringBuilder sb =  new StringBuilder();
		for(int i = start; i < end; i++){
			list.setn(i);
			sb.append(list.toString());
			sb.append(" ");
		}
		//not included in for loop to remove trail space.
		list.setn(end);
		sb.append(list.toString());
		return sb.toString();
	}
}
			
		
			
	



