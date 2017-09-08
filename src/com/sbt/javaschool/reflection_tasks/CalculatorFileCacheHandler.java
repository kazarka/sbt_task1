package com.sbt.javaschool.reflection_tasks;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class CalculatorFileCacheHandler implements InvocationHandler {

    private static final String CACHE_FILE_NAME = "cache.txt";

    private final Object delegate;

    public CalculatorFileCacheHandler(Object delegate) {
        this.delegate = delegate;
    }

    ExpressionWithResult parseFileDataFormat(String expression) {
        String[] exprParts = expression.split(";");

        RuntimeException exception = new RuntimeException("File: wrong data format");

        if (    exprParts.length != 4 ||
                exprParts[2].length() != 1 ||
                Arrays.asList('+', '-', '*', '/').indexOf(exprParts[2].charAt(0)) == -1
                )
            throw  exception;

        try {
            double firstNumber = Double.parseDouble(exprParts[0]);
            double secondNumber = Double.parseDouble(exprParts[1]);
            char operation = exprParts[2].charAt(0);
            double result = Double.parseDouble(exprParts[3]);

            return new ExpressionWithResult(firstNumber, secondNumber, result, operation);

        } catch (NumberFormatException numException) {
            exception.initCause(numException);
            throw exception;
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        if (! method.getName().equals("calc")) {
            result = method.invoke(delegate, args);
            return result;
        }

        //  Getting class info
        Class clazz = delegate.getClass();

        Method parse = clazz.getDeclaredMethod("parse", String.class, Expression.class);
        Method performCalc = clazz.getDeclaredMethod("performCalc", Expression.class);

        Field expression = clazz.getDeclaredField("expression");

        expression.setAccessible(true);
        Expression calculatingExpression = (Expression) expression.get(delegate);
        expression.setAccessible(false);

        //  Performing calculations
        parse.setAccessible(true);
        boolean matches = (Boolean) parse.invoke(delegate, args[0], calculatingExpression);
        parse.setAccessible(false);

        if (matches) {

            File file = new File(CACHE_FILE_NAME);

            if (file.exists()) {
                if (file.isDirectory())
                    throw new RuntimeException("Filename is equal to name of existing directory");

                for (String line: Files.readAllLines(file.toPath())) {
                    if (line.isEmpty())
                        continue;

                    ExpressionWithResult expressionWithResult = parseFileDataFormat(line);

                    if (calculatingExpression.equals((Expression) expressionWithResult)) {
                        result = expressionWithResult.getResult();
                        return result;
                    }
                }
            }

            performCalc.setAccessible(true);
            result = performCalc.invoke(delegate, calculatingExpression);
            performCalc.setAccessible(false);

            OpenOption[] options = new OpenOption[] {StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND};
            String resultFileDataFormatString =
                    String.format("%s;%s;%s;%s",
                            calculatingExpression.getFirstNumber(),
                            calculatingExpression.getSecondNumber(),
                            calculatingExpression.getOperation(),
                            result);
            Files.write(file.toPath(), Arrays.asList(resultFileDataFormatString), options);

            return result;
        }
        else
            throw new RuntimeException("Invalid input.");

    }
}
