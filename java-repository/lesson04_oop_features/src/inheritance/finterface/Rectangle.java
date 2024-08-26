package inheritance.finterface;

public class Rectangle implements Shape{

	// Khi class implements interface
	// Bắt buộc phải override các hàm trừu tượng từ interface
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle --> draw...");
	}

	@Override
	public void calS() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle --> cal S...");
	}

}
