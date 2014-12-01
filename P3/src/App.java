import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("Test for the Fifty Shades of Grey");
			WordStat ws = new WordStat("fiftyshades.txt");
			/**
			System.out.println("Word stats for individual words:wordcount,wordrank,count,count,count,paircount,pairrank");
			System.out.println(ws.wordCount("orgasm"));
			System.out.println(ws.wordRank("sex"));
			System.out.println(ws.wordCount("sex"));
			**/
			
			
			System.out.println(ws.wordCount("submissive"));
			System.out.println(ws.wordCount("dominant"));
			System.out.println(ws.wordPairCount("a","demonic"));
			System.out.println(ws.wordPairRank("a","demonic"));
			String[] common = ws.mostCommonWords(1000);
			System.out.println("1000 Most common words");
			for(int i = 0; i < common.length; i++)
				System.out.println(common[i]);
			System.out.println("");
			System.out.println("1000 Least common words");
			String[] least = ws.leastCommonWords(1000);
			for(int i = 0; i < least.length; i++)
				System.out.println(least[i]);
			System.out.println("");
			
			System.out.println("1000 most common word pairs");
			String[] pairs = ws.mostCommonWordPairs(10000);
			for(int i = 0; i < pairs.length; i++){
				System.out.println(pairs[i]);
			}
			
			
			
			
	}
}
