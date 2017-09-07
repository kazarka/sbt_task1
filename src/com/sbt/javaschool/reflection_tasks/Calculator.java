package com.sbt.javaschool.reflection_tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements ICalculator {

    private double firstNumber;
    private double secondNumber;
    private char operation;

    private boolean parse(String expression) {
        Pattern pattern = Pattern.compile("\\s*([0-9]+(?:\\.{1}[0-9]+)*)\\s*([\\+\\-\\*\\/])\\s*([0-9]+(?:\\.{1}[0-9]+)*\\s*)");
        Matcher matcher = pattern.matcher(expression);

        boolean matches = matcher.matches();

        if (! matches)
            return false;
        else {
            firstNumber = Double.parseDouble(matcher.group(1));
            secondNumber = Double.parseDouble(matcher.group(3));
            operation = matcher.group(2).charAt(0);

            return true;
        }
    }

    private double performCalc() {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            default:
                throw new RuntimeException("Unexpected operation. Check your regexp?");
        }
    }

    public double calc(String expression) {

        if (parse(expression))
            return performCalc();
        else
            throw new RuntimeException("Invalid input.");
    }

}
