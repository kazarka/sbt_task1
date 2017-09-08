package com.sbt.javaschool;

import javafx.util.Pair;

public class MyUtils {

    public static <T extends Comparable> Pair<T, T> defineSmallestAndBiggest(T first, T second) {
        return first.compareTo(second) < 0? new Pair<>(first, second): new Pair<>(second, first);
    }

}
