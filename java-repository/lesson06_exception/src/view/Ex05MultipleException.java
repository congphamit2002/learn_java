package view;

import java.util.Scanner;

public class Ex05MultipleException {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		System.out.println("x1 = " + findX());
		System.out.println("================");
		System.out.println("x2 = " + findXLevel2());
	}
	
	private static float findXLevel2() {
		int a = nextInt("a");
		int b = nextInt("b");
		if(a == 0) {
			throw new ArithmeticException("please enter a != 0");
		}
		return (float)-b/a;
	}
	
	private static int nextInt(String text) {
		String numberAsText = "";
		do {
			System.out.println("Enter " + text + ": ");
			numberAsText = sc.nextLine().trim();
			// \\d+ --> \\d(number) +(1|n letters)
			// -?: optinal for -
			if(numberAsText.matches("-?\\d+")) {
				break;
			}
		}while(true);
		return Integer.parseInt(numberAsText);
	}
	
	private static float findX() {
		Scanner sc = new Scanner(System.in);
		try {
			// NumberFormatException
			// ArithmeticException
			// NullPointerException
			
			System.out.println("Enter a: ");
			int a = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter b: ");
			int b = Integer.parseInt(sc.nextLine());
			return (float)-b/a; // lấy kết quả tử rồi mới chia

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return Integer.MIN_VALUE;
		
	}
}
