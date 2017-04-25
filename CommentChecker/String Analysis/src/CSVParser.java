import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSVParser {

	public String fileName;
	public HashMap<String, Integer> wordCount;
	
	
	public CSVParser(String fileName){
		
		this.fileName = fileName;
		this.wordCount = new HashMap<String, Integer>();
		this.parseFile();
		
	}
	
	public void parseFile(){
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String line = "";
		
		try {
			
			while((line = br.readLine()) != null){
				
				String[] data = line.split(",");
				for(int i = 0; i < data.length; i++){
					//System.out.println(data[i]);
				}
				if(data.length >= 5){
					this.parseComment(data[4]);
				}
				
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		
//		File csvFile = new File(fileName);
//		Scanner scan = null;
//		
//		try {
//			scan = new Scanner(csvFile);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}		
//		scan.useDelimiter(",");
//		
//		while(scan.hasNext()){
//			
//			// Skip through the first 4 columns
//			for(int i = 0; i < 4; i++){
//				String throwaway = (String) scan.next();
//			}
//			
//			// Extract comment
//			String comment = scan.next();
//			
//			// Don't care about other contents
//			scan.nextLine();
//			
//			// Parse comment, add to word count
//			this.parseComment(comment);
//		}
	}
	
	private void parseComment(String comment){
		
		// Split the comment
		String[] data = comment.split("[\\p{Punct}\\s]+");
		
		// Start racking up word counts
		for(int i = 0; i < data.length; i++){
			
			String word = data[i];
			
			// Word count
			if(!wordCount.containsKey(word)){
				wordCount.put(word.toLowerCase(), 1);
			}else{
				wordCount.put(word.toLowerCase(), wordCount.get(word) + 1);
			}			
			
		}
		
	}
	
	public void printWordCount(){
		
		System.out.print("File: ");
		System.out.println(this.fileName);
		System.out.println("==========");
		System.out.println("Words: ");
		
		Set<String> keys = wordCount.keySet();
		//keys = this.sortKeys(keys);
		
		for(String word : keys){
			
			System.out.print(word + ": ");
			System.out.println(this.wordCount.get(word));
			
		}
		
	}
	
	private Set<String> sortKeys(Set<String> keys){
		
		Set<String> copy = keys;
		Set<String> sorted = new HashSet<String>();		
		String[] allKeys = keys.toArray(new String[keys.size()]);
		
		while(allKeys.length > 0){
			
			String currMax = allKeys[0];
			
			for(int i = 0; i < allKeys.length; i++){
				
				if(wordCount.get(allKeys[i]) >= wordCount.get(currMax)){
					currMax = allKeys[i];
				}
				
			}
			
			sorted.add(currMax);
			copy.remove(currMax);
			allKeys = keys.toArray(new String[copy.size()]);
		}
		
		return sorted;
	}
}
