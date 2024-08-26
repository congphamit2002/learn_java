package working.finding_matching;

import java.util.Arrays;

public class Ex01BasicDemoRewrite {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean hasNumberDivisibleBy10 = Arrays.stream(numbers)
                .anyMatch(number -> number % 10 == 0);
        System.out.println("1. Result = " + hasNumberDivisibleBy10);

        Arrays.stream(numbers)
                .filter(num -> num % 4 == 0)
                .findFirst()
                .ifPresent(e -> System.out.println("2. Result = " + e));

        Arrays.stream(numbers)
                .filter(num -> num % 5 == 0)
                .findAny()
                .ifPresent(e -> System.out.println("3. Result = " + e));

        boolean isAllLessThan100 = Arrays.stream(numbers)
                                        .allMatch(num -> num < 100);
        System.out.println("5. Result = " + isAllLessThan100);

        boolean isNoElementGreaterThan0 = Arrays.stream(numbers).noneMatch(num -> num > 0);
        System.out.println("6. Result = " + isNoElementGreaterThan0);
    }
}
