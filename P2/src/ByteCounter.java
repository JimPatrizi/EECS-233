import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author James Patrizi
 * EECS 233 P2
 *
 */
public class ByteCounter {
	
	//public ArrayList<Byte> originalList;
	public ArrayList<Byte> byteList = new ArrayList<Byte>();
	public ArrayList<Integer> intList = new ArrayList<Integer>();
	
	public ByteCounter(byte[] b){
		//originalList = new ArrayList<Byte>(Arrays.asList(b));
		for(byte i : b){
			if(!byteList.contains(i)){
				byteList.add(i);
				intList.add(1);
			}
			else{
				Integer m = intList.get(byteList.indexOf(i));
				intList.set(byteList.indexOf(i), m+1);
			}
		}
	}
	
	public ByteCounter(String file) throws IOException {
		this(Files.readAllBytes(Paths.get(file)));
	}
	
	public int getCount(byte b){
		int index= byteList.indexOf(b);
		return intList.get(index);
	}
	
	
	public int[] getCount(byte[] b){
		int [] array = new int[b.length];
		for(int i = 0; i < b.length ; i++){
			//for( byte i : b){
			array[i]= this.getCount(b);//use for(int i = 0; i < L ; i++) { a[i]}
		}
		return array;
	}
		
	
	public byte[] getElements(){
		return null;
	}
	/*
	private boolean contains(byte[] bArray, byte b){
		for(int i = 0; i < bArray.length ; i++){
			if(bArray[i]== b){
				return true;
			}
		}
				return false;
	}
	*/
	public void setOrder(String order){
		
	}
	
	public String toString(){
		return "";
	}
	
	public String toString(String format){
		return "";
	}
}
