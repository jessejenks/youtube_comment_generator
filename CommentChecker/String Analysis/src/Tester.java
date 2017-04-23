
public class Tester {

	public static void main(String[] args){
		
		String channel = "H3H3";
		String comment = "Wow Ethan! Great moves, keep it up. Proud of you.";
		
		CommentParser parser = new CommentParser(channel, comment);
		parser.printWordCount();
		parser.printStats();
	}
	
}
