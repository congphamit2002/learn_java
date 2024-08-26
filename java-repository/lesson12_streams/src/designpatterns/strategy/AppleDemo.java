package designpatterns.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


import model.DataModel;

/**
 * Find green apples
 * Find red apples
 * Find blue apples and heavier than 150g
 * Find apples from VietNam
 *
 * --> boolean behavior(Apple apple) --> strategy method
 * --> implementation will be provided by invoked
 */

/*
* Predicate
* 		T -> boolean
* Consumer
* 		T -> void
* */
public class AppleDemo {
public static void main(String[] args) {
		
		Runnable r = () -> {};
		Callable<String> c1 = () -> "Raul";
		Callable<String> c2 = () -> {return "Raul";};
		Function<Integer, String> f1 = (Integer i) -> {return "Alan " + i;};
	
		// Functional interface => Nên thay thế bằng lambda
//		Consumer<Apple> c1 = new Consumer<Apple>() {
//			@Override
//			public void accept(Apple apple) {
//				// TODO Auto-generated method stub
//				System.out.println(apple);
//			}
//		};
		// Lambda
	// C1
//		Consumer<Apple> c1 = (Apple apple) -> {
//			System.out.println(apple);
//		};
	// C2
//		Consumer<Apple> c1 = apple -> System.out.println(apple);
		
		// Functional interface
		List<Apple> inventory = DataModel.getApples();
		inventory.forEach(apple -> System.out.println(apple));
//		inventory.forEach(c1);
		
		// keyExtractor = a - a.getColor()
		// => keyExtractor = (A a) -> a.getColor()
		// Step 1: (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
		// Step 2: (c1, c2) -> c1.getColor().compareTo(keyExtractor.apply(c2));
		// Step 3: (c1, c2) -> c1.getColor().compareTo(c2.getColor());
		inventory.sort(Comparator.comparing(Apple::getColor));
		inventory.sort(Comparator.comparing(a -> a.getColor()));
		inventory.sort(Comparator.comparing((Apple a) -> a.getColor()));
		
		System.out.println(">>==============<<");
//		Predicate<Apple> pa = new Predicate<Apple>() {
//			
//			@Override
//			public boolean test(Apple apple) {
//				// TODO Auto-generated method stub
//				return "green".equals(apple.getColor());
//			}
//		};
		filter(inventory, apple -> "green".equals(apple.getColor()))
				.forEach(apple -> System.out.println(apple));
		
		filter(inventory, apple -> "VietNam".equals(apple.getOriginal()))
			.forEach(apple -> System.out.println(apple));
	}

//	public static void forEach(List<Apple> inventory, Consumer<Apple> consumer) {
//		for (Apple apple: inventory) {
//			consumer.accept(apple);
//		}
//	}
	
	// predicate là functional interface có sẵn trong java
	// predicate = apple -> "VietNam".equals(apple.getOriginal());
	private static List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
