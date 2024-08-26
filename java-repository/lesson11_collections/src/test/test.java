package test;

public class test {
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Car");
		Vehicle motorbike = new Vehicle("Motorbike");
		System.out.println("Tong so phuong tien " + Vehicle.getTotalVehicles()); 
	}
}