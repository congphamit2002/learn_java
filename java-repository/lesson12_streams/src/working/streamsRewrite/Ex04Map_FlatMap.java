package working.streamsRewrite;

import bean.Warehouse;
import data.structure.model.DataModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex04Map_FlatMap {
    public static void main(String[] args) {
        List<Warehouse> whs = DataModel.getWhs();

        // 1. Get nam of warehouse in the list 'whs'
        whs.stream().map(Warehouse::getName).forEach(System.out::println);
        System.out.println("==========================================");
        // 2. Count number of stores of wh 1
        whs.stream().filter(wh -> wh.getId() == 11)
                        .findFirst().ifPresent(wh -> System.out.println(wh.getStoreIds().size()));
        System.out.println("==========================================");

        // 3. Count number of stores of country 2
        System.out.println("==========================================");
        long count = whs.stream().filter(wh -> wh.getCountryId() == 2)
                .map(Warehouse::getStoreIds)
                .flatMap(List::stream)
                .count();
        System.out.println("Count " + count);

        // 4. Count number of stores of each country
        System.out.println("==========================================");
        whs.stream()
                .collect(Collectors.toMap(Warehouse::getCountryId, (wh) -> wh.getStoreIds().size(), Integer::sum, LinkedHashMap::new))
                .forEach((k, v) -> System.out.println("Key: " + k + " - " + v));
    }
}
