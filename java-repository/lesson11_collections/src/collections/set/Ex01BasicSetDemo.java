package collections.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex01BasicSetDemo {
	public static void main(String[] args) {
		// List --> ArrayList, LinkedList --> array (dynamic size)
		// get(i)
		
		// Set -> map -> add -> put(e, present(obj)) -> e là key
		// Muốn lấy phần tử trong set thì chỉ có duyệt sau đó if else mà lấy như key của map vậy
//		Set<String> text = new HashSet<>();
//		text.add("a");
//		text.add("b");
//		text.add("c");
		// Kiểm tra hashcode của element này có trùng với phần tử nào đã add trước đó hay không
		// Vì string là immutable
//		text.add("b"); 
		
		Set<String> text = new TreeSet<>(Comparator.reverseOrder());
		text.add("123456789");
		text.add("zzzzabc");
		text.add("abcccc");
		
		text.add(new String("b"));
		
		System.out.println("size: " + text.size());
		printf(text);
	}
	
	private static <E> void printf(Set<E> set) {
		for (E e: set) {
			System.out.println(e);
		}
	}
}
