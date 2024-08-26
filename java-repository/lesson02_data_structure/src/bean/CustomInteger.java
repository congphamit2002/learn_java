package bean;

public class CustomInteger {
    // Instance variable
	public int value; // HEAP: thông tin lưu trữ trên ô nhớ HEAP

	public CustomInteger(int value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
//		return "" + value;
		return "" + this.value;
	}
}
