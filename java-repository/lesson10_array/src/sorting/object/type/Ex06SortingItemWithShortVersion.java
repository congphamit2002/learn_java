package sorting.object.type;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.function.Function;

import common.Item;
import utils.ArrayUtils;

public class Ex06SortingItemWithShortVersion {
	public static void main(String[] args) {
		// Arrays.sort(primitive)
		// Arrays.sort(String/Integer/Item) --> sub class of Comparable
		// Arrays.sort(Item[], Comparator<Item>)
		
		// Problem: override Comparable#compareTo(that) --> verbose
		//          override Comparator#compare(c1, c2) --> verbose
		
		Item[] items = getItems();
		
		// 1. SORT items by itemId(ASC) --> o1.getId() - o2.getId()
		// 1. SORT items by name(ASC)   --> 
		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item i1, Item i2) {
				// return i1.getId() - i2.getId();
				return i1.getName().compareTo(i2.getName());
			}
		});
		ArrayUtils.printf("items by name(ASC)", items);
		
		// lambda
		Arrays.sort(items, 
				(i1, i2) -> i1.getName().compareTo(i2.getName())
		);
		ArrayUtils.printf("items by name(ASC)", items);
		
		// Thông thường  --> viết ngắn hơn khi xài lambda
//		Arrays.sort(items, Comparator.comparing(new Function<Item, String>() {
//
//			@Override
//			public String apply(Item item) {
//				// TODO Auto-generated method stub
//				return item.getName();
//			}
//		}));
		
		// functional interface: là interface có duy nhất 1 hàm trừu tượng.
		// T --> Item
		// R --> String(Name)
		// (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))
		// item -> item.getName() ==> Item::getName(method reference)
		// import static java.util.Comparator.*;
		// --> Thì chỉ cần viết comparing(Item::getName)
		// thay vì Comparator.comparing(Item::getName))
		Arrays.sort(items, comparing(Item::getName));
		ArrayUtils.printf("last --> items by name(ASC)", items);
		
		// 4. storeId(asc), price(asc)
		// Arrays.sort(items, comparing(Item::getStoreId).thenComparing(Item::getPrice));
		// 4. storeId(asc), price(desc)
		Arrays.sort(items, comparing(Item::getStoreId).thenComparing(Item::getPrice, reverseOrder()));
		ArrayUtils.printf("4. storeId(asc), price(asc)", items);
		
		items[0] = null;
		items[4] = null;
		// 5. storeId(asc), price(desc), null first/last
		Arrays.sort(items, nullsLast(comparing(Item::getStoreId)
				.thenComparing(Item::getPrice, reverseOrder())));
		ArrayUtils.printf("5. storeId(asc), price(desc), null first", items);
	}

	public static Item[] getItems() {
		return new Item[] { 
				new Item(1, "Item 1", 350, 101),
				new Item(8, "Item 8", 120, 102),
				new Item(2, "Item 2", 450, 101),
				new Item(9, "Item 9", 250, 102),
				new Item(5, "Item 5", 620, 102),
		};
	}
}
