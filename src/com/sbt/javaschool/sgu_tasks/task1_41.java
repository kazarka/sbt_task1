package com.sbt.javaschool.sgu_tasks;

import java.util.Scanner;

public class task1_41 {

    private static boolean isPalindrome(String str) {

        int strLength = str.length();

        for (int i = 0; i < strLength - i; ++i)
            if (str.charAt(i) != str.charAt(strLength - 1 - i))
                return false;

        return true;

    }

    public static void main(String[] strings) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); ++i) {
            //  Splitting string in two
            String shiftSubstr1 = str.substring(0,i);
            String shiftSubstr2 = str.substring(i);

            //  Checking both are palindromes
            if (isPalindrome(shiftSubstr1) && isPalindrome(shiftSubstr2)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    }

}
