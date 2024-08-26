package immutable;

public class Ex01BasicDeclaration {
	public static void main(String[] args) {
		// immutable: bất biến --> String, Integer, Double, Float
		// Không thể thay đổi giá trị tại vùng nhớ HEAP
		
//		// 2 stack - 1 heap
//		Integer a = 10; // constant pool
//		Integer a1 = 10;
//		
//		// 2 stack - 2 heap
//		Integer b = new Integer(20);
//		Integer b1 = new Integer(20);
		
		// String Literal stores in HEAP(constant pool)
		// 2 heap
		String s1 = "Welcome";
		String s2 = "Welcome";
		String s3 = "Student";
				
		hash("s1 hash", s1);
		hash("s2 hash", s2);
		hash("s3 hash", s3);
				
		// String Object stores in HEAP(normal)
		// 3 heap
		String o1 = new String("Welcome");
		String o2 = new String("Welcome");
		String o3 = new String("Student");
			
		hash("o1 hash", o1);
		hash("o2 hash", o2);
		hash("o3 hash", o3);
		
	}
	
	private static void hash(String text, String object) {
		System.out.println(text + " --> " + System.identityHashCode(object));
	}
}
