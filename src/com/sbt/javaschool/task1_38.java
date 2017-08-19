package com.sbt.javaschool;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class task1_38 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> appropriateStrings = Arrays.asList(text.split("[^a-zA-Z]"));

        String maxLengthStr = Collections.max(appropriateStrings, Comparator.comparing(String::length));

        System.out.println(maxLengthStr.length());

    }

}
