package com.pros;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.utils.CommonUtils;
import com.utils.Employee;

public class StreamsBasic {
    static int[] arr = { 35, 567, 25, 467, 7908, 2435, 3546 };
    static Integer[] arrObj = { 35, 567, 25, 467, 7908, 2435, 3546 };
    static String[] froots = { "Green", "Yellow", "Yellow", "Green", "Orange", "Blood Orange", "Red", "Red", "Green" };

    static List<Employee> employees;

    static {
        employees = CommonUtils.getEmployees();
    }

    static List<List<Integer>> listOfListInts = Arrays.asList(
            Arrays.asList(20, 30, 50),
            Arrays.asList(40, 607, 80));

    static void convertToStream() {
        IntStream arrStream = Arrays.stream(arr);
        arrStream.forEach(System.out::println);

        Stream<Integer> arrObjStream = Stream.of(arrObj);
        arrObjStream.forEach(System.out::println);
    }

    /*
     * Filter
     */
    static void oddOrEvent() {
        int[] odd = Arrays.stream(arr).filter(i -> i % 2 == 0).toArray();
        System.out.println(Arrays.toString(odd));
    }

    /*
     * Map
     */
    static void mapExample() {

        String[] uppder = Stream.of(froots).map(String::toUpperCase).toArray(String[]::new);
        System.out.println(Arrays.toString(uppder));
    }

    /*
     * Reduce
     * Summing Values
     * Calculate the sum of a list of numbers.
     */
    static void reduceExample() {
        Integer sum = Stream.of(arrObj).reduce(0, (a, b) -> a + b);
        System.out.println("Sum:" + sum);

        IntSummaryStatistics summaryStatistics = Stream.of(arrObj)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Sum:" + summaryStatistics.getSum());

        sum = Stream.of(arrObj).reduce(0, Integer::sum);
        System.out.println("Sum:" + sum);

    }

    /*
     * flatMap
     */
    static void flatMapSum() {
        List<List<Integer>> listOfListInts = Arrays.asList(
                Arrays.asList(20, 30, 50),
                Arrays.asList(40, 607, 80));

        Integer sum = listOfListInts.stream()
                .flatMap(Collection::stream)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    /*
     * Sort
     */
    static void sortBylength() {
        System.out.println(Arrays.toString(froots));
        System.out.println("--------");
        List<String> sort1 = Stream.of(froots).sorted().toList();
        System.out.println(sort1);
        System.out.println("--------");
        List<String> sort2 = Stream.of(froots).sorted(Comparator.reverseOrder()).toList();
        System.out.println(sort2);
        System.out.println("--------");
        List<String> sort3 = Stream.of(froots).sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sort3);
    }

    private static void printAlternateElementsOfArray() {
        int[] my_array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        IntStream.range(0, my_array.length).filter(i -> i % 2 == 0).map(i -> my_array[i]).forEach(System.out::println);
    }

    static void toUppderAndJoin() {
        String names = employees.stream()
                .map(emp -> (emp.getFirstName() + ", " + emp.getLastName())
                        .toUpperCase())
                .collect(Collectors.joining(" : "));

        System.out.println(names);
    }

    static void getAllDuplicates() {
        Set<String> uniqueNames = new HashSet<>();
        List<String> list = Stream.of(froots).filter(n -> !uniqueNames.add(n)).toList();
        for (String n : uniqueNames) {
            System.out.printf("%s, ", n);
        }
        System.out.println();
        for (String n : list) {
            System.out.printf("%s, ", n);
        }
        System.out.println();
        String[] distinct = Stream.of(froots).distinct().toArray(String[]::new);
        for (String s : distinct) {
            System.out.printf("%s, ", s);
        }
    }

    /*
     * Joining Strings
     * Concatenate a list of strings with a delimiter.
     */

    static void joiningStrings() {
        List<String> words = Arrays.asList("Hello", "World", "Java");
        String joinWords = words.stream().collect(Collectors.joining(" "));
        System.out.println(joinWords);
    }

    public static void main(String[] args) {
        joiningStrings();
    }
}
