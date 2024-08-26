package view;

import java.util.Random;

import bean.Car;

public class Ex02CarApp {
	public static void main(String[] args) {
		// Yêu cầu: Tạo 100 mẫu xe Audi với các màu sắc khác nhau
		// Màu sắc: Yellow, Red, Blue, White, Black
		Random rd = new Random();
		String[] colors = {"Yello", "Red", "Blue", "White", "Black"};
		Car[] cars = new Car[100];
//		for(int i = 1; i <= 100; i++) {
//			Car car = new Car(i, "Audi", colors[rd.nextInt(colors.length)]);
//			System.out.println(car);
//		}

		for(int i = 0; i < cars.length; i++) {
			Car car = new Car(i, colors[rd.nextInt(colors.length)]);
			cars[i] = car;
		}
		

		// Yêu cầu: Số lượng xe còn lại đổi model thành MG
//		cars[2].model = "MG";
		Car.model = "MG";
//		for(Car car: cars) {
//			car.model = "MG";
//		}
		
		System.out.println("=========================");
		for(Car car: cars) {
			System.out.println(car);
		}
	}
}
