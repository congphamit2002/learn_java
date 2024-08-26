package datastructure;

public class Ex02DelarePriority {
	
	private static int number = 99;
	public static void main(String[] args) {
		int number = 10;
		System.out.println(number); //10
		demo(); //20 99
		test(); //99
	}
	
	private static void demo() {
		int number = 20;
		System.out.println(number); //20
		System.out.println(Ex02DelarePriority.number); //99
	}
	
	private static void test() {
		System.out.println(number); //99
	}
}
