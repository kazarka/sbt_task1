package com.sbt.javaschool.sgu_tasks;

import java.util.Scanner;

public class task1_40 {

    public static void main(String[] strings) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String minCycleShiftStr = str;

        for (int i = 0; i < str.length(); ++i) {
            //  Splitting string in two
            String shiftSubstr1 = str.substring(0,i);
            String shiftSubstr2 = str.substring(i);
            //  Concat vice versa
            String resStr = shiftSubstr2.concat(shiftSubstr1);
            //  Comparing strings
            if (resStr.compareTo(minCycleShiftStr) < 0)
                minCycleShiftStr = resStr;
        }

        System.out.println(minCycleShiftStr);

    }

}
