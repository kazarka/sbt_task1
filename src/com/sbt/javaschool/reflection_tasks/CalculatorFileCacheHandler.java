package com.sbt.javaschool.reflection_tasks;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorFileCacheHandler implements InvocationHandler {
    private final Object delegate;

    public CalculatorFileCacheHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (! method.getName().equals("calc")) {
            Object result = method.invoke(delegate, args);
            return result;
        }

        //  Getting class info
        Class clazz = delegate.getClass();

        Method parse = clazz.getDeclaredMethod("parse", String.class);
        Method performCalc = clazz.getDeclaredMethod("performCalc");

        Field firstNumber = clazz.getDeclaredField("firstNumber");
        Field secondNumber = clazz.getDeclaredField("secondNumber");
        Field operation = clazz.getDeclaredField("operation");

        //  Performing calculations
        parse.setAccessible(true);
        boolean matches = (Boolean) parse.invoke(delegate, args);
        parse.setAccessible(false);

        if (matches) {

            firstNumber.setAccessible(true);
            firstNumber.set(delegate, 300);
            firstNumber.setAccessible(false);

            secondNumber.setAccessible(true);
            secondNumber.set(delegate, 72);
            secondNumber.setAccessible(false);

            operation.setAccessible(true);
            operation.set(delegate, '-');
            operation.setAccessible(false);

            performCalc.setAccessible(true);
            Object result = performCalc.invoke(delegate);
            performCalc.setAccessible(false);

            return result;
        }
        else
            throw new RuntimeException("Invalid input.");

    }
}
