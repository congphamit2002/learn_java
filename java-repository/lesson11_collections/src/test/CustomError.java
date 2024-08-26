package test;

public class CustomError extends Error {
    
    public CustomError(String message) {
        super(message);
    }

    // Bạn cũng có thể thêm các hàm khởi tạo khác nếu cần thiết
}
