package com.collections.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import com.utils.CommonUtils;
import com.utils.Employee;

public class FunctionDemo {
   /*
    * Function<T, R> in Java, another functional interface from the
    * java.util.function package.
    * A Function represents a function that takes
    * one argument of type T and produces a result of type R.
    * Its core method is apply(T t), which performs the transformation.
    */

   static Function<String, Integer> strLenght = str -> str.length();

   static void testFunction(String str) {
      int length = strLenght.apply(str);
      System.out.printf("String : %s, length: %d \n", str, length);
   }

   static Function<Integer, Integer> addTwo = num -> num + 2;
   static Function<Integer, Integer> multiByThree = num -> num * 3;

   // andThen: Executes the first function, then passes its result to the second.
   static Function<Integer, Integer> andThen = addTwo.andThen(multiByThree);

   static void testAndThen(Integer num) {
      int result = andThen.apply(num);
      System.out.println("andThen: " + result);
   }

   // compose: Executes the second function first, then passes its result to the
   // first.
   static Function<Integer, Integer> compose = addTwo.compose(multiByThree);

   static void testCompose(Integer num) {
      int result = compose.apply(num);
      System.out.println("Compose: " + result);
   }

   static void testtComposeStream() {
      List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,80,90);
      List<Integer> composeList = list.stream().map(compose).toList();
      System.out.println(composeList);
   }

   static Function<Employee, String> getFullName = emp->"Full Name: "+emp.getFirstName()+", "+emp.getLastName();

   static void testGetFullName() {
      List<String> fullNames = CommonUtils.getEmployees().stream().map(getFullName).toList();
      fullNames.forEach(System.out::println);
   }
   public static void main(String[] args) {
      testFunction("Hello, Java functional interaces");
      testAndThen(10);
      testCompose(10);
      testtComposeStream();
      testGetFullName();
   }
}
