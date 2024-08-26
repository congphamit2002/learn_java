package condition.loop;

import java.util.Scanner;

public class Ex06Loop {
	public static void main(String[] args) {
		// 1st --> using for --> duyệt mảng, danh sách
//		int i = 0;
//		for(; i < 10;) {
//			if(i % 4 == 0) {
//				System.out.print(i + " ");
//			}
//			i += 2;
//		}
		for(int i = 0; i < 10; i++) {
			if(i % 4 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n=================");
		// 2nd --> using while --> tính toán
		int i = 0;
		while (i < 10) {
			if(i % 4 == 0) {
				System.out.print(i + " ");
			}
			i += 2;
		}
		
		System.out.println("\n=================");
		// 3rd --> Viết chương trình nhập vào 1 số nguyên hợp lệ
		// TODO: Nếu nhập sai quá 3 lần thì thoát luôn chương trình
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter valid number: ");
//		String numberAsText = sc.nextLine();
		String numberAsText = "";	
		// Kiểm tra numberAsText là số thì mới parse sang int
		// \\d: số nguyên
		// + : 1 hoặc nhiều
		
//		if(numberAsText.matches("\\d+")) {
//			int number = Integer.parseInt(numberAsText);
//			System.out.println("Number: " + number);
//		}
		
//		while(!numberAsText.matches("\\d+")) {
//			System.out.print("Enter valid number: ");
//			numberAsText = sc.nextLine();
//		}
		int count = 0;
		do {
			System.out.print("Enter valid number: ");
			numberAsText = sc.nextLine();
			count++;
			if(count == 3) {
				break;
			}
			System.out.println("count: " + count);
		}while(!numberAsText.matches("\\d+"));
		
		int number = Integer.parseInt(numberAsText);
		System.out.println("Number: " + number);	
//		int number = Integer.parseInt(sc.nextLine());
		System.out.println("Finish");
	}
}
