package working.streamsRewrite;

import data.structure.model.DataModel;
import data.structure.streamsRewrite.Dish;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex02FilterDistinctByKey {
    public static void main(String[] args) {
        List<Dish> menu = DataModel.getDishes();

        // c1
        Map<Integer, Dish> result =  menu.stream()
                .collect(Collectors.toMap(
                        Dish::getCalories,
                        Function.identity(),
                        (v1, v2) -> v1,
                        LinkedHashMap::new)
                );

        result.values().forEach(System.out::println);

        System.out.println("================");

        Set<Integer> set = new HashSet<>();
        menu.stream()
//                .filter(distinctByKey(d -> d.getName()))
                .filter(distinctByKey(Dish::getCategory))
                .forEach(System.out::println);
    }

//    private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
//        Set<R> set = new HashSet<>();
//        return d -> set.add(func.apply(d));
//     }

    private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
        Set<R> set = new HashSet<>();
        return d -> set.add(func.apply(d));
    }
}
