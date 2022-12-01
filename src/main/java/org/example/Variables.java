package org.example;

public class Variables {
    private Variables() {
    }

    public static void printAllVariables() {
        System.out.println("boolean variable: " + true);
        System.out.println("char variable: " + 'A');
        System.out.println("int variable: " + 2);
        System.out.println("long variable: " + 100000000000L);
        System.out.println("float variable: " + 0.001f);
        System.out.println("double variable: " + 0.00000000001);
        System.out.println("String variable: " + "Hello World!");
    }
}
