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
			array[i]= getCount(b[i]);
		}
		return array;
	}
		
	public byte[] getElements(){
		byte [] array = new byte[byteList.size()];
		for(int i = 0 ; i < byteList.size();i++){
			array[i] = byteList.get(i);
		}
		return array;
	}
	
	public void setOrder(String order){
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < byteList.size() - 1;i++ ){
			sb.append(byteList.get(i).intValue());
			sb.append(':');
			sb.append(intList.get(i));
			sb.append(" ");
			}
		sb.append(byteList.get(byteList.size()- 1));
		sb.append(':');
		sb.append(intList.get(byteList.size()-1));
		return sb.toString();
	}
	
	public String toString(String format){
		return"";
	}
}
