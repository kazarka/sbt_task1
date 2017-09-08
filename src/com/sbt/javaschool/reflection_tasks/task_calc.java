package com.sbt.javaschool.reflection_tasks;

import java.lang.reflect.Proxy;
import java.util.Scanner;

public class task_calc {

    private static String INVALID_INPUT_MESSAGE = "Invalid input.";

    public static void main(String[] args) {

        ICalculator calculator = (ICalculator)
                Proxy.newProxyInstance(
                        ClassLoader.getSystemClassLoader(),
                        new Class[]{ICalculator.class},
                        new CalculatorFileCacheHandler(new Calculator())
                );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide with expression. Example: 1+1. Operations: +,-,*,/");
        String input = scanner.nextLine();

        try {

            double result = calculator.calc(input);
            System.out.println(result);
        } catch (RuntimeException exception) {

            if (exception.getMessage().equals(INVALID_INPUT_MESSAGE))
                System.out.println(INVALID_INPUT_MESSAGE);
            else
                throw exception;
        }
    }

}
