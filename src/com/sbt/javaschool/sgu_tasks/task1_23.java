//--------------------------
//-----TASK IN PROGRESS-----
//--------------------------


//package com.sbt.javaschool.sgu_tasks;
//
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.StringJoiner;
//
//public class task1_23 {
//
//    //  Read and print array functions are not in separate module
//    //  because of online checker.
//
//    private static void readArray(int[] arr) {
//        Scanner scanner = new Scanner(System.in);
//
//        int count = scanner.nextInt();
//        arr = new int[count];
//
//        for (int i = 0; i < count; ++i)
//            arr[i] = scanner.nextInt();
//    }
//
//    private static void printArray(int[] arr) {
//        StringJoiner sj = new StringJoiner(" ");
//
//        for (int i = 0; i < arr.length; ++i)
//            sj.add(Integer.toString(arr[i]));
//
//        System.out.println(String.format("%d\n%s\n", arr.length, sj.toString()));
//    }
//
//    public static void main(String[] args) {
//
//        int[] a = null;
//        int[] b = null;
//
//        readArray(a);
//        readArray(b);
//
//        printArray(a);
//
//        int[] c = new int[Math.max(a.length, b.length)];
//        int curInd = 0;
//
//        for (int i = 0; i < a.length; ++i)
//            for (int j = 0; j < b.length; ++j)
//                if (a[i] == b[j]) {
//                    c[curInd] = a[i];
//                    ++curInd;
//                }
//
//        c = Arrays.copyOf(c, curInd + 1);
//
//        printArray(c);
//    }
//
//}
