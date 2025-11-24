package com.collections.functional;

import java.util.function.Supplier;

/*
 * Key Points:
        Syntax: Supplier<T> takes no input and returns a result of type T.
        Method: get() is the core method you implement.
        Use Cases: Ideal for lazy evaluation, providing default values, or acting as a factory.
        No Chaining: Unlike Function or Consumer, Supplier doesn’t have built-in chaining methods since it doesn’t take input.
 */
public class SupplierDemo {
    static Supplier<String> getMessage = ()->"Hello, Supplier!";
    static Supplier<Double> random = ()-> Math.random();

    static void testGetMessage() {
        System.out.println(getMessage.get());
        System.out.println(random.get());
    }

    public static void main(String[] args) {
        testGetMessage();
    }
}
