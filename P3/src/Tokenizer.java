import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author James Patrizi 
 * EECS 233-P3
 * Reads lines of text files, extracts and normalizes, and stores the elements as Strings.
 * 
 */
public class Tokenizer {
	
	ArrayList<String> wordlist = new ArrayList<String>();
	
	/**
	 * Constructor that constructs the word list from a file passed in.
	 * @param file - file to be passes in
	 * @throws IOException 
	 */
	public Tokenizer(String file) throws IOException{
		
		try {
			File filein = new File(file);
			BufferedReader in = new BufferedReader(new FileReader(filein));
			String read = null;
			String[] split = new String[100];
			while((read = in.readLine()) != null){
				//read = in.readLine();
				//read.toLowerCase();
				// read.trim();
				 split = read.trim().split("\\s+");
				
				 for(String i : split){
					wordlist.add(i.toLowerCase().replaceAll("\\p{Punct}+",""));
				}
			}
			in.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Formats String array to an arraylist with no punctuation, lowercase words, and no leading and trailing whitespace.
	 * @param array - String array to be formatted and put into an array list.
	 */
	public Tokenizer(String[] array){
		String[] formatted = array;
		for(int i = 0; i < array.length; i++){
			wordlist.add(formatted[i].replaceAll("\\W","").toLowerCase().trim());
		}
	}
	
	/**
	 * 
	 * @return- returns the word list made by the constructor.
	 */
	public ArrayList<String> wordList(){
		return this.wordlist;
	}
	
	//split lines from text file into words using whitespace chars. Use Java's split method in String class
	
	/**
	 * normalize words for both constructors
	 * convert words to lower case
	 * remove leading and trailing whitespace
	 * remove punctuation
	 */
}
