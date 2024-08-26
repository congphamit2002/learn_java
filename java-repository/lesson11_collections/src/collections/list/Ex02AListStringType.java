package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02AListStringType {
	// interface: List --> dynamic array
	// implementation: ArrayList & LinkedList
	// class cha = class con
	// class con != class cha
		public static void main(String[] args) {
			// sequences lúc compile sẽ là kiểu List
			// runtime sẽ là arraylist
			List<String> sequences = new ArrayList<>();
			sequences.add("A1"); // index = 0
			sequences.add("B2");
			sequences.add("C3");
			sequences.add("D4");
			System.out.println("size: " + sequences.size());
			loop(sequences);
			System.out.println("elements[1] --> " + sequences.get(1));
			
			sequences.set(1, "B99");
			System.out.println("elements[1] --> " + sequences.get(1));
		
			sequences.remove(0); // by index
			sequences.remove("D4"); // by value
			loop(sequences); // B99, C3
			
			sequences.add("E4");
			sequences.add("F5");
			sequences.add("G6"); // B99, C3, E4, F5, G6
			loop(sequences);
//			removeIf(sequences);
//			loop(sequences);
			
//			Condition c1 = new Condition() {
//				
//				@Override
//				public boolean test(String element) {
//					// TODO Auto-generated method stub
//					return element.compareTo("G") < 0;
//				}
//			};
			//lambda
//			Condition c1 = (String element) -> element.compareTo("C") < 0;
//			Condition c1 = item -> item.compareTo("C") < 0;
//			removeIf(sequences, c1);
//			System.out.println("========================");
			
			removeIf(sequences, item -> item.compareTo("C") < 0);
			System.out.println("==== After removeIf ====");
			loop(sequences);
			
			System.out.println("==== After removeIf 02====");
			// removeIf(sequences, item -> item.compareTo("G") < 0);
			
			// Hàm có sẵn --> predicate ~ condition
			sequences.removeIf(s -> s.compareTo("F") < 0);
			loop(sequences);
			
			//	sequences.remove("D4");
			// 	sequences.contains("D4");
			
			sequences.add("A1");
			sequences.add("A2");
			sequences.add("A3");
			loop(sequences);
			
			// Duyệt từng phần tử trong sequences
			// Kiểm tra nếu có phần tử nào sequences[i].equals("A2") --> true
			// else --> false
			// Lưu ý khi gọi tương tự với kiểu dữ liệu là 1 object không phải string
			// cần override lại hàm equals nếu ko muốn nó so sánh địa chỉ 
			
			System.out.println("Is A2 existed --> " + sequences.contains("A2"));
			sequences.remove("A2");
			System.out.println("Is A2 existed --> " + sequences.contains("A2"));
		  }
		
		// ConcurrentModificationException
		// --> Khi 1 phần tử đang được thao tác/xử lý bởi 1 process
		// --> Không thể được truy cập bởi process khác
		// strategy pattern trong java không có khái niệm tham số là một hàm vì vậy
		// java có sp một loại design pattern hỗ trợ việc truyền tham số cho hàm
		// Nói đơn giản strategy pattern là cách ta sử dụng parameter là hàm. --> parameter đó có thể là 1 abstract có thể 1 interface
		// Condition c = c1;
		private static boolean removeIf(List<String> elements, Condition c) {
			// for(String element: elements){
			//		if(element.compareTo("E") > 0){
			//			elements.remove(element);
			//      }
			//		return true;
			// }
			// --> khi một phần tử đang duyệt thì không được thêm
			//	bất kỳ thao tác nào vào phần tử đó.
			
			// Iterator hiểu đơn giản là nó sẽ cho phép mình process từng element trong list, array, element này,... 
			// --> Duyệt tới đâu process tới đó. (Duyệt tuần tự)
			// Iterator<String> iterator = elements.iterator();
			// while(iterator.hasNext()) {
			//		String each = iterator.next();
			//		if (c.test(each)) {
			//         iterator.remove();
		    //      }
			// }
			// return true;
			
			boolean removed = false;
			// Cho phép duyệt các phần tử trong mảng
			Iterator<String> iterator = elements.iterator();
			while(iterator.hasNext()) {
				//	String each = iterator.next();
				//	System.out.println("each --> " + each);
				
				// each.compareTo("F") < 0
				// test(each) --> strategy method
				if (c.test(iterator.next())) {
					iterator.remove();
					removed = true;
				}
			}
			return removed;
		}
		
		// capacity --> length of elementData
		// size     --> non-null elements in elementData
		// ArrayList --> size
		private static void loop(List<String> elements) {
			System.out.print("----------> ");
			// for(String element : elements){
			// 		System.out.print(element + " ");
			// }
			for(int i = 0; i < elements.size(); i++) {
				System.out.print(elements.get(i) + "  ");
			}
			System.out.println();
		}
}

	// strategy --> interface, abstract class
	// interface có một hàm trừu tượng được gọi là functional interface
	// --> thay vì new ra thì ta dùng lambda cho khỏe
    @FunctionalInterface 
	interface Condition {
		boolean test(String element);
	}
