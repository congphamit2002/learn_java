package condition.loop;

public class Ex01If {
	public static void main(String[] args) {
		int number = 8;
//		boolean isValid = isEven(number);
		if(isEven(number)) {
			// statement
			System.out.println(number + " is even number!!!");
		}
		
		System.out.println("Finish...");
	}
	
	private static boolean isEven(int number) {
//		if(number % 2 == 0) {
//			return true;
//		}
//		return false;
		return number % 2 == 0;
	}
}
