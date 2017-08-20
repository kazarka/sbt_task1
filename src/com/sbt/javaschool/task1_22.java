package com.sbt.javaschool;

import java.util.Scanner;

public class task1_22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[] arr = new int[count];

        for (int i = 0; i < count; ++i)
            arr[i] = scanner.nextInt();

        int divCount = 0;

        for (int i = 0; i < arr.length; ++i)
            for (int j = 0; j < arr.length; ++j)
                //  If a[i] is divisible by b[j] then count
                if (i != j && arr[i] % arr [j] == 0)
                    ++divCount;

        System.out.println(divCount);

    }

}
