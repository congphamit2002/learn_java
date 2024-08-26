package sorting.object.type;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class Ex04AvailableSortWithStringRewrite {
	public static void main(String[] args) {
		String[] sequences = {"a1", "c3", "b2", "e5", "d4"};
		
		// 1. Sorting sequences ascending
		Arrays.sort(sequences);
		ArrayUtils.printf("1. sequences asc", sequences);
		
		// 2. Sorting sequences descending
		// Comparator --> sorting asc/desc - handle null/non-null values
		// Comparator#compare(s1, s2)
		// mergeSort --> if (compare(s1, s2) > 0) ==> swap ==> default(asc)
		Arrays.sort(sequences, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				// default 
				// return s1.compareTo(s2); //asc
				
				// c1
				return s2.compareTo(s1);
				// c2
//				return (-1) * s1.compareTo(s2);
			}
		});
		ArrayUtils.printf("2. sequences desc", sequences);
		
		// 3. Sorting sequences ascending and NULL first
		sequences = new String[]{null, "a1", "c3", null, "b2", "e5", "d4" , null};

		Arrays.sort(sequences, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1 == null) {
					return -1;
				}
				if (s2 == null) {
					return 1;
				}
				return s1.compareTo(s2);
			}
		});
		ArrayUtils.printf("3. sequences asc & null first", sequences);
	}
}
