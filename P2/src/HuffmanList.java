import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author James Patrizi
 * EECS 233 P2
 * Constructs the initial linked list of HuffmanNodes to build the HuffmanTree.
 * @param <T> generic 
 */
public class HuffmanList<T> implements Iterable<T>{

	public LinkedList<HuffmanNode> list;
	
	public HuffmanList(byte[] b){
		
	}
	
	public HuffmanList(String file){
		
	}
	
	public HuffmanList(byte[] b , int[] array){
		
	}
	
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			
			public boolean hasNext(){
				return true;
			}
			
			public T next(){
				return null;
			}
			
			public void remove(){
				
			}
		};
	}
}
