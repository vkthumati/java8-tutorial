package com.thumati.java8inaction.chap08;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheExample {
    private MessageDigest messageDigest;

    public CacheExample() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private byte[] calculateDigest(String key) {
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }

    private void main(){
        List<String> lines = Arrays.asList(
                " Nel   mezzo del cammin  di nostra  vita ",
                "mi  ritrovai in una  selva oscura",
                " che la  dritta via era   smarrita "
        );

        Map<String, byte[]> dataToHash = new HashMap<>();
        lines.forEach(line -> dataToHash.computeIfAbsent(line, this::calculateDigest));
        dataToHash.forEach( (line, hash) -> System.out.printf("%s -> %s%n", line, new String(hash).chars().map(i -> i & 0xff).mapToObj(String::valueOf).collect(Collectors.joining(", ", "[", "]"))));
    }

    public static void main(String[] args) {
        new CacheExample().main();
    }
}
