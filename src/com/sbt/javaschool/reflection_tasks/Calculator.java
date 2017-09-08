package com.sbt.javaschool.reflection_tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements ICalculator {

    private Expression expression;

    public Calculator() {
        this.expression = new Expression();
    }

    private boolean parse(String expressionString, Expression expression) {
        Pattern pattern = Pattern.compile("\\s*([0-9]+(?:\\.{1}[0-9]+)*)\\s*([\\+\\-\\*\\/])\\s*([0-9]+(?:\\.{1}[0-9]+)*\\s*)");
        Matcher matcher = pattern.matcher(expressionString);

        boolean matches = matcher.matches();

        if (! matches)
            return false;
        else {
            double firstNumber = Double.parseDouble(matcher.group(1));
            double secondNumber = Double.parseDouble(matcher.group(3));
            char operation = matcher.group(2).charAt(0);

            expression.setFirstNumber(firstNumber);
            expression.setSecondNumber(secondNumber);
            expression.setOperation(operation);

            return true;
        }
    }

    private double performCalc(Expression expression) {
        double firstNumber = expression.getFirstNumber();
        double secondNumber = expression.getSecondNumber();
        char operation = expression.getOperation();

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

    public double calc(String expressionString) {

        if (parse(expressionString, this.expression))
            return performCalc(this.expression);
        else
            throw new RuntimeException("Invalid input.");
    }

}
