package com.thumati.corejava.collection;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class CreateTreeMapCustomComparatorExample {
    public static void main(String[] args) {
        // Creating a TreeMap with a Custom comparator (Descending order)
        SortedMap<String, String> fileExtensions = new TreeMap<>(Comparator.reverseOrder());

        /*SortedMap<String, String> fileExtensions = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/

        // Adding new key-value pairs to a TreeMap
        fileExtensions.put("python", ".py");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");

        // Printing the TreeMap (The keys will be sorted based on the supplied comparator)
        System.out.println(fileExtensions);
    }
}
