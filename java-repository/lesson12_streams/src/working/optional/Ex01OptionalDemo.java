package working.optional;

import java.util.Optional;

public class Ex01OptionalDemo {
	public static void main(String[] args) {
		Integer nonNullValue = 10;
		Integer nullValue = null;

		// Hiểu cơ bản Optional như một container nằm bên ngoài để bọc element và kiểm tra nó
		Optional.of(nonNullValue).ifPresent(System.out::println); // 10
		Optional.ofNullable(nonNullValue).ifPresent(System.out::println); // 10
		Optional.ofNullable(nullValue).ifPresent(System.out::println);
	}
}
