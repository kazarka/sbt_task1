package com.sbt.javaschool;

import java.util.Scanner;
import java.util.regex.Pattern;

public class task1_36 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Pattern p = Pattern.compile(".*[eyuioa]{3,}.*");

        for (int i = 1; i <= count; ++i) {
            String str = scanner.nextLine();

            if (!p.matcher(str).matches())
                System.out.println(str);
        }

    }

}
