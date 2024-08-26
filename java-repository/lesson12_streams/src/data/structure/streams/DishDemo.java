package data.structure.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.DataModel;

public class DishDemo {
	public static void main(String[] args) {
		List<Dish> menu = DataModel.getDishes();
		
		// 1. Get dishes which have calories > 250
		getDishes(menu, d -> d.getCalories() > 250).forEach(System.out::println);
		System.out.println("===================================================");
		
		// B1. Convert current data structure --> stream
		// List<T> stream() --> Stream()
		// B2. Using streams's methods(API) --> .m1() --> stream<X>
		// --> Builder pattern
		// B3. Convert to another data structure for storing
		// Interview: why we don't store data in stream?
		// Answer: --> 1. Traversable once
		
		List<Dish> dishesWithHighCalories = menu.stream() // Stream<Dish> --> B1
				.filter(d -> d.getCalories() > 250)       // Stream<Dish> --> B2
				.collect(Collectors.toList());            // List<Dish> --> B3
		dishesWithHighCalories.forEach(System.out::println);
		System.out.println("===================================================");

		// 2. Get name of dishes
		getNames(menu, d -> d.getName()).forEach(name -> System.out.print(name + " "));
		System.out.println();
		getNames(menu, Dish::getName).forEach(System.out::println);
		System.out.println("===================================================");
		Set<String> namesOfSetDishes = menu.stream()                      // Stream<Dish>
										   .map(Dish::getName)            // Stream<String>
										   .collect(Collectors.toSet());  // Default: Set<String> --> HashSet 
		namesOfSetDishes.forEach(name -> System.out.print(name + " "));
		System.out.println();
		List<String> namesOfDishes = menu.stream()           // Stream<Dish>
										 .map(Dish::getName) // Stream<String>
										 .collect(Collectors.toList());
		namesOfDishes.forEach(name -> System.out.print(name + " "));
		System.out.println("\n===================================================");
		
		// intermediate, terminal
		
		// 3. Get name of dishes which is vegetarian food
		menu.stream() // Stream<Dish>
			.filter(d -> {
				System.out.println("hello -- halla .....");
				return FoodCategory.VEGETARIAN.equals(d.getCategory());
			})
			.map(Dish::getName)
			.forEach(name -> System.out.print(name + " ")); // void
		System.out.println();
		menu.stream().filter(d -> FoodCategory.VEGETARIAN.equals(d.getCategory()))  // Stream<Dish>
					 .map(Dish::getName)											// Stream<String>
					 .collect(Collectors.toSet())									// Nếu cần lưu trữ lại thì dùng toSet()
					 .forEach(name -> System.out.print(name + " "));                // void
		System.out.println();
		menu.stream().filter(d -> d.getCategory() == FoodCategory.VEGETARIAN).map(Dish::getName)
				.forEach(name -> System.out.print(name + " "));
		System.out.println("\n===================================================");
		
		// 4. Sort a budget map
		// map --> Set<Entry<K, V>> --> List<Entry<K, V>> --> sortByValue -->
		// LinkedHashMap() => Dùng hàm hỗ trợ của Stream
		Map<String, Integer> budget = sort(DataModel.getBudget());
		budget.forEach((k, v) -> System.out.println(k + ", " + v));
		System.out.println("===================================================");
		Map<String, Integer> budget1 = DataModel.getBudget();
		budget1.forEach((k, v) -> System.out.println(k + ", " + v));
		System.out.println("===================================================");
		Map<String, Integer> sortedMap = DataModel.getBudget()
												  .entrySet()
												  .stream() // Stream<Entry<K, V>>
//												  .sorted(Comparator.comparing(e -> e.getValue()))
//												  .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, () -> new LinkedHashMap());
//												  .sorted(Comparator.comparing(Entry::getValue)) 
												  .sorted(Entry.comparingByValue()) // Stream<Entry<K, V>>
												  .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		sortedMap.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	// not use stream --> stream filter
	public static List<Dish> getDishes(List<Dish> menu, Predicate<Dish> predicate) {
		List<Dish> result = new ArrayList<>();
		for (Dish dish : menu) {
//			if (dish.getCalories() > 250) {
//				result.add(dish);
//			}
			if (predicate.test(dish)) {
				result.add(dish);
			}
		}
		return result;
	}

	// not use stream --> stream map
	public static <R> Set<R> getNames(List<Dish> menu, Function<Dish, R> function) {
//		List<String> result = new ArrayList<String>();
		Set<R> result = new LinkedHashSet<>();
		for (Dish dish : menu) {
//			result.add(dish.getName()); // ArrayList
			// dish --> ...
			result.add(function.apply(dish));
		}
		return result;
	}	
	
	public static Map<String, Integer> sort(Map<String, Integer> budget) {
//		Set<Entry<String, Integer>> budgetSet = budget.entrySet();
//		List<Entry<String, Integer>> budgetList = new LinkedList<>(budgetSet);
//		budgetList.sort(Comparator.comparing(e -> e.getValue()));
//		Map<String, Integer> sortedMap = new LinkedHashMap<>();
//		for (Entry<String, Integer> entry : budgetList) {
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}
//		return sortedMap;
		List<Entry<String, Integer>> budgetList = new LinkedList<>(budget.entrySet());
//		budgetList.sort(Comparator.comparing(e -> e.getValue()));
		budgetList.sort(Comparator.comparing(Entry::getValue));
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Entry<String, Integer> entry : budgetList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
