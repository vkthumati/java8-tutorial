package com.thumati.java8inaction.chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsFromFiles {
    public static void main(String[] args) {

        System.getProperties().keySet().stream().forEach(key -> System.out.println(key +"="+System.getProperty((String)key)));
        System.out.println("==================================================================================================");
        String filePath = System.getProperty("user.dir")+"/src/com/thumati/java8inaction/chap05";
        try(Stream<String> lines = Files.lines(Paths.get(filePath+"/data.txt"), Charset.defaultCharset())){
            long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                                    .distinct()
                                    .count();
            System.out.println("Total No.of words : "+uniqueWords);
        }catch (IOException e){
            System.out.println("Exception : "+e);
        };
    }
}
