package immutable;

public class Ex02Manipulation {
	public static void main(String[] args) {
		String s = "hello all";
		// Tính chiều dài của chuỗi s
		System.out.println("length: " + s.length());
		
		// Nối chuỗi s1 vào chuỗi s
		String s1 = " - 12345";
		System.out.println("Plus: " + (s + s1));
		System.out.println("Concatenate: " + s.concat(s1));
		
		// Lấy một ký tự tại vị trí index(3) trong chuỗi s
		System.out.println("index: " + s.charAt(3));
		
		// Duyệt từng ký tự trong chuỗi
		for(int i = 0; i < s.length(); i++) {
			System.out.println("s" + i + ":" + s.charAt(i));
		}
		
		// Tìm vị trí - chỉ số xuất hiện đầu tiên,
		// cuối cùng của ký tự "l" trong chuỗi s
		System.out.println("Start index of 'l' --> " + s.indexOf("l"));
		System.out.println("Last index of 'l' --> " + s.lastIndexOf("l"));
	}
}
