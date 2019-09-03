package com.thumati.corejava.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateOverList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        Iterator<String> iterator = list.iterator();
       /* while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
            if(item.equalsIgnoreCase("B")){
                list.remove("B");
            }
        }*/
        while(iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
            if(item.equalsIgnoreCase("B")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
