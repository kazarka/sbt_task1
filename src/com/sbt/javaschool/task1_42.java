package com.sbt.javaschool;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class task1_42 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String templateStr = String.format("(?=%s)", scanner.nextLine().replace("?", "[a-z]"));

        Pattern pattern = Pattern.compile(templateStr);
        Matcher matcher = pattern.matcher(str);

        StringJoiner sj = new StringJoiner(" ");

        while (matcher.find())
            sj.add(Integer.toString(matcher.start() + 1));

        System.out.println(sj);
    }

}
