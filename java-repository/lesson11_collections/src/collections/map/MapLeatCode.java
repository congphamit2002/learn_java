package collections.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapLeatCode {
    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 3, 4, 5};
        int k = removeDuplicates(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }


    public static boolean isPalindrome(int x) {
        int numberTemp = x;
        int reverseNumber = 0;
        while (x > 0) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        return numberTemp == reverseNumber;
    }


    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        int index = 0;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        while (index < minLength) {
            for (String str : strs) {
                if(str.charAt(index) != strs[0].charAt(index)) {
                    return index > 0 ? strs[0].substring(0, index) : "";
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
