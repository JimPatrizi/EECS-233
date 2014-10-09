import java.io.IOException;
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
	
	private byte[] byteArray;
	
	public ByteCounter(byte[] b){
		this.byteArray = b;
	}
	
	public ByteCounter(String file){
		Path path = Paths.get(file);
		try {
			this.byteArray = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	
	public int getCount(byte b){
		int count = 0;
		for(int i=0; i < byteArray.length ; i++){
			if(byteArray[i]== b){
				count++;
			}
		}
		return count;
	}
	
	public int[] getCount(byte[] b){
		int[] barray = {0};
		return barray;
	}
	
	public byte[] getElements(){
		return null;
	}
	
	public void setOrder(String order){
		
	}
	
	public String toString(){
		return "";
	}
	
	public String toString(String format){
		return "";
	}
}
