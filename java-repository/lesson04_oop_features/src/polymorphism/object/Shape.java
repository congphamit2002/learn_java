package polymorphism.object;

public class Shape {
	
	void draw() {
		// optional
		System.out.println("Shape --> draw...");
	}
	
	void calS() {
		// optional
		System.out.println("Shape --> cal S...");
	}
}

// 1. Lớp con (Square, Rectangle) bắt buộc phải override phương thức
// draw, calS từ Shape
// 2. Hàm draw, calS bên trong Shape vô nghĩa nên mong muốn hàm draw,
// calS không có thân hàm
// Lớp con phải override các hàm từ cha
// Hàm trong cha là hàm không có thân hàm
// ==> Cha --> interface