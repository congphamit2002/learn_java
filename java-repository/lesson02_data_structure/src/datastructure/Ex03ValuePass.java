package datastructure;

public class Ex03ValuePass {
	public static void main(String[] args) {
		int age = 23;
		int salary = 10; //M1
		
		// Làm 1 năm
		salary = age; // assign value
		age = 24;
		
		System.out.println("Age: " + age); //24
		System.out.println("Salary: " + salary); //23
		
		modify(salary); //M1
		System.out.println("Salary after review: " + salary);
	}
	
	// Java pass by value at stack
	
	// Review lương hằng năm
	// int salary --> Danh sách tham số truyền vào
	// Nhận giá trị từ bên ngoài
	// int salary = salary
	// salary = 30? => salary của modify được lưu giả định ở M2
	private static void modify(int salary) {
		salary = 30;
		System.out.println("Salary: " + salary);
	}
}
