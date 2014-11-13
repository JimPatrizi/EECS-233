import java.io.IOException;
import java.util.ArrayList;


public class App {

	public static void main(String[] args) throws IOException{
		HashTable ht = new HashTable(6);
    	ht.put("Hi",1);
    	ht.put("Bonjour",2);
    	ht.put("Marhaba",3);
    	ht.update("Hi",4);
    	ht.update("Hola", 5);
    	ArrayList<HashEntry> entry = ht.getHashArray();
    	for(HashEntry i : entry){
    		System.out.println(i.getKey());
    		System.out.println(i.getValue());
    	}
		
	}
}
