package working.reduce;

import java.util.List;

public class Ex01ReduceDemo {
	public static void main(String[] args) {
		// Find sum, sub, max, min of all element in list, array
		// int[]
		// List<Integer>
		List<Integer> numberList = List.of(1, 5, 7, 2);

		System.out.println(numberList.stream().reduce(0, (result, number) -> result + number));
		Integer sum = numberList.stream().reduce(0, (result, number) -> result + number);
		System.out.println("sum --> " + sum);
		System.out.println(numberList.stream().reduce(0, Ex01ReduceDemo::sum));
		System.out.println(numberList.stream().reduce(0, Integer::sum)); // hàm có sẵn
		
		Integer max = numberList.stream().reduce(Integer.MIN_VALUE, Ex01ReduceDemo::max);
		System.out.println("max --> " + max);
		System.out.println(numberList.stream().reduce(Integer.MIN_VALUE, (result, number) -> (result > number) ? result : number));
		System.out.println(numberList.stream().reduce(Integer.MIN_VALUE, Integer::max));
		
		// Example: Describe => numberList.stream().reduce(0, accumulator);
		// => numberList.stream().reduce(0, (n1, n2) -> n1 + n2);
		/*
		 T reduce (T identity, BinaryOperator<T> accumulator){
		 	T result = 0;
		 	for(T element : this stream)
		 		result = accumulator.apply(result, element); => result = result + element; 
		 	return result;
		 }
		 * */
		
		/* Original Method
		   T reduce(T identity, BinaryOperator<T> accumulator){
		      T  result = identity;
		 	  for (T element : this stream)
		 		result = accumulator.apply(result, element);
		 	  return result;
		   }
		 */

		// BinaryOperator<T>
		// T apply (T t1, T t2);
	}

	private static Integer sum(Integer x1, Integer x2) {
		return x1 + x2;
	}
	private static Integer max(int a, int b) {
        return a > b ? a : b;
    }
}
