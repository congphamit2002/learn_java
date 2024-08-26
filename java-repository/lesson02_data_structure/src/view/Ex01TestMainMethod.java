package view;

public class Ex01TestMainMethod {
	public static void main(String[] args) {
		// running: ctrl + f11
		// debugging:
		// breakpoint
		
		// data structure: attributes, variables
		// algorithm: functions, method
		System.out.println("Main method");
		anotherMainMethod();
	}
	
	// Chia nhỏ bài toán
	// Tái sử dụng code
	
	// declaration: Khai báo
	public static void anotherMainMethod() {
		System.out.println("Fake main method");
	}
}
