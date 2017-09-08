package com.sbt.javaschool.reflection_tasks;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorFileCacheHandler implements InvocationHandler {

    private static final String CACHE_FILE_NAME = "cache.txt";

    private final Object delegate;

    public CalculatorFileCacheHandler(Object delegate) {
        this.delegate = delegate;
    }

    Expression parseFileDataFormat(String expression) {
        String[] exprParts = expression.split(";");

        RuntimeException exception = new RuntimeException("File: wrong data format");

        if (    exprParts.length != 3 ||
                exprParts[2].length() != 1 ||
                Arrays.asList('+', '-', '*', '/').indexOf(exprParts[2].charAt(0)) == -1
                )
            throw  exception;

        try {
            double firstNumber = Double.parseDouble(exprParts[0]);
            double secondNumber = Double.parseDouble(exprParts[1]);
            char operation = exprParts[2].charAt(0);

            return new Expression(firstNumber, secondNumber, operation);

        } catch (NumberFormatException numException) {
            exception.initCause(numException);
            throw exception;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (! method.getName().equals("calc")) {
            Object result = method.invoke(delegate, args);
            return result;
        }

        //  Getting class info
        Class clazz = delegate.getClass();

        Method parse = clazz.getDeclaredMethod("parse", String.class, Expression.class);
        Method performCalc = clazz.getDeclaredMethod("performCalc", Expression.class);

        Field expression = clazz.getDeclaredField("expression");

        //  Performing calculations
        parse.setAccessible(true);
        boolean matches = (Boolean) parse.invoke(delegate, args[0], expression.get(delegate));
        parse.setAccessible(false);

        if (matches) {

            File file = new File(CACHE_FILE_NAME);

            if (file.exists() && ! file.isDirectory()) {

            }

            expression.setAccessible(true);
            expression.set(delegate, new Expression(300, 72, '-'));
            expression.setAccessible(false);

            performCalc.setAccessible(true);
            Object result = performCalc.invoke(delegate, expression.get(delegate));
            performCalc.setAccessible(false);

            return result;
        }
        else
            throw new RuntimeException("Invalid input.");

    }
}
