package com.sbt.javaschool.sgu_tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class task1_21 {

    /**
     *  Finds max elements in array and returns it's indices
     * @param arr Array to analyze
     * @return List of max elements indices of array
     */
    private static List<Integer> getMaxElementsIndices(int[] arr) {
        List<Integer> maxElemIndices = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; ++i) {

            if (arr[i] > max) {
                maxElemIndices.clear();
                max = arr[i];
            }

            if (arr[i] >= max)
                maxElemIndices.add(i);

        }

        return maxElemIndices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Getting data
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        //  Twice dividing max elements
        for (int i = 1; i <= 2; ++i) {

            for (Integer ind : getMaxElementsIndices(arr)) {
                arr[ind] /= 2;
            }

        }

        //  Print result array
        System.out.println(Arrays.toString(arr).replaceAll("[\\[,\\]]", ""));
    }

}
