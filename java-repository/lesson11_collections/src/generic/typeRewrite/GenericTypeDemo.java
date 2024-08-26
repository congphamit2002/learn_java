package generic.typeRewrite;

import common.Item;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeDemo {
    public static void main(String[] args) {
//        IList<String> sArray = new JavaListImpl<>();
//        sArray.add("Hello");
//        sArray.add("World");
//        sArray.add("Java");
//        sArray.add("Python");
//        sArray.add("Python");
//        System.out.println("Size of list: " + sArray.size());
//        System.out.println("=============================");
//        sArray.printf();
//        System.out.println("=============================");
//        System.out.println("Index of 5" + sArray.get(4));
//        System.out.println("=============================");
//        sArray.set(4, "A");
//        System.out.println("=============================");

//        List<String> list = new ArrayList<>();
//        list.add("Hello");
//        list.add("World");
//        list.add("Java");
//        list.add("Python");
//        list.forEach(System.out::println);
//        list.remove(1);
//        System.out.println("=============================");
//        list.forEach(System.out::println);
//        System.out.println("=============================");
//        sArray.removeIf((element) -> element.equals("Java"));
//        sArray.forEach(System.out::println);

        IList<Item> iList = new JavaListImpl<>();
        iList.add(new Item(1, "Name1", 123, 123));
        iList.add(new Item(2, "Name2", 123, 123));
        iList.add(new Item(3, "Name3", 123, 123));
        iList.add(new Item(4, "Name4", 123, 123));

//        iList.removeIf((element) -> element.getId() == 1);
//        iList.add(new Item(5, "Name4", 123, 123));
        iList.remove(new Item(3, "Name4", 123, 123));
        System.out.println("This size is " + iList.size());
        iList.forEach(element -> System.out.println(element));
    }
}
