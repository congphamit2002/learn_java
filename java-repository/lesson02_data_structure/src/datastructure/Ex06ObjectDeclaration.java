package datastructure;

import bean.Item;

public class Ex06ObjectDeclaration {
	public static void main(String[] args) {
		// Khai báo KDL nguyên thủy
		// Number, itemA: biển, tham chiếu --> luôn nằm ở Stack
		// Giá trị của KNT --> Stack
		int number = 10;
		
		// Khai báo KDL đối tượng --> Default: NULL
		// Item: id, name, price
		// Giá trị lưu trữ ở HEAP
		// ItemA itemA = 1, "Item 1", 100;
		// New Item() --> gọi hàm khởi tạo của class Item
		// Tạo ra một ô nhớ ở HEAP với các thuộc tính mang giá trị mặc định
		
		Item itemA = new Item(101, "Phone", 1000);
		Item itemB = new Item(102, "Bag", 300);
		Item itemC = new Item();
		itemC.itemId = 103;
		itemC.name = "T-shirt";
		itemC.price = 500;
		
		System.out.println("item id: " + itemA.itemId);
		System.out.println("item name: " + itemA.name);
		System.out.println("item price: " + itemA.price);
		
		System.out.println("item id: " + itemB.itemId);
		System.out.println("item name: " + itemB.name);
		System.out.println("item price: " + itemB.price);
		
		System.out.println("item id: " + itemC.itemId);
		System.out.println("item name: " + itemC.name);
		System.out.println("item price: " + itemC.price);
		
		//Mặc định khi in ra biến kiểu đối tượng --> tự động gọi là toString của class Object
		// Vì Object mặc định là class cha của mọi class trong Java
		System.out.println("itemB: " + itemB);
		System.out.println("itemC: " + itemC.toString());
	}
}
