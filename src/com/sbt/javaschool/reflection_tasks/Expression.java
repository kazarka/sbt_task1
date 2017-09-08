package com.sbt.javaschool.reflection_tasks;

import com.sbt.javaschool.MyUtils;
import javafx.util.Pair;

public class Expression {
    private double firstNumber;
    private double secondNumber;
    private char operation;

    public Expression() {
    }

    public Expression(double firstNumber, double secondNumber, char operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public char getOperation() {
        return operation;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public boolean isCommutativeOperation(char operation) {

        return operation == '+' || operation == '*';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null /*|| getClass() != o.getClass()*/) return false;

        Expression that = (Expression) o;

        if (operation != that.operation)
            return false;

        if (isCommutativeOperation(operation)) {
            Pair<Double, Double> smallestAndBiggest =
                    MyUtils.defineSmallestAndBiggest(firstNumber, secondNumber);

            double smallestThis = smallestAndBiggest.getKey();
            double biggestThis = smallestAndBiggest.getValue();

            smallestAndBiggest = MyUtils.defineSmallestAndBiggest(that.firstNumber, that.secondNumber);

            double smallestThat = smallestAndBiggest.getKey();
            double biggestThat = smallestAndBiggest.getValue();

            return Double.compare(smallestThis, smallestThat) == 0 &&
                    Double.compare(biggestThis, biggestThat) == 0;
        }

        return Double.compare(that.firstNumber, firstNumber) == 0 &&
                Double.compare(that.secondNumber, secondNumber) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(firstNumber);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(secondNumber);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) operation;
        return result;
    }
}
