import java.io.IOException;


public class App {

	public static void main(String[] args) throws IOException{
		String[] array = {"Hello" ,"my","name","is","Jim"};
		Tokenizer tz = new Tokenizer ("test2.txt");
		Tokenizer tz1 = new Tokenizer ("file.txt");
		System.out.println(tz.wordList());
		System.out.println(tz1.wordList());
	}
}
