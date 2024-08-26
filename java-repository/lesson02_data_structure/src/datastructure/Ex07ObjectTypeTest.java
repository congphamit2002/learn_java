package datastructure;

import bean.Item;

public class Ex07ObjectTypeTest {
	
	public static void main(String[] args) {
		Item itemX = new Item(101, "ItemA", 200);
		// Hàm in ra địa chỉ value
		System.out.println("itemX1 hash: " + System.identityHashCode(itemX));
		System.out.println("price: " + itemX.price);
		
		modify(itemX);
		System.out.println("price: " + itemX.price); //200 -> 888
	}
	
	// Java pass by value at stack
	// Toán tử = luôn hoạt động ở stack, gán phải cho trái
	// Item item = itemX;
	// H1
	private static void modify(Item item) {
		System.out.println("item1 hash: " + System.identityHashCode(item));
		item.price = 888;
		item = new Item(202, "Item Y", 555);
		System.out.println("item2 hash: " + System.identityHashCode(item));
		item.price = 999;
	}
}
