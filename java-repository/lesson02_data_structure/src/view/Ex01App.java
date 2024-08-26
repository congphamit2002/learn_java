package view;

import java.time.LocalDate;

import datastructure.Ex01Delcare;

public class Ex01App {
	public static void main(String[] args) {
		System.out.println("Lesson02 demo");
		System.out.println("Publish date: " + LocalDate.now());
		
		// Class.staticAttribute
		System.out.println("LargeNumber: " + Ex01Delcare.largeNumber);
	}
}
