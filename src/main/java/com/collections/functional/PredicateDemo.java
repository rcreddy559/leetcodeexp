package com.collections.functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
   static Predicate<Integer> isPrime = num -> num % 2 ==0;

   static BiPredicate<Integer, Integer> biPredicate = (num1, num2)-> (num1+num2)%2 == 0;
   static BiPredicate<String, String> startsWith = (str, prefix)-> str.startsWith(prefix);

   /*
    * Predicate<T>
    📌 Represents a boolean-valued function of one argument.
    🔹 Method: boolean test(T t)
    */
    static void testIsPrimeNum(int num) {
       boolean resule =  isPrime.test(num);
       System.out.printf("%d is prime number: %b", num, resule);
    }

    /**
         * Key Points:
            Syntax: BiPredicate<T, U> takes two generic types T and U.
            Method: test(T t, U u) is the core method you implement.
            Default Methods: and, or, and negate allow logical combinations.
            Use Cases: Great for validation, filtering, or conditional logic with two inputs.
            Let me know if you’d like more examples or help integrating BiPredicate into a specific scenario!
     */


    /*
     * BiPredicate<T, U>
    📌 Represents a boolean-valued function of two arguments.
    🔹 Method: boolean test(T t, U u)
     */
    private static void testBiPredicate(int num1, int num2) {
        boolean result = biPredicate.test(num1, num2);
        System.out.println("BiPredicate: "+result);
    }

     /*
     * BiPredicate<T, U>
    📌 Represents a boolean-valued function of two arguments.
    🔹 Method: boolean test(T t, U u)
     */
    static void testStartsWith(String str, String prefix) {
        boolean result = startsWith.test(str, prefix);
        System.out.println("Result: "+result);
    }


    public static void main(String[] args) {
        int num = 31;
        int num2 = 41;
        testIsPrimeNum(31);
        testBiPredicate(num, num2);
        testStartsWith("Represents a boolean-valued function", "Represents");
        testStartsWith("Represents a boolean-valued function", "function");
    }
        
}