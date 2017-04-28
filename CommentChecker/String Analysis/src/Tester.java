import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args){
		
		// Parse the files for positive and negative words
		CommentStatistics.positiveWords = Tester.parsePositive();
		CommentStatistics.negativeWords = Tester.parseNegative();
		
		//CSVParser csvParser = new CSVParser("src/comment_files/VapeNaysh.csv");
		CSVParser csvParser = new CSVParser("src/comment_files/youngThug");
		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/buzz");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/KidsReact");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/LiveToWin");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/numberphile");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/PinkGuy");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/PorcupineEatsPumpkin");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/ScreamingGoats");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/TryGuys");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/VapeNaysh");
//		csvParser.printWordCount();
//		csvParser = new CSVParser("src/comment_files/youngThug");
//		csvParser.printWordCount();
	}
	
	
	public static String[] parsePositive(){
		
		// Storing the words
		ArrayList<String> posWords = new ArrayList<String>();
		
		// Setting up the scanner
		File posFile = new File("src/parsepositive.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(posFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Just go through the file and add to the array list
		while(scan.hasNext()){			
			String nextWord = scan.nextLine();
			posWords.add(nextWord);			
		}
		
		// Parse to array for variable
		Object[] middleman = posWords.toArray();
		return Arrays.copyOf(middleman, middleman.length, String[].class);
	}
	
	
	public static String[] parseNegative(){
		
		// Storing the words
		ArrayList<String> negWords = new ArrayList<String>();
		
		// Setting up the scanner
		File negFile = new File("src/parsenegative.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(negFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Just go through the file and add to the array list
		while(scan.hasNext()){			
			String nextWord = scan.nextLine();
			negWords.add(nextWord);			
		}
		
		// Parse to array for variable
		Object[] middleman = negWords.toArray();
		return Arrays.copyOf(middleman, middleman.length, String[].class);
	}
}
