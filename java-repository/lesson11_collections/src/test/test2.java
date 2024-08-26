package test;

public class test2 {
	public static void main(String[] args) {
		int sum = MathHelper.add(3, 5); // Sử dụng phương thức static add()
		int product = MathHelper.multiply(3, 5); // Sử dụng phương thức static multiply()
		System.out.println("Tổng của 3 và 5 là: " + sum); // Kết quả: 8
		System.out.println("Tích của 3 và 5 là: " + product); // Kết quả: 15
	}
}
