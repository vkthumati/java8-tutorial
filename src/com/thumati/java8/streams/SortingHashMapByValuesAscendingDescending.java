package com.thumati.java8.streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

//import java.util.

public class SortingHashMapByValuesAscendingDescending {
    public static void main(String[] args) {
        // a Map with string keys and integer values
        Map<String, Integer> budgetMap = new HashMap<>();
        budgetMap.put("clothes", 130);
        budgetMap.put("grocery", 160);
        budgetMap.put("transportation", 110);
        budgetMap.put("utility", 140);
        budgetMap.put("rent", 1250);
        budgetMap.put("miscellneous", 900);

        System.out.println("map before sorting: " + budgetMap);

        Map<String, Integer> sortedBudgetMap = budgetMap.entrySet().
                                                stream().
                                                sorted(comparingByValue()).
                                                collect(toMap(e->e.getKey(), e->e.getValue(), (e1, e2)->e2, LinkedHashMap::new));
        System.out.println("map after sorting: "+sortedBudgetMap);

        // above code can be cleaned a bit by using method reference
        sortedBudgetMap = budgetMap .entrySet() .
                            stream().
                            sorted(comparingByValue()).
                            collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        // now let's sort the map in decreasing order of keys
        sortedBudgetMap = budgetMap.entrySet().
                            stream().
                            sorted(Collections.reverseOrder(comparingByValue())).
                            collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new));

        System.out.println("map after sorting by keys in descending order: " + sortedBudgetMap);
    }
}
