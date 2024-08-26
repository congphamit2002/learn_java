package data.structure.streamsRewrite;

import data.structure.model.DataModel;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DishDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataModel.getDishes();

        // 1. Get dishes which have calories > 250
        getDishes(menu, (dish) -> dish.getCalories() > 250)
                 .forEach(System.out::println);
        System.out.println("=====================================");
        menu.stream()
                .filter(d -> d.getCalories() > 250)
                .map(Dish::getName)
                .toList()
                .forEach(System.out::println);
        System.out.println("====================================");
        menu.stream()
                .filter(d -> FoodCategory.VEGETARIAN.equals(d.getCategory()))
                .map(Dish::getName)
                .toList()
                .forEach(System.out::println);
        System.out.println("====================================");
        Map<String, Integer> budget = model.DataModel.getBudget();
        sort(budget).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("====================================");
        budget.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }

    public static Map<String, Integer> sort(Map<String, Integer> budgets) {
        Set<Map.Entry<String, Integer>> budgetSet = budgets.entrySet();
        List<Map.Entry<String, Integer>> budgetList = new LinkedList<>(budgetSet);
        budgetList.sort(Comparator.comparing(Map.Entry::getValue));
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : budgetList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static List<Dish> getDishes(List<Dish> menu, Predicate<Dish> predicate) {
        List<Dish> result = new ArrayList<>();
        for (Dish disk : menu) {
           if (predicate.test(disk)) {
               result.add(disk);
           }
        }
        return result;
    }
}
