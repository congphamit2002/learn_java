package mutable;

/**
 * Phân biệt String Mutable và Mutable
 */
public class Ex01StringMuatble {
	public static void main(String[] args) {
		// Mutable: StringBuilder, StringBuffer has String as property
		StringBuilder sbd = new StringBuilder("Layout ");
		// C1: builder pattern
		hash("sbd1", sbd);
		sbd.append("Manager"); // builder pattern
		// Biến --> gọi method set luôn giá trị đồng thời sẽ 
		// return về this đó luôn
		
		//C2
//		sbd = sbd.append("Manager");
		hash("sbd2", sbd);
		System.out.println("value: " + sbd);
		System.out.println("\n===============\n");
		
		StringBuffer sb = new StringBuffer("Layout ");
		hash("sb1", sb);
		
		sb.append("Manager"); 

		hash("sb2", sb);
		System.out.println("value: " + sb);
		
		System.out.println("\n===============\n");
		
		// Immutable: String
		String i = "Box ";
		hash("i1", i);
		
		i = i + "Layout";
		hash("i2", i);
	}	
//	private static void hash(String text, String object)
//--> Không thể truyền vào String vì String không phải parent class của Builder
	private static void hash(String text, Object object) {
		System.out.println(text + ": " + System.identityHashCode(object));
	}
}
