package view;
/*
 * Khi một hàm bị ngoại lệ. Có 2 cách để xử lý
 * 1. Bắt lỗi tại hàm đó
 * 2. Ném ngoại lệ để nơi gọi sẽ bắt, xử lý lỗi đó.
 * */
public class Ex02DivideThrows {
	public static void main(String[] args) {
		// A --> validate
		System.out.println("Result1: " + divide(4, 2));
		
		// B --> arbitrary
		System.out.println("Result2: " + divide(5, 0));
		
		System.out.println("Finished...");
	}
	
	// Ném tại vị trí khai báo hàm
	// Nếu chỗ gọi không bắt lỗi thì vẫn bị crash app
	
	// throws runtime (unchecked) exception --> chỗ gọi không cần bắt buộc xử lý
	// throws compile (checked) exception -->ử lý chỗ gọi bắt buộc x
	private static int divide(int a, int b) throws ArithmeticException{
		return a/b;
	}
}
