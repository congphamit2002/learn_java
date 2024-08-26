package immutable;

public class Ex06Split {
	public static void main(String[] args) {
		// Print words from text, each word on each line
		// regex stands for regular expression
		String text = "Welcome to class";
		String[] tokens = text.split("\\s");
		System.out.println("length: " + tokens.length);
//		for(String token: tokens) {
//			System.out.println(token);
//		}
		printf(tokens);
		
		System.out.println("==================");
	
		String line = "Susan, 0936252119, 28, English";
		tokens = line.split(",\\s");
		printf(tokens);
		
		// split by set of letters
		System.out.println("==================");
		// split by set of letters[1-N]  ===> []
		line = "   Smith,123456789   , 19, Math    ";
		tokens = line.trim().split("[,\\s]+");
		printf(tokens);
		
		System.out.println("====================");
		
		// **Question:** Find valid numbers from string ab123bx09aa222
		// 123 9 222
//		String numberAsString = "ab123bx09aa222";
		String numberAsString = "987ab123bx09aa222";
		tokens = numberAsString.split("[a-zA-Z]+");
		printf(tokens);
	}
	
	
	private static void printf(String[] tokens) {
		for (String token: tokens) {
//			System.out.println(token);
			System.out.println("||" + token + "||");
		}
	}
}


