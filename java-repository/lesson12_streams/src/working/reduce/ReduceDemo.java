package working.reduce;

import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numberList.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Max: " + numberList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));
    }
}
