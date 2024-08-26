package exception;

// runtime --> extends RuntimeException
// compile --> extends Exception
public class InvalidAgeException extends Exception{
	
	// Serializable trong java tạo ra khái niệm trên nhằm mục đích mã hóa dữ liệu
	// đưa dữ liệu đó về định dạng là byte (ByteStream) không đưa dữ liệu chính xác xuống memory của server
	// Khi ta deploy ứng dụng thì nếu không Serializable thì dữ liệu sẽ được
	// lưu dưới ổ cứng của server đó gây thất thoát thông tin 
	// ==> Sinh ra Serializable để mã hóa dữ liệu, muốn đọc data phải convert
	// --> từ memory --> byteStream --> Object để đọc dữ liệu
	// Muốn mã hóa dữ liệu chỉ cần implements Serializable --> tạo ra serialVersionUID (ngẫu nhiên)
	// serialVersionUID --> key to define object to serialize or de-serialize
	private static final long serialVersionUID = 6368183477036711158L;

	public InvalidAgeException() {
		super("--> InvalidAgeException");
		
	}
	
	public InvalidAgeException(String message) {
		super(message);
	}
}
