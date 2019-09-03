package com.thumati.corejava.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class IterateOverLinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> userCityMapping = new LinkedHashMap<>();

        userCityMapping.put("Rajeev", "Bengaluru");
        userCityMapping.put("Chris", "London");
        userCityMapping.put("David", "Paris");
        userCityMapping.put("Jesse", "California");

        System.out.println("=== Iterating over a LinkedHashMap using Java 8 forEach and lambda ===");
        userCityMapping.forEach( (user, city) -> System.out.print(user+"="+city+", "));

        System.out.println("\n\n=== Iterating over the LinkedHashMap's entrySet using Java 8 forEach and lambda ===");
        userCityMapping.entrySet().forEach( entry -> System.out.print(entry.getKey()+"=>"+entry.getValue()+", "));

        System.out.println("\n\n=== Iterating over the entrySet of a LinkedHashMap using iterator() ===");
        Iterator<Entry<String, String>> iterator = userCityMapping.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<String, String> entry = iterator.next();
            System.out.print(entry.getKey()+"=>"+entry.getValue()+", ");
        }

        System.out.println("\n\n=== Iterating over the entrySet of a LinkedHashMap using iterator() and forEachRemaining ===");
        userCityMapping.entrySet().iterator().forEachRemaining(entry-> System.out.print(entry.getKey()+"=>"+entry.getValue()+", "));

    }
}
