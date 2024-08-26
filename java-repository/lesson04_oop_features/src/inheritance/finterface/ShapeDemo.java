package inheritance.finterface;

public class ShapeDemo {
	public static void main(String[] args) {
		Shape rect = new Rectangle();
		rect.draw();
		rect.calS();
		
		// Shape: interface
		// Anonymous class: Lớp ẩn danh
		Shape shape = new Shape() {
			
			@Override
			public void draw() {
				// TODO Auto-generated method stub
				System.out.println("X --> draw ...");
			}
			
			@Override
			public void calS() {
				// TODO Auto-generated method stub
				System.out.println("X --> calS ...");
			}
		};
		shape.draw();
		shape.calS();
		
		Shape shapeX = new X();
		shapeX.draw();
		shapeX.calS();
	}
}
