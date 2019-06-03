package com.thumati.corejava.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapWriteOperationWhileIterating {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<10; ++i){
            map.put("Hello"+i, "Vasanth"+i);
        }

        for(Map.Entry<String, String> entry : map.entrySet() ) {
            System.out.println(entry.getKey()+"=>"+entry.getValue());
            map.put("Hi", "Thumati");
        }

    }
}
