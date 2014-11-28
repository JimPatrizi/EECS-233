import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author James Patrizi EECS 233-P4 
 * Reads lines of text files, extracts and
 *         normalizes, and stores the elements as Strings.
 * 
 */
public class Tokenizer {

	public ArrayList<String> wordlist = new ArrayList<String>();

	/**
	 * Constructor that constructs the word list from a file passed in.
	 * 
	 * @param file
	 *            - file to be passes in
	 * @throws IOException
	 */
	public Tokenizer(String file) throws IOException {

		try {
			File filein = new File(file);
			BufferedReader in = new BufferedReader(new FileReader(filein));
			String read = null;
			String[] split = new String[100];
			while ((read = in.readLine()) != null) {
				// read = in.readLine();
				// read.toLowerCase();
				// read.trim();
				split = read.trim().split("\\s+");

				for (String i : split) {
					if(i.toLowerCase().replaceAll("\\p{Punct}+", "").replaceAll("\\W+","").replaceAll("\\s+","").trim()!= " "){
						wordlist.add(i.toLowerCase().replaceAll("\\p{Punct}+", "").replaceAll("\\W+","").replaceAll("\\s+","").trim());
					}
				}//word = word.toLowerCase().replaceAll("\\s+","").replaceAll("\\W","").replaceAll("\\p{Punct}+", "");
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Formats String array to an arraylist with no punctuation, lowercase
	 * words, and no leading and trailing whitespace.
	 * 
	 * @param array
	 *            - String array to be formatted and put into an array list.
	 */
	public Tokenizer(String[] array) {
		String formatted = arrayStringToString(array);
		String[] split = new String[100];
		split = formatted.trim().split("\\s+");
		for (int i = 0; i < split.length; i++) {
			wordlist.add(split[i].toLowerCase().replaceAll("\\p{Punct}+", ""));
		}
	}

	/**
	 * Converts array contents to string.
	 * 
	 * @param array
	 *            - String array to be passed in.
	 * @return - Returns String with array contents.
	 */
	public String arrayStringToString(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (String i : array) {
			sb.append(i);
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * Gets the list of words.
	 * 
	 * @return- returns the word list made by the constructor.
	 */
	public ArrayList<String> wordList() {
		return this.wordlist;
	}
}

