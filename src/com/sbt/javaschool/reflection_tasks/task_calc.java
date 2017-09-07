package com.sbt.javaschool.reflection_tasks;

import java.lang.reflect.Proxy;

public class task_calc {

    public static void main(String[] args) {

        ICalculator calculator = (ICalculator)
                Proxy.newProxyInstance(
                        ClassLoader.getSystemClassLoader(),
                        new Class[]{ICalculator.class},
                        new CalculatorFileCacheHandler(new Calculator())
                );

        double result = calculator.calc("1.0+1.1");

        System.out.println(result);
    }

}
