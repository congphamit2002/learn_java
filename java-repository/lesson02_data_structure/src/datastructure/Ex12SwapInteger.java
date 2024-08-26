package datastructure;

public class Ex12SwapInteger {
	public static void main(String[] args) {
		Integer a = 22; //h1
		Integer b = 66; //h2
		
		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	// Integer first = a; // h1(22)
	// Integer second = b; // h2(66)
	// Java pass by value at stack --> truyền tham trị
	// Không thể thay đổi giá trị của biến ở Stack truyền vào
	private static void swap(Integer first, Integer second) {
		Integer temporary = first; //h1
		first = second; //h2
		second = temporary; //h1
		// Đổi first và second chứ không liên quan tới a, b
	}
}
