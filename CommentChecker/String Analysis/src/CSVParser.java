import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSVParser {

	public String fileName;
	public HashMap<String, Integer> wordCount;
	public String writerName;
	
	
	public CSVParser(String fileName){
		
		this.fileName = fileName + ".csv";
		this.writerName = fileName + ".txt";
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
				//if(data.length >= 5){
					this.parseComment(data[0]);
				//}
				
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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
		
		FileWriter fwriter = null;
		BufferedWriter bwriter = null;
		
		try {
			fwriter = new FileWriter(this.fileName + ".txt");
			bwriter = new BufferedWriter(fwriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.print("File: ");
//		System.out.println(this.fileName);
//		System.out.println("==========");
//		System.out.println("Words: ");
		try {
			bwriter.write("File: " + this.fileName + "\n ========== \n Words: \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		ArrayList<String> keys = this.sortKeys(wordCount.keySet());
		
		for(String word : keys){
			
			if(!word.equals("")){
//				System.out.print(word + ": ");
//				System.out.println(this.wordCount.get(word));
				try {
					bwriter.write(word + "," + this.wordCount.get(word) + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			
		}
		
	}
	
	private ArrayList<String> sortKeys(Set<String> keys){
		
		ArrayList<String> sorted = new ArrayList<String>();
		String[] allKeys = keys.toArray(new String[keys.size()]);
		
		for(int i = 0; i < allKeys.length; i++){
			
			String currMax = "";
			for(int k = 0; k < allKeys.length; k++){
				if(!sorted.contains(allKeys[k])){
					currMax = allKeys[k];
					break;
				}
			}
			
			for(int j = 0; j < allKeys.length; j++){
				
				if(!sorted.contains(allKeys[j]) && wordCount.get(allKeys[j]) >= wordCount.get(currMax)){
					currMax = allKeys[j];
				}
				
			}
			
			sorted.add(currMax);
		}
		
		return sorted;
	}
}
