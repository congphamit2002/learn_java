package working.streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bean.Warehouse;
import model.DataModel;

public class Ex04Map_FlatMap {
	public static void main(String[] args) {
		// Khi mình có Stream<Collection<T>> --> Stream<T> ==> using flatMap
		// Stream<T[]> --> Stream<T> --> using flatMap (gộp các phần tử lại với nhau)
		/*
		   new Warehouse(11, "WH-11", 1, List.of(1, 2, 3, 4, 5)),
		   new Warehouse(12, "WH-12", 1, List.of(6, 7, 8, 9, 10)),
		   new Warehouse(21, "WH-21", 2, List.of(11, 12, 13, 14, 15)),
		   new Warehouse(22, "WH-22", 2, List.of(16, 17, 18, 19, 20))
		 */
		
		List<Warehouse> whs = DataModel.getWhs();
		
		// 1. Get name of warehouse in the list 'whs'
		System.out.println("1. Get name of warehouse in the list 'whs' --> ");
		whs.stream()                     // Stream<Warehouse>
		   .map(Warehouse::getName)      // Stream<String>
		   .forEach(System.out::println);
		
		// 2. Count number of stores of wh 11
		System.out.println("2. Count number of stores of wh 11");
		Optional<Warehouse> optWh = whs.stream().filter(wh -> wh.getId() == 11).findFirst();
		// filter: wh11, null --> Null pointer exception
		// Optional<T> {
		// 	  T value; 
		// }
		if (optWh.isPresent()) {
			Warehouse wh = optWh.get();
			System.out.println("Amount of strores: " + wh.getStoreIds().size());
			System.out.println("Optional warehouse value: " + optWh);
		}
		whs.stream()
		   .filter(wh -> wh.getId() == 11)   // Stream<WareHouse>
		   .findFirst()
		   .ifPresent(wh -> System.out.println("Amount of strores: " + wh.getStoreIds().size()));
		
		// 3. Count number of stores of country 2
		// flatMap -> flat trong flatten (biến mảng 2, 3 chiều thành 1 chiều) -> flatMap(i -> i.stream()).collect(Collectors.toList())
		// Dùng flatMap khi ta có một array của array muốn return về array thôi
		// hoặc ta có list của list chỉ muốn return về list thì ta dùng flatMap
		System.out.println("3. Count number of stores of country 2");
		whs.stream()
		   .filter(wh -> wh.getCountryId() == 2)  // Stream<Warehouse>
		   .map(wh -> wh.getStoreIds())           // Stream<List<Integer>>
		   .flatMap(list -> list.stream())        // Stream<Integer> --> 11 -> 20
//		   .count();
		   .collect(Collectors.toList())
		   .forEach(System.out::println);;
		whs.stream()
		   .filter(wh -> wh.getCountryId() == 2)  // Stream<Warehouse>
		   .map(wh -> wh.getStoreIds());		  // Stream<List<Integer>>
		System.out.println("Amount of stores (country 2): " + whs.stream().filter(wh -> wh.getCountryId() == 2)
				.map(wh -> wh.getStoreIds().size()).reduce(0, (s1, s2) -> s1 + s2));
		List<Integer> storeOfCountry2 = whs.stream()
										   .filter(wh -> wh.getCountryId() == 2)
										   .map(wh -> wh.getStoreIds())
										   .flatMap(list -> list.stream())
										   .collect(Collectors.toList());
		System.out.println("Amount --> " + storeOfCountry2.size());
		System.out.println("Amount --> " + storeOfCountry2);
		
		// 4. Count number of stores of each country
		// 1 --> 9
		// 2 --> 10
		// groupBy trả về List
		// toMap trả về value
		System.out.println("4. Count number of stores of each country");
		whs.stream()
		   .collect(Collectors.toMap(
				   Warehouse::getCountryId,
				   wh -> wh.getStoreIds().size(),
				   (v1, v2) -> v1 + v2,
				   LinkedHashMap::new)
				   ).forEach((k, v) -> System.out.println(k + " : " + v));
		whs.stream()
		   .collect(Collectors.toMap(
				   Warehouse::getCountryId,
				   wh -> wh.getStoreIds(),
				   (v1, v2) -> {
						List<Integer> v = new ArrayList<>(v1);
						v.addAll(v2);
						return v;
				   },
				   LinkedHashMap::new))
//		   		  .forEach((k, v) -> System.out.println(k + " : " + v.size()));
		   		  .forEach((k, v) -> System.out.println(k + " : " + v));
	}
}
