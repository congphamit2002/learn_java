package working.streams;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.structure.streams.Dish;
import model.DataModel;

public class Ex02FilterDistinctByKey {
	public static void main(String[] args) {
		List<Dish> menu = DataModel.getDishes();

		// Distinct dishes by calories - Key: calories - Value: Dish
//		Map<Integer, Dish> result1 = menu.stream().collect(Collectors.toMap(Dish::getCalories, d -> d, (c1, c2) -> c1, LinkedHashMap::new));
//		System.out.println("result --> " + result1);
		Map<Integer, Dish> result = menu.stream()
				.collect(Collectors.toMap(Dish::getCalories, Function.identity(), (c1, c2) -> c1, LinkedHashMap::new));
		result.values().forEach(System.out::println);// map.values() return Collection of values
		System.out.println("Opt2 -->");
		// Duyệt các phần tử xem có hashCode equals không
		menu.stream() // stream<dish> s1: duyệt từng phần tử trong s1
			.distinct()
			.forEach(System.out::println);
		// stream<dish> s2
		// for(d --> s1) {
		//		s2.add(d); // hashcode(d), equals(d) trong set
		// }
		
		System.out.println("Opt3 -->");
		Set<Integer> set = new HashSet<>();
		// set: 120, 360, 880, 970, 650, 30
		// stream: d1, d2, d3, d5, d6, d7
		// C1
//		menu.stream().filter(d -> {
//			if(set.add(d.getCalories())) {
//				return true;
//			}
//			return false;
//		}).forEach(System.out::println);
		// C2
//		menu.stream().filter(d -> {
//			return set.add(d.getCalories());
//		})
//		.forEach(System.out::println);
//		System.out.println("=============");
		menu.stream().filter(d -> set.add(d.getCalories()))
									 .forEach(System.out::println);
		System.out.println("=============");
//		menu.stream().filter(distinctByKey()).forEach(System.out::println);
//		menu.stream().filter(distinctByKey(d -> d.getName())).forEach(System.out::println);
		menu.stream().filter(distinctByKey(Dish::getCalories)).forEach(System.out::println);
	}
	
//	private static Predicate<Dish> distinctByKey(){
//		Set<Integer> set = new HashSet<>();
//		return d -> set.add(d.getCalories());
//	}

	private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
		Set<R> set = new HashSet<>();
		return d -> set.add(func.apply(d));
	}
}
