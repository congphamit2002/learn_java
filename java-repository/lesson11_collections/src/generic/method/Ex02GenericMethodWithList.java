package generic.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sau khi mình xử lý dữ liệu xong, kết quả có thể trả về
 * List<Double>, List<String>, List<Item>, List<Integer>;
 *
 * --> Người dùng muốn in ra dữ liệu từ các mảng đó
 * 
 * * Yêu cầu: Chỉ được phép in ra các mảng là số Integer, Double, Long
 * Idea --> Tìm 1 super type of Integer/Long/Double
 *      sau đó giới hạn E bởi super type --> Number
 */

/*	Generic Method là một method có tham số truyền vào là một generic type
 * 	Generic type là khi mình truyền vào thì mình sẽ truyền giá trị cho nó (kiểu dữ liệu)
 * 	Generic class là class có tham số truyền vào là một generic type
 * 	Một generic class là một class hoặc interface thì ta có thể tham số hóa kiểu dữ liệu truyền vào
 * 	Bình thường ta code theo kiểu Object thì nó thường mắc các lỗi như
 * 	runtime, không limit (không bao lại kiểu dữ liệu)
 *  => Dùng dữ liệu tự custom bằng generic
 * */
public class Ex02GenericMethodWithList {
	public static void main(String[] args) {
		
		// new ArrayList<>()
		//	--> java.util.ArrayList --> array with dynamic size
		
		// Arrays.asList()
		// --> java.util.Arrays.ArrayList --> array with fixed size
		// --> Không add không remove được
		
		List<Double> dList = Arrays.asList(1d, 2d, 3d, 4d);
//		dList.add(123d); 
// 		Tại sao dList lại gọi được add bởi vì lúc compile nó vẫn là ArrayList nhưng
// 		khi runtime thì nó không còn của ArrayList nữa mà là Array.ArrayList
//		System.out.println(dList); 
//		--> Không xài được add
		List<String> sList = Arrays.asList("hello", "hallo", "hollo");
		List<Integer> iList = Arrays.asList(2, 4, 4, 2);
		
//		printList("dList", dList);
//      => Không cho bởi vì List là class interface là một kiểu dữ liệu, object chỉ là
//		tham số nên khi truyền là 1 List Object thì nó sẽ không cho gọi method.
//		List<Object> không phải là super của List<String> List<Double> List<Integer>
//		=> Không cho truyền tham số. (Tất cả đều là kiểu dữ liệu List)		
// 		=> Thay thế bằng Generic type
		
		printListGeneric("dList", dList);
//		printListGeneric("sList", sList);
		printListGeneric("iList", iList);
//		 printListWildCard("dList", dList);
//		 printListWildCard("sList", sList);
		printListWildCard("iList", iList);
	}
	
	private static void printListWildCard(String prefix, List<? super Integer> objects) {
		System.out.print(prefix + " ----> ");
		for (Object object: objects) {
			System.out.print(object + "  ");
		}
		System.out.println("\n");
	}
	
//	private static <E> void printListGeneric(String prefix, List<E> objects) {
//		System.out.print(prefix + " ----> ");
//		for (E object: objects) {
//			System.out.print(object + "  ");
//		}
//		System.out.println("\n");
//	}
	
// <E> --> no limitation
// <E extends Number> --> limit by Number (Number or sub types of Number)
// <E extends CharSequence> --> limit by CharSequence (CharSequence or sub types of CharSequence)
	
	private static <E extends Number> void printListGeneric(String prefix, List<E> objects) {
		System.out.print(prefix + " ----> ");
		for (E object: objects) {
			System.out.print(object + "  ");
		}
		System.out.println("\n");
	}
	
	// Không gọi được hàm này vì List<Object> không phải là kiểu dữ liệu cha của List<Double>, List<Integer>, List<String>
	// Object ở đây là một parameter thôi chứ data type vẫn là list
	private static void printList(String prefix, List<Object> objects) {
		System.out.print(prefix + " ----> ");
		for (Object object: objects) {
			System.out.print(object + "  ");
		}
		System.out.println("\n");
	}
}