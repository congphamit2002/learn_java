package operator;
// format code: ctrl + shift + f
public class Ex02BasicTest {
	public static void main(String[] args) {
		int i = 2;
		if (++i > 2 && i++ > 2) {
			i++;
		}
		if (i++ > 4 || ++i > 5) {
			System.out.println(i); //6
		}
		if (i++ < 4 || i++ > 5) {
			System.out.println(i); //8
		}
		
		// i = 8 ==> & | --> AND OR BIT
		// --> Khá như kiểu ngược lại toán tử && và ||
//		if(i++ > 20 && ++i > 5) {
//			System.out.println("I after: " + i);
//		}
//		if(i++ > 20 & ++i > 5) {
//			System.out.println("I after: " + i);
//		}
//		if(i++ > 20 || ++i > 5) {
//			System.out.println("I after: " + i);
//		}
//		if(i++ > 20 | ++i > 5) {
//			System.out.println("I after: " + i);
//		}
//		if(++i > 5 || i++ > 20) {
//			System.out.println("I after: " + i);
//		}
		if(++i > 5 | i++ > 20) {
			System.out.println("I after: " + i);
		}
		System.out.println("I after: " + i);
	}
}
