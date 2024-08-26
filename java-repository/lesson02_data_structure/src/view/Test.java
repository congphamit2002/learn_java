package view;

public class Test {
	public static void main(String[] args) {
		int x = 10;
		System.out.println("x1: " + x);
		x = 20;
		System.out.println("x2: " + x);
		change(x);
		System.out.println("x3: " + x);
	}
	
	public static void change(int x) {
		x = 30;
	}
}
