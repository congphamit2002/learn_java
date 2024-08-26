package utils;

import java.util.Arrays;

import common.Item;

// Utils là các class tiện ích, có các hàm chức năng chỉ phụ thuộc tham số truyền vào 
//--> static (khi hàm thuộc tính không quan tâm đối tượng đang gọi)
//--> Ứng với tham số nào cho ra kết quả đó. 
//--> Và không quan tâm đến đối tượng đang gọi.
//--> class có thể gọi được ex: ArrayUtils.method
public class ArrayUtils {
	private ArrayUtils() {}
	
	// Không thể truyền mảng object bởi vì ta đã truyền int[] 
	// --> Nó đã hiểu digits là 1 object rồi 
	// --> Nên khi truyền 1 mảng object thì nó sẽ không hiểu
//	public static void printf(String prefix, Object[] objects) {
//		System.out.println(prefix + " --> " + Arrays.toString(objects));
//	}
	
	public static void printf(String prefix, int[] input) {
		System.out.println(prefix + " --> " + Arrays.toString(input));
	}
	
	public static <E> void printf(String prefix, E[] input) {
		System.out.println(prefix + " --> " + Arrays.toString(input));
	}
	
	public static void printf(String prefix, String[] input) {
		System.out.println(prefix + " --> " + Arrays.toString(input));
	}
	
	public static void printf(String prefix, Item[] input) {
		System.out.println(prefix + " --> " + Arrays.toString(input));
	}
}
