import java.util.Arrays;
import java.util.Set;

public class CommentStatistics {

	// Word categories
	// Positive and negative are parsed on the main call
	public static String[] positiveWords;
	public static String[] negativeWords;
	
	// Computes the average word length of a comment
	public static int avgWordLength(CommentParser comment){
		
		int allLength = 0;
		Set<String> keys = comment.wordCount.keySet();
		
		for(String word : keys){
			allLength += (word.length() * comment.wordCount.get(word));
		}
		
		return (allLength / comment.numWords);
	}
	
	// Positive words
	public static int countPositive(CommentParser comment){
		
		int posCount = 0;
		Set<String> keys = comment.wordCount.keySet();
		
		for(String word : keys){
			if(Arrays.asList(CommentStatistics.positiveWords).contains(word)){
				posCount += comment.wordCount.get(word);	
			}
		}		
		
		return posCount;
	}
	
	// Negative words
	public static int countNegative(CommentParser comment){
		
		int negCount = 0;
		Set<String> keys = comment.wordCount.keySet();
		
		for(String word : keys){
			if(Arrays.asList(CommentStatistics.negativeWords).contains(word)){
				negCount += comment.wordCount.get(word);
	
			}
		}		
		
		return negCount;
	}
	
	// Returns the ratio of positive to negative words in a comment
	// Returns -1 if a ratio comparison wouldn't make sense
	public static double posNegRatio(CommentParser comment){	
		
		int countPositive = CommentStatistics.countPositive(comment);
		int countNegative = CommentStatistics.countNegative(comment);

		if(countNegative == 0 || countPositive == 0){
			return -1;
		}else{
			return (double)countPositive / (double)countNegative;
		}
	}
	
}
