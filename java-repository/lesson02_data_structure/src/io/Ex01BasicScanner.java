package io;

import java.util.Scanner;

public class Ex01BasicScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your first name: ");
		String firstName = sc.nextLine();
		
		System.out.print("Enter your last name: ");
		String lastName = sc.nextLine();
		
		System.out.print("Enter your age: ");
		// Cách tránh bị lỗi null string khi value trước không phải string
		
		// C1
//		int age = sc.nextInt();
//		sc.nextLine();
		// C2
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter yout salary: ");
		double salary = Double.parseDouble(sc.nextLine());
		
		System.out.print("Enter your email: ");
		String email = sc.nextLine();
		
		System.out.println("=================");
		System.out.println("fullName: " + firstName + lastName);
		System.out.println("age: " + age);
		System.out.println("email: " + email);
		System.out.println("Salary: " + salary);
	}
}
