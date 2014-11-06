import java.io.IOException;


public class App {

	public static void main(String[] args) throws IOException{
		String test [] = {"hello@ world!","with#, punctuation; only&"};
		Tokenizer tz = new Tokenizer (test);
		System.out.println(tz.wordList());
		//System.out.println(tz1.wordList());
	}
}
