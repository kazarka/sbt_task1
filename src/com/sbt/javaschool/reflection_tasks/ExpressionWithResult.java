package com.sbt.javaschool.reflection_tasks;

public class ExpressionWithResult extends Expression {

    private double result;

    public ExpressionWithResult(double firstNumber, double secondNumber, double result, char operation) {
        super(firstNumber, secondNumber, operation);

        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
