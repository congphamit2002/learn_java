package inheritance.finterface;

public interface Shape {
	// method: declaration: khai báo
	//       : implementation: thực thi
	// JAVA07 trở về trước: 1 hàm trong interface là không có thân hàm (abstract method)
	// ==> Hàm trừu tượng - abstract method
	void draw();
	void calS();
}

// 1. Lớp con (Square, Rectangle) bắt buộc phải override phương thức
// draw, calS từ Shape
// 2. Hàm draw, calS bên trong Shape vô nghĩa nên mong muốn hàm draw,
// calS không có thân hàm
// Lớp con phải override các hàm từ cha
// Hàm trong cha là hàm không có thân hàm
// ==> Cha --> interface