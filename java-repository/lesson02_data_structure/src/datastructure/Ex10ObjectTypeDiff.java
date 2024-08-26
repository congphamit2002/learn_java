package datastructure;

public class Ex10ObjectTypeDiff {
	public static void main(String[] args) {
		// String, Integer, Double, Float, Long, Character
		// Kiểu đối tượng và chỉ có duy nhất 1 thông tin (thuộc tính) bên trong
		// Directly assign: Khai báo trực tiếp
		// Lưu trữ giá trị ở HEAD -> constant pool
		
		String s1 = "hello"; // h1
		String s2 = "Welcome"; // h2
		String s3 = "hello"; // h1
		
		System.out.println("s1 hash: " + System.identityHashCode(s1));
		System.out.println("s2 hash: " + System.identityHashCode(s2));
		System.out.println("s3 hash: " + System.identityHashCode(s3));
		s3 = "Quan que"; // h3
		System.out.println("s3 hash: " + System.identityHashCode(s3));
	
		System.out.println("===================================");
		// Heap
		String o1 = new String("hello");
		String o2 = new String("welcome");
		String o3 = new String("hello");
		System.out.println("o1 hash: " + System.identityHashCode(o1));
		System.out.println("o2 hash: " + System.identityHashCode(o2));
		System.out.println("o3 hash: " + System.identityHashCode(o3));
	}
}
