package working.streamsRewrite;

import bean.Trader;
import bean.Transaction;
import model.DataModel;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class TransactionApp {
    public static void main(String[] args) {
        List<Trader> traders = DataModel.getTraders();
        List<Transaction> transactions = DataModel.getTransactions();
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("======================================================");
        System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high).");
        transactions.stream().filter((tran) -> tran.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue, Comparator.reverseOrder())).toList().forEach(System.out::println);
//		2. Find all transactions have value greater than 300 and sort them by trader’s city
        System.out.println("======================================================");
        System.out.println("2. Find all transactions have value greater than 300 and sort them by trader’s city");
        transactions.stream().filter((tran) -> tran.getValue() > 300).sorted(Comparator.comparing((tran) -> tran.getTrader().getCity(), Comparator.reverseOrder())).toList().forEach(System.out::println);
//		3. What are all the unique cities where the traders work?
        System.out.println("======================================================");
        System.out.println("3. What are all the unique cities where the traders work?");
//        traders.stream().map(Trader::getCity).distinct().forEach(System.out::println);
        traders.stream().filter(distinctByKey(Trader::getCity)).map(Trader::getCity).forEach(System.out::println);
//		4. Find all traders from Cambridge and sort them by name desc.
        System.out.println("======================================================");
        traders.stream().filter((trader) -> "Cambridge".equals(trader.getCity())).sorted(Comparator.comparing(Trader::getName, Comparator.reverseOrder())).forEach(System.out::println);
//		5. Return a string of all traders’ names sorted alphabetically.
        System.out.println("======================================================");
        System.out.println("5. Return a string of all traders’ names sorted alphabetically.");
        traders.stream().map(Trader::getName).sorted(Comparator.comparing(e -> e)).forEach(System.out::println);
//		6. Are any traders based in Milan?
        System.out.println("======================================================");
        boolean isHaveTrader = traders.stream().anyMatch((trader) -> "Milan".equals(trader.getCity()));
        System.out.println("6. Are any traders based in Milan? ==> " + isHaveTrader);
//		7. Count the number of traders in Milan.
        System.out.println("======================================================");
        System.out.println("7. Count the number of traders in Milan.  ==> " + traders.stream().filter((trader) -> "Milan".equals(trader.getCity())).count());
//		8. Print all transactions’ values from the traders living in Cambridge.
        System.out.println("======================================================");
        System.out.println("8. Print all transactions’ values from the traders living in Cambridge.");
        transactions.stream().filter((trans) -> "Cambridge".equals(trans.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
//		9. What’s the highest value of all the transactions?
        System.out.println("======================================================");
        System.out.println("9. What’s the highest value of all the transactions?");
        transactions.stream().map(Transaction::getValue).max(Comparator.comparing(e -> e)).ifPresent(System.out::println);
//		10. Find the transaction with the smallest value.
        System.out.println("======================================================");
        System.out.println("10. Find the transaction with the smallest value.");
        transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).findFirst().ifPresent(System.out::println);
    }

    private static <T, R> Predicate<T> distinctByKey(Function<T, R> func) {
        Set<R> set = new HashSet<>();
        return t -> set.add(func.apply(t));
    }
}
