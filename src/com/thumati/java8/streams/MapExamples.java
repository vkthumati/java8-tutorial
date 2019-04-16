package com.thumati.java8.streams;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for(int i=0; i<10; ++i){
            map.putIfAbsent(i, "val"+i);
        }

        map.forEach( (id, val) -> System.out.println(val));

        map.computeIfPresent(3, (k, v)->v+k);
        System.out.println(map.get(3));

        map.computeIfPresent(9, (k,v)->null);
        System.out.println(map.containsKey(9));

        map.computeIfAbsent(23, key->"val"+key);
        System.out.println(map.get(23));
        System.out.println(map.containsKey(23));

        map.computeIfAbsent(3, key->"bam");
        System.out.println(map.get(3));

        map.remove(3, "val3");
        System.out.println(map.get(3));

        map.remove(3, "val33");
        System.out.println(map.get(3));

        System.out.println(map.getOrDefault(42, "not found"));

        map.merge(9, "val9", (value, newValue)-> value.concat(newValue));
        System.out.println(map.get(9));

        map.merge(9, "concat", (value, newValue)-> value.concat(newValue));
        System.out.println(map.get(9));
    }
}
