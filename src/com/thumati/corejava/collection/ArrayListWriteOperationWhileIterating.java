package com.thumati.corejava.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWriteOperationWhileIterating {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<10; ++i){
            list.add("Hello"+i);
        }

        /*Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("Vasanth");
        }*/

        for(String s : list) {
            System.out.println(s);
            list.add("Vasanth");
        }

    }
}
