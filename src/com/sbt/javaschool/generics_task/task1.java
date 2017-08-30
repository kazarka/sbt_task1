package com.sbt.javaschool.generics_task;

import java.util.Iterator;

public class task1 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(0);

        linkedList.add(0, 1);

        linkedList.add(5);

        System.out.println(linkedList.remove(1));

        for (Integer value: linkedList) {
            System.out.println(value);
        }

    }

}
