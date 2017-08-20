package com.sbt.javaschool;

import java.util.Scanner;

public class task1_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < count; ++i) {
            int num = scanner.nextInt();
            //  If even iteration of cycle then +num, else -num
            sum += i % 2 == 0 ? num: -num;
        }

        System.out.println(sum);
    }

}
