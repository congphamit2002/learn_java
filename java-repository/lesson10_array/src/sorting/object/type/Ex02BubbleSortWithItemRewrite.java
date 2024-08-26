package sorting.object.type;

import common.Item;
import common.NullOption;
import utils.ArrayUtils;

public class Ex02BubbleSortWithItemRewrite {
	public static void main(String[] args) {
		Item[] items = getItems();
		ArrayUtils.printf("items", items);
		// sort items by price ascending
		
		System.out.println("====================");
		bubbleSort(items);
		ArrayUtils.printf("sorted items", items);
	}
	
	// bubble sort with default is NULL_FIRST
	private static void bubbleSort(Item[] elements) {
		bubbleSort(elements, NullOption.NULL_FIRST);
	}

	// bubble sort with default is null option
	private static void bubbleSort(Item[] elements, NullOption no) {
		for (int i = 0; i < elements.length - 1; i++) {
			for (int j = 0; j < elements.length - i - 1; j++) {
				Item itemPrev = elements[j];
				Item itemNext = elements[j + 1];
				if (no == NullOption.NULL_FIRST) {
					if (itemPrev == null) {
						continue;
					} else if (itemNext == null) {
						Item temp = elements[j];
						elements[j] = elements[j + 1];
						elements[j + 1] = temp;
					}
				} else if (no == NullOption.NULL_LAST) {
					if (itemPrev == null && itemNext != null) {
						Item temp = elements[j];
						elements[j] = elements[j + 1];
						elements[j + 1] = temp;
					} else if (itemNext == null) {
						continue;
					}
				}
				if (itemPrev.getPrice() > itemNext.getPrice()) {
					Item temp = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = temp;
				}
			}
		}
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
