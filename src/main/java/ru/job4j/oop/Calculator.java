package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperations(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int number = 5;
        Calculator calculator = new Calculator();
        System.out.println(sum(number));
        System.out.println(minus(number));
        System.out.println(calculator.multiply(number));
        System.out.println(calculator.divide(number));
        System.out.println("Sum: " + calculator.sumAllOperations(number));
    }
}
