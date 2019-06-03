package com.thumati.java8.streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.*;

public class SortingHashMapByKeysAscendingDescending {
    public static void main(String[] args) {
        // a Map with string keys and integer values
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println("map before sorting: " + budget);

        Map<String, Integer> sortedMap = budget.entrySet().
                                                stream().
                                                sorted(comparingByKey()).
                                                collect(toMap(e->e.getKey(), e->e.getValue(), (e1, e2)->e2, LinkedHashMap::new));
        System.out.println("map after sorting: "+sortedMap);

        // above code can be cleaned a bit by using method reference
        sortedMap = budget .entrySet() .
                            stream().
                            sorted(comparingByKey()).
                            collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        // now let's sort the map in decreasing order of keys
        sortedMap = budget.entrySet().
                            stream().
                            sorted(Collections.reverseOrder(comparingByKey())).
                            collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new));

        System.out.println("map after sorting by keys in descending order: " + sortedMap);
    }
}
