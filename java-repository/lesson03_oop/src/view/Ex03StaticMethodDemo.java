package view;

public class Ex03StaticMethodDemo {
	private int x;
	private int y;
	
	
	public Ex03StaticMethodDemo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		// Non-static
//		Ex03StaticMethodDemo o1 = new Ex03StaticMethodDemo();
//		System.out.println("Sum 1: " + o1.sum(5, 3));
		
		// Using static
		System.out.println("Sum 1: " + sum(5, 3));
		System.out.println("Sum 2: " + sum(5, 10));
		System.out.println("Sum 3: " + sum(5, 5));
		System.out.println("Sum 4: " + sum(5, 15));
		
		System.out.println("======================");
		Ex03StaticMethodDemo o1 = new Ex03StaticMethodDemo(50, 8);
		Ex03StaticMethodDemo o2 = new Ex03StaticMethodDemo(40, 8);
		Ex03StaticMethodDemo o3 = new Ex03StaticMethodDemo(30, 8);
		System.out.println("Sub 1: " + o1.sub());
		System.out.println("Sub 2: " + o2.sub());
		System.out.println("Sub 3: " + o3.sub());
	}
	
	// Hàm chỉ phụ thuộc vào tham số truyền vào, không phụ thuộc vào đối tượng đang gọi 
	// ==> Cho hàm static
	private static int sum(int a, int b) {
		return a + b;
	}
	
	// Hàm phụ thuộc vào đối tượng đang gọi
	// ==> Cho hàm non-static
	private int sub() {
		return x - y;
	}
}
