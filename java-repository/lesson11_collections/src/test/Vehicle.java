package test;

public class Vehicle {
	private static int totalVehicles = 0; // Biến static để đếm tổng số phương tiện

	private String type;

	public Vehicle(String type2) {
		this.type = type;
		totalVehicles++; // Tăng tổng số phương tiện khi tạo đối tượng mới
	}
	public static int getTotalVehicles() {
		return totalVehicles;
	}
}
