package datastructure;

public class Ex01Delcare {
	// static --> giải thích sau: 
	// biến toàn cục, thuộc tính
	// global variables = attributes
	public static int largeNumber = 555;
	
	// algorithm: functions, method
	public static void main(String[] args) {
		// local variables --> giá trị lưu ở STACK
		// block code
		int myNum = 8;
		long myBigNum = 999l;
		float avgPoint = 8.6f;
		boolean isValid = false;
		
		System.out.println("Du lieu " + myNum);
		System.out.println("Du lieu so lon " + myBigNum);
		System.out.println("Diem trung binh " + avgPoint);
		System.out.println("Hop le " + isValid);
		
		System.out.println("Main largeNumber: " + largeNumber);
		showData();
	}
	
	private static void showData() {
		int number = 20;
		System.out.println("Du lieu " + number);
		System.out.println("ShowData largeNumber: " + largeNumber);
	}
}
