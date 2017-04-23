import java.util.HashMap;
import java.util.Set;

public class CommentParser {

	public String channel;
	public String comment;
	public HashMap<String, Integer> wordCount;
	// All-caps and non-caps
	public int numUppercase;
	public int numLowercase;
	// Number of words that imply start of sentences or formal recognition of names, titles, etc.
	public int numSentenceStarters;
	public int numWords;
	public int numUniqueWords;
	
	
	public CommentParser(String comment, String channel){
		
		this.channel = channel;
		this.comment = comment;
		
		this.wordCount = new HashMap<String, Integer>();
		this.numUppercase = 0;
		this.numLowercase = 0;
		this.numSentenceStarters = 0;
		
		this.parseComment(comment);
		
		this.numUniqueWords = wordCount.size();
	}
	
	private void parseComment(String comment){
		
		// Split the comment
		String[] data = comment.split("[\\p{Punct}\\s]+");
		this.numWords = data.length;
		
		// Start racking up word counts
		for(int i = 0; i < data.length; i++){
			
			String word = data[i];
			
			// Word count
			if(!wordCount.containsKey(word)){
				wordCount.put(word, 0);
			}else{
				wordCount.put(word, wordCount.get(word) + 1);
			}
			
			// Sentence starters
			if(word.charAt(0) > 64 && word.charAt(0) < 91){
				this.numSentenceStarters++;
			}
			
			// All caps/All non-caps
			if(this.isAllCaps(word)){
				this.numUppercase++;
			}else{
				this.numLowercase++;
			}
			
			
		}
		
	}
	
	private boolean isAllCaps(String word){
		
		for(int i = 0; i < word.length(); i++){			
			if(word.charAt(i) > 97 && word.charAt(i) < 123){return false;}			
		}
		
		return true;
	}
	
	public void printWordCount(){
	
		System.out.println("Channel: ");
		System.out.println(this.channel);
		System.out.println("==========");
		System.out.println("Comment: ");
		System.out.println(this.comment);
		System.out.println("==========");
		
		Set<String> keys = wordCount.keySet();
		
		for(String word : keys){
			
			System.out.print(word + ": ");
			System.out.println(this.wordCount.get(word));
			
		}
		
	}
	
	public void printStats(){
		
		System.out.println("Comment Statistics");
		System.out.println("============");
		System.out.print("Average word length: ");
		System.out.println(CommentStatistics.avgWordLength(this));
		System.out.print("Percent words all caps: ");
		System.out.println(CommentStatistics.percentAllCaps(this));
		System.out.print("Percent words positive: ");
		System.out.println(CommentStatistics.percentPositive(this));
		System.out.print("Percent words negative: ");
		System.out.println(CommentStatistics.percentNegative(this));
		System.out.print("Percent words racist");
		System.out.println(CommentStatistics.percentRacist(this));
		System.out.print("Percent words sexist");
		System.out.println(CommentStatistics.percentSexist(this));
		System.out.print("Percent words homophobic");
		System.out.println(CommentStatistics.percentHomophobic(this));
		System.out.print("Percent words profanity");
		System.out.println(CommentStatistics.percentProfanity(this));
		System.out.print("Percent words miscellaneous: ");
		System.out.println(CommentStatistics.percentMiscellaneous(this));
		System.out.print("Percent words emojis: ");
		System.out.println(CommentStatistics.percentEmoji(this));
	}
}
