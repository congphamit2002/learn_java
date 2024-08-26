package working.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex01SliceFilterMatching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 4); // create a static list
		
		// 1. Select unique elements --> 1 2 3 4
		numbers.stream()                     // Stream<Integer>
			   .distinct()					 // Stream<Integer> --> // hashCode(), equals() distinct khá giống set
			   .forEach(System.out::print);
		System.out.println();
		numbers.stream().distinct().forEach(number -> System.out.print(number + " "));
		System.out.println();
		
		// 2. Select elements which appear one time in list --> 3 4
		// Map<Number, Count> 
		// 1 -> 1, 1 
		// 2 -> 2, 2 
		// 3 -> 3 
		// 4 -> 4 
		// C1
		Map<Integer, List<Integer>> map = numbers.stream() // Stream<Integer>
				                                 .collect(Collectors.groupingBy(number -> number));
		map.entrySet() // Entry<Integer, List<Integer>>
		   .stream()
		   .filter(e -> e.getValue().size() == 1)
		   .forEach(e -> System.out.print(e.getKey()));
		System.out.println();
		// C2
		// Map<Integer, Long>
		// 1 -> 2
		// 2 -> 2
		// 3 -> 1
		// 4 -> 1
		numbers.stream()
			   .collect(Collectors.groupingBy(number -> number, Collectors.counting())) // Map<Integer, Long>
			   .entrySet()
			   .stream()
			   .filter(e -> e.getValue() == 1)
			   .forEach(e -> System.out.print(e.getKey()));
	}
}
