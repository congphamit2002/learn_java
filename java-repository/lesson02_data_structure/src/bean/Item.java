package bean;

// Class --> Kiểu dữ liệu đối tượng
// Chứa nhiều thông tin bên trong
// Mỗi thông tin mình gọi là một thuộc tính, đặc điểm của class này
public class Item {
	
	// attributes: thuộc tính ~ biến toàn cục
	public int itemId;
	public String name;
	public double price;
	
	// Hàm: [access_modifier] [static] return_type function_name(parameters)
    // Hàm khởi tạo (constructor): [access_modifier] constructor_name(parameters)
	// --> constructor_name = class_name
	/*
	 	public Item(int pId, String pName, double pPrice) {
		itemId = pId;
		name = pName;
		price = pPrice;
	    }
	 */
	public Item() {
		super();
	}
	// this là đại diện cho địa chỉ, ô nhớ hiện tại đang gọi, đang khởi tạo
	public Item(int itemId, String name, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.itemId + ", " + this.name + ", " + this.price;
	}
}
