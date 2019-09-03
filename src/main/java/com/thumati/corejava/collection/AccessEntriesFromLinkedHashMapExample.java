package com.thumati.corejava.collection;

import java.util.LinkedHashMap;

public class AccessEntriesFromLinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> consumerIdNameMapping = new LinkedHashMap<>();

        consumerIdNameMapping.put(1001, "Jack");
        consumerIdNameMapping.put(1002, "David");
        consumerIdNameMapping.put(1003, "Steve");
        consumerIdNameMapping.put(1004, "Alice");
        consumerIdNameMapping.put(1005, "Marie");
        consumerIdNameMapping.put(1006, "Lisa");

        System.out.println("ConsumerIdNameMapping : "+consumerIdNameMapping);

        // Check if a key exists in the LinkedHashMap
        Integer id = 1005;
        if(consumerIdNameMapping.containsKey(id)) {
            System.out.println("Found the customer with id " + id + " : " + consumerIdNameMapping.get(id));
        } else {
            System.out.println("Customer with id " + id + " does not exist");
        }

        // Check if a value exists in the LinkedHashMap
        String name = "David";
        if(consumerIdNameMapping.containsValue(name)) {
            System.out.println("A customer named " + name + " exist in the map");
        } else {
            System.out.println("No customer found with name " + name + " in the map");
        }

        // Change the value associated with an existing key
        id = 1004;
        consumerIdNameMapping.put(id, "Bob");
        System.out.println("Changed the name of customer with id " + id + ", New mapping : " + consumerIdNameMapping);

    }
}
