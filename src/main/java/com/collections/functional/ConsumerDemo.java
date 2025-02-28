package com.collections.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.utils.CommonUtils;
import com.utils.Employee;

public class ConsumerDemo {
    
    static Consumer<String> printStr = str -> System.out.println(", "+str);

    static void testComsumer() {
       List<String> list = Arrays.asList("Full"," Name:"," Elizabeth,"," Johnson") ;
       
       for(String s: list) {
           // printStr.accept(s);
       }

       List<String> count = list.stream().peek(printStr).toList();
       System.out.println(count);
    }

    static Consumer<Employee> incrementAge = emp-> emp.setAge(emp.getAge()+10);

    static void incrementAge() {
        List<Employee> list = CommonUtils.getEmployees();
        List<Integer> ages = list.stream().map(Employee::getAge).toList();

        List<Integer> incrAges =  list.stream().peek(incrementAge).map(Employee::getAge).toList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(ages.get(i)+"-> "+incrAges.get(i));
        }

    }


    static Consumer<String> print = str -> System.out.println("Printing: " + str);
    static Consumer<String> log = str -> System.out.println("Logging: " + str);

    static Consumer<String> andThenCompConsumer = log.andThen(print);
    
    static void testAndThenCompConsumer(){
        andThenCompConsumer.accept("just print");
    }

    public static void main(String[] args) {
        testComsumer();
        incrementAge();
        testAndThenCompConsumer();
    }
}
