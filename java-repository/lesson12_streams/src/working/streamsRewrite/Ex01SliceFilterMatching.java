package working.streamsRewrite;

import data.structure.model.DataModel;
import data.structure.streamsRewrite.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex01SliceFilterMatching {
    public static void main(String[] args) {
        List<Dish> menu = DataModel.getDishes();
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 3, 2, 4, 5);

        numbers.stream()
                .filter((e) -> e % 2 > 0)
                .distinct()
                .toList()
                .forEach(System.out::println);
        Map<Integer, List<Integer>> map = numbers.stream()
                                                 .collect(Collectors.groupingBy(number -> number));
        System.out.println("==================================");
        map.entrySet().stream()
                .filter((e) -> e.getValue().size() == 1)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()))
                .forEach((k, v) -> System.out.println(k));
        System.out.println("==================================");
        numbers.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter((e) -> e.getValue() == 1)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
