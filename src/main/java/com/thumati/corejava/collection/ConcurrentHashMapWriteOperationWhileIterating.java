package com.thumati.corejava.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapWriteOperationWhileIterating {
    public static void main(String[] args) {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>() ;
        for(int i=0; i<10; ++i){
            concurrentMap.put("Hi"+i, "Thumati"+i);
        }

        for(Map.Entry<String, String> entry : concurrentMap.entrySet()){
            System.out.println(entry.getKey()+"=>"+entry.getValue());
            concurrentMap.put("Hello", "Vasanth");
        }
    }
}
