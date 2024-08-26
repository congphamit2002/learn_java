package datastructure;

import bean.Item;

public class Ex09JavaObjectType {
	public static void main(String[] args) {
		String s = "Hello";
		int a = 5;
		
		// Float, Double, Long, Character
		Integer o1 = new Integer(10);
		String o2 = new String("Hello");
		
		Integer o3 = 99;
		String o4 = "Bye";
		
		// Custom --> Có báo nhiêu field trong 1 object class
		// thì java cũng bắt khởi tạo object bằng từ khóa new
		Item item = new Item(1, "Item 1", 222);
		System.out.println(item);
		System.out.println(s);
		System.out.println(a);
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		System.out.println(o4);
	}
}
