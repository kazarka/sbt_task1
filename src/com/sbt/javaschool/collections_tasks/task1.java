package com.sbt.javaschool.collections_tasks;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {

    public static void main(String[] args) {

        String fileName = "resources/text1.txt";

        if (args.length > 1)
            System.out.println("Must be one argument. It's filename.");
        else if (args.length == 1)
            fileName = args[0];

        try (Scanner scanner = new Scanner(new File(fileName)).useDelimiter("\\Z")) {
            String content = scanner.next();

            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(content.toLowerCase());

            Map<String, Integer> wordsCountMap = new LinkedHashMap<>();

            while (matcher.find()) {
                String word = matcher.group();

                Integer wordCount;
                wordCount = wordsCountMap.getOrDefault(word, 0);
                wordsCountMap.put(word, wordCount + 1);
            }

            //  Print
            System.out.println("=== Original text is: ===");
            System.out.println(content);
            System.out.println("=== Words and count: ====");
            System.out.println(wordsCountMap);
        } catch (IOException ex) {
            System.out.println(String.format("Error: %s", ex.getMessage()));
        }
    }
}
