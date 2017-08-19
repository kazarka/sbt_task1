package com.sbt.javaschool;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1_39 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        //  Finding matching values
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);

        int count = 0;

        //  Counting matching values
        while (matcher.find())
            ++count;

        System.out.println(count);

    }

}
