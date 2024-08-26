package datastructure;

public class Ex12SwapInt {
	public static void main(String[] args) {
		int a = 22;
		int b = 66;
		
		// swap in main method
		// C1
//		int temporary = a;
//		a = b;
//		b = temporary;
	
		// C2
//		a = a - b; 
//		b = a + b;
//		a = b - a;
		
		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		// create separate method to swap
	}
	
	// int first = a;
	// int second = b;
	// Không cập nhật a, b nếu gọi tới
	private static void swap(int first, int second) {
		int temporary = first;
		first = second;
		second = temporary;
	}
}
