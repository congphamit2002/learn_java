package test;

public class Main {
	 public static void main(String[] args) {
	        try {
	            divide(10, 0);
	        } catch (ArithmeticException e) {
	            System.out.println("Bắt ngoại lệ: " + e.getMessage());
	        }
	    }
	    static void divide(int a, int b) throws ArithmeticException {
	        if (b == 0) {
	            throw new ArithmeticException("Lỗi chia cho 0");
	        }
	        int result = a / b;
	        System.out.println("Kết quả: " + result);
	    }
}
