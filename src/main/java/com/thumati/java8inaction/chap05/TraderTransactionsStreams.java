package com.thumati.java8inaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class TraderTransactionsStreams {

    public static List<Transaction> transactions;

    static{
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        /*1 Find all transactions in the year 2011 and sort them by value (small to high).
        2 What are all the unique cities where the traders work?
        3 Find all traders from Cambridge and sort them by name.
        4 Return a string of all traders’ names sorted alphabetically.
        5 Are any traders based in Milan?
        6 Print the values of all transactions from the traders living in Cambridge.
        7 What’s the highest value of all the transactions?
        8 Find the transaction with the smallest value.*/


    }

    public static List<Transaction> findAllTransactionsIn2011SortByValue(){
        return transactions.stream()
                    .filter(transaction -> transaction.getYear()==2011)
                    .sorted(comparing(Transaction::getValue))
                    .collect(toList());
    }

    public static Set<String> findAllUniqueCitiesWhereTradersWork(){
        /*return transactions.stream()
                    .map(transaction -> transaction.getTrader().getCity())
                    .distinct()
                    .collect(toList());*/

        return transactions.stream()
                            .map(Transaction::getTrader)
                            .map(Trader::getCity)
                            .collect(toSet());
    }

    public static List<Trader> findAllTradersFromCambridgeAndSortThemByName(){
        return transactions.stream()
                            .map(Transaction::getTrader)
                            .filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
                            .distinct()
                            .sorted(comparing(Trader::getName))
                            .collect(toList());
    }

    public static String returnStringOfAllTradersNamesSorted(){
        /*return transactions.stream()
                    .map(transaction -> transaction.getTrader().getName())
                    .distinct()
                    .sorted()
                    .reduce("", (n1, n2)-> n1+" "+n2);*/

        return transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .collect(joining());
    }

    public static boolean areAnyTradersBasedInMilan(){
        /*return transactions.stream()
                    .map(Transaction::getTrader)
                    .anyMatch(trader -> "Milan".equalsIgnoreCase(trader.getCity()));*/

        return transactions.stream()
                            .anyMatch(transaction -> transaction.getTrader()
                                                                .getCity().equalsIgnoreCase("Milan"));
    }

    public static void printAllTransactionsValuesFromTheTradersLivingInCambridge(){
        transactions.stream()
                    .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
    }

    public int findMaxTransaction(){
        return transactions.stream()
                    .map(Transaction::getValue)
                    .reduce(Integer::max)
                    .get();
    }

    public Transaction findTransactionWithSmallestValue(){
        transactions.stream()
                .reduce( (t1,t2)->t1.getValue()<t2.getValue()?t1:t2 );

        return transactions.stream()
                            .min(comparing(Transaction::getValue))
                            .get();


    }

}
