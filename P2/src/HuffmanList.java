import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 
 * @author James Patrizi
 * EECS 233 P2
 * Constructs the initial linked list of HuffmanNodes to build the HuffmanTree.
 * @param <T> generic 
 */
@SuppressWarnings("serial")
public class HuffmanList extends LinkedList<HuffmanNode>{

	
	public HuffmanList(byte[] b){
		ByteCounter counter = new ByteCounter(b);
		counter.setOrder("countInc");
		for(int i = 0 ; i < counter.byteList.size(); i++){
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}
	 
	public HuffmanList(String file) throws IOException{
		ByteCounter counter = new ByteCounter(file);
		counter.setOrder("countInc");
		for(int i = 0 ; i < counter.byteList.size(); i++){
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}
	
	public HuffmanList(byte[] b , int[] array) throws Exception{
		ByteCounter counter = new ByteCounter(b);
		if(counter.intList.size() != b.length){
			throw new Exception();
		}
		for(int i = 0; i < array.length; i++){
			if(array[i] < 1){
				throw new Exception();
			}
		}
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		for(int i = 0; i < b.length ; i++){
			byteList.add(b[i]);
		}
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i = 0; i < b.length ; i++){
			intList.add(array[i]);
		}
		Class<ByteCounter> byteCounter = ByteCounter.class;
		Field field = byteCounter.getDeclaredField("byteList");
		field.setAccessible(true);
		field.set(counter, byteList);
		Field dos = byteCounter.getDeclaredField("intList");
		dos.setAccessible(true);
		dos.set(counter, intList);
		counter.setOrder("countInc");
		for(int i = 0 ; i < counter.byteList.size() ; i++){
			add(new HuffmanNode(counter.byteList.get(i), counter.intList.get(i)));
		}
	}
	
	
	
}
