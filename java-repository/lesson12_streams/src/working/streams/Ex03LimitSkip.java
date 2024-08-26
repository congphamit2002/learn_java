package working.streams;

import java.util.Arrays;
import java.util.Comparator;

public class Ex03LimitSkip {
	public static void main(String[] args) {
		// Collection(List/Set) --> .stream() --> stream
		// Array --> Arrays.stream(arrayName)

		// Primitive Stream --> IntStream, DoubleStream, LongStream
		// -->> additional --> sum, sub, mul, div, avg
		// Object Stream --> Stream<T>
		// Consumer -> truyền T -> return void
		// IntConsumer -> truyền int -> return void
		
		int[] numbers = { 9, 5, 6, 7, 1, 3, 5, 7 };
//		Integer[] somenumbers = { 9, 5, 6, 7, 1, 3, 5, 7 };
		
		// Find max 3 numbers
		Arrays.stream(numbers)  // IntStream (each element is a primitive value)  != Stream<Integer>
			  .distinct()       // IntStream
			  .boxed()          // Stream<Integer>
			  .sorted(Comparator.reverseOrder())
			  .limit(3)
			  .forEach(System.out::println);
		// IntStream cannot use
	    // sorted(Comparator.)

	}
}