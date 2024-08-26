package manipulation;

import common.Tuple;

import java.util.Arrays;

public class Ex01RewriteCrudApp {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 36, 12, 33};

        int sumOfOddElements = sum(numbers);
        System.out.println("sumOfOddElements: " + sumOfOddElements);

        // Không cần new Tuple vì trong getMinMax đã làm rồi
        Tuple tuple = getMinMax(numbers);
        System.out.println("tuple: " + tuple);

        int[] newAddedArray = add(numbers, 18, 3);
        System.out.println("newAddedArray: " + Arrays.toString(newAddedArray));

        int[] newInsertedArray = insert(newAddedArray, 77, 2);
        System.out.println("newInsertedArray: " + Arrays.toString(newInsertedArray));

        int[] newRemovedArray = remove(numbers, 2);
        System.out.println("newRemovedArray: " + Arrays.toString(newRemovedArray));
    }

    public  static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static Tuple getMinMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        return new Tuple(max, min);
    }

    public static int[] add(int[] numbers, int value, int k) {
        int[] newArray = new int[numbers.length + 1];
        for (int i = 0; i < k; i++) {
            newArray[i] = numbers[i];
        }
        newArray[k] = value;
        for (int i = k + 1; i < newArray.length; i++) {
            newArray[i] = numbers[i-1];
        }
        return newArray;
    }

    public static int[] insert(int[] numbers, int value, int k) {
        int[] newArray = new int[numbers.length + 1];
        for (int i = 0; i < k; i++) {
            newArray[i] = numbers[i];
        }
        for (int i = newArray.length - 1; i > k; i--) {
            newArray[i] = numbers[i - 1];
        }
        newArray[k] = value;
        return newArray;
    }

    public static int[] remove(int[] numbers, int k) {
        for(int i = k; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        return Arrays.copyOfRange(numbers, 0, numbers.length-1);
    }
}
