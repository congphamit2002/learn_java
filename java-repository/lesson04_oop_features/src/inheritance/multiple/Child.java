package inheritance.multiple;

// Kế thừa: 1 class không thể extend từ nhiều class
// Nguyên nhân: Class con khi kế thừa từ class cha thì
// Không bắt buộc override method từ cha
// TH khi các class cha có hàm giống nhau, lúc này con không biết gọi từ 
// class cha nào.
// Trong java không có multiple extend nhưng lại có multiple implements
public class Child extends Dad{
	public static void main(String[] args) {
		Child son = new Child();
		son.cooking();
		son.playSport();
	}
}
