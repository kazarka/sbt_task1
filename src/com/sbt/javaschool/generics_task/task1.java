package com.sbt.javaschool.generics_task;

import java.util.HashSet;
import java.util.Set;

public class task1 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(0);

        linkedList.add(0, 1);

        linkedList.add(5);

        System.out.println(linkedList.get(2));

        System.out.println(linkedList.remove(1));

        for (Integer value: linkedList) {
            System.out.print(String.format("%d ", value));
        }
        System.out.println();

        Set<Integer> set = new HashSet<>();
        set.add(7);
        set.add(10);
        set.add(1);
        set.add(5);

        System.out.println(linkedList.addAll(set));

        for (Integer value: linkedList) {
            System.out.print(String.format("%d ", value));
        }
        System.out.println();

        System.out.println(linkedList.copy(set));

        System.out.println(set);
    }

}
