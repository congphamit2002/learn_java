package sorting.primitive.type;

import utils.ArrayUtils;

public class Ex01BubbleSortRewrite {
	public static void main(String[] args) {
		int[] digits = { 1, 5, 11, 9, 4, 6 };
		bubbleSort(digits);
		ArrayUtils.printf("digits", digits);
	}
	
	// sorting ascending
	private static void bubbleSort(int[] elements) {
		// ASC
		for (int i = 0; i < elements.length - 1; i++) {
			for (int j = 0; j < elements.length - i - 1; j++) {
				if (elements[j] > elements[j + 1]) {
					int temp = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = temp;
				}
			}
		}
	}
}
