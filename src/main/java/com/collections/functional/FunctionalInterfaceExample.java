package com.collections.functional;

import java.util.function.Consumer;
import java.util.Arrays;

public class FunctionalInterfaceExample {
    public static void main(String... args) {

        // 1. Consumer
       Consumer<String> printSomething = value -> System.out.println(value);
       var list = Arrays.asList("one", "tow", "three");
       printSomething.accept("ravi");
       list.forEach(printSomething);
        // 2. Predicate
        // 3. Function
        // 4. Supplier

    }
}
