package com.sbt.javaschool.sgu_tasks;

import java.util.Scanner;
import java.util.StringJoiner;

public class task1_37 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //  Reading data
        String str = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());

        //  Result
        StringJoiner sj = new StringJoiner(",");

        //  Join appropriate strings
        for (String word: str.split(",",-1))
            if (word.length() >= num)
                sj.add(word);

        System.out.println(sj);
    }

}
